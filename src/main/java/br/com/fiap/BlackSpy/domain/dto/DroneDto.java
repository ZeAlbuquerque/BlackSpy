package br.com.fiap.BlackSpy.domain.dto;

import br.com.fiap.BlackSpy.domain.Base;
import br.com.fiap.BlackSpy.domain.Fabricante;
import br.com.fiap.BlackSpy.domain.enums.TipoDrone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DroneDto {

    private String alias;

    private String modelo;

    private TipoDrone tipo;

    private Integer fabricante;

    private Integer base;

}
