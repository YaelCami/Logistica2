package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.*;

import java.util.List;

public class ActualizarEstadoEnvioController {
    private App app;
    private Administrador administrador;
    private EmpresaLogistica empresaLogistica = EmpresaLogistica.getInstance();

    /**
     * Metodo para cambiar el estado del envio seleccionado, por el estado seleccionado en el combo box
     * @param envio
     * @param nuevoEstado
     */
    public void cambiarEstadoEnvio(Envio envio, IEstado nuevoEstado) {
        envio.cambiarEstado(nuevoEstado);
        List<Pedido> pedidos = envio.getListPedidos();
        for (Pedido pedido : pedidos){
            pedido.setEstado(nuevoEstado.getNombre());
        }
        if (nuevoEstado instanceof EnRuta) {
            envio.enRuta();
            administrador.cambiarDisponibilidadEnRuta(envio.getRepartidor());
        }
        else if (nuevoEstado instanceof Entregado) {
            envio.entregar();
            administrador.cambiarDisponibilidadActivo(envio.getRepartidor());
        }
        else if (nuevoEstado instanceof Incidencia) {
            envio.reportarIncidencia();
            administrador.cambiarDisponibilidadInactivo(envio.getRepartidor());
        }
    }

    /**
     * Metodo para volver a interfaz administrador
     */
    public void volver(){
        app.openAdministrador(administrador);
    }

    /**
     * Metodo para obtener la lista de envios almacenados
     * @return lista de envios creados
     */
    public List<Envio> obtenerEnvios(){
        return empresaLogistica.getListEnvios();
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    public void setApp(App app) {
        this.app = app;
    }
}
