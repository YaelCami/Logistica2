package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Ciudad;
import co.edu.uniquindio.poo.logistica2.model.Direccion;
import co.edu.uniquindio.poo.logistica2.model.EmpresaLogistica;
import co.edu.uniquindio.poo.logistica2.model.Usuario;
import javafx.application.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para la gestión de direcciones de un usuario en la aplicación.
 * Esta clase permite agregar, actualizar, eliminar y obtener direcciones asociadas a un usuario,
 * así como navegar a otras vistas. Interactúa con la instancia de EmpresaLogistica para obtener
 * la lista de ciudades disponibles.
 */
public class AgregarDireccionController {
    private App app;
    private Usuario usuario;
    private EmpresaLogistica empresaLogistica = EmpresaLogistica.getInstance();

    /**
     * Constructor que inicializa el controlador con el usuario especificado.
     *
     * @param usuario El usuario cuyas direcciones serán gestionadas.
     */
    public AgregarDireccionController(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la lista de direcciones asociadas al usuario.
     *
     * @return Una lista de objetos Direccion pertenecientes al usuario.
     */
    public List<Direccion> obtenerDirecciones() {
        return usuario.getListDirecciones();
    }

    /**
     * Obtiene la lista de ciudades disponibles desde la empresa logística.
     *
     * @return Una lista de objetos Ciudad disponibles en el sistema.
     */
    public List<Ciudad> obtenerCiudades() {
        return empresaLogistica.getListCiudades();
    }

    /**
     * Actualiza una dirección existente del usuario identificada por su ID.
     *
     * @param id El identificador único de la dirección a actualizar.
     * @param actualizada La nueva instancia de Direccion con los datos actualizados.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizarDireccion(String id, Direccion actualizada) {
        return usuario.actualizarDireccion(id, actualizada);
    }

    /**
     * Elimina una dirección del usuario identificada por su ID.
     *
     * @param id El identificador único de la dirección a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public boolean eliminarDireccion(String id) {
        return usuario.eliminarDireccion(id);
    }

    /**
     * Agrega una nueva dirección al usuario.
     *
     * @param direccion La nueva instancia de Direccion a agregar.
     * @return true si la adición fue exitosa, false en caso contrario.
     */
    public boolean agregarDireccion(Direccion direccion) {
        return usuario.agregarDireccion(direccion);
    }

    /**
     * Navega a la vista principal del usuario.
     * Abre la interfaz de usuario principal, pasando la instancia del usuario.
     */
    public void irAlInicio() {
        app.openUsuario(usuario);
    }

    /**
     * Establece la instancia del usuario.
     *
     * @param usuario La nueva instancia del usuario.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

