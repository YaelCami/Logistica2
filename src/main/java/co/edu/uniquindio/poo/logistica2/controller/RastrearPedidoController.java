package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Usuario;

/**
 * Controlador encargado de gestionar la vista de rastreo de pedidos
 * para un usuario dentro de la aplicación.
 * <p>
 * Permite consultar el estado de un pedido mediante su ID y
 * regresar a la pantalla principal del usuario.
 */
public class RastrearPedidoController {
    private App app;
    private Usuario usuario;

    /**
     * Asigna el usuario que utilizará esta vista para rastrear pedidos.
     *
     * @param usuario instancia del usuario activo en la sesión.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Llama al método de rastreo del usuario para obtener el estado
     * del pedido correspondiente al ID proporcionado.
     *
     * @param id identificador único del pedido.
     * @return un mensaje con el estado del pedido o un aviso si no existe.
     */
    public String rastrearPedido(String id) {
        return usuario.rastrearPedido(id);
    }

    /**
     * Asigna la referencia de la aplicación principal, necesaria
     * para gestionar los cambios de vista.
     *
     * @param app instancia de la clase App.
     */
    public void setApp(App app) {
        this.app = app;
    }

    /**
     * Regresa a la pantalla principal del usuario que está utilizando la vista.
     */
    public void irAlInicio() {
        app.openUsuario(usuario);
    }
}

