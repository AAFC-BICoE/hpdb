--This file contains the mysql commands to load the hosts.csv file for the hpdb web application

drop table host;
drop table pathogen;
drop table hostPathogen;


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


LOAD DATA INFILE '/home/bilkhus/Downloads/hostPathogenCsv/hosts.csv' INTO TABLE host character set 'utf8' FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n' 
IGNORE 1 LINES 
(@col1,@col2,@col3,@col4,@col5,@col6,@col7,@col8,@col9,@col10,@col11) 
set 
id=@col1,genus=@col4,species=@col5,subSpecificTaxa=@col6,author=@col7,cultivar=@col8,enName=@col9,frName=@col10,notes=@col11;


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


LOAD DATA INFILE '/home/bilkhus/Downloads/hostPathogenCsv/pathogens.csv' INTO TABLE pathogen character set 'utf8' FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n' 
IGNORE 1 LINES 
(@col1,@col2,@col3,@col4,@col5,@col6,@col7,@col8,@col9,@col10,@col11,@col12,@col13,@col14,@col15) 
set 
id=@col1,genus=@col6,species=@col7,subSpecificTaxa=@col8,author=@col9,fungalState=@col10,enName=@col11,frName=@col13,notes=@col15;


 CREATE TABLE `hostPathogen` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `credibilityRating` varchar(200) DEFAULT NULL,
  `notes` varchar(200) DEFAULT NULL,
  `plantPart` varchar(200) DEFAULT NULL,
  `questionableData` varchar(200) DEFAULT NULL,
  `referenceId` bigint(20) DEFAULT NULL,
  `rustState` varchar(200) DEFAULT NULL,
  `symptom` varchar(200) DEFAULT NULL,
  `host` bigint(20) DEFAULT NULL,
  `pathogen` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_qoayr2ic5o45djhs4383bad29` (`host`),
  KEY `FK_ls3nio2m5bvhnjoer85ulu0d5` (`pathogen`),
  CONSTRAINT `FK_ls3nio2m5bvhnjoer85ulu0d5` FOREIGN KEY (`pathogen`) REFERENCES `pathogen` (`id`),
  CONSTRAINT `FK_qoayr2ic5o45djhs4383bad29` FOREIGN KEY (`host`) REFERENCES `host` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1 ;


LOAD DATA INFILE '/home/bilkhus/Downloads/hostPathogenCsv/host_pathogens.csv' INTO TABLE hostPathogen character set 'utf8' FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n' 
IGNORE 1 LINES 
(@col1,@col2,@col3,@col4,@col5,@col6,@col7,@col8,@col9,@col10,@col11) 
set 
id=@col1,referenceId=@col2,host=@col3,pathogen=@col4,plantPart=@col6,symptom=@col7,notes=@col9;


