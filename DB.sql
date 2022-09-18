-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.9.2-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para alquiler_equipos
CREATE DATABASE IF NOT EXISTS `alquiler_equipos` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `alquiler_equipos`;

-- Volcando datos para la tabla alquiler_equipos.alquiler: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `alquiler` DISABLE KEYS */;
/*!40000 ALTER TABLE `alquiler` ENABLE KEYS */;

-- Volcando datos para la tabla alquiler_equipos.equipo_medico: ~20 rows (aproximadamente)
/*!40000 ALTER TABLE `equipo_medico` DISABLE KEYS */;
INSERT INTO `equipo_medico` (`id_equipo`, `nombre_equipo`, `tipo_equipo`, `marca_equipo`, `cantidad_equipo`, `observacion_equipo`) VALUES
	(1, 'Ciclotron', 'Terapeutico', 'Varian', 3, 'Ninguna'),
	(2, 'Colimador', 'Rayos Gamma', 'Elekta', 1, 'Ninguna'),
	(3, 'Acelerador', 'Radiocirugia', 'Brainlab', 5, 'Ninguna'),
	(4, 'CQ', 'Radioterapia', 'Scandidos', 1, 'Ninguna'),
	(5, 'Mesa de posicionamiento', 'Radioterapia', 'Civco', 23, 'Ninguna'),
	(6, 'Colimador multilaminas', 'Cambiado', '3done', 5, 'Ninguna'),
	(7, 'Inmovilizador', 'Radioterapia', '3done', 12, 'Ninguna'),
	(8, 'Marcos de estereotaxia', 'Neuroimgen', 'Elekta', 7, 'Ninguna'),
	(9, 'Laser de alineacion', 'Escaner de rayos x', 'Diacor', 8, 'Ninguna'),
	(10, 'Braquiterapia', 'Radiacion', 'Elekta', 2, 'Ninguna'),
	(11, 'Peroperatoria', 'Rayos x', 'Cad', 0, 'Ninguna'),
	(12, 'Proyector de fuente', 'Braquiterapia', 'Elekta', 1, 'Ninguna'),
	(13, 'Sillon de Quimioterapia', 'Quimioterapia', 'Lemi', 1, 'Ninguna'),
	(14, 'Hipertermia', 'Intraperitoneal', 'Rand', 1, 'Ninguna'),
	(15, 'Cascos de Quimioterapia', 'terapeutico', 'Gentherm', 1, 'Ninguna'),
	(16, 'Bombas de infusion', 'Quimioterapia', 'Medreno', 2, 'Ninguna'),
	(17, 'Bombas de Jeringa', 'Quimioterapia', 'Enmind', 34, 'Ninguna'),
	(18, 'Sets de Perfusion', 'Quimioterapia', 'Bqmas', 2, 'Ninguna'),
	(19, 'Camara Implantada', 'Quimioterapia', 'Braun', 12, 'Ninguna'),
	(20, 'Adaptadores para Frascos', 'Quimioterapia', 'Bqmas', 4, 'Ninguna');
/*!40000 ALTER TABLE `equipo_medico` ENABLE KEYS */;

-- Volcando datos para la tabla alquiler_equipos.usuario: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
