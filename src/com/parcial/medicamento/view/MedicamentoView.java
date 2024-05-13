package com.parcial.medicamento.view;

import com.parcial.medicamento.model.entities.Medicamento;

import java.util.Scanner;

public class MedicamentoView {
    Scanner scan = new Scanner(System.in);

    public int medicamentoMenu(){`
        System.out.println("""
                1- Crear medicamento.
                2- Consultar medicamento.
                3- Modificar medicamento.
                4- Eliminar medicamento.
                5- Salir.
                """);

        System.out.println("Ingrese una opcion.");
        int opcion = scan.nextInt();
        return opcion;
    }

    public void mostrarMedicamento(Medicamento med){
        System.out.println("Nombre " + med.getNombre());
        System.out.println("Laboratorio " + med.getLaboratorio());
        System.out.println("Categoria " + med.getCategoria());
        System.out.println("Cantidad de stock " + med.getCantidadEnStock());
    }

    public Medicamento crearMedicamento(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre del medicamento: ");
        String nombre = scan.nextLine();

        System.out.println("Ingrese el laboratorio que lo produce: ");
        String labo = scan.nextLine();

        System.out.println("Ingrese a la categoria que pertenece: (ej: analgesicos)");
        String cat = scan.nextLine();

        System.out.println("Ingrese la cantidad en stock: ");
        int stock = scan.nextInt();

        return new Medicamento(nombre, labo, cat, stock);
    }
// Se realiza la modularizacion de cada modificacion con fin de generar mayor utlidad, en caso de querer hacer
// modificaciones individuales.
    public String getByName(){
        System.out.println("Ingrese el nombre del medicamento a buscar: ");
        return scan.nextLine();
    }

    public String updateNombre(){
        System.out.println("Ingrese el nuevo nombre a asignar: ");
        return scan.nextLine();
    }

    public String updateLab(){
        System.out.println("Ingrese el nombre del laboratorio: ");
        return scan.nextLine();
    }

    public String updateCat(){
        System.out.println("Ingrese la categoria a asignar: ");
        return scan.nextLine();
    }

    public int updateStock(){
        System.out.println("Ingrese la nueva cantidad de stock: ");
        return scan.nextInt();
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
