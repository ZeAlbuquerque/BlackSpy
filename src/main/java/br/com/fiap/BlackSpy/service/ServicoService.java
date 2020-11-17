package br.com.fiap.BlackSpy.service;

import br.com.fiap.BlackSpy.domain.Servico;
import br.com.fiap.BlackSpy.domain.dto.ServicoDto;
import br.com.fiap.BlackSpy.domain.enums.StatusServico;
import br.com.fiap.BlackSpy.domain.enums.TipoServico;
import br.com.fiap.BlackSpy.repository.ServicoRepository;
import br.com.fiap.BlackSpy.service.exeption.RegraNegocioException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Calendar;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ServicoService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private DroneService droneService;

    @Autowired
    private AlvoService alvoService;

    @Autowired
    private ServicoRepository repository;


    public Servico buscarAlvo(ServicoDto dto){
        Servico servico = new Servico();

        servico.setAlvo(alvoService.buscarPeloId(dto.getAlvo()));
        servico.setDrone(droneService.buscarPorId(dto.getDrone()));

        servico.setDataDespacho(Calendar.getInstance());
        servico.setStatusServico(StatusServico.EM_ANDAMENTO);
        servico.setTipo(TipoServico.valueOf(dto.getTipo()));

        repository.save(servico);

        return servico;
    }


    public void cancelarServico(Integer id){
        repository.findById(id)
                .map(servico -> {
                    servico.setStatusServico(StatusServico.CANCELADO);
                    repository.save(servico);
                    return servico;
                }).orElseThrow(() -> new RegraNegocioException("Não foi possível cancelar esse serviço"));
    }

    public List<Servico> buscarTodos(){
        return repository.findAll();
    }

    public Servico buscarPorId(Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Servico não encontrado"));
    }




}
