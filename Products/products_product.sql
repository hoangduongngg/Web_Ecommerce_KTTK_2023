CREATE DATABASE  IF NOT EXISTS `products` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `products`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: products
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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `img` varchar(300) DEFAULT NULL,
  `price` int NOT NULL DEFAULT '0',
  `units` int NOT NULL DEFAULT '0',
  `description` varchar(600) DEFAULT NULL,
  `expiration_date` varchar(255) NOT NULL,
  `id_supplier` int NOT NULL DEFAULT '0',
  `quantity` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idt_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (3,'Nike Air Force 1 React','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/a6bce3ef-bc25-4e3d-b45b-db8223745a49/air-force-1-react-shoes-g9MPSs.png',100,100,'From hoops staple to urban street legend, the Nike AF-1 React takes another step forward into shoe iconography. Amplified features from the outsole to the branding add dramatic expression to the storied look while Nike React tech assists with a smooth ride. Stand out to fit in.','6 tháng',0,100),(4,'Nike Air Huarache','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/3306d0ec-5d7c-4d2e-9d09-543f41e478b0/air-huarache-shoes-fg69qQ.png',100,100,'Built to fit your foot and designed for comfort, the Nike Air Huarache brings back a street-level favourite. Soft leather accents on the upper are mixed with super-breathable, perfectly shined neoprene-like fabric for easy styling. The low-cut collar and bootie-like construction keep it sleek. Its iconic heel clip and stripped away branding keep the early-90s look you love.','3 tháng',0,100),(5,'Nike Air Presto','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/08e369ae-fa2f-4097-9b46-d226428c1738/air-presto-shoes-QdhgZW.png',100,100,'With a sleek design that\'s more comfortable than your favourite T-shirt, the Nike Air Presto is made to feel good and look fast. Its stretchy sleeve creates a cosy, sock-like fit while the super-soft foam adds spring to your step. Put them on and you\'ll never want to take them off.','10 tháng',0,100),(6,'Nike Free Run 5.0','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/3b27eb2b-da90-4a12-bb43-a093ca26b4a3/free-run-5-road-running-shoes-m8L9mr.png',100,100,'Made from at least 20% recycled material by weight, the sock-like boot of this Nike Free is designed to transition from running to training to your everyday routine. With a breathable knit upper, it combines the flexibility you love with a secure design that will help keep you close to the ground for that barefoot feeling. New cushioning is lighter, softer and more responsive than previous versions so you can keep moving in comfort whether you\'re on the tarmac or track.','1 năm',0,100),(7,'Nike Revolution 6','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/7df57edf-bdc6-4320-a956-8ce37228cd1d/revolution-6-road-running-shoes-NC0P7k.png',100,1000,'Là loại nước ngọt được nhiều người yêu thích đến từ thương hiệu nước ngọt Pepsi nổi tiếng thế giớivới hương vị thơm ngon, sảng khoái. 6 lon nước ngọt Pepsi không calo lon 320ml với lượng gas lớn sẽ giúp bạn xua tan mọi cảm giác mệt mỏi, căng thẳng, sản phẩm không calo lành mạnh, tốt cho sức khỏe','2 tháng',0,1000),(8,'Nike Revolution 6 FlyEase','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/4144c92b-0558-448c-aaa1-31f475a45b9f/revolution-6-flyease-easy-on-off-road-running-shoes-XvR99K.png',100,1000,'Here\'s to new beginnings between you and the pavement. We know comfort is key to a successful run, so we made sure your steps are cushioned and flexible for a soft ride. A strap and wraparound zip makes these shoes super-easy to get on and off. It\'s an evolution of a favourite, with a breathable design made with at least 20% recycled content by weight.','4 tháng',0,100),(9,'Nike City Rep TR','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/a917d6ad-3b8a-4c89-93fd-6751aeb8801e/city-rep-tr-training-shoes-djC0DF.png',100,1000,'The Nike City Rep TR is a versatile shoe that brings durability and flexibility to your active urban lifestyle. Rubber tread gives you grip on a range of surfaces, while foam cushioning keeps your foot comfortable—during outdoor workouts and through the rest of your day.','7 tháng',0,100),(10,'Nike MC Trainer','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/3e85cebb-b631-4c33-9fd6-dc13eae442d4/mc-trainer-training-shoe-T9vmbZ.png',100,100,'The Nike MC Trainer helps you transition from heavy lifting in the weight room to agility drills on the turf without skipping a beat. It packs stability, durability and flexibility into a versatile design that supports all the ways you move while you train for your sport.','4 tháng',0,100),(11,'Nike SuperRep Go 3 Next Nature Flyknit','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/029cab7f-8f28-4a33-b09c-536a47607f03/superrep-go-3-next-nature-flyknit-training-shoes-mxKptW.png',100,100,'The new Nike SuperRep Go 3 Flyknit Shoe is a radical design story rooted in sustainability and innovation. The zoned Flyknit construction wraps your foot in 360 degrees of comfort and support. A finely ground, reclaimed foam midsole gives you responsive cushioning for high-impact training. The lightweight, packable design lets you keep them close, no matter where your next workout takes you.','7 tháng',0,100),(12,'Nike Zoom Metcon Turbo 2','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/d646b481-eece-4618-83b6-2aef6bb85047/zoom-metcon-turbo-2-training-shoes-jPvmwl.png',100,100,'The Nike Zoom Metcon Turbo 2 puts a shot of adrenalizing speed into your everyday workout. It combines stability and responsiveness in a lightweight package to help you move quickly during circuit training, high-intensity intervals on the treadmill, a cardio workout you\'ve squeezed in on the way home—whatever you choose. From the Zoom Air cushioning underfoot to the rope wrap at the instep, every detail is pared down to minimise weight while maximising function and durability. Lighter, stronger materials are built for speed and strength.','2 năm',0,100),(14,'Nike Metcon 8','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/4f34abbb-70df-44bf-8cad-137cca108d49/metcon-8-training-shoes-p9rQzn.png',100,10,'You chase the clock, challenging and encouraging each other all in the name of achieving goals and making gains. Our go-to model for training relies on a lighter, more breathable upper than our previous edition to complement our standards of durability and comfort, so that you can float through your cardio, power through your lifts and dominate your workouts.','1 năm',0,10),(26,'Nike Metcon 8 AMP','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/8f11d52e-2a1e-4e8b-afd1-0eadf8341d00/metcon-8-amp-training-shoes-KkzKHZ.png',100,100,'We\'re here to help get you moving! Regardless of whether your pace is snail-like or lickety-split, the Nike Metcon 8 AMP helps keep you on the go. Expressive, playful graphics remind your fun can be found in every workout, no matter how tough. The upper is lighter and more breathable than our previous edition to complement our standards of durability and comfort so that you can float through your cardio and power through your lifts. So go ahead, put 1 foot in front of the other, we\'ve got you, from your friends at the Moving Co.','1 năm',0,100),(58,'Nike Metcon 8 Premium','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/63e4acc1-d963-4231-907f-e3243e19b2fd/metcon-8-training-shoes-DNz7Sg.png',100,100,'You chase the clock, challenging and encouraging each other all in the name of achieving goals and making gains. Our go-to model for training relies on a lighter, more breathable upper than our previous iteration to complement our standards of durability and comfort, so that you can float through your cardio, power through your lifts and dominate your workouts.','39 ngày',0,100),(66,'Nike Free Metcon 4 Premium','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/5f896a2b-5f33-4552-9780-a84f991447d2/free-metcon-4-training-shoes-WK9VZ7.png',100,100,'The Nike Free Metcon 4 Premium combines flexibility with stability to help you get the most out of your training programme. Updated \"chain-link\" mesh cools and flexes as you speed through agility drills, while support at the midfoot and heel braces you for your heaviest sets in the weight room.','10 tháng',0,100);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-17 11:19:30
