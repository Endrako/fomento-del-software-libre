-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 11-06-2011 a las 17:33:18
-- Versión del servidor: 5.5.8
-- Versión de PHP: 5.3.5

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=8 ;

--
-- Volcar la base de datos para la tabla `aplicaciones`
--

INSERT INTO `aplicaciones` (`OIDAplicacion`, `IDAplicacion`, `idUsuarioCreador`, `nombre`, `descripcion`, `fechaPublicacion`, `URLWeb`, `numeroVotosAFavor`, `numeroVotosEnContra`, `IDProyecto`) VALUES
(1, '1', '1305817111314288eb5b0', 'VLC', 'Reproductor de video multicodecs.', '2011-04-29', 'www.url1.com', 0, 0, NULL),
(2, '2', '1305817111314288eb5b0', 'Open Office', 'Programa de ofimatica parecida al Microsoft Office', '2011-04-28', 'www.url2.com', 0, 0, NULL),
(3, '3', '1305817111314288eb5b0', 'Winamp', 'Reproductor de audio y video normalito', '2011-04-22', 'www.url3.com', 0, 0, NULL),
(4, '4', '1305817111314288eb5b0', 'Calculetor', 'Calculadora para estadisticos', '2011-04-23', 'www.url4.com', 0, 0, NULL),
(7, '1307796716138ffffffffeaa0803b', '1307796693466ffffffffdeb6e35c', '', '', '2011-06-11', '', 0, 0, NULL);

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
  `IDUsuario` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`OIDEncuesta`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=2 ;

--
-- Volcar la base de datos para la tabla `encuestas`
--

INSERT INTO `encuestas` (`OIDEncuesta`, `IDEncuesta`, `IDUsuario`, `nombre`) VALUES
(1, '1307806303227295412e4', 'PerryMayson', 'Encuesta sobre el sexo de los grillos');

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

INSERT INTO `enfrentamientos` (`OIDEnfrentamiento`, `IDEnfrentamiento`, `IDAplicacion1`, `IDAplicacion2`, `descripcion`, `votosApp1`, `votosApp2`, `fechaCreacion`, `fechaFin`, `aceptado`, `IDUsuario`, `finalizado`) VALUES
(1, 'en1', '1', '3', 'VLC vs Winamp ¿Quien ganra? voten', 0, 0, '2011-04-29 14:53:05', '2011-04-30 14:53:09', 1, '', 1);

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `paises`
--

INSERT INTO `paises` (`OIDPais`, `IDPais`, `nombre`) VALUES
(1, '1', 'España'),
(2, '2', 'Portugal');

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=18 ;

--
-- Volcar la base de datos para la tabla `perfiles`
--

INSERT INTO `perfiles` (`OIDPerfil`, `IDPerfil`, `nombre`, `apellidos`, `edad`, `IDPais`, `IDProvincia`, `IDSO1`, `IDSO2`) VALUES
(14, '130581714241341a241b4', 'Juan Antonio', 'Sanchez Madero', 24, '1', '3', '1', '4'),
(13, '1305740927043ffffffffa76acf18', 'mar', 'beyond', 56, '1', '2', '1', '4'),
(12, '1305740818995ffffffffedba705a', 'Juan Antonio', 'Sanchez Madero', 23, '1', '1', '1', '4'),
(15, '1305817206316ffffffff8d4dab94', 'Marc', 'Bayon', 23, '1', '1', '1', '4'),
(16, '13075319160103146e62', 'Fray', 'Daza', 26, '1', '1', '3', '4'),
(17, '130779669917929e8c823', '', '', 0, '1', '1', '1', '4');

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

INSERT INTO `preguntas` (`OIDPregunta`, `IDPregunta`, `IDEncuesta`, `descripcionPregunta`) VALUES
(1, '1307806303228fffffffff87824c8', '1307806303227295412e4', '¿Que sistema operativo usas?'),
(2, '130780630324825c5aa1a', '1307806303227295412e4', '¿Que personaje de los siguientes te pone más cachondo?');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntasrespuestas`
--

CREATE TABLE IF NOT EXISTS `preguntasrespuestas` (
  `OIDRelacion` int(11) NOT NULL AUTO_INCREMENT,
  `IDRespuesta` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDPregunta` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`OIDRelacion`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=9 ;

--
-- Volcar la base de datos para la tabla `preguntasrespuestas`
--

INSERT INTO `preguntasrespuestas` (`OIDRelacion`, `IDRespuesta`, `IDPregunta`) VALUES
(1, '1307806303228ffffffffc4753353', '1307806303228fffffffff87824c8'),
(2, '1307806303244ffffffff8e037bd9', '1307806303228fffffffff87824c8'),
(3, '130780630324535c1bf72', '1307806303228fffffffff87824c8'),
(4, '1307806303246ffffffff9cc4027b', '1307806303228fffffffff87824c8'),
(5, '1307806303248630fbc54', '130780630324825c5aa1a'),
(6, '1307806303252400c16c4', '130780630324825c5aa1a'),
(7, '1307806303253ffffffffe0b3e7cd', '130780630324825c5aa1a'),
(8, '1307806303254ffffffffc50c270e', '130780630324825c5aa1a');

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

INSERT INTO `proyectos` (`OIDProyecto`, `IDProyecto`, `IDUsuarioCreador`, `nombre`, `descripcion`, `fechaInicio`, `fechaFin`, `disponible`, `nivelKarma`) VALUES
(1, '1', '1', 'Pacome', 'Calendario de comidas para lpersonas de la tercera edad', '2011-04-29 15:45:54', '2012-04-27 15:45:58', 1, 0),
(2, '2', '1', 'Pacorrer', 'Calendario de marchas y senderismo en España.', '2011-04-29 15:46:29', '2012-04-27 15:46:32', 1, 0);

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=9 ;

--
-- Volcar la base de datos para la tabla `respuestas`
--

INSERT INTO `respuestas` (`OIDRespuesta`, `IDRespuesta`, `descripcionRespuesta`, `numeroVotos`) VALUES
(1, '1307806303228ffffffffc4753353', 'windows', 0),
(2, '1307806303244ffffffff8e037bd9', 'Linux', 0),
(3, '130780630324535c1bf72', 'Mac', 0),
(4, '1307806303246ffffffff9cc4027b', 'Soy Chuck Norris y no necesito un sistema operativo', 0),
(5, '1307806303248630fbc54', 'Bill Gates', 0),
(6, '1307806303252400c16c4', 'Papa Pitufo', 0),
(7, '1307806303253ffffffffe0b3e7cd', 'David el Gnomo', 0),
(8, '1307806303254ffffffffc50c270e', 'Chuck Norris', 0);

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `so`
--

INSERT INTO `so` (`OIDSO`, `IDSO`, `nombre`, `esSOMovil`) VALUES
(1, '1', 'Windows 7', 0),
(2, '2', 'Windows Vista', 0),
(3, '3', 'Ubuntu 11.04', 0),
(4, '4', 'Android', 1);

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

INSERT INTO `tagsaplicaciones` (`OIDRelacion`, `IDAplicacion`, `IDTag`) VALUES
(8, '3', 'vid'),
(7, '1', 'mus'),
(6, '1', 'vid'),
(11, '4', 'mus'),
(10, '4', 'vid'),
(9, '3', 'mus'),
(12, '7', '4'),
(13, '7', '5'),
(14, '7', '4'),
(15, '7', '5');

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=18 ;

--
-- Volcar la base de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`OIDUsuario`, `IDUsuario`, `nombreUsuario`, `contrasenna`, `email`, `IDPerfil`, `karma`, `numeroRecomendaciones`) VALUES
(14, '1305817111314288eb5b0', 'sheinx', 's', 'shx@isg3.com', '130581714241341a241b4', 20, 1),
(15, '1305817188803ffffffffd20a59cf', 'marc', 'm', 'marc@isg3.com', '1305817206316ffffffff8d4dab94', 20, 0),
(16, '1307531898645ffffffffa3aa848a', 'francis', 'f', 'fragelbreak@gmail.com', '13075319160103146e62', 10, 0),
(17, '1307796693466ffffffffdeb6e35c', 'arundil', '1234', '1', '130779669917929e8c823', 30, 0);

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

