package com.ifsul.tds_rodrigo.autenticacao;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UsuarioAutenticacaoDto(
        @NotBlank(message = "O email não pode ser nulo nem vazio")
        @Email(message = "O email deve ter @ e . no minimo.")
        String email,
        @NotBlank(message = "A senha não pode ser nula nem vazia")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "A senha deve ter no minimo 8 caracteres, um maiusculo, um minusculo, um numero e um caractere especial")
        String senha) {
}
