package com.parcial.venta.view;

import com.parcial.venta.model.entities.Venta;
import java.util.Scanner;

public class VentaView {

    Scanner scan = new Scanner(System.in);

    public int ventasMenu(){
        System.out.println("""
                1- Generar venta.
                2- Detalle de venta.
                3- Modificar venta.
                4- Eliminar venta.
                5- Salir.
                """);

        System.out.println("Ingrese una opcion.");
        int opcion = scan.nextInt();
        return opcion;
    }

    public Float totalVenta(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el total de la venta: $");
        return scan.nextFloat();
    }

    public void verVentas(Venta ventas){
        System.out.println("Cliente: " + ventas.getCliente().getNombre());
        System.out.println("Total Venta: " + ventas.getTotalVenta());
        System.out.println("Medicamento: " + ventas.getMedicamento());
        System.out.println("Fecha de la venta: " + ventas.getFechaVenta());
    }

    public void mensajes(int numero) {
        switch (numero) {
            case 1:
                System.out.println("Actualizacion exitosa.");
                break;
            case 2:
                System.out.println("Actualizacion invalida.");
                break;
            case 3:
                System.out.println("Opcion invalida.");
                break;
        }
    }

    public Float updateTotalVenta(){
        System.out.println("Ingrese el nuevo monto a asignar: ");
        return scan.nextFloat();
    }
}
