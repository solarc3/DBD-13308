create table if not exists cuenta_usuario
(
    id_usuario       serial,
    nombre_usuario   text,
    correo           text,
    contrasena       text,
    fecha_nacimiento date,
    primary key (id_usuario)
);

create table if not exists juego
(
    id_juego         serial,
    nombre_juego     text,
    descripcion      text,
    precio_original  integer,
    precio_oferta    integer,
    descuento        integer,
    restriccion_edad boolean,
    primary key (id_juego)
);

create table if not exists genero
(
    id_genero     serial,
    nombre_genero text,
    primary key (id_genero)
);

create table if not exists ranking
(
    id_ranking         serial,
    cantidad_comprados integer,
    cantidad_favoritos integer,
    id_juego           integer,
    primary key (id_ranking),
    foreign key (id_juego) references juego
);

create table if not exists valoracion
(
    id_valoracion serial,
    puntuacion    integer,
    id_juego      integer,
    primary key (id_valoracion),
    foreign key (id_juego) references juego
);

create table if not exists tipo
(
    id_tipo     serial,
    nombre_tipo text,
    primary key (id_tipo)
);

create table if not exists carro_de_compras
(
    id_carro        serial,
    juegos_en_carro integer,
    id_usuario      integer,
    primary key (id_carro),
    foreign key (id_usuario) references cuenta_usuario
);

create table if not exists medio_de_pago
(
    id_pago          serial,
    nombre_del_medio text,
    datos_del_medio  text,
    primary key (id_pago)
);

create table if not exists boleta
(
    id_boleta serial,
    detalle   text,
    primary key (id_boleta)
);

create table if not exists compra
(
    id_compra        serial,
    total_pagado     integer,
    juegos_comprados integer,
    id_pago          integer,
    id_boleta        integer,
    id_carro         integer,
    primary key (id_compra),
    foreign key (id_pago) references medio_de_pago,
    foreign key (id_boleta) references boleta,
    foreign key (id_carro) references carro_de_compras
);

create table if not exists compra_cuenta_usuario
(
    id_compra  integer not null,
    id_usuario integer not null,
    primary key (id_compra, id_usuario),
    foreign key (id_compra) references compra,
    foreign key (id_usuario) references cuenta_usuario
);

create table if not exists tipo_cuenta_usuario
(
    id_tipo    integer not null,
    id_usuario integer not null,
    primary key (id_tipo, id_usuario),
    foreign key (id_tipo) references tipo,
    foreign key (id_usuario) references cuenta_usuario
);

create table if not exists compra_juego
(
    id_compra integer not null,
    id_juego  integer not null,
    primary key (id_compra, id_juego),
    foreign key (id_compra) references compra,
    foreign key (id_juego) references juego
);

create table if not exists juego_cuenta_usuario
(
    id_juego    integer not null,
    id_usuario  integer not null,
    es_favorito boolean,
    primary key (id_juego, id_usuario),
    foreign key (id_juego) references juego,
    foreign key (id_usuario) references cuenta_usuario
);

create table if not exists juego_genero
(
    id_juego  integer not null,
    id_genero integer not null,
    primary key (id_juego, id_genero),
    foreign key (id_juego) references juego,
    foreign key (id_genero) references genero
);

create table if not exists carro_de_compras_juego
(
    id_carro integer not null,
    id_juego integer not null,
    primary key (id_carro, id_juego),
    foreign key (id_carro) references carro_de_compras,
    foreign key (id_juego) references juego
);

create table if not exists seguimiento
(
    id_usuario_seguidor integer not null,
    id_usuario_seguido  integer not null,
    primary key (id_usuario_seguidor, id_usuario_seguido),
    foreign key (id_usuario_seguidor) references cuenta_usuario,
    foreign key (id_usuario_seguido) references cuenta_usuario
);

create table if not exists valoracion_cuenta_usuario
(
    id_usuario    integer not null,
    id_valoracion integer not null,
    primary key (id_usuario, id_valoracion),
    foreign key (id_usuario) references cuenta_usuario,
    foreign key (id_valoracion) references valoracion
);


