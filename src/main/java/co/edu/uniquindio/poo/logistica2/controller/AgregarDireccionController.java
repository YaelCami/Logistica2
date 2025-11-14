package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Ciudad;
import co.edu.uniquindio.poo.logistica2.model.Direccion;
import co.edu.uniquindio.poo.logistica2.model.EmpresaLogistica;
import co.edu.uniquindio.poo.logistica2.model.Usuario;
import javafx.application.Application;

import java.util.ArrayList;
import java.util.List;

public class AgregarDireccionController {
    private App app;
    private Usuario usuario;
    private EmpresaLogistica empresaLogistica = EmpresaLogistica.getInstance();

    public AgregarDireccionController(Usuario usuario){
        this.usuario = usuario;
    }
    public List<Direccion> obtenerDirecciones() {
        return usuario.getListDirecciones();
    }
    public List<Ciudad> obtenerCiudades(){
        return empresaLogistica.getListCiudades();
    }
    public boolean actualizarDireccion(String id, Direccion actualizada){
        return usuario.actualizarDireccion(id, actualizada);
    }
    public boolean eliminarDireccion(String id){
        return usuario.eliminarDireccion(id);
    }
    public boolean agregarDireccion(Direccion direccion){
        return usuario.agregarDireccion(direccion);
    }

    public void irAlInicio() {
        app.openUsuario(usuario);
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void setApp(App app) {
        this.app = app;
    }
}
