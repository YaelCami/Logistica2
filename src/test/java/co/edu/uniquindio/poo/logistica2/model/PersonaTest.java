package co.edu.uniquindio.poo.logistica2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {

    @Test
    void verificarCorreo() {
        Persona p1=new Persona.Builder()
                .id("1")
                .nombre("q")
                .correo("@Raul")
                .build();
        assertTrue(p1.verificarCorreo(p1.getCorreo()));
    }
}