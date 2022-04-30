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
ubicacion INT NOT NULL,
capacidad INT NOT NULL,
horario_inicial DATE not null,
horario_final DATE not null,
disponibilidad BOOLEAN NOT null,
tiporecurso INT NOT NULL
);

create table tiporecurso(
id INT not null,
tipo VARCHAR(50) not null
);

create table ubicacion(
id INT not null,
ubicacion VARCHAR(50) not null
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
ALTER TABLE Tiporecurso ADD CONSTRAINT pk_tiporecurso PRIMARY KEY (id);
ALTER TABLE ubicacion  ADD CONSTRAINT pk_ubicacion PRIMARY KEY (id);
ALTER TABLE reserva  ADD CONSTRAINT pk_reserva PRIMARY KEY (id_reserva);


--UK
ALTER TABLE usuarios ADD CONSTRAINT uk_correo UNIQUE (correo);

--FK
ALTER TABLE usuarios
ADD constraint usuarios_tipo FOREIGN KEY (tipousuario) REFERENCES tipousuario (id);
ALTER TABLE usuarios
ADD constraint usuarios_reserva FOREIGN KEY (reserva) REFERENCES reserva (id_reserva);
ALTER TABLE recursos
ADD constraint recursos_ubicacion FOREIGN KEY (ubicacion) REFERENCES ubicacion (id);
ALTER TABLE recursos
ADD constraint recursos_tiporecurso FOREIGN KEY (tiporecurso) REFERENCES tiporecurso (id);
ALTER TABLE reserva
ADD constraint reserva_recurso FOREIGN KEY (recurso) REFERENCES recursos (id_recursos);

--Atributos
alter table ubicacion
	add CONSTRAINT CK_ubicacion_recurso
		check (
				nombre in ('BloqueG','BibliotecaJorgeAlvarez','BloqueB')
);


--POBLAR
insert into ubicacion (id,ubicacion) values (1,'BloqueG');
insert into ubicacion (id,ubicacion) values (2,'BloqueB');
insert into ubicacion (id,ubicacion) values (3,'BibliotecaJorgeAlvarez');
insert into tiporecurso (id,tipo) values (1,'equipodecomputo');
insert into tiporecurso (id,tipo) values (2,'Saladeestudio');
insert into tiporecurso (id,tipo) values (3,'equipoultimedia');

INSERT INTO recursos (id_recursos,nombre,ubicacion,capacidad,horario_inicial,horario_final,disponibilidad,tiporecurso)
VALUES (6,'libro','BloqueG',1,'2021-12-13','2021-12-14',true,'1');



--POBLAR
INSERT INTO recursos (id_recursos,nombre,ubicacion,capacidad,horario_inicial,horario_final,disponibilidad ,tiporecurso)
VALUES (1,'libro','BloqueG',1,'2021-12-13','2021-12-14',true,'libro');

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

