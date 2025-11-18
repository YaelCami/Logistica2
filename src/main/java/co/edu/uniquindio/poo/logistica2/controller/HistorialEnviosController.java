package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.EmpresaLogistica;
import co.edu.uniquindio.poo.logistica2.model.IEstado;
import co.edu.uniquindio.poo.logistica2.model.Pedido;
import co.edu.uniquindio.poo.logistica2.model.Usuario;

import java.time.LocalDate;
import java.util.List;

/**
 * Controlador para la visualización del historial de envíos de un usuario.
 * Esta clase permite ver el historial de pedidos filtrados por estado y fecha,
 * así como obtener la lista completa de pedidos del usuario. Interactúa con la aplicación
 * para navegación y con el usuario para acceder a sus datos.
 */
public class HistorialEnviosController {
    private App app;
    private Usuario usuario;

    /**
     * Navega a la vista principal del usuario.
     * Abre la interfaz del usuario, pasando su instancia.
     */
    public void irAlInicio() {
        app.openUsuario(usuario);
    }

    /**
     * Obtiene el historial de pedidos del usuario filtrados por estado y fecha.
     *
     * @param estado El estado por el cual filtrar los pedidos (e.g., "Enviado", "Entregado").
     * @param fecha La fecha por la cual filtrar los pedidos.
     * @return Una lista de pedidos que coinciden con el estado y fecha especificados.
     */
    public List<Pedido> verHistorial(String estado, LocalDate fecha) {
        return usuario.historialEstados(estado, fecha);
    }

    /**
     * Obtiene la lista completa de pedidos del usuario.
     *
     * @return Una lista de todos los pedidos asociados al usuario.
     */
    public List<Pedido> verPedidos() {
        return usuario.getListPedidos();
    }

    /**
     * Establece la instancia del usuario.
     *
     * @param usuario La instancia del usuario.
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

