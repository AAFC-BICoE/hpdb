--This file contains the mysql commands to load the pathogens.csv file for the hpdb web application

LOAD DATA INFILE '/path/to/pathogens.csv' INTO TABLE pathogen character set 'utf8' FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n' 
IGNORE 1 LINES 
(@col1,@col2,@col3,@col4,@col5,@col6,@col7,@col8,@col9,@col10,@col11,@col12,@col13,@col14,@col15) 
set 
id=@col1,genus=@col6,species=@col7,subSpecificTaxa=@col8,author=@col9,fungalState=@col10,enName=@col11,frName=@col13,notes=@col15;



 CREATE TABLE `pathogen` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `anamorphId` bigint(20) DEFAULT NULL,
  `author` varchar(200) DEFAULT NULL,
  `enDiseaseName` varchar(200) DEFAULT NULL,
  `enName` varchar(200) DEFAULT NULL,
  `frDiseaseName` varchar(200) DEFAULT NULL,
  `frName` varchar(200) DEFAULT NULL,
  `fullName` varchar(512) DEFAULT NULL,
  `fungalState` varchar(200) DEFAULT NULL,
  `gbifId` bigint(20) DEFAULT NULL,
  `genus` varchar(200) DEFAULT NULL,
  `higherTaxaId` bigint(20) DEFAULT NULL,
  `idAccepted` bigint(20) DEFAULT NULL,
  `notes` varchar(200) DEFAULT NULL,
  `species` varchar(200) DEFAULT NULL,
  `subSpecificTaxa` varchar(200) DEFAULT NULL,
  `virusNames` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1 ;
