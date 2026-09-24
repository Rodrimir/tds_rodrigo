package com.ifsul.tds_rodrigo.habito;

public record HabitoDtoPost(
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
        Long usuarioId
) {
    public HabitoDtoPost(Habito habito) {
        this(habito.getTitulo(), habito.getCategoria(), habito.getTipoMedida(), habito.getGatilhoAncora(),
                habito.getModalidade(), habito.getMetaBase(), habito.getMetaMaxima(), habito.getIncremento(),
                habito.getDiasIncremento(), habito.getFrequenciaSemanal(), habito.getUsuario().getId());
    }
}
