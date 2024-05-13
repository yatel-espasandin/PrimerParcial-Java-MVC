package com.parcial.venta.model.entities;

import com.parcial.cliente.model.entities.Cliente;
import com.parcial.medicamento.model.entities.Medicamento;

import java.time.LocalDate;

public class Venta{
    private Cliente cliente;
    private static int contador;
    private Integer id;
    private LocalDate fechaVenta;
    private Medicamento medicamento;
    private Float totalVenta;

    public Venta(Cliente cliente, Medicamento medicamento, Float totalVenta) {
        this.cliente = cliente;
        this.id = ++contador;
        this.fechaVenta = LocalDate.now();
        this.medicamento = medicamento;
        this.totalVenta = totalVenta;
    }

    //TODO gestionar la fecha de la venta con LocalDate

    public Float getTotalVenta() {
        return totalVenta;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public Integer getId() {
        return id;
    }

    public static int getContador() {
        return contador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setTotalVenta(Float totalVenta) {
        this.totalVenta = totalVenta;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
