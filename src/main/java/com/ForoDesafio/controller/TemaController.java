package com.ForoDesafio.controller;

import com.ForoDesafio.dto.Tema.DatosActualizarTema;
import com.ForoDesafio.dto.Tema.DatosDetalleTema;
import com.ForoDesafio.dto.Tema.DatosListaTema;
import com.ForoDesafio.dto.Tema.DatosRegistroTema;
import com.ForoDesafio.model.Tema;
import com.ForoDesafio.repository.TemaRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/temas")
@SecurityRequirement(name = "bearer-key")
public class TemaController {
    @Autowired
    private TemaRepository temaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registrarTema(@RequestBody @Valid DatosRegistroTema datosRegistroTema,
                                          UriComponentsBuilder uriComponentsBuilder) {
        var tema = new Tema(datosRegistroTema);
        temaRepository.save(tema);

        var uri = uriComponentsBuilder.path("/temas/{id}").buildAndExpand(tema.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleTema(tema));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaTema>> datosListaTemas(@PageableDefault(size = 5, sort = {"curso"}) Pageable pageable) {
        var page = temaRepository.findAll(pageable).map(DatosListaTema::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTema(@RequestBody @Valid DatosActualizarTema datosActualizarTema) {
        var tema = temaRepository.getReferenceById(datosActualizarTema.id());
        tema.actualizarInformacion(datosActualizarTema);
        return ResponseEntity.ok(new DatosDetalleTema(tema));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarTema(@PathVariable Long id) {
        Tema tema = temaRepository.findById(id).orElse(null);
        if (tema == null) {
            return ResponseEntity.noContent().build();
        }
        temaRepository.delete(tema);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detallarTema(@PathVariable Long id) {
        var tema = temaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleTema(tema));
    }
}