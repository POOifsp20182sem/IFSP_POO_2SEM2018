CREATE DATABASE  IF NOT EXISTS `farmacia` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `farmacia`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: farmacia
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.29-MariaDB

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
-- Table structure for table `classe_terapeutica`
--

DROP TABLE IF EXISTS `classe_terapeutica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classe_terapeutica` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe_terapeutica`
--

LOCK TABLES `classe_terapeutica` WRITE;
/*!40000 ALTER TABLE `classe_terapeutica` DISABLE KEYS */;
INSERT INTO `classe_terapeutica` VALUES (1,'teste');
/*!40000 ALTER TABLE `classe_terapeutica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (7,'zé mane','eder@gmail.com','Rua x','3534652870','99999999999','fisica','12409536619',NULL,'2000-12-12',0),(8,'zé mane','ze@gmail.com','Rua 7','123213213','5454848444','juridica',NULL,'12409536619123','2000-10-15',1),(10,'Batman','eder@gmail.com','Rua x','3534652870','99999999999','fisica','12409536619',NULL,'2000-12-12',1),(11,'Éder','eder@gmail.com','Rua x','3534652870','99999999999','fisica','12409536619',NULL,'2000-12-12',1),(14,'Éder','eder@gmail','Monte Sião, Irineu Bernardi, 97, ','1988845','154544','fisica','12409534612','','1995-00-04',1),(15,'Éder','eder@gmail','Monte Sião, Irineu Bernardi, 97, ','1988845','154544','juridica','','12409534612','1995-00-04',1),(16,'Éder','eder@gmail','Monte Sião, Irineu Bernardi, 97, ','1988845','154544','juridica','','12409534612','1995-00-04',1),(17,'aaa','asdasd','rua x','145454','45454','fisica','cpf',NULL,'1992-12-12',1),(20,'eder','adsad','asdasd','1213','12423','juridica',NULL,'1asdasd','1992-12-12',1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (2,'batatao','eder@gmail.com','Rua x','3534652870','99999999999','12409536619','2000-12-12','atendente',1200,1),(3,'aaa','aaa','aaa','aaa','aa','aaa','1987-12-12','',123,1),(4,'aaa','aaa','aaa','aaa','aa','aaa','1987-12-12','',123,1),(5,'aaa','aaa','aaa','aaa','aa','aaa','1987-12-12','atendente',123,1);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itens_pedido`
--

DROP TABLE IF EXISTS `itens_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
-- Table structure for table `movimento`
--

DROP TABLE IF EXISTS `movimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `principio_ativo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `principio_ativo`
--

LOCK TABLES `principio_ativo` WRITE;
/*!40000 ALTER TABLE `principio_ativo` DISABLE KEYS */;
INSERT INTO `principio_ativo` VALUES (1,'teste');
/*!40000 ALTER TABLE `principio_ativo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (6,'asas','asd','asdasa','asd','asd','asd','asd',12,1,1,1);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessao`
--

DROP TABLE IF EXISTS `sessao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sessao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `func_abertura_id` int(11) NOT NULL,
  `func_fechamento_id` int(11) NOT NULL,
  `saldo_inicial` double NOT NULL,
  `saldo_final` double NOT NULL,
  `data_abertura` datetime DEFAULT NULL,
  `data_fechamento` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `func_abertura_id` (`func_abertura_id`),
  KEY `func_fechamento_id` (`func_fechamento_id`),
  CONSTRAINT `sessao_ibfk_1` FOREIGN KEY (`func_abertura_id`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `sessao_ibfk_2` FOREIGN KEY (`func_fechamento_id`) REFERENCES `funcionario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessao`
--

LOCK TABLES `sessao` WRITE;
/*!40000 ALTER TABLE `sessao` DISABLE KEYS */;
/*!40000 ALTER TABLE `sessao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'farmacia'
--

--
-- Dumping routines for database 'farmacia'
--
/*!50003 DROP PROCEDURE IF EXISTS `alterar_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alterar_cliente`(
IN p_id int,
IN p_nome varchar(50),
IN p_email varchar(50),
IN p_endereco varchar(50),
IN p_telefone varchar(10),
IN p_celular varchar(11),
IN p_tipo_cliente enum('juridica','fisica'),
IN p_documento varchar(14) ,
IN p_data_nascimento date
)
BEGIN

IF p_tipo_cliente = 'fisica' THEN

	UPDATE cliente
	SET
		nome = p_nome, 
		email = p_email, 
		endereco = p_endereco, 
		telefone = p_telefone, 
		celular = p_celular, 
		tipo_cliente = p_tipo_cliente,
		cnpj = NULL,
		cpf = p_documento, 
		data_nascimento = p_data_nascimento
	WHERE id = p_id;

ELSE 
	UPDATE cliente
	SET
		nome = p_nome, 
		email = p_email, 
		endereco = p_endereco, 
		telefone = p_telefone, 
		celular = p_celular, 
		tipo_cliente = p_tipo_cliente,
		cnpj = p_documento,
		cpf = NULL, 
		data_nascimento = p_data_nascimento
	WHERE id = p_id;

END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `alterar_funcionario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alterar_funcionario`(
IN p_id int,
IN p_nome varchar(50),
IN p_email varchar(50) ,
IN p_endereco varchar(50) ,
IN p_telefone varchar(10),
IN p_celular varchar(11),
IN p_cpf varchar(11),
IN p_data_nascimento date,
IN p_tipo_funcionario enum('gerente','atendente'),
IN p_salario double
)
BEGIN
	
    UPDATE funcionario 
    SET
    nome = p_nome,
    email = p_email,
    endereco = p_endereco,
    telefone = p_telefone,
    celular = p_celular,
    cpf = p_cpf,
    data_nascimento = p_data_nascimento,
    tipo_funcionario = p_tipo_funcionario,
    salario = p_salario
    WHERE
    id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `alterar_itens_pedido` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alterar_itens_pedido`(
IN p_old_produto_id	int(11),
IN p_old_pedido_id	int(11),
IN p_new_produto_id	int(11),
IN p_new_pedido_id	int(11),
IN p_quantidade	int(11),
IN p_preco_unitario	double
)
BEGIN
	UPDATE itens_pedido 
    SET
    produto_id = p_new_produto_id,
    pedido_id= p_new_pedido_id,
    quantidade = p_quantidade,
    preco_unitario = p_preco_unitario
    WHERE 
    produto_id = p_old_produto_id 
    AND
    pedido_id= p_old_pedido_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `alterar_pedido` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alterar_pedido`(
IN p_id int(11),
IN p_cliente_id int(11),
IN p_funcionario_id int(11),
IN p_desconto double,
IN p_total double,
IN p_data_compra date
)
BEGIN
	UPDATE pedido
    SET 
    cliente_id = p_cliente_id,
    funcionario_id = p_funcionario_id,
    desconto = p_desconto,
    total = p_total,
    data_compra = p_data_compra
    WHERE 
    id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `alterar_produto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alterar_produto`(
IN p_id int(11),
IN p_nome_comercial varchar(50),
IN p_apresentacao varchar(50),
IN p_forma_farmaco varchar(30),
IN p_fabricante	varchar(60),
IN p_principio_ativo varchar(50),
IN p_unidade_medida	varchar(40),
IN p_registro_ms varchar(11),
IN p_codigo_barras varchar(13),
IN p_classe_terapeutica varchar(40),
IN p_qtde_estoque int(11))
BEGIN
	UPDATE produto SET
    nome_comercial = p_nome_comercial,
    apresentacao = p_apresentacao,
    forma_farmaco = p_forma_farmaco,
    fabricante = p_fabricante,
    principio_ativo = p_principio_ativo,
    unidade_medida = p_unidade_medida,
    registro_ms = p_registro_ms,
    codigo_barras = p_codigo_barras,
    classe_terapeutica = p_classe_terapeutica,
    qtde_estoque = p_qtde_estoque
    WHERE 
    id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_clientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_clientes`(IN filter varchar(50))
BEGIN

# pensar em diferentes modos de filtragem de dados
# converter todos os dados para upper ou converter apenas na busca?

	IF filter LIKE '' THEN
		SELECT * FROM cliente WHERE ativo IS TRUE;
	ELSE
		SELECT * FROM cliente
			WHERE 
				(nome LIKE CONCAT('%', filter,'%') OR
				email LIKE CONCAT('%', filter,'%') OR
				endereco LIKE CONCAT('%', filter,'%') OR
				telefone LIKE CONCAT('%', filter,'%') OR
				celular LIKE CONCAT('%', filter,'%') OR
				tipo_cliente LIKE CONCAT('%', filter,'%') OR
				cpf LIKE CONCAT('%', filter,'%') OR
				cnpj LIKE CONCAT('%', filter,'%')) AND ativo IS TRUE;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_funcionarios` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_funcionarios`(IN filter varchar(50))
BEGIN

# pensar em diferentes modos de filtragem de dados
# converter todos os dados para upper ou converter apenas na busca?

	IF filter LIKE '' THEN
		SELECT * FROM funcionario WHERE ativo IS TRUE;
	ELSE
		SELECT * FROM funcionario
			WHERE 
				(nome LIKE CONCAT('%', filter,'%') OR
				email LIKE CONCAT('%', filter,'%') OR
				endereco LIKE CONCAT('%', filter,'%') OR
				telefone LIKE CONCAT('%', filter,'%') OR
				celular LIKE CONCAT('%', filter,'%') OR
				tipo_funcionario LIKE CONCAT('%', filter,'%') OR
				cpf LIKE CONCAT('%', filter,'%')) AND ativo IS TRUE;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_pedidos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_pedidos`(IN filter varchar(50))
BEGIN

# pensar em um modo de pesquisa por período
# e um modo eficiente de procurar só com através do id

	IF filter IS NULL THEN
		SELECT p.id, p.data_compra, p.cliente_id,c.nome, p.funcionario_id,f.nome, p.total, p.desconto
			FROM pedido as p 
				INNER JOIN cliente c on (p.cliente_id = c.id)
				INNER JOIN funcionario f on (p.funcionario_id = f.id);
	ELSE
		SELECT p.id, p.data_compra, p.cliente_id,c.nome, p.funcionario_id,f.nome, p.total, p.desconto
			FROM pedido as p 
				INNER JOIN cliente c on (p.cliente_id = c.id)
				INNER JOIN funcionario f on (p.funcionario_id = f.id)
					WHERE  
						p.id LIKE CONCAT('%', filter,'%') OR
						f.nome LIKE CONCAT('%', filter,'%') OR
						c.nome LIKE CONCAT('%', filter,'%') OR
						data_compra LIKE CONCAT('%', filter,'%');
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_produtos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_produtos`(IN filter varchar(50))
BEGIN

# pensar em diferentes modos de filtragem de dados
# converter todos os dados para upper ou converter apenas na busca?
# fazer inner join para buscar por classe terapeutica e princípio ativo?

	IF filter LIKE '' THEN
		SELECT * FROM produto WHERE ativo is TRUE;
	ELSE
		SELECT * FROM produto
			WHERE 
				(nome_comercial LIKE CONCAT('%', filter,'%') OR
				apresentacao LIKE CONCAT('%', filter,'%') OR
				forma_farmaco LIKE CONCAT('%', filter,'%') OR
				fabricante LIKE CONCAT('%', filter,'%') OR
                # rever a necessidade do campo unidade medida
				unidade_medida LIKE CONCAT('%', filter,'%') OR
				registro_ms LIKE CONCAT('%', filter,'%') OR
				codigo_barras LIKE CONCAT('%', filter,'%')) AND ativo IS TRUE;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `excluir_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `excluir_cliente`(IN p_id int)
BEGIN
	
    # if the cliente has any association he has the field ativo modify to false
	IF EXISTS(SELECT id FROM pedido where cliente_id = p_id) THEN
		UPDATE cliente SET
			ativo = FALSE 
				WHERE id = p_id;
	# if the cliente does not have any association with another table he can be deleted
    ELSE
		DELETE FROM cliente where id = p_id;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `excluir_funcionario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `excluir_funcionario`(IN p_id int)
BEGIN
	IF EXISTS(SELECT id FROM pedido where funcionario_id = p_id) THEN
		UPDATE funcionario SET
			ativo = FALSE 
				WHERE id = p_id;
    ELSE
			DELETE FROM funcionario where id = p_id;
    END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `excluir_itens_pedido` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `excluir_itens_pedido`(
IN p_produto_id	int(11),
IN p_pedido_id	int(11)
)
BEGIN
	DELETE from itens_pedido where produto_id = p_produto_id AND pedido_id = p_pedido_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `excluir_pedido` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `excluir_pedido`(
IN p_id int(11)
)
BEGIN
	DELETE FROM pedido where id = p_id;
	#posso colocar um variavel para o status e também uma para ocultar
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `excluir_produto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `excluir_produto`(IN p_id int)
BEGIN

	IF EXISTS(SELECT id FROM itens_pedido where produto_id = p_id) THEN
		UPDATE produto SET
			ativo = FALSE 
				WHERE id = p_id;
    ELSE
			DELETE FROM produto where id = p_id;
    END IF;
    
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserir_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_cliente`(
IN p_nome varchar(50),
IN p_email varchar(50),
IN p_endereco varchar(50),
IN p_telefone varchar(10),
IN p_celular varchar(11),
IN p_tipo_cliente enum('juridica','fisica'),
IN p_documento varchar(14) ,
IN p_data_nascimento date
)
BEGIN

# criar um campo para documento (generico) ou fazer este processo sempre?

IF p_tipo_cliente = 'fisica' THEN

	INSERT INTO cliente
		(nome, email, endereco, telefone, celular, tipo_cliente, cpf, cnpj, data_nascimento) 
	VALUES
		(
		p_nome,
		p_email,
		p_endereco,
		p_telefone,
		p_celular,
		p_tipo_cliente,
		p_documento, null,
		p_data_nascimento
		);
ELSE
	INSERT INTO cliente
		(nome, email, endereco, telefone, celular, tipo_cliente, cpf, cnpj, data_nascimento) 
	VALUES
		(
		p_nome,
		p_email,
		p_endereco,
		p_telefone,
		p_celular,
		p_tipo_cliente,
		null, p_documento,
		p_data_nascimento
		);

END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserir_funcionario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_funcionario`(
IN p_nome varchar(50),
IN p_email varchar(50) ,
IN p_endereco varchar(50) ,
IN p_telefone varchar(10),
IN p_celular varchar(11),
IN p_cpf varchar(11),
IN p_data_nascimento date,
IN p_tipo_funcionario enum('gerente','atendente'),
IN p_salario double
)
BEGIN
	INSERT INTO funcionario
    (nome, email, endereco, telefone, celular, cpf, data_nascimento, tipo_funcionario, salario)
    VALUES
    (p_nome,
    p_email,
    p_endereco,
    p_telefone,
    p_celular,
    p_cpf,
    p_data_nascimento,
    p_tipo_funcionario,
    p_salario
    );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserir_itens_pedido` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_itens_pedido`(
IN p_produto_id	int(11),
IN p_pedido_id	int(11),
IN p_quantidade	int(11),
IN p_preco_unitario	double
)
BEGIN
	INSERT INTO itens_pedido 
    VALUES
    (
    p_produto_id,
    p_pedido_id,
    p_quantidade,
    p_preco_unitario
    );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserir_pedido` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_pedido`(
IN p_cliente_id int(11),
IN p_funcionario_id int(11),
IN p_desconto double,
IN p_total double,
IN p_data_compra date
)
BEGIN
	INSERT INTO pedido
    (cliente_id, funcionario_id,desconto,total,data_compra)
    VALUES
    (
    p_cliente_id,
    p_funcionario_id,
    p_desconto,
    p_total,
    p_data_compra
    );
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserir_produto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_produto`(
IN p_nome_comercial varchar(50),
IN p_apresentacao varchar(50),
IN p_forma_farmaco varchar(30),
IN p_fabricante	varchar(60),
IN p_unidade_medida	varchar(40),
IN p_registro_ms varchar(11),
IN p_codigo_barras varchar(13),
IN p_principio_ativo_id int(11),
IN p_classe_terapeutica_id int(11),
IN p_qtde_estoque int(11))
BEGIN
	INSERT INTO produto
    (nome_comercial, apresentacao, forma_farmaco, fabricante, unidade_medida, registro_ms, codigo_barras, qtde_estoque, classe_terapeutica_id, principio_ativo_id)
    VALUES
    (p_nome_comercial,
	p_apresentacao,
	p_forma_farmaco,
	p_fabricante,
	p_unidade_medida,
	p_registro_ms,
	p_codigo_barras,
	p_qtde_estoque,
	p_classe_terapeutica_id,
	p_principio_ativo_id
	);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-13 12:28:05
