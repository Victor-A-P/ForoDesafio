package com.ForoDesafio.dto.Tema;

import com.ForoDesafio.model.Materia;
import com.ForoDesafio.model.Tema;
import java.time.LocalDateTime;

public record DatosDetalleTema(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Materia materia) {
    
    public DatosDetalleTema(Tema tema) {

        this(tema.getTitulo(),
                tema.getMensaje(),
                tema.getFechaCreacion(),
                tema.getMateria());
    }
}