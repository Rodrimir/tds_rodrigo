package com.ifsul.tds_rodrigo.historicoExecucao;

import com.ifsul.tds_rodrigo.habito.Habito;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "historico_execucoes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HistoricoExecucao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer valorRealizado;
    private String tipoSucesso;
    private Integer moedasGanhas;
    private LocalDate dataExecucao;

    @ManyToOne
    @JoinColumn(name = "habito_id", referencedColumnName = "id", nullable = false)
    private Habito habito;
}
