package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.model.Pedido;
import co.edu.uniquindio.poo.logistica2.model.Producto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportadorArchivo {

    public static void exportarPedido(Pedido pedido, String rutaArchivoTxt) throws IOException {
        File archivo = new File(rutaArchivoTxt);
        File carpeta = archivo.getParentFile();
        if (carpeta != null && !carpeta.exists()) {
            carpeta.mkdirs();
        }

        try (FileWriter writer = new FileWriter(archivo)) {

            writer.write("=========================================\n");
            writer.write("            DETALLE DEL PEDIDO\n");
            writer.write("=========================================\n");

            writer.write(String.format("ID Pedido: %s\n", pedido.getId()));
            writer.write(String.format("Fecha de creación: %s\n", pedido.getFechaCreacion()));
            writer.write(String.format("Fecha estimada de entrega: %s\n", pedido.getFechaEstimadaEntrega()));
            writer.write(String.format("Estado: %s\n\n", pedido.getEstado()));

            // ------- DIRECCIÓN ORIGEN --------
            writer.write("Direccion Origen:\n");
            writer.write(pedido.getOrigen().toString());
            writer.write("\n\n");

            // ------- DIRECCIÓN DESTINO --------
            writer.write("Direccion Destino:\n");
            writer.write(pedido.getDestino().toString());
            writer.write("\n\n");

            writer.write("-----------------------------------------\n");
            writer.write("INFO DEL USUARIO\n");
            writer.write(String.format("ID Usuario: %s\n", pedido.getUsuario().getId()));
            writer.write(String.format("Nombre Usuario: %s\n", pedido.getUsuario().getNombre()));
            writer.write(String.format("Correo Usuario: %s\n\n", pedido.getUsuario().getCorreo()));

            // ------- TABLA DE PRODUCTOS --------
            writer.write("PRODUCTOS DEL PAQUETE\n");
            writer.write(String.format("%-25s %-10s %-12s\n", "Producto", "Cantidad", "Peso (kg)"));
            writer.write("-----------------------------------------\n");

            for (Producto d : pedido.getPaquete().getListproductos()) {
                writer.write(String.format(
                        "%-25s %-10d %-12.2f\n",
                        d.getNombre(),
                        d.getCantidad(),
                        d.getPeso()
                ));
            }

            writer.write("-----------------------------------------\n");
            writer.write(String.format("TOTAL A PAGAR: %.2f\n", pedido.getCosto()));
        }
    }
}

