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
ubicacion VARCHAR(50) NOT NULL,
capacidad INT NOT NULL,
horario_inicial DATE not null,
horario_final DATE not null,
disponibilidad BOOLEAN NOT null,
tiporecurso VARCHAR(50) NOT NULL
);

create table tiporecurso(
idtipo VARCHAR(20) not null,
nombre VARCHAR(50) not NULL
);

create table ubicacion(
idubicacion VARCHAR(20) not null,
nombre VARCHAR(50) not NULL
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
ALTER TABLE ubicacion  ADD CONSTRAINT pk_tipoubicacion PRIMARY KEY (nombre);
ALTER TABLE reserva  ADD CONSTRAINT pk_reserva PRIMARY KEY (id_reserva);


--UK
ALTER TABLE usuarios ADD CONSTRAINT uk_correo UNIQUE (correo);

--FK
ALTER TABLE usuarios
ADD FOREIGN KEY (tipousuario) REFERENCES tipousuario (id);
ALTER TABLE usuarios
ADD FOREIGN KEY (reserva) REFERENCES reserva (id_reserva);
ALTER TABLE recursos
ADD FOREIGN KEY (ubicacion) REFERENCES ubicacion (nombre);
ALTER TABLE recursos
ADD FOREIGN KEY (tiporecurso) REFERENCES tiporecurso (idtipo);
ALTER TABLE reserva
ADD FOREIGN KEY (recurso) REFERENCES recursos (id_recursos);

--Atributos
alter table ubicacion
	add CONSTRAINT CK_ubicacion_recurso
		check (
				nombre in ('BloqueG','BibliotecaJorgeAlvarez','BloqueB')
);


--POBLAR
insert into ubicacion (idubicacion,nombre) values (1,'BloqueG');
insert into ubicacion (idubicacion,nombre) values (2,'BloqueB');
insert into ubicacion (idubicacion,nombre) values (3,'BibliotecaJorgeAlvarez');
insert into tiporecurso (idtipo,nombre) values (2,'Saladeestudio');
INSERT INTO recursos (id_recursos,nombre,ubicacion,capacidad,horario_inicial,horario_final,disponibilidad,tiporecurso)
VALUES (6,'libro','BloqueG',1,'05:00:00','06:00:00',true,'Saladeestudio');






--POBLAR
INSERT INTO recursos (id_recursos,nombre,ubicacion,capacidad,horario_inicial,horario_final,tiporecurso)
VALUES (1,'libro','biblioteca1',1,'05:00:00','06:00:00','libro');

INSERT INTO recursos (id_recursos,nombre,ubicacion,capacidad,horario_inicial,horario_final,tiporecurso)
VALUES (3,'Computador','biblioteca2',1,'10:00:00','12:00:00','computador');

INSERT INTO recursos (id_recursos,nombre,ubicacion,capacidad,horario_inicial,horario_final,tiporecurso)
VALUES (2,'libro2','biblioteca2',1,'07:00:00','10:00:00','libro');

INSERT INTO recursos (id_recursos,nombre,ubicacion,capacidad,horario_inicial,horario_final,tiporecurso)
VALUES (4,'sala','bibliotecaa1',8,'13:00:00','15:00:00','sala');

--DROP
drop TABLE usuarios cascade;
drop TABLE recursos cascade;
DROP TABLE tipousuario cascade;
DROP TABLE ubicacion cascade;
DROP TABLE tiporecurso cascade;
drop table reserva cascade;
--DELETE
Delete from recursos;
delete from usuarios;
delete from tipousuario;
delete from ubicacion;
delete from tiporecurso;
delete from reserva;
