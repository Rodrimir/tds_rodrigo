package com.ifsul.tds_rodrigo.usuarios;

import java.io.Serializable;

public record UsuarioDtoResponse(Long id, String nome, String email, String fusoHorario,
                                 String preferenciaIdioma) implements Serializable {
    public UsuarioDtoResponse(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getFusoHorario(),
                usuario.getPreferenciaIdioma());
    }
}
