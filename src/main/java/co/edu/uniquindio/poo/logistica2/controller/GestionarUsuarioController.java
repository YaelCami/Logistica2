package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Administrador;
import co.edu.uniquindio.poo.logistica2.model.EmpresaLogistica;
import co.edu.uniquindio.poo.logistica2.model.Usuario;

import java.util.List;

public class GestionarUsuarioController {
    private App app;
    private Administrador administrador;
    private EmpresaLogistica empresa;

    public GestionarUsuarioController() {
        this.empresa = EmpresaLogistica.getInstance();
    }
    public void setAdministrador(Administrador administrador){
        this.administrador = administrador;
    }
    public List<Usuario> obtenerListaUsuarios(){
        return empresa.getListUsuarios();
    }
    public boolean agregarUsuario(Usuario usuario){
        administrador.agregarPersona(usuario);
        return true;
    }
    public boolean actualizar(String id, Usuario actualizado){
        return administrador.actualizarPersona(id, actualizado);
    }
    public boolean eliminar(String id){
        return administrador.eliminarPersona(id);
    }
    public void volver(){
        app.openAdministrador(administrador);
    }

    public void setApp(App app){
        this.app = app;
    }
}
