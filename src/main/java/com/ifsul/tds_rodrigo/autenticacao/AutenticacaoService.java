package com.ifsul.tds_rodrigo.autenticacao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {
    private final AutenticacaoRepository rep;

    public AutenticacaoService(AutenticacaoRepository rep) {
        this.rep = rep;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var usuario = rep.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        return usuario;
    }
}
