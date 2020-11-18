-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pd
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `leaveform`
--

DROP TABLE IF EXISTS `leaveform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leaveform` (
  `id` varchar(10) NOT NULL,
  `createTime` date DEFAULT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `reason` varchar(30) DEFAULT NULL,
  `modifyDate` date DEFAULT NULL,
  `state` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leaveform`
--

LOCK TABLES `leaveform` WRITE;
/*!40000 ALTER TABLE `leaveform` DISABLE KEYS */;
INSERT INTO `leaveform` VALUES ('234','2020-11-16','gch','2343','2020-11-16',2),('235','2020-11-16','jcl','1232','2020-11-16',1),('45','2020-11-16','gch','123','2020-11-16',2),('87','2020-11-16','gch','12312','2020-11-16',2);
/*!40000 ALTER TABLE `leaveform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offdocform`
--

DROP TABLE IF EXISTS `offdocform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offdocform` (
  `id` varchar(10) NOT NULL,
  `createTime` date DEFAULT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `reason` varchar(20) DEFAULT NULL,
  `modifyDate` date DEFAULT NULL,
  `Sstate` int(11) DEFAULT NULL,
  `Astate` int(11) DEFAULT NULL,
  `Bstate` int(11) DEFAULT NULL,
  `Cstate` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offdocform`
--

LOCK TABLES `offdocform` WRITE;
/*!40000 ALTER TABLE `offdocform` DISABLE KEYS */;
INSERT INTO `offdocform` VALUES ('3001','2020-11-16','lys','food','2020-11-16',3,0,0,0),('3002','2020-11-16','wy','food','2020-11-16',1,0,0,0);
/*!40000 ALTER TABLE `offdocform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offdocstaff`
--

DROP TABLE IF EXISTS `offdocstaff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offdocstaff` (
  `id` varchar(20) NOT NULL,
  `staName` varchar(20) DEFAULT NULL,
  `post` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offdocstaff`
--

LOCK TABLES `offdocstaff` WRITE;
/*!40000 ALTER TABLE `offdocstaff` DISABLE KEYS */;
INSERT INTO `offdocstaff` VALUES ('301','lys',0),('302','aadmin',1),('303','badmin',2),('304','cadmin',3),('305','sadmin',4);
/*!40000 ALTER TABLE `offdocstaff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reimform`
--

DROP TABLE IF EXISTS `reimform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reimform` (
  `id` varchar(10) NOT NULL,
  `money` int(11) DEFAULT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `reason` varchar(20) DEFAULT NULL,
  `modifyDate` date DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reimform`
--

LOCK TABLES `reimform` WRITE;
/*!40000 ALTER TABLE `reimform` DISABLE KEYS */;
INSERT INTO `reimform` VALUES ('100007',80,'frans','god','2020-11-16',1,'2020-11-15'),('100008',80,'frans','god','2020-11-15',0,'2020-11-15'),('100009',80,'frans','god','2020-11-15',0,'2020-11-15'),('10001',233,'frans','word','2020-11-16',1,'2020-11-15'),('100010',200,'frans','guess','2020-11-15',-1,'2020-11-15'),('123456',888,'frans','work','2020-11-16',0,'2020-11-16');
/*!40000 ALTER TABLE `reimform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reimstaff`
--

DROP TABLE IF EXISTS `reimstaff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reimstaff` (
  `id` varchar(20) NOT NULL,
  `staName` varchar(20) DEFAULT NULL,
  `staGender` varchar(10) DEFAULT NULL,
  `staAge` int(11) DEFAULT NULL,
  `post` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reimstaff`
--

LOCK TABLES `reimstaff` WRITE;
/*!40000 ALTER TABLE `reimstaff` DISABLE KEYS */;
INSERT INTO `reimstaff` VALUES ('1002','frans','male',19,0),('1005','staff2','female',30,1),('1006','staff3','female',20,2);
/*!40000 ALTER TABLE `reimstaff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teastu`
--

DROP TABLE IF EXISTS `teastu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teastu` (
  `id` varchar(10) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `post` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teastu`
--

LOCK TABLES `teastu` WRITE;
/*!40000 ALTER TABLE `teastu` DISABLE KEYS */;
INSERT INTO `teastu` VALUES ('1007','gch',0),('1900','whk',1),('1901','jgl',2);
/*!40000 ALTER TABLE `teastu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(20) NOT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `userPassword` varchar(20) DEFAULT NULL,
  `identity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1001','admin','123456',0),('1002','frans','123456',1),('1005','staff2','123456',1),('1006','staff3','123456',1),('1007','gch','123456',1),('1900','whk','123456',1),('1901','jgl','123456',1),('3001','lys','123456',1);
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

-- Dump completed on 2020-11-17 11:30:35
