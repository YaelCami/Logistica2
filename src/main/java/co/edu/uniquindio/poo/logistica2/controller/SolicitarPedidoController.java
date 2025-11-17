package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SolicitarPedidoController {
    private App app;
    private Usuario usuario;
    private EmpresaLogistica empresa;
    private Pedido pedido;
    private Paquete paquete;
    private String especificacionSeleccionada = "Ninguna";

    public SolicitarPedidoController() {
        this.empresa= EmpresaLogistica.getInstance();
    }
    public void irAlUsuario() {
        app.openUsuario(usuario);
    }
    public void setApp(App app) {
        this.app = app;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
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

    public double calcularCosto(Paquete paquete, Direccion origen, Direccion destino) {
        Pedido pedi = new Pedido("0001",LocalDate.of(2025,10,17),origen, destino, usuario,LocalDate.of(2025,10,22),paquete );
        IPedido p = new Pedido("0001",LocalDate.of(2025,10,17),origen, destino, usuario,LocalDate.of(2025,10,22),paquete );
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

    public void guardarEspecificacion(String esp) {
        this.especificacionSeleccionada = esp;
    }


    public LocalDate calcularFechaEstimada(LocalDate fechaSolicitud, Direccion origen, Direccion destino) {
        Pedido p = new Pedido("0001",LocalDate.of(2025,10,17),origen, destino, usuario,LocalDate.of(2025,10,22),paquete );
        //PEDIDO PROVISIONAL
        System.out.println("Iniciando cálculo: fecha=" + fechaSolicitud + ", origen=" + (origen != null ? origen.toString() : "null") + ", destino=" + (destino != null ? destino.toString() : "null"));

        if (fechaSolicitud == null || origen == null || destino == null) {
            System.out.println("Validación fallida: algún valor es null");
            return null;
        }
        try {
            System.out.println("Llamando a puedePedir...");
            Ruta ruta = p.puedePedir(origen, destino);
            if (ruta == null) {
                System.out.println("puedePedir retornó null");
                return null;
            }
            System.out.println("Ruta obtenida: distancia=" + ruta.getDistancia());

            System.out.println("Llamando a calcularFechaEstimadaEntrega...");
            LocalDate fechaEstimada = p.calcularFechaEstimadaEntrega(fechaSolicitud, ruta);
            if (fechaEstimada == null) {
                System.out.println("calcularFechaEstimadaEntrega retornó null");
                return null;
            }
            System.out.println("Fecha estimada calculada: " + fechaEstimada);
            return fechaEstimada;
        } catch (Exception e) {
            System.out.println("Excepción en calcularFechaEstimada: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public List<Pedido> obtenerPedidos() {
        return usuario.getListPedidos();
    }
    public List<Direccion> obtenerDirecciones() {
        return usuario.getListDirecciones();
    }
    public List<Paquete> obtenerPaquetes() {
        return usuario.getListPaquetes();
    }
    public boolean eliminarPedido(String id) {
        return usuario.eliminarPedido(id);
    }
    public boolean actualizarPedido(String id,Pedido actualizado){
        return usuario.actualizarPedido(id, actualizado);
    }
    public void exportarPedido(Pedido pedido, String rutaArchivoTxt) throws IOException {
        ExportadorArchivo.exportarPedido(pedido, rutaArchivoTxt);
    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
