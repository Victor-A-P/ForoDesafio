package com.ForoDesafio.repository;

import com.ForoDesafio.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository <Tema,Long> {
}
