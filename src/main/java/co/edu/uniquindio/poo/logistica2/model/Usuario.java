package co.edu.uniquindio.poo.logistica2.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona implements IObservador{
    private List<Direccion> listDirecciones;
    private List<Pago> listPagos ;
    private List<Pedido> listPedidos;
    private List<Paquete> listPaquetes;
    private Administrador administrador;
    private EmpresaLogistica empresa = EmpresaLogistica.getInstance();


    /**
     * Constructor que recibe un objeto Builder para inicializar el usuario.
     *
     * @param builder objeto constructor con los valores definidos.
     */
    public Usuario(Builder builder){
        super(builder);
        this.listDirecciones = builder.listDirecciones;
        this.listPagos = builder.listPagos;
        this.listPedidos = builder.listPedidos;
        this.listPaquetes = builder.listPaquetes;
    }
    /**
     * Builder para la creación de objetos {@link Usuario}.
     * Extiende el builder de Persona para incluir listas propias del usuario.
     */
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
    /**
     * Solicita un pedido nuevo y lo registra en el sistema.
     *
     * @param p pedido a solicitar.
     */
    public void solicitarPedido(Pedido p){
        agregarPedido(p);
        p.setEstado("Solicitado:");
        empresa.getListPedidos().add(p);
    }
    /**
     * Permite rastrear un pedido del usuario por su ID.
     *
     * @param id identificador del pedido.
     * @return información detallada del pedido, o un mensaje si no existe.
     */
    public String rastrearPedido(String id) {

        for (Pedido p : listPedidos) {

            if (p.getId().equals(id)) {
                StringBuilder sb = new StringBuilder();
                sb.append("ID Pedido: ").append(p.getId()).append("\n");
                sb.append("Estado actual: ").append(p.getEstado()).append("\n\n");

                sb.append("-------------      USUARIO      ------------\n");
                sb.append("ID Usuario: ").append(p.getUsuario().getId()).append("\n");
                sb.append("Nombre: ").append(p.getUsuario().getNombre()).append("\n\n");

                sb.append("--------------      PAQUETE      -----------\n");
                sb.append("Peso total: ").append(String.format("%.2f kg", p.getPaquete().getPeso())).append("\n");

                sb.append("Dirección destino: ")
                        .append(p.getDestino().getCiudad())
                        .append(" - ")
                        .append(p.getDestino().getCalle())
                        .append("\n\n");

                sb.append("--------------- PRODUCTOS ------------------\n");
                for (Producto prod : p.getPaquete().getListproductos()) {
                    sb.append("• ")
                            .append(prod.getNombre())
                            .append(" | Cant: ").append(prod.getCantidad())
                            .append(" | Peso: ").append(String.format("%.2f kg", prod.getPeso()))
                            .append("\n");
                }

                sb.append("===============================\n");

                return sb.toString();
            }
        }

        return "Pedido no encontrado";
    }

    /**
     * Obtiene los pedidos que coinciden con un estado y una fecha dada.
     *
     * @param estado estado a buscar.
     * @param fecha fecha de creación del pedido.
     * @return lista con los pedidos que cumplen los filtros.
     */
    public List<Pedido> historialEstados(String estado, LocalDate fecha){
        List<Pedido> historialEstados = new ArrayList<>();
        for(Pedido p : listPedidos){
            if(p.getEstado().equalsIgnoreCase(estado) && p.getFechaCreacion().equals(fecha)){
                historialEstados.add(p);
            }
        }
        return historialEstados;
    }
    /**
     * Recibe una notificación del sistema (Observer).
     *
     * @param mensaje mensaje enviado por el sujeto observado.
     */
    @Override
    public void actualizar(String mensaje) {
        System.out.println("🔔 Notificación para "  + ": " + mensaje) ;

    }
    /**
     * Agrega una nueva dirección al usuario si no existe previamente.
     *
     * @param direccion dirección a agregar.
     * @return true si fue agregada, false si ya existía.
     */
    public boolean agregarDireccion(Direccion direccion) {
        boolean centinela = false;
        if (!verificarDireccion(direccion.getId())) {
            listDirecciones.add(direccion);
            centinela = true;

        }
        return centinela;
    }

    /**
     * Agrega un nuevo pago al usuario si no existe previamente.
     */
    public boolean agregarPago(Pago pago) {
        boolean centinela = false;
        if (!verificarPago(pago.getId())) {
            listPagos.add(pago);
            centinela = true;

        }
        return centinela;
    }
    /**
     * Agrega un nuevo pedido si no existe y si la ruta es válida.
     */
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
    /**
     * Agrega un paquete si no existe.
     */
    public boolean agregarPaquete(Paquete paquete) {
        boolean centinela = false;
        if(!verificarPaquete(paquete.getId())) {
            listPaquetes.add(paquete);
            centinela = true;
        }
        return centinela;
    }
    /**
     * Verifica si existe una dirección con el ID especificado dentro de la lista del usuario.
     *
     * @param id ID de la dirección a verificar.
     * @return true si la dirección existe, false en caso contrario.
     */
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
    /**
     * Verifica si existe un pago con el ID especificado dentro de la lista del usuario.
     *
     * @param id ID del pago a verificar.
     * @return true si el pago existe, false en caso contrario.
     */
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
    /**
     * Verifica si existe un pedido con el ID especificado dentro de la lista del usuario.
     *
     * @param id ID del pedido a verificar.
     * @return true si el pedido existe, false en caso contrario.
     */
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
    /**
     * Verifica si existe un paquete con el ID especificado dentro de la lista del usuario.
     *
     * @param id ID del paquete a verificar.
     * @return true si el paquete existe, false en caso contrario.
     */
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
    /**
     * Elimina una dirección del usuario según el ID proporcionado.
     *
     * @param id ID de la dirección a eliminar.
     * @return true si la dirección fue eliminada, false si no se encontró.
     */
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
    /**
     * Elimina un pago del usuario según el ID proporcionado.
     *
     * @param id ID del pago a eliminar.
     * @return true si el pago fue eliminado, false si no se encontró.
     */
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
    /**
     * Elimina un pedido del usuario según el ID proporcionado.
     *
     * @param id ID del pedido a eliminar.
     * @return true si el pedido fue eliminado, false si no se encontró.
     */
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
    /**
     * Elimina un paquete del usuario según el ID proporcionado.
     *
     * @param id ID del paquete a eliminar.
     * @return true si el paquete fue eliminado, false si no se encontró.
     */
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
    /**
     * Actualiza los datos de una dirección existente del usuario.
     *
     * @param id ID de la dirección que se desea actualizar.
     * @param actualizado Objeto Direccion con los nuevos valores.
     * @return true si la dirección fue actualizada, false si no se encontró.
     */
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
    /**
     * Actualiza los datos de un pago existente del usuario.
     *
     * @param id ID del pago que se desea actualizar.
     * @param actualizado Objeto Pago con los nuevos valores.
     * @return true si el pago fue actualizado, false si no se encontró.
     */
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
    /**
     * Actualiza los datos de un pedido existente del usuario.
     *
     * @param id ID del pedido que se desea actualizar.
     * @param actualizado Objeto Pedido con los nuevos valores.
     * @return true si el pedido fue actualizado, false si no se encontró.
     */
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
    /**
     * Actualiza los datos de un paquete existente del usuario.
     *
     * @param id ID del paquete que se desea actualizar.
     * @param actualizado Objeto Paquete con los nuevos valores.
     * @return true si el paquete fue actualizado, false si no se encontró.
     */
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
    /**
     * Busca una dirección del usuario por su ID.
     *
     * @param id ID de la dirección a buscar.
     * @return la dirección encontrada o null si no existe.
     */
    public Direccion buscarDireccion(String id) {
        for (Direccion d: listDirecciones) {
            if (d.getId().equals(id)) {
                return d;
            }
        }
        return null;
    }
    /**
     * Busca un pago del usuario por su ID.
     *
     * @param id ID del pago a buscar.
     * @return el pago encontrado o null si no existe.
     */
    public Pago buscarPago(String id) {
        for (Pago p: listPagos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
    /**
     * Busca un pedido del usuario por su ID.
     *
     * @param id ID del pedido a buscar.
     * @return el pedido encontrado o null si no existe.
     */
    public Pedido buscarPedido(String id) {
        for (Pedido p: listPedidos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
    /**
     * Busca un paquete del usuario por su ID.
     *
     * @param id ID del paquete a buscar.
     * @return el paquete encontrado o null si no existe.
     */
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
