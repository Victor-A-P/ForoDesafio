package com.ForoDesafio.dto.Tema;

import com.ForoDesafio.model.Materia;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTema(
        @NotBlank
          String titulo,

        @NotBlank
          String mensaje,

        @NotNull @Valid
        Materia materia) {
}
