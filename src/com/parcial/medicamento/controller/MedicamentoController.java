package com.parcial.medicamento.controller;

import com.parcial.medicamento.model.entities.Medicamento;
import com.parcial.medicamento.model.repositories.MedicamentoRepositories;
import com.parcial.medicamento.view.MedicamentoView;

public class MedicamentoController {
    private MedicamentoRepositories medicamentoRepositories;
    private MedicamentoView medicamentoView;

    public MedicamentoController(MedicamentoRepositories medicamentoRepositories, MedicamentoView medicamentoView) {
        this.medicamentoRepositories = medicamentoRepositories;
        this.medicamentoView = medicamentoView;
    }


    public void MedicamentoControllerMenu(){
        while(true){
            int opcion = medicamentoView.medicamentoMenu();
            switch(opcion){
                case 1:
                    agregar();
                    break;
                case 2:
                    printMedicamento();
                case 3:
                    updateMedicamento();
                    break;
                case 4:
                    deleteMedicamento();
                    break;
                case 5:
                    return;
                default:
                    medicamentoView.mensajes(3);
            }
        }
    }

    public void agregar(){
        Medicamento agregar = medicamentoView.crearMedicamento();
        medicamentoRepositories.registrar(agregar);
    }

    public void printMedicamento(){
        Medicamento mostrar = getMedicamento();
        medicamentoView.mostrarMedicamento(mostrar);
    }

    public Medicamento getMedicamento(){
        String buscar = medicamentoView.getByName();
        return (Medicamento) medicamentoRepositories.consultar(buscar);
    }

    public void updateMedicamento(){
        Medicamento toUpdate = getMedicamento();
        String nombre = medicamentoView.updateNombre();
        String labo = medicamentoView.updateLab();
        String cat = medicamentoView.updateCat();
        int stock = medicamentoView.updateStock();

        Medicamento updated = new Medicamento(nombre, labo, cat, stock);

        boolean check = medicamentoRepositories.modificar(toUpdate.getNombre(), updated);
        if(!check){
            medicamentoView.mensajes(2);
        }else
            medicamentoView.mensajes(1);
    }

    public void deleteMedicamento(){
        Medicamento delete = getMedicamento();
        boolean check = medicamentoRepositories.eliminar(delete);
        if(!check){
            medicamentoView.mensajes(2);
        }else
            medicamentoView.mensajes(1);
    }
}
