package co.edu.uniquindio.poo.logistica2.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmpresaLogisticaTest {

    @Test
    void agregarPersona() {
        EmpresaLogistica empresa= EmpresaLogistica.getInstance();
        Persona p5=new Persona.Builder()
                .id("5")
                .nombre("e")
                .build();
        empresa.agregarPersona(p5);
        assertFalse(empresa.agregarPersona(p5));
    }

    @Test
    void agregarEnvio() {
        EmpresaLogistica empresa= EmpresaLogistica.getInstance();
        Ciudad c61=new Ciudad("23","c1",122);
        Ciudad c62=new Ciudad("22","c2",133);
        Ruta r6=new Ruta("21",c61,c62,11111);
        Repartidor p6=new Repartidor.Builder()
                .id("6")
                .nombre("y")
                .build();
        Envio e6=new Envio("6", LocalDate.of(10,12,1212),LocalDate.of(10,9,1212),r6,p6);
        assertTrue(empresa.agregarEnvio(e6));
    }

    @Test
    void agregarRuta() {
        EmpresaLogistica empresa= EmpresaLogistica.getInstance();
        Ciudad c71=new Ciudad("71","c3",122);
        Ciudad c72=new Ciudad("72","c4",133);
        Ruta r7=new Ruta("71",c71,c72,11111);
        empresa.agregarRuta(r7);
        assertFalse(empresa.agregarRuta(r7));
    }

    @Test
    void agregarCiudad() {
        EmpresaLogistica empresa= EmpresaLogistica.getInstance();
        Ciudad c81=new Ciudad("81","c8",122);
        assertTrue(empresa.agregarCiudad(c81));
    }

    @Test
    void verificarPersona() {
        EmpresaLogistica empresa= EmpresaLogistica.getInstance();
        Usuario p1=new Usuario.Builder()
                .id("1")
                .nombre("q")
                .build();
        empresa.agregarPersona(p1);
        assertTrue(empresa.verificarPersona(p1.getId()));
    }

    @Test
    void verificarEnvio() {
        EmpresaLogistica empresa= EmpresaLogistica.getInstance();
        Ciudad c1=new Ciudad("23","c1",122);
        Ciudad c2=new Ciudad("22","c2",133);
        Ruta r1=new Ruta("21",c1,c2,11111);
        Repartidor p2=new Repartidor.Builder()
                .id("2")
                .nombre("w")
                .build();
        Envio e1=new Envio("2",LocalDate.of(10,12,1212),LocalDate.of(20,9,1213),r1,p2);
        assertFalse(empresa.verificarEnvio(e1.getId()));
    }

    @Test
    void verificarRuta() {
        EmpresaLogistica empresa= EmpresaLogistica.getInstance();
        Ciudad c3=new Ciudad("31","c3",122);
        Ciudad c4=new Ciudad("32","c4",133);
        Ruta r1=new Ruta("31",c3,c4,11111);
        empresa.agregarRuta(r1);
        assertTrue(empresa.verificarRuta(r1.getId()));
    }

    @Test
    void verificarCiudad() {
        EmpresaLogistica empresa= EmpresaLogistica.getInstance();
        Ciudad c5=new Ciudad("51","c5",122);
        assertFalse(empresa.verificarCiudad(c5.getId()));
    }

    @Test
    void eliminarPersona() {
        EmpresaLogistica empresa= EmpresaLogistica.getInstance();
        Persona p8=new Usuario.Builder()
                .id("8")
                .nombre("r")
                .build();
        empresa.agregarPersona(p8);
        assertTrue(empresa.eliminarPersona(p8.getId()));
    }

    @Test
    void eliminarEnvio() {
        EmpresaLogistica empresa= EmpresaLogistica.getInstance();
        Ciudad c9=new Ciudad("91","c9",122);
        Ciudad c10=new Ciudad("102","c10",133);
        Ruta r9=new Ruta("21",c9,c10,11111);
        Repartidor p9=new Repartidor.Builder()
                .id("2")
                .nombre("t")
                .build();
        Envio e9=new Envio("2",LocalDate.of(10,12,1212),LocalDate.of(20,9,1213),r9,p9);
        assertFalse(empresa.eliminarEnvio(e9.getId()));
    }

    @Test
    void eliminarRuta() {
        EmpresaLogistica empresa= EmpresaLogistica.getInstance();
        Ciudad c9=new Ciudad("91","c9",122);
        Ciudad c10=new Ciudad("102","c10",133);
        Ruta r9=new Ruta("21",c9,c10,11111);
        empresa.agregarRuta(r9);
        assertTrue(empresa.eliminarRuta(r9.getId()));
    }

    @Test
    void eliminarCiudad() {
        EmpresaLogistica empresa= EmpresaLogistica.getInstance();
        Ciudad c10=new Ciudad("101","c10",122);
        assertFalse(empresa.eliminarCiudad(c10.getId()));
    }

    @Test
    void actualizarPersona() {
        EmpresaLogistica empresa= EmpresaLogistica.getInstance();
        Persona p11=new Usuario.Builder()
                .id("11")
                .nombre("y")
                .build();
        Persona p12=new Usuario.Builder()
                .id("11")
                .nombre("yael")
                .build();
        assertFalse(empresa.actualizarPersona(p11.getId(),p12));
    }

    @Test
    void actualizarEnvio() {
        EmpresaLogistica empresa= EmpresaLogistica.getInstance();
        Ciudad c12=new Ciudad("91","c9",122);
        Ciudad c13=new Ciudad("102","c10",133);
        Ruta r12=new Ruta("21",c12,c13,11111);
        Repartidor p12=new Repartidor.Builder()
                .id("12")
                .nombre("u")
                .build();
        empresa.agregarPersona(p12);

        Envio e12=new Envio("12",LocalDate.of(10,12,121),LocalDate.of(20,9,1213),r12,p12);
        Envio e13=new Envio("13",LocalDate.of(10,12,1212),LocalDate.of(20,9,1215),r12,p12);
        empresa.agregarRuta(r12);
        assertTrue(empresa.actualizarEnvio(e12.getId(),e13));
    }

    @Test
    void actualizarCiudad() {
        EmpresaLogistica empresa= EmpresaLogistica.getInstance();
        Ciudad c13=new Ciudad("131","c13",122);
        Ciudad c14=new Ciudad("14","c14",133);
        empresa.agregarCiudad(c13);
        assertTrue(empresa.actualizarCiudad(c13.getId(),c14));
    }

    @Test
    void actualizarRuta() {
        EmpresaLogistica empresa= EmpresaLogistica.getInstance();
        Ciudad c14=new Ciudad("141","c14",122);
        Ciudad c15=new Ciudad("152","c15",133);
        Ruta r14=new Ruta("21",c14,c15,11111);
        Ruta r15=new Ruta("151",c15,c15,11111);
        assertFalse(empresa.actualizarRuta(r14.getId(),r15));
    }

    @Test
    void buscarPersona() {
        EmpresaLogistica empresa= EmpresaLogistica.getInstance();
        Persona p15=new Usuario.Builder()
                .id("15")
                .nombre("p")
                .build();
        empresa.agregarPersona(p15);
        assertEquals(p15,empresa.buscarPersona(p15.getId()));
    }

    @Test
    void buscarEnvio() {
        EmpresaLogistica empresa= EmpresaLogistica.getInstance();
        Ciudad c15=new Ciudad("15","c15",122);
        Ciudad c16=new Ciudad("16","c16",133);
        Ruta r15=new Ruta("21",c15,c16,11111);
        Repartidor p15=new Repartidor.Builder()
                .id("15")
                .nombre("t")
                .build();
        Envio e15=new Envio("15",LocalDate.of(10,12,1212),LocalDate.of(20,9,1213),r15,p15);
        empresa.agregarEnvio(e15);
        assertEquals(e15,empresa.buscarEnvio(p15.getId()));
    }

    @Test
    void buscarRuta() {
        EmpresaLogistica empresa= EmpresaLogistica.getInstance();
        Ciudad c16=new Ciudad("141","c14",122);
        Ciudad c17=new Ciudad("152","c15",133);
        Ruta r16=new Ruta("21",c16,c17,11111);
        empresa.agregarRuta(r16);
        assertEquals(r16,empresa.buscarRuta(r16.getId()));
    }

    @Test
    void buscarCiudad() {
        EmpresaLogistica empresa= EmpresaLogistica.getInstance();
        Ciudad c17=new Ciudad("131","c13",122);
        empresa.agregarCiudad(c17);
        assertEquals(c17,empresa.buscarCiudad(c17.getId()));
    }
}