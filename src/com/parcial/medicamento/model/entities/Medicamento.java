package com.parcial.medicamento.model.entities;

public class Medicamento {
    private String nombre;
    private String laboratorio;
    private String categoria;

    private int cantidadEnStock;
    private static int contador;
    private int idMedicamento;

    public Medicamento(String nombre, String laboratorio, String categoria, int cantidadEnStock) {
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.categoria = categoria;
        this.cantidadEnStock = cantidadEnStock;
        this.idMedicamento = ++contador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }
}
