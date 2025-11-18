package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.*;

import java.util.List;

/**
 * Controlador para la gestión de repartidores por parte de un administrador.
 * Esta clase permite agregar, actualizar, eliminar y obtener la lista de repartidores y rutas
 * en el sistema. Utiliza un creador de repartidores para instanciar nuevos repartidores
 * a partir de DTOs y delega operaciones al administrador.
 */
public class GestionRepartidorController {
    private App app;
    private Administrador administrador;
    private EmpresaLogistica empresa;
    private CreatorRepartidor creator = new CreatorRepartidor();

    /**
     * Constructor que inicializa el controlador obteniendo la instancia única de la empresa logística.
     */
    public GestionRepartidorController() {
        this.empresa = EmpresaLogistica.getInstance();
    }

    /**
     * Navega de vuelta a la vista del administrador.
     * Abre la interfaz del administrador, pasando su instancia.
     */
    public void volver() {
        app.openAdministrador(administrador);
    }

    /**
     * Establece la referencia a la aplicación principal.
     *
     * @param app La instancia de la aplicación principal.
     */
    public void setApp(App app) {
        this.app = app;
    }

    /**
     * Establece la instancia del administrador.
     *
     * @param administrador La instancia del administrador.
     */
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    /**
     * Obtiene la lista de repartidores desde la empresa logística.
     *
     * @return Una lista de objetos Repartidor.
     */
    public List<Repartidor> obtenerListaRepartidores() {
        return empresa.getListRepartidores();
    }

    /**
     * Obtiene la lista de rutas desde la empresa logística.
     *
     * @return Una lista de objetos Ruta.
     */
    public List<Ruta> obtenerListaRutas() {
        return empresa.getListRutas();
    }

    /**
     * Agrega un nuevo repartidor al sistema utilizando un DTO.
     * Crea el repartidor a través del creador y lo agrega vía el administrador.
     *
     * @param dto El DTO con los datos del repartidor a crear.
     * @return El repartidor creado si la adición fue exitosa, null en caso contrario.
     */
    public Repartidor agregarRepartidor(RepartidorDTO dto) {
        Repartidor repartidor = (Repartidor) creator.crearPersona(dto);
        if (administrador.agregarPersona(repartidor)) {
            return repartidor;
        }
        return null;
    }

    /**
     * Actualiza un repartidor existente identificado por su ID.
     *
     * @param id El identificador único del repartidor a actualizar.
     * @param actualizado La nueva instancia de Repartidor con los datos actualizados.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizarRepartidor(String id, Repartidor actualizado) {
        return administrador.actualizarPersona(id, actualizado);
    }

    /**
     * Elimina un repartidor identificado por su ID.
     *
     * @param id El identificador único del repartidor a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public boolean eliminarRepartidor(String id) {
        return administrador.eliminarPersona(id);
    }
}

