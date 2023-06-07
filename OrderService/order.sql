-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: supermarket_ws
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `tblcustomer`
--

DROP TABLE IF EXISTS `tblcustomer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblcustomer` (
  `tblMemberid` int NOT NULL,
  `tbl_memberid` int NOT NULL,
  `tbl_payment_cardid` int DEFAULT NULL,
  PRIMARY KEY (`tblMemberid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcustomer`
--

LOCK TABLES `tblcustomer` WRITE;
/*!40000 ALTER TABLE `tblcustomer` DISABLE KEYS */;
INSERT INTO `tblcustomer` VALUES (1,0,NULL),(29,0,NULL),(32,0,NULL),(33,0,NULL),(34,0,NULL),(35,0,NULL),(36,0,NULL),(37,0,NULL),(38,0,NULL);
/*!40000 ALTER TABLE `tblcustomer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblmember`
--

DROP TABLE IF EXISTS `tblmember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblmember` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `address` varchar(255) COLLATE utf8_bin NOT NULL,
  `tel` varchar(255) COLLATE utf8_bin NOT NULL,
  `dob` date NOT NULL,
  `email` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblmember`
--

LOCK TABLES `tblmember` WRITE;
/*!40000 ALTER TABLE `tblmember` DISABLE KEYS */;
INSERT INTO `tblmember` VALUES (1,'customer','customer','Nguyen Van A','Bac Ninh','0123456789','2001-01-01','abc@gmail.com'),(2,'warehousestaff','warehousestaff','WareHouse Staff A','Ha Noi','0123456987','2001-01-01','abc@gmail.com'),(3,'shipper3','shipper3','Nguyen Van Anh','Ha Noi','0123456879','2001-01-01','abc@gmail.com'),(4,'shipper4','shipper4','Tran Van An','Ha Noi','0123456879','2001-01-01','abc@gmail.com'),(5,'shipper5','shipper5','Shipper 5','Ha Noi','0123456879','2001-01-01','abc@gmail.com'),(6,'shipper6','shipper6','Shipper 6','Ha Noi','0123456879','2001-01-01','abc@gmail.com'),(29,'hoangduongngg','hoangduongngg','Hoang Duong Nguyen','Ha Noi','0123456789','2022-10-19','hoangduongngg@gmail.com'),(32,'nguyenvanb','nguyenvanb','Nguyen Van B','HaNoi','0123456789','2022-11-03','duongnh.b19cn153@stu.ptit.edu.vn'),(33,'nguyenvanc','nguyenvana','Nguyen Van C','HaNoi','0123456789','2022-11-30','duongnh.b19cn153@stu.ptit.edu.vn'),(34,'hoanglynamduong','hoanglynamduong','Hoang Ly Nam Duong','Ha Noi','0123456789','2022-10-19','hoangduongngg@gmail.com'),(35,'nguyenvand','nguyenvand','Nguyen Van D','Ha Noi','0123456789','2022-12-08','hoangduong212121photo5@gmail.com'),(36,'nguyenvana','nguyenvana','Nguyen Van A','Thanh Tri, Ha Noi','0123456789','2022-11-24','hoangduong212121photo5@gmail.com'),(37,'nguyenvane','nguyenvane','Nguyen Van E','Ha Noi','0123456789','2022-12-08','hoangduong212121photo5@gmail.com'),(38,'helios.graphic','helios.graphic','Nguyen Hoang Duong','NC2-A Khu &#273;� th&#7883; C&#7847;u B&#432;&#417;u','0123456789','2022-11-03','hoangduong212121photo5@gmail.com');
/*!40000 ALTER TABLE `tblmember` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblorder`
--

DROP TABLE IF EXISTS `tblorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblorder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `payment_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `payment_date` date DEFAULT NULL,
  `cancel_date` date DEFAULT NULL,
  `delivery_date` date DEFAULT NULL,
  `reason_cancel` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status_delivery` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status_order` varchar(255) COLLATE utf8_bin NOT NULL,
  `note` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `tbl_customerid` int DEFAULT NULL,
  `tbl_shipperid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblorder`
--

LOCK TABLES `tblorder` WRITE;
/*!40000 ALTER TABLE `tblorder` DISABLE KEYS */;
INSERT INTO `tblorder` VALUES (1,'online','2022-01-01','2022-01-01',NULL,'2022-01-04',NULL,'delivered','bill',NULL,1,3),(5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'order',NULL,29,5),(6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'cart',NULL,1,NULL),(7,'online','2022-01-05','2022-01-05',NULL,NULL,NULL,'delivering','bill',NULL,29,6),(8,'online','2022-11-12','2022-11-12','2022-11-22',NULL,'Khong nghe may','cancel','bill',NULL,29,3),(9,'online','2022-11-15','2022-11-15','2022-11-16',NULL,'Khong nhan hang','cancel','bill',NULL,29,NULL),(10,'online','2022-11-15','2022-11-15',NULL,NULL,NULL,'delivered','bill',NULL,29,3),(11,'online','2022-11-15','2022-11-15',NULL,NULL,NULL,'delivering','bill',NULL,29,2),(12,NULL,'2022-11-15',NULL,NULL,NULL,NULL,NULL,'waitingforpayment',NULL,29,NULL),(13,'online','2022-11-15','2022-11-15',NULL,NULL,NULL,'delivering','bill',NULL,29,3),(14,'online','2022-11-15','2022-11-15',NULL,NULL,NULL,'preparing','bill',NULL,35,NULL),(15,'online','2022-11-15','2022-11-15',NULL,NULL,NULL,'preparing','bill',NULL,36,NULL),(16,'online','2022-11-15','2022-11-15',NULL,NULL,NULL,'delivered','bill',NULL,29,3),(17,'online','2022-11-22','2022-11-22',NULL,NULL,NULL,'preparing','bill',NULL,29,NULL),(18,'online','2023-02-03','2023-02-03',NULL,NULL,NULL,'preparing','bill',NULL,29,NULL),(19,NULL,'2023-03-24',NULL,NULL,NULL,NULL,NULL,'order',NULL,29,NULL);
/*!40000 ALTER TABLE `tblorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblorderdetail`
--

DROP TABLE IF EXISTS `tblorderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblorderdetail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `price` float NOT NULL,
  `tbl_productid` int NOT NULL,
  `tbl_orderid` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblorderdetail`
--

LOCK TABLES `tblorderdetail` WRITE;
/*!40000 ALTER TABLE `tblorderdetail` DISABLE KEYS */;
INSERT INTO `tblorderdetail` VALUES (1,1,100,1,1),(12,9,100,1,5),(14,2,100,2,5),(15,3,100,1,7),(16,1,100,2,7),(17,1,100,1,8),(18,3,100,1,9),(19,3,100,2,10),(21,1,100,1,10),(22,2,100,1,11),(23,2,100,1,12),(25,2,100,2,13),(26,1,100,2,9),(28,2,100,1,14),(29,3,100,1,15),(31,3,100,1,16),(32,3,100,1,17),(33,3,100,1,18),(34,1,100,1,19),(35,1,100,1,6);
/*!40000 ALTER TABLE `tblorderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblpaymentcard`
--

DROP TABLE IF EXISTS `tblpaymentcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblpaymentcard` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cardNumber` varchar(45) COLLATE utf8_bin NOT NULL,
  `cardCVV` varchar(45) COLLATE utf8_bin NOT NULL,
  `cardName` varchar(45) COLLATE utf8_bin NOT NULL,
  `cardOutDate` date NOT NULL,
  `card_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `card_number` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `card_out_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblpaymentcard`
--

LOCK TABLES `tblpaymentcard` WRITE;
/*!40000 ALTER TABLE `tblpaymentcard` DISABLE KEYS */;
INSERT INTO `tblpaymentcard` VALUES (1,'123456789','123','NGUYEN HOANG DUONG','2025-01-01',NULL,NULL,NULL),(29,'215645452315615','123','NGUYEN HOANG DUONG','2022-10-06',NULL,NULL,NULL),(30,'123456789','123','NGUYEN VAN A','2022-11-10',NULL,NULL,NULL),(31,'123456789','123','NGUYEN VAN A','2022-11-25',NULL,NULL,NULL),(32,'12345789','235','NGUYEN VAN A','2022-11-17',NULL,NULL,NULL),(33,'123456789','123','NGUYEN VAN A','2022-11-16',NULL,NULL,NULL),(34,'3545345345','123','Nguyen Hoang Duong','2022-11-10',NULL,NULL,NULL),(35,'1234568223','123','NGUYEN VAN A','2022-11-03',NULL,NULL,NULL),(36,'545465','123','NGUYEN VAN A','2022-11-09',NULL,NULL,NULL),(37,'152364','123','NGUYEN VAN A','2022-11-02',NULL,NULL,NULL),(38,'123642566','123','NGUYEN VAN A','2022-11-22',NULL,NULL,NULL);
/*!40000 ALTER TABLE `tblpaymentcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblproduct`
--

DROP TABLE IF EXISTS `tblproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblproduct` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `img` varchar(255) COLLATE utf8_bin NOT NULL,
  `price` float NOT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `color` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `mfgDate` date DEFAULT NULL,
  `expDate` date DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `tblWareHouseid` int NOT NULL,
  `exp_date` date DEFAULT NULL,
  `mfg_date` date DEFAULT NULL,
  `tbl_ware_houseid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblproduct`
--

LOCK TABLES `tblproduct` WRITE;
/*!40000 ALTER TABLE `tblproduct` DISABLE KEYS */;
INSERT INTO `tblproduct` VALUES (1,'Nike 1 \'071','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/aee23c65-5ed1-4a07-aeff-180b2ad74c00/air-force-1-07-shoe-NMmm1B.png',100,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.','white',NULL,NULL,10,3,NULL,NULL,NULL),(2,'Nike Air 1','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f094af40-f82f-4fb9-a246-e031bf6fc411/air-force-1-07-shoe-NMmm1B.png',100,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.','white',NULL,NULL,10,3,NULL,NULL,NULL),(3,'Nike Air 3','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f094af40-f82f-4fb9-a246-e031bf6fc411/air-force-1-07-shoe-NMmm1B.png',100,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.','white',NULL,NULL,10,3,NULL,NULL,NULL),(4,'Nike Air 4','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f094af40-f82f-4fb9-a246-e031bf6fc411/air-force-1-07-shoe-NMmm1B.png',100,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.','white',NULL,NULL,10,3,NULL,NULL,NULL),(5,'Nike Air 5','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f094af40-f82f-4fb9-a246-e031bf6fc411/air-force-1-07-shoe-NMmm1B.png',100,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.','white',NULL,NULL,10,3,NULL,NULL,NULL),(6,'Nike Air 6','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f094af40-f82f-4fb9-a246-e031bf6fc411/air-force-1-07-shoe-NMmm1B.png',100,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.','white',NULL,NULL,10,3,NULL,NULL,NULL),(7,'Nike Air 7','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f094af40-f82f-4fb9-a246-e031bf6fc411/air-force-1-07-shoe-NMmm1B.png',100,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.','white',NULL,NULL,10,3,NULL,NULL,NULL),(8,'Nike Air 8','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f094af40-f82f-4fb9-a246-e031bf6fc411/air-force-1-07-shoe-NMmm1B.png',100,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.','white',NULL,NULL,10,3,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tblproduct` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-08  0:04:15
