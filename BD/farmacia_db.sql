CREATE DATABASE  IF NOT EXISTS `farmacia` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `farmacia`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: farmacia
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `classe_terapeutica`
--

DROP TABLE IF EXISTS `classe_terapeutica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `classe_terapeutica` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe_terapeutica`
--

LOCK TABLES `classe_terapeutica` WRITE;
/*!40000 ALTER TABLE `classe_terapeutica` DISABLE KEYS */;
INSERT INTO `classe_terapeutica` VALUES (1,'teste'),(2,'Adstringente'),(3,'Amebicidas'),(4,'Bateriostático'),(5,'Broncodilatadores'),(6,'Calcitoninas'),(7,'Cicatrizante'),(8,'Descongestionante'),(9,'Diuréticos'),(10,'Emoliente'),(11,'Expectorantes'),(12,'Fibrinogênio'),(13,'Fibratos'),(14,'Gangliosideo'),(15,'Glicocorticóides'),(16,'Hormônio'),(17,'Hepatoprotetor'),(18,'Inibidores Fibrinólise'),(19,'Imunoglobulina Tetânica'),(20,'Laxante'),(21,'Lubrificante Oftálmico'),(22,'Monobactâmicos'),(23,'Mucolítico'),(24,'Nootrópicos'),(25,'Nitritos e Nitratos'),(26,'Orexígenos'),(27,'Polimixinas'),(28,'Pediculicida Sarnicida'),(29,'Quinolonas Urinários'),(30,'Quimioterápico Tópico'),(31,'Radiofármacos'),(32,'Regulador Intestinal'),(33,'Sedativo Hipnótico'),(34,'Soluções Aminoácidas Padrão'),(35,'Tecidos Hemostáticos'),(36,'Tranquilizantes'),(37,'Vasodilatadores'),(38,'Vasopressor');
/*!40000 ALTER TABLE `classe_terapeutica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `endereco` varchar(50) NOT NULL,
  `telefone` varchar(10) NOT NULL,
  `celular` varchar(11) DEFAULT NULL,
  `tipo_cliente` enum('juridica','fisica') NOT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `cnpj` varchar(14) DEFAULT NULL,
  `data_nascimento` date NOT NULL,
  `ativo` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (7,'zé mane','eder@gmail.com','Rua x','3534652870','99999999999','fisica','12409536619',NULL,'2000-12-12',0),(8,'zé mane','ze@gmail.com','Rua 7','123213213','5454848444','juridica',NULL,'12409536619123','2000-10-15',1),(10,'Batman','eder@gmail.com','Rua x','3534652870','99999999999','fisica','12409536619',NULL,'2000-12-12',1),(11,'Éder','eder@gmail.com','Rua x','3534652870','99999999999','fisica','12409536619',NULL,'2000-12-12',1),(14,'Éder','eder@gmail','Monte Sião, Irineu Bernardi, 97, ','1988845','154544','fisica','12409534612','','1995-00-04',1),(15,'Éder','eder@gmail','Monte Sião, Irineu Bernardi, 97, ','1988845','154544','juridica','','12409534612','1995-00-04',1),(16,'Éder','eder@gmail','Monte Sião, Irineu Bernardi, 97, ','1988845','154544','juridica','','12409534612','1995-00-04',1),(17,'aaa','asdasd','rua x','145454','45454','fisica','cpf',NULL,'1992-12-12',1),(20,'eder','adsad','asdasd','1213','12423','juridica',NULL,'1asdasd','1992-12-12',1),(21,'eder','eder','c, a, b, d','(11) 11111','(11) 111111','fisica',NULL,NULL,'1111-11-11',1),(22,'eder','eder','c, a, b, d','(11) 11111','(11) 111111','fisica',NULL,NULL,'1111-11-11',1),(23,'eder','eder','c, a, b, d','(11) 11111','(11) 111111','fisica',NULL,NULL,'1111-11-11',1),(24,'eder','eder','c, a, b, d','(11) 11111','(11) 111111','fisica',NULL,NULL,'1111-11-11',1),(25,'eder','eder','c, a, b, d','(11) 11111','(11) 111111','fisica',NULL,NULL,'1111-11-11',1),(26,'eder','eder','c, a, b, d','(11) 11111','(11) 111111','fisica',NULL,NULL,'1111-11-11',1),(27,'eder','der','c, a, b, d','2222222222','33333333333','fisica',NULL,NULL,'1111-11-11',1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `endereco` varchar(50) NOT NULL,
  `telefone` varchar(10) NOT NULL,
  `celular` varchar(11) DEFAULT NULL,
  `cpf` varchar(11) NOT NULL,
  `data_nascimento` date NOT NULL,
  `tipo_funcionario` enum('gerente','atendente') NOT NULL,
  `salario` double NOT NULL,
  `ativo` tinyint(1) DEFAULT '1',
  `login_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `login_id_fk` (`login_id`),
  CONSTRAINT `login_id_fk` FOREIGN KEY (`login_id`) REFERENCES `login` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (2,'batatao','eder@gmail.com','Rua x','3534652870','99999999999','12409536619','2000-12-12','atendente',1200,1,1),(3,'aaa','aaa','aaa','aaa','aa','aaa','1987-12-12','',123,1,1),(4,'aaa','aaa','aaa','aaa','aa','aaa','1987-12-12','',123,1,1),(5,'aaa','aaa','aaa','aaa','aa','aaa','1987-12-12','atendente',123,1,1);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itens_pedido`
--

DROP TABLE IF EXISTS `itens_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `itens_pedido` (
  `produto_id` int(11) NOT NULL,
  `pedido_id` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `preco_unitario` double NOT NULL,
  PRIMARY KEY (`produto_id`,`pedido_id`),
  KEY `pedido_id` (`pedido_id`),
  CONSTRAINT `itens_pedido_ibfk_1` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`),
  CONSTRAINT `itens_pedido_ibfk_2` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens_pedido`
--

LOCK TABLES `itens_pedido` WRITE;
/*!40000 ALTER TABLE `itens_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `itens_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) NOT NULL,
  `senha` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'eder','123'),(2,'consoli','321');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimento`
--

DROP TABLE IF EXISTS `movimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `movimento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sessao_id` int(11) NOT NULL,
  `pedido_id` int(11) DEFAULT NULL,
  `descricao` varchar(50) NOT NULL,
  `data_movimento` datetime NOT NULL,
  `valor_entrada` double NOT NULL,
  `valor_saida` double NOT NULL,
  `troco` double NOT NULL,
  `saldo` double NOT NULL,
  `forma_pagamento` enum('cartao','dinheiro') DEFAULT NULL,
  `nota_fiscal_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sessao_id` (`sessao_id`),
  KEY `pedido_id` (`pedido_id`),
  KEY `nota_fiscal_id` (`nota_fiscal_id`),
  CONSTRAINT `movimento_ibfk_1` FOREIGN KEY (`sessao_id`) REFERENCES `sessao` (`id`),
  CONSTRAINT `movimento_ibfk_2` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`),
  CONSTRAINT `movimento_ibfk_3` FOREIGN KEY (`nota_fiscal_id`) REFERENCES `nota_fiscal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimento`
--

LOCK TABLES `movimento` WRITE;
/*!40000 ALTER TABLE `movimento` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota_fiscal`
--

DROP TABLE IF EXISTS `nota_fiscal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `nota_fiscal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero_nf` int(11) NOT NULL,
  `status_nf` enum('AUTORIZADA','CANCELADA','PROCESSANDO') NOT NULL,
  `chave_nf` varchar(45) NOT NULL,
  `protocolo_nf` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `numero_nf` (`numero_nf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota_fiscal`
--

LOCK TABLES `nota_fiscal` WRITE;
/*!40000 ALTER TABLE `nota_fiscal` DISABLE KEYS */;
/*!40000 ALTER TABLE `nota_fiscal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_compra` date DEFAULT NULL,
  `cliente_id` int(11) DEFAULT NULL,
  `funcionario_id` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `desconto` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_id` (`cliente_id`),
  KEY `funcionario_id` (`funcionario_id`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (2,'2005-10-29',7,2,100,0.1);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `principio_ativo`
--

DROP TABLE IF EXISTS `principio_ativo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `principio_ativo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `principio_ativo`
--

LOCK TABLES `principio_ativo` WRITE;
/*!40000 ALTER TABLE `principio_ativo` DISABLE KEYS */;
INSERT INTO `principio_ativo` VALUES (1,'teste'),(2,'Acebrofilina'),(3,'Aceclofenaco'),(4,'Baclofeno'),(5,'Benzocaína'),(6,'Calcitriol'),(7,'Carbocisteína'),(8,'Deltametrina'),(9,'Desonida'),(10,'Ebastina'),(11,'Estradiol'),(12,'Fentanila'),(13,'Fenitoína'),(14,'Glicina'),(15,'Glicerina'),(16,'Halotano'),(17,'Haloperidol'),(18,'Ibuprofeno'),(19,'Icodextrina'),(20,'Jaborandi'),(21,'Lactase'),(22,'Lansoprazol'),(23,'Macitentana'),(24,'Magaldrato'),(25,'Nicotina'),(26,'Nicergolina'),(27,'Ocitocina'),(28,'Oxitocina'),(29,'Paracetamol'),(30,'Paricalcitol'),(31,'Quitosana'),(32,'Quelato de Cálcio'),(33,'Roxitromicina'),(34,'Secnidazol'),(35,'Simeticona'),(36,'Teofilina'),(37,'Tianeptina'),(38,'Ureia'),(39,'Urtiga Dioica'),(40,'Xilometazolina'),(41,'Zinco');
/*!40000 ALTER TABLE `principio_ativo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `produto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_comercial` varchar(50) NOT NULL,
  `apresentacao` varchar(50) NOT NULL,
  `forma_farmaco` varchar(30) NOT NULL,
  `fabricante` varchar(60) NOT NULL,
  `unidade_medida` varchar(40) NOT NULL,
  `registro_ms` varchar(11) DEFAULT NULL,
  `codigo_barras` varchar(13) DEFAULT NULL,
  `qtde_estoque` int(11) NOT NULL,
  `ativo` tinyint(1) DEFAULT '1',
  `classe_terapeutica_id` int(11) NOT NULL,
  `principio_ativo_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `classe_terapeutica_id` (`classe_terapeutica_id`),
  KEY `principio_ativo_id` (`principio_ativo_id`),
  CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`classe_terapeutica_id`) REFERENCES `classe_terapeutica` (`id`),
  CONSTRAINT `produto_ibfk_2` FOREIGN KEY (`principio_ativo_id`) REFERENCES `principio_ativo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (6,'asas','asd','asdasa','asd','asd','asd','asd',12,1,1,1),(7,'aa','a','a','aa','a','a','a',1,1,1,1),(8,'','','COMPRIMIDO','','','','',0,1,1,1);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessao`
--

DROP TABLE IF EXISTS `sessao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sessao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `func_abertura_id` int(11) NOT NULL,
  `func_fechamento_id` int(11) DEFAULT NULL,
  `saldo_inicial` double NOT NULL,
  `saldo_final` double DEFAULT NULL,
  `data_abertura` datetime DEFAULT NULL,
  `data_fechamento` datetime DEFAULT NULL,
  `status` enum('ABERTO','FECHADO') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `func_abertura_id` (`func_abertura_id`),
  KEY `func_fechamento_id` (`func_fechamento_id`),
  CONSTRAINT `sessao_ibfk_1` FOREIGN KEY (`func_abertura_id`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `sessao_ibfk_2` FOREIGN KEY (`func_fechamento_id`) REFERENCES `funcionario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessao`
--

LOCK TABLES `sessao` WRITE;
/*!40000 ALTER TABLE `sessao` DISABLE KEYS */;
INSERT INTO `sessao` VALUES (1,2,2,1000,2000,'0000-00-00 00:00:00','0000-00-00 00:00:00','FECHADO'),(2,2,NULL,1000,NULL,'2018-09-25 00:00:00','0000-00-00 00:00:00','FECHADO'),(4,2,NULL,1000,NULL,'2018-09-25 21:21:21',NULL,'FECHADO'),(5,2,NULL,1000,NULL,'2018-09-25 21:21:21',NULL,'FECHADO'),(6,2,NULL,1000,NULL,'2018-09-25 21:21:21',NULL,'ABERTO');
/*!40000 ALTER TABLE `sessao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'farmacia'
--

--
-- Dumping routines for database 'farmacia'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-26 15:51:11
