-- MySQL dump 10.10
--
-- Host: localhost    Database: niru
-- ------------------------------------------------------
-- Server version	5.0.18-nt

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
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `pass` varchar(15) default NULL,
  `privillage` varchar(7) default NULL,
  `uname` varchar(50) NOT NULL,
  PRIMARY KEY  (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--


/*!40000 ALTER TABLE `login` DISABLE KEYS */;
LOCK TABLES `login` WRITE;
INSERT INTO `login` VALUES ('kannan','ttttt','nimu'),('nishi','tffff','nishi');
UNLOCK TABLES;
/*!40000 ALTER TABLE `login` ENABLE KEYS */;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `rid` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `age` varchar(3) default NULL,
  `sex` varchar(1) default NULL,
  `phone` varchar(20) default NULL,
  `email` varchar(50) default NULL,
  PRIMARY KEY  (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `record`
--


/*!40000 ALTER TABLE `record` DISABLE KEYS */;
LOCK TABLES `record` WRITE;
INSERT INTO `record` VALUES (2,'nirmala','22','f','9349060631','nirmalababu28@yahoo.com'),(5,'nishi','22','f','1232','hhhjj@'),(6,'nimmi','22','f','1','lll'),(8,'nirmal','22','m','1234','krishna'),(9,'nini','23','f','9349060631','nn@yahoo.com'),(18,'kkkk','a','m','a','a@c.b'),(19,'dddd','12','m','1234','1@a.v');
UNLOCK TABLES;
/*!40000 ALTER TABLE `record` ENABLE KEYS */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uname` varchar(50) NOT NULL,
  `designation` varchar(50) default NULL,
  `uphone` varchar(20) default NULL,
  `uemail` varchar(50) default NULL,
  `addres` varchar(150) default NULL,
  `name` varchar(50) default NULL,
  PRIMARY KEY  (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--


/*!40000 ALTER TABLE `user` DISABLE KEYS */;
LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES ('nimu','Analyst','9349060631','nimu@gmail.com','Aynimoottil House\nEdathala .p.o\nAluva\nPin-683561','Nirmala.A.B'),('nishi','Analyst','2108590','nishi@depaul.edu.in','Koonjattu()\nPadivattom\nPalarivattom.','NishiDhannian');
UNLOCK TABLES;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

