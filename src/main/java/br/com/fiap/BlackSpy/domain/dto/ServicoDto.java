package br.com.fiap.BlackSpy.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicoDto {

    private String tipo;

    private Calendar dataDespacho;

    private Calendar dataFim;

    private Integer drone;

    private Integer alvo;
}
