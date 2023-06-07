CREATE DATABASE  IF NOT EXISTS `customers` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `customers`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: customers
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `phone_number` varchar(14) NOT NULL,
  `img` varchar(300) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `phone_number_UNIQUE` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Nguyễn Văn Bến','Gia Bình - Bắc Ninh','nguyenvanben02001@gmail.com','0963778407','https://scontent.fhan5-10.fna.fbcdn.net/v/t39.30808-1/324346157_573092641003089_8994177206377802673_n.jpg?stp=dst-jpg_p240x240&_nc_cat=101&ccb=1-7&_nc_sid=7206a8&_nc_ohc=7CEX1x39facAX-dLmAs&_nc_ht=scontent.fhan5-10.fna&oh=00_AfAP5Cncvdbdb2BIdv6pxL4a9ZEyefqcu5nWgoJ7_UFZrw&oe=644A863A','2001-04-14'),(2,'Nguyễn Văn Bến','Gia Bình - Bắc Ninh','bennv14@gmail.com','092342343','https://scontent.fhan5-11.fna.fbcdn.net/v/t39.30808-6/278534687_3198224627133355_3470095109332184846_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=174925&_nc_ohc=MJsE-MQBEKIAX-0YwxY&_nc_ht=scontent.fhan5-11.fna&oh=00_AfAk79q8zNl-d-PoVueKb0F1hoIStcF79Mk-dxhgWYMIzA&oe=644A123C','2001-04-14'),(3,'Nguyễn Văn Bến','Gia Bình - Bắc Ninh','bennv14@gmail.com','092342342','https://scontent.fhan5-2.fna.fbcdn.net/v/t1.6435-9/110175814_2701368460152310_6513542925692273288_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=174925&_nc_ohc=m7uJnobF15IAX-g7e2H&_nc_ht=scontent.fhan5-2.fna&oh=00_AfD5sptaQXVzpaZi54QNqq9FeyvIP9Y5vScj-bT0knB26w&oe=646C44C4','2001-04-14'),(17,'Nguyễn Bến','Bắc Ninh','ben@gmail.com','09727642874',NULL,'2023-05-01'),(18,'Nguyễn Bến','Bắc Ninh','ben@gmail.com','09727642871',NULL,'2023-05-01'),(19,'Nguyễn Bến','Bắc Ninh','ben@gmail.com','0963778434',NULL,'2023-05-04'),(20,'Nguyễn Bến','Bắc Ninh','ben@gmail.com','825945205',NULL,'2023-05-15');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-15 21:59:01
