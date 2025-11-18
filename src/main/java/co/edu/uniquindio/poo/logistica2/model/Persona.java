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

    public static class Builder {
        private String id;
        private String nombre;
        private String correo;
        private String telefono;

        public Builder id(String id) {
                this.id = id;
                return this;
        }
        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }
        public Builder correo(String correo) {
            this.correo = correo;
            return this;
        }
        public Builder telefono(String telefono) {
            this.telefono = telefono;
            return this;
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
