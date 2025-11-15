package co.edu.uniquindio.poo.logistica2.model;

import java.util.List;


public class Paquete implements IProducto{
    private String id;
    private double peso;
    private double volumen;
    private List<Producto> listproductos;
    private List<IProducto> hijos;

    public Paquete(Builder builder){
        this.id= builder.id;
        this.peso= builder.peso;
        this.volumen= builder.volumen;
        this.listproductos = builder.listproductos;
        this.hijos= builder.hijos;

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
        public Paquete build(){
            return new Paquete(this);
        }

    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Paquete: " + id);
        for(IProducto hijo : hijos){
            hijo.mostrarDetalles();
        }

    }

    public void agregarIProducto(IProducto hijo){
        hijos.add(hijo);
    }
    public boolean agregarProductos(Producto producto) {
        boolean centinela = false;
        if (!verificarProducto(producto.getId())) {
            listproductos.add(producto);
            centinela = true;

        }

        return centinela;
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

    public boolean eliminarProducto(String id) {
        boolean centinela = false;
        for (Producto p : listproductos) {
            if (p.getId().equals(id)) {
                listproductos.remove(p);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarProducto(String id, Producto actualizado) {
        boolean centinela = false;
        for (Producto p : listproductos) {
            if (p.getId().equals(id)) {
                p.setId(actualizado.getId());
                p.setNombre(actualizado.getNombre());
                p.setMarca(actualizado.getMarca());
                p.setPeso(actualizado.getPeso());
                p.setCantidad(actualizado.getCantidad());
                p.setCategoria(actualizado.getCategoria());
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public Producto buscarProducto(String id) {
        for (Producto p: listproductos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
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


}
