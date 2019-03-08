-- This file contains the mysql commands to load the refSource.csv file for the hpdb web application

SET foreign_key_checks = 0;

DROP TABLE IF EXISTS `refSource`;

CREATE TABLE `refSource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bookAuthor` varchar(255) DEFAULT NULL,
  `bookPages` varchar(255) DEFAULT NULL,
  `bookTitle` varchar(255) DEFAULT NULL,
  `journal` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1 ;

LOAD DATA INFILE '/home/xilu/unpack/hpdb/csvExporter/ref_sources.csv' INTO TABLE refSource character set 'utf8' FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\r\n' 
IGNORE 1 LINES 
(@col1,@col2,@col3,@col4,@col5,@col6,@col7,@col8,@col9,@col10,@col11) 
set 
id=@col1,bookAuthor=@col5,bookPages=@col10,bookTitle=@col7,journal=@col3;

SET foreign_key_checks = 1;
 