package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.*;

import java.util.List;

public class ActualizarEstadoEnvioController {
    private App app;
    private Administrador administrador;
    private EmpresaLogistica empresaLogistica = EmpresaLogistica.getInstance();

    public void cambiarEstadoEnvio(Envio envio, IEstado nuevoEstado) {
        envio.cambiarEstado(nuevoEstado);
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

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    public void volver(){
        app.openAdministrador(administrador);
    }
    public List<Envio> obtenerEnvios(){
        return empresaLogistica.getListEnvios();
    }
    public void setApp(App app) {
        this.app = app;
    }
}
