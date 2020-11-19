package br.com.fiap.BlackSpy.controller;

import br.com.fiap.BlackSpy.domain.Alvo;
import br.com.fiap.BlackSpy.service.AlvoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "Api de Alvos")
@RestController
@RequestMapping("/api/alvo")
public class AlvoController {

    @Autowired
    private AlvoService alvoService;

    @ApiOperation(value = "Cadastra novo alvo e automaticamente cria uma serviço de busca para este alvo")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Alvo cadastar(@RequestBody @Valid Alvo alvo){
        return alvoService.cadastrar(alvo);
    }

    @ApiOperation(value = "Deleta um alvo a partir do id")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        alvoService.deletar(id);
    }

    @ApiOperation(value = "Busca um alvo a partir do id")
    @GetMapping("/{id}")
    public Alvo buscarPeloId(@PathVariable Integer id){
        return alvoService.buscarPeloId(id);
    }
}
