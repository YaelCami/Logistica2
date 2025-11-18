package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.model.Pedido;
import co.edu.uniquindio.poo.logistica2.model.Producto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportadorArchivo {
    public static void exportarPedido(Pedido pedido, String rutaArchivoTxt) throws IOException {
        // Asegurar carpeta existente
        File archivo = new File(rutaArchivoTxt);
        File carpeta = archivo.getParentFile();
        if (carpeta != null && !carpeta.exists()) {
            carpeta.mkdirs();
        }

        FileWriter writer = new FileWriter(archivo);
        writer.write("=========================================\n");
        writer.write("            DETALLE DEL PEDIDO\n");
        writer.write("=========================================\n");
        writer.write("ID Pedido: " + pedido.getId() + "\n");
        writer.write("Fecha de creación: " + pedido.getFechaCreacion() + "\n");
        writer.write("Fecha estimada de entrega: " + pedido.getFechaEstimadaEntrega() + "\n");
        writer.write("Direccion Origen : " + pedido.getOrigen() + "\n");
        writer.write("Direccion Destino : " + pedido.getDestino() + "\n");
        writer.write("Estado : " + pedido.getEstado() + "\n");
        writer.write("-----------------------------------------\n");
        writer.write("INFO DEL USUARIO          \n");
        writer.write("ID Usuario "+ pedido.getUsuario().getId() +"\n");
        writer.write("Nombre Usuario "+ pedido.getUsuario().getNombre()   +"\n");
        writer.write("Correo Usuario "+ pedido.getUsuario().getCorreo() +"\n");

        writer.write(String.format("%-25s %8s %12s\n", "Producto", "Cantidad", "Peso (en kg)"));
        writer.write("-----------------------------------------\n");

        List<Producto> detalles = pedido.getPaquete().getListproductos();
        for (int i = 0; i < detalles.size(); i++) {
            Producto d = detalles.get(i);
            String nombre = d.getNombre();
            int cantidad = d.getCantidad();
            double peso = d.getPeso();
            writer.write(String.format("%-25s %8d %12.2f\n", nombre, cantidad, peso));
        }

        writer.write("-----------------------------------------\n");
        writer.write(String.format("TOTAL: %.2f\n", pedido.getCosto()));
        writer.write("=========================================\n");
        writer.write("-------------servientrega UQ-------------\n");
    }
}
