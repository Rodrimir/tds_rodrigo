package com.ifsul.tds_rodrigo.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
