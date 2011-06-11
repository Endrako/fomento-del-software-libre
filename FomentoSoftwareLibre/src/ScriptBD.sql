-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 11-06-2011 a las 15:45:48
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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=7 ;

--
-- Volcar la base de datos para la tabla `aplicaciones`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colaboracionusuariosproyectos`
--

CREATE TABLE IF NOT EXISTS `colaboracionusuariosproyectos` (
  `OIDRelacion` int(11) NOT NULL AUTO_INCREMENT,
  `IDUsuario` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDProyecto` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`OIDRelacion`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `colaboracionusuariosproyectos`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentarios`
--

CREATE TABLE IF NOT EXISTS `comentarios` (
  `OIDComentario` int(11) NOT NULL AUTO_INCREMENT,
  `IDComentario` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDAplicacion` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDUsuario` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` text COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`OIDComentario`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `comentarios`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encuestas`
--

CREATE TABLE IF NOT EXISTS `encuestas` (
  `OIDEncuesta` int(11) NOT NULL AUTO_INCREMENT,
  `IDEncuesta` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDUsusario` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`OIDEncuesta`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `encuestas`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enfrentamientos`
--

CREATE TABLE IF NOT EXISTS `enfrentamientos` (
  `OIDEnfrentamiento` int(11) NOT NULL AUTO_INCREMENT,
  `IDEnfrentamiento` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDAplicacion1` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDAplicacion2` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` text COLLATE latin1_spanish_ci NOT NULL,
  `votosApp1` int(11) NOT NULL,
  `votosApp2` int(11) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `fechaFin` datetime NOT NULL,
  `aceptado` tinyint(1) NOT NULL,
  `IDUsuario` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `finalizado` tinyint(1) NOT NULL,
  PRIMARY KEY (`OIDEnfrentamiento`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=2 ;

--
-- Volcar la base de datos para la tabla `enfrentamientos`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paises`
--

CREATE TABLE IF NOT EXISTS `paises` (
  `OIDPais` int(11) NOT NULL AUTO_INCREMENT,
  `IDPais` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`OIDPais`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `paises`
--

INSERT INTO `paises` (`OIDPais`, `IDPais`, `nombre`) VALUES
(1, '1', 'España'),
(2, '2', 'Portugal'),
(3, '3', 'Francia'),
(4, '4', 'Alemania');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfiles`
--

CREATE TABLE IF NOT EXISTS `perfiles` (
  `OIDPerfil` int(11) NOT NULL AUTO_INCREMENT,
  `IDPerfil` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(50) COLLATE latin1_spanish_ci DEFAULT NULL,
  `apellidos` varchar(50) COLLATE latin1_spanish_ci DEFAULT NULL,
  `edad` int(3) DEFAULT NULL,
  `IDPais` varchar(50) COLLATE latin1_spanish_ci DEFAULT NULL,
  `IDProvincia` varchar(50) COLLATE latin1_spanish_ci DEFAULT NULL,
  `IDSO1` varchar(50) COLLATE latin1_spanish_ci DEFAULT NULL,
  `IDSO2` varchar(50) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`OIDPerfil`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=17 ;

--
-- Volcar la base de datos para la tabla `perfiles`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE IF NOT EXISTS `preguntas` (
  `OIDPregunta` int(11) NOT NULL AUTO_INCREMENT,
  `IDPregunta` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDEncuesta` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `descripcionPregunta` varchar(150) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`OIDPregunta`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `preguntas`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntasrespuestas`
--

CREATE TABLE IF NOT EXISTS `preguntasrespuestas` (
  `OIDRelacion` int(11) NOT NULL AUTO_INCREMENT,
  `IDRespuesta` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDPregunta` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`OIDRelacion`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `preguntasrespuestas`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincias`
--

CREATE TABLE IF NOT EXISTS `provincias` (
  `OIDProvincia` int(11) NOT NULL AUTO_INCREMENT,
  `IDProvincia` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` text COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`OIDProvincia`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `provincias`
--

INSERT INTO `provincias` (`OIDProvincia`, `IDProvincia`, `nombre`) VALUES
(1, '1', 'Madrid'),
(2, '2', 'Badajoz'),
(3, '3', 'Sevilla'),
(4, '4', 'Almeria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyectos`
--

CREATE TABLE IF NOT EXISTS `proyectos` (
  `OIDProyecto` int(11) NOT NULL AUTO_INCREMENT,
  `IDProyecto` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDUsuarioCreador` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` text COLLATE latin1_spanish_ci NOT NULL,
  `fechaInicio` datetime NOT NULL,
  `fechaFin` datetime DEFAULT NULL,
  `disponible` tinyint(1) NOT NULL,
  `nivelKarma` int(11) NOT NULL,
  PRIMARY KEY (`OIDProyecto`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `proyectos`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `referenciascomentarios`
--

CREATE TABLE IF NOT EXISTS `referenciascomentarios` (
  `OIDReferencia` int(11) NOT NULL AUTO_INCREMENT,
  `IDComentarioReferenciado` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDComentarioReferenciador` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`OIDReferencia`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `referenciascomentarios`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuestas`
--

CREATE TABLE IF NOT EXISTS `respuestas` (
  `OIDRespuesta` int(11) NOT NULL AUTO_INCREMENT,
  `IDRespuesta` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `descripcionRespuesta` varchar(200) COLLATE latin1_spanish_ci NOT NULL,
  `numeroVotos` int(11) NOT NULL,
  PRIMARY KEY (`OIDRespuesta`),
  UNIQUE KEY `IDRespuesta` (`IDRespuesta`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `respuestas`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `so`
--

CREATE TABLE IF NOT EXISTS `so` (
  `OIDSO` int(11) NOT NULL AUTO_INCREMENT,
  `IDSO` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `esSOMovil` tinyint(1) NOT NULL,
  PRIMARY KEY (`OIDSO`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=7 ;

--
-- Volcar la base de datos para la tabla `so`
--

INSERT INTO `so` (`OIDSO`, `IDSO`, `nombre`, `esSOMovil`) VALUES
(1, '1', 'Windows 7', 0),
(2, '2', 'Windows Vista', 0),
(3, '3', 'Ubuntu 11.04', 0),
(4, '4', 'Android', 1),
(5, '5', 'Lion OS X', 0),
(6, '6', 'IOS 5', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tags`
--

CREATE TABLE IF NOT EXISTS `tags` (
  `OIDTag` int(11) NOT NULL AUTO_INCREMENT,
  `IDTag` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`OIDTag`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=6 ;

--
-- Volcar la base de datos para la tabla `tags`
--

INSERT INTO `tags` (`OIDTag`, `IDTag`, `nombre`) VALUES
(1, 'vid', 'Video'),
(2, 'ant', 'Antivirus'),
(3, 'mus', 'Musica'),
(4, 'ofi', 'Ofimatica'),
(5, 'cht', 'Chat');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tagsaplicaciones`
--

CREATE TABLE IF NOT EXISTS `tagsaplicaciones` (
  `OIDRelacion` int(11) NOT NULL AUTO_INCREMENT,
  `IDAplicacion` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDTag` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`OIDRelacion`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=16 ;

--
-- Volcar la base de datos para la tabla `tagsaplicaciones`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarioencuestas`
--

CREATE TABLE IF NOT EXISTS `usuarioencuestas` (
  `OIDRelacion` int(11) NOT NULL AUTO_INCREMENT,
  `IDEncuesta` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDUsuario` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDPregunta` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDRespuesta` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`OIDRelacion`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `usuarioencuestas`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `OIDUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `IDUsuario` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `nombreUsuario` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `contrasenna` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `email` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDPerfil` varchar(50) COLLATE latin1_spanish_ci DEFAULT NULL,
  `karma` int(11) NOT NULL,
  `numeroRecomendaciones` int(11) NOT NULL,
  PRIMARY KEY (`OIDUsuario`),
  UNIQUE KEY `nombreUsuario` (`nombreUsuario`,`email`,`IDPerfil`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=17 ;

--
-- Volcar la base de datos para la tabla `usuarios`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `votos`
--

CREATE TABLE IF NOT EXISTS `votos` (
  `OIDVoto` int(11) NOT NULL AUTO_INCREMENT,
  `IDVoto` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDUsuario` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDAplicacion` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `valor` tinyint(1) NOT NULL,
  PRIMARY KEY (`OIDVoto`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `votos`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `votosusuarioenfrentamiento`
--

CREATE TABLE IF NOT EXISTS `votosusuarioenfrentamiento` (
  `OIDRelacion` int(11) NOT NULL AUTO_INCREMENT,
  `IDEnfrentamiento` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDUsuario` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDAplicacion` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`OIDRelacion`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `votosusuarioenfrentamiento`
--

