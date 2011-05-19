-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 19-05-2011 a las 16:06:05
-- Versión del servidor: 5.1.44
-- Versión de PHP: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `isg3bd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aplicaciones`
--

CREATE TABLE IF NOT EXISTS `aplicaciones` (
  `OIDAplicacion` int(11) NOT NULL AUTO_INCREMENT,
  `IDAplicacion` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `idUsuarioCreador` varchar(256) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` text COLLATE latin1_spanish_ci NOT NULL,
  `fechaPublicacion` date NOT NULL,
  `URLWeb` varchar(200) COLLATE latin1_spanish_ci NOT NULL,
  `numeroVotosAFavor` int(11) NOT NULL,
  `numeroVotosEnContra` int(11) NOT NULL,
  `IDProyecto` varchar(50) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`OIDAplicacion`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `aplicaciones`
--

INSERT INTO `aplicaciones` (`OIDAplicacion`, `IDAplicacion`, `idUsuarioCreador`, `nombre`, `descripcion`, `fechaPublicacion`, `URLWeb`, `numeroVotosAFavor`, `numeroVotosEnContra`, `IDProyecto`) VALUES
(1, '1', '1305817111314288eb5b0', 'VLC', 'Reproductor de video multicodecs.', '2011-04-29', 'www.url1.com', 0, 0, NULL),
(2, '2', '1305817111314288eb5b0', 'Open Office', 'Programa de ofimatica parecida al Microsoft Office', '2011-04-28', 'www.url2.com', 0, 0, NULL),
(3, '3', '1305817111314288eb5b0', 'Winamp', 'Reproductor de audio y video normalito', '2011-04-22', 'www.url3.com', 0, 0, NULL),
(4, '4', '1305817111314288eb5b0', 'Calculetor', 'Calculadora para estadisticos', '2011-04-23', 'www.url4.com', 0, 0, NULL);
