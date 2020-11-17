package br.com.fiap.BlackSpy.service;

import br.com.fiap.BlackSpy.domain.Base;
import br.com.fiap.BlackSpy.repository.BaseRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class BaseService {

    @Autowired
    private BaseRepository repository;

    public Base cadastrar(Base base){
        return repository.save(base);
    }

    public void deletar(Integer id){
        repository.findById(id)
                .map(base ->{
                    repository.delete(base);
                    return base;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Base não encontrada"));
    }

    public Base buscarPorId(Integer id){
       return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Base não encontrada"));
    }

    public Base buscarPorAlias(String alias){
        return repository.findBaseByAlias(alias);
    }
}
