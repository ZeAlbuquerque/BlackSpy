package br.com.fiap.BlackSpy.repository;

import br.com.fiap.BlackSpy.domain.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DroneRepository extends JpaRepository<Drone, Integer> {

    List<Drone> findDroneByBase(@Param("idBase") Integer idBase);

    Drone findDroneByAlias(@Param("alias") String alias);
}
