package com.ifsul.tds_rodrigo.habito;

import java.io.Serializable;

public record HabitoDtoResponse(Long id, String titulo, String categoria, String tipoMedida, String modalidade,
                                Integer metaBase, String frequenciaSemanal, Boolean ativo) implements Serializable {
    public HabitoDtoResponse(Habito habito) {
        this(habito.getId(), habito.getTitulo(), habito.getCategoria(), habito.getTipoMedida(),
                habito.getModalidade(), habito.getMetaBase(), habito.getFrequenciaSemanal(), habito.getAtivo());
    }
}
