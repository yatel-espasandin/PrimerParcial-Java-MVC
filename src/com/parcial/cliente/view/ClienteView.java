package com.parcial.cliente.view;

import com.parcial.cliente.model.entities.Cliente;

import java.util.Scanner;

public class ClienteView {

    Scanner scan = new Scanner(System.in);

    public int clienteMenu(){
        System.out.println("""
                1- Crear cliente.
                2- Consultar cliente.
                3- Modificar cliente.
                4- Eliminar cliente.
                5- Salir.
                """);
        System.out.println("Ingrese una opcion.");
        int opcion = scan.nextInt();
        return opcion;
    }

    public void mostrarCliente(Cliente cliente){
        System.out.println("Nombre " + cliente.getNombre());
        System.out.println("Apellido " + cliente.getApellido());
        System.out.println("Tipo de cliente " + cliente.getTipoDeCliente());
    }

    public Cliente crearCliente(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre: ");
        String nombre = scan.nextLine();

        System.out.println("Ingrese el apellido: ");
        String apellido = scan.nextLine();

        System.out.println("Ingrese el tipo de cliente: (recurrent, no recurrente)");
        String tipoCliente = scan.nextLine();

        return new Cliente(nombre, apellido, tipoCliente);
    }

    public String getByName(){
        System.out.println("Ingrese el nombre del cliente que desea buscar: ");
        return scan.nextLine();
    }

    public String updateNombre(){
        System.out.println("Ingrese el nuevo nombre a asignar: ");
        return scan.nextLine();
    }

    public String updateApellido(){
        System.out.println("Ingrese el nuevo apellido a asignar: ");
        return scan.nextLine();
    }

    public String updateTipo(){
        System.out.println("Ingrese el tipo de cliente a asingar: ");
        return scan.nextLine();
    }

    public void mensajes(int numero){
        switch(numero){
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
}
