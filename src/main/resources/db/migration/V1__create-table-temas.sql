CREATE TABLE temas(
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL UNIQUE,
    mensaje VARCHAR(500) NOT NULL UNIQUE,
    fecha_creacion DATETIME NOT NULL,
    materia VARCHAR(100) NOT NULL,

    PRIMARY KEY (id)
);