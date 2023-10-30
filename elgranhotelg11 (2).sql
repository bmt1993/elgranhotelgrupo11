-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-10-2023 a las 23:45:52
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `elgranhotelg11`
--
CREATE DATABASE IF NOT EXISTS `elgranhotelg11` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `elgranhotelg11`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `idhabitacion` int(11) NOT NULL,
  `piso` int(11) NOT NULL,
  `estadohabitacion` varchar(16) NOT NULL,
  `categoria` varchar(9) NOT NULL,
  `camassimples` int(11) NOT NULL,
  `camasdobles` int(11) NOT NULL,
  `librehasta` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `habitacion`
--

INSERT INTO `habitacion` (`idhabitacion`, `piso`, `estadohabitacion`, `categoria`, `camassimples`, `camasdobles`, `librehasta`) VALUES
(1, 1, 'Libre', 'Comfort', 2, 0, '0000-00-00'),
(2, 1, 'Libre', 'Comfort', 0, 1, '0000-00-00'),
(3, 1, 'Libre', 'Privilege', 2, 0, '0000-00-00'),
(4, 1, 'Libre', 'Privilege', 0, 1, '0000-00-00'),
(5, 1, 'Libre', 'Luxury', 2, 0, '0000-00-00'),
(6, 1, 'Libre', 'Luxury', 0, 1, '0000-00-00'),
(7, 1, 'Libre', 'Privilege', 3, 0, '0000-00-00'),
(8, 1, 'Libre', 'Privilege', 1, 1, '0000-00-00'),
(9, 1, 'Libre', 'Luxury', 3, 0, '0000-00-00'),
(10, 1, 'Libre', 'Luxury', 1, 1, '0000-00-00'),
(11, 1, 'Libre', 'Privilege', 4, 0, '0000-00-00'),
(12, 1, 'Libre', 'Privilege', 2, 1, '0000-00-00'),
(13, 1, 'Libre', 'Luxury', 4, 0, '0000-00-00'),
(14, 2, 'Libre', 'Luxury', 2, 1, '0000-00-00'),
(15, 2, 'Libre', 'Comfort', 2, 0, '0000-00-00'),
(16, 2, 'Libre', 'Comfort', 0, 1, '0000-00-00'),
(17, 2, 'Libre', 'Privilege', 2, 0, '0000-00-00'),
(18, 2, 'Libre', 'Privilege', 0, 1, '0000-00-00'),
(19, 2, 'Libre', 'Luxury', 2, 0, '0000-00-00'),
(20, 2, 'Libre', 'Luxury', 0, 1, '0000-00-00'),
(21, 2, 'Libre', 'Privilege', 3, 0, '0000-00-00'),
(22, 2, 'Libre', 'Privilege', 1, 1, '0000-00-00'),
(23, 2, 'Libre', 'Luxury', 3, 0, '0000-00-00'),
(24, 2, 'Libre', 'Luxury', 1, 1, '0000-00-00'),
(25, 2, 'Libre', 'Privilege', 4, 0, '0000-00-00'),
(26, 2, 'Libre', 'Privilege', 2, 1, '0000-00-00'),
(27, 2, 'Libre', 'Luxury', 4, 0, '0000-00-00'),
(28, 3, 'Libre', 'Luxury', 2, 1, '0000-00-00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `huesped`
--

CREATE TABLE `huesped` (
  `dni` bigint(20) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `telefono` bigint(20) NOT NULL,
  `domicilio` varchar(30) NOT NULL,
  `pais` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `idhabitacion` int(11) NOT NULL,
  `dni` bigint(20) NOT NULL,
  `checkin` date NOT NULL,
  `checkout` date NOT NULL,
  `estadoreserva` varchar(9) NOT NULL,
  `montobase` double NOT NULL,
  `montofinal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`idhabitacion`);

--
-- Indices de la tabla `huesped`
--
ALTER TABLE `huesped`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD KEY `idhabitacion` (`idhabitacion`),
  ADD KEY `dni` (`dni`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`idhabitacion`) REFERENCES `habitacion` (`idhabitacion`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`dni`) REFERENCES `huesped` (`dni`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
