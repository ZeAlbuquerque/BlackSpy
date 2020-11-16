package br.com.fiap.BlackSpy.repository;

import br.com.fiap.BlackSpy.domain.Base;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository extends JpaRepository<Base,Integer> {
}
