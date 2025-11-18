package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Administrador;
import co.edu.uniquindio.poo.logistica2.model.Ciudad;
import co.edu.uniquindio.poo.logistica2.model.EmpresaLogistica;

import java.util.List;

/**
 * Controlador para la gestión de ciudades por parte de un administrador.
 * Esta clase permite agregar, actualizar, eliminar y obtener la lista de ciudades
 * en el sistema. Interactúa con el administrador para realizar operaciones de datos
 * y con la aplicación para navegación.
 */
public class GestionarCiudadController {
    private App app;
    private Administrador administrador;
    private EmpresaLogistica empresa;

    /**
     * Constructor que inicializa el controlador obteniendo la instancia única de la empresa logística.
     */
    public GestionarCiudadController() {
        this.empresa = EmpresaLogistica.getInstance();
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
     * Obtiene la lista de ciudades gestionadas por el administrador.
     *
     * @return Una lista de objetos Ciudad.
     */
    public List<Ciudad> obtenerListaCiudades() {
        return administrador.getListCiudades();
    }

    /**
     * Agrega una nueva ciudad al sistema a través del administrador.
     *
     * @param ciudad La ciudad a agregar.
     * @return true si la adición fue exitosa (siempre retorna true en la implementación actual).
     */
    public boolean agregarCiudad(Ciudad ciudad) {
        administrador.agregarCiudad(ciudad);
        return true;
    }

    /**
     * Elimina una ciudad identificada por su ID.
     *
     * @param id El identificador único de la ciudad a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public boolean eliminar(String id) {
        return administrador.eliminarCiudad(id);
    }

    /**
     * Actualiza una ciudad existente identificada por su ID.
     *
     * @param id El identificador único de la ciudad a actualizar.
     * @param actualizada La nueva instancia de Ciudad con los datos actualizados.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizar(String id, Ciudad actualizada) {
        return administrador.actualizarCiudad(id, actualizada);
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
}

