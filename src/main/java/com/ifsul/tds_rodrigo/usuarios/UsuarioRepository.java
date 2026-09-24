package com.ifsul.tds_rodrigo.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
//desliga o controller automatico
@RepositoryRestResource(exported = false)
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    <T> Optional<T> findById(Long id);
}