create table usuarios(

documento INT,
nombre VARCHAR(20),
contraseņa VARCHAR(16),
correo VARCHAR(20),
telefono VARCHAR(20),
tipousuario VARCHAR(3)

);

create table tipo_usuario(

id_tipousuario VARCHAR(3),
nombre VARCHAR(20),
descripcion VARCHAR(150)

);

create table recursos(

id_recursos INT,
nombre VARCHAR(20),
ubicacion VARCHAR(20),
capacidad INT,
tiporecurso INT,
fecha DATE,
horario_inicial TIME,
horario_final TIME

);

create table tipo_recurso(

id_tiporecurso INT,
nombre VARCHAR(20),
descripcion VARCHAR(22)

);