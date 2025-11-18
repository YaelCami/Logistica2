package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Controlador encargado de gestionar la lógica relacionada con la solicitud de pedidos
 * por parte de un usuario. Permite calcular costos, aplicar decoradores, gestionar
 * métodos de pago, fechas estimadas y CRUD de pedidos asociados al usuario.
 */
public class SolicitarPedidoController {
    private App app;
    private Usuario usuario;
    private EmpresaLogistica empresa;
    private Pedido pedido;
    private Paquete paquete;
    private String especificacionSeleccionada = "Ninguna";

    /**
     * Constructor del controlador. Inicializa la empresa logística
     * obteniendo su instancia singleton.
     */
    public SolicitarPedidoController() {
        this.empresa= EmpresaLogistica.getInstance();
    }

    /**
     * Regresa a la vista del usuario dentro de la aplicación.
     */
    public void irAlUsuario() {
        app.openUsuario(usuario);
    }

    /**
     * Asigna la referencia de la aplicación principal.
     *
     * @param app instancia de la aplicación JavaFX.
     */
    public void setApp(App app) {
        this.app = app;
    }

    /**
     * Define el usuario que realizará o gestionará pedidos.
     *
     * @param usuario instancia del usuario autenticado.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Procesa la solicitud de un pedido, mostrando un cuadro de diálogo
     * para elegir un método de pago, calculando el costo total
     * y registrando el pago realizado.
     *
     * @param pedido pedido a procesar.
     * @return true si el proceso se completó exitosamente.
     */
    public boolean realizarPedido(Pedido pedido) {
        IMetodoPago efectivo = new Efectivo();
        IMetodoPago tarjeta = new Tarjeta();
        IMetodoPago nequi = new Nequi();

        ChoiceDialog<IMetodoPago> dialog = new ChoiceDialog<>(efectivo,
                efectivo, tarjeta, nequi);
        dialog.setTitle("Método de pago");
        dialog.setHeaderText("Seleccione un método de pago");
        dialog.setContentText("Método:");

        IMetodoPago elegido = dialog.showAndWait().orElse(efectivo);

        double costo = calcularCosto(
                pedido.getPaquete(), pedido.getOrigen(), pedido.getDestino());

        Pago procesador = new Pago(
                pedido.getId(), costo, pedido.getFechaCreacion(), pedido, elegido);

        String resultado = procesador.ejecutarPago(costo);
        mostrarAlerta("Resultado del pago", resultado);

        usuario.solicitarPedido(pedido);
        return true;
    }

    /**
     * Calcula el costo total del pedido aplicando decoradores como seguro,
     * frágil, firma o prioridad, según la especificación seleccionada.
     *
     * @param paquete paquete seleccionado por el usuario.
     * @param origen dirección origen.
     * @param destino dirección destino.
     * @return costo total del pedido.
     */
    public double calcularCosto(Paquete paquete, Direccion origen, Direccion destino) {
        Pedido pedi = new Pedido("0001", LocalDate.of(2025,10,17), origen, destino,
                usuario, LocalDate.of(2025,10,22), paquete);

        IPedido p = new Pedido("0001", LocalDate.of(2025,10,17), origen, destino,
                usuario, LocalDate.of(2025,10,22), paquete);

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
     * Guarda el tipo de especificación decoradora seleccionada
     * para aplicarla posteriormente al cálculo del costo.
     *
     * @param esp nombre de la especificación (Seguro, Frágil, Firma, Prioridad).
     */
    public void guardarEspecificacion(String esp) {
        this.especificacionSeleccionada = esp;
    }

    /**
     * Calcula la fecha estimada de entrega del pedido con base en la ruta
     * entre origen y destino, verificando previamente que los datos sean válidos.
     *
     * @param fechaSolicitud fecha en la que se solicita el pedido.
     * @param origen dirección de origen.
     * @param destino dirección de destino.
     * @return fecha estimada de entrega o null si no es posible calcularla.
     */
    public LocalDate calcularFechaEstimada(LocalDate fechaSolicitud, Direccion origen, Direccion destino) {
        Pedido p = new Pedido("0001", LocalDate.of(2025,10,17), origen, destino,
                usuario, LocalDate.of(2025,10,22), paquete);

        System.out.println("Iniciando cálculo: fecha=" + fechaSolicitud +
                ", origen=" + (origen != null ? origen : "null") +
                ", destino=" + (destino != null ? destino : "null"));

        if (fechaSolicitud == null || origen == null || destino == null) {
            System.out.println("Validación fallida: algún valor es null");
            return null;
        }

        try {
            Ruta ruta = p.puedePedir(origen, destino);

            if (ruta == null) {
                return null;
            }

            return p.calcularFechaEstimadaEntrega(fechaSolicitud, ruta);

        } catch (Exception e) {
            System.out.println("Excepción en calcularFechaEstimada: " + e.getMessage());
            return null;
        }
    }

    /**
     * Obtiene la lista de pedidos del usuario.
     *
     * @return lista de pedidos.
     */
    public List<Pedido> obtenerPedidos() {
        return usuario.getListPedidos();
    }

    /**
     * Obtiene las direcciones registradas por el usuario.
     *
     * @return lista de direcciones.
     */
    public List<Direccion> obtenerDirecciones() {
        return usuario.getListDirecciones();
    }

    /**
     * Obtiene los paquetes registrados por el usuario.
     *
     * @return lista de paquetes.
     */
    public List<Paquete> obtenerPaquetes() {
        return usuario.getListPaquetes();
    }

    /**
     * Elimina un pedido del usuario.
     *
     * @param id identificador del pedido.
     * @return true si se eliminó correctamente.
     */
    public boolean eliminarPedido(String id) {
        return usuario.eliminarPedido(id);
    }

    /**
     * Actualiza un pedido existente del usuario.
     *
     * @param id ID del pedido a actualizar.
     * @param actualizado datos del pedido actualizado.
     * @return true si se modificó correctamente.
     */
    public boolean actualizarPedido(String id, Pedido actualizado){
        return usuario.actualizarPedido(id, actualizado);
    }

    /**
     * Exporta un pedido a un archivo de texto en la ruta indicada.
     *
     * @param pedido pedido a exportar.
     * @param rutaArchivoTxt ruta del archivo .txt.
     * @throws IOException si ocurre un error al escribir el archivo.
     */
    public void exportarPedido(Pedido pedido, String rutaArchivoTxt) throws IOException {
        ExportadorArchivo.exportarPedido(pedido, rutaArchivoTxt);
    }

    /**
     * Muestra una alerta informativa en pantalla.
     *
     * @param titulo título de la alerta.
     * @param mensaje mensaje interno de la alerta.
     */
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
