-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: rentitdb
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookingTS` varchar(45) NOT NULL,
  `returnDate` varchar(45) DEFAULT NULL,
  `startDate` varchar(45) DEFAULT NULL,
  `dueDate` varchar(45) DEFAULT NULL,
  `cancelDate` varchar(45) DEFAULT NULL,
  `clientId` varchar(45) DEFAULT NULL,
  `vehicleId` varchar(45) DEFAULT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (1,'2019-11-17','2019-11-17 17:16:15','2019-11-17','2019-11-28',NULL,'1','1',2),(2,'2019-11-17',NULL,'2019-11-17','2019-11-23','2019-11-17 17:16:23','2','1',2),(3,'2019-11-17',NULL,'2019-11-17','2019-11-19',NULL,'3','2',1),(4,'2019-11-17',NULL,'2019-11-17','2019-11-19',NULL,'4','3',1),(5,'2019-11-17',NULL,'2019-11-17','2019-11-18',NULL,'5','3',1),(6,'2019-11-17',NULL,'2019-11-17','2019-11-18',NULL,'6','5',1),(8,'2019-11-17',NULL,'2019-11-17','2019-11-18',NULL,'8','5',1);
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clerks`
--

DROP TABLE IF EXISTS `clerks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clerks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `usergroup` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clerks`
--

LOCK TABLES `clerks` WRITE;
/*!40000 ALTER TABLE `clerks` DISABLE KEYS */;
INSERT INTO `clerks` VALUES (1,'a','a','abcdef','8mzCNJUNtvSJJSpQl9fUJg==','a@a','clerk'),(2,'q','q','qwerty','8mzCNJUNtvSJJSpQl9fUJg==','q@q','clerk'),(3,'admin','admin','admin','X+tGwEBkr7aJJSpQl9fUJg==','ad@ad','admin');
/*!40000 ALTER TABLE `clerks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `licenceNumber` varchar(45) NOT NULL,
  `licenceValidity` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `clerkId` int(11) DEFAULT NULL,
  `bookingId` int(11) DEFAULT NULL,
  `vehicleId` int(11) DEFAULT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'aaaaaaaaaaaaaaa','aaaaaaaaaaaaaaa','a-1234-567890-12','2019-11-30','4389280525',2,0,0,2),(2,'bbbbbbbbbbb','bbbbbbbbbbbbbb','a-1234-567890-99','2019-11-30','8066575757',1,0,0,2),(3,'Aravind','Adiga','a-1234-567890-32','2019-11-30','8066575757',1,3,2,1),(4,'Basant','Bhai','a-1234-567890-99','2019-11-30','4389280525',1,4,3,1),(5,'Charan','C','a-1234-567890-99','2019-11-30','8066575757',2,5,3,1),(8,'a','a','a-1234-567890-12','2019-11-30','8066575757',1,8,5,1);
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicles`
--

DROP TABLE IF EXISTS `vehicles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Make` varchar(45) NOT NULL,
  `Model` varchar(45) NOT NULL,
  `iYear` varchar(45) NOT NULL,
  `Type` varchar(45) NOT NULL,
  `LicPlate` varchar(45) NOT NULL,
  `Color` varchar(45) DEFAULT NULL,
  `bookingId` varchar(45) DEFAULT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `LicPlate_UNIQUE` (`LicPlate`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicles`
--

LOCK TABLES `vehicles` WRITE;
/*!40000 ALTER TABLE `vehicles` DISABLE KEYS */;
INSERT INTO `vehicles` VALUES (1,'ahn','sss','2019','SUV1','abc 123','black','0',5),(2,'maruti','swift','2019','SUV3','xyz 123','black','3',3),(3,'urus','Lamborgini','2019','SUV1','lam 999','yellow','5',3),(4,'f80','Ferrari','2019','SUV1','fer 123','red','0',3),(5,'BMW','M3','2018','Sedan','BMW 123','Blue','8',13);
/*!40000 ALTER TABLE `vehicles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-17 19:29:23
