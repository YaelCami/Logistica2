package co.edu.uniquindio.poo.logistica2.model;

public class Producto implements IProducto{
    private String id;
    private String nombre;
    private String marca;
    private double peso;
    private int cantidad;
    private Categoria categoria;


    /**
     * Constructor privado utilizado por el patrón Builder.
     *
     * @param builder Objeto Builder que contiene los datos para crear el producto.
     */
    public Producto(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.marca = builder.marca;
        this.peso = builder.peso;
        this.cantidad = builder.cantidad;
        this.categoria = builder.categoria;

    }
    /**
     * Builder para construir objetos Producto de manera flexible y clara.
     * Permite asignar selectivamente atributos antes de crear la instancia final.
     */
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
        /**
         * Construye el producto con los atributos configurados.
         *
         * @return Nuevo objeto Producto.
         */
        public Producto build(){
            return new Producto(this);
        }
    }
    /**
     * Muestra en consola un detalle simple del producto como parte del patrón Composite.
     * Útil para visualizar jerarquías de paquetes y productos.
     */
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