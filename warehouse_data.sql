-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: warehouse
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `data`
--

DROP TABLE IF EXISTS `data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `maleOrfemal` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `asset` decimal(10,3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data`
--

LOCK TABLES `data` WRITE;
/*!40000 ALTER TABLE `data` DISABLE KEYS */;
INSERT INTO `data` VALUES (4,'Phạm Nhật Vượng','Male',52,'Hà Tĩnh',186.079),(5,'Nguyễn Thị Phương Thảo','Female',50,'Hà Nội',23.927),(6,'Trần Đình Long','Male',59,'Hải Dương',19.075),(7,'Hồ Hùng Anh','Male',50,'Thừa Thiên Huế',16.111),(8,'Nguyễn Đăng Quang','Male',57,'Hà Nội',15.785),(9,'Phạm Thu Hương','Female',51,'Hà Nội',14.668),(10,'Bùi Thành Nhơn','Male',62,'Hải Dương',11.515),(11,'Phạm Thúy Hằng','Female',46,'Hà Nội',9.796),(12,'Hồ Xuân Năng','Male',56,'Nam Định',8.104),(13,'Nguyễn Đức Tài','Male',51,'Nam Định',5.472),(14,'Nguyễn Văn Đạt','Male',50,'Quảng Ngãi',4.919),(15,'Đỗ Hữu Hạ','Male',65,'Hải Phòng',3.582),(16,'Trần Lê Quân','Male',60,'Quảng Nam',3.327),(17,'Trương Thị Lệ Khanh','Female',59,'An Giang',2.770),(18,'Nguyễn Hoàng Yến','Female',57,'Hà Nam',2.672),(19,'Trương Gia Bình','Male',64,'Đà Nẵng',2.352),(20,'Trần Tuấn Dương','Male',57,'Nam Định',2.013),(21,'Nguyễn Mạnh Tuấn','Male',58,'Hà Nội',1.979),(22,'Chu Thị Bình','Female',56,'Thái Bình',1.850),(23,'Trần Huy Thanh Tùng','Male',49,'Hà Nam',1.498);
/*!40000 ALTER TABLE `data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-01 22:27:13
