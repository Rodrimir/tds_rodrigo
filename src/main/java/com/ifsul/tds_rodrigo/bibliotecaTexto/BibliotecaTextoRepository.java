package com.ifsul.tds_rodrigo.bibliotecaTexto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface BibliotecaTextoRepository extends JpaRepository<BibliotecaTexto, Long> {
}
