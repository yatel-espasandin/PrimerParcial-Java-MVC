package com.parcial.cliente.model.entities;

import com.parcial.abstractas.Persona;

public class Cliente  extends Persona {
    private String tipoDeCliente;

    public Cliente(String nombre, String apellido, String tipoDeCliente) {
        super(nombre, apellido);
        this.tipoDeCliente = tipoDeCliente;
    }

    public String getTipoDeCliente() {
        return tipoDeCliente;
    }

    public void setTipoDeCliente(String tipoDeCliente) {
        this.tipoDeCliente = tipoDeCliente;
    }

}
