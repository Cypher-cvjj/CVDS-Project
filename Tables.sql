--TABLES
CREATE TABLE usuarios(

documento INT NOT NULL,
nombre VARCHAR(20) NOT NULL,
contrasena VARCHAR(16) NOT NULL,
correo VARCHAR(20) NOT NULL,
telefono VARCHAR(20),
tipousuario INT NOT null,
reserva int not null
);

CREATE TABLE recursos(

id_recursos INT NOT NULL,
nombre VARCHAR(20) NOT NULL,
ubicacion VARCHAR(20) NOT NULL,
capacidad INT NOT NULL,
disponibilidad BOOLEAN NOT null,
horario_inicial TIME not null,
horario_final TIME not null,
tiporecurso VARCHAR(20) NOT NULL
);

create table tiporecurso(
idtipo VARCHAR(20) not null,
nombre VARCHAR(20) not NULL
);

create table ubicacion(
idubicacion VARCHAR(20) not null,
nombre VARCHAR(20) not NULL
);


CREATE TABLE TipoUsuario(
id INT not null,
nombre VARCHAR(10) not null
);

create table reserva(
id_reserva INT not null,
nombre VARCHAR(20) not null,
recurso INT not null,
fechasoli Date not null,
fechaini Date not null,
fechafin Date not null
);

--PK
ALTER TABLE usuarios ADD CONSTRAINT pk_usuario PRIMARY KEY (documento);
ALTER TABLE recursos ADD CONSTRAINT pk_recursos PRIMARY KEY (id_recursos);
ALTER TABLE TipoUsuario  ADD CONSTRAINT pk_tipousuario PRIMARY KEY (id);
ALTER TABLE Tiporecurso ADD CONSTRAINT pk_tiporecurso PRIMARY KEY (idtipo);
ALTER TABLE ubicacion  ADD CONSTRAINT pk_tipoubicacion PRIMARY KEY (idubicacion);
ALTER TABLE reserva  ADD CONSTRAINT pk_reserva PRIMARY KEY (id_reserva);


--UK
ALTER TABLE usuarios ADD CONSTRAINT uk_correo UNIQUE (correo);

--FK
ALTER TABLE usuarios
ADD FOREIGN KEY (tipousuario) REFERENCES tipousuario (id);
ALTER TABLE usuarios
ADD FOREIGN KEY (reserva) REFERENCES reserva (id_reserva);
ALTER TABLE recursos
ADD FOREIGN KEY (ubicacion) REFERENCES ubicacion (idubicacion);
ALTER TABLE recursos
ADD FOREIGN KEY (tiporecurso) REFERENCES tiporecurso (idtipo);
ALTER TABLE reserva
ADD FOREIGN KEY (recurso) REFERENCES recursos (id_recursos);




--POBLAR
INSERT INTO recursos (id_recursos,nombre,ubicacion,capacidad,tiporecurso,fecha,horario_inicial,horario_final)
VALUES (1,'libro','biblioteca1',1,'libro','2020-11-11','05:00:00','06:00:00');

INSERT INTO recursos (id_recursos,nombre,ubicacion,capacidad,tiporecurso,fecha,horario_inicial,horario_final)
VALUES (3,'Computador','biblioteca2',1,'computador','2020-11-11','10:00:00','12:00:00');

INSERT INTO recursos (id_recursos,nombre,ubicacion,capacidad,tiporecurso,fecha,horario_inicial,horario_final)
VALUES (2,'libro2','biblioteca2',1,'libro','2020-11-11','07:00:00','10:00:00');

INSERT INTO recursos (id_recursos,nombre,ubicacion,capacidad,tiporecurso,fecha,horario_inicial,horario_final)
VALUES (4,'sala','bibliotecaa1',8,'sala','2020-11-11','13:00:00','15:00:00');

--DROP
DROP TABLE usuarios;
DROP TABLE recursos;
DROP TABLE tipousuario;
DROP TABLE ubicacion;
DROP TABLE tiporecurso;
drop table reserva;

--DELETE 
Delete from recursos;
delete from usuarios;