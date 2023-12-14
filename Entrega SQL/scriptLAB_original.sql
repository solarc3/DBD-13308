CREATE TABLE Cuenta_Usuario
(
    ID_Usuario serial primary key,
    Nombre_Usuario text,
    Correo text,
    Contrasena text,
    Fecha_Nacimiento date
    );

CREATE TABLE Juego
(
    ID_Juego        serial primary key,
    Nombre_Juego    text,
    Descripcion     text,
    Precio_Original int,
    Precio_Oferta   int,
    Descuento int,
    Restriccion_Edad bool
);

CREATE TABLE Genero
(
    ID_Genero   serial primary key,
    Nombre_Genero text
);

CREATE TABLE Ranking
(
    ID_Ranking serial primary key,
    Cantidad_Comprados int,
    Cantidad_Favoritos int,
    ID_juego int,
    foreign key (ID_Juego) references Juego(ID_Juego)
);

CREATE TABLE Valoracion
(
    ID_Valoracion serial primary key,
    Puntuacion int,
    ID_Juego int,
    foreign key (ID_Juego) references Juego(ID_Juego)
);
CREATE TABLE Tipo
(   ID_Tipo serial primary key,
    Nombre_Tipo text
);
CREATE TABLE Carro_de_Compras
(
    ID_Carro serial primary key,
    Juegos_en_Carro int,
    ID_Usuario int,
    foreign key (ID_Usuario) references Cuenta_Usuario(ID_Usuario)
);
CREATE TABLE Medio_de_Pago
(
    ID_pago serial primary key,
    Nombre_del_medio text,
    Datos_del_medio text
);
CREATE TABLE Boleta
(
    ID_Boleta serial primary key,
    Detalle text
);
CREATE TABLE Compra
(
    ID_Compra serial primary key,
    Total_Pagado int,
    Juegos_comprados int,
    ID_pago int,
    ID_Boleta int,
    ID_Carro int,
    foreign key (ID_pago) references Medio_de_Pago(ID_pago),
    foreign key (ID_Boleta) references Boleta(ID_Boleta),
    foreign key (ID_Carro) references Carro_de_Compras(ID_Carro)
);

CREATE TABLE Compra_Cuenta_Usuario
(
    ID_Compra int,
    ID_Usuario int,
    PRIMARY KEY (ID_Compra, ID_Usuario),
    FOREIGN KEY (ID_Compra) REFERENCES Compra(ID_Compra),
    FOREIGN KEY (ID_Usuario) REFERENCES Cuenta_Usuario(ID_Usuario)
);
CREATE TABLE Tipo_Cuenta_Usuario
(
    ID_Tipo int,
    ID_Usuario int,
    PRIMARY KEY (ID_Tipo, ID_Usuario),
    FOREIGN KEY (ID_Tipo) REFERENCES Tipo(ID_Tipo),
    FOREIGN KEY (ID_Usuario) REFERENCES Cuenta_Usuario(ID_Usuario)
);
CREATE TABLE Compra_Juego
(
    ID_Compra int,
    ID_Juego int,
    PRIMARY KEY (ID_Compra, ID_Juego),
    FOREIGN KEY (ID_Compra) REFERENCES Compra(ID_Compra),
    FOREIGN KEY (ID_Juego) REFERENCES Juego(ID_Juego)
);
CREATE TABLE Juego_Cuenta_Usuario
(
    ID_Juego int,
    ID_Usuario int,
    Es_favorito bool,
    PRIMARY KEY (ID_Juego, ID_Usuario),
    FOREIGN KEY (ID_Juego) REFERENCES Juego(ID_Juego),
    FOREIGN KEY (ID_Usuario) REFERENCES Cuenta_Usuario(ID_Usuario)
);
CREATE TABLE Juego_Genero
(
    ID_Juego int,
    ID_Genero int,
    PRIMARY KEY (ID_Juego, ID_Genero),
    FOREIGN KEY (ID_Juego) REFERENCES Juego(ID_Juego),
    FOREIGN KEY (ID_Genero) REFERENCES Genero(ID_Genero)
);
CREATE TABLE Carro_de_Compras_Juego
(
    ID_Carro int,
    ID_Juego int,
    PRIMARY KEY (ID_Carro, ID_Juego),
    FOREIGN KEY (ID_Carro) REFERENCES Carro_de_Compras(ID_Carro),
    FOREIGN KEY (ID_Juego) REFERENCES Juego(ID_Juego)
);
CREATE TABLE Seguimiento
(
    ID_Usuario_Seguidor int,
    ID_Usuario_Seguido int,
    PRIMARY KEY (ID_Usuario_Seguidor, ID_Usuario_Seguido),
    FOREIGN KEY (ID_Usuario_Seguidor) REFERENCES Cuenta_Usuario(ID_Usuario),
    FOREIGN KEY (ID_Usuario_Seguido) REFERENCES Cuenta_Usuario(ID_Usuario)
);
CREATE TABLE Valoracion_Cuenta_Usuario
(
    ID_Usuario int,
    ID_Valoracion int,
    PRIMARY KEY (ID_Usuario, ID_Valoracion),
    FOREIGN KEY (ID_Usuario) REFERENCES Cuenta_Usuario(ID_Usuario),
    FOREIGN KEY (ID_Valoracion) REFERENCES Valoracion(ID_Valoracion)
);
