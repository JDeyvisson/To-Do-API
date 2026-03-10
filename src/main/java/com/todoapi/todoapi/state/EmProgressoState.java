package com.todoapi.todoapi.state;

public class EmProgressoState implements TarefaState {

    @Override
    public String getNome() {
        return "EM_PROGRESSO";
    }

    @Override
    public TarefaState avancar() {
        return new ConcluidaState();
    }

}