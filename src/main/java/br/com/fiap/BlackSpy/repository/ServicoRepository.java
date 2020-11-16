package br.com.fiap.BlackSpy.repository;

import br.com.fiap.BlackSpy.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
