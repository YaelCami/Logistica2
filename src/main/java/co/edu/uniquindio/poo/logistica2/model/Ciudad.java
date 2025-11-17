package co.edu.uniquindio.poo.logistica2.model;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {
    private String id;
    private String nombre;
    private int habitantes;
    private List<Ruta> listRutas;
    private List<Direccion> listDirecciones;

    public Ciudad(String id,  String nombre, int habitantes) {
        this.id = id;
        this.nombre = nombre;
        this.habitantes = habitantes;
        this.listRutas = new ArrayList<>();
        this.listDirecciones = new ArrayList<>();
    }
    public boolean agregarRuta(Ruta ruta) {
        boolean centinela = false;
        if (!verificarRuta(ruta.getId())) {
                listRutas.add(ruta);
                centinela = true;

        }

        return centinela;
    }
    public boolean agregarDireccion(Direccion direccion) {
        boolean centinela = false;

            if (!verificarDireccion(direccion.getId())) {
                listDirecciones.add(direccion);
                centinela = true;

            }

        return centinela;
    }
    public boolean verificarDireccion(String id) {
        boolean centinela = false;
        for (Direccion  d: listDirecciones) {
            if (d.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean verificarRuta(String id) {
        boolean centinela = false;
        for (Ruta r : listRutas) {
            if (r.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean eliminarRuta(String id) {
        boolean centinela = false;
        for (Ruta r: listRutas) {
            if (r.getId().equals(id)) {
                listRutas.remove(r);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean eliminarDireccion(String id) {
        boolean centinela = false;
        for (Direccion d: listDirecciones) {
            if (d.getId().equals(id)) {
                listDirecciones.remove(d);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarRuta(String id, Ruta actualizado) {
        boolean centinela = false;
        for (Ruta r: listRutas) {
            if (r.getId().equals(id)) {
                r.setId(actualizado.getId());
                r.setCiudadOrigen(actualizado.getCiudadOrigen());
                r.setCiudadDestino(actualizado.getCiudadDestino());
                r.setDistancia(actualizado.getDistancia());
                centinela = true;
                break;
            }

        }
        return centinela;
    }
    public boolean actualizarDireccion(String id, Direccion actualizado) {
        boolean centinela = false;
        for (Direccion d:listDirecciones) {
            if (d.getId().equals(id)) {
                d.setId(actualizado.getId());
                d.setAlias(actualizado.getAlias());
                d.setCalle(actualizado.getCalle());
                d.setCiudad(actualizado.getCiudad());
                d.setCoordenadas(actualizado.getCoordenadas());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public Ruta buscarRuta(String id) {
        for (Ruta r: listRutas) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    public Direccion buscarDireccion(String id) {
        for (Direccion d: listDirecciones) {
            if (d.getId().equals(id)) {
                return d;
            }
        }
        return null;
    }


    public List<Direccion> getListDirecciones() {
        return listDirecciones;
    }

    public void setListDirecciones(List<Direccion> listDirecciones) {
        this.listDirecciones = listDirecciones;
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

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    public List<Ruta> getListRutas() {
        return listRutas;
    }

    public void setListRutas(List<Ruta> listRutas) {
        this.listRutas = listRutas;
    }
}
