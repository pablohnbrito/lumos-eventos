package br.com.lumus.evento;

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
public class EventoController {

    private final EventoService eventoService;

    @GetMapping("/evento")
    Page<Evento> getAll(Pageable pageable) {
        log.info("Listando eventos");
        return eventoService.getAll(pageable);
    }
    
    @GetMapping("/evento/{id}")
    public ResponseEntity<Evento> findById(@PathVariable("id") int id) {
        return ResponseEntity.of(eventoService.findById(id));
    }

    @PostMapping("/evento")
    public Evento createEvento(@RequestBody Evento evento) {
        log.info(evento.toString());
        return eventoService.save(evento);
    }
    
}
