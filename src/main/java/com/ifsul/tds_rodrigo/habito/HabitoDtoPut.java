package com.ifsul.tds_rodrigo.habito;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record HabitoDtoPut(
        @NotBlank(message = "O titulo não pode ser nulo nem vazio")
        @Size(max = 100, message = "O titulo deve ter no maximo 100 caracteres")
        String titulo,
        @NotBlank(message = "A categoria não pode ser nula nem vazia")
        String categoria,
        @NotBlank(message = "O tipo de medida não pode ser nulo nem vazio")
        String tipoMedida,
        String gatilhoAncora,
        @NotBlank(message = "A modalidade não pode ser nula nem vazia")
        String modalidade,
        @NotNull(message = "A meta base não pode ser nula")
        @Min(value = 1, message = "A meta base deve ser maior que zero")
        Integer metaBase,
        @NotNull(message = "A meta maxima não pode ser nula")
        @Min(value = 1, message = "A meta maxima deve ser maior que zero")
        Integer metaMaxima,
        @NotNull(message = "O incremento não pode ser nulo")
        @Min(value = 0, message = "O incremento não pode ser negativo")
        Integer incremento,
        @NotNull(message = "Os dias de incremento não podem ser nulos")
        @Min(value = 1, message = "Os dias de incremento devem ser maior que zero")
        Integer diasIncremento,
        @NotBlank(message = "A frequencia semanal não pode ser nula nem vazia")
        String frequenciaSemanal,
        @NotNull(message = "O campo ativo não pode ser nulo")
        Boolean ativo
) {
    public HabitoDtoPut(Habito habito) {
        this(habito.getTitulo(), habito.getCategoria(), habito.getTipoMedida(), habito.getGatilhoAncora(),
                habito.getModalidade(), habito.getMetaBase(), habito.getMetaMaxima(), habito.getIncremento(),
                habito.getDiasIncremento(), habito.getFrequenciaSemanal(), habito.getAtivo());
    }
}
