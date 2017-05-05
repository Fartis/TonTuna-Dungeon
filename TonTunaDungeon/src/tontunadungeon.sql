-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 04-05-2017 a las 07:21:34
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `tontunadungeon`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `arma`
--

CREATE TABLE IF NOT EXISTS `arma` (
  `nombre` varchar(20) NOT NULL,
  `atributo` enum('fuerza','destreza','intelecto') NOT NULL,
  `bonificador` int(10) unsigned NOT NULL,
  `descripcion` text NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `armadura`
--

CREATE TABLE IF NOT EXISTS `armadura` (
  `nombre` varchar(20) NOT NULL,
  `bonificador` int(10) unsigned NOT NULL,
  `indice` int(10) unsigned NOT NULL,
  `descripcion` text NOT NULL,
  `nivel` int unsigned NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `desbloqueado`
--

CREATE TABLE IF NOT EXISTS `desbloqueado` (
  `raza` varchar(20) NOT NULL,
  `logro` varchar(20) NOT NULL,
  `desbloqueado` tinyint(1) NOT NULL DEFAULT '0',
  `fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `raza` (`raza`),
  UNIQUE KEY `logro` (`logro`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eliminado`
--

CREATE TABLE IF NOT EXISTS `eliminado` (
  `nombrePJ` varchar(20) NOT NULL,
  `nombreMON` varchar(20) NOT NULL,
  `cantidad` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`nombrePJ`,`nombreMON`),
  UNIQUE KEY `nombrePJ` (`nombrePJ`),
  UNIQUE KEY `nombreMON` (`nombreMON`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `logro`
--

CREATE TABLE IF NOT EXISTS `logro` (
  `nombre` varchar(50) NOT NULL,
  `descripcion` text,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `monstruo`
--

CREATE TABLE IF NOT EXISTS `monstruo` (
  `nombre` varchar(20) NOT NULL,
  `nivel` int(10) unsigned NOT NULL,
  `fuerza` int(10) unsigned NOT NULL,
  `destreza` int(10) unsigned NOT NULL,
  `intelecto` int(10) unsigned NOT NULL,
  `constitucion` int(10) unsigned NOT NULL,
  `descripcion` text NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `objeto`
--

CREATE TABLE IF NOT EXISTS `objeto` (
  `nombre` varchar(20) NOT NULL,
  `tipo` enum('curacion','apoyo','daño') NOT NULL,
  `bonificador` int(10) unsigned NOT NULL,
  `descripcion` text NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personaje`
--

CREATE TABLE IF NOT EXISTS `personaje` (
  `raza` varchar(20) NOT NULL,
  `fuerza` int(10) unsigned NOT NULL,
  `destreza` int(10) unsigned NOT NULL,
  `intelecto` int(10) unsigned NOT NULL,
  `constitucion` int(10) unsigned NOT NULL,
  `descripcion` text NOT NULL,
  PRIMARY KEY (`raza`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pjcreado`
--

CREATE TABLE IF NOT EXISTS `pjcreado` (
  `nombre` varchar(20) NOT NULL,
  `raza` varchar(20) NOT NULL,
  `nivel` int(10) unsigned NOT NULL,
  `fcreacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `vivo` tinyint(1) DEFAULT '1',
  `fmuerte` tinyint(1) DEFAULT NULL,
  `fuerza` int(10) unsigned NOT NULL,
  `destreza` int(10) unsigned NOT NULL,
  `intelecto` int(10) unsigned NOT NULL,
  `constitucion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`nombre`,`raza`),
  UNIQUE KEY `nombre` (`nombre`),
  UNIQUE KEY `raza` (`raza`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiene`
--

CREATE TABLE IF NOT EXISTS `tiene` (
  `nombrePJ` varchar(20) NOT NULL,
  `nombreOB` varchar(20) NOT NULL,
  `cantidad` int(10) unsigned NOT NULL,
  PRIMARY KEY (`nombrePJ`,`nombreOB`),
  UNIQUE KEY `nombrePJ` (`nombrePJ`),
  UNIQUE KEY `nombreOB` (`nombreOB`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `utiliza`
--

CREATE TABLE IF NOT EXISTS `utiliza` (
  `nombrePJ` varchar(20) NOT NULL,
  `nombreARMA` varchar(20) NOT NULL,
  PRIMARY KEY (`nombrePJ`,`nombreARMA`),
  UNIQUE KEY `nombrePJ` (`nombrePJ`),
  UNIQUE KEY `nombreARMA` (`nombreARMA`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `utilizamon`
--

CREATE TABLE IF NOT EXISTS `utilizamon` (
  `nombreMON` varchar(20) NOT NULL,
  `nombreARMA` varchar(20) NOT NULL,
  PRIMARY KEY (`nombreMON`,`nombreARMA`),
  UNIQUE KEY `nombreMON` (`nombreMON`),
  UNIQUE KEY `nombreARMA` (`nombreARMA`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `viste`
--

CREATE TABLE IF NOT EXISTS `viste` (
  `nombrePJ` varchar(20) NOT NULL,
  `nombreARMADURA` varchar(20) NOT NULL,
  PRIMARY KEY (`nombrePJ`,`nombreARMADURA`),
  UNIQUE KEY `nombrePJ` (`nombrePJ`),
  UNIQUE KEY `nombreARMADURA` (`nombreARMADURA`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vistemon`
--

CREATE TABLE IF NOT EXISTS `vistemon` (
  `nombreMON` varchar(20) NOT NULL,
  `nombreARMADURA` varchar(20) NOT NULL,
  PRIMARY KEY (`nombreMON`,`nombreARMADURA`),
  UNIQUE KEY `nombreMON` (`nombreMON`),
  UNIQUE KEY `nombreARMADURA` (`nombreARMADURA`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pjcreado`
--
ALTER TABLE `pjcreado`
  ADD CONSTRAINT `pjcreado_ibfk_1` FOREIGN KEY (`raza`) REFERENCES `personaje` (`raza`) ON DELETE NO ACTION ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
