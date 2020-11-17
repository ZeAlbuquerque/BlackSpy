package br.com.fiap.BlackSpy.repository;

import br.com.fiap.BlackSpy.domain.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BaseRepository extends JpaRepository<Base,Integer> {

    List<Base> findBaseByAliasContaining(@Param("alias") String alias);

    Base findBaseByAlias(@Param("alias") String alias);
}
