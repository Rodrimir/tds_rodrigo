package com.ifsul.tds_rodrigo.autenticacao;

import com.ifsul.tds_rodrigo.usuarios.Usuario;
import org.springframework.data.repository.Repository;

public interface AutenticacaoRepository extends Repository<Usuario, Long> {
    Usuario findByEmail(String email);
}
