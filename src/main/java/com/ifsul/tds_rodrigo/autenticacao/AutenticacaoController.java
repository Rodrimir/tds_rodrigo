package com.ifsul.tds_rodrigo.autenticacao;

import com.ifsul.tds_rodrigo.infra.jwt.TokenJwtDto;
import com.ifsul.tds_rodrigo.infra.jwt.TokenService;
import com.ifsul.tds_rodrigo.usuarios.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/autenticacao")
public class AutenticacaoController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    public AutenticacaoController(AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenJwtDto> efetuaLogin(@Valid @RequestBody UsuarioAutenticacaoDto data) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var authentication = manager.authenticate(authenticationToken);

        var token = tokenService.geraToken((Usuario)authentication.getPrincipal());
        System.out.println("Token gerado: " + token);

        return ResponseEntity.ok(new TokenJwtDto(token));
    }
}