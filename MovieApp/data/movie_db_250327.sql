-- MySQL dump 10.19  Distrib 10.3.39-MariaDB, for Linux (x86_64)
--
-- Host: 146.245.252.140    Database: huichen_db
-- ------------------------------------------------------
-- Server version	10.6.21-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `P1Address`
--

DROP TABLE IF EXISTS `P1Address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `P1Address` (
  `addressID` int(11) NOT NULL AUTO_INCREMENT,
  `street` varchar(30) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `county` varchar(30) DEFAULT NULL,
  `zip` char(5) DEFAULT NULL,
  `zip4` char(4) DEFAULT NULL,
  `type` char(1) DEFAULT NULL,
  `complex` char(1) DEFAULT NULL,
  PRIMARY KEY (`addressID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `P1Address`
--

LOCK TABLES `P1Address` WRITE;
/*!40000 ALTER TABLE `P1Address` DISABLE KEYS */;
INSERT INTO `P1Address` VALUES (1,'West Hollywood Ave',1,'Beverly Hills','Orange County','10136','1101','S','N'),(2,'East Hollywood Ave',2,'Beverly Hills','Orange County','10136','1101','S','N'),(3,'1st Street',909,'New York','New York','10003','1101','S','N');
/*!40000 ALTER TABLE `P1Address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `P1Customer`
--

DROP TABLE IF EXISTS `P1Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `P1Customer` (
  `id` char(9) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `addressID` int(11) DEFAULT NULL,
  `homephone` char(10) DEFAULT NULL,
  `cellphone` char(10) DEFAULT NULL,
  `primaryemail` varchar(60) DEFAULT NULL,
  `secondemail` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `addressID` (`addressID`),
  CONSTRAINT `P1Customer_ibfk_1` FOREIGN KEY (`addressID`) REFERENCES `P1Address` (`addressID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `P1Customer`
--

LOCK TABLES `P1Customer` WRITE;
/*!40000 ALTER TABLE `P1Customer` DISABLE KEYS */;
INSERT INTO `P1Customer` VALUES ('C12345678','Will Smith',1,'8044531234','9651231234','willsmith@willsmith.com','willsmithisstar@madeupcompany.com'),('C87654321','Jennifer Lopez',3,'1234567890','9876543210','jlo@jlo.com','jlo2@ljo.com');
/*!40000 ALTER TABLE `P1Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `P1CustomerLogin`
--

DROP TABLE IF EXISTS `P1CustomerLogin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `P1CustomerLogin` (
  `username` varchar(20) NOT NULL,
  `customerid` char(9) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  `expiry` date DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `customerid` (`customerid`),
  CONSTRAINT `P1CustomerLogin_ibfk_1` FOREIGN KEY (`customerid`) REFERENCES `P1Customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `P1CustomerLogin`
--

LOCK TABLES `P1CustomerLogin` WRITE;
/*!40000 ALTER TABLE `P1CustomerLogin` DISABLE KEYS */;
/*!40000 ALTER TABLE `P1CustomerLogin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `P1Item`
--

DROP TABLE IF EXISTS `P1Item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `P1Item` (
  `itemnum` char(8) NOT NULL,
  `mediatype` varchar(10) DEFAULT NULL,
  `movietitle` varchar(60) DEFAULT NULL,
  `movieyear` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `price` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`itemnum`),
  KEY `movietitle` (`movietitle`,`movieyear`),
  CONSTRAINT `P1Item_ibfk_1` FOREIGN KEY (`movietitle`, `movieyear`) REFERENCES `P1Movie` (`title`, `year`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `P1Item`
--

LOCK TABLES `P1Item` WRITE;
/*!40000 ALTER TABLE `P1Item` DISABLE KEYS */;
INSERT INTO `P1Item` VALUES ('11223344','Bluray','Men in Black',1997,84,9.99),('13223366','Bluray','Men in Black II',2002,118,4.99),('13223367','DVD','Men in Black II',2002,117,2.99);
/*!40000 ALTER TABLE `P1Item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `P1Movie`
--

DROP TABLE IF EXISTS `P1Movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `P1Movie` (
  `title` varchar(80) NOT NULL,
  `year` int(11) NOT NULL,
  `length` int(11) DEFAULT NULL,
  `genre` char(2) DEFAULT NULL,
  `studioName` varchar(60) DEFAULT NULL,
  `producercnum` char(9) DEFAULT NULL,
  PRIMARY KEY (`title`,`year`),
  KEY `studioName` (`studioName`),
  KEY `producercnum` (`producercnum`),
  CONSTRAINT `P1Movie_ibfk_1` FOREIGN KEY (`studioName`) REFERENCES `P1Studio` (`name`),
  CONSTRAINT `P1Movie_ibfk_2` FOREIGN KEY (`producercnum`) REFERENCES `P1MovieExec` (`certnum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `P1Movie`
--

LOCK TABLES `P1Movie` WRITE;
/*!40000 ALTER TABLE `P1Movie` DISABLE KEYS */;
INSERT INTO `P1Movie` VALUES ('Men in Black',1997,98,'CO','Amblin Entertainment','123412342'),('Men in Black II',2002,89,'CO','Amblin Entertainment','123412342');
/*!40000 ALTER TABLE `P1Movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `P1MovieExec`
--

DROP TABLE IF EXISTS `P1MovieExec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `P1MovieExec` (
  `certnum` char(9) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `addressID` int(11) DEFAULT NULL,
  `netWorth` decimal(16,0) DEFAULT NULL,
  PRIMARY KEY (`certnum`),
  KEY `addressID` (`addressID`),
  CONSTRAINT `P1MovieExec_ibfk_1` FOREIGN KEY (`addressID`) REFERENCES `P1Address` (`addressID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `P1MovieExec`
--

LOCK TABLES `P1MovieExec` WRITE;
/*!40000 ALTER TABLE `P1MovieExec` DISABLE KEYS */;
INSERT INTO `P1MovieExec` VALUES ('123412341','Will Smith',1,100000000),('123412342','Steven Spielberg',2,100000000);
/*!40000 ALTER TABLE `P1MovieExec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `P1MovieStar`
--

DROP TABLE IF EXISTS `P1MovieStar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `P1MovieStar` (
  `name` varchar(60) NOT NULL,
  `addressID` int(11) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  PRIMARY KEY (`name`),
  KEY `addressID` (`addressID`),
  CONSTRAINT `P1MovieStar_ibfk_1` FOREIGN KEY (`addressID`) REFERENCES `P1Address` (`addressID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `P1MovieStar`
--

LOCK TABLES `P1MovieStar` WRITE;
/*!40000 ALTER TABLE `P1MovieStar` DISABLE KEYS */;
INSERT INTO `P1MovieStar` VALUES ('Will Smith',1,'M','1968-09-25');
/*!40000 ALTER TABLE `P1MovieStar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `P1StarsIn`
--

DROP TABLE IF EXISTS `P1StarsIn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `P1StarsIn` (
  `starname` varchar(60) NOT NULL,
  `movietitle` varchar(60) NOT NULL,
  `movieyear` int(11) NOT NULL,
  PRIMARY KEY (`starname`,`movietitle`,`movieyear`),
  KEY `movietitle` (`movietitle`,`movieyear`),
  CONSTRAINT `P1StarsIn_ibfk_1` FOREIGN KEY (`movietitle`, `movieyear`) REFERENCES `P1Movie` (`title`, `year`),
  CONSTRAINT `P1StarsIn_ibfk_2` FOREIGN KEY (`starname`) REFERENCES `P1MovieStar` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `P1StarsIn`
--

LOCK TABLES `P1StarsIn` WRITE;
/*!40000 ALTER TABLE `P1StarsIn` DISABLE KEYS */;
INSERT INTO `P1StarsIn` VALUES ('Will Smith','Men in Black',1997),('Will Smith','Men in Black II',2002);
/*!40000 ALTER TABLE `P1StarsIn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `P1Store`
--

DROP TABLE IF EXISTS `P1Store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `P1Store` (
  `storeno` char(6) NOT NULL,
  `transno` char(9) DEFAULT NULL,
  PRIMARY KEY (`storeno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `P1Store`
--

LOCK TABLES `P1Store` WRITE;
/*!40000 ALTER TABLE `P1Store` DISABLE KEYS */;
INSERT INTO `P1Store` VALUES ('100001','000000009');
/*!40000 ALTER TABLE `P1Store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `P1Studio`
--

DROP TABLE IF EXISTS `P1Studio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `P1Studio` (
  `name` varchar(60) NOT NULL,
  `prescnum` char(9) DEFAULT NULL,
  `addressID` int(11) DEFAULT NULL,
  PRIMARY KEY (`name`),
  KEY `prescnum` (`prescnum`),
  KEY `addressID` (`addressID`),
  CONSTRAINT `P1Studio_ibfk_1` FOREIGN KEY (`prescnum`) REFERENCES `P1MovieExec` (`certnum`),
  CONSTRAINT `P1Studio_ibfk_2` FOREIGN KEY (`addressID`) REFERENCES `P1Address` (`addressID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `P1Studio`
--

LOCK TABLES `P1Studio` WRITE;
/*!40000 ALTER TABLE `P1Studio` DISABLE KEYS */;
INSERT INTO `P1Studio` VALUES ('Amblin Entertainment','123412342',2);
/*!40000 ALTER TABLE `P1Studio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `P1Transaction`
--

DROP TABLE IF EXISTS `P1Transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `P1Transaction` (
  `transno` char(9) NOT NULL,
  `custid` char(9) DEFAULT NULL,
  `transdate` date NOT NULL,
  `transtime` time DEFAULT NULL,
  `price` decimal(9,2) DEFAULT NULL,
  `tax1` decimal(9,2) DEFAULT NULL,
  `tax2` decimal(9,2) DEFAULT NULL,
  `tax3` decimal(9,2) DEFAULT NULL,
  `tax4` decimal(9,2) DEFAULT NULL,
  `tax1rate` decimal(6,3) DEFAULT NULL,
  `tax2rate` decimal(6,3) DEFAULT NULL,
  `tax3rate` decimal(6,3) DEFAULT NULL,
  `tax4rate` decimal(6,3) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`transno`,`transdate`),
  KEY `custid` (`custid`),
  CONSTRAINT `P1Transaction_ibfk_1` FOREIGN KEY (`custid`) REFERENCES `P1Customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `P1Transaction`
--

LOCK TABLES `P1Transaction` WRITE;
/*!40000 ALTER TABLE `P1Transaction` DISABLE KEYS */;
INSERT INTO `P1Transaction` VALUES ('000000001','C12345678','2025-03-26','09:39:36',9.99,0.00,0.00,0.00,0.00,0.000,0.000,0.000,0.000,9.99),('000000002','C12345678','2025-03-26','09:41:14',4.99,0.00,0.00,0.00,0.00,0.000,0.000,0.000,0.000,4.99),('000000003','C12345678','2025-03-26','10:09:58',4.99,0.00,0.00,0.00,0.00,0.000,0.000,0.000,0.000,4.99),('000000004','C12345678','2025-03-26','10:13:46',2.99,0.00,0.00,0.00,0.00,0.000,0.000,0.000,0.000,2.99),('000000005','C12345678','2025-03-26','14:02:31',24.95,1.37,0.00,0.00,0.00,5.500,0.000,0.000,0.000,26.32),('000000006','C12345678','2025-03-26','15:49:56',17.97,0.00,0.00,0.00,0.00,0.000,0.000,0.000,0.000,17.97),('000000007','C12345678','2025-03-26','16:00:08',20.96,0.00,0.00,0.00,0.00,0.000,0.000,0.000,0.000,20.96),('000000008','C12345678','2025-03-26','16:06:57',4.99,0.00,0.00,0.00,0.00,0.000,0.000,0.000,0.000,4.99),('000000009','C87654321','2025-03-27','00:19:50',5.98,0.00,0.00,0.00,0.00,0.000,0.000,0.000,0.000,5.98);
/*!40000 ALTER TABLE `P1Transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `P1TransactionDetail`
--

DROP TABLE IF EXISTS `P1TransactionDetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `P1TransactionDetail` (
  `transno` char(9) NOT NULL,
  `transdate` date NOT NULL,
  `itemnum` char(8) NOT NULL,
  `itemprice` decimal(5,2) NOT NULL,
  `lineprice` decimal(12,2) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  PRIMARY KEY (`transno`,`transdate`,`itemnum`,`itemprice`),
  CONSTRAINT `P1TransactionDetail_ibfk_1` FOREIGN KEY (`transno`, `transdate`) REFERENCES `P1Transaction` (`transno`, `transdate`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `P1TransactionDetail`
--

LOCK TABLES `P1TransactionDetail` WRITE;
/*!40000 ALTER TABLE `P1TransactionDetail` DISABLE KEYS */;
INSERT INTO `P1TransactionDetail` VALUES ('000000001','2025-03-26','11223344',9.99,9.99,1),('000000002','2025-03-26','13223366',4.99,4.99,1),('000000003','2025-03-26','13223366',4.99,4.99,1),('000000004','2025-03-26','13223367',2.99,2.99,1),('000000005','2025-03-26','13223366',4.99,NULL,5),('000000006','2025-03-26','11223344',9.99,9.99,1),('000000006','2025-03-26','13223366',4.99,4.99,1),('000000006','2025-03-26','13223367',2.99,2.99,1),('000000007','2025-03-26','11223344',9.99,9.99,1),('000000007','2025-03-26','13223366',4.99,4.99,1),('000000007','2025-03-26','13223367',2.99,5.98,2),('000000008','2025-03-26','13223366',4.99,4.99,1),('000000009','2025-03-27','13223367',2.99,5.98,2);
/*!40000 ALTER TABLE `P1TransactionDetail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-27  0:21:27
