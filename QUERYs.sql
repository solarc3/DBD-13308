-- Ranking de los juegos mas comprados
SELECT
    j.id_juego,
    j.nombre_juego,
    COUNT(cj.id_compra) AS cantidad_comprados
FROM
    juego j
JOIN
    compra_juego cj ON j.id_juego = cj.id_juego
GROUP BY
    j.id_juego, j.nombre_juego
ORDER BY
    cantidad_comprados DESC;
-- 1. Agregar un producto al carro de compras

INSERT INTO carro_de_compras_juego (id_carro, id_juego)
VALUES (1, 3);

-- 2. Eliminar un producto del carro de compras
DELETE FROM carro_de_compras_juego
WHERE id_carro = 3 AND id_juego = 6;

-- 3.Mostrar los Productos del Carrito de Compras
SELECT j.nombre_juego, j.precio_original
FROM juego j
JOIN carro_de_compras_juego cdj ON j.id_juego = cdj.id_juego
WHERE cdj.id_carro = 1;
-- 4. Precio total a pagar por carrito de compra
SELECT SUM(j.precio_original) AS total_a_pagar
FROM juego j
JOIN carro_de_compras_juego cdj ON j.id_juego = cdj.id_juego
WHERE cdj.id_carro = 1;

-- 5. Calcular el promedio de juegos que los usuarios tienen en promedio
SELECT AVG(cantidad_favoritos) FROM (
    SELECT id_usuario, COUNT(id_juego) AS cantidad_favoritos
    FROM juego_cuenta_usuario
    WHERE es_favorito = true
    GROUP BY id_usuario
) AS favoritos_por_usuario;
-- 6. Ranking de los juegos que mas personas tienen en favoritos
SELECT j.nombre_juego, COUNT(jcu.id_usuario) AS cantidad_favoritos
FROM juego_cuenta_usuario jcu
JOIN juego j ON jcu.id_juego = j.id_juego
WHERE jcu.es_favorito = true
GROUP BY j.nombre_juego
ORDER BY cantidad_favoritos DESC;
-- 7. Los juegos favoritos de un usuario
SELECT j.nombre_juego
FROM juego j
JOIN juego_cuenta_usuario jcu ON j.id_juego = jcu.id_juego
WHERE jcu.id_usuario = 7 AND jcu.es_favorito = true;
