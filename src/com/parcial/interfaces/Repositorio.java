package com.parcial.interfaces;

public interface Repositorio {
    void registrar(Object objeto);
    Object consultar(String id);
    boolean modificar(String id, Object objeto);
    boolean eliminar(Object objeto);
}
