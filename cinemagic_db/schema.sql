/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19-11.4.7-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: cinemagic
-- ------------------------------------------------------
-- Server version	11.4.7-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*M!100616 SET @OLD_NOTE_VERBOSITY=@@NOTE_VERBOSITY, NOTE_VERBOSITY=0 */;

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `branch` (
  `inter_number` int(11) NOT NULL,
  `id_branch` bigint(20) NOT NULL AUTO_INCREMENT,
  `country` varchar(255) DEFAULT NULL,
  `direction` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `town` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_branch`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cinema_user`
--

DROP TABLE IF EXISTS `cinema_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `cinema_user` (
  `id_viewer` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_viewer`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `duration` int(11) NOT NULL,
  `id_movie` bigint(20) NOT NULL AUTO_INCREMENT,
  `synopsis` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_movie`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `calification` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `id_movie` bigint(20) DEFAULT NULL,
  `id_review` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_user` bigint(20) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_review`),
  KEY `FK2yfxcptnm004rmqfks9f3teiq` (`id_movie`),
  KEY `FK6dh1jigfpj1h1nfvuf2qh4u42` (`id_user`),
  CONSTRAINT `FK2yfxcptnm004rmqfks9f3teiq` FOREIGN KEY (`id_movie`) REFERENCES `movie` (`id_movie`),
  CONSTRAINT `FK6dh1jigfpj1h1nfvuf2qh4u42` FOREIGN KEY (`id_user`) REFERENCES `cinema_user` (`id_viewer`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `showing`
--

DROP TABLE IF EXISTS `showing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `showing` (
  `price` double NOT NULL,
  `date_time` datetime(6) DEFAULT NULL,
  `id_movie` bigint(20) DEFAULT NULL,
  `id_show` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_theater` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_show`),
  KEY `FK6nyqtek42b38f04gvdk2k88b3` (`id_movie`),
  KEY `FK4djlev7ibt2ns345s76o5qnws` (`id_theater`),
  CONSTRAINT `FK4djlev7ibt2ns345s76o5qnws` FOREIGN KEY (`id_theater`) REFERENCES `theater` (`id_theater`),
  CONSTRAINT `FK6nyqtek42b38f04gvdk2k88b3` FOREIGN KEY (`id_movie`) REFERENCES `movie` (`id_movie`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `theater`
--

DROP TABLE IF EXISTS `theater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `theater` (
  `total_seats` int(11) NOT NULL,
  `id_branch` bigint(20) DEFAULT NULL,
  `id_theater` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_theater`),
  KEY `FK7ow197gmflcsfjpjnbka6m7jd` (`id_branch`),
  CONSTRAINT `FK7ow197gmflcsfjpjnbka6m7jd` FOREIGN KEY (`id_branch`) REFERENCES `branch` (`id_branch`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `seat_number` int(11) NOT NULL,
  `id_show` bigint(20) DEFAULT NULL,
  `id_ticket` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_viewer` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_ticket`),
  KEY `FKfntttdmfclieuecyo35qtxs2` (`id_show`),
  KEY `FK59hgglew0llc285x07keg3s6t` (`id_viewer`),
  CONSTRAINT `FK59hgglew0llc285x07keg3s6t` FOREIGN KEY (`id_viewer`) REFERENCES `cinema_user` (`id_viewer`),
  CONSTRAINT `FKfntttdmfclieuecyo35qtxs2` FOREIGN KEY (`id_show`) REFERENCES `showing` (`id_show`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*M!100616 SET NOTE_VERBOSITY=@OLD_NOTE_VERBOSITY */;

-- Dump completed on 2025-07-27 16:36:57
