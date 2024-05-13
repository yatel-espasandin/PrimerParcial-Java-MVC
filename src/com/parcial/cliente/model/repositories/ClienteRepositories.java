package com.parcial.cliente.model.repositories;

import com.parcial.cliente.model.entities.Cliente;
import com.parcial.interfaces.Repositorio;

import java.util.ArrayList;

public class ClienteRepositories implements Repositorio
{
    private ArrayList<Cliente> listCliente;

    public ClienteRepositories(){
        this.listCliente = new ArrayList<>();
    }


    @Override
    public void registrar(Object objeto) {
            listCliente.add((Cliente)objeto);
    }

    @Override
    public Object consultar(String id) {
        for(Cliente clientes : listCliente){
            if(clientes.getNombre().equalsIgnoreCase(id)){
                return clientes;
            }
        }
        return null;
    }

    @Override
    public boolean modificar(String id, Object objeto) {
        Object consulta = consultar(id);
        int index = listCliente.indexOf(consulta);
        if(consulta!=null){
            listCliente.add(index, (Cliente) objeto);
            return true;
        }else
            return false;
    }

    @Override
    public boolean eliminar(Object objeto) {
        if(objeto!=null){
            listCliente.remove(objeto);
            return true;
        }else
            return false;
    }
}
