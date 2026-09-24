package com.ifsul.tds_rodrigo.usuarios;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(usuarioRepository.findById(id).map(UsuarioDto::new).orElse(null));
    }

    @Secured("ROLE_ADMIN")
    @GetMapping
    public ResponseEntity<List<UsuarioDto>> findById() {
        return ResponseEntity.ok(usuarioRepository.findAll().stream()

                .map(UsuarioDto::new)
                .toList());
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    public String insert(@RequestBody Usuario usuario) {
        return "insert";
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return "delete";
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody Usuario usuario) {
        return "update";
    }

    //    public static void main(String[] args) {
//        BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
//        String senha = enconder.encode("senha");
//    }
}
