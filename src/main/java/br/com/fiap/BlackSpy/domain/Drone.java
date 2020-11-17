package br.com.fiap.BlackSpy.domain;

import br.com.fiap.BlackSpy.domain.enums.TipoDrone;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
@Entity
public class Drone {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer id;

    @Column(unique = true,length = 20, nullable = false)
    private String alias;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private TipoDrone tipo;

    @ManyToOne
    @JoinColumn(name = "id_fabricante")
    @JsonIgnore
    private Fabricante fabricante;

    @ManyToOne
    @JoinColumn(name = "id_base")
    @JsonIgnore
    private Base base;

    
}
