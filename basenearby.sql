-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-12-2024 a las 00:50:52
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `basenearby`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias_match`
--

CREATE TABLE `categorias_match` (
  `cat_mat_id` int(11) NOT NULL,
  `cat_mat_amistad` varchar(15) DEFAULT NULL,
  `cat_mat_casual` varchar(15) DEFAULT NULL,
  `cat_mat_diversion` varchar(15) DEFAULT NULL,
  `cat_mat_romance` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `cit_id` int(11) NOT NULL,
  `cit_fecha` date DEFAULT NULL,
  `cit_hora` varchar(10) DEFAULT NULL,
  `cit_ubicacion` varchar(50) DEFAULT NULL,
  `cit_estado` varchar(15) DEFAULT NULL,
  `matches_mat_id` int(11) NOT NULL,
  `matches_mat_id1` int(11) NOT NULL,
  `categorias_match_cat_mat_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fotografias`
--

CREATE TABLE `fotografias` (
  `fot_id` int(11) NOT NULL,
  `fot_fechaSubida` date DEFAULT NULL,
  `perfiles_per_id` int(11) NOT NULL,
  `perfiles_per_id1` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matches`
--

CREATE TABLE `matches` (
  `mat_id` int(11) NOT NULL,
  `mat_usu1` int(11) NOT NULL,
  `mat_usu2` int(11) NOT NULL,
  `categorias_match_cat_mat_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfiles`
--

CREATE TABLE `perfiles` (
  `per_id` int(11) NOT NULL,
  `per_nombre` varchar(100) DEFAULT NULL,
  `per_descripcion` text DEFAULT NULL,
  `usuarios_usu_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `usu_id` int(11) NOT NULL,
  `usu_nombre` varchar(100) NOT NULL,
  `usu_email` varchar(100) NOT NULL,
  `usu_contraseña` varchar(255) NOT NULL,
  `usu_genero` varchar(10) DEFAULT NULL,
  `usu_edad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias_match`
--
ALTER TABLE `categorias_match`
  ADD PRIMARY KEY (`cat_mat_id`);

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`cit_id`),
  ADD KEY `fk_citas_matches1_idx` (`matches_mat_id`),
  ADD KEY `fk_citas_matches1_idx1` (`matches_mat_id1`),
  ADD KEY `fk_citas_categorias_match1_idx` (`categorias_match_cat_mat_id`);

--
-- Indices de la tabla `fotografias`
--
ALTER TABLE `fotografias`
  ADD PRIMARY KEY (`fot_id`),
  ADD KEY `fk_fotografias_perfiles1_idx` (`perfiles_per_id`),
  ADD KEY `fk_fotografias_perfiles1_idx1` (`perfiles_per_id1`);

--
-- Indices de la tabla `matches`
--
ALTER TABLE `matches`
  ADD PRIMARY KEY (`mat_id`),
  ADD KEY `fk_matches_categorias_match1_idx` (`categorias_match_cat_mat_id`),
  ADD KEY `fk_mat_usu1` (`mat_usu1`),
  ADD KEY `fk_mat_usu2` (`mat_usu2`);

--
-- Indices de la tabla `perfiles`
--
ALTER TABLE `perfiles`
  ADD PRIMARY KEY (`per_id`),
  ADD KEY `fk_perfiles_usuarios1_idx` (`usuarios_usu_id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`usu_id`),
  ADD UNIQUE KEY `usu_email` (`usu_email`),
  ADD UNIQUE KEY `email_unique` (`usu_email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias_match`
--
ALTER TABLE `categorias_match`
  MODIFY `cat_mat_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `cit_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `fotografias`
--
ALTER TABLE `fotografias`
  MODIFY `fot_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `matches`
--
ALTER TABLE `matches`
  MODIFY `mat_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `perfiles`
--
ALTER TABLE `perfiles`
  MODIFY `per_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `usu_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `fk_citas_categorias_match1` FOREIGN KEY (`categorias_match_cat_mat_id`) REFERENCES `categorias_match` (`cat_mat_id`);

--
-- Filtros para la tabla `fotografias`
--
ALTER TABLE `fotografias`
  ADD CONSTRAINT `fk_fotografias_perfiles1` FOREIGN KEY (`perfiles_per_id1`) REFERENCES `perfiles` (`per_id`);

--
-- Filtros para la tabla `matches`
--
ALTER TABLE `matches`
  ADD CONSTRAINT `fk_mat_usu1` FOREIGN KEY (`mat_usu1`) REFERENCES `usuarios` (`usu_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_mat_usu2` FOREIGN KEY (`mat_usu2`) REFERENCES `usuarios` (`usu_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_matches_categorias_match1` FOREIGN KEY (`categorias_match_cat_mat_id`) REFERENCES `categorias_match` (`cat_mat_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
