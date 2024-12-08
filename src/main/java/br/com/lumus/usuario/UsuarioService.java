package br.com.lumus.usuario;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    Page<Usuario> getAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

}
