package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Paquete;
import co.edu.uniquindio.poo.logistica2.model.Usuario;

import java.util.List;

public class CrearPaqueteController {
    private App app;
    private Usuario usuario;

    public CrearPaqueteController(Usuario usuario){
        this.usuario = usuario;
    }
    public void regresar(){
        app.openUsuario(usuario);
    }
    public List<Paquete> obtenerPaquetes(){
        return usuario.getListPaquetes();
    }
    public boolean agregarPaquete(Paquete paquete){
        return usuario.getListPaquetes().add(paquete);
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    public void setApp(App app) {
        this.app = app;
    }
}
