-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-07-2022 a las 20:39:43
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto_java`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrito`
--

CREATE TABLE `carrito` (
  `CAR_CODIGO` int(11) NOT NULL,
  `PER_CODIGO` int(11) DEFAULT NULL,
  `ZAP_CODIGO` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `carrito`
--

INSERT INTO `carrito` (`CAR_CODIGO`, `PER_CODIGO`, `ZAP_CODIGO`) VALUES
(2, 1, '1'),
(11, 3, '1'),
(13, 1, '3'),
(14, 1, '4'),
(15, 4, '6'),
(16, 4, '4'),
(17, 4, '3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_pedido`
--

CREATE TABLE `detalle_pedido` (
  `DEP_CODIGO` int(11) NOT NULL,
  `DEP_CANTIDAD` int(11) NOT NULL,
  `DEP_DESCUENTO` double DEFAULT NULL,
  `DEP_IVA` double DEFAULT NULL,
  `DEP_OBSERVACION` varchar(255) DEFAULT NULL,
  `DEP_PRECIO` double NOT NULL,
  `DEP_SUBTOTAL` double DEFAULT NULL,
  `PED_CODIGO` int(11) DEFAULT NULL,
  `ZAP_CODIGO` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle_pedido`
--

INSERT INTO `detalle_pedido` (`DEP_CODIGO`, `DEP_CANTIDAD`, `DEP_DESCUENTO`, `DEP_IVA`, `DEP_OBSERVACION`, `DEP_PRECIO`, `DEP_SUBTOTAL`, `PED_CODIGO`, `ZAP_CODIGO`) VALUES
(1, 5, 10, 12, 'calculando SubTotal', 18, 90.72, NULL, '1'),
(2, 4, 7, 12, 'calculando SubTotal', 26, 108.32639999999999, NULL, '2'),
(3, 4, 7, 12, 'calculando SubTotal', 26, 108.32639999999999, NULL, '2'),
(4, 10, 7, 12, 'calculando SubTotal', 50, 520.8, NULL, '3'),
(5, 5, 10, 12, 'calculando SubTotal', 18, 90.72, NULL, '1'),
(6, 3, 10, 12, 'calculando SubTotal', 20, 60.48, NULL, '3'),
(7, 3, 10, 12, 'calculando SubTotal', 20, 60.48, NULL, '3'),
(8, 5, 10, 12, 'calculando SubTotal', 18, 90.72, NULL, '4'),
(9, 5, 10, 12, 'calculando SubTotal', 10, 50.4, NULL, '2'),
(10, 4, 10, 12, 'calculando SubTotal', 8, 32.256, NULL, '3'),
(11, 3, 10, 12, 'calculando SubTotal', 30, 90.72, NULL, '6'),
(12, 5, 10, 12, 'calculando SubTotal', 55, 277.2, NULL, '2'),
(13, 5, 10, 12, 'calculando SubTotal', 55, 277.2, NULL, '2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrega`
--

CREATE TABLE `entrega` (
  `ENT_CODIGO` int(11) NOT NULL,
  `ENT_DESCRIPCION` varchar(255) DEFAULT NULL,
  `ENT_ESTADO` varchar(255) NOT NULL,
  `ENT_FECHA_ENVIO` datetime(6) DEFAULT NULL,
  `ENT_FECHA_RECIBE` datetime(6) DEFAULT NULL,
  `ENT_OBSERVACION` varchar(255) DEFAULT NULL,
  `ENT_RECIBE` varchar(255) DEFAULT NULL,
  `PED_CODIGO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `PED_CODIGO` int(11) NOT NULL,
  `PED_ESTADO` varchar(255) DEFAULT NULL,
  `PED_FACTURA` varchar(255) NOT NULL,
  `PED_FECHA` date NOT NULL,
  `PED_IVA` double DEFAULT NULL,
  `PED_OBSERVACION` varchar(255) DEFAULT NULL,
  `PED_SUBTOTAL` double DEFAULT NULL,
  `PER_CODIGO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`PED_CODIGO`, `PED_ESTADO`, `PED_FACTURA`, `PED_FECHA`, `PED_IVA`, `PED_OBSERVACION`, `PED_SUBTOTAL`, `PER_CODIGO`) VALUES
(1, 'Enviado', 'TTG01', '2022-07-16', 12, 'Frágil', NULL, 1),
(6, 'Enviado', 'TTG01', '2022-07-16', 12, 'Frágil', NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `PER_CODIGO` int(11) NOT NULL,
  `PER_APELLIDO` varchar(255) NOT NULL,
  `PER_DIRECCION` varchar(255) DEFAULT NULL,
  `PER_EMAIL` varchar(255) DEFAULT NULL,
  `PER_FECHA_NACIMIENTO` varchar(255) DEFAULT NULL,
  `PER_GENERO` varchar(255) DEFAULT NULL,
  `PER_IDENTIFICACION` varchar(255) NOT NULL,
  `PER_NOMBRE` varchar(255) NOT NULL,
  `PER_PASSWORD` varchar(255) DEFAULT NULL,
  `PER_ROLE` varchar(255) DEFAULT NULL,
  `PER_TALLA` varchar(255) DEFAULT NULL,
  `ZAP_CODIGO` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`PER_CODIGO`, `PER_APELLIDO`, `PER_DIRECCION`, `PER_EMAIL`, `PER_FECHA_NACIMIENTO`, `PER_GENERO`, `PER_IDENTIFICACION`, `PER_NOMBRE`, `PER_PASSWORD`, `PER_ROLE`, `PER_TALLA`, `ZAP_CODIGO`, `token`) VALUES
(1, 'Torres', 'Quito', 'boris@gmail.com', '11-02-1996', 'M', '1724399025', 'Boris', '12345', 'Admin', '40', NULL, NULL),
(2, 'Olivo', 'Cuenca', 'dayana@gmail.com', '22-04-1994', 'F', '1102984545', 'Dayana', '12345', 'Cliente', '36', NULL, NULL),
(3, 'Soria', 'Ambato', 'erika@gmail.com', '18-08-1998', 'F', '0604913286', 'Erika', '12345678', 'Cliente', '38', NULL, NULL),
(4, 'Gomez', 'Riobamba', 'andres@gmail.com', '26-11-1987', 'M', '1890173928', 'Andres', '12345678', 'Cliente', '40', NULL, NULL),
(5, 'Soria', 'Ambato', 'erika@gmail.com', '11-02-1998', 'F', '123456789', 'Erika', '12345', 'Cliente', '36', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zapato`
--

CREATE TABLE `zapato` (
  `ZAP_CODIGO` varchar(255) NOT NULL,
  `ZAP_COLOR` varchar(255) NOT NULL,
  `ZAP_GENERO` varchar(255) NOT NULL,
  `ZAP_MODELO` varchar(255) NOT NULL,
  `ZAP_NOMBRE` varchar(255) NOT NULL,
  `ZAP_PRECIO` double DEFAULT NULL,
  `ZAP_STOCK` int(11) NOT NULL,
  `ZAP_TALLA` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `zapato`
--

INSERT INTO `zapato` (`ZAP_CODIGO`, `ZAP_COLOR`, `ZAP_GENERO`, `ZAP_MODELO`, `ZAP_NOMBRE`, `ZAP_PRECIO`, `ZAP_STOCK`, `ZAP_TALLA`) VALUES
('1', 'Gris', 'F', 'Atleta', 'Reebok', 55, 99, '38'),
('100', 'Cafe', 'M', 'Casuales', 'Reebok', 60, 9, '40'),
('2', 'Blanco', 'M', 'Deportivos', 'Nike', 67, 3, '39'),
('3', 'Negro', 'M', 'Futbol', 'Puma', 80, 7, '41'),
('4', 'Negro', 'F', 'Hypervenom', 'Nike', 90, 15, '38'),
('5', 'Blanco', 'F', 'Total90', 'Adidas', 57, 6, '38'),
('6', 'Cafe', 'M', 'Casuales', 'Reebok', 60, 9, '40');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carrito`
--
ALTER TABLE `carrito`
  ADD PRIMARY KEY (`CAR_CODIGO`),
  ADD KEY `FKridbajasqbs734pw437jguaa7` (`ZAP_CODIGO`),
  ADD KEY `FK4lmxmar3himpcf172kanhsrnf` (`PER_CODIGO`);

--
-- Indices de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD PRIMARY KEY (`DEP_CODIGO`),
  ADD KEY `FK8q2h1837hjfow50vci4p8cu60` (`ZAP_CODIGO`),
  ADD KEY `FKag0j9ql5uoyj4n7q6oik0lgdq` (`PED_CODIGO`);

--
-- Indices de la tabla `entrega`
--
ALTER TABLE `entrega`
  ADD PRIMARY KEY (`ENT_CODIGO`),
  ADD KEY `FKd0lk48e45dhe8axndd86qxa3r` (`PED_CODIGO`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`PED_CODIGO`),
  ADD KEY `FKopt0g8tn898mxj868rtg1nc0m` (`PER_CODIGO`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`PER_CODIGO`);

--
-- Indices de la tabla `zapato`
--
ALTER TABLE `zapato`
  ADD PRIMARY KEY (`ZAP_CODIGO`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `carrito`
--
ALTER TABLE `carrito`
  MODIFY `CAR_CODIGO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  MODIFY `DEP_CODIGO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `entrega`
--
ALTER TABLE `entrega`
  MODIFY `ENT_CODIGO` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `PED_CODIGO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `PER_CODIGO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `carrito`
--
ALTER TABLE `carrito`
  ADD CONSTRAINT `FK4lmxmar3himpcf172kanhsrnf` FOREIGN KEY (`PER_CODIGO`) REFERENCES `persona` (`PER_CODIGO`),
  ADD CONSTRAINT `FKridbajasqbs734pw437jguaa7` FOREIGN KEY (`ZAP_CODIGO`) REFERENCES `zapato` (`ZAP_CODIGO`);

--
-- Filtros para la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD CONSTRAINT `FK8q2h1837hjfow50vci4p8cu60` FOREIGN KEY (`ZAP_CODIGO`) REFERENCES `zapato` (`ZAP_CODIGO`),
  ADD CONSTRAINT `FKag0j9ql5uoyj4n7q6oik0lgdq` FOREIGN KEY (`PED_CODIGO`) REFERENCES `pedido` (`PED_CODIGO`);

--
-- Filtros para la tabla `entrega`
--
ALTER TABLE `entrega`
  ADD CONSTRAINT `FKd0lk48e45dhe8axndd86qxa3r` FOREIGN KEY (`PED_CODIGO`) REFERENCES `pedido` (`PED_CODIGO`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `FKopt0g8tn898mxj868rtg1nc0m` FOREIGN KEY (`PER_CODIGO`) REFERENCES `persona` (`PER_CODIGO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
