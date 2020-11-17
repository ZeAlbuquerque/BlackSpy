package br.com.fiap.BlackSpy.service;

import br.com.fiap.BlackSpy.domain.Drone;
import br.com.fiap.BlackSpy.domain.dto.DroneDto;
import br.com.fiap.BlackSpy.repository.DroneRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class DroneService {

    @Autowired
    private DroneRepository repository;

    @Autowired
    private BaseService baseService;

    @Autowired
    private FabricanteService fabricanteService;

    public Drone cadastrar(DroneDto dto){
        Drone drone = new Drone();

        drone.setAlias(dto.getAlias());
        drone.setBase(baseService.buscarPorId(dto.getBase()));
        drone.setFabricante(fabricanteService.buscarPorId(dto.getFabricante()));
        drone.setModelo(dto.getModelo());
        drone.setTipo(dto.getTipo());

        return repository.save(drone);

    }

    public void deletar(Integer id){
        repository.findById(id)
                .map(drone -> {
                    repository.delete(drone);
                    return drone;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Drone não encontrado"));
    }

    public Drone buscarPorId(Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Drone não encontrado"));
    }

    public List<Drone> buscarPorBase(Integer idBase){
        return repository.findDroneByBase(idBase);
    }

    public Drone buscarPorAlias(String alias){
        return  repository.findDroneByAlias(alias);
    }
}
