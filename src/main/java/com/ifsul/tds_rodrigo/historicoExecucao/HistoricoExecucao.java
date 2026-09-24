package com.ifsul.tds_rodrigo.historicoExecucao;

import com.ifsul.tds_rodrigo.habito.Habito;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "historico_execucoes")
public class HistoricoExecucao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "his_id", length = 36, nullable = false, updatable = false)
    private UUID id;
    @Column(name = "his_execution_token", length = 36, nullable = false, unique = true)
    private UUID executionToken;

    @Column(name = "his_valor_realizado", nullable = false)
    private Integer valorRealizado = 0;

    @Column(name = "his_tipo_sucesso", length = 30, nullable = false)
    private String tipoSucesso;

    @Column(name = "his_moedas_ganhas", nullable = false)
    private Integer moedasGanhas = 0;

    @Column(name = "his_data_hora", insertable = false, updatable = false)
    private OffsetDateTime dataHoraExecucao;

    @Column(name = "his_data_local", nullable = false)
    private LocalDate dataLocal;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "his_habito_id", nullable = false)
    private Habito habito;
}
