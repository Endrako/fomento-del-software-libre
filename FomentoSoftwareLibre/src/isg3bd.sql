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

-
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aplicaciones`
--

CREATE TABLE IF NOT EXISTS `aplicaciones` (
  `OID` int(11) NOT NULL AUTO_INCREMENT,
  `IDAplicacion` VARCHAR(50) NOT NULL,
  `nombre` varchar(50) COLLATE latin1_spanish_ci,
  `descripcion` text COLLATE latin1_spanish_ci,
  `fechaPublicacion` date,
  `URLWeb` varchar(200) COLLATE latin1_spanish_ci,
  `numeroVotosAFavor` int(11),
  `numeroVotosEnContra` int(11),
  PRIMARY KEY (`OID`),
  UNIQUE KEY `idAplicacion` (`IDAplicacion`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `aplicaciones`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colaboracionusuariosproyectos`
--

CREATE TABLE IF NOT EXISTS `colaboracionusuariosproyectos` (
  `OID` int(11) NOT NULL AUTO_INCREMENT,
  `IDRelacion` VARCHAR(50),
  `IDUsuario`VARCHAR(50),
  `IDProyecto` VARCHAR(50),
  PRIMARY KEY (`OID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `colaboracionusuariosproyectos`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentarios`
--

CREATE TABLE IF NOT EXISTS `comentarios` (
  `OID` int(11) NOT NULL AUTO_INCREMENT,
  `IDComentario` VARCHAR(50),
  `IDAplicacion` VARCHAR(50),
  `IDUsuario` VARCHAR(50),
  `descripcion` text COLLATE latin1_spanish_ci,
  PRIMARY KEY (`OID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `comentarios`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encuestas`
--

CREATE TABLE IF NOT EXISTS `encuestas` (
  `OID` int(11) NOT NULL AUTO_INCREMENT,
  `IDEncuesta` VARCHAR(50),
  `nombre` varchar(100) COLLATE latin1_spanish_ci,
  PRIMARY KEY (`OID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `encuestas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enfrentamientos`
--

CREATE TABLE IF NOT EXISTS `enfrentamientos` (
  `OID` int(11) NOT NULL AUTO_INCREMENT,
  `IDEnfrentamiento` VARCHAR(50),
  `IDAplicacion1` VARCHAR(50),
  `idAplicacion2`VARCHAR(50),
  `descripcion` text COLLATE latin1_spanish_ci,
  `votosApp1` int(11) ,
  `votosApp2` int(11) ,
  `fechaCreacion` datetime,
  `fechaFin` datetime ,
  `aceptado` tinyint(1) ,
  PRIMARY KEY (`OID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=2 ;

--
-- Volcar la base de datos para la tabla `enfrentamientos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paises`
--

CREATE TABLE IF NOT EXISTS `paises` (
	`OID` int(11) NOT NULL AUTO_INCREMENT,
  `IDPais` VARCHAR(50),
  `nombre` varchar(50) COLLATE latin1_spanish_ci,
  PRIMARY KEY (`OID`),
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfiles`
--

CREATE TABLE IF NOT EXISTS `perfiles` (
`OID` int(11) NOT NULL AUTO_INCREMENT,
  `IDPerfil` VARCHAR(50),
  `nombre` varchar(50) COLLATE latin1_spanish_ci,
  `apellidos` varchar(50) COLLATE latin1_spanish_ci,
  `edad` int(3) ,
  `IDPais` VARCHAR(50) ,
  `IDCiudad` VARCHAR(50),
  `IDPoblacion` VARCHAR(50),
  `IDSO1` VARCHAR(50),
  `IDSO2` VARCHAR(50),
  PRIMARY KEY (`OID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `poblaciones`
--

CREATE TABLE IF NOT EXISTS `poblaciones` (
`OID` int(11) NOT NULL AUTO_INCREMENT,
  `IDPoblacion` VARCHAR(50),
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`OID`),
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `poblaciones`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE IF NOT EXISTS `preguntas` (
`OID` int(11) NOT NULL AUTO_INCREMENT,
  `IDPregunta` VARCHAR(50),
  `IDEncuesta` VARCHAR(50),
  `descripcionPregunta` varchar(150) COLLATE latin1_spanish_ci,
  PRIMARY KEY (`OID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntasrespuestas`
--

CREATE TABLE IF NOT EXISTS `preguntasrespuestas` (
	`OID` int(11) NOT NULL AUTO_INCREMENT,
  `IDRelacion` VARCHAR(50),
  `IDRespuesta` VARCHAR(50),
  `IDPregunta` VARCHAR(50),
  PRIMARY KEY (`OID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `preguntasrespuestas`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincias`
--

CREATE TABLE IF NOT EXISTS `provincias` (
`OID` int(11) NOT NULL AUTO_INCREMENT,
  `IDProvincia` VARCHAR(50),
  `nombre` text COLLATE latin1_spanish_ci,
  PRIMARY KEY (`OID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `provincias`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyectos`
--

CREATE TABLE IF NOT EXISTS `proyectos` (
`OID` int(11) NOT NULL AUTO_INCREMENT,
  `IDProyecto` VARCHAR(50),
  `nombre` varchar(50) COLLATE latin1_spanish_ci,
  `descripcion` text COLLATE latin1_spanish_ci,
  `fechaInicio` datetime,
  `fechaFin` datetime,
  `disponible` tinyint(1),
  PRIMARY KEY (`OID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `proyectos`
--


--
-- Estructura de tabla para la tabla `referenciascomentarios`
--

CREATE TABLE IF NOT EXISTS `referenciascomentarios` (
`OID` int(11) NOT NULL AUTO_INCREMENT,
  `IDReferencia` VARCHAR(50),
  `IDComentarioReferenciado` VARCHAR(50),
  `IDComentarioReferenciador` VARCHAR(50),
  PRIMARY KEY (`OID)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `referenciascomentarios`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuestas`
--

CREATE TABLE IF NOT EXISTS `respuestas` (
`OID` int(11) NOT NULL AUTO_INCREMENT,
  `IDRespuesta` VARCHAR(50),
  `descripcionRespuesta` varchar(200) COLLATE latin1_spanish_ci,
  `numeroVotos` int(11),
  PRIMARY KEY (`OID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `respuestas`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `so`
--

CREATE TABLE IF NOT EXISTS `so` (
`OID` int(11) NOT NULL AUTO_INCREMENT,
  `IDSO` VARCHAR(50),
  `nombre` varchar(50) COLLATE latin1_spanish_ci,
  `esSOMovil` tinyint(1),
  PRIMARY KEY (`OID`),
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `so`
--
-- --------------------------------------------------------

-- --------------------------------------------------------

--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tags`
--

CREATE TABLE IF NOT EXISTS `tags` (
`OID` int(11) NOT NULL AUTO_INCREMENT,
  `IDTag` VARCHAR(50),
  `nombre` varchar(50) COLLATE latin1_spanish_ci,
  PRIMARY KEY (`OID`),
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=5 ;


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tagsaplicaciones`
--

CREATE TABLE IF NOT EXISTS `tagsaplicaciones` (
`OID` int(11) NOT NULL AUTO_INCREMENT,
  `IDRelacion` VARCHAR(50),
  `IDAplicacion` VARCHAR(50),
  `IDTag` VARCHAR(50),
  PRIMARY KEY (`OID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=6 ;


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarioencuestas`
--

CREATE TABLE IF NOT EXISTS `usuarioencuestas` (
`OID` int(11) NOT NULL AUTO_INCREMENT,
  `IDRelacion` VARCHAR(50),
  `IDEncuesta` VARCHAR(50),
  `IDUsuario` VARCHAR(50),
  `IDPregunta` VARCHAR(50),
  `IDRespuesta` VARCHAR(50),
  PRIMARY KEY (`OID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `usuarioencuestas`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
`OID` int(11) NOT NULL AUTO_INCREMENT,
  `IDUsuario` VARCHAR(50),
  `nombreUsuario` VARCHAR(50),
  `password` varchar(50) COLLATE latin1_spanish_ci,
  `email` varchar(50) COLLATE latin1_spanish_ci,
  `IDPerfil` VARCHAR(50),
  'karma' int,
  PRIMARY KEY (`OID`),
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
