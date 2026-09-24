package com.ifsul.tds_rodrigo.historicoExecucao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HistoricoExecucaoRepository extends JpaRepository<HistoricoExecucao, UUID> {
}