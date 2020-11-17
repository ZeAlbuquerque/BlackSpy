package br.com.fiap.BlackSpy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Base {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 20, unique = true)
    private String alias;

    @Column(nullable = false)
    private Integer capacidade;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private String bairoo;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;
}
