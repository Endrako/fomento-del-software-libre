-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 15-06-2011 a las 18:47:39
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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=11 ;

--
-- Volcar la base de datos para la tabla `aplicaciones`
--

INSERT INTO `aplicaciones` (`OIDAplicacion`, `IDAplicacion`, `idUsuarioCreador`, `nombre`, `descripcion`, `fechaPublicacion`, `URLWeb`, `numeroVotosAFavor`, `numeroVotosEnContra`, `IDProyecto`) VALUES
(7, '1308051231663425dc559', '13080510052365afb1452', 'VLC', 'Reproductor de audio y video de gran calidad', '2011-06-14', 'www.videolan.org/vlc', 1, 1, NULL),
(8, '130805132428947edf781', '13080510052365afb1452', 'Winamp', 'Reproductor de audio y video de gran calidad con gran numero de opciones de ecualiacion de audio', '2011-06-14', 'www.winamp.com', 0, 0, NULL),
(9, '1308051401252ffffffffaa5d00f1', '13080510052365afb1452', 'Realplayer', 'Reproductor de prestigio de audio y video', '2011-06-14', 'es.real.com/realplayer', 0, 0, NULL),
(10, '130805147796042f49d39', '13080510052365afb1452', 'Open Office', 'El homologo de Microsoft Office para el mundo del software libre', '2011-06-14', 'es.openoffice.org', 0, 0, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colaboracionusuariosproyectos`
--

CREATE TABLE IF NOT EXISTS `colaboracionusuariosproyectos` (
  `OIDRelacion` int(11) NOT NULL AUTO_INCREMENT,
  `IDUsuario` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDProyecto` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`OIDRelacion`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=6 ;

--
-- Volcar la base de datos para la tabla `colaboracionusuariosproyectos`
--

INSERT INTO `colaboracionusuariosproyectos` (`OIDRelacion`, `IDUsuario`, `IDProyecto`) VALUES
(3, '13080510052365afb1452', '1308156294646bf55d32'),
(5, '13080510052365afb1452', '130815634709360d536b2');

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=7 ;

--
-- Volcar la base de datos para la tabla `encuestas`
--

INSERT INTO `encuestas` (`OIDEncuesta`, `IDEncuesta`, `IDUsuario`, `nombre`) VALUES
(4, '13080889735182639b353', '13080510052365afb1452', 'Encuesta sobre tendencias Linux'),
(5, '1308089377584ffffffffaf697eb8', '1308050771600768973ad', 'Encuesta sobre reproductores audio/video'),
(6, '130808964605141b9c182', '13080510052365afb1452', 'Encuesta sobre lenguajes de programaciÃ³n');

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
  `IDUsuario` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `finalizado` tinyint(1) NOT NULL,
  PRIMARY KEY (`OIDEnfrentamiento`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `enfrentamientos`
--

INSERT INTO `enfrentamientos` (`OIDEnfrentamiento`, `IDEnfrentamiento`, `IDAplicacion1`, `IDAplicacion2`, `descripcion`, `votosApp1`, `votosApp2`, `fechaCreacion`, `fechaFin`, `IDUsuario`, `finalizado`) VALUES
(2, '130805243569215643ced', '1308051231663425dc559', '130805132428947edf781', 'Reproductores de alto prestigio se somenten a una intensa evaluacion. ¿Quien ganará? Tú decides.', 0, 0, '2011-06-14 00:00:00', '2011-06-21 00:00:00', '13080510052365afb1452', 0),
(3, '1308052602836ffffffffae6dfc0b', '1308051231663425dc559', '1308051401252ffffffffaa5d00f1', 'El veterano Realplayer se cruzará con el reproductor en auge VLC.', 1, 0, '2011-05-10 00:00:00', '2011-05-17 00:00:00', '1308050771600768973ad', 1);

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=21 ;

--
-- Volcar la base de datos para la tabla `perfiles`
--

INSERT INTO `perfiles` (`OIDPerfil`, `IDPerfil`, `nombre`, `apellidos`, `edad`, `IDPais`, `IDProvincia`, `IDSO1`, `IDSO2`) VALUES
(17, '13080508494944eb3e2aa', 'Juan', 'Sanchez', 30, '1', '3', '1', '4'),
(18, '1308050948985ffffffffe67d4f37', '', '', 0, '1', '1', '1', '4'),
(19, '1308051008040ffffffff8416913c', '', '', 0, '1', '1', '1', '4'),
(20, '13080890367187bfe55c9', 'Marc', 'Bayón Benegas', 23, '1', '3', '3', '4');

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=20 ;

--
-- Volcar la base de datos para la tabla `preguntas`
--

INSERT INTO `preguntas` (`OIDPregunta`, `IDPregunta`, `IDEncuesta`, `descripcionPregunta`) VALUES
(3, '1308088626344ffffffffbc7e63b1', '1308088626343ffffffffa23915d6', 'Â¿QuÃ© entorno de escritorio usas?'),
(4, '1308088626353e88b913', '1308088626343ffffffffa23915d6', 'Â¿QuÃ© formato de video usas mÃ¡s a menudo?'),
(5, '130808862635846a39b4c', '1308088626343ffffffffa23915d6', 'Â¿QuÃ© distribuciÃ³n de Linux tienes instalada en tu PC?'),
(6, '130808862637033cd5b4', '1308088626343ffffffffa23915d6', 'Â¿QuÃ© tipo de sistema operativo usas mÃ¡s a menudo?'),
(7, '1308088626377597650ec', '1308088626343ffffffffa23915d6', 'Â¿Cuantas horas dedicas al diÃ¡ a trabajar con el ordenador?'),
(9, '13080889735183b0de1d6', '13080889735182639b353', 'Â¿QuÃ© entorno de escritorio usas?'),
(10, '13080889735253f37b06f', '13080889735182639b353', 'Â¿QuÃ© formato de video usas mÃ¡s a menudo?'),
(11, '1308088973530ffffffff8abcf1be', '13080889735182639b353', 'Â¿Que distrubuciÃ³n de Linux usas mÃ¡s?'),
(12, '13080889735553e1e7d17', '13080889735182639b353', 'Â¿QuÃ© tipo de sistema operativo usas mÃ¡s a menudo?'),
(13, '1308088973562ffffffffa0d7eeab', '13080889735182639b353', 'Â¿Cuantas horas dedicas al diÃ¡ a trabajar con el ordenador?'),
(14, '1308089377584ffffffffa5359ddc', '1308089377584ffffffffaf697eb8', 'Â¿Que reproductor de audio usas mÃ¡s a menudo?'),
(15, '1308089377592fffffffff45ef98d', '1308089377584ffffffffaf697eb8', 'Â¿QuÃ© reproductor de video usas mÃ¡s a menudo?'),
(16, '13080893775984d8c9972', '1308089377584ffffffffaf697eb8', 'Â¿Que te parece openshoot?'),
(17, '1308089646051ffffffffdc4037d8', '130808964605141b9c182', 'Â¿Eres desarrollador?'),
(18, '1308089646055ffffffffab331784', '130808964605141b9c182', 'Â¿En que lenguajes sueles programar aplicaciones para pc?'),
(19, '1308089646071ffffffffb65b2b94', '130808964605141b9c182', 'Â¿Que IDE usas mÃ¡s a menudo?');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntasrespuestas`
--

CREATE TABLE IF NOT EXISTS `preguntasrespuestas` (
  `OIDRelacion` int(11) NOT NULL AUTO_INCREMENT,
  `IDRespuesta` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `IDPregunta` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`OIDRelacion`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=75 ;

--
-- Volcar la base de datos para la tabla `preguntasrespuestas`
--

INSERT INTO `preguntasrespuestas` (`OIDRelacion`, `IDRespuesta`, `IDPregunta`) VALUES
(1, '1308088626344633e5198', '1308088626344ffffffffbc7e63b1'),
(2, '1308088626346ffffffffd3b83aa3', '1308088626344ffffffffbc7e63b1'),
(3, '1308088626348ffffffffdc095f0a', '1308088626344ffffffffbc7e63b1'),
(4, '13080886263514341a10d', '1308088626344ffffffffbc7e63b1'),
(5, '1308088626353fffffffffbdbeb34', '1308088626353e88b913'),
(6, '130808862635475aab537', '1308088626353e88b913'),
(7, '13080886263566757186a', '1308088626353e88b913'),
(8, '1308088626358ffffffffe6a8c92a', '130808862635846a39b4c'),
(9, '1308088626360380fcc38', '130808862635846a39b4c'),
(10, '13080886263613b533cb7', '130808862635846a39b4c'),
(11, '1308088626362ffffffffb25a7379', '130808862635846a39b4c'),
(12, '130808862636473e44f41', '130808862635846a39b4c'),
(13, '1308088626366ffffffffa4958aad', '130808862635846a39b4c'),
(14, '13080886263674af5658c', '130808862635846a39b4c'),
(15, '1308088626368ffffffffe6ee3ef2', '130808862635846a39b4c'),
(16, '1308088626370609cbafc', '130808862637033cd5b4'),
(17, '13080886263725af07291', '130808862637033cd5b4'),
(18, '13080886263743845bf44', '130808862637033cd5b4'),
(19, '1308088626375ffffffffe877d756', '130808862637033cd5b4'),
(20, '1308088626377ffffffffd2fc07fb', '1308088626377597650ec'),
(21, '1308088626379ffffffff9f722bc6', '1308088626377597650ec'),
(22, '1308088626381a2f391a', '1308088626377597650ec'),
(23, '1308088626383689a903e', '1308088626377597650ec'),
(24, '1308088626385ffffffffe4e77dc2', '1308088626377597650ec'),
(28, '1308088973521fffffffffdaf0f11', '13080889735183b0de1d6'),
(27, '1308088973519ffffffffddce08b2', '13080889735183b0de1d6'),
(29, '1308088973522ffffffffef26665c', '13080889735183b0de1d6'),
(30, '1308088973525ffffffff8c3ec068', '13080889735253f37b06f'),
(31, '130808897352660b675e2', '13080889735253f37b06f'),
(32, '130808897352825ff0117', '13080889735253f37b06f'),
(33, '1308088973530ffffffffdbc45327', '1308088973530ffffffff8abcf1be'),
(34, '13080889735413878cd8f', '1308088973530ffffffff8abcf1be'),
(35, '13080889735442a083558', '1308088973530ffffffff8abcf1be'),
(36, '13080889735461405ba23', '1308088973530ffffffff8abcf1be'),
(37, '1308088973547ffffffffd4b48329', '1308088973530ffffffff8abcf1be'),
(38, '1308088973549141caec2', '1308088973530ffffffff8abcf1be'),
(39, '1308088973550ffffffffd7471316', '1308088973530ffffffff8abcf1be'),
(40, '1308088973551ffffffff8b74bd6c', '1308088973530ffffffff8abcf1be'),
(41, '1308088973553fffffffff137b1d8', '1308088973530ffffffff8abcf1be'),
(42, '1308088973555ffffffff8c2a6a8e', '13080889735553e1e7d17'),
(43, '130808897355754b41a4a', '13080889735553e1e7d17'),
(44, '1308088973559ffffffffbba98193', '13080889735553e1e7d17'),
(45, '1308088973560ffffffffd2e2d2f5', '13080889735553e1e7d17'),
(46, '1308088973562ffffffffcf41177a', '1308088973562ffffffffa0d7eeab'),
(47, '1308088973564fffffffffd7fbb1f', '1308088973562ffffffffa0d7eeab'),
(48, '1308088973566ffffffffc7e5ec26', '1308088973562ffffffffa0d7eeab'),
(49, '1308088973567ffffffffb0664c8e', '1308088973562ffffffffa0d7eeab'),
(50, '13080889735698196e3d', '1308088973562ffffffffa0d7eeab'),
(51, '1308089377584574cbc7c', '1308089377584ffffffffa5359ddc'),
(52, '1308089377586ffffffffa4e66bf0', '1308089377584ffffffffa5359ddc'),
(53, '1308089377587fffffffff3eda54f', '1308089377584ffffffffa5359ddc'),
(54, '13080893775897f86bb0b', '1308089377584ffffffffa5359ddc'),
(55, '1308089377592ffffffffa4d80866', '1308089377592fffffffff45ef98d'),
(56, '13080893775933e40979f', '1308089377592fffffffff45ef98d'),
(57, '1308089377595ffffffffc3da3c35', '1308089377592fffffffff45ef98d'),
(58, '130808937759730d5404a', '1308089377592fffffffff45ef98d'),
(59, '13080893775991e942fee', '13080893775984d8c9972'),
(60, '1308089377600ffffffffe7b42235', '13080893775984d8c9972'),
(61, '1308089377601ffffffffdb29c8ef', '13080893775984d8c9972'),
(62, '13080893776045d570947', '13080893775984d8c9972'),
(63, '13080893776053abaa6f', '13080893775984d8c9972'),
(64, '1308089646051ffffffffc9b9a077', '1308089646051ffffffffdc4037d8'),
(65, '13080896460522efa1a90', '1308089646051ffffffffdc4037d8'),
(66, '13080896460557e415d97', '1308089646055ffffffffab331784'),
(67, '1308089646056446c9f2c', '1308089646055ffffffffab331784'),
(68, '1308089646058fffffffff5569a34', '1308089646055ffffffffab331784'),
(69, '13080896460601cf75a8d', '1308089646055ffffffffab331784'),
(70, '1308089646061ffffffffe1bce67e', '1308089646055ffffffffab331784'),
(71, '13080896460633a7f8dfd', '1308089646055ffffffffab331784'),
(72, '1308089646071ffffffffc2adc264', '1308089646071ffffffffb65b2b94'),
(73, '1308089646073a8808b3', '1308089646071ffffffffb65b2b94'),
(74, '1308089646074ffffffffb1c65c44', '1308089646071ffffffffb65b2b94');

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=7 ;

--
-- Volcar la base de datos para la tabla `proyectos`
--

INSERT INTO `proyectos` (`OIDProyecto`, `IDProyecto`, `IDUsuarioCreador`, `nombre`, `descripcion`, `fechaInicio`, `fechaFin`, `disponible`, `nivelKarma`) VALUES
(5, '1308156294646bf55d32', '13080510052365afb1452', 'prueba 1', 'descp1', '2011-06-15 00:00:00', '2011-09-13 00:00:00', 0, 50),
(6, '130815634709360d536b2', '13080510052365afb1452', 'prueba 2', 'desc 2', '2011-06-15 00:00:00', '2011-08-14 00:00:00', 1, 100);

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=75 ;

--
-- Volcar la base de datos para la tabla `respuestas`
--

INSERT INTO `respuestas` (`OIDRespuesta`, `IDRespuesta`, `descripcionRespuesta`, `numeroVotos`) VALUES
(1, '1308088626344633e5198', 'KDE', 0),
(2, '1308088626346ffffffffd3b83aa3', 'Gnome', 0),
(3, '1308088626348ffffffffdc095f0a', 'otro', 0),
(4, '13080886263514341a10d', 'no uso entorno de escritorio', 0),
(5, '1308088626353fffffffffbdbeb34', 'Divx', 0),
(6, '130808862635475aab537', 'HD', 0),
(7, '13080886263566757186a', 'otro', 0),
(8, '1308088626358ffffffffe6a8c92a', 'Ubuntu', 0),
(9, '1308088626360380fcc38', 'SuSe', 0),
(10, '13080886263613b533cb7', 'Mandriba', 0),
(11, '1308088626362ffffffffb25a7379', 'Fedora', 0),
(12, '130808862636473e44f41', 'Debian', 0),
(13, '1308088626366ffffffffa4958aad', 'Guadalinex', 0),
(14, '13080886263674af5658c', 'uso software privativo', 0),
(15, '1308088626368ffffffffe6ee3ef2', 'otra', 0),
(16, '1308088626370609cbafc', 'Windows', 0),
(17, '13080886263725af07291', 'Linux', 0),
(18, '13080886263743845bf44', 'Mac', 0),
(19, '1308088626375ffffffffe877d756', 'otro', 0),
(20, '1308088626377ffffffffd2fc07fb', 'menos de 1 hora', 0),
(21, '1308088626379ffffffff9f722bc6', '1-3 horas', 0),
(22, '1308088626381a2f391a', '4-8 horas', 0),
(23, '1308088626383689a903e', '8-12 horas', 0),
(24, '1308088626385ffffffffe4e77dc2', 'mÃ¡s de 12 horas', 0),
(27, '1308088973519ffffffffddce08b2', 'KDE', 1),
(28, '1308088973521fffffffffdaf0f11', 'Gnome', 4),
(29, '1308088973522ffffffffef26665c', 'otro', 1),
(30, '1308088973525ffffffff8c3ec068', 'Divx', 1),
(31, '130808897352660b675e2', 'HD', 4),
(32, '130808897352825ff0117', 'Otro', 0),
(33, '1308088973530ffffffffdbc45327', 'Ubuntu', 1),
(34, '13080889735413878cd8f', 'Debian', 0),
(35, '13080889735442a083558', 'Mandriba', 3),
(36, '13080889735461405ba23', 'Fedora', 1),
(37, '1308088973547ffffffffd4b48329', 'Suse', 0),
(38, '1308088973549141caec2', 'Guadalinex', 0),
(39, '1308088973550ffffffffd7471316', 'Red hat', 0),
(40, '1308088973551ffffffff8b74bd6c', 'No uso software libre', 1),
(41, '1308088973553fffffffff137b1d8', 'otra', 0),
(42, '1308088973555ffffffff8c2a6a8e', 'Windows', 1),
(43, '130808897355754b41a4a', 'Linux', 5),
(44, '1308088973559ffffffffbba98193', 'Mac', 0),
(45, '1308088973560ffffffffd2e2d2f5', 'otro', 0),
(46, '1308088973562ffffffffcf41177a', 'menos de 1 hora', 5),
(47, '1308088973564fffffffffd7fbb1f', '1-3 horas', 0),
(48, '1308088973566ffffffffc7e5ec26', '4-8 horas', 1),
(49, '1308088973567ffffffffb0664c8e', '8-12 horas', 0),
(50, '13080889735698196e3d', 'mÃ¡s de 12 horas', 0),
(51, '1308089377584574cbc7c', 'Spotify', 0),
(52, '1308089377586ffffffffa4e66bf0', 'Banshee', 1),
(53, '1308089377587fffffffff3eda54f', 'xmedia', 0),
(54, '13080893775897f86bb0b', 'otro', 0),
(55, '1308089377592ffffffffa4d80866', 'VLC', 1),
(56, '13080893775933e40979f', 'Totem', 0),
(57, '1308089377595ffffffffc3da3c35', 'uso youtube como proveedor de videos', 0),
(58, '130808937759730d5404a', 'otro', 0),
(59, '13080893775991e942fee', 'No lo sÃ©, no me suena', 1),
(60, '1308089377600ffffffffe7b42235', 'Calidad excelente', 0),
(61, '1308089377601ffffffffdb29c8ef', 'Dificil de manejar', 0),
(62, '13080893776045d570947', 'Lo he bicheado pero no me apasiona', 0),
(63, '13080893776053abaa6f', 'no me gusta la ediciÃ³n de videos', 0),
(64, '1308089646051ffffffffc9b9a077', 'Si', 0),
(65, '13080896460522efa1a90', 'No', 0),
(66, '13080896460557e415d97', 'C', 0),
(67, '1308089646056446c9f2c', 'C++', 0),
(68, '1308089646058fffffffff5569a34', 'Java', 0),
(69, '13080896460601cf75a8d', '.net', 0),
(70, '1308089646061ffffffffe1bce67e', 'objetive c', 0),
(71, '13080896460633a7f8dfd', 'otro', 0),
(72, '1308089646071ffffffffc2adc264', 'Eclipse', 0),
(73, '1308089646073a8808b3', 'Visual Estudio', 0),
(74, '1308089646074ffffffffb1c65c44', 'otro', 0);

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=23 ;

--
-- Volcar la base de datos para la tabla `tagsaplicaciones`
--

INSERT INTO `tagsaplicaciones` (`OIDRelacion`, `IDAplicacion`, `IDTag`) VALUES
(16, '1308051231663425dc559', 'vid'),
(17, '1308051231663425dc559', 'mus'),
(18, '130805132428947edf781', 'vid'),
(19, '130805132428947edf781', 'mus'),
(20, '1308051401252ffffffffaa5d00f1', 'vid'),
(21, '1308051401252ffffffffaa5d00f1', 'mus'),
(22, '130805147796042f49d39', 'ofi');

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=21 ;

--
-- Volcar la base de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`OIDUsuario`, `IDUsuario`, `nombreUsuario`, `contrasenna`, `email`, `IDPerfil`, `karma`, `numeroRecomendaciones`) VALUES
(17, '1308050771600768973ad', 'sheinx', 'sheinx', 'sheinx@test.com', '13080508494944eb3e2aa', 415, 4),
(18, '1308050943696732e470d', 'tristan', 'tristan', 'tristan@test.com', '1308050948985ffffffffe67d4f37', 25, 0),
(19, '13080510052365afb1452', 'marc', 'marc', 'marc@test.com', '1308051008040ffffffff8416913c', 750, 0),
(20, '1308089015393fffffffff964b61f', 'arundil', '1234', 'mb154@hotmail.com', '13080890367187bfe55c9', 10, 0);

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `votos`
--

INSERT INTO `votos` (`OIDVoto`, `IDVoto`, `IDUsuario`, `IDAplicacion`, `valor`) VALUES
(1, '13080515216597d81049f', '13080510052365afb1452', '1308051231663425dc559', 1),
(2, '1308052987925ffffffff8495bc8b', '1308050943696732e470d', '1308051231663425dc559', 0);

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `votosusuarioenfrentamiento`
--

INSERT INTO `votosusuarioenfrentamiento` (`OIDRelacion`, `IDEnfrentamiento`, `IDUsuario`, `IDAplicacion`) VALUES
(1, '1308052602836ffffffffae6dfc0b', '1308050771600768973ad', '1308051231663425dc559');
