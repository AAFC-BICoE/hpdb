package ca.gc.agr.mbb.hostpathogen.luceneloader;

import org.apache.commons.csv.CSVRecord;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVMapImpl implements CSVMap{

    Map<String, CSVRecord>index = new HashMap<String, CSVRecord>();

    String indexKeyField = null;

    public void setIndexKeyField(final String indexKeyField){
	this.indexKeyField = indexKeyField;
    }

    public void add(final CSVRecord record){
	index.put(record.get(indexKeyField), record);
    }

    public CSVRecord get(final String key){
	return index.get(key);
    }

    public List<CSVRecord> getAll(final String key){
	List<CSVRecord> list = new ArrayList<CSVRecord>();
	list.add(index.get(key));
	return list;
    }
    

}
