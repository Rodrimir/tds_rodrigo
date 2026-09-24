package com.ifsul.tds_rodrigo.habito;

import com.ifsul.tds_rodrigo.historicoExecucao.HistoricoExecucao;
import com.ifsul.tds_rodrigo.statusHabito.StatusHabito;
import com.ifsul.tds_rodrigo.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "habitos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Habito {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String categoria;
    private String tipoMedida;
    private String gatilhoAncora;
    private String modalidade;
    private Integer metaBase;
    private Integer metaMaxima;
    private Integer incremento;
    private Integer diasIncremento;
    private String frequenciaSemanal;
    private Boolean ativo;
    private LocalDate criadoEm;
    private LocalDate arquivadoEm;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "habito")
    private Collection<HistoricoExecucao> historicoExecucoes;

    @OneToOne(mappedBy = "habito")
    private StatusHabito statusHabito;
}
