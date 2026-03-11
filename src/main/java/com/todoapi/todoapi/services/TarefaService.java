package com.todoapi.todoapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapi.todoapi.models.Tarefa;
import com.todoapi.todoapi.models.Usuario;

@Service
public class TarefaService {

    private ArrayList<Tarefa> tarefas = new ArrayList<>();

    @Autowired
    private UsuarioService usuarioService;

    public Tarefa criarTarefa(int usuarioId, String descricao) {
        Usuario usuario = usuarioService.buscarPorId(usuarioId);

        Tarefa tarefa = new Tarefa(descricao, usuarioId);
        tarefas.add(tarefa);
        usuario.adicionarTarefa(tarefa);
        return tarefa;
    }

    public void deletarTarefa(int usuarioId, int tarefaId) {
        Usuario usuario = usuarioService.buscarPorId(usuarioId);
        Tarefa tarefa = buscarTarefaDoUsuario(usuarioId, tarefaId);

        tarefas.removeIf(t -> t.getId() == tarefaId);
        usuario.removerTarefa(tarefa);
    }

    public Tarefa avancarEstado(int usuarioId, int tarefaId) {
        Tarefa tarefa = buscarTarefaDoUsuario(usuarioId, tarefaId);
        tarefa.avancarEstado();
        return tarefa;
    }

    public List<Tarefa> listarTarefasDoUsuario(int usuarioId) {

        usuarioService.buscarPorId(usuarioId);
        return tarefas.stream()
                .filter(t -> t.getUsuarioId() == usuarioId)
                .toList();
    }

    public Tarefa atualizarTarefa(int usuarioId, int tarefaId, String descricao) {
        Tarefa tarefa = buscarTarefaDoUsuario(usuarioId, tarefaId);
        tarefa.setDescricao(descricao);
        return tarefa;
    }


    private Tarefa buscarTarefaDoUsuario(int usuarioId, int tarefaId) {
        return tarefas.stream()
                .filter(t -> t.getId() == tarefaId && t.getUsuarioId() == usuarioId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        "Tarefa " + tarefaId + " não encontrada para o usuário " + usuarioId));
    }

}