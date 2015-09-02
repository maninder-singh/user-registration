-- MySQL dump 10.13  Distrib 5.5.44, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: user_registration
-- ------------------------------------------------------
-- Server version	5.5.44-0ubuntu0.14.04.1

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
-- Table structure for table `user_detail`
--

DROP TABLE IF EXISTS `user_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_detail` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `zip` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_detail`
--

LOCK TABLES `user_detail` WRITE;
/*!40000 ALTER TABLE `user_detail` DISABLE KEYS */;
INSERT INTO `user_detail` VALUES (1,'update userName','update midleName','update lastName','Roas colony','Hyderbad','Telangana',NULL,'500056','update@update.com'),(2,'Bhuvneshwar','','Sharma','Aligarh','Aligarh','Uttar Pradesh','India','438392','bhuvneshwar.sharma@imaginea.com'),(3,'Ashok','','Chelimilla','Hyderabad','Hyderabad','Telangana','India','500034','ashok.chelimilla@imaginea.com'),(26,'fsdf','','sfsd','fsdf','dfsdfdfsdf','dfsdf','dfgdfg','121121','sdsd@gmauil.com'),(27,'firstName','middleName','lastName','address','city','state','country','500034','email@email.com'),(28,'firstName','middleName','lastName','address','city','state','country','500034','email@email.com'),(29,'firstName','middleName','lastName','address','city','state','country','500034','email@email.com'),(30,'firstName','middleName','lastName','address','city','state','country','500034','email@email.com'),(31,'firstName','middleName','lastName','address','city','state','country','500034','email@email.com'),(32,'firstName','middleName','lastName','address','city','state','country','500034','email@email.com'),(33,'insert firstName','insert midleName','insert lastName','Roas colony','Hyderbad','Telangana',NULL,'500056','insert@inset.com'),(34,'insert firstName','insert midleName','insert lastName','Roas colony','Hyderbad','Telangana',NULL,'500056','insert@inset.com'),(35,'firstName','middleName','lastName','address','city','state','country','500034','email@email.com'),(36,'ashok','kumar','Chelimilla','Dilsuknagar','Hyderabad','Telangana','india','500042','ask@ask.com'),(37,'insert firstName','insert midleName','insert lastName','Roas colony','Hyderbad','Telangana',NULL,'500056','insert@inset.com'),(38,'ashok','kumar','Chelimilla','Dilsuknagar','Hyderabad','Telangana','india','500042','ask@ask.com'),(39,'insert firstName','insert midleName','insert lastName','Roas colony','Hyderbad','Telangana',NULL,'500056','insert@inset.com'),(40,'ashok','kumar','Chelimilla','Dilsuknagar','Hyderabad','Telangana','india','500042','ask@ask.com'),(41,'insert firstName','insert midleName','insert lastName','Roas colony','Hyderbad','Telangana',NULL,'500056','insert@inset.com'),(42,'firstName','middleName','lastName','address','city','state','country','500034','email@email.com'),(43,'firstName','middleName','lastName','address','city','state','country','500034','email@email.com'),(44,'ashok','kumar','Chelimilla','Dilsuknagar','Hyderabad','Telangana','india','500042','ask@ask.com'),(45,'ashok','kumar','Chelimilla','Dilsuknagar','Hyderabad','Telangana','india','500042','ask@ask.com'),(46,'insert firstName','insert midleName','insert lastName','Roas colony','Hyderbad','Telangana',NULL,'500056','insert@inset.com'),(47,'ashok','kumar','Chelimilla','Dilsuknagar','Hyderabad','Telangana','india','500042','ask@ask.com'),(48,'insert firstName','insert midleName','insert lastName','Roas colony','Hyderbad','Telangana',NULL,'500056','insert@inset.com');
/*!40000 ALTER TABLE `user_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-02 11:57:20
