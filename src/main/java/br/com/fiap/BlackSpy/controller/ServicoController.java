package br.com.fiap.BlackSpy.controller;

import br.com.fiap.BlackSpy.domain.Servico;
import br.com.fiap.BlackSpy.domain.dto.ServicoDto;
import br.com.fiap.BlackSpy.service.ServicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "API de servicos(Busca/Neutralizacao)")
@RestController
@RequestMapping("/api/servico")
public class ServicoController {

    @Autowired
    private ServicoService service;

    @ApiOperation(value = "Cadastra uma nova busca de alvo")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico BuscarAlvo(@RequestBody ServicoDto dto){
        return service.buscarAlvo(dto);
    }

    @ApiOperation(value = "Deleta um serviço a partir do Id")
    @PostMapping("/{id}")
    public void deletarServico(@PathVariable Integer id){
        service.cancelarServico(id);
    }

    @ApiOperation(value = "Busca todos os servicos na base")
    @GetMapping("/buscarTodos")
    public List<Servico> buscarTodos(){
        return service.buscarTodos();
    }

    @ApiOperation(value = "Busca um servico a partir do id")
    @GetMapping("/{id}")
    public Servico buscar(@PathVariable Integer id){
        return service.buscarPorId(id);
    }


}
