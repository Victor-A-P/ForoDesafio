package com.ForoDesafio.dto.Tema;

import com.ForoDesafio.model.Materia;
import com.ForoDesafio.model.Tema;

public record DatosListaTema(
        Long id,
        String titulo,
        String mensaje,
        Materia materia) {
    
    public DatosListaTema(Tema tema) {

        this(tema.getId(),
            tema.getTitulo(),
            tema.getMensaje(),
            tema.getMateria());
    }
}