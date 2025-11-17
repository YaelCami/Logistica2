package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Administrador;
import co.edu.uniquindio.poo.logistica2.model.EmpresaLogistica;
import co.edu.uniquindio.poo.logistica2.model.Persona;
import co.edu.uniquindio.poo.logistica2.model.Usuario;

public class PrimaryController {
    private App app;
    private EmpresaLogistica empresa = EmpresaLogistica.getInstance();

    public void setApp(App app) {
        this.app = app;
    }
    public void irAlRegistro(){
        app.openRegistrarse();
    }
    public void irACotizar(){
        app.openCotizarTarifa();
    }

    public void redireccionar(String id){
        Persona p = empresa.buscarPersona(id);
        if(p != null){
            if(p instanceof Usuario){
                Usuario u = (Usuario) p;
                app.openUsuario(u);
            }
             else if(p instanceof Administrador){
                Administrador a = (Administrador) p;
                app.openAdministrador(a);
            } else {
                System.out.println("No se puede redireccionar");
            }
        } else {
            System.out.println("No encuentra a ninguna persona");
        }
    }


}
