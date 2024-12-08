package br.com.lumus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Local {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String logradouro;

    private String complemento;

    private String cidade;

    private Estado estado;

}
