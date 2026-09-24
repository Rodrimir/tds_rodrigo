package com.ifsul.tds_rodrigo.bibliotecaTexto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BibliotecaTextoRepository extends JpaRepository<BibliotecaTexto, UUID> {
}