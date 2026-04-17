-- This file contains the mysql commands to load the hosts.csv file for the hpdb web application


SET foreign_key_checks = 0;

DROP TABLE IF EXISTS `reference`;

CREATE TABLE `reference` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authors` varchar(255) DEFAULT NULL,
  `chapterArticleTitle` varchar(255) DEFAULT NULL,
  `data_source` varchar(255) DEFAULT NULL,
  `pages` varchar(255) DEFAULT NULL,
  `refSourceId` bigint(20) DEFAULT NULL,
  `volume` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;


LOAD DATA INFILE '/home/xilu/unpack/hpdb/csvExporter/references.csv' INTO TABLE reference character set 'utf8' FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\r\n' 
IGNORE 1 LINES 
(@col1,@col2,@col3,@col4,@col5,@col6,@col7,@col8,@col9) 
set 
id=@col1,refSourceId=@col2,authors=@col3,year=@col4,chapterArticleTitle=@col5,volume=@col6,pages=@col7,data_source=@col8;

SET foreign_key_checks = 1;


