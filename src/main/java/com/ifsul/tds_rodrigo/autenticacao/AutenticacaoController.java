package com.ifsul.tds_rodrigo.autenticacao;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/autenticacao")
public class AutenticacaoController {

    private final AuthenticationManager manager;

    public AutenticacaoController(AuthenticationManager manager) {
        this.manager = manager;
    }

    @PostMapping("/login")
    public ResponseEntity<String> efetuaLogin(@RequestBody UsuarioAutenticacaoDto data) {
        var authenticationDTO = new UsernamePasswordAuthenticationToken(data.email(), data.senha());

        var authentication = manager.authenticate(authenticationDTO);
        return ResponseEntity.ok("autenticou " + authentication.getPrincipal());
    }
}
