package com.ifsul.tds_rodrigo.bibliotecaTexto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "biblioteca_textos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BibliotecaTexto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoria;
    private String idioma;
    private String textoPreTarefa;
    private String textoSucessoPadrao;
    private String textoSucessoExtra;
    private String textoAvisoUrgencia;
}
