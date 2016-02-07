--This file contains the mysql commands to load the hosts.csv file for the hpdb web application

LOAD DATA INFILE '/home/bilkhus/Downloads/hostPathogenCsv/references.csv' INTO TABLE reference character set 'utf8' FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n' 
IGNORE 1 LINES 
(@col1,@col2,@col3,@col4,@col5,@col6,@col7,@col8) 
set 
id=@col1,refSourceId=@col2,authors=@col3,year=@col4,chapterArticleTitle=@col5,volume=@col6,pages=@col7,data_source=@col8;

CREATE TABLE `reference` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authors` varchar(200) DEFAULT NULL,
  `chapterArticleTitle` varchar(200) DEFAULT NULL,
  `data_source` varchar(200) DEFAULT NULL,
  `pages` varchar(200) DEFAULT NULL,
  `refSourceId` bigint(20) DEFAULT NULL,
  `volume` varchar(200) DEFAULT NULL,
  `year` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;