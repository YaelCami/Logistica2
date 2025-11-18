package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Controlador para la cotización de tarifas de envío en la aplicación.
 * Esta clase permite calcular el precio de un pedido basado en el paquete, direcciones de origen y destino,
 * y especificaciones adicionales como seguro, frágil, firma o prioridad. Interactúa con la empresa logística
 * para obtener datos y con la aplicación para navegación.
 */
public class CotizarTarifaController {
    private App app;
    private EmpresaLogistica empresa = EmpresaLogistica.getInstance();
    private String especificacionSeleccionada = "Ninguna";

    /**
     * Navega a la vista principal de inicio.
     * Abre la vista principal de la aplicación sin parámetros adicionales.
     */
    public void irAlInicio() {
        app.openViewPrincipal();
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
     * Obtiene la lista de ciudades disponibles desde la empresa logística.
     *
     * @return Una lista de objetos Ciudad disponibles en el sistema.
     */
    public List<Ciudad> obtenerCiudades() {
        return empresa.getListCiudades();
    }

    /**
     * Calcula el precio total de un pedido basado en el paquete, direcciones y especificaciones seleccionadas.
     * Crea una instancia temporal de Pedido, verifica si puede realizarse el pedido, aplica decoradores según
     * la especificación seleccionada y calcula el costo incluyendo extras.
     *
     * @param paquete El paquete a enviar.
     * @param origen La dirección de origen.
     * @param destino La dirección de destino.
     * @param usuario El usuario que realiza el pedido.
     * @return El precio total calculado del pedido, incluyendo extras por especificaciones.
     */
    public double calcularPrecio(Paquete paquete, Direccion origen, Direccion destino, Usuario usuario) {
        Pedido pedi = new Pedido("0001", LocalDate.of(2025, 10, 17), origen, destino, usuario, LocalDate.of(2025, 10, 22), paquete);
        IPedido p = new Pedido("0001", LocalDate.of(2025, 10, 17), origen, destino, usuario, LocalDate.of(2025, 10, 22), paquete);
        Ruta ruta = pedi.puedePedir(origen, destino);
        pedi.setRuta(ruta);
        switch (especificacionSeleccionada) {
            case "Seguro":
                p = new PedidoSeguro(p);
                break;
            case "Frágil":
                p = new PedidoFragil(p);
                break;
            case "Firma":
                p = new PedidoFirma(p);
                break;
            case "Prioridad":
                p = new PedidoPrioridad(p);
                break;
        }
        pedi.setDecorador(p);
        return pedi.calcularCostoPedido() + p.getExtras();
    }

    /**
     * Guarda la especificación seleccionada para el cálculo de precio.
     *
     * @param esp La especificación a guardar (e.g., "Seguro", "Frágil", etc.).
     */
    public void guardarEspecificacion(String esp) {
        this.especificacionSeleccionada = esp;
    }
}

