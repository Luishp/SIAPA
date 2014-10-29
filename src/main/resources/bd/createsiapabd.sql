-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-10-2014 a las 00:44:52
-- Versión del servidor: 5.5.32
-- Versión de PHP: 5.4.19

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

INSERT INTO `ss_menus` (`ID_MENU`, `SS__ID_MENU`, `NOMBRE_MENU`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`) VALUES
('1', NULL, 'Configuracion Inicial', 'desarrollo', '2013-12-01 08:00:00', NULL, NULL),
('2', NULL, 'Asesoria de Credito', 'desarrollo', '2013-12-01 08:00:00', NULL, NULL),
('3', NULL, 'solicitud de Credito', 'desarrollo', '2013-12-01 08:00:00', NULL, NULL),
('4', NULL, 'Analisis de Credito', 'desarrollo', '2013-12-01 08:00:00', NULL, NULL),
('5', NULL, 'Resolucion de Credito', 'desarrollo', '2013-12-01 08:00:00', NULL, NULL),
('6', NULL, 'Desembolso de Credito', 'desarrollo', '2013-12-01 08:00:00', NULL, NULL),
('7', NULL, 'Caja', 'desarrollo', '2013-12-01 08:00:00', NULL, NULL),
('8', NULL, 'Reportes', 'desarrollo', '2013-12-01 08:00:00', NULL, NULL),
('9', '1', 'Gestionar Sucursal', 'desarrollo', '2013-12-01 08:00:00', NULL, NULL),
('10', '1', 'Gestionar Usuario', 'desarrollo', '2013-12-01 08:00:00', NULL, NULL),
('11', '1', 'Gestionar Caja', 'desarrollo', '2013-12-01 08:00:00', NULL, NULL),
('12', '1', 'Gestionar Banco', 'desarrollo', '2013-12-01 08:00:00', NULL, NULL),
('13', '1', 'Gestionar Pagaduria', 'desarrollo', '2013-12-01 08:00:00', NULL, NULL),
('14', '1', 'Gestionar Catalogo Garantias', '\r\ndesarrollo', '2013-12-01 08:00:00', NULL, NULL),
('15', '1', 'Gestinar Linea de Credito', 'desarrollo', '2013-12-01 08:00:00', NULL, NULL),
('16', '1', 'Gestionar Promociones', 'desarrollo', '2013-12-01 08:00:00', NULL, NULL),
('17', '1', 'Contabilidad', 'desarrollo', '2013-12-01 08:00:00', NULL, NULL);

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

INSERT INTO `ss_menus_opciones` (`ID_MENU`, `ID_OPCION`) VALUES
('1', '2'),
('1', '6'),
('1', '10'),
('1', '14'),
('1', '18'),
('1', '22'),
('1', '26'),
('1', '30'),
('1', '34'),
('3', '35'),
('3', '36'),
('3', '37'),
('3', '38'),
('2', '39'),
('4', '40'),
('5', '41'),
('5', '42'),
('5', '43'),
('6', '44'),
('6', '45'),
('6', '46'),
('8', '47'),
('8', '48'),
('8', '49'),
('8', '50'),
('8', '51'),
('8', '52'),
('8', '53'),
('8', '54'),
('8', '55'),
('4', '56'),
('3', '57'),
('4', '58'),
('8', '59'),
('6', '60'),
('7', '61'),
('7', '62'),
('4', '63');

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

INSERT INTO `ss_opciones` (`ID_OPCION`, `NOMBRE_OPCION`, `URL`, `VISIBLE`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `IMAGEN_OPCION`) VALUES
('0', '', NULL, 'N', NULL, NULL, NULL, NULL, ''),
('1', 'Home', '/siacofinges/views/index.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:40', NULL, NULL, 'home.png'),
('2', 'Sucursal', '/siacofinges/views/configuracionInicial/sucursal/index.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:37', NULL, NULL, NULL),
('6', 'Usuarios', '/siacofinges/views/configuracionInicial/usuario/index.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:37', NULL, NULL, NULL),
('10', 'Cajas', '/siacofinges/views/configuracionInicial/caja/index.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:37', NULL, NULL, 'caja.png'),
('14', 'Bancos', '/siacofinges/views/configuracionInicial/banco/index.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:37', NULL, NULL, 'bank.png'),
('18', 'Pagaduria', '/siacofinges/views/configuracionInicial/pagaduria/index.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:37', NULL, NULL, NULL),
('22', 'Catalogo Garantía', '/siacofinges/views/configuracionInicial/catalogoGarantias/index.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:37', NULL, NULL, NULL),
('26', 'Linea Crédito', '/siacofinges/views/configuracionInicial/lineaCredito/index.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:37', NULL, NULL, NULL),
('30', 'Promociones', '/siacofinges/views/configuracionInicial/promocion/index.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:37', NULL, NULL, 'discount.png'),
('34', 'parametrizacionCuentas', '/siacofinges/views/configuracionInicial/contabilidad/index.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:17', NULL, NULL, NULL),
('35', 'Registrar Solicitud de Crédito', '/siacofinges/views/solicitud/crear.xhtml', 'N', 'desarrollo', '2013-12-01 08:00:38', NULL, NULL, NULL),
('36', 'Consultar Solicitud de Crédito', '/siacofinges/views/solicitud/index.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:36', NULL, NULL, 'solicitud.png'),
('37', 'Modificar', '/siacofinges/views/solicitud/modificar.xhtml', 'N', 'desarrollo', '2013-12-01 08:00:37', NULL, NULL, NULL),
('38', 'Formulario', '/siacofinges/views/solicitud/form.xhtml', 'N', 'desarrollo', '2013-12-01 08:00:37', NULL, NULL, NULL),
('39', 'Registrar Asesoria de Crédito', '/siacofinges/views/asesoria/index.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:37', '', NULL, 'asesoria.png'),
('40', 'Enviar analisis a Resolicion', '/siacofinges/views/analisis/envioAnalisis/enviodeanalisis.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:37', NULL, NULL, NULL),
('41', 'Agenda Comite de Creditos', '/siacofinges/views/resoluciondecredito/agendacomite/index.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:37', NULL, NULL, 'comite.png'),
('42', 'Ingresar Resolucion de Crédito', '/siacofinges/views/resoluciondecredito/ingresaresolucion/index.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:37', NULL, NULL, NULL),
('43', 'Modificar Resolucion de Crédito', '/siacofinges/views/resoluciondecredito/modificaresolucion/index.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:37', NULL, NULL, NULL),
('44', 'Ingresar desembolso', '/siacofinges/views/desembolso/ingresardesembolso/index.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:37', NULL, NULL, NULL),
('45', 'Modificar desembolso', '/siacofinges/views/desembolso/modificardesembolso/index.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:37', NULL, NULL, NULL),
('46', 'Aplicar desembolso', '/siacofinges/views/desembolso/aplicardesembolso/index.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:37', NULL, NULL, NULL),
('47', 'Generar acta de comite de Crédito', '/siacofinges/views/reportes/resolucionCredito/generaractascomite/index.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:37', NULL, NULL, NULL),
('48', 'Solicitudes de creditos con resolucion aprobada', '/siacofinges/views/reportes/analisisCredito/resolucionesaprobadas/index.xhtml', 'S', 'desarrollo', '2014-05-04 08:00:37', NULL, NULL, NULL),
('49', 'Desembolso', '/siacofinges/views/reportes/desembolso/index.xhtml', 'S', 'desarrollo', '2014-05-04 08:00:37', NULL, NULL, NULL),
('50', 'Generar Informe Gerencial', '/siacofinges/views/reportes/analisisCredito/informeGerencial/index.xhtml', 'S', 'desarrollo', '2014-05-04 08:00:37', NULL, NULL, NULL),
('51', 'Generar estado de cuenta', '/siacofinges/views/reportes/prestamo/prestamosVigentes/index.xhtml', 'S', 'desarrollo', '2014-05-04 08:00:37', NULL, NULL, NULL),
('52', 'Generar Tabla Teórica de Amortización', '/siacofinges/views/reportes/prestamo/tablaAmortizacion/index.xhtml', 'S', 'desarrollo', '2014-05-04 08:00:37', NULL, NULL, NULL),
('53', 'Generar Historial Crediticio', '/siacofinges/views/reportes/analisisCredito/historialCrediticio/index.xhtml', 'S', 'desarrollo', '2014-05-04 08:00:37', NULL, NULL, NULL),
('54', 'Generar Reporte de Recuperacion e Ingresos por Prestamo', '/siacofinges/views/reportes/prestamo/recuperacionPrestamo/index.xhtml', 'S', 'desarrollo', '2014-05-04 08:00:37', NULL, NULL, NULL),
('55', 'Generar Reporte de fechas de pagos de Prestamo', '/siacofinges/views/reportes/prestamo/fechaPago/index.xhtml', 'S', 'desarrollo', '2014-05-04 08:00:37', NULL, NULL, NULL),
('56', 'Registrar Analisis de Crédito', '/siacofinges/views/analisis/index.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:37', '', NULL, NULL),
('57', 'Modificar Solicitud de Crédito', '/siacofinges/views/solicitud/solicitudEdit.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:37', NULL, NULL, NULL),
('58', 'Asignar Garantias', '/siacofinges/views/garantia/index.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:37', NULL, NULL, NULL),
('59', 'Generar Informe Gerencial', '/siacofinges/views/reportes/resolucionCredito/generarInformeGerencial/index.xhtml', 'S', 'desarrollo', '2014-07-05 00:00:00', NULL, NULL, NULL),
('60', 'Emitir Cheque', '/siacofinges/views/desembolso/emitircheque/index.xhtml', 'S', 'desarrollo', '2014-07-20 00:00:00', NULL, NULL, NULL),
('61', 'Desembolso de Efectivo', '/siacofinges/views/caja/desembolsodeefectivo/index.xhtml', 'S', 'desarrollo', '2014-07-20 00:00:00', NULL, NULL, NULL),
('62', 'Registrar Pago de Prestamo', '/siacofinges/views/caja/pagodeprestamo/index.xhtml', 'S', 'desarrollo', '2014-07-20 00:00:00', NULL, NULL, NULL),
('63', 'Modificar Analisis de Crédito', '/siacofinges/views/analisis/analisisEdit.xhtml', 'S', 'desarrollo', '2013-12-01 08:00:37', NULL, NULL, NULL);

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

INSERT INTO `ss_roles` (`ID_ROL`, `CODIGO_ROL`, `NOMBRE_ROL`, `DESCRIPCION`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`) VALUES
('1', 'admin', 'Administrador del sistema', 'Tiene todos los privilegios de gestion de usuarios y otras tareas de administracion del sistema.', 'desarrollo', '2013-12-01 08:00:00', NULL, NULL),
('2', 'jefop', 'Jefe de Operaciones.', 'Posee privilegios de nivel gerencial, puede aprobar solicitudes de credito y generar reportes.', 'desarrollo', '2013-12-01 08:00:01', NULL, NULL),
('3', 'ejmer', 'Ejecutivo de Mercadeo.', 'Posee privilegios de asesoria y solicitud de credito.', 'desarrollo', '2013-12-01 08:00:02', NULL, NULL),
('4', 'conta', 'Contador', 'Posee privilegios de configuracion de cuentas contables y otras funciones contables.', 'desarrollo', '2013-12-01 08:00:03', NULL, NULL),
('5', 'anlst', 'Analista de créditos ', 'Posee privilegios para elaborar analisis de creditos y generar documentos previos a la evalucion de la solicitud de credito', 'desarrollo', '2013-12-01 08:00:04', NULL, NULL),
('6', 'grent', 'Gerente', 'Posee privilegios de nivel gerencial, puede aprobar solicitudes de credito y generar reportes.', 'desarrollo', '2013-12-01 08:00:05', NULL, NULL),
('7', 'scret', 'Secretario CC', 'Encargado de emitir resoluciones de credito.', 'desarrollo', '2013-12-01 08:00:06', NULL, NULL),
('8', 'cajro', 'Cajero', 'Posee privilegios para registrar transacciones del modulo de caja', 'desarrollo', '2013-12-01 08:00:07', NULL, NULL),
('9', 'auxcn', 'Auxiliar Contable', 'Posee privilegios para efectuar desembolsos', 'desarrollo', '2013-12-01 08:00:08', NULL, NULL);

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

INSERT INTO `ss_roles_menu` (`ID_MENU`, `ID_ROL`) VALUES
('1', '1'),
('1', '2'),
('8', '2'),
('2', '3'),
('3', '3'),
('4', '5'),
('6', '5'),
('8', '5'),
('8', '6'),
('5', '7'),
('8', '7'),
('7', '8'),
('8', '8'),
('1', '9'),
('6', '9'),
('8', '9');

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

INSERT INTO `ss_roles_opciones` (`ID_ROL`, `ID_OPCION`) VALUES
('1', '1'),
('2', '1'),
('3', '1'),
('5', '1'),
('6', '1'),
('7', '1'),
('8', '1'),
('9', '1'),
('2', '2'),
('1', '6'),
('2', '10'),
('2', '14'),
('2', '18'),
('2', '22'),
('2', '26'),
('2', '30'),
('9', '34'),
('3', '35'),
('3', '36'),
('3', '37'),
('3', '38'),
('3', '39'),
('5', '40'),
('7', '41'),
('7', '42'),
('7', '43'),
('5', '44'),
('5', '45'),
('9', '46'),
('7', '47'),
('5', '48'),
('9', '49'),
('5', '50'),
('9', '51'),
('8', '52'),
('2', '53'),
('5', '53'),
('6', '53'),
('2', '54'),
('6', '54'),
('2', '55'),
('6', '55'),
('5', '56'),
('3', '57'),
('5', '58'),
('7', '59'),
('9', '60'),
('8', '61'),
('8', '62'),
('5', '63');

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

INSERT INTO `ss_roles_usuarios` (`ID_ROL`, `ID_USUARIO`) VALUES
('1', '1'),
('2', '2'),
('3', '3'),
('5', '5'),
('6', '6'),
('7', '7'),
('8', '8'),
('9', '9');

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

INSERT INTO `ss_usuarios` (`ID_USUARIO`, `CODIGO_USUARIO`, `NOMBRE_USUARIO`, `TELEFONO`, `EMAIL`, `CARGO`, `DESCRIPCION`, `BLOQUEADO`, `CLAVE`, `INTENTOS_ACCESO_FALLIDOS`, `USUARIO_REGISTRO`, `FECHA_REGISTRO`, `USUARIO_ULTIMAMODIFICACION`, `FECHA_ULTIMAMODIFICACION`, `FECHA_ULTIMO_ACCESO`, `DIRECCION_ACCESO`, `DETALLE_ULTIMO_ACCESO`, `FECHA_CAMBIO_CLAVE`, `CODIGO_SUCURSAL`) VALUES
('1', 'admin', 'Administrador del sistema', '78421829', NULL, 'Administrador del sistema.', NULL, 'N', 'e10adc3949ba59abbe56e057f20f883e', '0', 'desarrollo', '2013-12-01 08:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('2', 'jefop', 'Jefe de Operaciones', '78439305', NULL, 'Jefe de Operaciones.', NULL, 'N', 'e10adc3949ba59abbe56e057f20f883e', '0', 'desarrollo', '2013-12-01 08:00:01', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('3', 'ejmer', 'Ejecutivo de Mercadeo', '78439305', NULL, 'Ejecutivo de Mercadeo', NULL, 'N', 'e10adc3949ba59abbe56e057f20f883e', '0', 'desarrollo', '2013-12-01 08:00:01', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('5', 'anlst', 'Analista de creditos', '78439305', NULL, 'Analista de creditos', NULL, 'N', 'e10adc3949ba59abbe56e057f20f883e', '0', 'desarrollo', '2013-12-01 08:00:01', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('6', 'grent', 'Gerente', '74718921', NULL, 'Gerente.', NULL, 'N', 'e10adc3949ba59abbe56e057f20f883e', '0', 'desarrollo', '2013-12-01 08:00:17', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('7', 'scret', 'Secretario CC', '78718921', NULL, 'Secretario CC', NULL, 'N', 'e10adc3949ba59abbe56e057f20f883e', '0', 'desarrollo', '2013-12-01 08:00:17', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('8', 'cajro', 'Cajero', '78718941', NULL, 'Cajero', NULL, 'N', 'e10adc3949ba59abbe56e057f20f883e', '0', 'desarrollo', '2013-12-01 08:00:17', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('9', 'auxcn', 'Auxiliar Contable', '78718921', NULL, 'Auxiliar Contable.', NULL, 'N', 'e10adc3949ba59abbe56e057f20f883e', '0', 'desarrollo', '2013-12-01 08:00:17', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_alimento`
--

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
  ADD CONSTRAINT `FK_RELATIONSHIP_25` FOREIGN KEY (`ID_PERSONA`) REFERENCES `persona` (`ID_PERSONA`),
  ADD CONSTRAINT `FK_RELATIONSHIP_22` FOREIGN KEY (`ID_CATEGORIAS`) REFERENCES `categorias` (`ID_CATEGORIAS`);

--
-- Filtros para la tabla `cliente_contacto`
--
ALTER TABLE `cliente_contacto`
  ADD CONSTRAINT `FK_CLIENTE_CONTACTO2` FOREIGN KEY (`ID_PERSONA`) REFERENCES `persona` (`ID_PERSONA`),
  ADD CONSTRAINT `FK_CLIENTE_CONTACTO` FOREIGN KEY (`ID_CONTACTO`) REFERENCES `contacto` (`ID_CONTACTO`);

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `FK_RELATIONSHIP_15` FOREIGN KEY (`ID_PROVEEDOR`) REFERENCES `proveedor` (`ID_PROVEEDOR`);

--
-- Filtros para la tabla `comprobante_venta`
--
ALTER TABLE `comprobante_venta`
  ADD CONSTRAINT `FK_RELATIONSHIP_3` FOREIGN KEY (`ID_VENTA`) REFERENCES `venta` (`ID_VENTA`),
  ADD CONSTRAINT `FK_RELATIONSHIP_1` FOREIGN KEY (`ID_TIPO_COMPROBANTE`) REFERENCES `tipo_comprobante` (`ID_TIPO_COMPROBANTE`);

--
-- Filtros para la tabla `descuento`
--
ALTER TABLE `descuento`
  ADD CONSTRAINT `FK_RELATIONSHIP_20` FOREIGN KEY (`ID_CATEGORIAS`) REFERENCES `categorias` (`ID_CATEGORIAS`),
  ADD CONSTRAINT `FK_RELATIONSHIP_19` FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `producto` (`ID_PRODUCTO`);

--
-- Filtros para la tabla `detalle_compra_alimento`
--
ALTER TABLE `detalle_compra_alimento`
  ADD CONSTRAINT `FK_RELATIONSHIP_14` FOREIGN KEY (`ID_COMPRA`) REFERENCES `compra` (`ID_COMPRA`),
  ADD CONSTRAINT `FK_RELATIONSHIP_12` FOREIGN KEY (`ID_ALIMENTO`) REFERENCES `alimento` (`ID_ALIMENTO`);

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
  ADD CONSTRAINT `FK_RELATIONSHIP_21` FOREIGN KEY (`ID_VENTA`) REFERENCES `venta` (`ID_VENTA`),
  ADD CONSTRAINT `FK_RELATIONSHIP_17` FOREIGN KEY (`ID_JAULA`) REFERENCES `jaula` (`ID_JAULA`),
  ADD CONSTRAINT `FK_RELATIONSHIP_18` FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `producto` (`ID_PRODUCTO`);

--
-- Filtros para la tabla `ingreso_producto`
--
ALTER TABLE `ingreso_producto`
  ADD CONSTRAINT `FK_RELATIONSHIP_6` FOREIGN KEY (`ID_JAULA`) REFERENCES `jaula` (`ID_JAULA`),
  ADD CONSTRAINT `FK_RELATIONSHIP_24` FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `producto` (`ID_PRODUCTO`);

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
  ADD CONSTRAINT `FK_RELATIONSHIP_16` FOREIGN KEY (`ID_JAULA`) REFERENCES `jaula` (`ID_JAULA`),
  ADD CONSTRAINT `FK_RELATIONSHIP_11` FOREIGN KEY (`ID_ALIMENTO`) REFERENCES `alimento` (`ID_ALIMENTO`);

--
-- Filtros para la tabla `registro_mortalidad`
--
ALTER TABLE `registro_mortalidad`
  ADD CONSTRAINT `FK_RELATIONSHIP_10` FOREIGN KEY (`ID_JAULA`) REFERENCES `jaula` (`ID_JAULA`);

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

--
-- Filtros para la tabla `traslados`
--
ALTER TABLE `traslados`
  ADD CONSTRAINT `FK_RELATIONSHIP_5` FOREIGN KEY (`ID_JAULA`) REFERENCES `jaula` (`ID_JAULA`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `FK_RELATIONSHIP_4` FOREIGN KEY (`ID_COMPROBANTE_VENTA`) REFERENCES `comprobante_venta` (`ID_COMPROBANTE_VENTA`),
  ADD CONSTRAINT `FK_RELATIONSHIP_23` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `cliente` (`ID_CLIENTE`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

