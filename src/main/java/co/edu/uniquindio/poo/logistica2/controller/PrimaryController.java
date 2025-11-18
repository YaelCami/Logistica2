package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;
import co.edu.uniquindio.poo.logistica2.model.Administrador;
import co.edu.uniquindio.poo.logistica2.model.EmpresaLogistica;
import co.edu.uniquindio.poo.logistica2.model.Persona;
import co.edu.uniquindio.poo.logistica2.model.Usuario;

/**
 * Controlador principal de la aplicación.
 * Gestiona la navegación entre vistas iniciales y la redirección
 * según el tipo de persona que inicia sesión.
 */
public class PrimaryController {
    private App app;
    private EmpresaLogistica empresa = EmpresaLogistica.getInstance();

    /**
     * Asigna la referencia de la aplicación principal.
     *
     * @param app instancia de la clase App utilizada para cambiar de ventanas.
     */
    public void setApp(App app) {
        this.app = app;
    }

    /**
     * Redirige a la vista de registro de nuevos usuarios.
     */
    public void irAlRegistro() {
        app.openRegistrarse();
    }

    /**
     * Redirige a la vista donde se cotiza la tarifa de envío.
     */
    public void irACotizar() {
        app.openCotizarTarifa();
    }

    /**
     * Busca una persona según su ID y redirige a la interfaz correspondiente:
     * Si no encuentra a la persona o no es una instancia válida, muestra un mensaje por consola.
     *
     * @param id el identificador único de la persona.
     */
    public void redireccionar(String id) {
        Persona p = empresa.buscarPersona(id);
        if (p != null) {
            if (p instanceof Usuario) {
                Usuario u = (Usuario) p;
                app.openUsuario(u);

            } else if (p instanceof Administrador) {
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

