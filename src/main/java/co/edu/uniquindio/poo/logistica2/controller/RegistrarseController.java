package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.EmpresaLogistica;
import co.edu.uniquindio.poo.logistica2.model.Usuario;

public class RegistrarseController {
    private App app;
    private EmpresaLogistica empresa;

    public RegistrarseController() {
        this.empresa = EmpresaLogistica.getInstance();
    }
    public boolean registrar(Usuario usuario){
        return empresa.agregarPersona(usuario);
    }
    public void volver(){
        app.openViewPrincipal();
    }
    public void setApp(App app) {
        this.app = app;
    }
}
