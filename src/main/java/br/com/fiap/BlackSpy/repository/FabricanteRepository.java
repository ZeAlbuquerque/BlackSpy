package br.com.fiap.BlackSpy.repository;

import br.com.fiap.BlackSpy.domain.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface FabricanteRepository extends JpaRepository<Fabricante, Integer> {
}
