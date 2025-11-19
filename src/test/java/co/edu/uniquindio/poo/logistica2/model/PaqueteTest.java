package co.edu.uniquindio.poo.logistica2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaqueteTest {

    @Test
    void agregarProductos() {
        Paquete pa1=new Paquete.Builder()
                .id("1")
                .peso(30)
                .volumen(200)
                .build();
        Producto pr1=new Producto.Builder()
                .nombre("chancla")
                .id("1")
                .build();
        pa1.agregarProductos(pr1);
        assertFalse(pa1.agregarProductos(pr1));
    }

    @Test
    void verificarProducto() {
        Paquete pa1=new Paquete.Builder()
                .id("1")
                .peso(30)
                .volumen(200)
                .build();
        Producto pr1=new Producto.Builder()
                .nombre("chancla")
                .id("1")
                .build();
        pa1.agregarProductos(pr1);
        assertTrue(pa1.verificarProducto(pr1.getId()));
    }

    @Test
    void eliminarProducto() {
        Paquete pa1=new Paquete.Builder()
                .id("1")
                .peso(30)
                .volumen(200)
                .build();
        Producto pr1=new Producto.Builder()
                .nombre("chancla")
                .id("1")
                .build();
        assertFalse(pa1.eliminarProducto(pr1.getId()));
    }

    @Test
    void actualizarProducto() {
        Paquete pa1=new Paquete.Builder()
                .id("1")
                .peso(30)
                .volumen(200)
                .build();
        Producto pr1=new Producto.Builder()
                .nombre("chancla")
                .id("1")
                .build();
        Producto pr2=new Producto.Builder()
                .nombre("chancla")
                .id("13")
                .build();
        pa1.agregarProductos(pr1);
        assertTrue(pa1.actualizarProducto(pr1.getId(),pr2));
    }

    @Test
    void buscarProducto() {
        Paquete pa1=new Paquete.Builder()
                .id("1")
                .peso(30)
                .volumen(200)
                .build();
        Producto pr1=new Producto.Builder()
                .nombre("chancla")
                .id("1")
                .build();
        assertNull(pa1.buscarProducto(pr1.getId()));
    }
}