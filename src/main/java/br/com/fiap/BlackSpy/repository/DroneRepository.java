package br.com.fiap.BlackSpy.repository;

import br.com.fiap.BlackSpy.domain.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<JpaRepository, Drone> {
}
