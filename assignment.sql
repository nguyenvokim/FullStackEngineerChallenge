-- MySQL dump 10.16  Distrib 10.1.37-MariaDB, for osx10.10 (x86_64)
--
-- Host: 127.0.0.1    Database: assignment
-- ------------------------------------------------------
-- Server version	10.1.37-MariaDB

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
-- Table structure for table `employee_review_requests`
--

DROP TABLE IF EXISTS `employee_review_requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_review_requests` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `from_employee_id` int(11) DEFAULT NULL,
  `to_employee_id` int(11) DEFAULT NULL,
  `employee_review_id` int(11) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `from_employee_id_idx` (`from_employee_id`),
  KEY `to_employee_id_idx` (`to_employee_id`),
  KEY `state_idx` (`employee_review_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_review_requests`
--

LOCK TABLES `employee_review_requests` WRITE;
/*!40000 ALTER TABLE `employee_review_requests` DISABLE KEYS */;
INSERT INTO `employee_review_requests` VALUES (10,1,8,NULL,2,'2019-11-10 09:31:40','2019-11-10 10:51:10'),(11,5,1,NULL,0,'2019-11-10 09:33:26','2019-11-10 09:33:26'),(12,8,1,NULL,0,'2019-11-10 09:35:01','2019-11-10 09:35:01'),(13,1,5,NULL,2,'2019-11-10 09:53:38','2019-11-10 10:49:06'),(14,1,9,NULL,2,'2019-11-10 09:53:45','2019-11-10 10:52:06'),(15,1,5,20,1,'2019-11-10 10:49:21','2019-11-10 11:36:54'),(16,1,8,19,1,'2019-11-10 10:51:18','2019-11-10 11:36:37'),(17,1,9,18,1,'2019-11-10 10:52:12','2019-11-10 11:19:08'),(21,1,5,NULL,0,'2019-11-10 11:37:32','2019-11-10 11:37:32'),(22,1,8,NULL,2,'2019-11-10 11:37:35','2019-11-10 12:53:01'),(23,1,9,24,1,'2019-11-10 11:37:37','2019-11-10 11:37:58'),(27,1,26,26,1,'2019-11-10 12:49:11','2019-11-10 12:53:20'),(28,1,27,25,1,'2019-11-10 12:52:42','2019-11-10 12:53:11');
/*!40000 ALTER TABLE `employee_review_requests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_reviews`
--

DROP TABLE IF EXISTS `employee_reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_reviews` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `score` tinyint(4) DEFAULT NULL,
  `reviewer_id` int(11) DEFAULT NULL,
  `comment` text,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `employee_id_idx` (`employee_id`),
  KEY `reviewer_id_idx` (`reviewer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_reviews`
--

LOCK TABLES `employee_reviews` WRITE;
/*!40000 ALTER TABLE `employee_reviews` DISABLE KEYS */;
INSERT INTO `employee_reviews` VALUES (18,9,10,1,'He very good','2019-11-10 11:19:08','2019-11-10 11:19:08'),(19,8,6,1,'Well well','2019-11-10 11:36:37','2019-11-10 11:36:37'),(20,5,10,1,'Ye','2019-11-10 11:36:54','2019-11-10 11:36:54'),(24,9,10,1,'','2019-11-10 11:37:58','2019-11-10 11:37:58'),(25,27,10,1,'He very good','2019-11-10 12:53:11','2019-11-10 12:53:11'),(26,26,10,1,'I love you','2019-11-10 12:53:20','2019-11-10 12:53:20');
/*!40000 ALTER TABLE `employee_reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'nguyenVk4 Update','My possition5',NULL,'2019-11-08 16:34:46'),(5,'nguyenVk4','My possition5','2019-11-08 16:24:04','2019-11-08 16:24:04'),(8,'Love me','I do','2019-11-08 23:29:17','2019-11-08 23:29:17'),(9,'New Nguyen','Bla bla bla','2019-11-10 09:04:48','2019-11-10 09:04:48'),(25,'New Employee 1','Developer','2019-11-10 12:48:09','2019-11-10 12:48:09'),(26,'Some test','Love Me','2019-11-10 12:48:53','2019-11-10 12:48:53'),(27,'Another test','Hmm','2019-11-10 12:52:15','2019-11-10 12:52:15');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (28);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-10 13:13:44
