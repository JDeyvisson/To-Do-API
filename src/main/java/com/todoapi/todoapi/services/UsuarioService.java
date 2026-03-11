package com.todoapi.todoapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapi.todoapi.dtos.UsuarioRequestDTO;
import com.todoapi.todoapi.dtos.UsuarioResponseDTO;
import com.todoapi.todoapi.mappers.UsuarioMapper;
import com.todoapi.todoapi.models.Usuario;
import com.todoapi.todoapi.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto) {
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Já existe um usuário com o e-mail: " + dto.getEmail());
        }
        Usuario salvo = usuarioRepository.save(new Usuario(dto.getNome(), dto.getEmail()));
        return UsuarioMapper.toDTO(salvo);
    }

    public List<UsuarioResponseDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toDTO)
                .toList();
    }

    public Usuario buscarEntidadePorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + id));
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        return UsuarioMapper.toDTO(buscarEntidadePorId(id));
    }

    public UsuarioResponseDTO atualizarUsuario(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = buscarEntidadePorId(id);
        if (dto.getNome() != null && !dto.getNome().isBlank()) usuario.setNome(dto.getNome());
        if (dto.getEmail() != null && !dto.getEmail().isBlank()) usuario.setEmail(dto.getEmail());
        return UsuarioMapper.toDTO(usuarioRepository.save(usuario));
    }

    public void deletarUsuario(Long id) {
        buscarEntidadePorId(id); 
        usuarioRepository.deleteById(id);
    }

}