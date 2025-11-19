package co.edu.uniquindio.poo.logistica2.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AdministradorTest {

    @Test
    void buscarRepartidorRutaDisponible() {
        Administrador a1=new Administrador.Builder()
                .nombre("Juan")
                .salario(3000)
                .build();
        Ciudad c1=new Ciudad("23","c1",122);
        Ciudad c2=new Ciudad("22","c2",133);
        Ruta r1=new Ruta("21",c1,c2,11111);
        Repartidor p1=new Repartidor.Builder()
                .nombre("Ema")
                .disponibilidad(Disponibilidad.ENRUTA)
                .build();
        a1.agregarRuta(r1);
        a1.agregarPersona(p1);
        assertNull(a1.buscarRepartidorRutaDisponible(r1));
    }

    @Test
    void cambiarDisponibilidadEnRuta() {
        Administrador a2=new Administrador.Builder()
                .nombre("Juan")
                .salario(3000)
                .build();
        Repartidor p1=new Repartidor.Builder()
                .nombre("Raul")
                .disponibilidad(Disponibilidad.ACTIVO)
                .build();
        a2.cambiarDisponibilidadEnRuta(p1);
        assertTrue(Disponibilidad.ENRUTA==p1.getDisponibilidad());
    }

    @Test
    void cambiarDisponibilidadActivo() {
        Administrador a3=new Administrador.Builder()
                .nombre("Juan")
                .salario(3000)
                .build();
        Repartidor p1=new Repartidor.Builder()
                .nombre("Yael")
                .disponibilidad(Disponibilidad.INACTIVO)
                .build();
        a3.cambiarDisponibilidadActivo(p1);
        assertFalse(Disponibilidad.ACTIVO==p1.getDisponibilidad());
    }

    @Test
    void cambiarDisponibilidadInactivo() {
    }

    @Test
    void buscarPedidosRuta() {
        Administrador a3=new Administrador.Builder()
                .nombre("Juan")
                .salario(3000)
                .build();
        Ciudad c1=new Ciudad("23","c1",122);
        Ciudad c2=new Ciudad("22","c2",133);
        Direccion dO=new Direccion("1","Hola","Avenida quensinton",c1,"Coordenadas");
        Direccion dL=new Direccion("2","Bye","Almanaque del futuro",c2,"Coordenadas#2");
        Usuario u1=new Usuario.Builder()
                .nombre("Ben")
                .build();
        Paquete p1=new Paquete.Builder()
                .id("2")
                .peso(11)
                .volumen(232)
                .build();
        Ruta r2=new Ruta("21",c1,c2,11111);
        Pedido p2=new Pedido("1", LocalDate.of(2025,11,18),dO,dL,u1,LocalDate.of(2025,11,29),p1);
        p2.setRuta(r2);
        a3.agregarCiudad(c1);
        a3.agregarCiudad(c2);
        a3.agregarPersona(u1);
        a3.agregarRuta(r2);
        assertEquals(p2,a3.buscarPedidosRuta(r2));
    }

    @Test
    void agregarEnvio() {
        Administrador a4=new Administrador.Builder()
                .nombre("Juan")
                .salario(3000)
                .build();
        Ciudad c1=new Ciudad("23","c1",122);
        Ciudad c2=new Ciudad("22","c2",133);
        Ruta r1=new Ruta("21",c1,c2,11111);
        Repartidor p5=new Repartidor.Builder()
                .nombre("Mike")
                .build();
        Envio e1=new Envio("5",LocalDate.of(2025,11,18),LocalDate.of(2025,12,1),r1,p5);
        assertTrue(a4.agregarEnvio(e1));
    }
}

