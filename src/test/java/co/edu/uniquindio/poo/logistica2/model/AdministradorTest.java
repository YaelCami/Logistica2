package co.edu.uniquindio.poo.logistica2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdministradorTest {

    @Test
    void buscarRepartidorRutaDisponible() {
        Administrador a1=new Administrador.Builder()
                .nombre("Juan")
                .salario(3000)
                .build();
    }

    @Test
    void cambiarDisponibilidadEnRuta() {
    }

    @Test
    void cambiarDisponibilidadActivo() {
    }

    @Test
    void cambiarDisponibilidadInactivo() {
    }

    @Test
    void buscarPedidosRuta() {
    }

    @Test
    void agregarEnvio() {
    }
}

