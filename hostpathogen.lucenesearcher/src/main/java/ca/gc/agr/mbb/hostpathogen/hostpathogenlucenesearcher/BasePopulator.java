package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;

import org.apache.lucene.document.Document;
import ca.gc.agr.mbb.hostpathogen.nouns.Pathogen;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract public class BasePopulator<T> implements Populator{
    private final static Logger LOG = Logger.getLogger(BasePopulator.class.getName()); 

    protected Set<String> validSortFieldSet = new HashSet<String>();
    protected Set<String> validSearchFieldSet = new HashSet<String>();
    protected Map<Class, String> validRelations = new HashMap<Class, String>();
    protected List<String> defaultSortFields = new ArrayList<String>();
    protected String primaryKeyField = PK;

    protected String recordType = null;
    protected Class classType = null;

    @Override
    public Class getProductClass(){
	return classType;
    }

    @Override
    public String getRecordType(){
	return recordType;
    }

    @Override
    public void addDefaultSortFields(final String... sf){
	for(String field: sf){
	    defaultSortFields.add(field);
	}
    }

    @Override
    public List<String> getDefaultSortFields(){
	return defaultSortFields;
    }

    @Override
    public String getPrimaryKeyField(){
	return primaryKeyField;
    }

    @Override
    public Set<String>getValidSortFieldSet(){
	return validSortFieldSet;
    }

    @Override
    public void addSortFields(final String... sf){
	for(String field: sf){
	    validSortFieldSet.add(field);
	}
    }

    @Override
    public boolean isValidSortField(String s){
	return validSortFieldSet.contains(s);
    }

    @Override
    public Set<String>getValidSearchFieldSet(){
	return validSearchFieldSet;
    }

    @Override
    public void addSearchFields(final String... sf){
	for(String field: sf){
	    validSearchFieldSet.add(field);
	}
    }

    @Override
    public boolean isValidSearchField(String s){
	return validSearchFieldSet.contains(s);
    }

    @Override
    public void addRelation(Class type, String field){
	validRelations.put(type, field);
    }

    @Override
    public String getRelationField(Class type){
	return validRelations.get(type);
    }

    @Override
    public boolean isValidRelation(Class type){
	return 	validRelations.containsKey(type);
    }

    @Override
    public Map<Class, String>getValidRelations(){
	return validRelations;
    }

    @Override
    public T populate(Document doc) throws FailedPopulateException{
	try{
	    Util.isNull(doc);
	}catch(IllegalArgumentException e){
	    e.printStackTrace();
	    //throw new FailedPopulateException("Document is null");
	    throw new FailedPopulateException("The Lucene Document is null", e);
	}
	return null;
    }

    final long longValue(Document doc, String fieldName) throws FailedPopulateException{
	return longValue(doc, fieldName, false);
    }

    final long longValue(Document doc, String fieldName, boolean mustExist) throws FailedPopulateException
    {
	checkDocFieldName(doc, fieldName);

	String[] values = doc.getValues(fieldName);
	if(values == null || values.length == 0){
	    if(mustExist){
		throw new FailedPopulateException(this.getClass().getName() + ": Field " + fieldName + " is mandatory: cannot be empty/null");
	    }
	    return 0l;
	}
	try{
	    return (new Long(values[0])).longValue();
	}catch(NumberFormatException e){
	    throw new FailedPopulateException(e);
	}
    }
    
    static final String stringValue(Document doc, String fieldName) throws FailedPopulateException{
	return stringValue(doc, fieldName, false);
    }

    static final String stringValue(Document doc, String fieldName, boolean mustExist) throws FailedPopulateException
    {
	checkDocFieldName(doc, fieldName);

	String[] values = doc.getValues(fieldName);
	if(values == null || values.length == 0){
	    if(mustExist){
		throw new FailedPopulateException("Field " + fieldName + " is mandatory: cannot be empty/null");
	    }
	    return null;
	}
	try{
	    return values[0];
	}catch(NumberFormatException e){
	    throw new FailedPopulateException(e);
	}
    }

    static final void checkDocFieldName(Document doc, String fieldName){
	if (doc == null){
	    throw new FailedPopulateException("Document is null");
	}

	if (fieldName == null || fieldName.length() == 0){
	    throw new FailedPopulateException("Fieldname is null or zero length");
	}
    }


    public static final String stored(String base){
	return base + STORED_SUFFIX;
    }
}
