package co.edu.uniquindio.poo.logistica2.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void calcularCostoPedido() {
        Ciudad c1=new Ciudad("23","c1",122);
        Ciudad c2=new Ciudad("22","c2",133);
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

        Pedido p2=new Pedido("1", LocalDate.of(2025,11,18),dO,dL,u1,LocalDate.of(2025,11,29),pa1);
        Ruta r1=new Ruta("21",c1,c2,10);
        p2.setRuta(r1);
        assertNotEquals(10000,p2.calcularCostoPedido());
    }

    @Test
    void puedePedir() {
        Ciudad c1=new Ciudad("23","c1",122);
        Ciudad c2=new Ciudad("22","c2",133);
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
        Pedido p2=new Pedido("1", LocalDate.of(2025,11,18),dO,dL,u1,LocalDate.of(2025,11,29),pa1);
        assertNull(p2.puedePedir(dO,dL));
    }

    @Test
    void calcularFechaEstimadaEntrega() {
        Ciudad c1=new Ciudad("23","c1",122);
        Ciudad c2=new Ciudad("22","c2",133);
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
        Pedido p2=new Pedido("1", LocalDate.of(2025,11,18),dO,dL,u1,LocalDate.of(2025,11,29),pa1);
        Ruta r1=new Ruta("21",c1,c2,10);
        assertEquals(LocalDate.of(2025,11,23),p2.calcularFechaEstimadaEntrega(LocalDate.of(2025,11,18),r1));
    }
}