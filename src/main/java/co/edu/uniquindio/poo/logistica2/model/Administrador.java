package co.edu.uniquindio.poo.logistica2.model;

import java.util.ArrayList;
import java.util.List;

public class Administrador extends Persona {

    private EmpresaLogistica empresaLogistica = EmpresaLogistica.getInstance();
    private double salario;
    private List<Usuario> listUsuarios;
    private List<Repartidor> listRepartidores;
    private List<Envio> listEnvios;
    private List<Ruta> listRutas;
    private List<Ciudad> listCiudades;
    private List<Pedido> listPedidos;


    public Administrador(Builder builder, double salario) {
        super(builder);
        this.salario = builder.salario;
        this.listUsuarios = builder.listUsuarios;
        this.listRepartidores = builder.listRepartidores;
        this.listEnvios = builder.listEnvios;
        this.listRutas = builder.listRutas;
        this.listCiudades = builder.listCiudades;
        this.listPedidos = builder.listPedidos;

    }

    public static class Builder extends Persona.Builder<Builder> {
        private double salario;
        private List<Usuario> listUsuarios = new ArrayList<>();
        private List<Repartidor> listRepartidores = new ArrayList<>();
        private List<Envio> listEnvios = new ArrayList<>();
        private List<Ruta> listRutas = new ArrayList<>();
        private List<Ciudad> listCiudades = new ArrayList<>();
        private List<Pedido> listPedidos = new ArrayList<>();

        @Override
        public Administrador build() {
            return new Administrador(this, salario);
        }

        public Builder salario(double salario) {
            this.salario = salario;
            return this;
        }

        public Builder listUsuarios(List<Usuario> listUsuarios) {
            this.listUsuarios = listUsuarios;
            return this;
        }

        public Builder listRepartidores(List<Repartidor> listRepartidores) {
            this.listRepartidores = listRepartidores;
            return this;
        }

        public Builder listEnvios(List<Envio> listEnvios) {
            this.listEnvios = listEnvios;
            return this;
        }

        public Builder listRutas(List<Ruta> listRutas) {
            this.listRutas = listRutas;
            return this;
        }

        public Builder listCiudades(List<Ciudad> listCiudades) {
            this.listCiudades = listCiudades;
            return this;
        }
        public Builder listPedidos(List<Pedido> listPedidos) {
            this.listPedidos = listPedidos;
            return this;
        }
    }



    public boolean agregarPersona(Persona persona) {
        return empresaLogistica.agregarPersona(persona);

    }

    public boolean agregarEnvio(Envio envio) {
        eliminarPedido(envio);
        return empresaLogistica.agregarEnvio(envio);
    }

    public boolean eliminarPedido(Envio envio) {
        boolean centinela = false;
        List<Pedido> listPedidosEnvio = envio.getListPedidos();
        for(Pedido pedido : listPedidosEnvio){
            for(Pedido pedidoAux : listPedidos){
                if(listPedidos.contains(pedido)){
                    listPedidosEnvio.remove(pedido);
                    centinela = true;
                }
            }
        }
        return centinela;
    }

    public boolean agregarRuta(Ruta ruta) {
        return empresaLogistica.agregarRuta(ruta);
    }

    public boolean agregarCiudad(Ciudad ciudad) {
        return empresaLogistica.agregarCiudad(ciudad);
    }


    public boolean eliminarPersona(String id) {
        return empresaLogistica.eliminarPersona(id);
    }

    public boolean eliminarEnvio(String id) {
        return empresaLogistica.eliminarEnvio(id);
    }

    public boolean eliminarRuta(String id) {
        return empresaLogistica.eliminarRuta(id);
    }

    public boolean eliminarCiudad(String id) {
        return empresaLogistica.eliminarCiudad(id);
    }

    public boolean actualizarPersona(String id, Persona actualizado){
        return empresaLogistica.actualizarPersona(id, actualizado);
    }

    public boolean actualizarEnvio(String id, Envio actualizado){
        return empresaLogistica.actualizarEnvio(id, actualizado);
    }
    public boolean actualizarRuta(String id, Ruta actualizado) {
        return empresaLogistica.actualizarRuta(id,actualizado);
    }

    public boolean actualizarCiudad(String id, Ciudad actualizado) {
        return empresaLogistica.actualizarCiudad(id,actualizado);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    public List<Repartidor> getListRepartidores() {
        return listRepartidores;
    }

    public void setListRepartidores(List<Repartidor> listRepartidores) {
        this.listRepartidores = listRepartidores;
    }

    public List<Envio> getListEnvios() {
        return listEnvios;
    }

    public void setListEnvios(List<Envio> listEnvios) {
        this.listEnvios = listEnvios;
    }

    public List<Ruta> getListRutas() {
        return empresaLogistica.getListRutas();
    }

    public void setListRutas(List<Ruta> listRutas) {
        this.listRutas = listRutas;
    }

    public List<Ciudad> getListCiudades() {
        return empresaLogistica.getListCiudades();
    }

    public void setListCiudades(List<Ciudad> listCiudades) {
        this.listCiudades = listCiudades;
    }

    public EmpresaLogistica getEmpresaLogistica() {
        return empresaLogistica;
    }

    public void setEmpresaLogistica(EmpresaLogistica empresaLogistica) {
        this.empresaLogistica = empresaLogistica;
    }

    public List<Pedido> getListPedidos() {
        return empresaLogistica.getListPedidos();
    }

    public void setListPedidos(List<Pedido> listPedidos) {
        this.listPedidos = listPedidos;
    }
}

