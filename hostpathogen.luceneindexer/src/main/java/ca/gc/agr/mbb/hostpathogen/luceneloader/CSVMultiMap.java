package ca.gc.agr.mbb.hostpathogen.hostpathogenluceneloader;

import org.apache.commons.csv.CSVRecord;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVMultiMap implements CSVMap{

    Map<String, List<CSVRecord>>index = new HashMap<String, List<CSVRecord>>();

    String indexKeyField = null;

    public void setIndexKeyField(final String indexKeyField){
	this.indexKeyField = indexKeyField;
    }

    public void add(final CSVRecord record){
	List<CSVRecord> list = null;

	String key = record.get(indexKeyField);
	if (index.containsKey(key)){
	    list = index.get(key);
	}else{
	    list = new ArrayList<CSVRecord>();
	    index.put(key, list);
	}
	list.add(record);
    }

    public CSVRecord get(final String key){
	return index.get(key).get(0);
    }

    public List<CSVRecord> getAll(final String key){
	return index.get(key);
    }
    

}
