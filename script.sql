create table productos
(
    producto     varchar(40),
    id_productor serial
        constraint productos_pk
            primary key
);

create table consumidor
(
    nombre   varchar(40) not null,
    apellido varchar(40) not null,
    rut      integer     not null
        constraint consumidor_pk
            primary key,
    id       serial
        constraint consumidor_pk3
            unique
);

create table ordenes
(
    product_id  integer           not null
        constraint producto_fk
            references productos,
    customer_id integer           not null
        constraint consumidor_fk
            references consumidor (id),
    cantidad    integer default 1 not null,
    fecha       timestamp,
    constraint ordenes_pk
        primary key (customer_id, product_id)
);

comment on table ordenes is 'tabla M:M ';


