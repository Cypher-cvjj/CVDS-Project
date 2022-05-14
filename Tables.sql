--TABLES
CREATE TABLE usuarios(
documento INT NOT NULL,
nombre VARCHAR(50) NOT NULL,
contrasena VARCHAR(16) NOT NULL,
correo VARCHAR(50) NOT NULL,
telefono VARCHAR(50),
tipousuario INT NOT null
);


CREATE TABLE recursos(

id_recursos INT NOT NULL,
nombre VARCHAR(50) NOT NULL,
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
nombre VARCHAR(50) not null
);

create table reserva(
id_reserva INT not null,
nombre VARCHAR(50) not null,
fechasoli Date not null,
fechaini Date not null,
fechafin Date not null,
estado BOOLEAN not null,
usuario int not null,
recurso INT not null,
tiporeserva INT not null
);


create table tiporeserva(
id INT not null,
tipore VARCHAR (50)
);

--PK
ALTER TABLE usuarios ADD CONSTRAINT pk_usuario PRIMARY KEY (documento);
ALTER TABLE recursos ADD CONSTRAINT pk_recursos PRIMARY KEY (id_recursos);
ALTER TABLE TipoUsuario  ADD CONSTRAINT pk_tipousuario PRIMARY KEY (id);
ALTER TABLE Tiporecurso ADD CONSTRAINT pk_tiporecurso PRIMARY KEY (id);
ALTER TABLE ubicacion  ADD CONSTRAINT pk_ubicacion PRIMARY KEY (id);
ALTER TABLE reserva  ADD CONSTRAINT pk_reserva PRIMARY KEY (id_reserva);
alter TABLE tiporeserva add CONSTRAINT pk_tiporeserva PRIMARY key (id);

--UK
ALTER TABLE usuarios ADD CONSTRAINT uk_correo UNIQUE (correo);

--FK
ALTER TABLE usuarios
ADD constraint usuarios_tipo FOREIGN KEY (tipousuario) REFERENCES tipousuario (id);
ALTER TABLE reserva
ADD constraint usuarios_reserva FOREIGN KEY (usuario) references usuarios (documento);
ALTER TABLE recursos
ADD constraint recursos_ubicacion FOREIGN KEY (ubicacion) REFERENCES ubicacion (id);
ALTER TABLE recursos
ADD constraint recursos_tiporecurso FOREIGN KEY (tiporecurso) REFERENCES tiporecurso (id);
ALTER TABLE reserva
ADD constraint reserva_recurso FOREIGN KEY (recurso) REFERENCES recursos (id_recursos);
alter table reserva
add constraint reserva_tiporeserva FOREIGN key (tiporeserva) REFERENCES tiporeserva(id);


--POBLAR
insert into ubicacion (id,ubicacion) values (1,'BloqueG');
insert into ubicacion (id,ubicacion) values (2,'BloqueB');
insert into ubicacion (id,ubicacion) values (3,'BibliotecaJorgeAlvarez');
insert into tiporecurso (id,tipo) values (1,'equipodecomputo');
insert into tiporecurso (id,tipo) values (2,'Saladeestudio');
insert into tiporecurso (id,tipo) values (3,'equipoultimedia');
insert into tiporeserva  (id,tipore) values (1,'Diario');
insert into tiporeserva (id,tipore) values (2,'Semanal');
insert into tiporeserva (id,tipore) values (3,'mensual');
insert into tiporeserva (id,tipore) values (4,'ninguna');
insert into tipousuario (id,nombre) values (1,'admin');
insert into tipousuario (id,nombre) values (2,'user');


insert into usuarios(documento,nombre,contrasena,correo,telefono,tipousuario)
values(00000,'pepito','9876','pepito@escuelaing.edu.co',876543,1);

INSERT INTO recursos (id_recursos,nombre,ubicacion,capacidad,horario_inicial,horario_final,disponibilidad,tiporecurso)
VALUES (6,'libro',1,1,'2021-12-13','2021-12-14',true,1);

insert into reserva(id_reserva,nombre,fechasoli,fechaini,fechafin,estado,usuario,recurso,tiporeserva)
VALUES (1,'reserva 1','2021-12-12','2022-12-13','2022-12-13',true,00000,6,1);





--DROP
drop TABLE usuarios cascade;
drop TABLE recursos cascade;
DROP TABLE tipousuario cascade;
DROP TABLE ubicacion cascade;
DROP TABLE tiporecurso cascade;
drop table reserva cascade;
drop table tiporeserva cascade;
--DELETE
Delete from recursos;
delete from usuarios;
delete from tipousuario;
delete from ubicacion;
delete from tiporecurso;
delete from reserva;
delete from tiporeserva;


