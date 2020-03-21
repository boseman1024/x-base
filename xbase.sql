-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: xbase
-- ------------------------------------------------------
-- Server version	5.7.20-log
use xbase;
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
-- Table structure for table `msg_store`
--

DROP TABLE IF EXISTS `msg_store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `msg_store` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `content` text,
  `type` char(1) NOT NULL DEFAULT '0',
  `receiver` varchar(255) DEFAULT NULL,
  `state` char(1) NOT NULL DEFAULT '0',
  `sender` varchar(64) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `del_flag` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `msg_store`
--

LOCK TABLES `msg_store` WRITE;
/*!40000 ALTER TABLE `msg_store` DISABLE KEYS */;
INSERT INTO `msg_store` VALUES (2,'Highcharts Demo','<p><presource code=\"\" pro\';font-size:12.0pt;\"=\"\">@RequestBody</presource><br></p>','0',NULL,'1','admin','2020-01-17 08:44:09','2020-01-17 08:44:09','0'),(3,'所谓标题','<p>所谓内容</p>','0',NULL,'1','admin','2020-01-17 08:44:40','2020-01-17 08:44:40','0'),(4,'标题','<p>内容</p>','0',NULL,'1','admin','2020-01-17 08:45:47','2020-01-17 08:45:47','0'),(5,'标题2','<p>内容2</p>','0',NULL,'1','admin','2020-01-17 08:46:44','2020-01-17 08:46:44','0'),(6,'标题3','<p>内容3</p>','0',NULL,'1','admin','2020-01-17 08:47:04','2020-01-17 08:47:04','0'),(7,'标题4','<p>内容4</p>','0',NULL,'1','admin','2020-01-17 08:47:20','2020-01-17 08:47:20','0'),(8,'标题5','<p>内容5</p>','0',NULL,'1','admin','2020-01-17 08:51:39','2020-01-17 08:51:39','0'),(9,'标题6','<p>内容6</p>','0',NULL,'1','admin','2020-01-17 08:52:53','2020-01-17 08:52:53','0'),(10,'标题7','<p>内容7</p>','0',NULL,'1','admin','2020-01-17 08:54:11','2020-01-17 08:54:11','0'),(11,'标题7','<p>内容7</p>','0',NULL,'1','admin','2020-01-17 08:58:52','2020-01-17 08:58:52','0'),(12,'标题8','<p>内容8</p>','0',NULL,'1','admin','2020-01-17 08:59:24','2020-01-17 08:59:24','0'),(13,'标题9','<p>内容9</p>','0',NULL,'1','admin','2020-01-17 09:00:20','2020-01-17 09:00:20','0'),(14,'标题10','<p>内容10</p>','0',NULL,'1','admin','2020-01-17 09:00:55','2020-01-17 09:00:55','0'),(15,'标题11','<p>内容11</p>','0',NULL,'1','admin','2020-01-17 09:01:51','2020-01-17 09:01:51','0'),(16,'标题11','<p>内容11</p>','0',NULL,'1','admin','2020-01-17 09:05:43','2020-01-17 09:05:43','0'),(17,'标题12','<p>内容12</p>','0',NULL,'1','admin','2020-01-17 09:07:36','2020-01-17 09:07:36','0'),(18,'标题13','<p>内容13</p>','0',NULL,'1','admin','2020-01-17 09:08:46','2020-01-17 09:08:46','0'),(19,'标题15','<p>内容15</p>','0',NULL,'1','admin','2020-01-17 09:27:43','2020-01-17 09:27:43','0'),(20,'标题17','<p>内容7</p>','0',NULL,'1','admin','2020-01-17 09:28:35','2020-01-17 09:28:35','0'),(21,'标题18','<p>内容19</p>','0',NULL,'1','admin','2020-01-17 09:29:35','2020-01-17 09:29:35','0');
/*!40000 ALTER TABLE `msg_store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_client_details`
--

DROP TABLE IF EXISTS `oauth_client_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(255) NOT NULL,
  `resource_ids` varchar(255) DEFAULT NULL,
  `client_secret` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `authorized_grant_types` varchar(255) DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) DEFAULT NULL,
  `authorities` varchar(255) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(255) DEFAULT NULL,
  `autoapprove` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_client_details`
--

LOCK TABLES `oauth_client_details` WRITE;
/*!40000 ALTER TABLE `oauth_client_details` DISABLE KEYS */;
INSERT INTO `oauth_client_details` VALUES ('admin','','$2a$10$v05NP5AqMOp71hR5mI1e2eX42yvUldP7PhQGloNXxfzG396CKOLQC','web,mobile','password,refresh_token',NULL,NULL,3600,3600,'{\"country\":\"CN\",\"country_code\":\"086\"}',NULL);
/*!40000 ALTER TABLE `oauth_client_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dept`
--

DROP TABLE IF EXISTS `sys_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dept` (
  `dept_id` int(64) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `type` char(1) NOT NULL DEFAULT '0',
  `pid` int(64) DEFAULT '0',
  `sort` int(11) NOT NULL DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `del_flag` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept`
--

LOCK TABLES `sys_dept` WRITE;
/*!40000 ALTER TABLE `sys_dept` DISABLE KEYS */;
INSERT INTO `sys_dept` VALUES (1,'根部门','1',0,1,'2020-01-05 07:55:38','2020-01-05 07:55:38','0'),(2,'子部门','2',1,1,'2020-01-05 07:56:22','2020-01-05 07:56:22','0'),(3,'子部门2','2',1,2,'2020-01-05 07:56:22','2020-01-05 07:56:22','1'),(4,'子子部门','2',2,1,'2020-01-05 07:56:22','2020-01-05 07:56:22','0'),(5,'吱吱部门','2',4,1,'2020-01-07 15:39:32','2020-01-07 15:39:32','1');
/*!40000 ALTER TABLE `sys_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dept_menu`
--

DROP TABLE IF EXISTS `sys_dept_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dept_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept_menu`
--

LOCK TABLES `sys_dept_menu` WRITE;
/*!40000 ALTER TABLE `sys_dept_menu` DISABLE KEYS */;
INSERT INTO `sys_dept_menu` VALUES (1,1,1),(5,5,1),(6,5,2),(7,5,5),(14,4,1),(15,4,2),(16,4,5),(17,4,6),(18,4,2);
/*!40000 ALTER TABLE `sys_dept_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dept_role`
--

DROP TABLE IF EXISTS `sys_dept_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dept_role` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `dept_id` int(64) NOT NULL,
  `role_id` int(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept_role`
--

LOCK TABLES `sys_dept_role` WRITE;
/*!40000 ALTER TABLE `sys_dept_role` DISABLE KEYS */;
INSERT INTO `sys_dept_role` VALUES (1,1,1),(2,4,3),(5,4,8),(6,4,9);
/*!40000 ALTER TABLE `sys_dept_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dept_user`
--

DROP TABLE IF EXISTS `sys_dept_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dept_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept_user`
--

LOCK TABLES `sys_dept_user` WRITE;
/*!40000 ALTER TABLE `sys_dept_user` DISABLE KEYS */;
INSERT INTO `sys_dept_user` VALUES (8,4,13),(9,2,14),(10,1,12),(11,2,15);
/*!40000 ALTER TABLE `sys_dept_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict`
--

DROP TABLE IF EXISTS `sys_dict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dict` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) NOT NULL,
  `label` varchar(100) NOT NULL,
  `value` varchar(100) NOT NULL,
  `type` char(1) NOT NULL DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
  `pid` int(64) DEFAULT '0',
  `sort` int(11) DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `del_flag` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict`
--

LOCK TABLES `sys_dict` WRITE;
/*!40000 ALTER TABLE `sys_dict` DISABLE KEYS */;
INSERT INTO `sys_dict` VALUES (1,'CODE','字典','123','1','字典111',0,1,'2020-01-10 15:22:51','2020-01-10 15:22:51','0'),(2,'123','123','123','1','123',0,1,'2020-01-10 15:33:42','2020-01-10 15:33:42','0'),(3,'321','321','321','1','321',0,1,'2020-01-10 15:35:01','2020-01-10 15:35:01','0'),(4,'111','555','555','1','555',3,1,'2020-01-10 15:37:48','2020-01-10 15:37:48','0'),(5,'999','999','999','1','999',3,1,'2020-01-10 15:46:27','2020-01-10 15:46:27','1'),(6,'AAA','AAA','AAAA','0',NULL,0,2,'2020-01-15 08:02:23','2020-01-15 08:02:23','0');
/*!40000 ALTER TABLE `sys_dict` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `menu_id` int(64) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `permission` varchar(64) NOT NULL,
  `type` char(1) NOT NULL,
  `path` varchar(255) DEFAULT NULL,
  `pid` int(64) DEFAULT '0',
  `component` varchar(64) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `sort` int(11) NOT NULL DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `del_flag` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (1,'工作台','workplace','1','/dashboard/workplace',0,NULL,NULL,1,'2020-01-03 15:21:14','2020-01-03 15:21:14','0'),(2,'系统管理','system','1',NULL,1,NULL,NULL,1,'2020-01-05 16:26:52','2020-01-05 16:26:52','0'),(3,'用户列表','USERLIST','1',NULL,0,NULL,NULL,1,'2020-01-06 14:56:44','2020-01-06 14:56:44','1'),(4,'AAA','AAA','1',NULL,3,NULL,NULL,1,'2020-01-06 14:57:44','2020-01-06 14:57:44','1'),(5,'菜单','11','1',NULL,1,NULL,NULL,1,'2020-01-06 15:04:02','2020-01-06 15:04:02','0'),(6,'查询','CHECK','2','11',5,NULL,NULL,1,'2020-01-07 14:35:12','2020-01-07 14:35:12','0'),(7,'修改','update','2',NULL,5,NULL,NULL,2,'2020-01-13 07:44:05','2020-01-13 07:44:05','0'),(8,'删除','delete1','2',NULL,5,NULL,NULL,2,'2020-01-15 07:31:45','2020-01-15 07:31:45','0');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `role_id` int(64) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `code` varchar(64) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `del_flag` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'超级管理员','admin','超级管理员','2020-01-03 15:19:52','2020-01-03 15:19:52','0'),(3,'子子1','AA','AA11','2020-01-08 15:05:44','2020-01-08 15:05:44','0'),(5,'DDD','DDD','DDD','2020-01-08 15:13:16','2020-01-08 15:13:16','1'),(7,'DDD','DDD','DDD','2020-01-08 15:18:30','2020-01-08 15:18:30','1'),(8,'DDD112','DD2','DDD112','2020-01-08 15:18:39','2020-01-08 15:18:39','0'),(9,'AA','AAA','DDD','2020-01-15 07:12:21','2020-01-15 07:12:21','0');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_menu` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `role_id` int(64) NOT NULL,
  `menu_id` int(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` VALUES (2,2,1),(3,2,2),(4,2,5),(20,1,1),(33,8,2),(34,8,6),(35,8,5),(36,3,1),(37,3,6),(42,9,1),(43,9,2);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `user_id` int(64) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `password` varchar(255) NOT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `nickname` varchar(64) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `state` char(1) NOT NULL DEFAULT '0',
  `del_flag` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (12,'admin','$2a$10$v05NP5AqMOp71hR5mI1e2eX42yvUldP7PhQGloNXxfzG396CKOLQC',NULL,'admin','115692',NULL,'2020-01-02 13:23:47','2020-01-02 13:23:47','0','0'),(13,'admin11','$2a$10$MA837ejVitdSR6MTf8dS0uj4mwHQHtK2tz3mdN7FHm7/3tU7FYBrO',NULL,'admin333',NULL,NULL,'2020-01-09 15:13:59','2020-01-09 15:13:59','0','1'),(14,'admin999','$2a$10$NF.ai.AZxS6ihLz9Z9Bu0OQeIep4LbCVotAFSQnxUqpPol0N.xkeS',NULL,'admin999',NULL,NULL,'2020-01-09 15:34:19','2020-01-09 15:34:19','1','1'),(15,'admin123','$2a$10$b27XmXKS1jPnmJ0VT1qyze4EKZe.0Kad.sfyhtqrejQ55seGNus4q',NULL,'123','123',NULL,'2020-01-15 03:28:41','2020-01-15 03:28:41','0','0');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `user_id` int(64) NOT NULL,
  `role_id` int(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (9,13,3),(10,12,1);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-07 13:40:28
