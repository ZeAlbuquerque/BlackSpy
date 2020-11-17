package br.com.fiap.BlackSpy.domain;

import br.com.fiap.BlackSpy.domain.enums.StatusServico;
import br.com.fiap.BlackSpy.domain.enums.TipoServico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Servico {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoServico tipo;

    @Column(nullable = false)
    private Calendar dataDespacho;

    @Column(nullable = false)
    private Calendar dataFim;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusServico statusServico;

    @ManyToOne
    @JoinColumn(name = "id_drone")
    private Drone drone;

    @ManyToOne
    @JoinColumn(name = "id_alvo")
    private Alvo alvo;
}
