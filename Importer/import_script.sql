-- 1. This section contains the mysql commands to load the hosts.csv file for the hpdb web application

SET foreign_key_checks = 0;

DROP TABLE IF EXISTS `host`;

CREATE TABLE `host` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `cultivar` varchar(255) DEFAULT NULL,
  `enName` varchar(255) DEFAULT NULL,
  `frName` varchar(255) DEFAULT NULL,
  `gbifId` bigint(20) DEFAULT NULL,
  `genus` varchar(255) DEFAULT NULL,
  `higherTaxaId` bigint(20) DEFAULT NULL,
  `idAccepted` bigint(20) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `species` varchar(255) DEFAULT NULL,
  `subSpecificTaxa` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1 ;

LOAD DATA INFILE '/home/xilu/unpack/hpdb/csvExporter/hosts.csv' INTO TABLE host character set 'utf8' FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\r\n' 
IGNORE 1 LINES 
(@col1,@col2,@col3,@col4,@col5,@col6,@col7,@col8,@col9,@col10,@col11,@col12,@col13) 
set 
id=@col1,genus=@col4,species=@col5,subSpecificTaxa=@col6,author=@col7,cultivar=@col8,enName=@col9,frName=@col10,notes=@col11;

SET foreign_key_checks = 1;





-- 2. This section contains the mysql commands to load the host_pathogenss.csv file for the hpdb web application

SET foreign_key_checks = 0;

DROP TABLE IF EXISTS `hostPathogen`;

CREATE TABLE `hostPathogen` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hostFamily` varchar(255) DEFAULT NULL,
  `hostGenus` varchar(255) DEFAULT NULL,
  `hostSpecies` varchar(255) DEFAULT NULL,
  `hostSubSpecificTaxa` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `pathogenGenus` varchar(255) DEFAULT NULL,
  `pathogenSpecies` varchar(255) DEFAULT NULL,
  `pathogenSubSpecificTaxa` varchar(255) DEFAULT NULL,
  `pathogenVirusNames` varchar(500) DEFAULT NULL,
  `plantPart` varchar(255) DEFAULT NULL,
  `rustState` varchar(255) DEFAULT NULL,
  `symptom` varchar(255) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;

LOAD DATA INFILE '/home/xilu/unpack/hpdb/csvExporter/SBML_PHCit.csv' INTO TABLE hostPathogen character set 'utf8' FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\r\n' 
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

SET foreign_key_checks = 1;





-- 3. This section contains the mysql commands to load the pathogens.csv file for the hpdb web application

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

LOAD DATA INFILE '/home/xilu/unpack/hpdb/csvExporter/pathogens.csv' INTO TABLE pathogen character set 'utf8' FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\r\n' 
IGNORE 1 LINES 
(@col1,@col2,@col3,@col4,@col5,@col6,@col7,@col8,@col9,@col10,@col11,@col12,@col13,@col14,@col15,@col16,@col17,@col18,@col19,@col20) 
set 
id=@col1,virusNames=@col5,genus=@col6,species=@col7,subSpecificTaxa=@col8,author=@col9,fungalState=@col10,enName=@col11,frName=@col13,notes=@col15;

SET foreign_key_checks = 1;





-- 4. This section contains the mysql commands to load the hosts.csv file for the hpdb web application

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





-- 5. This section contains the mysql commands to load the refSource.csv file for the hpdb web application

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


-- 6. import location table

SET foreign_key_checks = 0;

DROP TABLE IF EXISTS `location`;

CREATE TABLE `location` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `country` varchar(255) DEFAULT NULL,
  `geographicalAbbreviation` varchar(10) DEFAULT NULL,
  `interpretation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1 ;

LOAD DATA INFILE '/home/xilu/unpack/hpdb/csvExporter/localities.csv' INTO TABLE location character set 'utf8' FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\r\n' 
IGNORE 1 LINES 
(@col1,@col2,@col3,@col4,@col5) 
set 
id=@col1,geographicalAbbreviation=@col2,interpretation=@col3,country=@col4;

SET foreign_key_checks = 1;





-- 7. This file contains the mysql commands to load the hp_locality_links.csv file for the hpdb web application

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





-- 8.  Post process hp_location_link, insert empty location reference for the missing link
insert into location (id) values (-111);
commit;
insert into hp_location_link (hp_id, location_id) select id, -111 from hostPathogen where id not in (select hp_id from hp_location_link);
commit;

