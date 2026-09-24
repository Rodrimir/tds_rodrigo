package com.ifsul.tds_rodrigo.bibliotecaTexto;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "biblioteca_textos")
public class BibliotecaTexto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "bib_id", length = 36, nullable = false, updatable = false)
    private UUID id;

    @Column(name = "bib_categoria", length = 50, nullable = false)
    private String categoria;

    @Column(name = "bib_idioma", length = 10, nullable = false)
    private String idioma = "pt-BR";

    @Column(name = "bib_texto_pre_tarefa", columnDefinition = "TEXT", nullable = false)
    private String textoPreTarefa;

    @Column(name = "bib_texto_sucesso_padrao", columnDefinition = "TEXT", nullable = false)
    private String textoSucessoPadrao;

    @Column(name = "bib_texto_sucesso_extra", columnDefinition = "TEXT", nullable = false)
    private String textoSucessoExtra;

    @Column(name = "bib_texto_aviso_urgencia", columnDefinition = "TEXT")
    private String textoAvisoUrgencia;

}
