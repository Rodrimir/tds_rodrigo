package com.ifsul.tds_rodrigo.habito;

public record HabitoDtoPut(
        String titulo,
        String categoria,
        String tipoMedida,
        String gatilhoAncora,
        String modalidade,
        Integer metaBase,
        Integer metaMaxima,
        Integer incremento,
        Integer diasIncremento,
        String frequenciaSemanal,
        Boolean ativo
) {
    public HabitoDtoPut(Habito habito) {
        this(habito.getTitulo(), habito.getCategoria(), habito.getTipoMedida(), habito.getGatilhoAncora(),
                habito.getModalidade(), habito.getMetaBase(), habito.getMetaMaxima(), habito.getIncremento(),
                habito.getDiasIncremento(), habito.getFrequenciaSemanal(), habito.getAtivo());
    }
}
