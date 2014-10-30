
-----------------------------------------------------------------------------
--
--PRIMERA PARTE SIAPA
-----------------------------------------------------------------------------
-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-10-2014 a las 23:00:14
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

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

DROP TABLE IF EXISTS `alimento`;
CREATE TABLE IF NOT EXISTS `alimento` (
  `ID_ALIMENTO` decimal(18,0) NOT NULL,
  `ID_TIPO_ALIMENTO` decimal(18,0) DEFAULT NULL,
  `MARCA_ALIMENTO` varchar(50) DEFAULT NULL,
  `EXISTENCIA_ALIMENTO` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID_ALIMENTO`),
  KEY `FK_RELATIONSHIP_13` (`ID_TIPO_ALIMENTO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

DROP TABLE IF EXISTS `categorias`;
CREATE TABLE IF NOT EXISTS `categorias` (
  `ID_CATEGORIAS` decimal(18,0) NOT NULL,
  `NOMBRE_CATEGORIAS` varchar(50) NOT NULL,
  `DESCRIPCION_CATEGORIAS` varchar(500) NOT NULL,
  PRIMARY KEY (`ID_CATEGORIAS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `ID_CLIENTE` decimal(18,0) NOT NULL,
  `ID_CATEGORIAS` decimal(18,0) DEFAULT NULL,
  `ID_PERSONA` decimal(18,0) DEFAULT NULL,
  `NOMBRE_CLIENTE_COMP_VENTA` varchar(50) NOT NULL,
  `APELLIDOS_CLIENTE` varchar(50) DEFAULT NULL,
  `DIRECCION_CLIENTE` varchar(500) DEFAULT NULL,
  `TIPO_CLIENTE` varchar(1) NOT NULL,
  PRIMARY KEY (`ID_CLIENTE`),
  KEY `FK_RELATIONSHIP_22` (`ID_CATEGORIAS`),
  KEY `FK_RELATIONSHIP_25` (`ID_PERSONA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_contacto`
--

DROP TABLE IF EXISTS `cliente_contacto`;
CREATE TABLE IF NOT EXISTS `cliente_contacto` (
  `ID_CONTACTO` decimal(18,0) NOT NULL,
  `ID_PERSONA` decimal(18,0) NOT NULL,
  `VALOR_CLIENTE_CONTACTO` varchar(100) NOT NULL,
  `ACTIVO_CLIENTE_CONTACTO` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID_CONTACTO`,`ID_PERSONA`),
  KEY `FK_CLIENTE_CONTACTO2` (`ID_PERSONA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

DROP TABLE IF EXISTS `compra`;
CREATE TABLE IF NOT EXISTS `compra` (
  `ID_COMPRA` decimal(18,0) NOT NULL,
  `ID_PROVEEDOR` decimal(18,0) DEFAULT NULL,
  `FECHA_HORA_COMPRA` date NOT NULL,
  `USUARIO_COMPRA` varchar(30) NOT NULL,
  `TOTAL_COMPRA` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID_COMPRA`),
  KEY `FK_RELATIONSHIP_15` (`ID_PROVEEDOR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprobante_venta`
--

DROP TABLE IF EXISTS `comprobante_venta`;
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

DROP TABLE IF EXISTS `contacto`;
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

DROP TABLE IF EXISTS `descuento`;
CREATE TABLE IF NOT EXISTS `descuento` (
  `ID_DESCUENTO` decimal(18,0) NOT NULL,
  `ID_CATEGORIAS` decimal(18,0) DEFAULT NULL,
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

DROP TABLE IF EXISTS `detalle_compra_alimento`;
CREATE TABLE IF NOT EXISTS `detalle_compra_alimento` (
  `ID_DETALLE_COMPRA_ALIMENTO` decimal(18,0) NOT NULL,
  `ID_COMPRA` decimal(18,0) DEFAULT NULL,
  `ID_ALIMENTO` decimal(18,0) DEFAULT NULL,
  `CANT_DETALLE_COMPRA_ALIMENTO` decimal(10,2) NOT NULL,
  `PRECIO_DETALLE_COMPRA_ALIMENTO` decimal(10,2) NOT NULL,
  `IMPUESTO_DET_COMPRA_ALIMENTO` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID_DETALLE_COMPRA_ALIMENTO`),
  KEY `FK_RELATIONSHIP_12` (`ID_ALIMENTO`),
  KEY `FK_RELATIONSHIP_14` (`ID_COMPRA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_comprobante_venta`
--

DROP TABLE IF EXISTS `detalle_comprobante_venta`;
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

DROP TABLE IF EXISTS `detalle_muestreo`;
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

DROP TABLE IF EXISTS `detalle_venta`;
CREATE TABLE IF NOT EXISTS `detalle_venta` (
  `ID_DETALLE_VENTA` decimal(18,0) NOT NULL,
  `ID_PRODUCTO` decimal(18,0) DEFAULT NULL,
  `ID_JAULA` decimal(18,0) DEFAULT NULL,
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

DROP TABLE IF EXISTS `ingreso_producto`;
CREATE TABLE IF NOT EXISTS `ingreso_producto` (
  `ID_INGRESO_PRODUCTO` decimal(18,0) NOT NULL,
  `ID_PRODUCTO` decimal(18,0) DEFAULT NULL,
  `ID_JAULA` decimal(18,0) DEFAULT NULL,
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

DROP TABLE IF EXISTS `jaula`;
CREATE TABLE IF NOT EXISTS `jaula` (
  `ID_JAULA` decimal(18,0) NOT NULL,
  `ID_TIPO_JAULA` decimal(18,0) DEFAULT NULL,
  `NOMBRE_JAULA` varchar(50) NOT NULL,
  `DESCRIPCION_JAULA` varchar(500) DEFAULT NULL,
  `LISTA_VENTA_JAULA` tinyint(1) DEFAULT NULL,
  `FECHA_VENTA_JAULA` date NOT NULL,
  `FECHA_SIEMBRA_JAULA` date NOT NULL,
  `VENTA_JAULA` decimal(8,0) NOT NULL,
  PRIMARY KEY (`ID_JAULA`),
  KEY `FK_RELATIONSHIP_7` (`ID_TIPO_JAULA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `muestreo`
--

DROP TABLE IF EXISTS `muestreo`;
CREATE TABLE IF NOT EXISTS `muestreo` (
  `ID_MUESTREO` decimal(18,0) NOT NULL,
  `ID_JAULA` decimal(18,0) DEFAULT NULL,
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

DROP TABLE IF EXISTS `persona`;
CREATE TABLE IF NOT EXISTS `persona` (
  `ID_PERSONA` decimal(18,0) NOT NULL,
  `NOMBRE_PERSONA` varchar(50) NOT NULL,
  `DIRECCION_PERSONA` varchar(500) DEFAULT NULL,
  `NRC_PERSONA` varchar(14) DEFAULT NULL,
  `NIT_PERSONA` varchar(17) DEFAULT NULL,
  `DUI_PERSONA` varchar(14) DEFAULT NULL,
  `TIPO_PERSONA` varchar(1) NOT NULL,
  PRIMARY KEY (`ID_PERSONA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
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

DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE IF NOT EXISTS `proveedor` (
  `ID_PROVEEDOR` decimal(18,0) NOT NULL,
  `ID_PERSONA` decimal(18,0) DEFAULT NULL,
  `FECHA_PROVEEDOR` date NOT NULL,
  `USUARIO_PROVEEDOR` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_PROVEEDOR`),
  KEY `FK_RELATIONSHIP_26` (`ID_PERSONA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro_alimentacion`
--

DROP TABLE IF EXISTS `registro_alimentacion`;
CREATE TABLE IF NOT EXISTS `registro_alimentacion` (
  `ID_REGISTRO_ALIMENTACION` decimal(18,0) NOT NULL,
  `ID_ALIMENTO` decimal(18,0) DEFAULT NULL,
  `ID_JAULA` decimal(18,0) DEFAULT NULL,
  `CANTIDAD_REGISTRO_ALIMENTACION` decimal(10,2) NOT NULL,
  `FECHA_HORA_REG_ALIMENTACION` date NOT NULL,
  `USUARIO_REGISTRO_ALIMENTACION` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_REGISTRO_ALIMENTACION`),
  KEY `FK_RELATIONSHIP_11` (`ID_ALIMENTO`),
  KEY `FK_RELATIONSHIP_16` (`ID_JAULA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro_mortalidad`
--

DROP TABLE IF EXISTS `registro_mortalidad`;
CREATE TABLE IF NOT EXISTS `registro_mortalidad` (
  `ID_REGISTRO_MORTALIDAD` decimal(18,0) NOT NULL,
  `ID_JAULA` decimal(18,0) DEFAULT NULL,
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

DROP TABLE IF EXISTS `tipo_alimento`;
CREATE TABLE IF NOT EXISTS `tipo_alimento` (
  `ID_TIPO_ALIMENTO` decimal(18,0) NOT NULL,
  `NOMBRE_TIPO_ALIMENTO` varchar(50) NOT NULL,
  `DESCRICION_TIPO_ALIMENTO` varchar(500) DEFAULT NULL,
  `PORCE_PROTEINA_TIPO_ALIMENTO` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID_TIPO_ALIMENTO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_comprobante`
--

DROP TABLE IF EXISTS `tipo_comprobante`;
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

DROP TABLE IF EXISTS `tipo_jaula`;
CREATE TABLE IF NOT EXISTS `tipo_jaula` (
  `ID_TIPO_JAULA` decimal(18,0) NOT NULL,
  `NOMBRE_TIPO_JAULA` varchar(50) NOT NULL,
  `DESCRIPCION_TIPO_JAULA` varchar(500) DEFAULT NULL,
  `ANCHO_TIPO_JAULA` decimal(10,2) NOT NULL,
  `LARGO_TIPO_JAULA` decimal(10,2) NOT NULL,
  `PROFUNDIDAD_TIPO_JAULA` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID_TIPO_JAULA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `traslados`
--

DROP TABLE IF EXISTS `traslados`;
CREATE TABLE IF NOT EXISTS `traslados` (
  `ID_TRASLADOS` decimal(18,0) NOT NULL,
  `ID_JAULA` decimal(18,0) DEFAULT NULL,
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

DROP TABLE IF EXISTS `venta`;
CREATE TABLE IF NOT EXISTS `venta` (
  `ID_VENTA` decimal(18,0) NOT NULL,
  `ID_CLIENTE` decimal(18,0) DEFAULT NULL,
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
  ADD CONSTRAINT `FK_RELATIONSHIP_13` FOREIGN KEY (`ID_TIPO_ALIMENTO`) REFERENCES `tipo_alimento` (`ID_TIPO_ALIMENTO`);

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `FK_RELATIONSHIP_22` FOREIGN KEY (`ID_CATEGORIAS`) REFERENCES `categorias` (`ID_CATEGORIAS`),
  ADD CONSTRAINT `FK_RELATIONSHIP_25` FOREIGN KEY (`ID_PERSONA`) REFERENCES `persona` (`ID_PERSONA`);

--
-- Filtros para la tabla `cliente_contacto`
--
ALTER TABLE `cliente_contacto`
  ADD CONSTRAINT `FK_CLIENTE_CONTACTO` FOREIGN KEY (`ID_CONTACTO`) REFERENCES `contacto` (`ID_CONTACTO`),
  ADD CONSTRAINT `FK_CLIENTE_CONTACTO2` FOREIGN KEY (`ID_PERSONA`) REFERENCES `persona` (`ID_PERSONA`);

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `FK_RELATIONSHIP_15` FOREIGN KEY (`ID_PROVEEDOR`) REFERENCES `proveedor` (`ID_PROVEEDOR`);

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
  ADD CONSTRAINT `FK_RELATIONSHIP_19` FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `producto` (`ID_PRODUCTO`),
  ADD CONSTRAINT `FK_RELATIONSHIP_20` FOREIGN KEY (`ID_CATEGORIAS`) REFERENCES `categorias` (`ID_CATEGORIAS`);

--
-- Filtros para la tabla `detalle_compra_alimento`
--
ALTER TABLE `detalle_compra_alimento`
  ADD CONSTRAINT `FK_RELATIONSHIP_12` FOREIGN KEY (`ID_ALIMENTO`) REFERENCES `alimento` (`ID_ALIMENTO`),
  ADD CONSTRAINT `FK_RELATIONSHIP_14` FOREIGN KEY (`ID_COMPRA`) REFERENCES `compra` (`ID_COMPRA`);

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
  ADD CONSTRAINT `FK_RELATIONSHIP_17` FOREIGN KEY (`ID_JAULA`) REFERENCES `jaula` (`ID_JAULA`),
  ADD CONSTRAINT `FK_RELATIONSHIP_18` FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `producto` (`ID_PRODUCTO`),
  ADD CONSTRAINT `FK_RELATIONSHIP_21` FOREIGN KEY (`ID_VENTA`) REFERENCES `venta` (`ID_VENTA`);

--
-- Filtros para la tabla `ingreso_producto`
--
ALTER TABLE `ingreso_producto`
  ADD CONSTRAINT `FK_RELATIONSHIP_24` FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `producto` (`ID_PRODUCTO`),
  ADD CONSTRAINT `FK_RELATIONSHIP_6` FOREIGN KEY (`ID_JAULA`) REFERENCES `jaula` (`ID_JAULA`);

--
-- Filtros para la tabla `jaula`
--
ALTER TABLE `jaula`
  ADD CONSTRAINT `FK_RELATIONSHIP_7` FOREIGN KEY (`ID_TIPO_JAULA`) REFERENCES `tipo_jaula` (`ID_TIPO_JAULA`);

--
-- Filtros para la tabla `muestreo`
--
ALTER TABLE `muestreo`
  ADD CONSTRAINT `FK_RELATIONSHIP_8` FOREIGN KEY (`ID_JAULA`) REFERENCES `jaula` (`ID_JAULA`);

--
-- Filtros para la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD CONSTRAINT `FK_RELATIONSHIP_26` FOREIGN KEY (`ID_PERSONA`) REFERENCES `persona` (`ID_PERSONA`);

--
-- Filtros para la tabla `registro_alimentacion`
--
ALTER TABLE `registro_alimentacion`
  ADD CONSTRAINT `FK_RELATIONSHIP_11` FOREIGN KEY (`ID_ALIMENTO`) REFERENCES `alimento` (`ID_ALIMENTO`),
  ADD CONSTRAINT `FK_RELATIONSHIP_16` FOREIGN KEY (`ID_JAULA`) REFERENCES `jaula` (`ID_JAULA`);

--
-- Filtros para la tabla `registro_mortalidad`
--
ALTER TABLE `registro_mortalidad`
  ADD CONSTRAINT `FK_RELATIONSHIP_10` FOREIGN KEY (`ID_JAULA`) REFERENCES `jaula` (`ID_JAULA`);

--
-- Filtros para la tabla `traslados`
--
ALTER TABLE `traslados`
  ADD CONSTRAINT `FK_RELATIONSHIP_5` FOREIGN KEY (`ID_JAULA`) REFERENCES `jaula` (`ID_JAULA`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `FK_RELATIONSHIP_23` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `cliente` (`ID_CLIENTE`),
  ADD CONSTRAINT `FK_RELATIONSHIP_4` FOREIGN KEY (`ID_COMPROBANTE_VENTA`) REFERENCES `comprobante_venta` (`ID_COMPROBANTE_VENTA`);

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
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-10-2014 a las 23:03:57
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

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

DROP TABLE IF EXISTS `ss_historico_claves`;
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

DROP TABLE IF EXISTS `ss_menus`;
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

INSERT INTO `ss_menus` (`ID_MENU`, `SS__ID_MENU`, `NOMBRE_MENU`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`) VALUES
('1', NULL, 'Ventas', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL),
('2', NULL, 'Clientes', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL),
('3', NULL, 'Administrar Producto', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL),
('4', NULL, 'Jaulas', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL),
('5', NULL, 'Alimento', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL),
('6', NULL, 'Reportes', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL),
('7', NULL, 'Configuracion', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL),
('8', NULL, 'Producto', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ss_menus_opciones`
--

DROP TABLE IF EXISTS `ss_menus_opciones`;
CREATE TABLE IF NOT EXISTS `ss_menus_opciones` (
  `ID_MENU` decimal(9,0) NOT NULL COMMENT 'Correlativo que identifica al menú.',
  `ID_OPCION` decimal(9,0) NOT NULL COMMENT 'Correlativo que identifica a la opción.',
  PRIMARY KEY (`ID_MENU`,`ID_OPCION`),
  KEY `FK_FK_SS_OPCIONES_MENUS` (`ID_OPCION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contiene la relacion n:n entre menus y opciones (de menú).';

--
-- Volcado de datos para la tabla `ss_menus_opciones`
--

INSERT INTO `ss_menus_opciones` (`ID_MENU`, `ID_OPCION`) VALUES
('1', '2'),
('1', '3'),
('2', '4'),
('3', '5'),
('3', '6'),
('3', '7'),
('3', '8'),
('3', '9'),
('4', '10'),
('5', '11'),
('5', '12'),
('8', '13');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ss_opciones`
--

DROP TABLE IF EXISTS `ss_opciones`;
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

INSERT INTO `ss_opciones` (`ID_OPCION`, `NOMBRE_OPCION`, `URL`, `VISIBLE`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `IMAGEN_OPCION`) VALUES
('1', 'Home', '/siapa/views/index.xhtml', '1', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL),
('2', 'Gestion de Ventas', '/siapa/views/index.xhtml', '1', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL),
('3', 'Ingresar Cliente', '/siapa/views/index.xhtml', '1', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL),
('4', 'Gestion de Clientes', '/siapa/views/index.xhtml', '1', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL),
('5', 'Ingreso Peces Muertos', '/siapa/views/index.xhtml', '1', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL),
('6', 'Ingreso de Muestreo', '/siapa/views/index.xhtml', '1', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL),
('7', 'Ingreso Alimento a Jaula', '/siapa/views/index.xhtml', '1', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL),
('8', 'Gestion de Compra de Peces', '/siapa/views/index.xhtml', '1', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL),
('9', 'Movimiento Entre Jaulas', '/siapa/views/index.xhtml', '1', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL),
('10', 'Gestion de Jaulas', '/siapa/views/index.xhtml', '1', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL),
('11', 'Gestion de Alimento', '/siapa/views/index.xhtml', '1', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL),
('12', 'Compra de Alimento', '/siapa/views/index.xhtml', '1', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL),
('13', 'Gestionar Producto', '/siapa/views/index.xhtml', '1', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ss_roles`
--

DROP TABLE IF EXISTS `ss_roles`;
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

INSERT INTO `ss_roles` (`ID_ROL`, `CODIGO_ROL`, `NOMBRE_ROL`, `DESCRIPCION`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`) VALUES
('1', 'EOP', 'Encargado Operativo', 'Posee privilegios ..', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL),
('2', 'EAD', 'Encargado Administrativo', 'Posee Privilegios de ...', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL),
('3', 'VEN', 'Vendedor', 'Encargado de registrar las ventas ', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL),
('4', 'OPE', 'Operario', 'Encargado de Realizar ...', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL),
('5', 'ADM', 'Administrador del Sistema', 'Tiene todos los provilegios de gestion de usuario y otras tareas de adminitracion del sistema', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL),
('6', 'ASC', 'Asociado', 'puede ver los reportes que se generan desde el sistema', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ss_roles_menu`
--

DROP TABLE IF EXISTS `ss_roles_menu`;
CREATE TABLE IF NOT EXISTS `ss_roles_menu` (
  `ID_MENU` decimal(9,0) NOT NULL COMMENT 'Correlativo que identifica al menú.',
  `ID_ROL` decimal(9,0) NOT NULL COMMENT 'Identificador único del rol',
  PRIMARY KEY (`ID_MENU`,`ID_ROL`),
  KEY `FK_SS_ROLES_MENU2` (`ID_ROL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contiene la relacion n:n entre roles y menus';

--
-- Volcado de datos para la tabla `ss_roles_menu`
--

INSERT INTO `ss_roles_menu` (`ID_MENU`, `ID_ROL`) VALUES
('3', '1'),
('4', '1'),
('5', '1'),
('6', '1'),
('1', '2'),
('2', '2'),
('3', '2'),
('4', '2'),
('7', '2'),
('1', '3'),
('8', '3'),
('3', '4'),
('7', '5'),
('2', '6'),
('6', '6');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ss_roles_opciones`
--

DROP TABLE IF EXISTS `ss_roles_opciones`;
CREATE TABLE IF NOT EXISTS `ss_roles_opciones` (
  `ID_ROL` decimal(9,0) NOT NULL COMMENT 'Identificador único del rol',
  `ID_OPCION` decimal(9,0) NOT NULL COMMENT 'Correlativo que identifica a la opción.',
  PRIMARY KEY (`ID_ROL`,`ID_OPCION`),
  KEY `FK_SS_ROLES_OPCIONES2` (`ID_OPCION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ss_roles_opciones`
--

INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES
('1', '1'),
('2', '1'),
('3', '1'),
('4', '1'),
('5', '1'),
('6', '1'),
('2', '2'),
('3', '2'),
('2', '3'),
('3', '3'),
('2', '4'),
('6', '4'),
('4', '5'),
('1', '6'),
('4', '7'),
('1', '8'),
('2', '8'),
('1', '9'),
('1', '10'),
('2', '10'),
('1', '11'),
('1', '12'),
('3', '13');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ss_roles_usuarios`
--

DROP TABLE IF EXISTS `ss_roles_usuarios`;
CREATE TABLE IF NOT EXISTS `ss_roles_usuarios` (
  `ID_ROL` decimal(9,0) NOT NULL COMMENT 'Identificador único del rol',
  `ID_USUARIO` decimal(9,0) NOT NULL,
  PRIMARY KEY (`ID_ROL`,`ID_USUARIO`),
  KEY `FK_SS_ROLES_USUARIOS2` (`ID_USUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contiene la relación n:n entre roles y usuarios';

--
-- Volcado de datos para la tabla `ss_roles_usuarios`
--

INSERT INTO `ss_roles_usuarios` (`ID_ROL`, `ID_USUARIO`) VALUES
('1', '1'),
('2', '2'),
('3', '3'),
('4', '4'),
('5', '5'),
('6', '6');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ss_usuarios`
--

DROP TABLE IF EXISTS `ss_usuarios`;
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

INSERT INTO `ss_usuarios` (`ID_USUARIO`, `CODIGO_USUARIO`, `NOMBRE_USUARIO`, `TELEFONO`, `EMAIL`, `CARGO`, `DESCRIPCION`, `BLOQUEADO`, `CLAVE`, `INTENTOS_ACCESO_FALLIDOS`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `FECHA_ULTIMO_ACCESO`, `DIRECCION_ACCESO`, `DETALLE_ULTIMO_ACCESO`, `FECHA_CAMBIO_CLAVE`, `CODIGO_SUCURSAL`) VALUES
('1', 'EOP', 'Encargado Operativo', '78421829', 'siapa@gmail.com', 'Encargado Operativo', NULL, 'N', 'e10adc3949ba59abbe56e057f20f883e', '0', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('2', 'EAD', 'Encargado Administrativo', '78421829', 'siapa@gmail.com', 'Encargado Administrativo', NULL, 'N', 'e10adc3949ba59abbe56e057f20f883e', '0', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('3', 'VEN', 'Vendedor', '78421829', 'siapa@gmail.com', 'Vendedor', NULL, 'N', 'e10adc3949ba59abbe56e057f20f883e', '0', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('4', 'OPE', 'Operario', '78421829', 'siapa@gmail.com', 'Operario', NULL, 'N', 'e10adc3949ba59abbe56e057f20f883e', '0', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('5', 'ADM', 'Administrador del Sistema', '78421829', 'siapa@gmail.com', 'Administrador del Sistema', NULL, 'N', 'e10adc3949ba59abbe56e057f20f883e', '0', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('6', 'ASC', 'Asociado', '78421829', 'siapa@gmail.com', 'Asociado', NULL, 'N', 'e10adc3949ba59abbe56e057f20f883e', '0', 'desarrollo', '2014-10-30 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

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
