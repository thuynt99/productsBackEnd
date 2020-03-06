-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: productdb
-- ------------------------------------------------------
-- Server version	5.7.29-log

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
-- Table structure for table `tbl_options`
--

DROP TABLE IF EXISTS `tbl_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_options` (
  `option_id` int(11) NOT NULL AUTO_INCREMENT,
  `option_value` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `tbl_variants_variant_id` int(11) NOT NULL,
  PRIMARY KEY (`option_id`),
  KEY `fk_tbl_options_tbl_variants1_idx` (`tbl_variants_variant_id`),
  CONSTRAINT `fk_tbl_options_tbl_variants1` FOREIGN KEY (`tbl_variants_variant_id`) REFERENCES `tbl_variants` (`variant_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_options`
--

LOCK TABLES `tbl_options` WRITE;
/*!40000 ALTER TABLE `tbl_options` DISABLE KEYS */;
INSERT INTO `tbl_options` VALUES (1,'36',5),(2,'37',5),(3,'38',5),(4,'42',5),(5,'Đen',6),(6,'Đỏ',6),(9,'Hong',6),(10,'Xanh',6),(13,'41',5),(14,'42',5),(15,'41',16),(16,'37',16),(17,'38',16),(18,'39',16),(19,'XanhVang',18),(20,'Vang',18),(21,'Hong',18),(22,'36',17),(23,'37',17),(24,'40',17),(25,'38',20),(26,'38',22),(27,'38',24),(28,'38',26),(29,'36',26),(30,'37',26),(31,'Đen',21),(32,'Đen',23),(33,'Đen',25),(34,'Đen',27),(35,'Đỏ',27);
/*!40000 ALTER TABLE `tbl_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_products`
--

DROP TABLE IF EXISTS `tbl_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `product_line` varchar(45) COLLATE utf8_bin NOT NULL,
  `product_price` int(11) NOT NULL,
  `product_image` varchar(1000) CHARACTER SET utf8 DEFAULT NULL,
  `product_description` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `created_at` date NOT NULL,
  `updated_at` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_products`
--

LOCK TABLES `tbl_products` WRITE;
/*!40000 ALTER TABLE `tbl_products` DISABLE KEYS */;
INSERT INTO `tbl_products` VALUES (6,'Vans','Giày thể thao nữ',699000,'https://product.hstatic.net/1000230642/product/dsmh01100cam__5__1a189b8f8b394b3fa2c5e58b9ba57b6b_medium.jpg','Giày Thể Thao Cao Cấp Nữ.','2020-02-27','2020-03-04'),(9,'Hun Niker','Giày thể thao nữ',1200000,'https://product.hstatic.net/1000230642/product/deg000400hog__4__9fc2255458074330ab01212f762744cb_medium.jpg','Giày Thể Thao Cao Cấp Nữ.','2020-02-28','2020-03-04'),(13,'IPU','Giày nữ',999000111,'https://product.hstatic.net/1000230642/product/dsmh01100cam__5__1a189b8f8b394b3fa2c5e58b9ba57b6b_medium.jpg','Giày Thể Thao Cao Cấp Nữ.','2020-03-04','2020-03-04'),(14,'Aleck','Giày nam',990000,'https://product.hstatic.net/1000230642/product/dsmh01100cam__5__1a189b8f8b394b3fa2c5e58b9ba57b6b_medium.jpg','Giày Thể Thao Cao Cấp Nam.','2020-03-04',NULL),(15,'Aleck','Giày nam',990000,'https://product.hstatic.net/1000230642/product/dsmh01100cam__5__1a189b8f8b394b3fa2c5e58b9ba57b6b_medium.jpg','Giày Thể Thao Cao Cấp Nam.','2020-03-01',NULL),(16,'MC King','Giày nam',9990001,'https://product.hstatic.net/1000230642/product/dsmh01100cam__5__1a189b8f8b394b3fa2c5e58b9ba57b6b_medium.jpg','Giày Thể Thao Cao Cấp Nam.','2020-03-04','2020-03-04'),(17,'MC Queen','Giày nữ',999000,'https://product.hstatic.net/1000230642/product/dsmh01100cam__5__1a189b8f8b394b3fa2c5e58b9ba57b6b_medium.jpg','Giày Thể Thao Cao Cấp Nữ.','2020-03-04','2020-03-04');
/*!40000 ALTER TABLE `tbl_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_variants`
--

DROP TABLE IF EXISTS `tbl_variants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_variants` (
  `variant_id` int(11) NOT NULL AUTO_INCREMENT,
  `variant_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `tbl_products_id` int(11) NOT NULL,
  PRIMARY KEY (`variant_id`),
  KEY `fk_tbl_variants_tbl_products_idx` (`tbl_products_id`),
  CONSTRAINT `fk_tbl_variants_tbl_products` FOREIGN KEY (`tbl_products_id`) REFERENCES `tbl_products` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_variants`
--

LOCK TABLES `tbl_variants` WRITE;
/*!40000 ALTER TABLE `tbl_variants` DISABLE KEYS */;
INSERT INTO `tbl_variants` VALUES (5,'Size',6),(6,'Màu sắc',6),(16,'Size',9),(17,'Size',13),(18,'Màu sắc',13),(20,'Size',14),(21,'Màu sắc',14),(22,'Size',15),(23,'Màu sắc',15),(24,'Size',16),(25,'Màu sắc',16),(26,'Size',17),(27,'Màu sắc',17);
/*!40000 ALTER TABLE `tbl_variants` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-06 19:52:50
