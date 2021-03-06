package br.com.fiap.BlackSpy.domain;

import br.com.fiap.BlackSpy.domain.enums.NivelPericulosidade;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alvo {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column
    private String foto;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NivelPericulosidade nivelPericulosidade;
}
