package com.ifsul.tds_rodrigo.habito;

import com.ifsul.tds_rodrigo.usuarios.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/habitos")
public class HabitoController {

    private final HabitoRepository habitoRepository;
    private final UsuarioRepository usuarioRepository;

    public HabitoController(HabitoRepository habitoRepository, UsuarioRepository usuarioRepository) {
        this.habitoRepository = habitoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<List<HabitoDtoResponse>> findAll() {
        return ResponseEntity.ok(habitoRepository.findAll().stream().map(HabitoDtoResponse::new).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitoDtoResponse> findById(@PathVariable Long id) {
        var optionalHabito = habitoRepository.findById(id);
        return optionalHabito.map(habito -> ResponseEntity.ok(new HabitoDtoResponse(habito)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<HabitoDtoResponse>> findByTitulo(@PathVariable String titulo) {
        var habitos = habitoRepository.findByTituloStartingWith(titulo);
        if (habitos.isPresent() && !habitos.get().isEmpty()) {
            return ResponseEntity.ok(habitos.get().stream().map(HabitoDtoResponse::new).toList());
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<String> insert(@RequestBody HabitoDtoPost habitoDTOPost, UriComponentsBuilder uriBuilder) {
        var optionalUsuario = usuarioRepository.findById(habitoDTOPost.usuarioId());
        if (optionalUsuario.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var h = habitoRepository.save(new Habito(
                null,
                habitoDTOPost.titulo(),
                habitoDTOPost.categoria(),
                habitoDTOPost.tipoMedida(),
                habitoDTOPost.gatilhoAncora(),
                habitoDTOPost.modalidade(),
                habitoDTOPost.metaBase(),
                habitoDTOPost.metaMaxima(),
                habitoDTOPost.incremento(),
                habitoDTOPost.diasIncremento(),
                habitoDTOPost.frequenciaSemanal(),
                true,
                LocalDate.now(),
                null,
                optionalUsuario.get(),
                null,
                null
        ));
        var location = uriBuilder.path("api/v1/habitos/{id}").buildAndExpand(h.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<HabitoDtoResponse> update(@PathVariable Long id, @RequestBody HabitoDtoPut habitoDTOPut) {
        var optionalHabito = habitoRepository.findById(id);
        if (optionalHabito.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var habito = optionalHabito.get();
        var h = habitoRepository.save(new Habito(
                id,
                habitoDTOPut.titulo(),
                habitoDTOPut.categoria(),
                habitoDTOPut.tipoMedida(),
                habitoDTOPut.gatilhoAncora(),
                habitoDTOPut.modalidade(),
                habitoDTOPut.metaBase(),
                habitoDTOPut.metaMaxima(),
                habitoDTOPut.incremento(),
                habitoDTOPut.diasIncremento(),
                habitoDTOPut.frequenciaSemanal(),
                habitoDTOPut.ativo(),
                habito.getCriadoEm(),
                habito.getArquivadoEm(),
                habito.getUsuario(),
                null,
                null
        ));
        return ResponseEntity.ok(new HabitoDtoResponse(h));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (habitoRepository.existsById(id)) {
            habitoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
