package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Administrador;
import co.edu.uniquindio.poo.logistica2.model.Ciudad;
import co.edu.uniquindio.poo.logistica2.model.EmpresaLogistica;

import java.util.List;

public class GestionarCiudadController {
    private App app;
    private Administrador administrador;
    private EmpresaLogistica empresa;

    public GestionarCiudadController() {
        this.empresa = EmpresaLogistica.getInstance();
    }
    public void setAdministrador(Administrador administrador){
        this.administrador = administrador;
    }
    public List<Ciudad> obtenerListaCiudades() {
        return administrador.getListCiudades();
    }
    public boolean agregarCiudad(Ciudad ciudad) {
        administrador.agregarCiudad(ciudad);
        return true;
    }
    public boolean eliminar(String id) {
        return administrador.eliminarCiudad(id);
    }
    public boolean actualizar(String id, Ciudad actualizada){
        return administrador.actualizarCiudad(id, actualizada);
    }
    public void volver(){
        app.openAdministrador(administrador);
    }
    public void setApp(App app) {
        this.app = app;
    }
}
