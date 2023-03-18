CREATE DATABASE  IF NOT EXISTS `online_shopping_system` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `online_shopping_system`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: online_shopping_system
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `CART_ID` int NOT NULL AUTO_INCREMENT,
  `CART_PRODUCTNAME` varchar(50) NOT NULL,
  `CART_PRODUCTPRICE` varchar(40) NOT NULL,
  `CART_QUANT` int NOT NULL,
  `PRODUCT_ID` varchar(10) NOT NULL,
  `CUSTOMER_ID` int NOT NULL,
  PRIMARY KEY (`CART_ID`),
  KEY `FKeyProductlDl` (`PRODUCT_ID`),
  KEY `FKeyCustomerID2` (`CUSTOMER_ID`),
  CONSTRAINT `FKeyCustomerID2` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`CUSTOMER_ID`),
  CONSTRAINT `FKeyProductlDl` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`PRODUCT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=500 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `CUSTOMER_ID` int NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `lNAME` varchar(50) NOT NULL,
  `fNAME` varchar(20) NOT NULL,
  `BIRTHDATE` date NOT NULL,
  `SEX` varchar(6) NOT NULL,
  `CUSTOMER_EMAIL` varchar(50) NOT NULL,
  `CUSTOMER_PNUMBER` varchar(20) NOT NULL,
  `ADDRESS` varchar(200) NOT NULL,
  `CITY` varchar(20) NOT NULL,
  `ZIP` int NOT NULL,
  PRIMARY KEY (`CUSTOMER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (101,'admin','admin','john paul','miraflores','2001-07-09','male','sevhen.nhayn@yahoo.com','09561901685','kingston st.','kingland',4438);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `payment_method` varchar(50) NOT NULL,
  `payment_total` double NOT NULL,
  `customer_id` int NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fkeyOrderCustID` (`customer_id`),
  CONSTRAINT `fkeyOrderCustID` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`CUSTOMER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=550 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `PAYMENT_ID` int NOT NULL AUTO_INCREMENT,
  `PAYMENT_AMOUNT` double NOT NULL,
  `ADDRESS_ID` varchar(200) NOT NULL,
  `PRODUCT_ID` varchar(10) NOT NULL,
  `PRODUCT_NAME` varchar(50) NOT NULL,
  `PRODUCT_QUANTITY` int NOT NULL,
  `CUSTOMER_ID` int NOT NULL,
  PRIMARY KEY (`PAYMENT_ID`),
  KEY `FKeyProductlD2` (`PRODUCT_ID`),
  KEY `fkeyCustlD` (`CUSTOMER_ID`),
  CONSTRAINT `fkeyCustlD` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`CUSTOMER_ID`),
  CONSTRAINT `FKeyProductlD2` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`PRODUCT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=250 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `PRODUCT_ID` varchar(10) NOT NULL,
  `PRODUCT_NAME` varchar(50) NOT NULL,
  `PRODUCT_PRICE` double NOT NULL,
  `PRODUCT_STOCK` int NOT NULL,
  `PRODUCT_BRAND` varchar(15) NOT NULL,
  `PRODUCT_CATEGORY` varchar(50) NOT NULL,
  PRIMARY KEY (`PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('B101','Tiffany\'s Hinged Bangle',4200,16,'TIFFANY & Co.','BRACELETS'),('B102','Classy Matte Black Bracelet',1291.14,15,'N/A','BRACELETS'),('B103','Cartier\'s Classic Bangle',26705,39,'CARTIER','BRACELETS'),('B104','Punk\'s Bracelet',437.8,8,'N/A','BRACELETS'),('E101','Silver Sapphire Earring',18790,29,'UNISILVER','EARRINGS'),('E102','Golden Aquamarine Earring',2310,31,'N/A','EARRINGS'),('E103','White Gold Onyx Earring',9085.8,36,'CARTIER','EARRINGS'),('E104','Cross Rounded Earring',1699,29,'N/A','EARRINGS'),('E105','Stud Earring',499,27,'N/A','EARRINGS'),('E106','Cross Earring',746,62,'N/A','EARRINGS'),('E107','Rounded Earring',699,31,'N/A','EARRINGS'),('N101','Ball Chain Neddace',2343.18,83,'UNISILVER','NECKLACES'),('N102','Touissant Diamond Neddace',25343.18,65,'J\'s Diamond','NECKLACES'),('N103','Emerald Golden Choker',29887.5,62,'J\'s Diamond','NECKLACES'),('N104','Diamond Choker Neddace',4951.54,23,'N/A','NECKLACES'),('N105','Link Golden Chain Neddace',4590.72,66,'N/A','NECKLACES'),('N106','Obsidian Chain Neddace',2175,19,'N/A','NECKLACES'),('N107','Silver Chain Neddace',1386.3,69,'N/A','NECKLACES'),('R101','Classy Diamond Ring',21685,78,'UNISILVER','RINGS'),('R102','Floral Diamond Ring',33926,68,'J\'s Diamond','RINGS'),('R103','Square Diamond Ring',34200,58,'J\'s Diamond','RINGS'),('R104','Golden Onyx Ring',762.4,21,'N/A','RINGS'),('R105','Titanium Ring',724.2,69,'N/A','RINGS'),('R106','Sappire Metal Ring',3726,18,'N/A','RINGS'),('R107','Stainless Steel Ring',1147.68,72,'N/A','RINGS'),('W101','Didiers Leather Watch',2750,7,'DIDIER','WATCHES'),('W102','Fossil\'s Classic Silver Watch',4305.57,19,'FOSSIL','WATCHES'),('W103','Fossil\'s Silver Blue Watch',4305.57,24,'FOSSIL','WATCHES'),('W104','Michael Kors Classic Leather Watch',6646.98,15,'MICHAEL KORS','WATCHES');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'online_shopping_system'
--

--
-- Dumping routines for database 'online_shopping_system'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-19  4:21:00
