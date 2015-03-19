package ca.gc.agr.mbb.hostpathogen.luceneloader;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.csv.CSVRecord;

import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.UtilLucene;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.Field;

import java.util.logging.Level;
import java.util.logging.Logger;



abstract public class Builder implements DocumentBuilder{
    private final static Logger LOG = Logger.getLogger(Builder.class.getName()); 
    protected List<String> fields;

    protected String[] objectFields;
    protected String primaryKeyField=null;
    protected String recordType = null;
    String csvFilename;

    public Builder(final String csvFilename){
	this.csvFilename = csvFilename;
    }

    @Override
    final public Document makeDocument(final CSVRecord record){

	if (primaryKeyField == null){
	    throw new NullPointerException("primaryKeyField is null");
	}

	if (recordType == null){
	    throw new NullPointerException("recordType is null");
	}

	Set<String> idFields = findIdFields(fields);

	Document doc = new Document();
	doc.add(new StringField(RECORD_TYPE, recordType, Field.Store.YES));

	String indexFieldName = null;

	StringBuilder allContent = new StringBuilder(200);

	for(String fieldName: fields){
	    String value = record.get(fieldName);

	    if (value == null || value.length() == 0){
		// throw exception??
		continue;
	    }

	    if(fieldName == primaryKeyField){
		indexFieldName = PK;
	    }else{
		indexFieldName = fieldName;
	    }
	    indexAndStore(doc, indexFieldName, value);
	}
	afterMakeDocument(doc);
	return doc;
    }

    int counter = 0;
    public void afterMakeDocument(final Document doc){
	//LOG.info("afterMakeDocument not implemented");
	++counter;
    }

    public void close(){
	System.err.println("Added records=" + counter);
    }
    private void indexAndStore(final Document doc, final String baseFieldName, String fieldValue){
	doc.add(new StoredField(UtilLucene.storedName(baseFieldName), fieldValue));
	doc.add(new StringField(baseFieldName, fieldValue.toLowerCase(), Field.Store.NO));
	//doc.add(new StringField(baseFieldName, fieldValue.toLowerCase(), Field.Store.YES));
    }

    protected void initFields(){
	fields = new ArrayList<String>(objectFields.length);
	for(String field: objectFields){
	    fields.add(field);
	}
    }

    private Set<String> findIdFields(final List<String> fields){
	Set<String>idFields = new HashSet<String>();
	for(String field:fields){
	    if (field.endsWith(ID_SUFFIX)){
		idFields.add(field);
	    }
	}
	return idFields;
    }

}
