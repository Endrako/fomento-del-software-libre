-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 29-04-2011 a las 15:50:23
-- Versión del servidor: 5.1.41
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
-- Estructura de tabla para la tabla `actualizaciones`
--

CREATE TABLE IF NOT EXISTS `actualizaciones` (
  `IDActualizacion` int(11) NOT NULL AUTO_INCREMENT,
  `IDAplicacion` int(11) NOT NULL,
  `versionDelCambio` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `descripcionCambios` text COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`IDActualizacion`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `actualizaciones`
--

INSERT INTO `actualizaciones` (`IDActualizacion`, `IDAplicacion`, `versionDelCambio`, `descripcionCambios`) VALUES
(1, 1, '1.2', 'Mejora en la calidad de la imagen brillo/contraste'),
(2, 2, '1.2', 'Implementacion de varios colores de la fuente Arial.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anuncioaplicaciones`
--

CREATE TABLE IF NOT EXISTS `anuncioaplicaciones` (
  `IDRelacion` int(11) NOT NULL AUTO_INCREMENT,
  `IDAnuncio` int(11) NOT NULL,
  `IDAplicacion` int(11) NOT NULL,
  PRIMARY KEY (`IDRelacion`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `anuncioaplicaciones`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anuncioproyectos`
--

CREATE TABLE IF NOT EXISTS `anuncioproyectos` (
  `IDRelacion` int(11) NOT NULL AUTO_INCREMENT,
  `IDAnuncio` int(11) NOT NULL,
  `IDProyecto` int(11) NOT NULL,
  PRIMARY KEY (`IDRelacion`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `anuncioproyectos`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anuncios`
--

CREATE TABLE IF NOT EXISTS `anuncios` (
  `IDAnuncio` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `cuerpoAnuncio` text COLLATE latin1_spanish_ci NOT NULL,
  `IDUsuario` int(11) NOT NULL,
  `fechaPublicacion` date NOT NULL,
  PRIMARY KEY (`IDAnuncio`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `anuncios`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aplicaciones`
--

CREATE TABLE IF NOT EXISTS `aplicaciones` (
  `IDAplicacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` text COLLATE latin1_spanish_ci NOT NULL,
  `fechaPublicacion` date NOT NULL,
  `URLWeb` varchar(200) COLLATE latin1_spanish_ci NOT NULL,
  `numeroVotosAFavor` int(11) NOT NULL,
  `numeroVotosEnContra` int(11) NOT NULL,
  PRIMARY KEY (`IDAplicacion`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `aplicaciones`
--

INSERT INTO `aplicaciones` (`IDAplicacion`, `nombre`, `descripcion`, `fechaPublicacion`, `URLWeb`, `numeroVotosAFavor`, `numeroVotosEnContra`) VALUES
(1, 'VLC', 'Reproductor de video multicodecs.', '2011-04-29', 'www.url1.com', 0, 0),
(2, 'Open Office', 'Programa de ofimatica parecida al Microsoft Office', '2011-04-28', 'www.url2.com', 0, 0),
(3, 'Winamp', 'Reproductor de audio y video normalito', '2011-04-22', 'www.url3.com', 0, 0),
(4, 'Calculetor', 'Calculadora para estadisticos', '2011-04-23', 'www.url4.com', 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colaboracionusuariosproyectos`
--

CREATE TABLE IF NOT EXISTS `colaboracionusuariosproyectos` (
  `IDRelacion` int(11) NOT NULL AUTO_INCREMENT,
  `IDUsuario` int(11) NOT NULL,
  `IDProyecto` int(11) NOT NULL,
  PRIMARY KEY (`IDRelacion`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `colaboracionusuariosproyectos`
--

INSERT INTO `colaboracionusuariosproyectos` (`IDRelacion`, `IDUsuario`, `IDProyecto`) VALUES
(1, 1, 2),
(2, 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentarios`
--

CREATE TABLE IF NOT EXISTS `comentarios` (
  `IDComentario` int(11) NOT NULL AUTO_INCREMENT,
  `IDAplicacion` int(11) NOT NULL,
  `IDUsuario` int(11) NOT NULL,
  `descripcion` text COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`IDComentario`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `comentarios`
--

INSERT INTO `comentarios` (`IDComentario`, `IDAplicacion`, `IDUsuario`, `descripcion`) VALUES
(1, 1, 3, 'El programa se me queda pillado cuando pongo un video de alta definicion'),
(2, 1, 2, 'Un gran programa, lo reproduce todo todo todo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encuestas`
--

CREATE TABLE IF NOT EXISTS `encuestas` (
  `IDEncuesta` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`IDEncuesta`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `encuestas`
--

INSERT INTO `encuestas` (`IDEncuesta`, `nombre`) VALUES
(1, 'Reproductores de video'),
(2, 'Programas de ofimatica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enfrentamientos`
--

CREATE TABLE IF NOT EXISTS `enfrentamientos` (
  `IDEnfrentamiento` int(11) NOT NULL AUTO_INCREMENT,
  `IDAplicacion1` int(11) NOT NULL,
  `idAplicacion2` int(11) NOT NULL,
  `descripcion` text COLLATE latin1_spanish_ci NOT NULL,
  `votosApp1` int(11) NOT NULL,
  `votosApp2` int(11) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `fechaFin` datetime NOT NULL,
  `aceptado` tinyint(1) NOT NULL,
  PRIMARY KEY (`IDEnfrentamiento`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=2 ;

--
-- Volcar la base de datos para la tabla `enfrentamientos`
--

INSERT INTO `enfrentamientos` (`IDEnfrentamiento`, `IDAplicacion1`, `idAplicacion2`, `descripcion`, `votosApp1`, `votosApp2`, `fechaCreacion`, `fechaFin`, `aceptado`) VALUES
(1, 1, 3, 'VLC vs Winamp ¿Quien ganra? voten', 0, 0, '2011-04-29 14:53:05', '2011-04-30 14:53:09', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paises`
--

CREATE TABLE IF NOT EXISTS `paises` (
  `IDPais` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`IDPais`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `paises`
--

INSERT INTO `paises` (`IDPais`, `nombre`) VALUES
(1, 'España'),
(2, 'Portugal');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfiles`
--

CREATE TABLE IF NOT EXISTS `perfiles` (
  `IDPerfil` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE latin1_spanish_ci DEFAULT NULL,
  `apellidos` varchar(50) COLLATE latin1_spanish_ci DEFAULT NULL,
  `edad` int(3) DEFAULT NULL,
  `IDPais` int(11) DEFAULT NULL,
  `IDCiudad` int(11) DEFAULT NULL,
  `IDPoblacion` int(11) DEFAULT NULL,
  `IDSO1` int(11) DEFAULT NULL,
  `IDSO2` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDPerfil`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `perfiles`
--

INSERT INTO `perfiles` (`IDPerfil`, `nombre`, `apellidos`, `edad`, `IDPais`, `IDCiudad`, `IDPoblacion`, `IDSO1`, `IDSO2`) VALUES
(1, 'Alvaro', NULL, 22, 1, 3, NULL, 1, 2),
(2, 'Fco Javier', NULL, 24, 1, 3, NULL, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `poblaciones`
--

CREATE TABLE IF NOT EXISTS `poblaciones` (
  `IDPoblacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`IDPoblacion`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `poblaciones`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE IF NOT EXISTS `preguntas` (
  `IDPregunta` int(11) NOT NULL AUTO_INCREMENT,
  `IDEncuesta` int(11) NOT NULL,
  `descripcionPregunta` varchar(150) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`IDPregunta`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `preguntas`
--

INSERT INTO `preguntas` (`IDPregunta`, `IDEncuesta`, `descripcionPregunta`) VALUES
(1, 1, '¿Cual tiene mejor calidad de video?'),
(2, 1, '¿Cual tiene mejor calidad de sonido?');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntasrespuestas`
--

CREATE TABLE IF NOT EXISTS `preguntasrespuestas` (
  `IDRelacion` int(11) NOT NULL AUTO_INCREMENT,
  `IDRespuesta` int(11) NOT NULL,
  `IDPregunta` int(11) NOT NULL,
  PRIMARY KEY (`IDRelacion`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `preguntasrespuestas`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincias`
--

CREATE TABLE IF NOT EXISTS `provincias` (
  `IDProvincia` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` text COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`IDProvincia`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `provincias`
--

INSERT INTO `provincias` (`IDProvincia`, `nombre`) VALUES
(1, 'Madrid'),
(2, 'Badajoz'),
(3, 'Sevilla'),
(4, 'Almeria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyectos`
--

CREATE TABLE IF NOT EXISTS `proyectos` (
  `IDProyecto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` text COLLATE latin1_spanish_ci NOT NULL,
  `fechaInicio` datetime NOT NULL,
  `fechaFin` datetime DEFAULT NULL,
  `disponible` tinyint(1) NOT NULL,
  PRIMARY KEY (`IDProyecto`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `proyectos`
--

INSERT INTO `proyectos` (`IDProyecto`, `nombre`, `descripcion`, `fechaInicio`, `fechaFin`, `disponible`) VALUES
(1, 'Pacome', 'Calendario de comidas para lpersonas de la tercera edad', '2011-04-29 15:45:54', '2012-04-27 15:45:58', 1),
(2, 'Pacorrer', 'Calendario de marchas y senderismo en España.', '2011-04-29 15:46:29', '2012-04-27 15:46:32', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `referenciascomentarios`
--

CREATE TABLE IF NOT EXISTS `referenciascomentarios` (
  `IDReferencia` int(11) NOT NULL AUTO_INCREMENT,
  `IDComentarioReferenciado` int(11) NOT NULL,
  `IDComentarioReferenciador` int(11) NOT NULL,
  PRIMARY KEY (`IDReferencia`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `referenciascomentarios`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuestas`
--

CREATE TABLE IF NOT EXISTS `respuestas` (
  `IDRespuesta` int(11) NOT NULL AUTO_INCREMENT,
  `descripcionRespuesta` varchar(200) COLLATE latin1_spanish_ci NOT NULL,
  `numeroVotos` int(11) NOT NULL,
  PRIMARY KEY (`IDRespuesta`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `respuestas`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `so`
--

CREATE TABLE IF NOT EXISTS `so` (
  `IDSO` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `esSOMovil` tinyint(1) NOT NULL,
  PRIMARY KEY (`IDSO`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `so`
--

INSERT INTO `so` (`IDSO`, `nombre`, `esSOMovil`) VALUES
(1, 'Windows 7', 0),
(2, 'Windows Vista', 0),
(3, 'Ubuntu 11.04', 0),
(4, 'Android', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `suscripcionaplicaciones`
--

CREATE TABLE IF NOT EXISTS `suscripcionaplicaciones` (
  `IDRelacion` int(11) NOT NULL AUTO_INCREMENT,
  `IDSuscripcion` int(11) NOT NULL,
  `IDAplicacion` int(11) NOT NULL,
  PRIMARY KEY (`IDRelacion`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `suscripcionaplicaciones`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `suscripciones`
--

CREATE TABLE IF NOT EXISTS `suscripciones` (
  `IDSuscripcion` int(11) NOT NULL AUTO_INCREMENT,
  `fechaAlta` datetime NOT NULL,
  `IDUsuario` int(11) NOT NULL,
  PRIMARY KEY (`IDSuscripcion`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `suscripciones`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `suscripcionproyectos`
--

CREATE TABLE IF NOT EXISTS `suscripcionproyectos` (
  `IDRelacion` int(11) NOT NULL AUTO_INCREMENT,
  `IDSuscripcion` int(11) NOT NULL,
  `IDProyecto` int(11) NOT NULL,
  PRIMARY KEY (`IDRelacion`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `suscripcionproyectos`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tags`
--

CREATE TABLE IF NOT EXISTS `tags` (
  `IDTag` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`IDTag`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `tags`
--

INSERT INTO `tags` (`IDTag`, `nombre`) VALUES
(1, 'Video'),
(2, 'Antivirus'),
(3, 'Musica'),
(4, 'Ofimatica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tagsaplicaciones`
--

CREATE TABLE IF NOT EXISTS `tagsaplicaciones` (
  `IDRelacion` int(11) NOT NULL AUTO_INCREMENT,
  `IDAplicacion` int(11) NOT NULL,
  `IDTag` int(11) NOT NULL,
  PRIMARY KEY (`IDRelacion`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=6 ;

--
-- Volcar la base de datos para la tabla `tagsaplicaciones`
--

INSERT INTO `tagsaplicaciones` (`IDRelacion`, `IDAplicacion`, `IDTag`) VALUES
(1, 1, 1),
(2, 3, 1),
(3, 3, 3),
(4, 2, 4),
(5, 4, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarioencuestas`
--

CREATE TABLE IF NOT EXISTS `usuarioencuestas` (
  `IDRelacion` int(11) NOT NULL AUTO_INCREMENT,
  `IDEncuesta` int(11) NOT NULL,
  `IDUsuario` int(11) NOT NULL,
  `IDPregunta` int(11) NOT NULL,
  `IDRespuesta` int(11) NOT NULL,
  PRIMARY KEY (`IDRelacion`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `usuarioencuestas`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `IDUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `contraseña` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `email` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDPerfil` int(11) NOT NULL,
  PRIMARY KEY (`IDUsuario`),
  UNIQUE KEY `nombreUsuario` (`nombreUsuario`,`email`,`IDPerfil`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`IDUsuario`, `nombreUsuario`, `contraseña`, `email`, `IDPerfil`) VALUES
(1, 'Varusblack', 'isg3', 'algo@email.com', 1),
(2, 'lordreivaj', 'isg3', 'alguien@email.com', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `votos`
--

CREATE TABLE IF NOT EXISTS `votos` (
  `IDVoto` int(11) NOT NULL AUTO_INCREMENT,
  `IDUsuario` int(11) NOT NULL,
  `IDAplicacion` int(11) NOT NULL,
  `valor` tinyint(1) NOT NULL,
  PRIMARY KEY (`IDVoto`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `votos`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `votosusuarioenfrentamiento`
--

CREATE TABLE IF NOT EXISTS `votosusuarioenfrentamiento` (
  `IDRelacion` int(11) NOT NULL AUTO_INCREMENT,
  `IDEnfrentamiento` int(11) NOT NULL,
  `IDUsuario` int(11) NOT NULL,
  `IDAplicacion` int(11) NOT NULL,
  PRIMARY KEY (`IDRelacion`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `votosusuarioenfrentamiento`
--


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
