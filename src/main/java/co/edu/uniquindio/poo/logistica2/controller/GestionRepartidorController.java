package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Administrador;
import co.edu.uniquindio.poo.logistica2.model.Ciudad;
import co.edu.uniquindio.poo.logistica2.model.EmpresaLogistica;
import co.edu.uniquindio.poo.logistica2.model.Repartidor;

import java.util.List;

public class GestionRepartidorController {
    private App app;
    private Administrador administrador;
    private EmpresaLogistica empresa;

    public GestionRepartidorController() {
        this.empresa= EmpresaLogistica.getInstance();
    }
    public void volver(){
        app.openAdministrador(administrador);
    }
    public void setApp(App app) {
        this.app = app;
    }
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    public List<Repartidor> obtenerListaRepartidores() {
        return empresa.getListRepartidores();
    }
    public List<Ciudad> obtenerListaCiudades() {
        return empresa.getListCiudades();
    }
    public boolean agregarRepartidor(Repartidor repartidor) {
        administrador.agregarPersona(repartidor);
        return true;
    }
    public boolean actualizarRepartidor(String id,Repartidor actualizado) {
        return administrador.actualizarPersona(id, actualizado);
    }
    public boolean eliminarRepartidor(String id) {
        return administrador.eliminarPersona(id);
    }
}
