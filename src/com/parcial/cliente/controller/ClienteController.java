package com.parcial.cliente.controller;

import com.parcial.cliente.model.entities.Cliente;
import com.parcial.cliente.model.repositories.ClienteRepositories;
import com.parcial.cliente.view.ClienteView;

public class ClienteController {
    private ClienteRepositories clienteRepositories;
    private ClienteView clienteView;

    public ClienteController(ClienteRepositories clienteRepositories, ClienteView clienteView) {
        this.clienteRepositories = clienteRepositories;
        this.clienteView = clienteView;
    }

    public void menuControllerCliente(){
        while(true){
            int opcion = clienteView.clienteMenu();
            switch(opcion){
                case 1:
                    agregar();
                    break;
                case 2:
                    printCliente();
                case 3:
                    modificar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    return;
                default:
                    clienteView.mensajes(3);
            }
        }
    }

    public Cliente getCliente(){
        String buscar = clienteView.getByName();
        return (Cliente) clienteRepositories.consultar(buscar);
    }

    public void printCliente(){
        Cliente mostrar = getCliente();
        clienteView.mostrarCliente(mostrar);
    }

    public void agregar(){
        Cliente cliente = clienteView.crearCliente();
        clienteRepositories.registrar(cliente);
    }

    public void modificar(){
        Cliente toUpdate = getCliente();
        String nombre = clienteView.updateNombre();
        String apellido = clienteView.updateApellido();
        String tipoCliente = clienteView.updateTipo();

        Cliente updated = new Cliente(nombre, apellido, tipoCliente);

        boolean check = clienteRepositories.modificar(toUpdate.getNombre(), updated);
        if(!check){
            clienteView.mensajes(2);
        }else
            clienteView.mensajes(1);
    }

    public void eliminar(){
        Cliente delete = (Cliente) getCliente();
        boolean check = clienteRepositories.eliminar(delete);
        if(!check){
            clienteView.mensajes(2);
        }else
            clienteView.mensajes(1);
    }
}
