CREATE DATABASE auction;
DROP TABLE IF EXISTS `systemuser`;
CREATE TABLE `systemuser` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Fname` varchar(20) DEFAULT NULL,
  `Lname` varchar(20) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Pass` varchar(30) DEFAULT NULL,
  `Gender` int(1) DEFAULT NULL,
  `BirthDate` varchar(20) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Cat_Name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `sessions`;
CREATE TABLE `sessions` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Session_date` varchar(20) DEFAULT NULL,
  `Start_time` int(11) DEFAULT NULL,
  `End_time` int(11) DEFAULT NULL,
  `reserved` int(2) NOT NULL DEFAULT '0',
  `Winner_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Winner_ID` (`Winner_ID`),
  CONSTRAINT `sessions_ibfk_1` FOREIGN KEY (`Winner_ID`) REFERENCES `systemuser` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Item_name` varchar(30) DEFAULT NULL,
  `Details` varchar(500) DEFAULT NULL,
  `picture` varchar(50) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `Cat_ID` int(11) DEFAULT NULL,
  `session_ID` int(11) DEFAULT NULL,
  `seller_ID` int(11) DEFAULT NULL,
  `Served` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `Cat_ID` (`Cat_ID`),
  KEY `session_ID` (`session_ID`),
  KEY `seller_ID` (`seller_ID`),
  CONSTRAINT `item_ibfk_1` FOREIGN KEY (`Cat_ID`) REFERENCES `category` (`ID`),
  CONSTRAINT `item_ibfk_2` FOREIGN KEY (`session_ID`) REFERENCES `sessions` (`ID`),
  CONSTRAINT `item_ibfk_3` FOREIGN KEY (`seller_ID`) REFERENCES `systemuser` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `session_participants`;
CREATE TABLE `session_participants` (
  `session_ID` int(11) NOT NULL,
  `bidder_ID` int(11) NOT NULL,
  `item_ID` int(11) NOT NULL,
  `price` int(11) DEFAULT '0',
  PRIMARY KEY (`session_ID`,`bidder_ID`,`item_ID`),
  KEY `Bidder_ID` (`bidder_ID`),
  KEY `session_participants_ibfk_3` (`item_ID`),
  CONSTRAINT `session_participants_ibfk_1` FOREIGN KEY (`session_ID`) REFERENCES `sessions` (`ID`),
  CONSTRAINT `session_participants_ibfk_2` FOREIGN KEY (`bidder_ID`) REFERENCES `systemuser` (`ID`),
  CONSTRAINT `session_participants_ibfk_3` FOREIGN KEY (`item_ID`) REFERENCES `item` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
