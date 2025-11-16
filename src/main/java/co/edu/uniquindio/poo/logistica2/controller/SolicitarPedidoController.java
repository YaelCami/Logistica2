package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.*;

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


    public String calcularFechaEstimada(LocalDate fechaSolicitud, Direccion origen, Direccion destino) {
        Pedido p = new Pedido("0001",LocalDate.of(2025,10,17),origen, destino, usuario,LocalDate.of(2025,10,22),paquete );
        //PEDIDO PROVISIONAL
        System.out.println("Iniciando cálculo: fecha=" + fechaSolicitud + ", origen=" + (origen != null ? origen.toString() : "null") + ", destino=" + (destino != null ? destino.toString() : "null"));

        if (fechaSolicitud == null || origen == null || destino == null) {
            System.out.println("Validación fallida: algún valor es null");
            return "Fecha";
        }
        try {
            System.out.println("Llamando a puedePedir...");
            Ruta ruta = p.puedePedir(origen, destino);
            if (ruta == null) {
                System.out.println("puedePedir retornó null");
                return "No se puede realizar el pedido para estas direcciones";
            }
            System.out.println("Ruta obtenida: distancia=" + ruta.getDistancia());

            System.out.println("Llamando a calcularFechaEstimadaEntrega...");
            LocalDate fechaEstimada = p.calcularFechaEstimadaEntrega(fechaSolicitud, ruta);
            if (fechaEstimada == null) {
                System.out.println("calcularFechaEstimadaEntrega retornó null");
                return "Error al calcular fecha";
            }
            System.out.println("Fecha estimada calculada: " + fechaEstimada);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String resultado = fechaEstimada.format(formatter);
            System.out.println("Resultado formateado: " + resultado);
            return resultado;
        } catch (Exception e) {
            System.out.println("Excepción en calcularFechaEstimada: " + e.getMessage());
            e.printStackTrace();
            return "Error al calcular fecha";
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
}
