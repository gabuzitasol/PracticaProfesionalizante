/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.4.14-MariaDB : Database - internet_practica
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`internet_practica` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `internet_practica`;

/*Table structure for table `actividad` */

DROP TABLE IF EXISTS `actividad`;

CREATE TABLE `actividad` (
  `id_actividad` bigint(20) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_actividad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `actividad` */

/*Table structure for table `actividad_producto` */

DROP TABLE IF EXISTS `actividad_producto`;

CREATE TABLE `actividad_producto` (
  `id_producto_activida` bigint(20) NOT NULL AUTO_INCREMENT,
  `cantidad` float NOT NULL,
  `detalle` varchar(255) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `nombre_persona` varchar(255) DEFAULT NULL,
  `numero_activo` float NOT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `kf_departamento` bigint(20) NOT NULL,
  `kf_producto` bigint(20) NOT NULL,
  PRIMARY KEY (`id_producto_activida`),
  KEY `FK5hi0m6l9yufgycelovf3lubok` (`kf_departamento`),
  KEY `FKg2yauf4f3xse8pc0lmmo0w97m` (`kf_producto`),
  CONSTRAINT `FK5hi0m6l9yufgycelovf3lubok` FOREIGN KEY (`kf_departamento`) REFERENCES `departamento` (`id_departamento`),
  CONSTRAINT `FKg2yauf4f3xse8pc0lmmo0w97m` FOREIGN KEY (`kf_producto`) REFERENCES `producto` (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `actividad_producto` */

/*Table structure for table `asignacion_actividad` */

DROP TABLE IF EXISTS `asignacion_actividad`;

CREATE TABLE `asignacion_actividad` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cumplimiento` varchar(255) DEFAULT NULL,
  `editar` int(11) NOT NULL,
  `empleado_secundario` varchar(255) DEFAULT NULL,
  `end` datetime DEFAULT NULL,
  `extras` varchar(255) DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  `start` datetime DEFAULT NULL,
  `fk_actividad` bigint(20) NOT NULL,
  `kf_cliente` bigint(20) NOT NULL,
  `kf_empleado` bigint(20) NOT NULL,
  `kf_locacion` bigint(20) NOT NULL,
  `kf_operador` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKila9j3fcfc8egpqlkv6hp8gvh` (`fk_actividad`),
  KEY `FKr6y6o507ij36xkry9um17q2h` (`kf_cliente`),
  KEY `FK37jx84yoluoj9yl5lrq95a5t8` (`kf_empleado`),
  KEY `FKtfhp1lo6ppgf3x9t50up25ndh` (`kf_locacion`),
  KEY `FKpkjpramno80ofjl87dr374d4n` (`kf_operador`),
  CONSTRAINT `FK37jx84yoluoj9yl5lrq95a5t8` FOREIGN KEY (`kf_empleado`) REFERENCES `empleado` (`id_empleado`),
  CONSTRAINT `FKila9j3fcfc8egpqlkv6hp8gvh` FOREIGN KEY (`fk_actividad`) REFERENCES `actividad` (`id_actividad`),
  CONSTRAINT `FKpkjpramno80ofjl87dr374d4n` FOREIGN KEY (`kf_operador`) REFERENCES `operador` (`id_operador`),
  CONSTRAINT `FKr6y6o507ij36xkry9um17q2h` FOREIGN KEY (`kf_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `FKtfhp1lo6ppgf3x9t50up25ndh` FOREIGN KEY (`kf_locacion`) REFERENCES `locacion` (`id_locacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `asignacion_actividad` */

/*Table structure for table `canton` */

DROP TABLE IF EXISTS `canton`;

CREATE TABLE `canton` (
  `id_canton` bigint(20) NOT NULL AUTO_INCREMENT,
  `canton` varchar(255) DEFAULT NULL,
  `kf_provincias` bigint(20) NOT NULL,
  PRIMARY KEY (`id_canton`),
  KEY `FK1ylftmq1e5v1n07inrwjs1wrw` (`kf_provincias`),
  CONSTRAINT `FK1ylftmq1e5v1n07inrwjs1wrw` FOREIGN KEY (`kf_provincias`) REFERENCES `provincias` (`id_provincia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `canton` */

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `id_cliente` bigint(20) NOT NULL AUTO_INCREMENT,
  `cliente_creado` datetime DEFAULT NULL,
  `cliente_modificado` datetime DEFAULT NULL,
  `correo_cliente` varchar(255) DEFAULT NULL,
  `direccion_cliente` varchar(255) DEFAULT NULL,
  `nombre_cliente` varchar(255) DEFAULT NULL,
  `ruc_cliente` varchar(255) DEFAULT NULL,
  `telefono_cliente` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cliente` */

/*Table structure for table `contacto_cliente` */

DROP TABLE IF EXISTS `contacto_cliente`;

CREATE TABLE `contacto_cliente` (
  `id_contacto_cliente` bigint(20) NOT NULL AUTO_INCREMENT,
  `celular_contacto` varchar(255) DEFAULT NULL,
  `email_contacto` varchar(255) DEFAULT NULL,
  `nombre_contacto` varchar(255) DEFAULT NULL,
  `telefono_contacto_cliente` varchar(255) DEFAULT NULL,
  `kf_cliente` bigint(20) NOT NULL,
  PRIMARY KEY (`id_contacto_cliente`),
  KEY `FKaq7su6nksj4nsdowjk5uakmxv` (`kf_cliente`),
  CONSTRAINT `FKaq7su6nksj4nsdowjk5uakmxv` FOREIGN KEY (`kf_cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `contacto_cliente` */

/*Table structure for table `contacto_sitio` */

DROP TABLE IF EXISTS `contacto_sitio`;

CREATE TABLE `contacto_sitio` (
  `id_contacto_sitio` bigint(20) NOT NULL AUTO_INCREMENT,
  `celular_contacto_sitio` varchar(255) DEFAULT NULL,
  `contacto_sitio` varchar(255) DEFAULT NULL,
  `email_contacto_sitio` varchar(255) DEFAULT NULL,
  `email_contacto_sitio_2` varchar(255) DEFAULT NULL,
  `email_contacto_sitio_3` varchar(255) DEFAULT NULL,
  `telefono_contacto_sitio` varchar(255) DEFAULT NULL,
  `kf_asignacion_actividad` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_contacto_sitio`),
  KEY `FK6qd8cvj85utyavyk3tjkvfe8j` (`kf_asignacion_actividad`),
  CONSTRAINT `FK6qd8cvj85utyavyk3tjkvfe8j` FOREIGN KEY (`kf_asignacion_actividad`) REFERENCES `asignacion_actividad` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `contacto_sitio` */

/*Table structure for table `departamento` */

DROP TABLE IF EXISTS `departamento`;

CREATE TABLE `departamento` (
  `id_departamento` bigint(20) NOT NULL AUTO_INCREMENT,
  `direccion_departamento` varchar(255) DEFAULT NULL,
  `nombre_departamento` varchar(255) DEFAULT NULL,
  `telefono_departamento` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `departamento` */

/*Table structure for table `empleado` */

DROP TABLE IF EXISTS `empleado`;

CREATE TABLE `empleado` (
  `id_empleado` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellido_empleado` varchar(255) DEFAULT NULL,
  `cedula` varchar(255) DEFAULT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `celular_contacto_emergencia` varchar(255) DEFAULT NULL,
  `contrasena_temporal` varchar(255) DEFAULT NULL,
  `cuenta_bancaria` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `email_empleado` varchar(255) DEFAULT NULL,
  `entidad_financiera` varchar(255) DEFAULT NULL,
  `estado_civil` varchar(255) DEFAULT NULL,
  `fecha_nacimiento` datetime DEFAULT NULL,
  `is_active` int(11) NOT NULL,
  `nombre_contacto_emergencia` varchar(255) DEFAULT NULL,
  `nombre_empleado` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `telefono_contacto_emergencia` varchar(255) DEFAULT NULL,
  `tipo_sangre` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `usuario_creado` datetime DEFAULT NULL,
  `usuario_editado` datetime DEFAULT NULL,
  `kf_departamento` bigint(20) NOT NULL,
  PRIMARY KEY (`id_empleado`),
  KEY `FKl5x8n5rdb5irc4xe8mkp9lhj9` (`kf_departamento`),
  CONSTRAINT `FKl5x8n5rdb5irc4xe8mkp9lhj9` FOREIGN KEY (`kf_departamento`) REFERENCES `departamento` (`id_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `empleado` */

/*Table structure for table `historial_bodega` */

DROP TABLE IF EXISTS `historial_bodega`;

CREATE TABLE `historial_bodega` (
  `id_historial` bigint(20) NOT NULL AUTO_INCREMENT,
  `accion` varchar(255) DEFAULT NULL,
  `cantidad` float NOT NULL,
  `fecha_accion` datetime DEFAULT NULL,
  `nombte_producto` varchar(255) DEFAULT NULL,
  `num_activo` varchar(255) DEFAULT NULL,
  `num_serie` varchar(255) DEFAULT NULL,
  `tipo_transaccion` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_historial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `historial_bodega` */

/*Table structure for table `locacion` */

DROP TABLE IF EXISTS `locacion`;

CREATE TABLE `locacion` (
  `id_locacion` bigint(20) NOT NULL AUTO_INCREMENT,
  `calle_principal` varchar(255) DEFAULT NULL,
  `calle_secundaria` varchar(255) DEFAULT NULL,
  `nombre_edificio` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `oficina` varchar(255) DEFAULT NULL,
  `piso` int(11) NOT NULL,
  `referencia_cliente` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  `kf_cantones` bigint(20) NOT NULL,
  PRIMARY KEY (`id_locacion`),
  KEY `FKo02tl0b0ef1dy0dnggmeob2s` (`kf_cantones`),
  CONSTRAINT `FKo02tl0b0ef1dy0dnggmeob2s` FOREIGN KEY (`kf_cantones`) REFERENCES `canton` (`id_canton`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `locacion` */

/*Table structure for table `operador` */

DROP TABLE IF EXISTS `operador`;

CREATE TABLE `operador` (
  `id_operador` bigint(20) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) DEFAULT NULL,
  `operador` varchar(255) DEFAULT NULL,
  `operador_creado` datetime DEFAULT NULL,
  `operador_editado` datetime DEFAULT NULL,
  `ruc` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_operador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `operador` */

/*Table structure for table `producto` */

DROP TABLE IF EXISTS `producto`;

CREATE TABLE `producto` (
  `id_producto` bigint(20) NOT NULL AUTO_INCREMENT,
  `cantidad` float NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `producto_creado` datetime DEFAULT NULL,
  `producto_editado` datetime DEFAULT NULL,
  `serie` varchar(255) DEFAULT NULL,
  `unidad` varchar(255) DEFAULT NULL,
  `kf_departamento` bigint(20) NOT NULL,
  `kf_operador` bigint(20) NOT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `FK8se1epbv1e94a4by568kehuke` (`kf_departamento`),
  KEY `FKfxo65p56iomkp7a95a8rcwuna` (`kf_operador`),
  CONSTRAINT `FK8se1epbv1e94a4by568kehuke` FOREIGN KEY (`kf_departamento`) REFERENCES `departamento` (`id_departamento`),
  CONSTRAINT `FKfxo65p56iomkp7a95a8rcwuna` FOREIGN KEY (`kf_operador`) REFERENCES `operador` (`id_operador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `producto` */

/*Table structure for table `provincias` */

DROP TABLE IF EXISTS `provincias`;

CREATE TABLE `provincias` (
  `id_provincia` bigint(20) NOT NULL AUTO_INCREMENT,
  `provincia` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_provincia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `provincias` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
