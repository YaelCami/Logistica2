package co.edu.uniquindio.poo.logistica2.model;

public class Persona {
    private String id;
    private String nombre;
    private String correo;
    private String telefono;

    public Persona(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.correo = builder.correo;
        this.telefono = builder.telefono;
    }

    public static class Builder<T extends Builder<T>> {
        private String id;
        private String nombre;
        private String correo;
        private String telefono;

        public T id(String id) {
                this.id = id;
                return (T) this;
        }
        public T nombre(String nombre) {
            this.nombre = nombre;
            return (T) this;
        }
        public T correo(String correo) {
            this.correo = correo;
            return (T) this;
        }
        public T telefono(String telefono) {
            this.telefono = telefono;
            return (T) this;
        }

        public Persona build(){
            return new Persona(this);
        }


    }

    public boolean verificarCorreo(String correo){
        boolean centinela = false;
        if(correo.contains("@")){
            centinela = true;
        }
        return centinela;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo == null || !correo.contains("@")) {
            throw new IllegalArgumentException("El correo debe contener '@'");
        }
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
