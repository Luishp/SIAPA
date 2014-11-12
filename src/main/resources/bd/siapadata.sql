-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-11-2014 a las 06:39:37
-- Versión del servidor: 5.5.32
-- Versión de PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `siapa`
--
CREATE DATABASE IF NOT EXISTS `siapa` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `siapa`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alimento`
--

CREATE TABLE IF NOT EXISTS `alimento` (
  `ID_ALIMENTO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_TIPO_ALIMENTO` int(11) DEFAULT NULL,
  `MARCA_ALIMENTO` varchar(50) DEFAULT NULL,
  `EXISTENCIA_ALIMENTO` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID_ALIMENTO`),
  KEY `FK_RELATIONSHIP_13` (`ID_TIPO_ALIMENTO`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `alimento`
--

INSERT INTO `alimento` (`ID_ALIMENTO`, `ID_TIPO_ALIMENTO`, `MARCA_ALIMENTO`, `EXISTENCIA_ALIMENTO`) VALUES(2, 3, 'ALCON', '100.00');
INSERT INTO `alimento` (`ID_ALIMENTO`, `ID_TIPO_ALIMENTO`, `MARCA_ALIMENTO`, `EXISTENCIA_ALIMENTO`) VALUES(4, 4, 'ALCON', '150.00');
INSERT INTO `alimento` (`ID_ALIMENTO`, `ID_TIPO_ALIMENTO`, `MARCA_ALIMENTO`, `EXISTENCIA_ALIMENTO`) VALUES(5, 7, 'Alianza', '1501.00');
INSERT INTO `alimento` (`ID_ALIMENTO`, `ID_TIPO_ALIMENTO`, `MARCA_ALIMENTO`, `EXISTENCIA_ALIMENTO`) VALUES(6, 6, 'DELTA', '234.00');
INSERT INTO `alimento` (`ID_ALIMENTO`, `ID_TIPO_ALIMENTO`, `MARCA_ALIMENTO`, `EXISTENCIA_ALIMENTO`) VALUES(7, 7, 'OMEGA', '159.00');
INSERT INTO `alimento` (`ID_ALIMENTO`, `ID_TIPO_ALIMENTO`, `MARCA_ALIMENTO`, `EXISTENCIA_ALIMENTO`) VALUES(8, 7, 'OMEGA', '159.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE IF NOT EXISTS `categorias` (
  `ID_CATEGORIAS` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE_CATEGORIAS` varchar(50) NOT NULL,
  `DESCRIPCION_CATEGORIAS` varchar(500) NOT NULL,
  PRIMARY KEY (`ID_CATEGORIAS`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`ID_CATEGORIAS`, `NOMBRE_CATEGORIAS`, `DESCRIPCION_CATEGORIAS`) VALUES(1, 'A', 'categoria 1 de prueba');
INSERT INTO `categorias` (`ID_CATEGORIAS`, `NOMBRE_CATEGORIAS`, `DESCRIPCION_CATEGORIAS`) VALUES(2, 'B', 'categoria 2 de prueba');
INSERT INTO `categorias` (`ID_CATEGORIAS`, `NOMBRE_CATEGORIAS`, `DESCRIPCION_CATEGORIAS`) VALUES(3, 'C', 'Categoria de prueba ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `ID_CLIENTE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_CATEGORIAS` int(11) DEFAULT NULL,
  `ID_PERSONA` int(11) DEFAULT NULL,
  `NOMBRE_CLIENTE_COMP_VENTA` varchar(50) NOT NULL,
  `DIRECCION_CLIENTE` varchar(500) DEFAULT NULL,
  `TIPO_CLIENTE` varchar(1) NOT NULL,
  PRIMARY KEY (`ID_CLIENTE`),
  KEY `FK_RELATIONSHIP_22` (`ID_CATEGORIAS`),
  KEY `FK_RELATIONSHIP_25` (`ID_PERSONA`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`ID_CLIENTE`, `ID_CATEGORIAS`, `ID_PERSONA`, `NOMBRE_CLIENTE_COMP_VENTA`, `DIRECCION_CLIENTE`, `TIPO_CLIENTE`) VALUES(3, 3, 6, 'Izabel Goulart', 'Brasil', 'C');
INSERT INTO `cliente` (`ID_CLIENTE`, `ID_CATEGORIAS`, `ID_PERSONA`, `NOMBRE_CLIENTE_COMP_VENTA`, `DIRECCION_CLIENTE`, `TIPO_CLIENTE`) VALUES(4, 1, 5, 'Behati Prinsloo ', '(Namibia)()', 'A');
INSERT INTO `cliente` (`ID_CLIENTE`, `ID_CATEGORIAS`, `ID_PERSONA`, `NOMBRE_CLIENTE_COMP_VENTA`, `DIRECCION_CLIENTE`, `TIPO_CLIENTE`) VALUES(5, 3, 5, 'Behati Prinsloo ', '(Namibia)()', 'C');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_contacto`
--

CREATE TABLE IF NOT EXISTS `cliente_contacto` (
  `ID_CONTACTO` decimal(18,0) NOT NULL,
  `ID_PERSONA` int(11) NOT NULL,
  `VALOR_CLIENTE_CONTACTO` varchar(100) NOT NULL,
  `ACTIVO_CLIENTE_CONTACTO` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID_CONTACTO`,`ID_PERSONA`),
  KEY `FK_CLIENTE_CONTACTO2` (`ID_PERSONA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE IF NOT EXISTS `compra` (
  `ID_COMPRA` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PROVEEDOR` int(11) DEFAULT NULL,
  `FECHA_HORA_COMPRA` date NOT NULL,
  `USUARIO_COMPRA` varchar(30) NOT NULL,
  `TOTAL_COMPRA` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID_COMPRA`),
  KEY `FK_RELATIONSHIP_15` (`ID_PROVEEDOR`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`ID_COMPRA`, `ID_PROVEEDOR`, `FECHA_HORA_COMPRA`, `USUARIO_COMPRA`, `TOTAL_COMPRA`) VALUES(1, 2, '2014-11-03', 'AOP', '125.00');
INSERT INTO `compra` (`ID_COMPRA`, `ID_PROVEEDOR`, `FECHA_HORA_COMPRA`, `USUARIO_COMPRA`, `TOTAL_COMPRA`) VALUES(2, 2, '2014-11-08', 'juan', '1223.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprobante_venta`
--

CREATE TABLE IF NOT EXISTS `comprobante_venta` (
  `ID_COMPROBANTE_VENTA` decimal(18,0) NOT NULL,
  `ID_VENTA` decimal(18,0) DEFAULT NULL,
  `ID_TIPO_COMPROBANTE` decimal(18,0) DEFAULT NULL,
  `NOMBRE_CLIENTE_COMP_VENTA` varchar(50) NOT NULL,
  `DIRECCION_COMPROBANTE_VENTA` varchar(500) NOT NULL,
  `TEL_COMPROBANTE_VENTA` varchar(14) DEFAULT NULL,
  `NRC_COMPROBANTE_VENTA` varchar(14) DEFAULT NULL,
  `NIT_COMPROBANTE_VENTA` varchar(17) DEFAULT NULL,
  `FECHA_HORA_COMPROBANTE_VENTA` date DEFAULT NULL,
  `TOTAL_COMPROBANTE_VENTA` decimal(10,2) DEFAULT NULL,
  `TOTAL_LETRAS_COMPROBANTE_VENTA` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID_COMPROBANTE_VENTA`),
  KEY `FK_RELATIONSHIP_1` (`ID_TIPO_COMPROBANTE`),
  KEY `FK_RELATIONSHIP_3` (`ID_VENTA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contacto`
--

CREATE TABLE IF NOT EXISTS `contacto` (
  `ID_CONTACTO` decimal(18,0) NOT NULL,
  `NOMBRE_CONTACTO` varchar(50) NOT NULL,
  `DESCRIPCION_CONTACTO` varchar(500) NOT NULL,
  PRIMARY KEY (`ID_CONTACTO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `descuento`
--

CREATE TABLE IF NOT EXISTS `descuento` (
  `ID_DESCUENTO` decimal(18,0) NOT NULL,
  `ID_CATEGORIAS` int(11) DEFAULT NULL,
  `ID_PRODUCTO` decimal(18,0) DEFAULT NULL,
  `NOMBRE_DESCUENTO` varchar(50) NOT NULL,
  `DESCRIPCION_DESCUENTO` varchar(500) NOT NULL,
  `PORCENTAJE_DESCUENTO` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID_DESCUENTO`),
  KEY `FK_RELATIONSHIP_19` (`ID_PRODUCTO`),
  KEY `FK_RELATIONSHIP_20` (`ID_CATEGORIAS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_compra_alimento`
--

CREATE TABLE IF NOT EXISTS `detalle_compra_alimento` (
  `ID_DETALLE_COMPRA_ALIMENTO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_COMPRA` int(11) DEFAULT NULL,
  `ID_ALIMENTO` int(11) DEFAULT NULL,
  `CANT_DETALLE_COMPRA_ALIMENTO` decimal(10,2) NOT NULL,
  `PRECIO_DETALLE_COMPRA_ALIMENTO` decimal(10,2) NOT NULL,
  `IMPUESTO_DET_COMPRA_ALIMENTO` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID_DETALLE_COMPRA_ALIMENTO`),
  KEY `FK_RELATIONSHIP_14` (`ID_COMPRA`),
  KEY `ID_ALIMENTO` (`ID_ALIMENTO`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `detalle_compra_alimento`
--

INSERT INTO `detalle_compra_alimento` (`ID_DETALLE_COMPRA_ALIMENTO`, `ID_COMPRA`, `ID_ALIMENTO`, `CANT_DETALLE_COMPRA_ALIMENTO`, `PRECIO_DETALLE_COMPRA_ALIMENTO`, `IMPUESTO_DET_COMPRA_ALIMENTO`) VALUES(1, 1, 7, '12.00', '1.25', '13.00');
INSERT INTO `detalle_compra_alimento` (`ID_DETALLE_COMPRA_ALIMENTO`, `ID_COMPRA`, `ID_ALIMENTO`, `CANT_DETALLE_COMPRA_ALIMENTO`, `PRECIO_DETALLE_COMPRA_ALIMENTO`, `IMPUESTO_DET_COMPRA_ALIMENTO`) VALUES(2, 2, 7, '12.00', '1.25', '13.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_comprobante_venta`
--

CREATE TABLE IF NOT EXISTS `detalle_comprobante_venta` (
  `ID_DETALLE_COMPROBANTE_VENTA` decimal(18,0) NOT NULL,
  `ID_COMPROBANTE_VENTA` decimal(18,0) DEFAULT NULL,
  `PRODUCTO_DETALLE_COMP_VENTA` varchar(50) NOT NULL,
  `CANTIDAD_DETALLE_COMP_VENTA` decimal(10,2) NOT NULL,
  `DESCRIPCION_DETALLE_COMP_VENTA` varchar(500) NOT NULL,
  `PRECIO_UNITARIO_DET_COMP_VENTA` decimal(10,2) NOT NULL,
  `TIPO_VENTA_DETALLE_COMP_VENTA` varchar(1) NOT NULL,
  `TOTAL_DETALLE_COMPROBANTE_VENTA` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID_DETALLE_COMPROBANTE_VENTA`),
  KEY `FK_RELATIONSHIP_2` (`ID_COMPROBANTE_VENTA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_muestreo`
--

CREATE TABLE IF NOT EXISTS `detalle_muestreo` (
  `ID_DETALLE_MUESTREO` decimal(18,0) NOT NULL,
  `ID_MUESTREO` decimal(18,0) DEFAULT NULL,
  `CANTIDAD_DETALLE_MUESTREO` decimal(10,2) NOT NULL,
  `PESO_DETALLE_MUESTREO` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID_DETALLE_MUESTREO`),
  KEY `FK_RELATIONSHIP_9` (`ID_MUESTREO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta`
--

CREATE TABLE IF NOT EXISTS `detalle_venta` (
  `ID_DETALLE_VENTA` decimal(18,0) NOT NULL,
  `ID_PRODUCTO` decimal(18,0) DEFAULT NULL,
  `ID_JAULA` int(11) DEFAULT NULL,
  `ID_VENTA` decimal(18,0) DEFAULT NULL,
  `CANTIDAD_DETALLE_VENTA` decimal(10,2) NOT NULL,
  `PORCENTAJE_DES_DETALLE_VENTA` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID_DETALLE_VENTA`),
  KEY `FK_RELATIONSHIP_17` (`ID_JAULA`),
  KEY `FK_RELATIONSHIP_18` (`ID_PRODUCTO`),
  KEY `FK_RELATIONSHIP_21` (`ID_VENTA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingreso_producto`
--

CREATE TABLE IF NOT EXISTS `ingreso_producto` (
  `ID_INGRESO_PRODUCTO` decimal(18,0) NOT NULL,
  `ID_PRODUCTO` decimal(18,0) DEFAULT NULL,
  `ID_JAULA` int(11) DEFAULT NULL,
  `CANTIDAD_INGRESO_PRODUCTO` decimal(10,2) NOT NULL,
  `FECHA_HORA_INGRESO_PRODUCTO` date NOT NULL,
  `USUARIO_INGRESO_PRODUCTO` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_INGRESO_PRODUCTO`),
  KEY `FK_RELATIONSHIP_24` (`ID_PRODUCTO`),
  KEY `FK_RELATIONSHIP_6` (`ID_JAULA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jaula`
--

CREATE TABLE IF NOT EXISTS `jaula` (
  `ID_JAULA` int(11) NOT NULL AUTO_INCREMENT,
  `ID_TIPO_JAULA` int(11) DEFAULT NULL,
  `NOMBRE_JAULA` varchar(50) NOT NULL,
  `DESCRIPCION_JAULA` varchar(500) DEFAULT NULL,
  `LISTA_VENTA_JAULA` tinyint(1) DEFAULT NULL,
  `FECHA_VENTA_JAULA` date NOT NULL,
  `FECHA_SIEMBRA_JAULA` date NOT NULL,
  `VENTA_JAULA` decimal(8,0) NOT NULL,
  PRIMARY KEY (`ID_JAULA`),
  KEY `FK_RELATIONSHIP_7` (`ID_TIPO_JAULA`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `muestreo`
--

CREATE TABLE IF NOT EXISTS `muestreo` (
  `ID_MUESTREO` decimal(18,0) NOT NULL,
  `ID_JAULA` int(11) DEFAULT NULL,
  `PESO_PROMEDIO_MUESTREO` decimal(10,2) NOT NULL,
  `FECHA_MUESTREO` date NOT NULL,
  `USUARIO_MUESTREO` varchar(30) NOT NULL,
  `FECHA_REGISTRO_MUESTREO` date NOT NULL,
  PRIMARY KEY (`ID_MUESTREO`),
  KEY `FK_RELATIONSHIP_8` (`ID_JAULA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE IF NOT EXISTS `persona` (
  `ID_PERSONA` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE_PERSONA` varchar(50) NOT NULL,
  `DIRECCION_PERSONA` varchar(500) DEFAULT NULL,
  `NRC_PERSONA` varchar(14) DEFAULT NULL,
  `NIT_PERSONA` varchar(17) DEFAULT NULL,
  `DUI_PERSONA` varchar(14) DEFAULT NULL,
  `TIPO_PERSONA` varchar(1) NOT NULL,
  PRIMARY KEY (`ID_PERSONA`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`ID_PERSONA`, `NOMBRE_PERSONA`, `DIRECCION_PERSONA`, `NRC_PERSONA`, `NIT_PERSONA`, `DUI_PERSONA`, `TIPO_PERSONA`) VALUES(1, 'Joao Hernandez', 'San Marcos', '123456', '321564', '2348949879', 'A');
INSERT INTO `persona` (`ID_PERSONA`, `NOMBRE_PERSONA`, `DIRECCION_PERSONA`, `NRC_PERSONA`, `NIT_PERSONA`, `DUI_PERSONA`, `TIPO_PERSONA`) VALUES(2, 'Walter Hernandez', 'Mejicanos', '789467868', '46416876416', '645468465746', 'B');
INSERT INTO `persona` (`ID_PERSONA`, `NOMBRE_PERSONA`, `DIRECCION_PERSONA`, `NRC_PERSONA`, `NIT_PERSONA`, `DUI_PERSONA`, `TIPO_PERSONA`) VALUES(3, 'Ricardo Armando Flamenco', 'San Martin #3', '1654891354', '12213123', '232323222', 'A');
INSERT INTO `persona` (`ID_PERSONA`, `NOMBRE_PERSONA`, `DIRECCION_PERSONA`, `NRC_PERSONA`, `NIT_PERSONA`, `DUI_PERSONA`, `TIPO_PERSONA`) VALUES(4, 'Alessandra Ambrosio ', 'Brasil #12, San Jacinto', '78916946198', '1654768162165', '65431894651657', 'A');
INSERT INTO `persona` (`ID_PERSONA`, `NOMBRE_PERSONA`, `DIRECCION_PERSONA`, `NRC_PERSONA`, `NIT_PERSONA`, `DUI_PERSONA`, `TIPO_PERSONA`) VALUES(5, 'Behati Prinsloo ', '(Namibia)()', '92512436146', '913434161657', '16541364655165', 'C');
INSERT INTO `persona` (`ID_PERSONA`, `NOMBRE_PERSONA`, `DIRECCION_PERSONA`, `NRC_PERSONA`, `NIT_PERSONA`, `DUI_PERSONA`, `TIPO_PERSONA`) VALUES(6, 'Izabel Goulart', 'Brasil', '1891564545615', '005961261', '0651364130', 'B');
INSERT INTO `persona` (`ID_PERSONA`, `NOMBRE_PERSONA`, `DIRECCION_PERSONA`, `NRC_PERSONA`, `NIT_PERSONA`, `DUI_PERSONA`, `TIPO_PERSONA`) VALUES(7, 'Kasia Struss', '(Polonia) ', '004405055', '0011224105', '0000521205', 'B');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE IF NOT EXISTS `producto` (
  `ID_PRODUCTO` decimal(18,0) NOT NULL,
  `NOMBRE_PRODUCTO` varchar(50) NOT NULL,
  `DESCRIPCION_PRODUCTO` varchar(500) DEFAULT NULL,
  `ACTIVO_PRODUCTO` tinyint(1) NOT NULL,
  `PRECIO_PRODUCTO` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID_PRODUCTO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE IF NOT EXISTS `proveedor` (
  `ID_PROVEEDOR` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PERSONA` int(11) DEFAULT NULL,
  `FECHA_PROVEEDOR` date NOT NULL,
  `USUARIO_PROVEEDOR` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_PROVEEDOR`),
  KEY `FK_RELATIONSHIP_26` (`ID_PERSONA`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`ID_PROVEEDOR`, `ID_PERSONA`, `FECHA_PROVEEDOR`, `USUARIO_PROVEEDOR`) VALUES(1, 5, '2014-11-20', 'EAD');
INSERT INTO `proveedor` (`ID_PROVEEDOR`, `ID_PERSONA`, `FECHA_PROVEEDOR`, `USUARIO_PROVEEDOR`) VALUES(2, 6, '2014-11-28', 'EAD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro_alimentacion`
--

CREATE TABLE IF NOT EXISTS `registro_alimentacion` (
  `ID_REGISTRO_ALIMENTACION` decimal(18,0) NOT NULL,
  `ID_ALIMENTO` int(11) DEFAULT NULL,
  `ID_JAULA` int(11) DEFAULT NULL,
  `CANTIDAD_REGISTRO_ALIMENTACION` decimal(10,2) NOT NULL,
  `FECHA_HORA_REG_ALIMENTACION` date NOT NULL,
  `USUARIO_REGISTRO_ALIMENTACION` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_REGISTRO_ALIMENTACION`),
  KEY `FK_RELATIONSHIP_16` (`ID_JAULA`),
  KEY `ID_ALIMENTO` (`ID_ALIMENTO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro_mortalidad`
--

CREATE TABLE IF NOT EXISTS `registro_mortalidad` (
  `ID_REGISTRO_MORTALIDAD` decimal(18,0) NOT NULL,
  `ID_JAULA` int(11) DEFAULT NULL,
  `CANTIDAD_REGISTRO_MORTALIDAD` decimal(10,2) NOT NULL,
  `FECHA_REGISTRO_MORTALIDAD` date NOT NULL,
  `USUARIO_REGISTRO_MORTALIDAD` varchar(30) NOT NULL,
  `FECHA_INGRESO_REG_MORTALIDAD` date NOT NULL,
  PRIMARY KEY (`ID_REGISTRO_MORTALIDAD`),
  KEY `FK_RELATIONSHIP_10` (`ID_JAULA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_alimento`
--

CREATE TABLE IF NOT EXISTS `tipo_alimento` (
  `ID_TIPO_ALIMENTO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE_TIPO_ALIMENTO` varchar(50) NOT NULL,
  `DESCRICION_TIPO_ALIMENTO` varchar(500) DEFAULT NULL,
  `PORCE_PROTEINA_TIPO_ALIMENTO` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID_TIPO_ALIMENTO`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `tipo_alimento`
--

INSERT INTO `tipo_alimento` (`ID_TIPO_ALIMENTO`, `NOMBRE_TIPO_ALIMENTO`, `DESCRICION_TIPO_ALIMENTO`, `PORCE_PROTEINA_TIPO_ALIMENTO`) VALUES(3, 'Alimento liofilizado', 'Son alimentos deshidratados mediante una técnica especial que les permite conservar todos sus nutrientes\n\n\n', '12.5');
INSERT INTO `tipo_alimento` (`ID_TIPO_ALIMENTO`, `NOMBRE_TIPO_ALIMENTO`, `DESCRICION_TIPO_ALIMENTO`, `PORCE_PROTEINA_TIPO_ALIMENTO`) VALUES(4, 'Papillas', ' El alimento se presenta en forma de papilla, después de haber mezclado y batido los ingredientes correspondientes.\n\n\n', '21.5');
INSERT INTO `tipo_alimento` (`ID_TIPO_ALIMENTO`, `NOMBRE_TIPO_ALIMENTO`, `DESCRICION_TIPO_ALIMENTO`, `PORCE_PROTEINA_TIPO_ALIMENTO`) VALUES(6, ' Alimento Fresco', 'Mejillones, gambas, corazón de res... Estos alimentos pueden proporcionarse ocasionalmente en su forma natural, siempre troceados en función del tamaño de los peces\n', '5.5');
INSERT INTO `tipo_alimento` (`ID_TIPO_ALIMENTO`, `NOMBRE_TIPO_ALIMENTO`, `DESCRICION_TIPO_ALIMENTO`, `PORCE_PROTEINA_TIPO_ALIMENTO`) VALUES(7, 'daphnia', 'las larvas de mosquito, camarones recién eclosionados o adultos (según el tipo de pez a alimentar) y las pequeñas lombrices Tubifex.\n', '.2.2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_comprobante`
--

CREATE TABLE IF NOT EXISTS `tipo_comprobante` (
  `ID_TIPO_COMPROBANTE` decimal(18,0) NOT NULL,
  `NOMBRE_TIPO_COMPROBANTE` varchar(50) DEFAULT NULL,
  `DESCRIPCION_TIPO_COMPROBANTE` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID_TIPO_COMPROBANTE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_jaula`
--

CREATE TABLE IF NOT EXISTS `tipo_jaula` (
  `ID_TIPO_JAULA` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE_TIPO_JAULA` varchar(50) NOT NULL,
  `DESCRIPCION_TIPO_JAULA` varchar(500) DEFAULT NULL,
  `ANCHO_TIPO_JAULA` decimal(10,2) NOT NULL,
  `LARGO_TIPO_JAULA` decimal(10,2) NOT NULL,
  `PROFUNDIDAD_TIPO_JAULA` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID_TIPO_JAULA`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `tipo_jaula`
--

INSERT INTO `tipo_jaula` (`ID_TIPO_JAULA`, `NOMBRE_TIPO_JAULA`, `DESCRIPCION_TIPO_JAULA`, `ANCHO_TIPO_JAULA`, `LARGO_TIPO_JAULA`, `PROFUNDIDAD_TIPO_JAULA`) VALUES(1, 'V', 'Jaula de Ventas', '8.40', '6.70', '4.50');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `traslados`
--

CREATE TABLE IF NOT EXISTS `traslados` (
  `ID_TRASLADOS` decimal(18,0) NOT NULL,
  `ID_JAULA` int(11) DEFAULT NULL,
  `FECHA_HORA_TRASLADOS` date NOT NULL,
  `USUARIO_TRASLADOS` varchar(30) NOT NULL,
  `CANTIDAD_TRASLADOS` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID_TRASLADOS`),
  KEY `FK_RELATIONSHIP_5` (`ID_JAULA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE IF NOT EXISTS `venta` (
  `ID_VENTA` decimal(18,0) NOT NULL,
  `ID_CLIENTE` int(11) DEFAULT NULL,
  `ID_COMPROBANTE_VENTA` decimal(18,0) DEFAULT NULL,
  `FECHA_HORA_VENTA` date NOT NULL,
  `USUARIO_VENTA` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_VENTA`),
  KEY `FK_RELATIONSHIP_23` (`ID_CLIENTE`),
  KEY `FK_RELATIONSHIP_4` (`ID_COMPROBANTE_VENTA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alimento`
--
ALTER TABLE `alimento`
  ADD CONSTRAINT `alimento_ibfk_1` FOREIGN KEY (`ID_TIPO_ALIMENTO`) REFERENCES `tipo_alimento` (`ID_TIPO_ALIMENTO`);

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`ID_PERSONA`) REFERENCES `persona` (`ID_PERSONA`),
  ADD CONSTRAINT `cliente_ibfk_2` FOREIGN KEY (`ID_CATEGORIAS`) REFERENCES `categorias` (`ID_CATEGORIAS`);

--
-- Filtros para la tabla `cliente_contacto`
--
ALTER TABLE `cliente_contacto`
  ADD CONSTRAINT `cliente_contacto_ibfk_1` FOREIGN KEY (`ID_PERSONA`) REFERENCES `persona` (`ID_PERSONA`),
  ADD CONSTRAINT `FK_CLIENTE_CONTACTO` FOREIGN KEY (`ID_CONTACTO`) REFERENCES `contacto` (`ID_CONTACTO`);

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`ID_PROVEEDOR`) REFERENCES `proveedor` (`ID_PROVEEDOR`);

--
-- Filtros para la tabla `comprobante_venta`
--
ALTER TABLE `comprobante_venta`
  ADD CONSTRAINT `FK_RELATIONSHIP_1` FOREIGN KEY (`ID_TIPO_COMPROBANTE`) REFERENCES `tipo_comprobante` (`ID_TIPO_COMPROBANTE`),
  ADD CONSTRAINT `FK_RELATIONSHIP_3` FOREIGN KEY (`ID_VENTA`) REFERENCES `venta` (`ID_VENTA`);

--
-- Filtros para la tabla `descuento`
--
ALTER TABLE `descuento`
  ADD CONSTRAINT `descuento_ibfk_1` FOREIGN KEY (`ID_CATEGORIAS`) REFERENCES `categorias` (`ID_CATEGORIAS`),
  ADD CONSTRAINT `FK_RELATIONSHIP_19` FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `producto` (`ID_PRODUCTO`);

--
-- Filtros para la tabla `detalle_compra_alimento`
--
ALTER TABLE `detalle_compra_alimento`
  ADD CONSTRAINT `detalle_compra_alimento_ibfk_1` FOREIGN KEY (`ID_ALIMENTO`) REFERENCES `alimento` (`ID_ALIMENTO`),
  ADD CONSTRAINT `detalle_compra_alimento_ibfk_2` FOREIGN KEY (`ID_COMPRA`) REFERENCES `compra` (`ID_COMPRA`);

--
-- Filtros para la tabla `detalle_comprobante_venta`
--
ALTER TABLE `detalle_comprobante_venta`
  ADD CONSTRAINT `FK_RELATIONSHIP_2` FOREIGN KEY (`ID_COMPROBANTE_VENTA`) REFERENCES `comprobante_venta` (`ID_COMPROBANTE_VENTA`);

--
-- Filtros para la tabla `detalle_muestreo`
--
ALTER TABLE `detalle_muestreo`
  ADD CONSTRAINT `FK_RELATIONSHIP_9` FOREIGN KEY (`ID_MUESTREO`) REFERENCES `muestreo` (`ID_MUESTREO`);

--
-- Filtros para la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD CONSTRAINT `detalle_venta_ibfk_1` FOREIGN KEY (`ID_JAULA`) REFERENCES `jaula` (`ID_JAULA`),
  ADD CONSTRAINT `FK_RELATIONSHIP_18` FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `producto` (`ID_PRODUCTO`),
  ADD CONSTRAINT `FK_RELATIONSHIP_21` FOREIGN KEY (`ID_VENTA`) REFERENCES `venta` (`ID_VENTA`);

--
-- Filtros para la tabla `ingreso_producto`
--
ALTER TABLE `ingreso_producto`
  ADD CONSTRAINT `ingreso_producto_ibfk_1` FOREIGN KEY (`ID_JAULA`) REFERENCES `jaula` (`ID_JAULA`),
  ADD CONSTRAINT `FK_RELATIONSHIP_24` FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `producto` (`ID_PRODUCTO`);

--
-- Filtros para la tabla `jaula`
--
ALTER TABLE `jaula`
  ADD CONSTRAINT `jaula_ibfk_1` FOREIGN KEY (`ID_TIPO_JAULA`) REFERENCES `tipo_jaula` (`ID_TIPO_JAULA`);

--
-- Filtros para la tabla `muestreo`
--
ALTER TABLE `muestreo`
  ADD CONSTRAINT `muestreo_ibfk_1` FOREIGN KEY (`ID_JAULA`) REFERENCES `jaula` (`ID_JAULA`);

--
-- Filtros para la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD CONSTRAINT `proveedor_ibfk_1` FOREIGN KEY (`ID_PERSONA`) REFERENCES `persona` (`ID_PERSONA`);

--
-- Filtros para la tabla `registro_alimentacion`
--
ALTER TABLE `registro_alimentacion`
  ADD CONSTRAINT `registro_alimentacion_ibfk_2` FOREIGN KEY (`ID_JAULA`) REFERENCES `jaula` (`ID_JAULA`),
  ADD CONSTRAINT `registro_alimentacion_ibfk_1` FOREIGN KEY (`ID_ALIMENTO`) REFERENCES `alimento` (`ID_ALIMENTO`);

--
-- Filtros para la tabla `registro_mortalidad`
--
ALTER TABLE `registro_mortalidad`
  ADD CONSTRAINT `registro_mortalidad_ibfk_1` FOREIGN KEY (`ID_JAULA`) REFERENCES `jaula` (`ID_JAULA`);

--
-- Filtros para la tabla `traslados`
--
ALTER TABLE `traslados`
  ADD CONSTRAINT `traslados_ibfk_1` FOREIGN KEY (`ID_JAULA`) REFERENCES `jaula` (`ID_JAULA`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `FK_RELATIONSHIP_4` FOREIGN KEY (`ID_COMPROBANTE_VENTA`) REFERENCES `comprobante_venta` (`ID_COMPROBANTE_VENTA`),
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `cliente` (`ID_CLIENTE`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;



-------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------
----------------------------------         SEGURIDAD     --------------------------------
-------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------
-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-11-2014 a las 06:40:56
-- Versión del servidor: 5.5.32
-- Versión de PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `siapa`
--
CREATE DATABASE IF NOT EXISTS `siapa` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `siapa`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ss_historico_claves`
--

CREATE TABLE IF NOT EXISTS `ss_historico_claves` (
  `ID_HISTORICO_CLAVE` decimal(9,0) NOT NULL COMMENT 'ID del histórico de clave.',
  `ID_USUARIO` decimal(9,0) DEFAULT NULL,
  `ID_USUARIO2` decimal(9,0) DEFAULT NULL,
  `FECHA_CLAVE` datetime DEFAULT NULL COMMENT 'Fecha en que la clave fue cambiada y movida al histórico.',
  `CLAVE2` varchar(100) DEFAULT NULL COMMENT 'Clave',
  PRIMARY KEY (`ID_HISTORICO_CLAVE`),
  KEY `AK_UK_SS_HISTORICO_CLAVES` (`ID_USUARIO2`,`CLAVE2`),
  KEY `FK_FK_SS_HIST_CLAVES_USUARIOS` (`ID_USUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contiene las claves que ha cambiado el usuario para controla';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ss_menus`
--

CREATE TABLE IF NOT EXISTS `ss_menus` (
  `ID_MENU` decimal(9,0) NOT NULL COMMENT 'Correlativo que identifica al menú.',
  `SS__ID_MENU` decimal(9,0) DEFAULT NULL COMMENT 'Correlativo que identifica al menú.',
  `NOMBRE_MENU` varchar(100) DEFAULT NULL COMMENT 'Nombre del menú ',
  `USUARIO_REGISTRO` varchar(15) DEFAULT NULL COMMENT 'Usuario que registra la información.',
  `FECHA_REGISTRO` datetime DEFAULT NULL COMMENT 'Fecha y hora en que se registra información',
  `USUARIO_ULTIMAMODIFICACION` varchar(15) DEFAULT NULL COMMENT 'Último usuario que modificó la información.',
  `FECHA_ULTIMAMODIFICACION` datetime DEFAULT NULL COMMENT 'Fecha y hora de última modificación de información.',
  PRIMARY KEY (`ID_MENU`),
  KEY `FK_FK_SS_MENUS_MENU_PADRE` (`SS__ID_MENU`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contiene los diferentes menus de las aplicaciones';

--
-- Volcado de datos para la tabla `ss_menus`
--

INSERT INTO `ss_menus` (`ID_MENU`, `SS__ID_MENU`, `NOMBRE_MENU`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`) VALUES('1', NULL, 'Ventas', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL);
INSERT INTO `ss_menus` (`ID_MENU`, `SS__ID_MENU`, `NOMBRE_MENU`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`) VALUES('2', NULL, 'Clientes', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL);
INSERT INTO `ss_menus` (`ID_MENU`, `SS__ID_MENU`, `NOMBRE_MENU`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`) VALUES('3', NULL, 'Administrar Producto', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL);
INSERT INTO `ss_menus` (`ID_MENU`, `SS__ID_MENU`, `NOMBRE_MENU`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`) VALUES('4', NULL, 'Jaulas', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL);
INSERT INTO `ss_menus` (`ID_MENU`, `SS__ID_MENU`, `NOMBRE_MENU`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`) VALUES('5', NULL, 'Alimento', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL);
INSERT INTO `ss_menus` (`ID_MENU`, `SS__ID_MENU`, `NOMBRE_MENU`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`) VALUES('6', NULL, 'Reportes', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL);
INSERT INTO `ss_menus` (`ID_MENU`, `SS__ID_MENU`, `NOMBRE_MENU`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`) VALUES('7', NULL, 'Configuracion', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL);
INSERT INTO `ss_menus` (`ID_MENU`, `SS__ID_MENU`, `NOMBRE_MENU`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`) VALUES('8', NULL, 'Producto', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ss_menus_opciones`
--

CREATE TABLE IF NOT EXISTS `ss_menus_opciones` (
  `ID_MENU` decimal(9,0) NOT NULL COMMENT 'Correlativo que identifica al menú.',
  `ID_OPCION` decimal(9,0) NOT NULL COMMENT 'Correlativo que identifica a la opción.',
  PRIMARY KEY (`ID_MENU`,`ID_OPCION`),
  KEY `FK_FK_SS_OPCIONES_MENUS` (`ID_OPCION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contiene la relacion n:n entre menus y opciones (de menú).';

--
-- Volcado de datos para la tabla `ss_menus_opciones`
--

INSERT INTO `ss_menus_opciones` (`ID_MENU`, `ID_OPCION`) VALUES('1', '2');
INSERT INTO `ss_menus_opciones` (`ID_MENU`, `ID_OPCION`) VALUES('1', '3');
INSERT INTO `ss_menus_opciones` (`ID_MENU`, `ID_OPCION`) VALUES('2', '4');
INSERT INTO `ss_menus_opciones` (`ID_MENU`, `ID_OPCION`) VALUES('3', '5');
INSERT INTO `ss_menus_opciones` (`ID_MENU`, `ID_OPCION`) VALUES('3', '6');
INSERT INTO `ss_menus_opciones` (`ID_MENU`, `ID_OPCION`) VALUES('3', '7');
INSERT INTO `ss_menus_opciones` (`ID_MENU`, `ID_OPCION`) VALUES('3', '8');
INSERT INTO `ss_menus_opciones` (`ID_MENU`, `ID_OPCION`) VALUES('3', '9');
INSERT INTO `ss_menus_opciones` (`ID_MENU`, `ID_OPCION`) VALUES('4', '10');
INSERT INTO `ss_menus_opciones` (`ID_MENU`, `ID_OPCION`) VALUES('5', '11');
INSERT INTO `ss_menus_opciones` (`ID_MENU`, `ID_OPCION`) VALUES('5', '12');
INSERT INTO `ss_menus_opciones` (`ID_MENU`, `ID_OPCION`) VALUES('8', '13');
INSERT INTO `ss_menus_opciones` (`ID_MENU`, `ID_OPCION`) VALUES('8', '14');
INSERT INTO `ss_menus_opciones` (`ID_MENU`, `ID_OPCION`) VALUES('2', '15');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ss_opciones`
--

CREATE TABLE IF NOT EXISTS `ss_opciones` (
  `ID_OPCION` decimal(9,0) NOT NULL COMMENT 'Correlativo que identifica a la opción.',
  `NOMBRE_OPCION` varchar(100) DEFAULT NULL COMMENT 'Nombre de la opción',
  `URL` varchar(300) DEFAULT NULL COMMENT 'URL de ubicación de la página de la opción.',
  `VISIBLE` varchar(1) DEFAULT '1' COMMENT 'Indica si la opción se muestra o no. (Si tiene un 1 = SI, Si tiene un 0 = NO, default=0)',
  `USUARIO_REGISTRO` varchar(15) DEFAULT NULL COMMENT 'Usuario que registra la información.',
  `FECHA_REGISTRO` datetime DEFAULT NULL COMMENT 'Fecha y hora en que se registra información',
  `USUARIO_ULTIMAMODIFICACION` varchar(15) DEFAULT NULL COMMENT 'Último usuario que modificó la información.',
  `FECHA_ULTIMAMODIFICACION` datetime DEFAULT NULL COMMENT 'Fecha y hora de última modificación de información.',
  `IMAGEN_OPCION` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_OPCION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contiene las diferentes opciones de los menús de las aplicac';

--
-- Volcado de datos para la tabla `ss_opciones`
--

INSERT INTO `ss_opciones` (`ID_OPCION`, `NOMBRE_OPCION`, `URL`, `VISIBLE`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `IMAGEN_OPCION`) VALUES('1', 'Home', '/siapa/views/index.xhtml', 'S', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL);
INSERT INTO `ss_opciones` (`ID_OPCION`, `NOMBRE_OPCION`, `URL`, `VISIBLE`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `IMAGEN_OPCION`) VALUES('2', 'Gestion de Ventas', '/siapa/views/index.xhtml', 'S', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL);
INSERT INTO `ss_opciones` (`ID_OPCION`, `NOMBRE_OPCION`, `URL`, `VISIBLE`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `IMAGEN_OPCION`) VALUES('3', 'Ingresar Cliente', '/siapa/views/index.xhtml', 'S', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL);
INSERT INTO `ss_opciones` (`ID_OPCION`, `NOMBRE_OPCION`, `URL`, `VISIBLE`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `IMAGEN_OPCION`) VALUES('4', 'Gestion de Clientes', '/siapa/views/index.xhtml', 'S', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL);
INSERT INTO `ss_opciones` (`ID_OPCION`, `NOMBRE_OPCION`, `URL`, `VISIBLE`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `IMAGEN_OPCION`) VALUES('5', 'Ingreso Peces Muertos', '/siapa/views/index.xhtml', 'S', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL);
INSERT INTO `ss_opciones` (`ID_OPCION`, `NOMBRE_OPCION`, `URL`, `VISIBLE`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `IMAGEN_OPCION`) VALUES('6', 'Ingreso de Muestreo', '/siapa/views/persona/index.xhtml', 'S', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL);
INSERT INTO `ss_opciones` (`ID_OPCION`, `NOMBRE_OPCION`, `URL`, `VISIBLE`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `IMAGEN_OPCION`) VALUES('7', 'Ingreso Alimento a Jaula', '/siapa/views/index.xhtml', 'S', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL);
INSERT INTO `ss_opciones` (`ID_OPCION`, `NOMBRE_OPCION`, `URL`, `VISIBLE`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `IMAGEN_OPCION`) VALUES('8', 'Gestion de Compra de Peces', '/siapa/views/index.xhtml', 'S', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL);
INSERT INTO `ss_opciones` (`ID_OPCION`, `NOMBRE_OPCION`, `URL`, `VISIBLE`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `IMAGEN_OPCION`) VALUES('9', 'Movimiento Entre Jaulas', '/siapa/views/index.xhtml', 'S', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL);
INSERT INTO `ss_opciones` (`ID_OPCION`, `NOMBRE_OPCION`, `URL`, `VISIBLE`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `IMAGEN_OPCION`) VALUES('10', 'Gestion de Jaulas', '/siapa/views/jaula/index.xhtml', 'S', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL);
INSERT INTO `ss_opciones` (`ID_OPCION`, `NOMBRE_OPCION`, `URL`, `VISIBLE`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `IMAGEN_OPCION`) VALUES('11', 'Gestion de Alimento', '/siapa/views/alimento/index.xhtml', 'S', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL);
INSERT INTO `ss_opciones` (`ID_OPCION`, `NOMBRE_OPCION`, `URL`, `VISIBLE`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `IMAGEN_OPCION`) VALUES('12', 'Compra de Alimento', '/siapa/views/cliente/index.xhtml', 'S', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL);
INSERT INTO `ss_opciones` (`ID_OPCION`, `NOMBRE_OPCION`, `URL`, `VISIBLE`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `IMAGEN_OPCION`) VALUES('13', 'Tipo de Producto', '/siapa/views/index.xhtml', 'S', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL);
INSERT INTO `ss_opciones` (`ID_OPCION`, `NOMBRE_OPCION`, `URL`, `VISIBLE`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `IMAGEN_OPCION`) VALUES('14', 'Ingresar Alimento', '/siapa/views/alimento/index.xhtml', 'S', 'desarrollo', '2014-11-01 00:00:00', NULL, NULL, NULL);
INSERT INTO `ss_opciones` (`ID_OPCION`, `NOMBRE_OPCION`, `URL`, `VISIBLE`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `IMAGEN_OPCION`) VALUES('15', 'Ingresar Proveedor', '/siapa/views/proveedor/index.xhtml', 'S', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ss_roles`
--

CREATE TABLE IF NOT EXISTS `ss_roles` (
  `ID_ROL` decimal(9,0) NOT NULL COMMENT 'Identificador único del rol',
  `CODIGO_ROL` varchar(50) DEFAULT NULL COMMENT 'Código que identifica al rol.',
  `NOMBRE_ROL` varchar(50) DEFAULT NULL COMMENT 'Nombre del Rol',
  `DESCRIPCION` varchar(150) DEFAULT NULL COMMENT 'Propiedades o usos que identifican al rol',
  `USUARIO_REGISTRO` varchar(15) DEFAULT NULL COMMENT 'Usuario que registra la información.',
  `FECHA_REGISTRO` datetime DEFAULT NULL COMMENT 'Fecha y hora en que se registra información',
  `USUARIO_ULTIMAMODIFICACION` varchar(15) DEFAULT NULL COMMENT 'Último usuario que modificó la información.',
  `FECHA_ULTIMAMODIFICACION` datetime DEFAULT NULL COMMENT 'Fecha y hora de última modificación de información.',
  PRIMARY KEY (`ID_ROL`),
  KEY `AK_UK_SS_ROLES_CODIGO_ROL` (`CODIGO_ROL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contiene los diferentes niveles de acceso que un usuario pue';

--
-- Volcado de datos para la tabla `ss_roles`
--

INSERT INTO `ss_roles` (`ID_ROL`, `CODIGO_ROL`, `NOMBRE_ROL`, `DESCRIPCION`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`) VALUES('1', 'EOP', 'Encargado Operativo', 'Posee privilegios ..', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL);
INSERT INTO `ss_roles` (`ID_ROL`, `CODIGO_ROL`, `NOMBRE_ROL`, `DESCRIPCION`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`) VALUES('2', 'EAD', 'Encargado Administrativo', 'Posee Privilegios de ...', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL);
INSERT INTO `ss_roles` (`ID_ROL`, `CODIGO_ROL`, `NOMBRE_ROL`, `DESCRIPCION`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`) VALUES('3', 'VEN', 'Vendedor', 'Encargado de registrar las ventas ', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL);
INSERT INTO `ss_roles` (`ID_ROL`, `CODIGO_ROL`, `NOMBRE_ROL`, `DESCRIPCION`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`) VALUES('4', 'OPE', 'Operario', 'Encargado de Realizar ...', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL);
INSERT INTO `ss_roles` (`ID_ROL`, `CODIGO_ROL`, `NOMBRE_ROL`, `DESCRIPCION`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`) VALUES('5', 'ADM', 'Administrador del Sistema', 'Tiene todos los provilegios de gestion de usuario y otras tareas de adminitracion del sistema', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL);
INSERT INTO `ss_roles` (`ID_ROL`, `CODIGO_ROL`, `NOMBRE_ROL`, `DESCRIPCION`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`) VALUES('6', 'ASC', 'Asociado', 'puede ver los reportes que se generan desde el sistema', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ss_roles_menu`
--

CREATE TABLE IF NOT EXISTS `ss_roles_menu` (
  `ID_MENU` decimal(9,0) NOT NULL COMMENT 'Correlativo que identifica al menú.',
  `ID_ROL` decimal(9,0) NOT NULL COMMENT 'Identificador único del rol',
  PRIMARY KEY (`ID_MENU`,`ID_ROL`),
  KEY `FK_SS_ROLES_MENU2` (`ID_ROL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contiene la relacion n:n entre roles y menus';

--
-- Volcado de datos para la tabla `ss_roles_menu`
--

INSERT INTO `ss_roles_menu` (`ID_MENU`, `ID_ROL`) VALUES('3', '1');
INSERT INTO `ss_roles_menu` (`ID_MENU`, `ID_ROL`) VALUES('4', '1');
INSERT INTO `ss_roles_menu` (`ID_MENU`, `ID_ROL`) VALUES('5', '1');
INSERT INTO `ss_roles_menu` (`ID_MENU`, `ID_ROL`) VALUES('6', '1');
INSERT INTO `ss_roles_menu` (`ID_MENU`, `ID_ROL`) VALUES('8', '1');
INSERT INTO `ss_roles_menu` (`ID_MENU`, `ID_ROL`) VALUES('1', '2');
INSERT INTO `ss_roles_menu` (`ID_MENU`, `ID_ROL`) VALUES('2', '2');
INSERT INTO `ss_roles_menu` (`ID_MENU`, `ID_ROL`) VALUES('3', '2');
INSERT INTO `ss_roles_menu` (`ID_MENU`, `ID_ROL`) VALUES('4', '2');
INSERT INTO `ss_roles_menu` (`ID_MENU`, `ID_ROL`) VALUES('7', '2');
INSERT INTO `ss_roles_menu` (`ID_MENU`, `ID_ROL`) VALUES('1', '3');
INSERT INTO `ss_roles_menu` (`ID_MENU`, `ID_ROL`) VALUES('8', '3');
INSERT INTO `ss_roles_menu` (`ID_MENU`, `ID_ROL`) VALUES('3', '4');
INSERT INTO `ss_roles_menu` (`ID_MENU`, `ID_ROL`) VALUES('7', '5');
INSERT INTO `ss_roles_menu` (`ID_MENU`, `ID_ROL`) VALUES('2', '6');
INSERT INTO `ss_roles_menu` (`ID_MENU`, `ID_ROL`) VALUES('6', '6');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ss_roles_opciones`
--

CREATE TABLE IF NOT EXISTS `ss_roles_opciones` (
  `ID_ROL` decimal(9,0) NOT NULL COMMENT 'Identificador único del rol',
  `ID_OPCION` decimal(9,0) NOT NULL COMMENT 'Correlativo que identifica a la opción.',
  PRIMARY KEY (`ID_ROL`,`ID_OPCION`),
  KEY `FK_SS_ROLES_OPCIONES2` (`ID_OPCION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ss_roles_opciones`
--

INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('1', '1');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('2', '1');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('3', '1');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('4', '1');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('5', '1');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('6', '1');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('2', '2');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('3', '2');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('2', '3');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('3', '3');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('2', '4');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('6', '4');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('4', '5');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('1', '6');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('4', '7');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('1', '8');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('2', '8');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('1', '9');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('1', '10');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('2', '10');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('1', '11');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('1', '12');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('3', '13');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('1', '14');
INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES('2', '15');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ss_roles_usuarios`
--

CREATE TABLE IF NOT EXISTS `ss_roles_usuarios` (
  `ID_ROL` decimal(9,0) NOT NULL COMMENT 'Identificador único del rol',
  `ID_USUARIO` decimal(9,0) NOT NULL,
  PRIMARY KEY (`ID_ROL`,`ID_USUARIO`),
  KEY `FK_SS_ROLES_USUARIOS2` (`ID_USUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contiene la relación n:n entre roles y usuarios';

--
-- Volcado de datos para la tabla `ss_roles_usuarios`
--

INSERT INTO `ss_roles_usuarios` (`ID_ROL`, `ID_USUARIO`) VALUES('1', '1');
INSERT INTO `ss_roles_usuarios` (`ID_ROL`, `ID_USUARIO`) VALUES('2', '2');
INSERT INTO `ss_roles_usuarios` (`ID_ROL`, `ID_USUARIO`) VALUES('3', '3');
INSERT INTO `ss_roles_usuarios` (`ID_ROL`, `ID_USUARIO`) VALUES('4', '4');
INSERT INTO `ss_roles_usuarios` (`ID_ROL`, `ID_USUARIO`) VALUES('5', '5');
INSERT INTO `ss_roles_usuarios` (`ID_ROL`, `ID_USUARIO`) VALUES('6', '6');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ss_usuarios`
--

CREATE TABLE IF NOT EXISTS `ss_usuarios` (
  `ID_USUARIO` decimal(9,0) NOT NULL,
  `CODIGO_USUARIO` varchar(15) DEFAULT NULL,
  `NOMBRE_USUARIO` varchar(100) DEFAULT NULL,
  `TELEFONO` varchar(20) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `CARGO` varchar(100) DEFAULT NULL,
  `DESCRIPCION` varchar(150) DEFAULT NULL COMMENT 'Propiedades o usos que identifican al rol',
  `BLOQUEADO` varchar(1) DEFAULT '0',
  `CLAVE` varchar(100) DEFAULT NULL,
  `INTENTOS_ACCESO_FALLIDOS` decimal(3,0) DEFAULT '0',
  `USUARIO_REGISTRO` varchar(15) DEFAULT NULL COMMENT 'Usuario que registra la información.',
  `FECHA_REGISTRO` datetime DEFAULT NULL COMMENT 'Fecha y hora en que se registra información',
  `USUARIO_ULTIMAMODIFICACION` varchar(15) DEFAULT NULL COMMENT 'Último usuario que modificó la información.',
  `FECHA_ULTIMAMODIFICACION` datetime DEFAULT NULL COMMENT 'Fecha y hora de última modificación de información.',
  `FECHA_ULTIMO_ACCESO` datetime DEFAULT NULL,
  `DIRECCION_ACCESO` varchar(100) DEFAULT NULL,
  `DETALLE_ULTIMO_ACCESO` varchar(300) DEFAULT NULL,
  `FECHA_CAMBIO_CLAVE` datetime DEFAULT NULL,
  `CODIGO_SUCURSAL` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`ID_USUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ss_usuarios`
--

INSERT INTO `ss_usuarios` (`ID_USUARIO`, `CODIGO_USUARIO`, `NOMBRE_USUARIO`, `TELEFONO`, `EMAIL`, `CARGO`, `DESCRIPCION`, `BLOQUEADO`, `CLAVE`, `INTENTOS_ACCESO_FALLIDOS`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `FECHA_ULTIMO_ACCESO`, `DIRECCION_ACCESO`, `DETALLE_ULTIMO_ACCESO`, `FECHA_CAMBIO_CLAVE`, `CODIGO_SUCURSAL`) VALUES('1', 'EOP', 'Encargado Operativo', '78421829', 'siapa@gmail.com', 'Encargado Operativo', NULL, 'N', 'e10adc3949ba59abbe56e057f20f883e', '0', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ss_usuarios` (`ID_USUARIO`, `CODIGO_USUARIO`, `NOMBRE_USUARIO`, `TELEFONO`, `EMAIL`, `CARGO`, `DESCRIPCION`, `BLOQUEADO`, `CLAVE`, `INTENTOS_ACCESO_FALLIDOS`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `FECHA_ULTIMO_ACCESO`, `DIRECCION_ACCESO`, `DETALLE_ULTIMO_ACCESO`, `FECHA_CAMBIO_CLAVE`, `CODIGO_SUCURSAL`) VALUES('2', 'EAD', 'Encargado Administrativo', '78421829', 'siapa@gmail.com', 'Encargado Administrativo', NULL, 'N', 'e10adc3949ba59abbe56e057f20f883e', '0', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ss_usuarios` (`ID_USUARIO`, `CODIGO_USUARIO`, `NOMBRE_USUARIO`, `TELEFONO`, `EMAIL`, `CARGO`, `DESCRIPCION`, `BLOQUEADO`, `CLAVE`, `INTENTOS_ACCESO_FALLIDOS`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `FECHA_ULTIMO_ACCESO`, `DIRECCION_ACCESO`, `DETALLE_ULTIMO_ACCESO`, `FECHA_CAMBIO_CLAVE`, `CODIGO_SUCURSAL`) VALUES('3', 'VEN', 'Vendedor', '78421829', 'siapa@gmail.com', 'Vendedor', NULL, 'N', 'e10adc3949ba59abbe56e057f20f883e', '0', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ss_usuarios` (`ID_USUARIO`, `CODIGO_USUARIO`, `NOMBRE_USUARIO`, `TELEFONO`, `EMAIL`, `CARGO`, `DESCRIPCION`, `BLOQUEADO`, `CLAVE`, `INTENTOS_ACCESO_FALLIDOS`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `FECHA_ULTIMO_ACCESO`, `DIRECCION_ACCESO`, `DETALLE_ULTIMO_ACCESO`, `FECHA_CAMBIO_CLAVE`, `CODIGO_SUCURSAL`) VALUES('4', 'OPE', 'Operario', '78421829', 'siapa@gmail.com', 'Operario', NULL, 'N', 'e10adc3949ba59abbe56e057f20f883e', '0', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ss_usuarios` (`ID_USUARIO`, `CODIGO_USUARIO`, `NOMBRE_USUARIO`, `TELEFONO`, `EMAIL`, `CARGO`, `DESCRIPCION`, `BLOQUEADO`, `CLAVE`, `INTENTOS_ACCESO_FALLIDOS`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `FECHA_ULTIMO_ACCESO`, `DIRECCION_ACCESO`, `DETALLE_ULTIMO_ACCESO`, `FECHA_CAMBIO_CLAVE`, `CODIGO_SUCURSAL`) VALUES('5', 'ADM', 'Administrador del Sistema', '78421829', 'siapa@gmail.com', 'Administrador del Sistema', NULL, 'N', 'e10adc3949ba59abbe56e057f20f883e', '0', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ss_usuarios` (`ID_USUARIO`, `CODIGO_USUARIO`, `NOMBRE_USUARIO`, `TELEFONO`, `EMAIL`, `CARGO`, `DESCRIPCION`, `BLOQUEADO`, `CLAVE`, `INTENTOS_ACCESO_FALLIDOS`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `FECHA_ULTIMO_ACCESO`, `DIRECCION_ACCESO`, `DETALLE_ULTIMO_ACCESO`, `FECHA_CAMBIO_CLAVE`, `CODIGO_SUCURSAL`) VALUES('6', 'ASC', 'Asociado', '78421829', 'siapa@gmail.com', 'Asociado', NULL, 'N', 'e10adc3949ba59abbe56e057f20f883e', '0', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ss_historico_claves`
--
ALTER TABLE `ss_historico_claves`
  ADD CONSTRAINT `FK_FK_SS_HIST_CLAVES_USUARIOS` FOREIGN KEY (`ID_USUARIO`) REFERENCES `ss_usuarios` (`ID_USUARIO`);

--
-- Filtros para la tabla `ss_menus`
--
ALTER TABLE `ss_menus`
  ADD CONSTRAINT `FK_FK_SS_MENUS_MENU_PADRE` FOREIGN KEY (`SS__ID_MENU`) REFERENCES `ss_menus` (`ID_MENU`);

--
-- Filtros para la tabla `ss_menus_opciones`
--
ALTER TABLE `ss_menus_opciones`
  ADD CONSTRAINT `FK_FK_SS_MENUS_OPCIONES` FOREIGN KEY (`ID_MENU`) REFERENCES `ss_menus` (`ID_MENU`),
  ADD CONSTRAINT `FK_FK_SS_OPCIONES_MENUS` FOREIGN KEY (`ID_OPCION`) REFERENCES `ss_opciones` (`ID_OPCION`);

--
-- Filtros para la tabla `ss_roles_menu`
--
ALTER TABLE `ss_roles_menu`
  ADD CONSTRAINT `FK_SS_ROLES_MENU` FOREIGN KEY (`ID_MENU`) REFERENCES `ss_menus` (`ID_MENU`),
  ADD CONSTRAINT `FK_SS_ROLES_MENU2` FOREIGN KEY (`ID_ROL`) REFERENCES `ss_roles` (`ID_ROL`);

--
-- Filtros para la tabla `ss_roles_opciones`
--
ALTER TABLE `ss_roles_opciones`
  ADD CONSTRAINT `FK_SS_ROLES_OPCIONES` FOREIGN KEY (`ID_ROL`) REFERENCES `ss_roles` (`ID_ROL`),
  ADD CONSTRAINT `FK_SS_ROLES_OPCIONES2` FOREIGN KEY (`ID_OPCION`) REFERENCES `ss_opciones` (`ID_OPCION`);

--
-- Filtros para la tabla `ss_roles_usuarios`
--
ALTER TABLE `ss_roles_usuarios`
  ADD CONSTRAINT `FK_SS_ROLES_USUARIOS` FOREIGN KEY (`ID_ROL`) REFERENCES `ss_roles` (`ID_ROL`),
  ADD CONSTRAINT `FK_SS_ROLES_USUARIOS2` FOREIGN KEY (`ID_USUARIO`) REFERENCES `ss_usuarios` (`ID_USUARIO`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
