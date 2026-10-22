package com.ifsul.tds_rodrigo.usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UsuarioDtoPost(
        @NotBlank(message = "O nome não pode ser nulo nem vazio")
        @Size(max = 100, message = "O nome deve ter no maximo 100 caracteres")
        String nome,
        @NotBlank(message = "O email não pode ser nulo nem vazio")
        @Email(message = "O email deve ter @ e . no minimo.")
        String email,
        @NotBlank(message = "A senha não pode ser nula nem vazia")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "A senha deve ter no minimo 8 caracteres, um maiusculo, um minusculo, um numero e um caractere especial")
        String senha,
        @NotBlank(message = "O fuso horario não pode ser nulo nem vazio")
        String fusoHorario,
        @NotBlank(message = "A preferencia de idioma não pode ser nula nem vazia")
        String preferenciaIdioma
) {
    public UsuarioDtoPost(Usuario usuario) {
        this(usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getFusoHorario(),
                usuario.getPreferenciaIdioma());
    }
}
