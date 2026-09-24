package com.ifsul.tds_rodrigo.usuarios;

public record UsuarioDtoPost(
        String nome,
        String email,
        String senha,
        String fusoHorario,
        String preferenciaIdioma
) {
    public UsuarioDtoPost(Usuario usuario) {
        this(usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getFusoHorario(),
                usuario.getPreferenciaIdioma());
    }
}
