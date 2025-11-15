package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Paquete;
import co.edu.uniquindio.poo.logistica2.model.Producto;
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
        return usuario.agregarPaquete(paquete);
    }
    public boolean agregarProductoAlPaquete(Paquete paquete, Producto producto){
        return paquete.agregarProductos(producto);
    }
    public boolean actualizarProductoEnPaquete(String idPaquete, String idProducto, Producto actualizado){
        Paquete paquete = usuario.buscarPaquete(idPaquete);
        if (paquete != null) {
            return paquete.actualizarProducto(idProducto, actualizado);
        }
        return false;
    }
    public boolean eliminarProductoDePaquete(String idPaquete, String idProducto){
        Paquete paquete = usuario.buscarPaquete(idPaquete);
        if (paquete != null) {
            return paquete.eliminarProducto(idProducto);
        }
        return false;
    }
    public boolean actualizarPaquete(String id, Paquete actualizado){
        return usuario.actualizarPaquete(id, actualizado);
    }
    public boolean eliminarPaquete(String id){
        return usuario.eliminarPaquete(id);
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    public void setApp(App app) {
        this.app = app;
    }
}
