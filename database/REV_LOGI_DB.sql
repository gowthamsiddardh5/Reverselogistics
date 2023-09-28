-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.1.45-community - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for rev_logistics
CREATE DATABASE IF NOT EXISTS `rev_logistics` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `rev_logistics`;

-- Dumping structure for table rev_logistics.1_users
CREATE TABLE IF NOT EXISTS `1_users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT 'NA',
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=62307 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table rev_logistics.2_productdata
CREATE TABLE IF NOT EXISTS `2_productdata` (
  `pid` varchar(50) DEFAULT NULL,
  `name` longtext,
  `brand` varchar(200) DEFAULT NULL,
  `selling_price` varchar(200) DEFAULT NULL,
  `mrp` varchar(100) DEFAULT NULL,
  `disc` varchar(200) DEFAULT NULL,
  `ratings` varchar(200) DEFAULT NULL,
  `ratingsNum` varchar(200) DEFAULT NULL,
  `details` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table rev_logistics.3_returndata
CREATE TABLE IF NOT EXISTS `3_returndata` (
  `uid` varchar(50) DEFAULT NULL,
  `pid` varchar(50) DEFAULT NULL,
  `pname` varchar(200) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `retre` varchar(50) DEFAULT NULL,
  `refund_status` varchar(50) DEFAULT NULL,
  `dt` varchar(50) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table rev_logistics.4_warehouse
CREATE TABLE IF NOT EXISTS `4_warehouse` (
  `wid` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `totalcap` varchar(50) DEFAULT NULL,
  `balcap` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
