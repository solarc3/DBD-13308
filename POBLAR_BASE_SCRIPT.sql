-- A NINGUNO SE LE AGREGA CON ID YA QUE SON AUTOINCREMENTALES SERIALES
-- borrado de datos para empezar de 0
DELETE FROM compra_juego where id_compra > 0 OR id_juego > 0;
DELETE FROM compra_cuenta_usuario where id_compra > 0 OR id_usuario > 0;
DELETE FROM compra where id_compra > 0;
DELETE FROM tipo_cuenta_usuario where id_tipo > 0 OR id_usuario > 0;
DELETE FROM juego_genero where id_genero > 0 OR id_juego > 0;
DELETE FROM juego_cuenta_usuario where id_juego > 0 OR id_usuario > 0;
DELETE FROM valoracion_cuenta_usuario where id_valoracion > 0 OR id_usuario > 0;
DELETE FROM carro_de_compras_juego where id_carro > 0 OR id_juego > 0;
DELETE FROM seguimiento where id_usuario_seguidor > 0 OR id_usuario_seguido > 0;
DELETE FROM carro_de_compras where id_carro > 0;
DELETE FROM cuenta_usuario where id_usuario > 0;
DELETE FROM boleta where id_boleta > 0;
DELETE FROM valoracion where id_valoracion > 0;
DELETE FROM tipo where id_tipo > 0;
DELETE FROM genero where id_genero > 0;
DELETE FROM juego where id_juego > 0;
DELETE FROM medio_de_pago where id_pago > 0;
-- reinicio de llaves seriales para que partan de 1
ALTER SEQUENCE compra_id_compra_seq RESTART;
ALTER SEQUENCE boleta_id_boleta_seq RESTART;
ALTER SEQUENCE carro_de_compras_id_carro_seq RESTART;
ALTER SEQUENCE cuenta_usuario_id_usuario_seq RESTART;
ALTER SEQUENCE valoracion_id_valoracion_seq RESTART;
ALTER SEQUENCE tipo_id_tipo_seq RESTART;
ALTER SEQUENCE genero_id_genero_seq RESTART;
ALTER SEQUENCE juego_id_juego_seq RESTART;
ALTER SEQUENCE medio_de_pago_id_pago_seq RESTART;
-- agregamos tipo Usuario a los tipos
INSERT INTO tipo(nombre_tipo) VALUES ('Usuario');
INSERT INTO tipo(nombre_tipo) VALUES ('Administrador');
INSERT INTO tipo(nombre_tipo) VALUES ('Developer');
-- agregamos usuarios
INSERT INTO cuenta_usuario(nombre_usuario,correo,contrasena,fecha_nacimiento) VALUES('xXPedroGamerXx','pedritopro@gmail.com','pedrito1234','1999-01-01');
INSERT INTO cuenta_usuario(nombre_usuario,correo,contrasena,fecha_nacimiento) VALUES('BodoquePro','Atun1989@protonmail.com','ASDASD123123','1989-01-01');
INSERT INTO cuenta_usuario(nombre_usuario,correo,contrasena,fecha_nacimiento) VALUES('Darius','noxus@hotmail.com','Trifarian956','1957-04-21');
INSERT INTO cuenta_usuario(nombre_usuario,correo,contrasena,fecha_nacimiento) VALUES('Michael Jackson','jackson@vevo.com','Thriller123','1958-08-29');
INSERT INTO cuenta_usuario(nombre_usuario,correo,contrasena,fecha_nacimiento) VALUES('Barack Obama','obama.barack@whitehouse.usa','soyeladmin','1961-08-04');
INSERT INTO cuenta_usuario(nombre_usuario,correo,contrasena,fecha_nacimiento) VALUES('Alan Turing','turing@gmail.com','enigmagoesbrr','1912-06-23');
INSERT INTO cuenta_usuario(nombre_usuario,correo,contrasena,fecha_nacimiento) VALUES('Albert Einstein','einsteinAlbert@mit.edu','emc2','1879-03-14');
INSERT INTO cuenta_usuario(nombre_usuario,correo,contrasena,fecha_nacimiento) VALUES('Cesar Riquelme','cesarito@gmail.com','123456789','1945-08-19');
INSERT INTO cuenta_usuario(nombre_usuario,correo,contrasena,fecha_nacimiento) VALUES('Reinaldo Baeza','condorito@vtr.cl','condorito123','1949-01-01');
INSERT INTO cuenta_usuario(nombre_usuario,correo,contrasena,fecha_nacimiento) VALUES('Sylvanas Windrunner','sylvanas@blizzard.eu','shadowlands','2004-11-23');
-- agregamos a los usuarios a con su respectivo tipo
INSERT INTO tipo_cuenta_usuario(id_tipo,id_usuario) VALUES(1,1);
INSERT INTO tipo_cuenta_usuario(id_tipo,id_usuario) VALUES(1,2);
INSERT INTO tipo_cuenta_usuario(id_tipo,id_usuario) VALUES(1,3);
INSERT INTO tipo_cuenta_usuario(id_tipo,id_usuario) VALUES(1,4);
-- Barack Obama es administrador y cesar riquelme es developer
INSERT INTO tipo_cuenta_usuario(id_tipo,id_usuario) VALUES(2,5);
INSERT INTO tipo_cuenta_usuario(id_tipo,id_usuario) VALUES(1,6);
INSERT INTO tipo_cuenta_usuario(id_tipo,id_usuario) VALUES(1,7);
INSERT INTO tipo_cuenta_usuario(id_tipo,id_usuario) VALUES(3,8);
INSERT INTO tipo_cuenta_usuario(id_tipo,id_usuario) VALUES(1,9);
INSERT INTO tipo_cuenta_usuario(id_tipo,id_usuario) VALUES(1,10);
-- agregamos generos
INSERT INTO genero(nombre_genero) VALUES('Accion');
INSERT INTO genero(nombre_genero) VALUES('Aventura');
INSERT INTO genero(nombre_genero) VALUES('Estrategia');
INSERT INTO genero(nombre_genero) VALUES('Rol');
INSERT INTO genero(nombre_genero) VALUES('Simulacion');
INSERT INTO genero(nombre_genero) VALUES('Deportes');
INSERT INTO genero(nombre_genero) VALUES('Carreras');
INSERT INTO genero(nombre_genero) VALUES('Peleas');
INSERT INTO genero(nombre_genero) VALUES('Puzzle');
INSERT INTO genero(nombre_genero) VALUES('Shooter');
INSERT INTO genero(nombre_genero) VALUES('Survival');
INSERT INTO genero(nombre_genero) VALUES('Terror');
INSERT INTO genero(nombre_genero) VALUES('MMO');
INSERT INTO genero(nombre_genero) VALUES('RPG');
-- creacion de juegos
INSERT INTO juego(nombre_juego, descripcion, precio_original, precio_oferta, descuento, restriccion_edad) VALUES('The Witcher 3','The Witcher 3: Wild Hunt es un videojuego desarrollado por CD Projekt RED., Aventuras EPICAS!',29990,14995,'50',true);
-- se agrega un juego sin todos los valores para probar que se agregan por defecto
INSERT INTO juego(nombre_juego, descripcion, precio_original) VALUES('League of Legends','Mas adictivo que las drogas, pero gratis!',0);
INSERT INTO juego(nombre_juego, descripcion, precio_original, precio_oferta, descuento, restriccion_edad) VALUES('CSGO','Juego de disparos en primera persona, competitivo y adictivo',14990,7495,'50',true);
INSERT INTO juego(nombre_juego, descripcion, precio_original, restriccion_edad) VALUES('Minecraft','Juego de construir y sobrevivir, muy entretenido',35990,false);
INSERT INTO juego(nombre_juego, descripcion, precio_original, precio_oferta, descuento, restriccion_edad) VALUES('Among Us','Juego de mentiras y traiciones',4990,2495,'50',false);
INSERT INTO juego(nombre_juego, descripcion, precio_original, precio_oferta, descuento, restriccion_edad) VALUES('GTA V','Juego de mundo abierto, intenta explorarlo todo!',39990,7998,'80',true);
INSERT INTO juego(nombre_juego, descripcion, precio_original, precio_oferta, descuento, restriccion_edad) VALUES('FIFA 21','Juego de futbol, el mejor de su genero',65990,62690,'5',true);
INSERT INTO juego(nombre_juego, descripcion, precio_original) VALUES('Half Life 3','Continuacion de la famosa saga!',79990);
INSERT INTO juego(nombre_juego, descripcion, precio_original, precio_oferta, descuento, restriccion_edad) VALUES('Usach Quest','Epica aventura mundo abierto!',29990,22492,'25',true);
-- se agregan los juegos a los generos
INSERT INTO juego_genero(id_juego,id_genero) VALUES(1,3);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(1,4);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(1,5);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(1,6);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(2,1);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(2,5);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(2,10);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(3,1);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(3,2);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(3,10);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(3,11);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(4,1);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(4,2);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(4,11);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(5,1);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(5,3);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(5,4);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(6,1);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(6,2);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(6,5);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(6,7);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(6,10);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(7,5);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(7,6);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(7,13);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(8,1);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(8,2);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(8,10);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(8,14);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(9,1);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(9,2);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(9,7);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(9,10);
INSERT INTO juego_genero(id_juego,id_genero) VALUES(9,13);
-- se agregan los juegos a los usuarios y si es favorito
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario) VALUES(1,1);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario) VALUES(1,2);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario) VALUES(1,3);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario,es_favorito) VALUES(1,4,true);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario) VALUES(1,5);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario,es_favorito) VALUES(1,6,true);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario) VALUES(2,3);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario) VALUES(2,4);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario) VALUES(2,5);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario) VALUES(2,6);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario,es_favorito) VALUES(2,7,true);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario) VALUES(3,1);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario,es_favorito) VALUES(3,2,true);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario,es_favorito) VALUES(4,1,true);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario) VALUES(4,2);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario) VALUES(4,3);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario) VALUES(4,4);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario,es_favorito) VALUES(5,5,true);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario) VALUES(5,6);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario) VALUES(5,7);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario,es_favorito) VALUES(6,8,true);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario) VALUES(7,9);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario) VALUES(8,10);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario) VALUES(9,1);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario) VALUES(9,2);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario) VALUES(9,3);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario) VALUES(9,4);
INSERT INTO juego_cuenta_usuario(id_juego,id_usuario,es_favorito) VALUES(9,7,true);
-- agregar seguidos
INSERT INTO seguimiento(id_usuario_seguidor,id_usuario_seguido) VALUES(1,2);
INSERT INTO seguimiento(id_usuario_seguidor,id_usuario_seguido) VALUES(1,3);
INSERT INTO seguimiento(id_usuario_seguidor,id_usuario_seguido) VALUES(1,4);
INSERT INTO seguimiento(id_usuario_seguidor,id_usuario_seguido) VALUES(1,5);
INSERT INTO seguimiento(id_usuario_seguidor,id_usuario_seguido) VALUES(1,6);
INSERT INTO seguimiento(id_usuario_seguidor,id_usuario_seguido) VALUES(2,1);
INSERT INTO seguimiento(id_usuario_seguidor,id_usuario_seguido) VALUES(2,3);
INSERT INTO seguimiento(id_usuario_seguidor,id_usuario_seguido) VALUES(2,4);
INSERT INTO seguimiento(id_usuario_seguidor,id_usuario_seguido) VALUES(9,4);
INSERT INTO seguimiento(id_usuario_seguidor,id_usuario_seguido) VALUES(9,5);
INSERT INTO seguimiento(id_usuario_seguidor,id_usuario_seguido) VALUES(10,1);
INSERT INTO seguimiento(id_usuario_seguidor,id_usuario_seguido) VALUES(10,2);
INSERT INTO seguimiento(id_usuario_seguidor,id_usuario_seguido) VALUES(10,3);
INSERT INTO seguimiento(id_usuario_seguidor,id_usuario_seguido) VALUES(10,4);
INSERT INTO seguimiento(id_usuario_seguidor,id_usuario_seguido) VALUES(10,5);
INSERT INTO seguimiento(id_usuario_seguidor,id_usuario_seguido) VALUES(10,6);
-- agregar medios de pago
INSERT INTO medio_de_pago(nombre_del_medio,datos_del_medio) VALUES('VISA','Tarjeta de credito');
INSERT INTO medio_de_pago(nombre_del_medio,datos_del_medio) VALUES('Mastercard','Tarjeta de Credito ');
INSERT INTO medio_de_pago(nombre_del_medio,datos_del_medio) VALUES('Paypal','Cuenta digital');
INSERT INTO medio_de_pago(nombre_del_medio,datos_del_medio) VALUES('Webpay','Cuenta digital');
INSERT INTO medio_de_pago(nombre_del_medio,datos_del_medio) VALUES('Mercado Pago','Cuenta digital');
INSERT INTO medio_de_pago(nombre_del_medio,datos_del_medio) VALUES('Transferencia Bancaria','Cuenta bancaria');
INSERT INTO medio_de_pago(nombre_del_medio,datos_del_medio) VALUES('Cuenta Rut','Cuenta bancaria');
INSERT INTO medio_de_pago(nombre_del_medio,datos_del_medio) VALUES('Western Union','Transferencia Fisica');
-- agregar valoraciones
INSERT INTO valoracion(puntuacion, id_juego) VALUES (1, 5);
INSERT INTO valoracion(puntuacion, id_juego) VALUES (2, 4);
INSERT INTO valoracion(puntuacion, id_juego) VALUES (3, 3);
INSERT INTO valoracion(puntuacion, id_juego) VALUES (4, 2);
INSERT INTO valoracion(puntuacion, id_juego) VALUES (5, 1);
INSERT INTO valoracion(puntuacion, id_juego) VALUES (5, 2);
INSERT INTO valoracion(puntuacion, id_juego) VALUES (5, 3);
INSERT INTO valoracion(puntuacion, id_juego) VALUES (5, 4);
INSERT INTO valoracion(puntuacion, id_juego) VALUES (5, 5);
-- agregar valoraciones a usuarios
INSERT INTO valoracion_cuenta_usuario(id_valoracion, id_usuario) VALUES (1, 1);
INSERT INTO valoracion_cuenta_usuario(id_valoracion, id_usuario) VALUES (2, 2);
INSERT INTO valoracion_cuenta_usuario(id_valoracion, id_usuario) VALUES (3, 3);
INSERT INTO valoracion_cuenta_usuario(id_valoracion, id_usuario) VALUES (4, 4);
INSERT INTO valoracion_cuenta_usuario(id_valoracion, id_usuario) VALUES (5, 5);
INSERT INTO valoracion_cuenta_usuario(id_valoracion, id_usuario) VALUES (6, 6);
INSERT INTO valoracion_cuenta_usuario(id_valoracion, id_usuario) VALUES (7, 7);
INSERT INTO valoracion_cuenta_usuario(id_valoracion, id_usuario) VALUES (8, 8);
INSERT INTO valoracion_cuenta_usuario(id_valoracion, id_usuario) VALUES (9, 9);
-- agregar carros de compra
-- juegos en carro, es la cantidad de juegos
INSERT INTO carro_de_compras(juegos_en_carro, id_usuario) VALUES (1, 1);
INSERT INTO carro_de_compras(juegos_en_carro, id_usuario) VALUES (2, 2);
INSERT INTO carro_de_compras(juegos_en_carro, id_usuario) VALUES (3, 3);
-- puedes tener cosas en el carro pero no necesariamente comprarlas
INSERT INTO carro_de_compras(juegos_en_carro, id_usuario) VALUES (2, 4);
-- agregar juegos a carros de compra
INSERT INTO carro_de_compras_juego(id_carro, id_juego) VALUES (1, 1);
INSERT INTO carro_de_compras_juego(id_carro, id_juego) VALUES (2, 2);
INSERT INTO carro_de_compras_juego(id_carro, id_juego) VALUES (2, 3);
INSERT INTO carro_de_compras_juego(id_carro, id_juego) VALUES (3, 4);
INSERT INTO carro_de_compras_juego(id_carro, id_juego) VALUES (3, 5);
INSERT INTO carro_de_compras_juego(id_carro, id_juego) VALUES (3, 6);
-- agregar boletas
INSERT INTO boleta(fecha) VALUES ('2021-06-01');
INSERT INTO boleta(fecha) VALUES ('2021-06-02');
INSERT INTO boleta(fecha) VALUES ('2021-06-03');
-- agregar compras
-- considerando que todos los juegos que estan en oferta, fue aplicado el descuento
-- compro el juego 1
INSERT INTO compra(total_pagado, juegos_comprados, id_pago, id_boleta, id_carro) VALUES (14995, 1, 1, 1, 1);
-- compro el juego 2 y 3 (el lol es gratis)
INSERT INTO compra(total_pagado, juegos_comprados, id_pago, id_boleta, id_carro) VALUES (7495, 2, 2, 2, 2);
-- compro el juego 4 5 y 6
INSERT INTO compra(total_pagado, juegos_comprados, id_pago, id_boleta, id_carro) VALUES (46483, 3, 3, 3, 3);
-- agregar compras a los usuarios, aqui se relacionan por la compra, el id del carro y el usuario y los juegos que tenian
-- el carro tiene que ver con el id de la persona
INSERT INTO compra_cuenta_usuario(id_compra, id_usuario) VALUES (1,1);
INSERT INTO compra_cuenta_usuario(id_compra, id_usuario) VALUES (2,2);
INSERT INTO compra_cuenta_usuario(id_compra, id_usuario) VALUES (3,3);
-- agregar los juegos comprados
INSERT INTO compra_juego(id_compra, id_juego) VALUES (1,1);
INSERT INTO compra_juego(id_compra, id_juego) VALUES (2,2);
INSERT INTO compra_juego(id_compra, id_juego) VALUES (2,3);
INSERT INTO compra_juego(id_compra, id_juego) VALUES (3,4);
INSERT INTO compra_juego(id_compra, id_juego) VALUES (3,5);
INSERT INTO compra_juego(id_compra, id_juego) VALUES (3,6);