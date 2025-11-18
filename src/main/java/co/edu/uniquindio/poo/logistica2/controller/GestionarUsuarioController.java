package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.*;

import java.util.List;

/**
 * Controlador para la gestión de usuarios por parte de un administrador.
 * Esta clase permite agregar, actualizar, eliminar y obtener la lista de usuarios
 * en el sistema. Utiliza un creador de usuarios para instanciar nuevos usuarios
 * a partir de DTOs y delega operaciones al administrador.
 */
public class GestionarUsuarioController {
    private App app;
    private Administrador administrador;
    private EmpresaLogistica empresa;
    private CreatorUsuario creator = new CreatorUsuario();

    /**
     * Constructor que inicializa el controlador obteniendo la instancia única de la empresa logística.
     */
    public GestionarUsuarioController() {
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
     * Obtiene la lista de usuarios desde la empresa logística.
     *
     * @return Una lista de objetos Usuario.
     */
    public List<Usuario> obtenerListaUsuarios() {
        return empresa.getListUsuarios();
    }

    /**
     * Agrega un nuevo usuario al sistema utilizando un DTO.
     * Crea el usuario a través del creador y lo agrega vía el administrador.
     *
     * @param dto El DTO con los datos del usuario a crear.
     * @return El usuario creado si la adición fue exitosa, null en caso contrario.
     */
    public Usuario agregarUsuario(UsuarioDTO dto) {
        Usuario usuario = (Usuario) creator.crearPersona(dto);
        if (administrador.agregarPersona(usuario)) {
            return usuario;
        }
        return null;
    }

    /**
     * Actualiza un usuario existente identificado por su ID.
     *
     * @param id El identificador único del usuario a actualizar.
     * @param actualizado La nueva instancia de Usuario con los datos actualizados.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizar(String id, Usuario actualizado) {
        return administrador.actualizarPersona(id, actualizado);
    }

    /**
     * Elimina un usuario identificado por su ID.
     *
     * @param id El identificador único del usuario a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public boolean eliminar(String id) {
        return administrador.eliminarPersona(id);
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

