create database sistema;

use sistema;

create table servicio(
id_servicio int not null auto_increment primary key,
nombre varchar (255) not null);



create table cliente(
id_cliente int not null auto_increment primary key,
razon_social varchar (255) not null,
cuit varchar (50) not null,
email varchar (255) not null);

create table tecnico(
id_tecnico int not null auto_increment primary key,
nombre varchar (255) not null,
telefono varchar (50) not null,
email varchar (255) not null);


create table especialidad(
id_especialidad int not null auto_increment primary key,
nombre varchar (255) not null);

create table tipo_problema(
id_tipo_problema int not null auto_increment primary key,
nombre varchar (255) not null,
tiempo_estimado_dias int);

create table tecnico_especialidad(
id_tecnico_especialidad int not null auto_increment primary key,
id_tecnico int,
id_especialidad int,
foreign key(id_tecnico) references tecnico(id_tecnico),
foreign key(id_especialidad) references especialidad(id_especialidad));


create table incidente(
id_incidente int not null auto_increment primary key,
alias varchar (255) not null,
fecha_estimada date,
fecha_desde date,
fecha_hasta date,
resuelto tinyint,
consideraciones text,
id_tecnico int,
id_cliente int,
foreign key(id_tecnico) references tecnico(id_tecnico),
foreign key(id_cliente) references cliente(id_cliente));

create table problema_especialidad(
id_problema_especialidad int not null auto_increment primary key,
id_tipo_problema int,
id_especialidad int,
foreign key(id_tipo_problema) references tipo_problema(id_tipo_problema),
foreign key(id_especialidad) references especialidad(id_especialidad));

create table cliente_servicio(
id_cliente_servicio int not null auto_increment primary key,
id_cliente int,
id_servicio int,
foreign key(id_cliente) references cliente(id_cliente),
foreign key(id_servicio) references servicio(id_servicio));

create table incidente_detalle(
id_incidente_detalle int not null auto_increment primary key,
descripcion varchar(255) not null,
id_incidente int,
id_servicio int,
id_tipo_problema int,
foreign key(id_incidente) references incidente(id_incidente),
foreign key(id_servicio) references servicio(id_servicio),
foreign key(id_tipo_problema) references tipo_problema(id_tipo_problema));






















 

 




