--This file contains the mysql commands to load the host_pathogenss.csv file for the hpdb web application

LOAD DATA INFILE '/path/to/host_pathogens_PHCit.csv' INTO TABLE hostPathogen character set 'utf8' FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n' 
IGNORE 1 LINES 
(@col1,@col2,@col3,@col4,@col5,@col6,@col7,@col8,@col9,@col10,@col11,@col12,@col13,@col14,@col15,@col16,@col17,@col18) 
set 
id=@col7,
host=@col5,
pathogen=@col6,
reference=@col4,
hostFamily=@col3,
hostGenus=@col8,
hostSpecies=@col9,
hostSubSpecificTaxa=@col10,
pathogenGenus=@col11,
pathogenSpecies=@col12,
pathogenSubSpecificTaxa=@col13,
pathogenVirusNames=@col14,
rustState=@col15,
plantPart=@col17,
symptom=@col18,
notes=@col16;


CREATE TABLE `hostPathogen` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hostFamily` varchar(200) DEFAULT NULL,
  `hostGenus` varchar(200) DEFAULT NULL,
  `hostSpecies` varchar(200) DEFAULT NULL,
  `hostSubSpecificTaxa` varchar(200) DEFAULT NULL,
  `notes` varchar(200) DEFAULT NULL,
  `pathogenGenus` varchar(200) DEFAULT NULL,
  `pathogenSpecies` varchar(200) DEFAULT NULL,
  `pathogenSubSpecificTaxa` varchar(200) DEFAULT NULL,
  `pathogenVirusNames` varchar(500) DEFAULT NULL,
  `plantPart` varchar(200) DEFAULT NULL,
  `rustState` varchar(200) DEFAULT NULL,
  `symptom` varchar(200) DEFAULT NULL,
  `host` bigint(20) DEFAULT NULL,
  `pathogen` bigint(20) DEFAULT NULL,
  `reference` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_qoayr2ic5o45djhs4383bad29` (`host`),
  KEY `FK_ls3nio2m5bvhnjoer85ulu0d5` (`pathogen`),
  KEY `FK_72rovtlh38aj7a78u9gr0ta9k` (`reference`),
  CONSTRAINT `FK_72rovtlh38aj7a78u9gr0ta9k` FOREIGN KEY (`reference`) REFERENCES `reference` (`id`),
  CONSTRAINT `FK_ls3nio2m5bvhnjoer85ulu0d5` FOREIGN KEY (`pathogen`) REFERENCES `pathogen` (`id`),
  CONSTRAINT `FK_qoayr2ic5o45djhs4383bad29` FOREIGN KEY (`host`) REFERENCES `host` (`id`)
) ENGINE=InnoDB ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;



