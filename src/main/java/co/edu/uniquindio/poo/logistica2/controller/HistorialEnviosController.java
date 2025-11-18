package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.EmpresaLogistica;
import co.edu.uniquindio.poo.logistica2.model.IEstado;
import co.edu.uniquindio.poo.logistica2.model.Pedido;
import co.edu.uniquindio.poo.logistica2.model.Usuario;

import java.time.LocalDate;
import java.util.List;

public class HistorialEnviosController {
    private App app;
    private Usuario usuario;

    public void irAlInicio() {
        app.openUsuario(usuario);
    }
    public List<Pedido> verHistorial(IEstado estado,LocalDate fecha){
        return usuario.historialEstados(estado, fecha);
    }
    public List<Pedido> verPedidos(){
        return usuario.getListPedidos();
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void setApp(App app) {
        this.app = app;
    }
}
