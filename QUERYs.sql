-- 1. Eliminar un producto del carrito de compras
DELETE FROM Carro_de_Compras_Juego WHERE ID_Carro = [ID del Carro] AND ID_Juego = [ID del Juego];
-- 2 Mostrar los productos del carrito de compras
SELECT J.Nombre_Juego, J.Precio_Original
FROM Juego J
JOIN Carro_de_Compras_Juego C ON J.ID_Juego = C.ID_Juego
WHERE C.ID_Carro = [ID del Carro];
-- 3. Mostrar el precio total a pagar por el carrito de compras:
SELECT SUM(J.Precio_Original) AS Total_Pagar
FROM Juego J
JOIN Carro_de_Compras_Juego C ON J.ID_Juego = C.ID_Juego
WHERE C.ID_Carro = [ID del Carro];
-- 4. Calcular el promedio de juegos que los usuarios tienen en favoritos:
SELECT AVG(Conteo) AS Promedio_Favoritos
FROM (SELECT COUNT(*) AS Conteo
      FROM Juego_Cuenta_Usuario
      WHERE Es_favorito = TRUE
      GROUP BY ID_Usuario) AS Subconsulta;
-- 5. Mostrar ranking de los juegos que más personas tienen en favorito:
SELECT J.ID_Juego, J.Nombre_Juego, COUNT(*) AS Cantidad_Favoritos
FROM Juego J
JOIN Juego_Cuenta_Usuario JC ON J.ID_Juego = JC.ID_Juego
WHERE JC.Es_favorito = TRUE
GROUP BY J.ID_Juego, J.Nombre_Juego
ORDER BY Cantidad_Favoritos DESC;
-- 6. Mostrar juegos favoritos de un usuario:
SELECT J.Nombre_Juego
FROM Juego J
JOIN Juego_Cuenta_Usuario JC ON J.ID_Juego = JC.ID_Juego
WHERE JC.Es_favorito = TRUE AND JC.ID_Usuario = [ID del Usuario];
