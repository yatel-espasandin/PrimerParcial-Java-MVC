package com.parcial.venta.model.repositories;

import com.parcial.interfaces.Repositorio;
import com.parcial.venta.model.entities.Venta;

import java.util.ArrayList;

public class VentaRepositories implements Repositorio {
    private ArrayList<Venta> listVenta;

    public VentaRepositories(){
        this.listVenta = new ArrayList<>();
    }

    @Override
    public void registrar(Object objeto) {
        this.listVenta.add((Venta)objeto);
    }

    @Override
    public Object consultar(String id) {
        for (Venta ventas : listVenta) {
            if (ventas.getCliente().getNombre().equalsIgnoreCase(id)) {
                return ventas;
            }
        }
        return null;
    }

    @Override
    public boolean modificar(String id, Object objeto) {
        Venta consultar = (Venta) consultar(id);
        int index = listVenta.indexOf(objeto);
        if(consultar!=null){
            listVenta.add(index, (Venta) objeto);
            return true;
        }else
            return false;
    }

    @Override
    public boolean eliminar(Object objeto) {
        if(objeto!=null){
            listVenta.remove(objeto);
            return true;
        }else
            return false;
    }
}
