package br.com.fiap.BlackSpy.controller;

import br.com.fiap.BlackSpy.domain.Alvo;
import br.com.fiap.BlackSpy.service.AlvoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alvo")
public class AlvoController {

    @Autowired
    private AlvoService alvoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Alvo cadastar(@RequestBody Alvo alvo){
        return alvoService.cadastrar(alvo);
    }


    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        alvoService.deletar(id);
    }

    @GetMapping("/id")
    public Alvo buscarPeloId(@PathVariable Integer id){
        return alvoService.buscarPeloId(id);
    }
}
