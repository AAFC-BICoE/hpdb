-- This file contains the mysql commands to load the hp_locality_links.csv file for the hpdb web application

SET foreign_key_checks = 0;

DROP TABLE IF EXISTS `hp_location_link`;

CREATE TABLE `hp_location_link` (
  `hp_id` bigint(20) NOT NULL,
  `location_id` bigint(20) NOT NULL,
  PRIMARY KEY (`hp_id`,`location_id`),
  KEY `FK_ldgd0rdaggwh21dfmgj4y32vu` (`location_id`),
  CONSTRAINT `FK_4f8inb2h4vbt3a8guw9pn0n8f` FOREIGN KEY (`hp_id`) REFERENCES `hostPathogen` (`id`),
  CONSTRAINT `FK_ldgd0rdaggwh21dfmgj4y32vu` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1 ;

LOAD DATA INFILE '/home/xilu/unpack/hpdb/csvExporter/hp_locality_links.csv' INTO TABLE hp_location_link character set 'utf8' FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\r\n' 
IGNORE 1 LINES 
(@col1,@col2,@col3,@col4) 
set 
hp_id=@col2,location_id=@col3;

SET foreign_key_checks = 1;
 