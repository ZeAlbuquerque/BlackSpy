package br.com.fiap.BlackSpy.service;

import br.com.fiap.BlackSpy.domain.Fabricante;
import br.com.fiap.BlackSpy.repository.FabricanteRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class FabricanteService {

    @Autowired
    private FabricanteRepository repository;

    public Fabricante cadastrar(Fabricante fabricante){
        return repository.save(fabricante);
    }

    public void deletar(Integer id){
        repository.findById(id)
                .map(fabricante ->{
                    repository.delete(fabricante);
                    return fabricante;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fabricante não encontrada"));
    }

    public Fabricante buscarPorId(Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fabricante não encontrada"));
    }
}
