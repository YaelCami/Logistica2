package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Usuario;

/**
 * Controlador responsable de gestionar la navegación del usuario dentro de la aplicación.
 * Esta clase actúa como intermediario entre la vista del usuario y las distintas pantallas
 * o procesos relacionados con direcciones, envíos, paquetes y solicitudes.
 * Permite redirigir al usuario a diferentes secciones según la acción seleccionada.
 */
public class UsuarioController {
    private App app;
    private Usuario usuario;

    /**
     * Establece el usuario activo cuyos datos y acciones serán manipulados en el controlador.
     *
     * @param usuario instancia del usuario actual.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Redirige a la pantalla para agregar una nueva dirección.
     * Verifica que exista un usuario válido antes de navegar.
     */
    public void irAgregarDireccion() {
        if (usuario == null) {
            System.out.println("Error: usuario es null en UsuarioController");
            return;
        }
        app.openAgregarDireccion(usuario);
    }

    /**
     * Abre la vista para rastrear un pedido perteneciente al usuario.
     */
    public void openRastrearPedido() {
        app.openRastrearPedido(usuario);
    }

    /**
     * Redirige a la pantalla donde se muestra el historial de envíos del usuario.
     */
    public void irAlHistorial() {
        app.openHistorialEnvios(usuario);
    }

    /**
     * Abre la interfaz para solicitar un nuevo pedido.
     */
    public void irSolicitarPedido() {
        app.openSolicitarPedido(usuario);
    }

    /**
     * Redirige al formulario de creación de paquetes.
     */
    public void irACrearPaquete() {
        app.openCrearPaquete(usuario);
    }

    /**
     * Regresa a la vista principal de la aplicación.
     */
    public void irAlInicio() {
        app.openViewPrincipal();
    }

    /**
     * Asigna la instancia principal de la aplicación al controlador.
     *
     * @param app instancia de la clase App.
     */
    public void setApp(App app) {
        this.app = app;
    }
}

