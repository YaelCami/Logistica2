package co.edu.uniquindio.poo.logistica2.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona{
    private List<Direccion> listDirecciones;
    private List<Pago> listPagos;
    private List<Pedido> listPedidos;

    public Usuario(Builder builder){
        super(builder);
        this.listDirecciones = new ArrayList<>();
        this.listPagos = new ArrayList<>();
        this.listPedidos = new ArrayList<>();
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
}
