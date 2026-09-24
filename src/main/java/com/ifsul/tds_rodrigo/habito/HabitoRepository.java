package com.ifsul.tds_rodrigo.habito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface HabitoRepository extends JpaRepository<Habito, Long> {
    Optional<List<Habito>> findByTituloStartingWith(String titulo);

    @Query("SELECT h FROM Habito h WHERE h.titulo LIKE CONCAT(?1, '%')")
    Optional<List<Habito>> findByTituloQuerySpeakJPQL(String titulo);

    @Query(value = "SELECT h.* FROM habitos h WHERE h.titulo LIKE CONCAT(?1, '%') ORDER BY h.titulo", nativeQuery = true)
    Optional<List<Habito>> findByTituloQuerySpeakSQL(String titulo);
}
