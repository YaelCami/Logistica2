package co.edu.uniquindio.poo.logistica2.model;

import java.util.ArrayList;
import java.util.List;

public class Paquete implements IProducto{
    private String id;
    private double peso;
    private double volumen;
    private List<Producto> listproductos;
    private List<IProducto> hijos;

    /**
     * Constructor privado que recibe un Builder} para crear el paquete.
     *
     * @param builder Objeto constructor que contiene los valores iniciales.
     */
    public Paquete(Builder builder){
        this.id= builder.id;
        this.peso= builder.peso;
        this.volumen= builder.volumen;
        this.listproductos = builder.listproductos;
        this.hijos= builder.hijos;

    }
    /**
     * Builder para crear objetos  Paquete} de manera flexible.
     */
    public static class Builder{
        private String id;
        private double peso;
        private double volumen;
        private List<Producto> listproductos = new ArrayList<>();
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
    /**
     * Muestra los detalles del paquete y de todos sus hijos (Composite).
     * Cada hijo también imprime sus propios detalles.
     */

    @Override
    public void mostrarDetalles() {
        System.out.println("Paquete: " + id);
        for(IProducto hijo : hijos){
            hijo.mostrarDetalles();
        }

    }
    /**
     * Agrega un componente hijo al paquete (Composite).
     *
     * @param hijo Producto o subpaquete a agregar.
     */
    public void agregarIProducto(IProducto hijo){
        hijos.add(hijo);
    }
    /**
     * Agrega un producto a la lista de productos internos si no existe otro
     * producto con el mismo ID.
     *
     * @param producto Producto a agregar.
     * @return true si se agregó correctamente, false si ya existe un producto con ese ID.
     */
    public boolean agregarProductos(Producto producto) {
        boolean centinela = false;
        if (!verificarProducto(producto.getId())) {
                listproductos.add(producto);
                centinela = true;
        }

        return centinela;
    }
    /**
     * Verifica si existe un producto con el ID indicado dentro del paquete.
     *
     * @param id Identificador del producto a buscar.
     * @return true si el producto existe, false en caso contrario.
     */

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
    /**
            * Elimina un producto dentro del paquete según su ID.
     *
             * @param id Identificador del producto a eliminar.
            * @return true si se eliminó correctamente, false si no se encontró.
            */
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
    /**
     * Actualiza los datos de un producto existente dentro del paquete.
     *
     * @param id ID del producto a actualizar.
     * @param actualizado Objeto con los nuevos valores.
     * @return true si se actualizó correctamente, false si no se encontró.
     */
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
    /**
     * Busca un producto dentro del paquete según su ID.
     *
     * @param id Identificador del producto.
     * @return El producto encontrado o null si no existe.
     */
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