-- phpMyAdmin SQL Dump
-- version 2.9.0.1
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tiempo de generación: 12-05-2011 a las 09:21:08
-- Versión del servidor: 5.0.24
-- Versión de PHP: 5.1.6
-- 
-- Base de datos: `prueba asdasdasd`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `aplicaciones`
-- 

CREATE TABLE IF NOT EXISTS `aplicaciones` (
  `OIDAplicacion` int(11) NOT NULL auto_increment,
  `IDAplicacion` varchar(50) collate latin1_spanish_ci NOT NULL,
  `nombre` varchar(50) collate latin1_spanish_ci NOT NULL,
  `descripcion` text collate latin1_spanish_ci NOT NULL,
  `fechaPublicacion` date NOT NULL,
  `URLWeb` varchar(200) collate latin1_spanish_ci NOT NULL,
  `numeroVotosAFavor` int(11) NOT NULL,
  `numeroVotosEnContra` int(11) NOT NULL,
  `IDProyecto` varchar(50) collate latin1_spanish_ci default NULL,
  PRIMARY KEY  (`OIDAplicacion`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=5 ;

-- 
-- Volcar la base de datos para la tabla `aplicaciones`
-- 

INSERT INTO `aplicaciones` VALUES (1, '', 'VLC', 'Reproductor de video multicodecs.', '2011-04-29', 'www.url1.com', 0, 0, NULL);
INSERT INTO `aplicaciones` VALUES (2, '', 'Open Office', 'Programa de ofimatica parecida al Microsoft Office', '2011-04-28', 'www.url2.com', 0, 0, NULL);
INSERT INTO `aplicaciones` VALUES (3, '', 'Winamp', 'Reproductor de audio y video normalito', '2011-04-22', 'www.url3.com', 0, 0, NULL);
INSERT INTO `aplicaciones` VALUES (4, '', 'Calculetor', 'Calculadora para estadisticos', '2011-04-23', 'www.url4.com', 0, 0, NULL);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `colaboracionusuariosproyectos`
-- 

CREATE TABLE IF NOT EXISTS `colaboracionusuariosproyectos` (
  `OIDRelacion` int(11) NOT NULL auto_increment,
  `IDUsuario` varchar(50) collate latin1_spanish_ci NOT NULL,
  `IDProyecto` varchar(50) collate latin1_spanish_ci NOT NULL,
  PRIMARY KEY  (`OIDRelacion`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

-- 
-- Volcar la base de datos para la tabla `colaboracionusuariosproyectos`
-- 

INSERT INTO `colaboracionusuariosproyectos` VALUES (1, '1', '2');
INSERT INTO `colaboracionusuariosproyectos` VALUES (2, '2', '1');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `comentarios`
-- 

CREATE TABLE IF NOT EXISTS `comentarios` (
  `OIDComentario` int(11) NOT NULL auto_increment,
  `IDComentario` varchar(50) collate latin1_spanish_ci NOT NULL,
  `IDAplicacion` varchar(50) collate latin1_spanish_ci NOT NULL,
  `IDUsuario` varchar(50) collate latin1_spanish_ci NOT NULL,
  `descripcion` text collate latin1_spanish_ci NOT NULL,
  PRIMARY KEY  (`OIDComentario`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

-- 
-- Volcar la base de datos para la tabla `comentarios`
-- 

INSERT INTO `comentarios` VALUES (1, '', '1', '3', 'El programa se me queda pillado cuando pongo un video de alta definicion');
INSERT INTO `comentarios` VALUES (2, '', '1', '2', 'Un gran programa, lo reproduce todo todo todo');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `encuestas`
-- 

CREATE TABLE IF NOT EXISTS `encuestas` (
  `OIDEncuesta` int(11) NOT NULL auto_increment,
  `IDEncuesta` varchar(50) collate latin1_spanish_ci NOT NULL,
  `nombre` varchar(100) collate latin1_spanish_ci NOT NULL,
  PRIMARY KEY  (`OIDEncuesta`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

-- 
-- Volcar la base de datos para la tabla `encuestas`
-- 

INSERT INTO `encuestas` VALUES (1, '', 'Reproductores de video');
INSERT INTO `encuestas` VALUES (2, '', 'Programas de ofimatica');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `enfrentamientos`
-- 

CREATE TABLE IF NOT EXISTS `enfrentamientos` (
  `OIDEnfrentamiento` int(11) NOT NULL auto_increment,
  `IDEnfrentamiento` varchar(50) collate latin1_spanish_ci NOT NULL,
  `IDAplicacion1` varchar(50) collate latin1_spanish_ci NOT NULL,
  `IDAplicacion2` varchar(50) collate latin1_spanish_ci NOT NULL,
  `descripcion` text collate latin1_spanish_ci NOT NULL,
  `votosApp1` int(11) NOT NULL,
  `votosApp2` int(11) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `fechaFin` datetime NOT NULL,
  `aceptado` tinyint(1) NOT NULL,
  PRIMARY KEY  (`OIDEnfrentamiento`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=2 ;

-- 
-- Volcar la base de datos para la tabla `enfrentamientos`
-- 

INSERT INTO `enfrentamientos` VALUES (1, '', '1', '3', 'VLC vs Winamp ¿Quien ganra? voten', 0, 0, '2011-04-29 14:53:05', '2011-04-30 14:53:09', 1);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `paises`
-- 

CREATE TABLE IF NOT EXISTS `paises` (
  `OIDPais` int(11) NOT NULL auto_increment,
  `IDPais` varchar(50) collate latin1_spanish_ci NOT NULL,
  `nombre` varchar(50) collate latin1_spanish_ci NOT NULL,
  PRIMARY KEY  (`OIDPais`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

-- 
-- Volcar la base de datos para la tabla `paises`
-- 

INSERT INTO `paises` VALUES (1, '', 'España');
INSERT INTO `paises` VALUES (2, '', 'Portugal');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `perfiles`
-- 

CREATE TABLE IF NOT EXISTS `perfiles` (
  `OIDPerfil` int(11) NOT NULL auto_increment,
  `IDPerfil` varchar(50) collate latin1_spanish_ci NOT NULL,
  `nombre` varchar(50) collate latin1_spanish_ci default NULL,
  `apellidos` varchar(50) collate latin1_spanish_ci default NULL,
  `edad` int(3) default NULL,
  `IDPais` varchar(50) collate latin1_spanish_ci default NULL,
  `IDProvincia` varchar(50) collate latin1_spanish_ci default NULL,
  `IDSO1` varchar(50) collate latin1_spanish_ci default NULL,
  `IDSO2` varchar(50) collate latin1_spanish_ci default NULL,
  PRIMARY KEY  (`OIDPerfil`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

-- 
-- Volcar la base de datos para la tabla `perfiles`
-- 

INSERT INTO `perfiles` VALUES (1, '', 'Alvaro', NULL, 22, '1', '3', '1', '2');
INSERT INTO `perfiles` VALUES (2, '', 'Fco Javier', NULL, 24, '1', '3', '1', '2');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `preguntas`
-- 

CREATE TABLE IF NOT EXISTS `preguntas` (
  `OIDPregunta` int(11) NOT NULL auto_increment,
  `IDPregunta` varchar(50) collate latin1_spanish_ci NOT NULL,
  `IDEncuesta` varchar(50) collate latin1_spanish_ci NOT NULL,
  `descripcionPregunta` varchar(150) collate latin1_spanish_ci NOT NULL,
  PRIMARY KEY  (`OIDPregunta`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

-- 
-- Volcar la base de datos para la tabla `preguntas`
-- 

INSERT INTO `preguntas` VALUES (1, '', '1', '¿Cual tiene mejor calidad de video?');
INSERT INTO `preguntas` VALUES (2, '', '1', '¿Cual tiene mejor calidad de sonido?');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `preguntasrespuestas`
-- 

CREATE TABLE IF NOT EXISTS `preguntasrespuestas` (
  `OIDRelacion` int(11) NOT NULL auto_increment,
  `IDRespuesta` varchar(50) collate latin1_spanish_ci NOT NULL,
  `IDPregunta` varchar(50) collate latin1_spanish_ci NOT NULL,
  PRIMARY KEY  (`OIDRelacion`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `preguntasrespuestas`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `provincias`
-- 

CREATE TABLE IF NOT EXISTS `provincias` (
  `OIDProvincia` int(11) NOT NULL auto_increment,
  `IDProvincia` varchar(50) collate latin1_spanish_ci NOT NULL,
  `nombre` text collate latin1_spanish_ci NOT NULL,
  PRIMARY KEY  (`OIDProvincia`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=5 ;

-- 
-- Volcar la base de datos para la tabla `provincias`
-- 

INSERT INTO `provincias` VALUES (1, '', 'Madrid');
INSERT INTO `provincias` VALUES (2, '', 'Badajoz');
INSERT INTO `provincias` VALUES (3, '', 'Sevilla');
INSERT INTO `provincias` VALUES (4, '', 'Almeria');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `proyectos`
-- 

CREATE TABLE IF NOT EXISTS `proyectos` (
  `OIDProyecto` int(11) NOT NULL auto_increment,
  `IDProyecto` varchar(50) collate latin1_spanish_ci NOT NULL,
  `nombre` varchar(50) collate latin1_spanish_ci NOT NULL,
  `descripcion` text collate latin1_spanish_ci NOT NULL,
  `fechaInicio` datetime NOT NULL,
  `fechaFin` datetime default NULL,
  `disponible` tinyint(1) NOT NULL,
  `nivelKarma` int(11) NOT NULL,
  PRIMARY KEY  (`OIDProyecto`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

-- 
-- Volcar la base de datos para la tabla `proyectos`
-- 

INSERT INTO `proyectos` VALUES (1, '', 'Pacome', 'Calendario de comidas para lpersonas de la tercera edad', '2011-04-29 15:45:54', '2012-04-27 15:45:58', 1, 0);
INSERT INTO `proyectos` VALUES (2, '', 'Pacorrer', 'Calendario de marchas y senderismo en España.', '2011-04-29 15:46:29', '2012-04-27 15:46:32', 1, 0);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `referenciascomentarios`
-- 

CREATE TABLE IF NOT EXISTS `referenciascomentarios` (
  `OIDReferencia` int(11) NOT NULL auto_increment,
  `IDComentarioReferenciado` varchar(50) collate latin1_spanish_ci NOT NULL,
  `IDComentarioReferenciador` varchar(50) collate latin1_spanish_ci NOT NULL,
  PRIMARY KEY  (`OIDReferencia`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `referenciascomentarios`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `respuestas`
-- 

CREATE TABLE IF NOT EXISTS `respuestas` (
  `OIDRespuesta` int(11) NOT NULL auto_increment,
  `IDRespuesta` varchar(50) collate latin1_spanish_ci NOT NULL,
  `descripcionRespuesta` varchar(200) collate latin1_spanish_ci NOT NULL,
  `numeroVotos` int(11) NOT NULL,
  PRIMARY KEY  (`OIDRespuesta`),
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
  `OIDSO` int(11) NOT NULL auto_increment,
  `IDSO` varchar(50) collate latin1_spanish_ci NOT NULL,
  `nombre` varchar(50) collate latin1_spanish_ci NOT NULL,
  `esSOMovil` tinyint(1) NOT NULL,
  PRIMARY KEY  (`OIDSO`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=5 ;

-- 
-- Volcar la base de datos para la tabla `so`
-- 

INSERT INTO `so` VALUES (1, '', 'Windows 7', 0);
INSERT INTO `so` VALUES (2, '', 'Windows Vista', 0);
INSERT INTO `so` VALUES (3, '', 'Ubuntu 11.04', 0);
INSERT INTO `so` VALUES (4, '', 'Android', 1);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `tags`
-- 

CREATE TABLE IF NOT EXISTS `tags` (
  `OIDTag` int(11) NOT NULL auto_increment,
  `IDTag` varchar(50) collate latin1_spanish_ci NOT NULL,
  `nombre` varchar(50) collate latin1_spanish_ci NOT NULL,
  PRIMARY KEY  (`OIDTag`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=5 ;

-- 
-- Volcar la base de datos para la tabla `tags`
-- 

INSERT INTO `tags` VALUES (1, '', 'Video');
INSERT INTO `tags` VALUES (2, '', 'Antivirus');
INSERT INTO `tags` VALUES (3, '', 'Musica');
INSERT INTO `tags` VALUES (4, '', 'Ofimatica');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `tagsaplicaciones`
-- 

CREATE TABLE IF NOT EXISTS `tagsaplicaciones` (
  `OIDRelacion` int(11) NOT NULL auto_increment,
  `IDAplicacion` varchar(50) collate latin1_spanish_ci NOT NULL,
  `IDTag` varchar(50) collate latin1_spanish_ci NOT NULL,
  PRIMARY KEY  (`OIDRelacion`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=6 ;

-- 
-- Volcar la base de datos para la tabla `tagsaplicaciones`
-- 

INSERT INTO `tagsaplicaciones` VALUES (1, '1', '1');
INSERT INTO `tagsaplicaciones` VALUES (2, '3', '1');
INSERT INTO `tagsaplicaciones` VALUES (3, '3', '3');
INSERT INTO `tagsaplicaciones` VALUES (4, '2', '4');
INSERT INTO `tagsaplicaciones` VALUES (5, '4', '4');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `usuarioencuestas`
-- 

CREATE TABLE IF NOT EXISTS `usuarioencuestas` (
  `OIDRelacion` int(11) NOT NULL auto_increment,
  `IDEncuesta` varchar(50) collate latin1_spanish_ci NOT NULL,
  `IDUsuario` varchar(50) collate latin1_spanish_ci NOT NULL,
  `IDPregunta` varchar(50) collate latin1_spanish_ci NOT NULL,
  `IDRespuesta` varchar(50) collate latin1_spanish_ci NOT NULL,
  PRIMARY KEY  (`OIDRelacion`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `usuarioencuestas`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `usuarios`
-- 

CREATE TABLE IF NOT EXISTS `usuarios` (
  `OIDUsuario` int(11) NOT NULL auto_increment,
  `IDUsuario` varchar(50) collate latin1_spanish_ci NOT NULL,
  `nombreUsuario` varchar(50) collate latin1_spanish_ci NOT NULL,
  `contrasenna` varchar(50) collate latin1_spanish_ci NOT NULL,
  `email` varchar(50) collate latin1_spanish_ci NOT NULL,
  `IDPerfil` varchar(50) collate latin1_spanish_ci default NULL,
  `karma` int(11) NOT NULL,
  `numeroRecomendaciones` int(11) NOT NULL,
  PRIMARY KEY  (`OIDUsuario`),
  UNIQUE KEY `nombreUsuario` (`nombreUsuario`,`email`,`IDPerfil`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

-- 
-- Volcar la base de datos para la tabla `usuarios`
-- 

INSERT INTO `usuarios` VALUES (1, '', 'Varusblack', 'isg3', 'algo@email.com', '1', 0, 0);
INSERT INTO `usuarios` VALUES (2, '', 'lordreivaj', 'isg3', 'alguien@email.com', '2', 0, 0);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `votos`
-- 

CREATE TABLE IF NOT EXISTS `votos` (
  `OIDVoto` int(11) NOT NULL auto_increment,
  `IDVoto` varchar(50) collate latin1_spanish_ci NOT NULL,
  `IDUsuario` varchar(50) collate latin1_spanish_ci NOT NULL,
  `IDAplicacion` varchar(50) collate latin1_spanish_ci NOT NULL,
  `valor` tinyint(1) NOT NULL,
  PRIMARY KEY  (`OIDVoto`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `votos`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `votosusuarioenfrentamiento`
-- 

CREATE TABLE IF NOT EXISTS `votosusuarioenfrentamiento` (
  `OIDRelacion` int(11) NOT NULL auto_increment,
  `IDEnfrentamiento` varchar(50) collate latin1_spanish_ci NOT NULL,
  `IDUsuario` varchar(50) collate latin1_spanish_ci NOT NULL,
  `IDAplicacion` varchar(50) collate latin1_spanish_ci NOT NULL,
  PRIMARY KEY  (`OIDRelacion`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `votosusuarioenfrentamiento`
-- 

