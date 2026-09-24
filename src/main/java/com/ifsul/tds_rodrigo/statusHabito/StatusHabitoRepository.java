package com.ifsul.tds_rodrigo.statusHabito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface StatusHabitoRepository extends JpaRepository<StatusHabito, Long> {
}
