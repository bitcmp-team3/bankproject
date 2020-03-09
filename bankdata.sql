-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: bank
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL,
  `accNo` varchar(45) COLLATE utf8_bin NOT NULL,
  `amount` decimal(20,0) NOT NULL,
  `type` varchar(20) COLLATE utf8_bin NOT NULL,
  `date` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`accNo`),
  KEY `fk01` (`id`),
  CONSTRAINT `fk01` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('ha1234','110-000-0001',100000,'자유저축',NULL),('ha1234','110-000-0022',5000000,'적금',NULL),('ha1234','110-000-0123',50000000,'대출',NULL),('ha1234','110-000-1',30000000,'Savings','2020-03-09'),('ha1234','110-000-3',45612,'Savings','2020-03-02'),('bo1234','110-123-1234',700000,'자유저축',NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `transNo` varchar(20) COLLATE utf8_bin NOT NULL,
  `accNo` varchar(45) COLLATE utf8_bin NOT NULL,
  `amount` decimal(20,0) NOT NULL,
  `date` date NOT NULL,
  `deposit` decimal(20,0) DEFAULT NULL,
  `withdraw` decimal(20,0) DEFAULT NULL,
  PRIMARY KEY (`transNo`),
  KEY `fk02` (`accNo`),
  CONSTRAINT `fk02` FOREIGN KEY (`accNo`) REFERENCES `account` (`accNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES ('1','110-000-0001',300000,'2020-01-01',NULL,100000),('2','110-000-0001',250000,'2020-01-01',NULL,50000),('3','110-000-0001',150000,'2020-01-05',NULL,100000),('4','110-000-0001',100000,'2020-01-10',NULL,50000);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL,
  `pw` varchar(45) COLLATE utf8_bin NOT NULL,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  `birthday` date NOT NULL,
  `phoneNo` varchar(20) COLLATE utf8_bin NOT NULL,
  `addr` varchar(100) COLLATE utf8_bin NOT NULL,
  `userNo` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `phoneNo_UNIQUE` (`phoneNo`),
  UNIQUE KEY `userNo_UNIQUE` (`userNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('bo1234','1234','김하현','1992-01-01','010-1324-1234','경기','0002'),('ha1234','1234','진보형','1993-11-12','010-0000-0000','인천','1234'),('kim123','1234','xx','1993-04-01','010-0000-1500','김포시dddd','No21993-04-01'),('oleg1234','1234','올레그','1993-04-06','010-0000-1234','인천','No11993-04-06');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-09 11:10:28
