package com.ForoDesafio.model;


import com.ForoDesafio.dto.Tema.DatosActualizarTema;
import com.ForoDesafio.dto.Tema.DatosRegistroTema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Table(name = "temas")
@Entity(name = "Tema")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;

    @CreationTimestamp
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private Materia materia;

    public Tema(DatosRegistroTema datosRegistroTema) {
        this.titulo = datosRegistroTema.titulo();
        this.mensaje = datosRegistroTema.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.materia = datosRegistroTema.materia();
    }

    public void actualizarInformacion(DatosActualizarTema datosActualizarTema) {
        if(datosActualizarTema.titulo() != null) {
            this.titulo = datosActualizarTema.titulo();
        }

        if(datosActualizarTema.mensaje() != null) {
            this.mensaje = datosActualizarTema.mensaje();
        }
    }
}