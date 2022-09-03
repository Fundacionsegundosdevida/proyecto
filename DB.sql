-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.10.1-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para alquiler_equipos
CREATE DATABASE IF NOT EXISTS `alquiler_equipos` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `alquiler_equipos`;

-- Volcando estructura para tabla alquiler_equipos.alquiler
CREATE TABLE IF NOT EXISTS `alquiler` (
  `id_equipo` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`id_equipo`,`username`,`fecha`) USING BTREE,
  KEY `FK_usuario` (`username`),
  CONSTRAINT `FK_equipo_medico` FOREIGN KEY (`id_equipo`) REFERENCES `equipo_medico` (`id_equipo`),
  CONSTRAINT `FK_usuario` FOREIGN KEY (`username`) REFERENCES `usuario` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla alquiler_equipos.alquiler: ~0 rows (aproximadamente)

-- Volcando estructura para tabla alquiler_equipos.equipo_medico
CREATE TABLE IF NOT EXISTS `equipo_medico` (
  `id_equipo` int(11) NOT NULL,
  `nombre_equipo` varchar(50) DEFAULT NULL,
  `tipo_equipo` varchar(50) DEFAULT NULL,
  `marca_equipo` varchar(50) DEFAULT NULL,
  `cantidad_equipo` varchar(50) DEFAULT NULL,
  `observacion_equipo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_equipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla alquiler_equipos.equipo_medico: ~20 rows (aproximadamente)
INSERT INTO `equipo_medico` (`id_equipo`, `nombre_equipo`, `tipo_equipo`, `marca_equipo`, `cantidad_equipo`, `observacion_equipo`) VALUES
	(1, 'Ciclotron', 'Terapeutico', 'Varian', 'Uno', 'Ninguna'),
	(2, 'Colimador', 'Rayos Gamma', 'Elekta', 'tres', 'Ninguna'),
	(3, 'Acelerador', 'Radiocirugia', 'Brainlab', 'seis', 'Ninguna'),
	(4, 'CQ', 'Radioterapia', 'Scandidos', 'dos', 'Ninguna'),
	(5, 'Mesa de posicionamiento', 'Radioterapia', 'Civco', 'Uno', 'Ninguna'),
	(6, 'Colimador multilaminas', 'Radiocirugia', '3done', 'dos', 'Ninguna'),
	(7, 'Inmovilizador', 'Radioterapia', '3done', 'diez', 'Ninguna'),
	(8, 'Marcos de estereotaxia', 'Neuroimgen', 'Elekta', 'siete', 'Ninguna'),
	(9, 'Laser de alineacion', 'Escaner de rayos x', 'Diacor', 'cinco', 'Ninguna'),
	(10, 'Braquiterapia', 'Radiacion', 'Elekta', 'seis', 'Ninguna'),
	(11, 'Peroperatoria', 'Rayos x', 'Cad', 'seis', 'Ninguna'),
	(12, 'Proyector de fuente', 'Braquiterapia', 'Elekta', 'tres', 'Ninguna'),
	(13, 'Sillon de Quimioterapia', 'Quimioterapia', 'Lemi', 'Dos', 'Ninguna'),
	(14, 'Hipertermia', 'Intraperitoneal', 'Rand', 'Diez', 'Ninguna'),
	(15, 'Cascos de Quimioterapia', 'terapeutico', 'Gentherm', 'Cuatro', 'Ninguna'),
	(16, 'Bombas de infusion', 'Quimioterapia', 'Medreno', 'Diez', 'Ninguna'),
	(17, 'Bombas de Jeringa', 'Quimioterapia', 'Enmind', 'Ocho', 'Ninguna'),
	(18, 'Sets de Perfusion', 'Quimioterapia', 'Bqmas', 'Diez', 'Ninguna'),
	(19, 'Camara Implantada', 'Quimioterapia', 'Braun', 'Diez', 'Ninguna'),
	(20, 'Adaptadores para Frascos', 'Quimioterapia', 'Bqmas', 'Diez', 'Ninguna');

-- Volcando estructura para tabla alquiler_equipos.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `username` varchar(50) NOT NULL DEFAULT '',
  `contrasena` varchar(20) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `edad` tinyint(2) DEFAULT NULL,
  `diagnostico` varchar(50) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `prioritario` tinyint(6) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `cuota_mantenimiento` double(22,3) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla alquiler_equipos.usuario: ~0 rows (aproximadamente)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
