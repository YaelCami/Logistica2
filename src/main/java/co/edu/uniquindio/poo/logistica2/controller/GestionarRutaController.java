package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Administrador;
import co.edu.uniquindio.poo.logistica2.model.Ciudad;
import co.edu.uniquindio.poo.logistica2.model.EmpresaLogistica;
import co.edu.uniquindio.poo.logistica2.model.Ruta;

import java.util.List;

public class GestionarRutaController {
    private App app;
    private Administrador administrador;
    private EmpresaLogistica empresa;

    public GestionarRutaController() {
        this.empresa = EmpresaLogistica.getInstance();
    }
    public void setApp(App app) {
        this.app = app;
    }
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    public List<Ruta> obtenerListaRutas(){
        return administrador.getListRutas();
    }
    public List<Ciudad> obtenerListaCiudades(){
        return administrador.getListCiudades();
    }
    public boolean agregarRuta(Ruta ruta) {
        administrador.agregarRuta(ruta);
        return true;
    }
    public boolean actualizarRuta(String id, Ruta actualizada){
        return administrador.actualizarRuta(id, actualizada);
    }
    public boolean eliminarRuta(String id){
        return administrador.eliminarRuta(id);
    }
    public void volver(){
        app.openAdministrador(administrador);
    }
}
