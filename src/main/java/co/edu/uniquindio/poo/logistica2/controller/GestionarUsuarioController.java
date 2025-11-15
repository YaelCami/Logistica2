package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.*;

import java.util.List;

public class GestionarUsuarioController {
    private App app;
    private Administrador administrador;
    private EmpresaLogistica empresa;
    private CreatorUsuario creator = new CreatorUsuario();

    public GestionarUsuarioController() {
        this.empresa = EmpresaLogistica.getInstance();
    }
    public void setAdministrador(Administrador administrador){
        this.administrador = administrador;
    }
    public List<Usuario> obtenerListaUsuarios(){
        return empresa.getListUsuarios();
    }
    public Usuario agregarUsuario(UsuarioDTO dto){
        Usuario usuario = (Usuario) creator.crearPersona(dto);
        if (administrador.agregarPersona(usuario)){
            return usuario;
        }
        return null;
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
