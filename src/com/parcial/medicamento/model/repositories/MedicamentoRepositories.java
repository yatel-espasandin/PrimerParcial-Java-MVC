package com.parcial.medicamento.model.repositories;

import com.parcial.interfaces.Repositorio;
import com.parcial.medicamento.model.entities.Medicamento;

import java.util.ArrayList;

public class MedicamentoRepositories implements Repositorio {
    private ArrayList<Medicamento> listMedicamento;

    public MedicamentoRepositories(){
        this.listMedicamento = new ArrayList<>();
    }

    @Override
    public void registrar(Object objeto) {
        this.listMedicamento.add((Medicamento)objeto);
    }

    @Override
    public Object consultar(String id) {
        for(Medicamento med : listMedicamento){
            if(med.getNombre().equalsIgnoreCase(id)){
                return med;
            }
        }
        return null;
    }

    @Override
    public boolean modificar(String id, Object objeto) {
        Object consulta = consultar(id);
        int index = listMedicamento.indexOf(consulta);
        if(consulta!=null){
            this.listMedicamento.add(index, (Medicamento) objeto);
            return true;
        }else
            return false;
    }

    @Override
    public boolean eliminar(Object objeto) {
        if(objeto!=null){
            listMedicamento.remove(objeto);
            return true;
        }else
            return false;
    }
}
