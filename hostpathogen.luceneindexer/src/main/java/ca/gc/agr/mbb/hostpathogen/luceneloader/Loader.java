
package ca.gc.agr.mbb.hostpathogen.hostpathogenluceneloader;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexWriter;

public class Loader{
    private final static Logger LOG = Logger.getLogger(Loader.class.getName()); 

    public void index(final IndexWriter writer, final CSVParser parser, final String filename, final Builder pb){
	Map<String,Integer> headers = parser.getHeaderMap();

	pb.init();
	pb.initFields();

	    int count = 0;
	    LOG.info("Filename csv=" + filename);
	    for (CSVRecord record : parser) {
		count++;
		//System.out.println("---");
		Document doc = null;

		if(pb != null){
		    doc = pb.makeDocument(record);
		}
		try{
		    writer.addDocument(doc);
		}catch(Exception e){
		    e.printStackTrace();
		    return;
		}
	    }
    }
}
