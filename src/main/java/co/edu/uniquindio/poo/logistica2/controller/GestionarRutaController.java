package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Administrador;
import co.edu.uniquindio.poo.logistica2.model.Ciudad;
import co.edu.uniquindio.poo.logistica2.model.EmpresaLogistica;
import co.edu.uniquindio.poo.logistica2.model.Ruta;

import java.util.List;

/**
 * Controlador para la gestión de rutas por parte de un administrador.
 * Esta clase permite agregar, actualizar, eliminar y obtener la lista de rutas y ciudades
 * en el sistema. Interactúa con el administrador para realizar operaciones de datos
 * y con la aplicación para navegación.
 */
public class GestionarRutaController {
    private App app;
    private Administrador administrador;
    private EmpresaLogistica empresa;

    /**
     * Constructor que inicializa el controlador obteniendo la instancia única de la empresa logística.
     */
    public GestionarRutaController() {
        this.empresa = EmpresaLogistica.getInstance();
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
     * Obtiene la lista de rutas gestionadas por el administrador.
     *
     * @return Una lista de objetos Ruta.
     */
    public List<Ruta> obtenerListaRutas() {
        return administrador.getListRutas();
    }

    /**
     * Obtiene la lista de ciudades gestionadas por el administrador.
     *
     * @return Una lista de objetos Ciudad.
     */
    public List<Ciudad> obtenerListaCiudades() {
        return administrador.getListCiudades();
    }

    /**
     * Agrega una nueva ruta al sistema a través del administrador.
     *
     * @param ruta La ruta a agregar.
     * @return true si la adición fue exitosa (siempre retorna true en la implementación actual).
     */
    public boolean agregarRuta(Ruta ruta) {
        administrador.agregarRuta(ruta);
        return true;
    }

    /**
     * Actualiza una ruta existente identificada por su ID.
     *
     * @param id El identificador único de la ruta a actualizar.
     * @param actualizada La nueva instancia de Ruta con los datos actualizados.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizarRuta(String id, Ruta actualizada) {
        return administrador.actualizarRuta(id, actualizada);
    }

    /**
     * Elimina una ruta identificada por su ID.
     *
     * @param id El identificador único de la ruta a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public boolean eliminarRuta(String id) {
        return administrador.eliminarRuta(id);
    }

    /**
     * Navega de vuelta a la vista del administrador.
     * Abre la interfaz del administrador, pasando su instancia.
     */
    public void volver() {
        app.openAdministrador(administrador);
    }
}

