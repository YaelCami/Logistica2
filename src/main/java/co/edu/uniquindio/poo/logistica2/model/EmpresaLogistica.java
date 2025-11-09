package co.edu.uniquindio.poo.logistica2.model;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public final class EmpresaLogistica {
    private String nombre;
    private String eslogan;
    private List<Repartidor> listRepartidores = new ArrayList<>();
    private List<Administrador> listAdministradores= new ArrayList<>();
    private List<Usuario> listUsuarios = new ArrayList<>();
    private List<Envio> listEnvios =  new ArrayList<>();
    private List<Persona> listPersonas = new ArrayList<>();
    private static EmpresaLogistica instance;

    private EmpresaLogistica(String nombre, String eslogan) {
        this.nombre = nombre;
        this.eslogan = eslogan;

    }

    public static EmpresaLogistica getInstance() {
        if (instance == null) {
            instance = new EmpresaLogistica("Servientrega" , "Super rápidos");
        }
        return instance;
    }

    public boolean agregarPersona(Persona persona) {
        boolean centinela = false;
        if (!verificarPersona(persona.getId())){
            if (persona instanceof Usuario) {
                listUsuarios.add((Usuario) persona);
                listPersonas.add(persona);
                centinela = true;
            }
            if (persona instanceof Administrador) {
                listAdministradores.add((Administrador) persona);
                listPersonas.add(persona);
                centinela = true;
            }
            if (persona instanceof Repartidor) {
                listRepartidores.add((Repartidor) persona);
                listPersonas.add(persona);
                centinela = true;
            }
        }
        return centinela;
    }

    public boolean agregarEnvio(Envio envio) {
        boolean centinela = false;
        for (Envio e : listEnvios) {
            if (!verificarEnvio(e.getId())) {
                listEnvios.add(e);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean verificarPersona(String id) {
        boolean centinela = false;
        for (Administrador a : listAdministradores) {
            if (a.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        for (Repartidor r : listRepartidores) {
            if (r.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        for (Usuario u : listUsuarios) {
            if (u.getId().equals(id)) {
                centinela = true;
            }
        }
        return centinela;
    }
    public boolean verificarEnvio(String id) {
        boolean centinela = false;
        for (Envio e : listEnvios) {
            if (e.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean eliminarPersona(String id) {
        boolean centinela = false;
        for (Usuario u : listUsuarios) {
            if (u.getId().equals(id)) {
                listUsuarios.remove(u);
                listPersonas.remove(u);
                centinela = true;
                break;
            }
        }
        for (Administrador a : listAdministradores) {
            if (a.getId().equals(id)) {
                listAdministradores.remove(a);
                listPersonas.remove(a);
                centinela = true;
                break;
            }
        }
        for (Repartidor r : listRepartidores) {
            if (r.getId().equals(id)) {
                listRepartidores.remove(r);
                listPersonas.remove(r);
                centinela = true;
            }
        }
        return centinela;
    }

    public boolean eliminarEnvio(String id) {
        boolean centinela = false;
        for (Envio e : listEnvios) {
            if (e.getId().equals(id)) {
                listEnvios.remove(e);
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean actualizarPersona(String id, Persona actualizado) {
        boolean centinela = false;
        for (Usuario u : listUsuarios) {
            if (u.getId().equals(id)) {
                u.setNombre(actualizado.getNombre());
                u.setCorreo(actualizado.getCorreo());
                u.setTelefono(actualizado.getTelefono());

                centinela = true;
                break;
            }
        }
        for (Administrador a : listAdministradores) {
            if (a.getId().equals(id)) {
                a.setNombre(actualizado.getNombre());
                a.setCorreo(actualizado.getCorreo());
                a.setTelefono(actualizado.getTelefono());

                break;
            }
        }
        for (Repartidor r : listRepartidores) {
            if (r.getId().equals(id)) {
                r.setNombre(actualizado.getNombre());
                r.setCorreo(actualizado.getCorreo());
                r.setTelefono(actualizado.getTelefono());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarEnvio(String id, Envio actualizado) {
        boolean centinela = false;
        for (Envio e:  listEnvios) {
            if (e.getId().equals(id)) {
                e.setFechaInicio(actualizado.getFechaInicio());
                e.setFechaEstimadaEntrega(actualizado.getFechaEstimadaEntrega());
                e.setFechaEntrega(actualizado.getFechaEntrega());
                e.setCosto(actualizado.getCosto());
                e.setEstado(actualizado.getEstado());
                e.setRuta(actualizado.getRuta());
                e.setRepartidor(actualizado.getRepartidor());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public Persona buscarPersona(String id) {
        for (Usuario u : listUsuarios) {
            if (u.getId().equalsIgnoreCase(id)) {
                return u;
            }
        }
        for (Administrador a : listAdministradores) {
            if (a.getId().equalsIgnoreCase(id)) {
                return a;
            }
        }for (Repartidor r : listRepartidores) {
            if (r.getId().equalsIgnoreCase(id)) {
                return r;
            }
        }
        return null;
    }

    public Envio buscarEnvio(String id) {
        for (Envio e: listEnvios) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }






    public List<Repartidor> getListRepartidores() {
        return listRepartidores;
    }

    public void setListRepartidores(List<Repartidor> listRepartidores) {
        this.listRepartidores = listRepartidores;
    }

    public List<Administrador> getListAdministradores() {
        return listAdministradores;
    }

    public void setListAdministradores(List<Administrador> listAdministradores) {
        this.listAdministradores = listAdministradores;
    }

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    public List<Envio> getListEnvios() {
        return listEnvios;
    }

    public void setListEnvios(List<Envio> listEnvios) {
        this.listEnvios = listEnvios;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEslogan() {
        return eslogan;
    }

    public void setEslogan(String eslogan) {
        this.eslogan = eslogan;
    }
}
