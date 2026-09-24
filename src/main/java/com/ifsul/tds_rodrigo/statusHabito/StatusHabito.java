package com.ifsul.tds_rodrigo.statusHabito;

import com.ifsul.tds_rodrigo.habito.Habito;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "status_habitos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StatusHabito {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer moedasLocais;
    private Integer bloqueiosAcumulados;
    private Integer diasSeguidos;
    private Integer recordeDias;
    private Integer execucoesHoje;
    private Integer valorAcumuladoHoje;
    private Integer nivelAvatar;
    private LocalDate proximoVencimento;
    private Boolean bloqueioUsadoHoje;
    private LocalDate ultimoReset;

    @OneToOne
    @JoinColumn(name = "habito_id", referencedColumnName = "id", nullable = false)
    private Habito habito;
}
