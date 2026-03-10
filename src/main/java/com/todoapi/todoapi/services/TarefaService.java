package com.todoapi.todoapi.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.todoapi.todoapi.models.Tarefa;

@Service
public class TarefaService {

    private ArrayList<Tarefa> tarefas;

    public void criarTarefa(String descricao){

        Tarefa tarefa = new Tarefa("Estudar programação");
        tarefas.add(tarefa);

    }

    public void deletarTarefa(Tarefa tarefa){

        if(!tarefas.isEmpty()){
            tarefas.remove(tarefa);
        }

    }

    public void marcarTarefa(Tarefa tarefa){

        if(tarefa.isFeito() == true){
            tarefa.setFeito(false);
        }else{
            tarefa.setFeito(true);
        }

    }
    

    public ArrayList<Tarefa> verTarefas(){
        
        return this.tarefas;

    }

    public void atualizarTarefa(Tarefa taref, String descricao){

        for (Tarefa tarefa : tarefas) {
            if(tarefa == taref){

                tarefa.setDescrição(descricao);

            }
        }

    }
}
