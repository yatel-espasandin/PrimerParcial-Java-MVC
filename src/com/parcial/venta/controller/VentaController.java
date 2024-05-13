package com.parcial.venta.controller;

import com.parcial.cliente.model.entities.Cliente;
import com.parcial.cliente.model.repositories.ClienteRepositories;
import com.parcial.cliente.view.ClienteView;
import com.parcial.interfaces.IVenta;
import com.parcial.medicamento.model.entities.Medicamento;
import com.parcial.medicamento.model.repositories.MedicamentoRepositories;
import com.parcial.medicamento.view.MedicamentoView;
import com.parcial.venta.model.entities.Venta;
import com.parcial.venta.model.repositories.VentaRepositories;
import com.parcial.venta.view.VentaView;

import java.util.Scanner;

public class VentaController implements IVenta {
    ClienteRepositories clienteRepositories;
    ClienteView clienteView;
    MedicamentoRepositories medicamentoRepositories;
    MedicamentoView medicamentoView;
    VentaRepositories ventaRepositories;
    VentaView ventaView;

    Scanner scan = new Scanner(System.in);

    public VentaController(ClienteRepositories clienteRepositories, ClienteView clienteView,
                           MedicamentoRepositories medicamentoRepositories, MedicamentoView medicamentoView, VentaRepositories ventaRepositories, VentaView ventaView) {
        this.clienteRepositories = clienteRepositories;
        this.clienteView = clienteView;
        this.medicamentoRepositories = medicamentoRepositories;
        this.medicamentoView = medicamentoView;
        this.ventaRepositories = ventaRepositories;
        this.ventaView = ventaView;
    }

    public void ventaControllerMenu(){
        while(true){
            int opcion = ventaView.ventasMenu();
            switch(opcion){
                case 1:
                    agregarVenta();
                    break;
                case 2:
                    detallesVenta();
                    break;
                case 3:
                    updateVenta();
                    break;
                case 4:
                    eliminarVenta();
                    break;
                case 5:
                    return;
                default:
                    ventaView.mensajes(3);
                    break;
            }
    }
    }

    public Object getVenta() {
        String buscar = clienteView.getByName();
        return ventaRepositories.consultar(buscar);
    }

    public Venta generarVentaTotal(){
        Cliente nuevoCliente = clienteView.crearCliente();
        clienteRepositories.registrar(nuevoCliente);
        Medicamento nuevoMedicamento = medicamentoView.crearMedicamento();
        medicamentoRepositories.registrar(nuevoMedicamento);

        Float totalVenta = ventaView.totalVenta();

        return new Venta (nuevoCliente, nuevoMedicamento, totalVenta);
    }

    @Override
    public Object generarVenta() {
        String nombreCliente = clienteView.getByName();
        Object cBuscado = clienteRepositories.consultar(nombreCliente);
        if(cBuscado!=null){
            String nombreMedicamento = medicamentoView.getByName();
            Object mBuscado = medicamentoRepositories.consultar(nombreMedicamento);
            if(mBuscado!=null){
                Float totalVenta = ventaView.totalVenta();
                return new Venta((Cliente) cBuscado, (Medicamento) mBuscado, totalVenta);
            }
        }else {
            return generarVentaTotal();
        }
        return null;
    }

    public void agregarVenta(){
        Venta registrar = (Venta) generarVenta();
        ventaRepositories.registrar(registrar);
    }

    @Override
    public void detallesVenta() {
        Venta detallar = (Venta) getVenta();
        ventaView.verVentas(detallar);
    }

    public void updateVenta(){
        Venta toUpdate = (Venta) getVenta();
        Float nuevoTotal = ventaView.totalVenta();
        toUpdate.setTotalVenta(nuevoTotal);
        boolean check = ventaRepositories.modificar(toUpdate.getCliente().getNombre(), toUpdate);

        if(!check){
            ventaView.mensajes(2);
        }else
            ventaView.mensajes(1);
    }

    @Override
    public void eliminarVenta() {
        Venta delete = (Venta) getVenta();
        boolean check = ventaRepositories.eliminar(delete);
        if(!check){
            ventaView.mensajes(2);
        }else
            ventaView.mensajes(1);
    }
}
