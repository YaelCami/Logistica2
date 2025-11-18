package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.EmpresaLogistica;
import co.edu.uniquindio.poo.logistica2.model.Usuario;

/**
 * Controlador responsable de gestionar la vista de registro de nuevos usuarios.
 * Se encarga de interactuar con la capa de lógica (EmpresaLogistica)
 * para registrar un nuevo usuario en el sistema y de manejar la navegación
 * hacia la vista principal.
 */
public class RegistrarseController {
    private App app;
    private EmpresaLogistica empresa;

    /**
     * Constructor del controlador.
     * Inicializa la instancia de la empresa logística mediante el patrón Singleton.
     */
    public RegistrarseController() {
        this.empresa = EmpresaLogistica.getInstance();
    }

    /**
     * Registra un nuevo usuario en la empresa logística.
     *
     * @param usuario el usuario que se desea registrar.
     * @return {@code true} si el usuario fue registrado exitosamente,
     *         {@code false} si ya existía o no se pudo agregar.
     */
    public boolean registrar(Usuario usuario) {
        return empresa.agregarPersona(usuario);
    }

    /**
     * Regresa a la vista principal de la aplicación.
     */
    public void volver() {
        app.openViewPrincipal();
    }

    /**
     * Asigna la referencia de la aplicación principal para permitir cambios de vista.
     *
     * @param app instancia de la clase App.
     */
    public void setApp(App app) {
        this.app = app;
    }
}

