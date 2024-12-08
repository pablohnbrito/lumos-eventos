package br.com.lumus.usuario;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@Slf4j @RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/usuario")
    Page<Usuario> getAll(Pageable pageable) {
        log.info("Listando usuários");
        return usuarioService.getAll(pageable);
    }
    
    @GetMapping("/usuario/{id}")
    ResponseEntity<Usuario> findById(@PathVariable Long id) {
        return ResponseEntity.of(usuarioService.findById(id));
    }
    
    @PostMapping("/usuario")
    Usuario createUsuario(@RequestBody Usuario usuario) {
       log.info("Usuário criado: {}", usuario);
        return usuarioService.save(usuario);
    }
    

}
