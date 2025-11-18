package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Administrador;
import co.edu.uniquindio.poo.logistica2.model.EmpresaLogistica;

/**
 * Controlador para la gestión de las acciones del administrador en la aplicación.
 * Esta clase maneja la navegación entre diferentes vistas y funcionalidades relacionadas
 * con la administración de usuarios, envíos, pedidos, repartidores, ciudades y rutas.
 * Actúa como intermediario entre la interfaz de usuario y la lógica de la aplicación.
 */
public class AdministradorController {
    private App app;
    private Administrador administrador;
    private EmpresaLogistica empresa;

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
     * Navega a la vista de gestión de usuarios.
     * Abre la interfaz para gestionar usuarios, pasando la instancia del administrador.
     */
    public void irAGestionUsuario() {
        app.openGestionarUsuario(administrador);
    }

    /**
     * Navega a la vista de actualización de estado de envío.
     * Abre la interfaz para actualizar el estado de envíos, pasando la instancia del administrador.
     */
    public void irAActualizarEstadoEnvio() {
        app.openActualizarEnvio(administrador);
    }

    /**
     * Navega a la vista de asignación de pedidos.
     * Abre la interfaz para asignar pedidos, pasando la instancia del administrador.
     */
    public void irAAsignarPedido() {
        app.openAsignarPedido(administrador);
    }

    /**
     * Navega a la vista de gestión de repartidores.
     * Abre la interfaz para gestionar repartidores, pasando la instancia del administrador.
     */
    public void irAGestionRepartidor() {
        app.openGestionRepartidor(administrador);
    }

    /**
     * Navega a la vista principal de inicio.
     * Abre la vista principal de la aplicación sin parámetros adicionales.
     */
    public void irAlInicio() {
        app.openViewPrincipal();
    }

    /**
     * Navega a la vista de gestión de ciudades.
     * Abre la interfaz para gestionar ciudades, pasando la instancia del administrador.
     */
    public void irAGestionCiudad() {
        app.openGestionarCiudad(administrador);
    }

    /**
     * Navega a la vista de gestión de rutas.
     * Abre la interfaz para gestionar rutas, pasando la instancia del administrador.
     */
    public void irAGestionRuta() {
        app.openGestionarRuta(administrador);
    }
}

