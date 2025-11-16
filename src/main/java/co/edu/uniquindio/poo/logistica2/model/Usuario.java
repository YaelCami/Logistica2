package co.edu.uniquindio.poo.logistica2.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona implements IObservador{
    private List<Direccion> listDirecciones;
    private List<Pago> listPagos ;
    private List<Pedido> listPedidos;
    private List<Paquete> listPaquetes;
    private Administrador administrador;

    public Usuario(Builder builder){
        super(builder);
        this.listDirecciones = builder.listDirecciones;
        this.listPagos = builder.listPagos;
        this.listPedidos = builder.listPedidos;
        this.listPaquetes = builder.listPaquetes;
    }


    public static class Builder extends Persona.Builder<Builder> {
        private List<Direccion> listDirecciones = new ArrayList<>();
        private List<Pago> listPagos =  new ArrayList<>();
        private List<Pedido> listPedidos = new ArrayList<>();
        private List<Paquete> listPaquetes = new ArrayList<>();

        @Override
        public Usuario build() {
            return new Usuario(this);
        }

        public Builder listDirecciones(List<Direccion> listDirecciones){
            this.listDirecciones = listDirecciones;
            return this;
        }
        public Builder listPagos(List<Pago> listPagos){
            this.listPagos = listPagos;
            return this;
        }
        public  Builder listPedidos(List<Pedido> listPedidos){
            this.listPedidos = listPedidos;
            return this;
        }
        public Builder listPaquetes(List<Paquete> listPaquetes){
            this.listPaquetes = listPaquetes;
            return this;
        }

    }
    public void solicitarPedido(Pedido p){
        agregarPedido(p);
        administrador.getListPedidos().add(p);
    }

    public String rastrearPedido(String id) {
        String rastrear = "";
        for (Pedido p : listPedidos) {
            if (p.getId().equals(id)) {
                rastrear = "El envío está actualmente en estado: " + p.getEnvio().getEstadoEnvio().getNombre();
            }
        }
        return rastrear;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("🔔 Notificación para "  + ": " + mensaje) ;

    }

    public boolean agregarDireccion(Direccion direccion) {
        boolean centinela = false;
        if (!verificarDireccion(direccion.getId())) {
                listDirecciones.add(direccion);
                centinela = true;

        }
        return centinela;
    }


    public boolean agregarPago(Pago pago) {
        boolean centinela = false;
        if (!verificarPago(pago.getId())) {
                listPagos.add(pago);
                centinela = true;

        }
        return centinela;
    }
    public boolean agregarPedido(Pedido pedido) {
        boolean centinela = false;
        if (!verificarPedido(pedido.getId())) {
            if(pedido.puedePedir(pedido.getOrigen(), pedido.getDestino()) != null){
                listPedidos.add(pedido);
                centinela = true;
            } else {
                System.out.println("No se encuentra ruta para esas direcciones");
            }
        }
        return centinela;
    }
    public boolean agregarPaquete(Paquete paquete) {
        boolean centinela = false;
        if(!verificarPaquete(paquete.getId())) {
            listPaquetes.add(paquete);
            centinela = true;
        }
        return centinela;
    }

    public boolean verificarDireccion(String id) {
        boolean centinela = false;
        for (Direccion  d: listDirecciones) {
            if (d.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean verificarPago(String id) {
        boolean centinela = false;
        for (Pago p: listPagos) {
            if (p.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean verificarPedido(String id) {
        boolean centinela = false;
        for (Pedido p: listPedidos) {
            if (p.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean verificarPaquete(String id) {
        boolean centinela = false;
        for (Paquete p: listPaquetes) {
            if (p.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean eliminarDireccion(String id) {
        boolean centinela = false;
        for (Direccion d: listDirecciones) {
            if (d.getId().equals(id)) {
                listDirecciones.remove(d);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean eliminarPago(String id) {
        boolean centinela = false;
        for (Pago p: listPagos) {
            if (p.getId().equals(id)) {
                listPagos.remove(p);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean eliminarPedido(String id) {
        boolean centinela = false;
        for (Pedido p: listPedidos) {
            if (p.getId().equals(id)) {
                listPedidos.remove(p);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean eliminarPaquete(String id) {
        boolean centinela = false;
        for (Paquete p: listPaquetes) {
            if (p.getId().equals(id)) {
                listPaquetes.remove(p);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarDireccion(String id, Direccion actualizado) {
        boolean centinela = false;
        for (Direccion d:listDirecciones) {
            if (d.getId().equals(id)) {
                d.setId(actualizado.getId());
                d.setAlias(actualizado.getAlias());
                d.setCalle(actualizado.getCalle());
                d.setCiudad(actualizado.getCiudad());
                d.setCoordenadas(actualizado.getCoordenadas());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarPago(String id, Pago actualizado) {
        boolean centinela = false;
        for (Pago p: listPagos) {
            if (p.getId().equals(id)) {
                p.setId(actualizado.getId());
                p.setMonto(actualizado.getMonto());
                p.setFecha(actualizado.getFecha());
                p.setPedido(actualizado.getPedido());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarPedido(String id, Pedido actualizado) {
        boolean centinela = false;
        for (Pedido p: listPedidos) {
            if (p.getId().equals(id)) {
                p.setId(actualizado.getId());
                p.setFechaCreacion(actualizado.getFechaCreacion());
                p.setRuta(actualizado.getRuta());
                p.setUsuario(actualizado.getUsuario());
                p.setCosto(actualizado.getCosto());
                p.setFechaEstimadaEntrega(actualizado.getFechaEstimadaEntrega());
                p.setFechaEntrega(actualizado.getFechaEntrega());
                p.setPago(actualizado.getPago());
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean actualizarPaquete(String id, Paquete actualizado) {
        boolean centinela = false;
        for (Paquete p: listPaquetes) {
            if (p.getId().equals(id)) {
                p.setId(actualizado.getId());
                p.setPeso(actualizado.getPeso());
                p.setVolumen(actualizado.getVolumen());
                p.setListproductos(actualizado.getListproductos());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public Direccion buscarDireccion(String id) {
        for (Direccion d: listDirecciones) {
            if (d.getId().equals(id)) {
                return d;
            }
        }
        return null;
    }
    public Pago buscarPago(String id) {
        for (Pago p: listPagos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public Pedido buscarPedido(String id) {
        for (Pedido p: listPedidos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
    public Paquete buscarPaquete(String id) {
        for (Paquete p: listPaquetes) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public List<Direccion> getListDirecciones() {
        return listDirecciones;
    }

    public void setListDirecciones(List<Direccion> listDirecciones) {
        this.listDirecciones = listDirecciones;
    }

    public List<Pago> getListPagos() {
        return listPagos;
    }

    public void setListPagos(List<Pago> listPagos) {
        this.listPagos = listPagos;
    }
    public List<Paquete> getListPaquetes() {
        return listPaquetes;
    }

    public void setListPaquetes(List<Paquete> listPaquetes) {
        this.listPaquetes = listPaquetes;
    }

    public List<Pedido> getListPedidos() {
        return listPedidos;
    }

    public void setListPedidos(List<Pedido> listPedidos) {
        this.listPedidos = listPedidos;
    }
}
