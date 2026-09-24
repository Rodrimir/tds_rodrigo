package com.ifsul.tds_rodrigo.statusHabito;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StatusHabitoRepository extends JpaRepository<StatusHabito, UUID> {
}