package br.com.fiap.BlackSpy.controller;

import br.com.fiap.BlackSpy.domain.Servico;
import br.com.fiap.BlackSpy.domain.dto.ServicoDto;
import br.com.fiap.BlackSpy.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servico")
public class ServicoController {

    @Autowired
    private ServicoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico BuscarAlvo(@RequestBody ServicoDto dto){
        return service.buscarAlvo(dto);
    }

    @PostMapping("/{id}")
    public void deletarServico(@PathVariable Integer id){
        service.cancelarServico(id);
    }

    @GetMapping("/buscarTodos")
    public List<Servico> buscarTodos(){
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public Servico buscar(@PathVariable Integer id){
        return service.buscarPorId(id);
    }


}
