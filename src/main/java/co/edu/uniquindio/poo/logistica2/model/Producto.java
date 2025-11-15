package co.edu.uniquindio.poo.logistica2.model;

public class Producto implements IProducto{
    private String id;
    private String nombre;
    private String marca;
    private double peso;
    private int cantidad;
    private Categoria categoria;

    public Producto(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.marca = builder.marca;
        this.peso = builder.peso;
        this.cantidad = builder.cantidad;
        this.categoria = builder.categoria;

    }

    public static class Builder{
        private String id;
        private String nombre;
        private String marca;
        private double peso;
        private int cantidad;
        private Categoria categoria;

        public Builder id(String id){
            this.id= id;
            return this;
        }
        public Builder nombre(String nombre){
            this.nombre = nombre;
            return this;
        }
        public Builder marca(String marca){
            this.marca = marca;
            return this;
        }
        public Builder peso(double peso){
            this.peso = peso;
            return this;
        }
        public Builder cantidad(int cantidad){
            this.cantidad = cantidad;
            return this;
        }
        public Builder categoria(Categoria categoria){
            this.categoria = categoria;
            return this;
        }
        public Producto build(){
            return new Producto(this);
        }
    }

    @Override
    public void mostrarDetalles(){
        System.out.println("Producto: " + nombre);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
