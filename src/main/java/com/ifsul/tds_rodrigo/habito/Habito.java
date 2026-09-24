package com.ifsul.tds_rodrigo.habito;

import com.ifsul.tds_rodrigo.historicoExecucao.HistoricoExecucao;
import com.ifsul.tds_rodrigo.statusHabito.StatusHabito;
import com.ifsul.tds_rodrigo.usuarios.Usuario;
import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "habitos")
public class Habito {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "hab_id", length = 36, nullable = false, updatable = false)
    private UUID id;

    @Column(name = "hab_titulo", length = 60, nullable = false)
    private String titulo;

    @Column(name = "hab_categoria", length = 50, nullable = false)
    private String categoria;

    @Column(name = "hab_tipo_medida", length = 20, nullable = false)
    private String tipoMedida;

    @Column(name = "hab_gatilho_ancora", length = 120)
    private String gatilhoAncora;

    @Column(name = "hab_modalidade", length = 50)
    private String modalidade;

    @Column(name = "hab_meta_base", nullable = false)
    private Integer metaBase = 1;

    @Column(name = "hab_meta_maxima")
    private Integer metaMaxima;

    @Column(name = "hab_incremento", nullable = false)
    private Integer incremento = 0;

    @Column(name = "hab_dias_incremento", nullable = false)
    private Integer diasIncremento = 10;

    @Column(name = "hab_frequencia_semanal", length = 7, nullable = false)
    private String frequenciaSemanal = "1111111";

    @Column(name = "hab_ativo", nullable = false)
    private boolean ativo = true;

    @Column(name = "hab_criado_em", insertable = false, updatable = false)
    private OffsetDateTime criadoEm;

    @Column(name = "hab_arquivado_em")
    private OffsetDateTime arquivadoEm;

    // associacoes

    @ManyToOne
    @JoinColumn(name = "hab_usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "habito", cascade = CascadeType.ALL)
    private List<HistoricoExecucao> historicoExecucoes = new ArrayList<>();

    @OneToOne(mappedBy = "habito", cascade = CascadeType.ALL)
    private StatusHabito statusHabito;
}
