package com.ifsul.tds_rodrigo.usuarios;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsuarioController(UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<List<UsuarioDtoResponse>> findAll() {
        return ResponseEntity.ok(usuarioRepository.findAll().stream().map(UsuarioDtoResponse::new).toList());
    }

    @GetMapping("/{id}")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<UsuarioDtoResponse> findById(@PathVariable Long id) {
        var optionalUsuario = usuarioRepository.findById(id);
        return optionalUsuario.map(usuario -> ResponseEntity.ok(new UsuarioDtoResponse(usuario)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<String> insert(@RequestBody UsuarioDtoPost usuarioDTOPost, UriComponentsBuilder uriBuilder) {
        var u = usuarioRepository.save(new Usuario(
                null,
                usuarioDTOPost.nome(),
                usuarioDTOPost.email(),
                bCryptPasswordEncoder.encode(usuarioDTOPost.senha()),
                usuarioDTOPost.fusoHorario(),
                usuarioDTOPost.preferenciaIdioma(),
                LocalDate.now(),
                null,
                null
        ));
        var location = uriBuilder.path("api/v1/usuarios/{id}").buildAndExpand(u.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{id}")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<UsuarioDtoResponse> update(@PathVariable Long id, @RequestBody UsuarioDtoPut usuarioDTOPut) {
        var optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var usuario = optionalUsuario.get();
        var u = usuarioRepository.save(new Usuario(
                id,
                usuarioDTOPut.nome(),
                usuarioDTOPut.email(),
                usuario.getSenha(),
                usuarioDTOPut.fusoHorario(),
                usuarioDTOPut.preferenciaIdioma(),
                usuario.getCriadoEm(),
                null,
                usuario.getPerfis()
        ));
        return ResponseEntity.ok(new UsuarioDtoResponse(u));
    }

    @DeleteMapping("{id}")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
