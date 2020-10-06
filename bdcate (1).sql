-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-10-2020 a las 04:35:01
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdcate`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `catequistas`
--

CREATE TABLE `catequistas` (
  `cat_codigo` int(11) NOT NULL,
  `cat_nombre` varchar(150) DEFAULT NULL,
  `igl_codigo` int(11) NOT NULL,
  `cat_telefono` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `catequistas`
--

INSERT INTO `catequistas` (`cat_codigo`, `cat_nombre`, `igl_codigo`, `cat_telefono`) VALUES
(1, 'PAULINA', 1, NULL),
(3, 'ARIAS NOEMI', 2, NULL),
(4, 'BERNAL ADRIANA', 2, NULL),
(5, 'CAPELO JULITA', 2, NULL),
(6, 'CHASI JUAN', 2, NULL),
(8, 'CORDOVA OLIVA', 2, NULL),
(9, 'SAMANIEGO PAULINA', 2, NULL),
(10, 'VASQUEZ MIRIAM', 2, NULL),
(11, 'SOLANO ANABEL', 2, NULL),
(12, 'VASQUEZ LUCIA', 2, NULL),
(13, 'PERALTA MARCELA', 2, NULL),
(14, 'MOGROVEJO FABIAN', 2, NULL),
(15, 'SANCHEZ NARCISA', 2, NULL),
(16, 'ANA MOROCHO', 1, NULL),
(17, 'NAULA BERTHA', 1, NULL),
(18, 'VILLA ROSA', 1, NULL),
(19, 'VERDUGO PAOLA', 1, NULL),
(20, 'CORREA NUBE', 1, NULL),
(21, 'PUMA ALFREDO', 1, NULL),
(22, 'QUINTEROS MARTHA', 1, NULL),
(23, 'MENDEZ MARLENE', 1, NULL),
(24, 'MUÑOZ LUCIA ', 1, NULL),
(25, 'CADME ELSA', 1, NULL),
(26, 'Aaaaa', 1, NULL),
(27, 'SANTI', 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiantes`
--

CREATE TABLE `estudiantes` (
  `est_codigo` int(11) NOT NULL,
  `est_cedula` varchar(10) NOT NULL,
  `est_nombre` varchar(150) DEFAULT NULL,
  `est_nom_padre` varchar(150) DEFAULT NULL,
  `est_nom_madre` varchar(150) DEFAULT NULL,
  `est_telefono` varchar(15) DEFAULT NULL,
  `est_celular` varchar(15) DEFAULT NULL,
  `est_fec_nacimiento` date DEFAULT NULL,
  `est_fec_bautismo` date DEFAULT NULL,
  `est_representante` varchar(150) DEFAULT NULL,
  `est_par_representante` varchar(1) DEFAULT NULL,
  `igl_codigo` int(11) NOT NULL,
  `est_pad_cas` varchar(1) DEFAULT NULL,
  `est_direccion` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `estudiantes`
--

INSERT INTO `estudiantes` (`est_codigo`, `est_cedula`, `est_nombre`, `est_nom_padre`, `est_nom_madre`, `est_telefono`, `est_celular`, `est_fec_nacimiento`, `est_fec_bautismo`, `est_representante`, `est_par_representante`, `igl_codigo`, `est_pad_cas`, `est_direccion`) VALUES
(10, '1', '1', '1', '1', '1', '1', NULL, NULL, '', 'T', 1, 'S', NULL),
(11, '5', '5', '5', '5', '5', '5+', '2020-09-02', '2020-09-08', '5', 'H', 1, 'S', NULL),
(12, '2', '22', '2', '2', '2', '2', NULL, NULL, '', NULL, 1, NULL, NULL),
(13, '0104775473', 'SANTIAGO ', 'TOYO', 'SILVIA', '2864210', '0984394802', '1990-03-09', '1995-05-01', '', NULL, 1, 'S', NULL),
(14, '0104287636', 'MARIA GABRIELA SAQUICELA PULLa', 'MARCOS SAQUICELa', 'KATY PULLa', '2864210', '0995307378', '1990-12-25', '1990-12-12', '', NULL, 1, 'S', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `iglesias`
--

CREATE TABLE `iglesias` (
  `igl_codigo` int(11) NOT NULL,
  `igl_nombre` varchar(150) DEFAULT NULL,
  `igl_texto` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `iglesias`
--

INSERT INTO `iglesias` (`igl_codigo`, `igl_nombre`, `igl_texto`) VALUES
(1, 'SAN JUAN PABLO II', 'Catequesis de forma virtual desde la IGLESIA NUESTRA SEÑORA DE LOURDES, DOMINGO 4 DE OCTUBRE 10H00. FACEBOOK: Parroquia San Juan Pablo II - Cuenca. YOUTUBE: Parroquia San Juan Pablo II Cuenca - Ecuador'),
(2, 'NUESTRA SEÑORA DE LOURDES', 'Inauguración de la catequesis de forma virtual desde la IGLESIA NUESTRA SEÑORA DE LOURDES, DOMINGO 4 DE OCTUBRE 10H00. FACEBOOK: Parroquia San Juan Pablo II - Cuenca. YOUTUBE: Parroquia San Juan Pablo II Cuenca - Ecuador'),
(3, 'PPP', 'Inauguración de la catequesis de forma virtual desde la IGLESIA NUESTRA SEÑORA DE LOURDES, DOMINGO 4 DE OCTUBRE 10H00. FACEBOOK: Parroquia San Juan Pablo II - Cuenca. YOUTUBE: Parroquia San Juan Pablo II Cuenca - Ecuador'),
(4, 'SANTIAGO', 'Inauguración de la catequesis de forma virtual desde la IGLESIA NUESTRA SEÑORA DE LOURDES, DOMINGO 4 DE OCTUBRE 10H00. FACEBOOK: Parroquia San Juan Pablo II - Cuenca. YOUTUBE: Parroquia San Juan Pablo II Cuenca - Ecuador'),
(6, 'IGLESIAAAA', 'san');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripciones`
--

CREATE TABLE `inscripciones` (
  `ins_codigo` int(11) NOT NULL,
  `ins_fecha` date DEFAULT NULL,
  `ins_estado` varchar(1) DEFAULT NULL,
  `est_codigo` int(11) NOT NULL,
  `par_codigo` int(11) NOT NULL,
  `ins_observaciones` varchar(200) DEFAULT NULL,
  `ins_valor` decimal(4,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `inscripciones`
--

INSERT INTO `inscripciones` (`ins_codigo`, `ins_fecha`, `ins_estado`, `est_codigo`, `par_codigo`, `ins_observaciones`, `ins_valor`) VALUES
(24, '2020-09-10', NULL, 10, 8, 'NIÑA EXONERADA ', '15.00'),
(25, '2020-09-10', NULL, 10, 8, '', '15.00'),
(26, '2020-09-11', NULL, 11, 8, '5', '15.00'),
(27, '2020-09-11', NULL, 12, 8, '', '15.00'),
(28, '2020-09-11', NULL, 10, 8, 's', '15.00'),
(29, '2020-09-11', NULL, 11, 8, 'Ss', '15.00'),
(30, '2020-09-11', NULL, 10, 8, '1', '15.00'),
(31, '2020-09-13', NULL, 10, 8, '', '15.00'),
(32, '2020-09-13', NULL, 10, 8, '', '15.00'),
(33, '2020-09-13', NULL, 10, 8, '11', '15.00'),
(34, '2020-09-13', NULL, 10, 8, '', '15.00'),
(35, '2020-09-13', NULL, 10, 8, '', '15.00'),
(36, '2020-09-13', NULL, 10, 8, 'AASASa', '15.00'),
(37, '2020-09-13', NULL, 10, 8, 'q', '15.00'),
(38, '2020-09-13', NULL, 10, 8, 'ASa', '15.00'),
(39, '2020-09-13', NULL, 10, 8, '', '15.00'),
(40, '2020-09-13', NULL, 10, 8, 'As', '15.00'),
(41, '2020-09-13', NULL, 10, 8, 'As', '15.00'),
(42, '2020-09-13', NULL, 10, 8, '', '15.00'),
(43, '2020-09-13', NULL, 10, 8, 'Aa', '15.00'),
(44, '2020-09-13', NULL, 10, 8, 'Df', '15.00'),
(45, '2020-09-13', NULL, 10, 8, 'WAs', '15.00'),
(46, '2020-09-13', NULL, 10, 8, 'SDf', '15.00'),
(47, '2020-09-13', NULL, 10, 8, '', '15.00'),
(48, '2020-09-13', NULL, 10, 8, 'SAd', '15.00'),
(49, '2020-09-13', NULL, 13, 8, 'NINGUNA', '15.00'),
(50, '2020-09-14', NULL, 14, 8, '', '15.00'),
(51, '2020-10-03', NULL, 10, 14, '', '15.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `niveles`
--

CREATE TABLE `niveles` (
  `niv_codigo` int(11) NOT NULL,
  `niv_nombre` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `niveles`
--

INSERT INTO `niveles` (`niv_codigo`, `niv_nombre`) VALUES
(1, 'INICIAL'),
(2, 'PRIMERO DE COMUNION'),
(3, 'SEGUNDO DE COMUNION'),
(4, 'AÑO BIBLICO'),
(5, 'PRIMERO DE CONFIRMACION'),
(6, 'SEGUNDO DE CONFIRMACION'),
(7, 'CATEQUESIS ADULTOS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paralelos`
--

CREATE TABLE `paralelos` (
  `par_codigo` int(11) NOT NULL,
  `par_nombre` varchar(150) DEFAULT NULL,
  `per_codigo` int(11) NOT NULL,
  `niv_codigo` int(11) NOT NULL,
  `igl_codigo` int(11) NOT NULL,
  `cat_codigo` int(11) DEFAULT NULL,
  `par_atributo` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `paralelos`
--

INSERT INTO `paralelos` (`par_codigo`, `par_nombre`, `per_codigo`, `niv_codigo`, `igl_codigo`, `cat_codigo`, `par_atributo`) VALUES
(3, 'PARALELO A', 1, 1, 1, 12, NULL),
(4, 'PARALELO B', 1, 1, 1, 22, NULL),
(5, 'PARALELO A', 1, 1, 2, NULL, NULL),
(6, 'PARALELO B', 1, 1, 2, 3, NULL),
(7, 'PARALELO A', 1, 7, 1, NULL, NULL),
(8, 'PARALELO A', 2, 1, 1, NULL, NULL),
(9, 'adasdas', 1, 1, 1, 1, NULL),
(10, 'sadasdas', 1, 1, 1, 1, NULL),
(11, 'wqeqwe', 1, 1, 1, 1, NULL),
(12, '', 1, 1, 1, 5, NULL),
(13, 'SANTI PARALELO', 2, 1, 1, 1, NULL),
(14, 'paralelo snt', 4, 1, 1, 1, NULL),
(15, 'nue', 4, 1, 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodos`
--

CREATE TABLE `periodos` (
  `per_codigo` int(11) NOT NULL,
  `per_nombre` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `periodos`
--

INSERT INTO `periodos` (`per_codigo`, `per_nombre`) VALUES
(1, '2014'),
(2, '2016'),
(4, '2017');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `catequistas`
--
ALTER TABLE `catequistas`
  ADD PRIMARY KEY (`cat_codigo`),
  ADD KEY `fk_catequistas_iglesias1` (`igl_codigo`);

--
-- Indices de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD PRIMARY KEY (`est_codigo`),
  ADD UNIQUE KEY `est_cedula_UNIQUE` (`est_cedula`),
  ADD KEY `fk_estudiantes_iglesias1` (`igl_codigo`);

--
-- Indices de la tabla `iglesias`
--
ALTER TABLE `iglesias`
  ADD PRIMARY KEY (`igl_codigo`);

--
-- Indices de la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  ADD PRIMARY KEY (`ins_codigo`),
  ADD KEY `fk_inscripciones_estudiantes1` (`est_codigo`),
  ADD KEY `fk_inscripciones_paralelos1` (`par_codigo`);

--
-- Indices de la tabla `niveles`
--
ALTER TABLE `niveles`
  ADD PRIMARY KEY (`niv_codigo`);

--
-- Indices de la tabla `paralelos`
--
ALTER TABLE `paralelos`
  ADD PRIMARY KEY (`par_codigo`),
  ADD KEY `fk_paralelos_periodos` (`per_codigo`),
  ADD KEY `fk_paralelos_niveles1` (`niv_codigo`),
  ADD KEY `fk_paralelos_parroquias1` (`igl_codigo`),
  ADD KEY `fk_paralelos_catequistas_idx` (`cat_codigo`);

--
-- Indices de la tabla `periodos`
--
ALTER TABLE `periodos`
  ADD PRIMARY KEY (`per_codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `catequistas`
--
ALTER TABLE `catequistas`
  MODIFY `cat_codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  MODIFY `est_codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `iglesias`
--
ALTER TABLE `iglesias`
  MODIFY `igl_codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  MODIFY `ins_codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT de la tabla `niveles`
--
ALTER TABLE `niveles`
  MODIFY `niv_codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `paralelos`
--
ALTER TABLE `paralelos`
  MODIFY `par_codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `periodos`
--
ALTER TABLE `periodos`
  MODIFY `per_codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `catequistas`
--
ALTER TABLE `catequistas`
  ADD CONSTRAINT `fk_catequistas_iglesias1` FOREIGN KEY (`igl_codigo`) REFERENCES `iglesias` (`igl_codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD CONSTRAINT `fk_estudiantes_iglesias1` FOREIGN KEY (`igl_codigo`) REFERENCES `iglesias` (`igl_codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  ADD CONSTRAINT `fk_inscripciones_estudiantes1` FOREIGN KEY (`est_codigo`) REFERENCES `estudiantes` (`est_codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_inscripciones_paralelos1` FOREIGN KEY (`par_codigo`) REFERENCES `paralelos` (`par_codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `paralelos`
--
ALTER TABLE `paralelos`
  ADD CONSTRAINT `fk_paralelos_catequistas` FOREIGN KEY (`cat_codigo`) REFERENCES `catequistas` (`cat_codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_paralelos_niveles1` FOREIGN KEY (`niv_codigo`) REFERENCES `niveles` (`niv_codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_paralelos_parroquias1` FOREIGN KEY (`igl_codigo`) REFERENCES `iglesias` (`igl_codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_paralelos_periodos` FOREIGN KEY (`per_codigo`) REFERENCES `periodos` (`per_codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
