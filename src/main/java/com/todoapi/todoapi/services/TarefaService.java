package com.todoapi.todoapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapi.todoapi.dtos.TarefaRequestDTO;
import com.todoapi.todoapi.dtos.TarefaResponseDTO;
import com.todoapi.todoapi.mappers.TarefaMapper;
import com.todoapi.todoapi.models.Tarefa;
import com.todoapi.todoapi.models.Usuario;
import com.todoapi.todoapi.repositories.TarefaRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private UsuarioService usuarioService;

    public TarefaResponseDTO criarTarefa(Long usuarioId, TarefaRequestDTO dto) {
        Usuario usuario = usuarioService.buscarEntidadePorId(usuarioId);
        Tarefa tarefa = tarefaRepository.save(new Tarefa(dto.getDescricao(), usuario));
        return TarefaMapper.toDTO(tarefa);
    }

    public List<TarefaResponseDTO> listarTarefasDoUsuario(Long usuarioId) {
        usuarioService.buscarEntidadePorId(usuarioId);
        return tarefaRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(TarefaMapper::toDTO)
                .toList();
    }

    public TarefaResponseDTO avancarEstado(Long usuarioId, Long tarefaId) {
        Tarefa tarefa = buscarTarefaDoUsuario(usuarioId, tarefaId);
        tarefa.avancarEstado();
        return TarefaMapper.toDTO(tarefaRepository.save(tarefa));
    }

    public TarefaResponseDTO atualizarTarefa(Long usuarioId, Long tarefaId, TarefaRequestDTO dto) {
        Tarefa tarefa = buscarTarefaDoUsuario(usuarioId, tarefaId);
        tarefa.setDescricao(dto.getDescricao());
        return TarefaMapper.toDTO(tarefaRepository.save(tarefa));
    }

    public void deletarTarefa(Long usuarioId, Long tarefaId) {
        Tarefa tarefa = buscarTarefaDoUsuario(usuarioId, tarefaId);
        tarefaRepository.delete(tarefa);
    }

    private Tarefa buscarTarefaDoUsuario(Long usuarioId, Long tarefaId) {
        return tarefaRepository.findByIdAndUsuarioId(tarefaId, usuarioId)
                .orElseThrow(() -> new RuntimeException(
                        "Tarefa " + tarefaId + " não encontrada para o usuário " + usuarioId));
    }

}