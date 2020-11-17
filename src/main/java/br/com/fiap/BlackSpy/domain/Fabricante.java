package br.com.fiap.BlackSpy.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Builder
@Table
@Entity
public class Fabricante {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @CNPJ
    @Column(nullable = false, unique = true)
    private String cnpj;


}
