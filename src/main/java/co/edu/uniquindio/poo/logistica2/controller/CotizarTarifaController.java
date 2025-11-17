package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.*;

import java.time.LocalDate;
import java.util.List;

public class CotizarTarifaController {
    private App app;
    private EmpresaLogistica empresa = EmpresaLogistica.getInstance();
    private String especificacionSeleccionada = "Ninguna";

    public void irAlInicio() {
        app.openViewPrincipal();
    }
    public void setApp(App app) {
        this.app = app;
    }
    public List<Ciudad> obtenerCiudades() {
        return empresa.getListCiudades();
    }
    public double calcularPrecio(Paquete paquete, Direccion origen, Direccion destino, Usuario usuario) {
        Pedido pedi = new Pedido("0001", LocalDate.of(2025,10,17),origen, destino, usuario,LocalDate.of(2025,10,22),paquete );
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
    public void guardarEspecificacion(String esp){
        this.especificacionSeleccionada = esp;
    }
}
