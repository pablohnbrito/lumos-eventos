package br.com.lumus.usuario;

import java.time.LocalDate;
import java.util.List;

import br.com.lumus.Local;
import br.com.lumus.evento.Evento;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String email;

    private LocalDate dataNascimento;

    @OneToOne
    private Local endereco;

    @ManyToMany
    private List<Evento> incricoes;
    
}
