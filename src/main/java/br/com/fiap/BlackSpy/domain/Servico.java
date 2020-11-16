package br.com.fiap.BlackSpy.domain;

import br.com.fiap.BlackSpy.domain.enums.TipoServico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servico {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoServico tipo;

    @Column(nullable = false)
    private Calendar dataDespacho;

    @Column(nullable = false)
    private Calendar dataFim;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_drone")
    private Drone drone;

    @ManyToOne
    @JoinColumn(name = "id_alvo")
    private Alvo alvo;
}
