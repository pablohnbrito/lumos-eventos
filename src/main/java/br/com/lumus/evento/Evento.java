package br.com.lumus.evento;

import java.time.LocalDateTime;
import java.util.List;

import br.com.lumus.Local;
import br.com.lumus.usuario.Usuario;
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
public class Evento {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String titulo;

    private String descricao;

    private long lotacao;

    private LocalDateTime realizacaoInicio;

    private LocalDateTime realizacaoFim;

    @OneToOne
    private Local local;

    @ManyToMany
    private List<Usuario> inscritos;

}
