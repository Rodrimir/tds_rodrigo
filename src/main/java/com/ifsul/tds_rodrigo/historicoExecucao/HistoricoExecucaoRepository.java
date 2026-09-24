package com.ifsul.tds_rodrigo.historicoExecucao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface HistoricoExecucaoRepository extends JpaRepository<HistoricoExecucao, Long> {
}
