package co.edu.uniquindio.poo.logistica2.model;

import java.util.List;

public class Paquete implements IProducto{
    private String id;
    private double peso;
    private double volumen;
    private List<Producto> listproductos;
    private List<IProducto> hijos;

    public Paquete(Builder builder){

    }

    public static class Builder{
        private String id;
        private double peso;
        private double volumen;
        private List<Producto> listproductos;
        private List<IProducto> hijos;

        public Builder id(String id){
            this.id = id;
            return this;
        }
        public Builder peso(double peso){
            this.peso = peso;
            return this;
        }
        public Builder volumen(double volumen){
            this.volumen = volumen;
            return this;
        }
        public Builder listproductos(List<Producto> listproductos){
            this.listproductos = listproductos;
            return this;
        }
        public Builder hijos(List<IProducto> hijos){
            this.hijos = hijos;
            return this;
        }

        public Builder agregarProductos(Producto producto){
            this.listproductos.add(producto);
            return this;
        }
        public Builder agregarHijos(IProducto hijo){
            this.hijos.add(hijo);
            return this;
        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public List<Producto> getListproductos() {
        return listproductos;
    }

    public void setListproductos(List<Producto> listproductos) {
        this.listproductos = listproductos;
    }

    public List<IProducto> getHijos() {
        return hijos;
    }

    public void setHijos(List<IProducto> hijos) {
        this.hijos = hijos;
    }

    public boolean verificarProducto(String id) {
        boolean centinela = false;
        for (Producto p : listproductos) {
            if (p.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }
}
