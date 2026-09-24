package com.ifsul.tds_rodrigo.usuarios;

public record UsuarioDtoPut(
        String nome,
        String email,
        String fusoHorario,
        String preferenciaIdioma
) {
    public UsuarioDtoPut(Usuario usuario) {
        this(usuario.getNome(), usuario.getEmail(), usuario.getFusoHorario(), usuario.getPreferenciaIdioma());
    }
}
