package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para la asignación de pedidos a envíos por parte de un administrador.
 * Esta clase facilita la gestión de pedidos, repartidores y rutas, permitiendo crear envíos,
 * asignar pedidos y calcular fechas estimadas de entrega. Interactúa con la empresa logística
 * para obtener datos y con el administrador para realizar operaciones.
 */
public class AsignarPedidoController {
    private App app;
    private Administrador administrador;
    private Repartidor repartidor;
    private EmpresaLogistica empresaLogistica = EmpresaLogistica.getInstance();

    /**
     * Constructor que inicializa el controlador con el administrador especificado.
     *
     * @param administrador El administrador que utilizará el controlador.
     */
    public AsignarPedidoController(Administrador administrador) {
        this.administrador = administrador;
    }

    /**
     * Establece la instancia del administrador.
     *
     * @param administrador La nueva instancia del administrador.
     */
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    /**
     * Obtiene la lista de pedidos asociados a una ruta específica.
     * Filtra los pedidos de la empresa logística que coincidan con las ciudades de origen y destino de la ruta.
     *
     * @param ruta La ruta para la cual se buscan los pedidos.
     * @return Una lista de pedidos que coinciden con la ruta.
     */
    public List<Pedido> getPedidos(Ruta ruta) {
        List<Pedido> pedidosSegunRuta = new ArrayList<>();
        List<Pedido> listPedidos = empresaLogistica.getListPedidos();
        for (Pedido pedido : listPedidos) {
            if (pedido.getOrigen().getCiudad().equals(ruta.getCiudadOrigen()) && pedido.getDestino().getCiudad().equals(ruta.getCiudadDestino())) {
                pedidosSegunRuta.add(pedido);
            }
        }
        return pedidosSegunRuta;
    }

    /**
     * Obtiene la lista de repartidores disponibles para una ruta específica.
     * Filtra los repartidores activos de la empresa logística que cubran la ruta dada.
     *
     * @param ruta La ruta para la cual se buscan los repartidores.
     * @return Una lista de repartidores disponibles que cubren la ruta.
     */
    public List<Repartidor> getRepartidores(Ruta ruta) {
        List<Repartidor> repartidors = new ArrayList<>();
        List<Repartidor> listRepartidores = empresaLogistica.getListRepartidores();
        for (Repartidor repartidor : listRepartidores) {
            List<Ruta> rutas = repartidor.getZonaCobertura();
            for (Ruta r : rutas) {
                if (repartidor.getDisponibilidad() == Disponibilidad.ACTIVO && r.equals(ruta)) {
                    repartidors.add(repartidor);
                }
            }
        }
        return repartidors;
    }

    /**
     * Crea un nuevo envío y actualiza el estado de los pedidos asociados.
     * Agrega el envío al administrador y establece el estado y el envío en cada pedido.
     *
     * @param envio El envío a crear.
     * @return true si la creación fue exitosa, false en caso contrario.
     */
    public boolean crearEnvio(Envio envio) {
        if (administrador.agregarEnvio(envio)) {
            for (Pedido p : envio.getListPedidos()) {
                p.setEstado(envio.getEstadoEnvio().getNombre());
                p.setEnvio(envio);
            }
            return true;
        }
        return false;
    }

    /**
     * Calcula la fecha estimada de entrega para un envío basado en la fecha inicial y la ruta.
     * Crea una instancia temporal de Envio para realizar el cálculo.
     *
     * @param fecha La fecha inicial del envío.
     * @param ruta La ruta del envío.
     * @return La fecha estimada de entrega, o null si ocurre un error o los parámetros son nulos.
     */
    public LocalDate calcularFechaEstimada(LocalDate fecha, Ruta ruta) {
        Envio envio = new Envio("78", fecha, LocalDate.of(2025, 10, 17), ruta, repartidor);
        if (fecha == null || ruta == null) {
            System.out.println("Algún valor es nulo para calcular fecha estimada de entrega");
            return null;
        }
        try {
            System.out.println("Calculando Fecha Estimada");
            LocalDate fechaEstimada = envio.calcularFechaEstimadaEntrega(fecha, ruta);
            if (fechaEstimada == null) {
                System.out.println("Fecha Estimada no encontrada");
                return null;
            }
            System.out.println("Fecha Estimada: " + fechaEstimada);
            return fechaEstimada;
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Asigna un pedido a un envío existente.
     *
     * @param envio El envío al cual asignar el pedido.
     * @param pedido El pedido a asignar.
     * @return true si la asignación fue exitosa, false en caso contrario.
     */
    public boolean asignarPedidoAlEnvio(Envio envio, Pedido pedido) {
        return envio.agregarPedido(pedido);
    }

    /**
     * Obtiene la lista de rutas disponibles desde la empresa logística.
     *
     * @return Una lista de todas las rutas en el sistema.
     */
    public List<Ruta> obtenerRutas() {
        return empresaLogistica.getListRutas();
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
     * Obtiene la lista de repartidores disponibles para una ruta específica.
     * Delega la búsqueda al administrador.
     *
     * @param ruta La ruta para la cual se buscan los repartidores.
     * @return Una lista de repartidores disponibles que cubren la ruta.
     */
    public List<Repartidor> obtenerRepartidores(Ruta ruta) {
        return administrador.buscarRepartidorRutaDisponible(ruta);
    }

    /**
     * Obtiene la lista de pedidos asociados a una ruta específica.
     * Delega la búsqueda al administrador.
     *
     * @param ruta La ruta para la cual se buscan los pedidos.
     * @return Una lista de pedidos que coinciden con la ruta.
     */
    public List<Pedido> obtenerPedidos(Ruta ruta) {
        return administrador.buscarPedidosRuta(ruta);
    }
}

