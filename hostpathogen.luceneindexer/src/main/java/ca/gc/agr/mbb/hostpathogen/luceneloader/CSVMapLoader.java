package ca.gc.agr.mbb.hostpathogen.luceneloader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;

public class CSVMapLoader{
    private static final Logger LOG = Logger.getLogger(CSVMapLoader.class.getName());

    public static final void load(final CSVMap index, final String csvDir, final String filename, final String indexKeyField){
	CSVParser parser = null;
	try{
	    parser = Main.fileReader(csvDir, filename);
	}catch(java.io.FileNotFoundException e){
	    e.printStackTrace();
	    System.err.println("Unable to find file: " + csvDir + File.separator + filename);
	    System.exit(42);
	}catch(java.io.IOException e){
	    e.printStackTrace();
	    System.exit(42);
	}
	index.setIndexKeyField(indexKeyField);

	for (CSVRecord record : parser) {
	    //LOG.info(indexKeyField + " || " + record);
	    index.add(record);
	    
	}
    }
    
}
