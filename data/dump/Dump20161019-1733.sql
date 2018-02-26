-- MySQL dump 10.13  Distrib 5.7.13, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: almacenamiento_inventario
-- ------------------------------------------------------
-- Server version	5.7.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `creado` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `actualizado` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'buzo','2016-10-19 17:50:18',NULL,1),(2,'pantalon','2016-10-19 17:50:18',NULL,1);
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` text COLLATE utf8_unicode_ci,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden_ingreso`
--

DROP TABLE IF EXISTS `orden_ingreso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orden_ingreso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id` int(11) NOT NULL,
  `fecha_salida` datetime NOT NULL,
  `descripcion` text COLLATE utf8_unicode_ci,
  `remitente` text COLLATE utf8_unicode_ci,
  `creado` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `actualizado` datetime DEFAULT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`,`usuario_id`),
  KEY `fk_orden_ingreso_usuario1_idx` (`usuario_id`),
  CONSTRAINT `fk_orden_ingreso_usuario1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden_ingreso`
--

LOCK TABLES `orden_ingreso` WRITE;
/*!40000 ALTER TABLE `orden_ingreso` DISABLE KEYS */;
/*!40000 ALTER TABLE `orden_ingreso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden_ingreso_has_producto`
--

DROP TABLE IF EXISTS `orden_ingreso_has_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orden_ingreso_has_producto` (
  `orden_ingreso_id` int(11) NOT NULL,
  `producto_id` int(11) NOT NULL,
  PRIMARY KEY (`orden_ingreso_id`,`producto_id`),
  KEY `fk_orden_ingreso_has_producto_producto1_idx` (`producto_id`),
  KEY `fk_orden_ingreso_has_producto_orden_ingreso1_idx` (`orden_ingreso_id`),
  CONSTRAINT `fk_orden_ingreso_has_producto_orden_ingreso1` FOREIGN KEY (`orden_ingreso_id`) REFERENCES `orden_ingreso` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_ingreso_has_producto_producto1` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden_ingreso_has_producto`
--

LOCK TABLES `orden_ingreso_has_producto` WRITE;
/*!40000 ALTER TABLE `orden_ingreso_has_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `orden_ingreso_has_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden_salida`
--

DROP TABLE IF EXISTS `orden_salida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orden_salida` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id` int(11) NOT NULL,
  `fecha_salida` datetime NOT NULL,
  `descripcion` text COLLATE utf8_unicode_ci,
  `destino` text COLLATE utf8_unicode_ci,
  `receptor` text COLLATE utf8_unicode_ci,
  `creado` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `actualizado` datetime DEFAULT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`,`usuario_id`),
  KEY `fk_orden_salida_usuario1_idx` (`usuario_id`),
  CONSTRAINT `fk_orden_salida_usuario1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden_salida`
--

LOCK TABLES `orden_salida` WRITE;
/*!40000 ALTER TABLE `orden_salida` DISABLE KEYS */;
/*!40000 ALTER TABLE `orden_salida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden_salida_has_producto`
--

DROP TABLE IF EXISTS `orden_salida_has_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orden_salida_has_producto` (
  `orden_salida_id` int(11) NOT NULL,
  `producto_id` int(11) NOT NULL,
  PRIMARY KEY (`orden_salida_id`,`producto_id`),
  KEY `fk_orden_salida_has_producto_producto1_idx` (`producto_id`),
  KEY `fk_orden_salida_has_producto_orden_salida1_idx` (`orden_salida_id`),
  CONSTRAINT `fk_orden_salida_has_producto_orden_salida1` FOREIGN KEY (`orden_salida_id`) REFERENCES `orden_salida` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_salida_has_producto_producto1` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden_salida_has_producto`
--

LOCK TABLES `orden_salida_has_producto` WRITE;
/*!40000 ALTER TABLE `orden_salida_has_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `orden_salida_has_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfil` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `descripcion` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creado` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `actualizado` datetime DEFAULT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES (1,'vendedor',NULL,'2016-10-19 17:31:45',NULL,1),(2,'almacenero',NULL,'2016-10-19 17:31:45',NULL,1),(3,'administrador',NULL,'2016-10-19 17:31:45',NULL,1);
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil_has_permisos`
--

DROP TABLE IF EXISTS `perfil_has_permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfil_has_permisos` (
  `perfil_id` int(11) NOT NULL,
  `permisos_id` int(11) NOT NULL,
  PRIMARY KEY (`perfil_id`,`permisos_id`),
  KEY `fk_perfil_has_permisos_permisos1_idx` (`permisos_id`),
  KEY `fk_perfil_has_permisos_perfil1_idx` (`perfil_id`),
  CONSTRAINT `fk_perfil_has_permisos_perfil1` FOREIGN KEY (`perfil_id`) REFERENCES `perfil` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_perfil_has_permisos_permisos1` FOREIGN KEY (`permisos_id`) REFERENCES `permisos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil_has_permisos`
--

LOCK TABLES `perfil_has_permisos` WRITE;
/*!40000 ALTER TABLE `perfil_has_permisos` DISABLE KEYS */;
INSERT INTO `perfil_has_permisos` VALUES (1,1),(2,1),(3,1);
/*!40000 ALTER TABLE `perfil_has_permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisos`
--

DROP TABLE IF EXISTS `permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permisos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `descripcion` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creado` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `actualizado` datetime DEFAULT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  `alias` varchar(45) COLLATE utf8_unicode_ci DEFAULT 'ROLE_',
  `grupo` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisos`
--

LOCK TABLES `permisos` WRITE;
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
INSERT INTO `permisos` VALUES (1,'ROLE_CREATE',NULL,'2016-10-19 17:31:05',NULL,1,'ROLE_',NULL),(2,'ROLE_EDIT',NULL,'2016-10-19 17:31:05',NULL,1,'ROLE_',NULL),(3,'ROLE_DELETE',NULL,'2016-10-19 17:31:05',NULL,1,'ROLE_',NULL);
/*!40000 ALTER TABLE `permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria_id` int(11) NOT NULL,
  `codigo` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `nombre` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `descripcion` text COLLATE utf8_unicode_ci,
  `color` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `talla` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `tipo_tela` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creado` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `actualizado` datetime DEFAULT NULL,
  `activo` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `fk_producto_categoria1_idx` (`categoria_id`),
  CONSTRAINT `fk_producto_categoria1` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,1,'ASD','producto 1','descripcion 1','rojo','45',345,'tela 1','2016-10-19 17:51:09',NULL,1),(2,1,'QWE','producto 2','descripcion 2','blanco','23',543,'tela 2','2016-10-19 17:51:09',NULL,1),(3,2,'ZXC','producto 3','descripcion 3','verde','12',789,'tela 3','2016-10-19 17:53:02',NULL,1);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `perfil_id` int(11) NOT NULL,
  `username` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `nombre` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `apellido` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `dni` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `ruc` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fecha_nacimiento` datetime DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_plain` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `clave_web` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `salt` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creado` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `actualizado` datetime DEFAULT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `clave_web_UNIQUE` (`clave_web`),
  KEY `fk_usuario_perfil1_idx` (`perfil_id`),
  CONSTRAINT `fk_usuario_perfil1` FOREIGN KEY (`perfil_id`) REFERENCES `perfil` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,3,'jhosep','jhosep','alvarado','12345678',NULL,NULL,'jhosep@gmail.com','','123',NULL,NULL,'2016-10-19 17:34:17',NULL,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-19 17:33:12
