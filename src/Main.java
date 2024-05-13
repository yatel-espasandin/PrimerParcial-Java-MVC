import com.parcial.cliente.controller.ClienteController;

import com.parcial.cliente.model.repositories.ClienteRepositories;
import com.parcial.cliente.view.ClienteView;
import com.parcial.medicamento.controller.MedicamentoController;

import com.parcial.medicamento.model.repositories.MedicamentoRepositories;
import com.parcial.medicamento.view.MedicamentoView;
import com.parcial.venta.controller.VentaController;
import com.parcial.venta.model.repositories.VentaRepositories;
import com.parcial.venta.view.VentaView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    ClienteView clienteView = new ClienteView();
    ClienteRepositories clienteRepositories = new ClienteRepositories();
    MedicamentoView medicamentoView = new MedicamentoView();
    MedicamentoRepositories medicamentoRepositories = new MedicamentoRepositories();
    VentaView ventaView = new VentaView();
    VentaRepositories ventaRepositories = new VentaRepositories();

    Scanner scan = new Scanner(System.in);

    ClienteController clienteController = new ClienteController(clienteRepositories, clienteView);
    MedicamentoController medicamentoController = new MedicamentoController(medicamentoRepositories, medicamentoView);
    VentaController ventacontroller = new VentaController(clienteRepositories, clienteView, medicamentoRepositories, medicamentoView, ventaRepositories, ventaView);
    mainMenu(clienteController, medicamentoController, ventacontroller);
    }

    public static void mainMenu(ClienteController clienteController,MedicamentoController medicamentoController,VentaController ventacontroller){
        Scanner scan = new Scanner(System.in);
        System.out.println("""
                MENU PRINCIPAL
                1- MENU VENTAS.
                2- MENU CLIENTES.
                3_ MENU MEDICAMENTOS.
                4- SALIR.
                """);
        System.out.println("Ingrese una opcion.");
        int opcion = scan.nextInt();
        switch(opcion){
            case 1:
                ventacontroller.ventaControllerMenu();
                break;
            case 2:
                clienteController.menuControllerCliente();
                break;
            case 3:
                medicamentoController.MedicamentoControllerMenu();
                break;
            case 4:
                return;
            default:
                System.out.println("Opcion invalida.");
        }
    }
}