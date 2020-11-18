package br.com.fiap.BlackSpy.service;

import br.com.fiap.BlackSpy.domain.Alvo;
import br.com.fiap.BlackSpy.domain.Servico;
import br.com.fiap.BlackSpy.domain.Usuario;
import br.com.fiap.BlackSpy.domain.dto.ServicoDto;
import br.com.fiap.BlackSpy.repository.AlvoRepository;
import br.com.fiap.BlackSpy.service.exeption.RegraNegocioException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Calendar;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AlvoService {

    @Autowired
    private AlvoRepository repository;

    @Autowired
    private ServicoService servicoService;

    @Transactional
    public Alvo cadastrar(Alvo alvo){
        Alvo a = repository.save(alvo);

        ServicoDto dto = new ServicoDto("NEUTRALIZACAO", Calendar.getInstance(),null,1,a.getId());
        servicoService.buscarAlvo(dto);

        return a;
    }

    @Transactional
    public void deletar(Integer id){
        repository
                .findById(id)
                .map(alvo -> {
                    repository.delete(alvo);
                    return alvo;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Alvo não encontrado"));
    }

    public Alvo buscarPeloId(Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Alvo não encontrado"));
    }

}
