package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Paquete;
import co.edu.uniquindio.poo.logistica2.model.Producto;
import co.edu.uniquindio.poo.logistica2.model.Usuario;

import java.util.List;

/**
 * Controlador para la creación y gestión de paquetes por parte de un usuario.
 * Esta clase permite agregar, actualizar y eliminar paquetes y productos dentro de ellos,
 * facilitando la gestión de inventario de paquetes para el usuario. Interactúa con la aplicación
 * para navegación y con el usuario para operaciones de datos.
 */
public class CrearPaqueteController {
    private App app;
    private Usuario usuario;

    /**
     * Constructor que inicializa el controlador con el usuario especificado.
     *
     * @param usuario El usuario que utilizará el controlador para gestionar paquetes.
     */
    public CrearPaqueteController(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Navega de vuelta a la vista del usuario.
     * Abre la interfaz del usuario, pasando su instancia.
     */
    public void regresar() {
        app.openUsuario(usuario);
    }

    /**
     * Obtiene la lista de paquetes asociados al usuario.
     *
     * @return Una lista de objetos Paquete pertenecientes al usuario.
     */
    public List<Paquete> obtenerPaquetes() {
        return usuario.getListPaquetes();
    }

    /**
     * Agrega un nuevo paquete al usuario.
     *
     * @param paquete El paquete a agregar.
     * @return true si la adición fue exitosa, false en caso contrario.
     */
    public boolean agregarPaquete(Paquete paquete) {
        return usuario.agregarPaquete(paquete);
    }

    /**
     * Agrega un producto a un paquete específico.
     *
     * @param paquete El paquete al cual agregar el producto.
     * @param producto El producto a agregar.
     * @return true si la adición fue exitosa, false en caso contrario.
     */
    public boolean agregarProductoAlPaquete(Paquete paquete, Producto producto) {
        return paquete.agregarProductos(producto);
    }

    /**
     * Actualiza un producto dentro de un paquete identificado por sus IDs.
     * Busca el paquete por ID y actualiza el producto correspondiente.
     *
     * @param idPaquete El identificador del paquete.
     * @param idProducto El identificador del producto a actualizar.
     * @param actualizado El producto actualizado.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizarProductoEnPaquete(String idPaquete, String idProducto, Producto actualizado) {
        Paquete paquete = usuario.buscarPaquete(idPaquete);
        if (paquete != null) {
            return paquete.actualizarProducto(idProducto, actualizado);
        }
        return false;
    }

    /**
     * Elimina un producto de un paquete identificado por sus IDs.
     * Busca el paquete por ID y elimina el producto correspondiente.
     *
     * @param idPaquete El identificador del paquete.
     * @param idProducto El identificador del producto a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public boolean eliminarProductoDePaquete(String idPaquete, String idProducto) {
        Paquete paquete = usuario.buscarPaquete(idPaquete);
        if (paquete != null) {
            return paquete.eliminarProducto(idProducto);
        }
        return false;
    }

    /**
     * Actualiza un paquete existente identificado por su ID.
     *
     * @param id El identificador del paquete a actualizar.
     * @param actualizado El paquete actualizado.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizarPaquete(String id, Paquete actualizado) {
        return usuario.actualizarPaquete(id, actualizado);
    }

    /**
     * Elimina un paquete identificado por su ID.
     *
     * @param id El identificador del paquete a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public boolean eliminarPaquete(String id) {
        return usuario.eliminarPaquete(id);
    }

    /**
     * Establece la instancia del usuario.
     *
     * @param usuario La nueva instancia del usuario.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Establece la referencia a la aplicación principal.
     *
     * @param app La instancia de la aplicación principal.
     */
    public void setApp(App app) {
        this.app = app;
    }
}

