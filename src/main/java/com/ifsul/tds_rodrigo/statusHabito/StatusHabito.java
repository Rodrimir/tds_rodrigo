package com.ifsul.tds_rodrigo.statusHabito;

import com.ifsul.tds_rodrigo.habito.Habito;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "status_habitos")
public class StatusHabito {

    @Id
    @Column(name = "sta_habito_id", length = 36, nullable = false, updatable = false)
    private UUID habitoId;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sta_habito_id")
    private Habito habito;

    @Column(name = "sta_moedas_locais", nullable = false)
    private Integer moedasLocais = 0;

    @Column(name = "sta_bloqueios_acumulados", nullable = false)
    private Integer bloqueiosAcumulados = 0;

    @Column(name = "sta_dias_seguidos", nullable = false)
    private Integer diasSeguidos = 0;

    @Column(name = "sta_recorde_dias", nullable = false)
    private Integer recordeDias = 0;

    @Column(name = "sta_execucoes_hoje", nullable = false)
    private Integer execucoesHoje = 0;

    @Column(name = "sta_valor_acumulado_hoje", nullable = false)
    private Integer valorAcumuladoHoje = 0;

    @Column(name = "sta_nivel_avatar", nullable = false)
    private Integer nivelAvatar = 1;

    @Column(name = "sta_proximo_vencimento")
    private OffsetDateTime proximoVencimento;

    @Column(name = "sta_bloqueio_usado_hoje", nullable = false)
    private Boolean bloqueioUsadoHoje = false;

    @Column(name = "sta_ultimo_reset")
    private LocalDate ultimoReset;
}
