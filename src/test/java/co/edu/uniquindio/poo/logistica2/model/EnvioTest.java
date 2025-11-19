package co.edu.uniquindio.poo.logistica2.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EnvioTest {

    @Test
    void calcularCosto() {
    }

    @Test
    void cambiarEstado() {
    }

    @Test
    void ejecutarAccion() {
    }

    @Test
    void asignar() {
    }

    @Test
    void enRuta() {
    }

    @Test
    void entregar() {
    }

    @Test
    void reportarIncidencia() {
    }

    @Test
    void agregarObservador() {
        Ciudad c1=new Ciudad("23","c1",122);
        Ciudad c2=new Ciudad("22","c2",133);
        Ruta r1=new Ruta("21",c1,c2,11111);
        Repartidor re1=new Repartidor.Builder()
                .id("2")
                .nombre("w")
                .build();
        Envio e1=new Envio("2", LocalDate.of(10,12,1212),LocalDate.of(20,9,1213),r1,re1);
        Usuario u1=new Usuario.Builder()
                .nombre("Ben")
                .build();
        e1.agregarObservador(u1);
        int h=e1.getListObservadores().size();
        int o=e1.getListObservadores().size();
        assertTrue(h==o);
    }

    @Test
    void eliminarObservador() {
        Ciudad c1=new Ciudad("23","c1",122);
        Ciudad c2=new Ciudad("22","c2",133);
        Ruta r1=new Ruta("21",c1,c2,11111);
        Repartidor re1=new Repartidor.Builder()
                .id("2")
                .nombre("w")
                .build();
        Envio e1=new Envio("2", LocalDate.of(10,12,1212),LocalDate.of(20,9,1213),r1,re1);
        Usuario u1=new Usuario.Builder()
                .nombre("Ben")
                .build();
        e1.agregarObservador(u1);
        int h=e1.getListObservadores().size();
        e1.eliminarObservador(u1);
        int o=e1.getListObservadores().size();
        assertFalse(h==o);
    }

    @Test
    void notificarObservador() {
    }

    @Test
    void calcularFechaEstimadaEntrega() {
    }

    @Test
    void revisarFechaInicio() {
    }

    @Test
    void agregarPedido() {
        Ciudad c1=new Ciudad("23","c1",122);
        Ciudad c2=new Ciudad("22","c2",133);
        Ruta r1=new Ruta("21",c1,c2,11111);
        Repartidor re1=new Repartidor.Builder()
                .id("2")
                .nombre("w")
                .build();
        Direccion dO=new Direccion("1","Hola","Avenida quensinton",c1,"Coordenadas");
        Direccion dL=new Direccion("2","Bye","Almanaque del futuro",c2,"Coordenadas#2");
        Usuario u1=new Usuario.Builder()
                .nombre("Ben")
                .build();
        Paquete pa1=new Paquete.Builder()
                .id("2")
                .peso(11)
                .volumen(232)
                .build();
        Envio e1=new Envio("2", LocalDate.of(10,12,1212),LocalDate.of(20,9,1213),r1,re1);
        Pedido p2=new Pedido("1", LocalDate.of(2025,11,18),dO,dL,u1,LocalDate.of(2025,11,29),pa1);
        assertFalse(e1.agregarPedido(p2));
    }

    @Test
    void verificarPedido() {
        Ciudad c1=new Ciudad("23","c1",122);
        Ciudad c2=new Ciudad("22","c2",133);
        Ruta r1=new Ruta("21",c1,c2,11111);
        Repartidor re1=new Repartidor.Builder()
                .id("2")
                .nombre("w")
                .build();
        Direccion dO=new Direccion("1","Hola","Avenida quensinton",c1,"Coordenadas");
        Direccion dL=new Direccion("2","Bye","Almanaque del futuro",c2,"Coordenadas#2");
        Usuario u1=new Usuario.Builder()
                .nombre("Ben")
                .build();
        Paquete pa1=new Paquete.Builder()
                .id("2")
                .peso(11)
                .volumen(232)
                .build();
        Envio e1=new Envio("2", LocalDate.of(10,12,1212),LocalDate.of(20,9,1213),r1,re1);
        Pedido p2=new Pedido("1", LocalDate.of(2025,11,18),dO,dL,u1,LocalDate.of(2025,11,29),pa1);
        e1.agregarPedido(p2);
        assertTrue(e1.verificarPedido(p2.getId()));
    }

    @Test
    void eliminarPedido() {
        Ciudad c1=new Ciudad("23","c1",122);
        Ciudad c2=new Ciudad("22","c2",133);
        Ruta r1=new Ruta("21",c1,c2,11111);
        Repartidor re1=new Repartidor.Builder()
                .id("2")
                .nombre("w")
                .build();
        Direccion dO=new Direccion("1","Hola","Avenida quensinton",c1,"Coordenadas");
        Direccion dL=new Direccion("2","Bye","Almanaque del futuro",c2,"Coordenadas#2");
        Usuario u1=new Usuario.Builder()
                .nombre("Ben")
                .build();
        Paquete pa1=new Paquete.Builder()
                .id("2")
                .peso(11)
                .volumen(232)
                .build();
        Envio e1=new Envio("2", LocalDate.of(10,12,1212),LocalDate.of(20,9,1213),r1,re1);
        Pedido p2=new Pedido("1", LocalDate.of(2025,11,18),dO,dL,u1,LocalDate.of(2025,11,29),pa1);
        e1.agregarPedido(p2);
        assertTrue(e1.eliminarPedido(p2.getId()));
    }

    @Test
    void actualizarPedido() {
        Ciudad c1=new Ciudad("23","c1",122);
        Ciudad c2=new Ciudad("22","c2",133);
        Ruta r1=new Ruta("21",c1,c2,11111);
        Repartidor re1=new Repartidor.Builder()
                .id("2")
                .nombre("w")
                .build();
        Direccion dO=new Direccion("1","Hola","Avenida quensinton",c1,"Coordenadas");
        Direccion dL=new Direccion("2","Bye","Almanaque del futuro",c2,"Coordenadas#2");
        Usuario u1=new Usuario.Builder()
                .nombre("Ben")
                .build();
        Paquete pa1=new Paquete.Builder()
                .id("2")
                .peso(11)
                .volumen(232)
                .build();
        Envio e1=new Envio("2", LocalDate.of(10,12,1212),LocalDate.of(20,9,1213),r1,re1);
        Pedido p2=new Pedido("1", LocalDate.of(2025,11,18),dO,dL,u1,LocalDate.of(2025,11,29),pa1);
        Pedido pA=new Pedido("12", LocalDate.of(2025,11,18),dO,dL,u1,LocalDate.of(2025,11,29),pa1);
        assertFalse(e1.actualizarPedido(p2.getId(),pA));
    }

    @Test
    void buscarPedido() {
        Ciudad c1=new Ciudad("23","c1",122);
        Ciudad c2=new Ciudad("22","c2",133);
        Ruta r1=new Ruta("21",c1,c2,11111);
        Repartidor re1=new Repartidor.Builder()
                .id("2")
                .nombre("w")
                .build();
        Direccion dO=new Direccion("1","Hola","Avenida quensinton",c1,"Coordenadas");
        Direccion dL=new Direccion("2","Bye","Almanaque del futuro",c2,"Coordenadas#2");
        Usuario u1=new Usuario.Builder()
                .nombre("Ben")
                .build();
        Paquete pa1=new Paquete.Builder()
                .id("2")
                .peso(11)
                .volumen(232)
                .build();
        Envio e1=new Envio("2", LocalDate.of(10,12,1212),LocalDate.of(20,9,1213),r1,re1);
        Pedido p2=new Pedido("1", LocalDate.of(2025,11,18),dO,dL,u1,LocalDate.of(2025,11,29),pa1);
        e1.agregarPedido(p2);
        assertEquals(p2,e1.buscarPedido(p2.getId()));
    }
}