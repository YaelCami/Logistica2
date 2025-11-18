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
    private List<Ciudad> listCiudades = new ArrayList<>();
    private List<Ruta> listRutas = new ArrayList<>();
    private List<Pedido> listPedidos = new ArrayList<>();
    /** Instancia única del patrón Singleton. */
    private static EmpresaLogistica instance;

    /**
     * Constructor privado para cumplir el patrón Singleton.
     *
     * @param nombre  nombre de la empresa
     * @param eslogan eslogan de la empresa
     */
    private EmpresaLogistica(String nombre, String eslogan) {
        this.nombre = nombre;
        this.eslogan = eslogan;

    }
    /**
     * Devuelve la única instancia disponible de la empresa.
     *
     * @return instancia única de EmpresaLogistica
     */
    public static EmpresaLogistica getInstance() {
        if (instance == null) {
            instance = new EmpresaLogistica("Servientrega" , "Super rápidos");
        }
        return instance;
    }
    /**
     * Agrega una persona al sistema si no existe previamente.
     * Clasifica automáticamente entre Usuario, Administrador o Repartidor.
     *
     * @param persona nueva persona a registrar
     * @return true si se agregó correctamente, false si ya existía
     */
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
    /**
     * Agrega un envío si no existe otro con el mismo ID.
     */
    public boolean agregarEnvio(Envio envio) {
        boolean centinela = false;
        if (!verificarEnvio(envio.getId())) {
            listEnvios.add(envio);
            centinela = true;

        }

        return centinela;
    }
    /**
     * Agrega una nueva ruta si no existe otra con el mismo ID.
     *
     * @param ruta objeto Ruta a agregar
     * @return true si la ruta fue agregada correctamente; false si ya existe una ruta con el mismo ID
     */
    public boolean agregarRuta(Ruta ruta) {
        boolean centinela = false;
        if (!verificarRuta(ruta.getId())) {
            listRutas.add(ruta);
            centinela = true;
        }
        return centinela;
    }
    /**
     * Agrega una nueva ciudad si no existe otra con el mismo ID.
     *
     * @param ciudad objeto Ciudad a agregar
     * @return true si la ciudad fue agregada correctamente; false si ya existe una ciudad con el mismo ID
     */
    public boolean agregarCiudad(Ciudad ciudad) {
        boolean centinela = false;
        if (!verificarCiudad(ciudad.getId())) {
            listCiudades.add(ciudad);
            centinela = true;
        }
        return centinela;
    }
    /**
     * Verifica si una persona con el ID proporcionado ya está registrada.
     *
     * @param id identificador a verificar
     * @return true si existe, false si no
     */

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
    /** Verifica si un envío existe por ID. */
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

    /**
     * Verifica si existe una ruta con el ID proporcionado.
     *
     * @param id identificador de la ruta a verificar
     * @return true si existe una ruta con ese ID; false en caso contrario
     */
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
    /**
     * Verifica si existe una ciudad con el ID proporcionado.
     *
     * @param id identificador de la ciudad a verificar
     * @return true si existe una ciudad con ese ID; false en caso contrario
     */
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
    /**
     * Elimina una persona por su ID, sin importar su tipo.
     *
     * @param id identificador de la persona
     * @return true si fue eliminada, false si no se encontró
     */
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
                break;
            }
        }
        return centinela;
    }
    /** Elimina un envío por ID. */
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
    /**
     * Elimina una ruta identificada por su ID.
     *
     * @param id identificador de la ruta a eliminar
     * @return true si la ruta fue eliminada; false si no se encontró ninguna ruta con ese ID
     */
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
    /**
     * Elimina una ciudad identificada por su ID.
     *
     * @param id identificador de la ciudad a eliminar
     * @return true si la ciudad fue eliminada; false si no se encontró ninguna ciudad con ese ID
     */
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
    /**
     * Actualiza la información personal de un Usuario, Repartidor o Administrador.
     *
     * @param id          identificador de la persona a actualizar
     * @param actualizado objeto con los datos nuevos
     * @return true si se actualizó, false si no se encontró
     */
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
    /**
     * Actualiza los datos de un envío existente.
     */
    public boolean actualizarEnvio(String id, Envio actualizado) {
        boolean centinela = false;
        for (Envio e:  listEnvios) {
            if (e.getId().equals(id)) {
                e.setFechaInicio(actualizado.getFechaInicio());
                e.setFechaEstimadaEntrega(actualizado.getFechaEstimadaEntrega());
                e.setFechaEntrega(actualizado.getFechaEntrega());
                e.setCosto(actualizado.getCosto());
                e.setEstadoEnvio(actualizado.getEstadoEnvio());
                e.setRuta(actualizado.getRuta());
                e.setRepartidor(actualizado.getRepartidor());
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    /**
     * Actualiza los datos de una ciudad existente.
     *
     * <p>Se busca por ID y se actualizan los campos de la ciudad con los valores
     * del objeto proporcionado (id, nombre, habitantes).</p>
     *
     * @param id         identificador de la ciudad que se desea actualizar
     * @param actualizado objeto Ciudad que contiene los nuevos valores
     * @return true si se actualizó correctamente; false si no se encontró la ciudad
     */
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
    /**
     * Actualiza los datos de una ruta existente.
     *
     * <p>Se busca por ID y se reemplazan los campos relevantes (id, ciudadOrigen,
     * ciudadDestino y distancia) por los valores del objeto actualizado.</p>
     *
     * @param id         identificador de la ruta que se desea actualizar
     * @param actualizado objeto Ruta que contiene los nuevos valores
     * @return true si se actualizó correctamente; false si no se encontró la ruta
     */
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
    /**
     * Busca una persona por su ID.
     *
     * @param id identificador de la persona
     * @return Persona encontrada o null si no existe
     */

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
    /** Busca un envío por ID. */
    public Envio buscarEnvio(String id) {
        for (Envio e: listEnvios) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Busca y devuelve una ruta por su ID.
     *
     * @param id identificador de la ruta buscada
     * @return la Ruta encontrada o null si no existe
     */
    public Ruta buscarRuta(String id) {
        for (Ruta r: listRutas) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }
    /**
     * Busca y devuelve una ciudad por su ID.
     *
     * @param id identificador de la ciudad buscada
     * @return la Ciudad encontrada o null si no existe
     */

    public Ciudad buscarCiudad(String id) {
        for (Ciudad c: listCiudades) {
            if (c.getId().equals(id)) {
                return c;
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

    public List<Ciudad> getListCiudades() {
        return listCiudades;
    }

    public void setListCiudades(List<Ciudad> listCiudades) {
        this.listCiudades = listCiudades;
    }

    public List<Ruta> getListRutas() {
        return listRutas;
    }

    public void setListRutas(List<Ruta> listRutas) {
        this.listRutas = listRutas;
    }

    public List<Pedido> getListPedidos() {
        return listPedidos;
    }
}