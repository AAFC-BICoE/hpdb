-- This file contains the mysql commands to load the pathogens.csv file for the hpdb web application

SET foreign_key_checks = 0;

DROP TABLE IF EXISTS `pathogen`;

CREATE TABLE `pathogen` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `anamorphId` bigint(20) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `enDiseaseName` varchar(255) DEFAULT NULL,
  `enName` varchar(255) DEFAULT NULL,
  `frDiseaseName` varchar(255) DEFAULT NULL,
  `frName` varchar(255) DEFAULT NULL,
  `fullName` varchar(512) DEFAULT NULL,
  `fungalState` varchar(255) DEFAULT NULL,
  `gbifId` bigint(20) DEFAULT NULL,
  `genus` varchar(255) DEFAULT NULL,
  `higherTaxaId` bigint(20) DEFAULT NULL,
  `idAccepted` bigint(20) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `species` varchar(255) DEFAULT NULL,
  `subSpecificTaxa` varchar(255) DEFAULT NULL,
  `virusNames` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;

LOAD DATA INFILE '../csvExporter/pathogens.csv' INTO TABLE pathogen character set 'utf8' FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\r\n' 
IGNORE 1 LINES 
(@col1,@col2,@col3,@col4,@col5,@col6,@col7,@col8,@col9,@col10,@col11,@col12,@col13,@col14,@col15,@col16,@col17,@col18,@col19,@col20) 
set 
id=@col1,virusNames=@col5,genus=@col6,species=@col7,subSpecificTaxa=@col8,author=@col9,fungalState=@col10,enName=@col11,frName=@col13,notes=@col15;

SET foreign_key_checks = 1;
