package co.edu.uniquindio.poo.logistica2.model;

import java.util.ArrayList;
import java.util.List;

public class Administrador extends Persona {

    private EmpresaLogistica empresaLogistica;
    private double salario;
    private List<Usuario> listUsuarios;
    private List<Repartidor> listRepartidores;
    private List<Envio> listEnvios;
    private List<Ruta> listRutas;
    private List<Ciudad> listCiudades;

    public Administrador(Builder builder, double salario) {
        super(builder);
        this.salario = builder.salario;
        this.listUsuarios = builder.listUsuarios;
        this.listRepartidores = builder.listRepartidores;
        this.listEnvios = builder.listEnvios;
        this.listRutas = builder.listRutas;
        this.listCiudades = builder.listCiudades;

    }

    public static class Builder extends Persona.Builder {
        private double salario;
        private List<Usuario> listUsuarios = new ArrayList<>();
        private List<Repartidor> listRepartidores = new ArrayList<>();
        private List<Envio> listEnvios = new ArrayList<>();
        private List<Ruta> listRutas = new ArrayList<>();
        private List<Ciudad> listCiudades = new ArrayList<>();

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
    }


    public boolean agregarPersona(Persona persona) {
        return empresaLogistica.agregarPersona(persona);

    }

    public boolean agregarEnvio(Envio envio) {
        return empresaLogistica.agregarEnvio(envio);
    }

    public boolean agregarRuta(Ruta ruta) {
        boolean centinela = false;
        for (Ruta r : listRutas) {
            if (!verificarRuta(r.getId())) {
                listRutas.add(r);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean agregarCiudad(Ciudad ciudad) {
        boolean centinela = false;
        for (Ciudad c : listCiudades) {
            if (!verificarCiudad(c.getId())) {
                listCiudades.add(c);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarRuta(String id) {
        boolean centinela = false;
        for (Ruta ruta : listRutas) {
            if (ruta.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarCiudad(String id) {
        boolean centinela = false;
        for (Ciudad c : listCiudades) {
            if (c.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean eliminarPersona(String id) {
        return empresaLogistica.eliminarPersona(id);
    }

    public boolean eliminarEnvio(String id) {
        return empresaLogistica.eliminarEnvio(id);
    }

    public boolean eliminarRuta(String id) {
        boolean centinela = false;
        for (Ruta ruta : listRutas) {
            if (ruta.getId().equals(id)) {
                listRutas.remove(ruta);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean eliminarCiudad(String id) {
        boolean centinela = false;
        for (Ciudad c : listCiudades) {
            if (c.getId().equals(id)) {
                listCiudades.remove(c);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarPersona(String id, Persona actualizado){
        return empresaLogistica.actualizarPersona(id, actualizado);
    }

    public boolean actualizarEnvio(String id, Envio actualizado){
        return empresaLogistica.actualizarEnvio(id, actualizado);
    }
    public boolean actualizarRuta(String id, Ruta actualizado) {
        boolean centinela = false;
        for (Ruta ruta : listRutas) {
            if (ruta.getId().equals(id)) {
                ruta.setId(actualizado.getId());
                ruta.setCiudadOrigen(actualizado.getCiudadOrigen());
                ruta.setCiudadDestino(actualizado.getCiudadDestino());
                ruta.setDistancia(actualizado.getDistancia());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarCiudad(String id, Ciudad actualizado) {
        boolean centinela = false;
        for (Ciudad c: listCiudades) {
            if (c.getId().equals(id)) {
                c.setId(actualizado.getId());
                c.setNombre(actualizado.getNombre());
                c.setHabitantes(actualizado.getHabitantes());
                centinela = true;
                break;
            }
        }
        return  centinela;
    }

    public Ruta buscarRuta(String id) {
        for (Ruta r: listRutas) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    public Ciudad buscarCiudad(String id) {
        for (Ciudad c: listCiudades) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
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
        return listRutas;
    }

    public void setListRutas(List<Ruta> listRutas) {
        this.listRutas = listRutas;
    }
}
