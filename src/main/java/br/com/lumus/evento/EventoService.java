package br.com.lumus.evento;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventoService {

    private final EventoRepository eventoRepository;

    Page<Evento> getAll(Pageable pageable) {
        return eventoRepository.findAll(pageable);
    }

    Evento save(Evento evento) {
        return eventoRepository.save(evento);
    }

    Optional<Evento> findById(int id) {
        return eventoRepository.findById(id);
    }

}
