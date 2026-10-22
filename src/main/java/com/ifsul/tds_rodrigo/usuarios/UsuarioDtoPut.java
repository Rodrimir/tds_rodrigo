package com.ifsul.tds_rodrigo.usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioDtoPut(
        @NotBlank(message = "O nome não pode ser nulo nem vazio")
        @Size(max = 100, message = "O nome deve ter no maximo 100 caracteres")
        String nome,
        @NotBlank(message = "O email não pode ser nulo nem vazio")
        @Email(message = "O email deve ter @ e . no minimo.")
        String email,
        @NotBlank(message = "O fuso horario não pode ser nulo nem vazio")
        String fusoHorario,
        @NotBlank(message = "A preferencia de idioma não pode ser nula nem vazia")
        String preferenciaIdioma
) {
    public UsuarioDtoPut(Usuario usuario) {
        this(usuario.getNome(), usuario.getEmail(), usuario.getFusoHorario(), usuario.getPreferenciaIdioma());
    }
}
