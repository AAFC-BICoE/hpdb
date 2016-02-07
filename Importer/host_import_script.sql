--This file contains the mysql commands to load the hosts.csv file for the hpdb web application

LOAD DATA INFILE '/path/to/hosts.csv' INTO TABLE host character set 'utf8' FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n' 
IGNORE 1 LINES 
(@col1,@col2,@col3,@col4,@col5,@col6,@col7,@col8,@col9,@col10,@col11) 
set 
id=@col1,genus=@col4,species=@col5,subSpecificTaxa=@col6,author=@col7,cultivar=@col8,enName=@col9,frName=@col10,notes=@col11;


 CREATE TABLE `host` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(200) DEFAULT NULL,
  `cultivar` varchar(200) DEFAULT NULL,
  `enName` varchar(200) DEFAULT NULL,
  `frName` varchar(200) DEFAULT NULL,
  `gbifId` bigint(20) DEFAULT NULL,
  `genus` varchar(200) DEFAULT NULL,
  `higherTaxaId` bigint(20) DEFAULT NULL,
  `idAccepted` bigint(20) DEFAULT NULL,
  `notes` varchar(200) DEFAULT NULL,
  `species` varchar(200) DEFAULT NULL,
  `subSpecificTaxa` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1 ;
