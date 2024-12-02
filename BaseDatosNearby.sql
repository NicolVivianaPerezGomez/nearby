-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: nearby
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categorias_matches`
--

DROP TABLE IF EXISTS `categorias_matches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias_matches` (
  `cat_mat_id` int NOT NULL,
  `cat_mat_amistad` varchar(15) DEFAULT NULL,
  `cat_mat_casual` varchar(15) DEFAULT NULL,
  `cat_mat_diversion` varchar(15) DEFAULT NULL,
  `cat_mat_romance` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`cat_mat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias_matches`
--

LOCK TABLES `categorias_matches` WRITE;
/*!40000 ALTER TABLE `categorias_matches` DISABLE KEYS */;
/*!40000 ALTER TABLE `categorias_matches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `citas`
--

DROP TABLE IF EXISTS `citas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `citas` (
  `cit_id` int NOT NULL,
  `cit_fecha` date DEFAULT NULL,
  `cit_hora` varchar(10) DEFAULT NULL,
  `cit_ubicación` varchar(50) DEFAULT NULL,
  `cit_estado` varchar(15) DEFAULT NULL,
  `matches_mat_id` int NOT NULL,
  PRIMARY KEY (`cit_id`),
  KEY `fk_citas_matches1_idx` (`matches_mat_id`),
  CONSTRAINT `fk_citas_matches1` FOREIGN KEY (`matches_mat_id`) REFERENCES `matches` (`mat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citas`
--

LOCK TABLES `citas` WRITE;
/*!40000 ALTER TABLE `citas` DISABLE KEYS */;
/*!40000 ALTER TABLE `citas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fotografias`
--

DROP TABLE IF EXISTS `fotografias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fotografias` (
  `fot_id` int NOT NULL,
  `fot_fechasubida` date DEFAULT NULL,
  `perfiles_per_id` int NOT NULL,
  PRIMARY KEY (`fot_id`),
  KEY `fk_fotografias_perfiles1_idx` (`perfiles_per_id`),
  CONSTRAINT `fk_fotografias_perfiles1` FOREIGN KEY (`perfiles_per_id`) REFERENCES `perfiles` (`per_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fotografias`
--

LOCK TABLES `fotografias` WRITE;
/*!40000 ALTER TABLE `fotografias` DISABLE KEYS */;
/*!40000 ALTER TABLE `fotografias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matches`
--

DROP TABLE IF EXISTS `matches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matches` (
  `mat_id` int NOT NULL,
  `mat_usu1` varchar(15) NOT NULL,
  `mat_usu2` varchar(15) NOT NULL,
  `mat_estado` varchar(10) DEFAULT NULL,
  `categorias_matches_cat_mat_id` int NOT NULL,
  PRIMARY KEY (`mat_id`),
  KEY `fk_matches_categorias_matches1_idx` (`categorias_matches_cat_mat_id`),
  CONSTRAINT `fk_matches_categorias_matches1` FOREIGN KEY (`categorias_matches_cat_mat_id`) REFERENCES `categorias_matches` (`cat_mat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matches`
--

LOCK TABLES `matches` WRITE;
/*!40000 ALTER TABLE `matches` DISABLE KEYS */;
/*!40000 ALTER TABLE `matches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfiles`
--

DROP TABLE IF EXISTS `perfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfiles` (
  `per_id` int NOT NULL,
  `per_nombre` varchar(30) DEFAULT NULL,
  `per_descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`per_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfiles`
--

LOCK TABLES `perfiles` WRITE;
/*!40000 ALTER TABLE `perfiles` DISABLE KEYS */;
/*!40000 ALTER TABLE `perfiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `usu_id` varchar(15) NOT NULL,
  `usu_nombre` varchar(30) NOT NULL,
  `usu_email` varchar(40) NOT NULL,
  `usu_contraseña` varchar(20) NOT NULL,
  `usu_edad` varchar(45) DEFAULT NULL,
  `usu_genero` varchar(45) DEFAULT NULL,
  `perfiles_per_id` int NOT NULL,
  PRIMARY KEY (`usu_id`),
  UNIQUE KEY `Usuarios_Id_UNIQUE` (`usu_id`),
  UNIQUE KEY `usu_contraseña_UNIQUE` (`usu_contraseña`),
  KEY `fk_usuarios_perfiles1_idx` (`perfiles_per_id`),
  CONSTRAINT `fk_usuarios_perfiles1` FOREIGN KEY (`perfiles_per_id`) REFERENCES `perfiles` (`per_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_has_matches`
--

DROP TABLE IF EXISTS `usuarios_has_matches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios_has_matches` (
  `usuarios_usu_id` varchar(15) NOT NULL,
  `matches_mat_id` int NOT NULL,
  PRIMARY KEY (`usuarios_usu_id`,`matches_mat_id`),
  KEY `fk_usuarios_has_matches_matches1_idx` (`matches_mat_id`),
  KEY `fk_usuarios_has_matches_usuarios1_idx` (`usuarios_usu_id`),
  CONSTRAINT `fk_usuarios_has_matches_matches1` FOREIGN KEY (`matches_mat_id`) REFERENCES `matches` (`mat_id`),
  CONSTRAINT `fk_usuarios_has_matches_usuarios1` FOREIGN KEY (`usuarios_usu_id`) REFERENCES `usuarios` (`usu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_has_matches`
--

LOCK TABLES `usuarios_has_matches` WRITE;
/*!40000 ALTER TABLE `usuarios_has_matches` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios_has_matches` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-27 20:43:12
