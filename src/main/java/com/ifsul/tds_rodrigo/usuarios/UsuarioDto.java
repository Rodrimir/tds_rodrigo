package com.ifsul.tds_rodrigo.usuarios;

import java.io.Serializable;

/**
 * DTO for {@link Usuario}
 */
public record UsuarioDto(String nome, String email, String senhaHash) implements Serializable {

  //crie o costrutor para a classe controller
  public UsuarioDto(Usuario usuario) {
    this(usuario.getNome(), usuario.getEmail(), usuario.getSenhaHash());
  }
}
