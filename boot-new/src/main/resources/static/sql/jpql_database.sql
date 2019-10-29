CREATE DATABASE  IF NOT EXISTS `jpa` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `jpa`;
-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: jpa
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'New York','NY','123 Apple Tree Cr.','10001'),(2,'Manhattan','NY','654 Stanton Way.','10003'),(3,'New York','NY','99 Queen St.','10001'),(4,'Redwood Shores','CA','445 McDonell Cr.','90123'),(5,'San Jose','CA','624 Hamilton Dr.','90123'),(6,'San Jose','CA','724 Coventry Rd.','90123'),(7,'San Francisco','CA','77 Manchester Blvd.','90123'),(8,'Moorestown','NJ','53 King St.','08057'),(9,'New York','NY','14 Industrial Ave.','10001'),(10,'Redwood Shores','CA','777 High Tech Ln.','90123');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `album` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `SINGER_ID` bigint(20) NOT NULL,
  `TITLE` varchar(100) NOT NULL,
  `RELEASE_DATE` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UQ_SINGER_ALBUM_1` (`SINGER_ID`,`TITLE`),
  CONSTRAINT `singer_id_foreign_key` FOREIGN KEY (`SINGER_ID`) REFERENCES `singer` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` VALUES (3,2,' From The Cradle ','1994-09-13'),(4,6,'The Beatles','1968-01-01'),(5,7,'Abbey Road','1969-01-01');
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Engineering'),(2,'QA'),(3,'Accounting'),(4,'CAEngOtt'),(5,'USEngCal'),(6,'CADocOtt'),(7,'QA_East'),(8,'QANorth');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `salary` bigint(20) DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `manager_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'John',60000,'2001-01-01',1,2,9),(2,'Rob',53000,'2001-05-23',2,2,9),(3,'Peter',40000,'2002-08-06',3,2,9),(4,'Frank',41000,'2003-02-17',4,1,10),(5,'Scott',60000,'2004-11-14',5,1,10),(6,'Sue',62000,'2005-08-18',6,1,10),(7,'Stephanie',54000,'2006-06-07',7,1,10),(8,'Jennifer',45000,'1999-08-11',8,1,NULL),(9,'Sarah',52000,'2002-04-26',9,2,10),(10,'Joan',59000,'2003-04-16',10,1,NULL),(11,'Marcus',35000,'1995-07-22',NULL,NULL,NULL),(12,'Joe',36000,'1995-07-22',NULL,3,11),(13,'Jack',43000,'1995-07-22',NULL,3,NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone`
--

DROP TABLE IF EXISTS `phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone` (
  `id` bigint(20) NOT NULL,
  `NUMBER` varchar(255) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
INSERT INTO `phone` VALUES (1,'(212)555-1234','Office',1),(2,'(212)555-9843','Home',1),(3,'(315)555-6253','Office',2),(4,'(516)555-9837','Office',3),(5,'(516)555-2034','Cell',3),(6,'(650)555-7583','Office',4),(7,'(650)555-5345','Home',4),(8,'(650)555-9386','Office',5),(9,'(650)555-4885','Cell',5),(10,'(650)555-3836','Office',6),(11,'(650)555-0985','Home',6),(12,'(650)555-1946','Cell',6),(13,'(650)555-4759','Office',7),(14,'(650)555-4757','Home',7),(15,'(650)555-6753','Office',8),(16,'(585)555-0693','Office',9),(17,'(585)555-3098','Home',9),(18,'(585)555-1457','Cell',9),(19,'(650)555-9838','Office',10),(20,'(650)555-2346','Home',10),(21,'(650)555-9874','Cell',10);
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `id` int(11) NOT NULL,
  `dtype` varchar(31) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `qa_rating` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'P','Implement Release1',NULL),(2,'P','Implement Release2',NULL),(3,'DP','Design Release1',NULL),(4,'DP','Design Release2',NULL),(5,'DP','Design Release3',NULL),(6,'QP','Test Release1',4),(7,'QP','Test Release2',5),(8,'QP','Test Release3',5),(9,'P','Implement Release3',NULL);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_employee`
--

DROP TABLE IF EXISTS `project_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_employee` (
  `employees_id` int(11) DEFAULT NULL,
  `projects_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_employee`
--

LOCK TABLES `project_employee` WRITE;
/*!40000 ALTER TABLE `project_employee` DISABLE KEYS */;
INSERT INTO `project_employee` VALUES (1,1),(2,2),(2,3),(3,1),(3,2),(3,3),(4,1),(5,2),(5,3),(6,1),(6,2),(7,7),(8,8),(8,2),(9,3),(9,9),(10,7),(10,8),(10,9),(10,9);
/*!40000 ALTER TABLE `project_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `singer`
--

DROP TABLE IF EXISTS `singer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `singer` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(60) NOT NULL,
  `LAST_NAME` varchar(40) NOT NULL,
  `BIRTH_DATE` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UQ_SINGER_1` (`FIRST_NAME`,`LAST_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `singer`
--

LOCK TABLES `singer` WRITE;
/*!40000 ALTER TABLE `singer` DISABLE KEYS */;
INSERT INTO `singer` VALUES (2,'MisterMisterMisterMisterMisterMisterMisterMisterMisterMister','Clapton','1945-03-30'),(3,'John','Butler','1975-04-01'),(6,'John','Lennon','1940-10-09'),(7,'Mister','Starr','1940-07-07'),(9,'Elvis','Presley','1942-10-12'),(10,'Elton','John','1941-10-12'),(11,'Ion','Dolanescu','1940-10-09');
/*!40000 ALTER TABLE `singer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-29 10:16:54
