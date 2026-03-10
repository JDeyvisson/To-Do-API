package com.todoapi.todoapi.models;

public class Tarefa {
    
    private String descricao;
    private boolean feito = false;

    public Tarefa(String descricao){
        this.descricao = descricao;
    }
    public String getDescrição() {
        return descricao;
    }
    public void setDescrição(String descrição) {
        this.descricao = descrição;
    }
    public boolean isFeito() {
        return feito;
    }
    public void setFeito(boolean feito) {
        this.feito = feito;
    }

    

}
