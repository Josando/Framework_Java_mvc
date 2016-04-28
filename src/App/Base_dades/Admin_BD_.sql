-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: db_admin
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `dni` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `nom` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `cognom` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `date_birthday` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `mobil` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `edad` int(100) NOT NULL DEFAULT '0',
  `email` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `avatar` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `usuario` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `status` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `incentivo` int(11) NOT NULL DEFAULT '0',
  `actividad` int(11) NOT NULL,
  `antiguedad` int(11) NOT NULL DEFAULT '0',
  `sueldo` float NOT NULL DEFAULT '0',
  `Hire_date` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`dni`),
  UNIQUE KEY `dni` (`dni`),
  UNIQUE KEY `usuario` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('15835050X','Javier','Ruiz','21/12/1970','646543258',45,'Javirui@gmail.com',NULL,'Javierruiz','145214ñoL','Online',90,45,13,1100,'18/2/2003'),('30198235V','Serafin','Ramos','21/1/1980','646543287',36,'Sefrafin@gmail.com',NULL,'serafi','JJJu87uj','Online',154,77,15,1100,'4/5/2000'),('30533829H','Dolores','Rodriguez','12/12/1985','652585258',30,'DolorRodri@gmail.com',NULL,'nomedolores','Jki89475','Online',156,78,11,1100,'14/4/2005'),('48292214B','jorge','sanchis','2/1/1982','646543238',34,'Josando@gmail.com',NULL,'josando','Epiphonesg400','Online',90,45,16,1100,'21/1/2000'),('80137039W','Pedro','Moyano','21/1/1975','646543238',41,'Pedro@gmail.com',NULL,'PedorMoya','444444lkO','Online',94,47,17,1100,'21/1/1999'),('85301212P','Jose','sanchis','21/1/1955','646543238',61,'josasn@gmail.com',NULL,'josesanchis','jjjjk)8juh798(uJ','Online',90,45,16,1100,'21/1/2000');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-29  1:38:53
