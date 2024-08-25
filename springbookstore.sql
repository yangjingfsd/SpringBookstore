CREATE DATABASE  IF NOT EXISTS `springbookstore`;
USE `springbookstore`;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `isbn` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `books`
--

INSERT INTO `books` VALUES 
	(1,'Wonderland','John Smith','ISBN1234567890120','$29.99'),
	(2,'The Lost Heaven','Interdum Pretium','ISBN1234567890121','$19.99'),
	(3,'Noise of Silence','Tincidunt Ipsum','ISBN1234567890122','$39.99'),
	(4,'We are in the corner','Tellus Massa','ISBN1234567890123','$25.99'),
	(5,'Who Knows What Is Happening','Orci Aliquet','ISBN1234567890124','$14.99'),
	(6,'That is how it works','Vitae Arcu','ISBN1234567890125','$59.99');
