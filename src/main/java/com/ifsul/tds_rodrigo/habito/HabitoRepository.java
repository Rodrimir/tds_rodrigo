package com.ifsul.tds_rodrigo.habito;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HabitoRepository extends JpaRepository<Habito, UUID> {
}