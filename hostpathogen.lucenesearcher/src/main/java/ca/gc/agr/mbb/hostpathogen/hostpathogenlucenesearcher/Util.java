package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;

import java.util.Properties;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import ca.gc.agr.mbb.hostpathogen.nouns.Pathogen;

public class Util{

    // Make sure offset and limits are sane and within constraints.
    public static final void checkOffsetAndLimit(final long offset, final int limit) throws IllegalOffsetLimitException{
	StringBuilder s = new StringBuilder();
	if (offset <0){
	    s.append("Offset is < 0: " + offset + "||");
	}
	if (limit<1){
	    s.append("Limit is < 1: " + limit);
	}

	if (limit>HPSearcher.LIMIT_MAX){
	    s.append("Limit is > max limit value:" + HPSearcher.LIMIT_MAX + " :" + limit); 
	}

	if(s.length() > 0){
	    throw new IllegalOffsetLimitException(s.toString());
	}

    }

    public static final void isNullOrZero(String s) throws IllegalArgumentException{
	isNull(s);
	if(s.length() == 0){
	    throw new IllegalArgumentException("String is null or zero length");
	}
    }

    public static final void isNull(Object s) throws IllegalArgumentException{
	if(s==null){
	    throw new IllegalArgumentException("String is null or zero length");
	}
    }

    public static final void checkSortFields(final List<String>sortFields, Set<String> acceptableFields) throws IllegalArgumentException{
	
	for(String field: sortFields){
	    if (! acceptableFields.contains(field)){
		throw new IllegalArgumentException("Sort fields: [" + field + "] is not allowed; allowed fields:" + acceptableFields);	    
	    }
	}
    }


    public static final void checkQueryParameters(final Map<String,List<String>>parameters, Set<String> acceptableFields) throws IllegalArgumentException{
	if(parameters == null){
	    throw new IllegalArgumentException("query parameters is null");
	} 

	if(parameters.size() == 0){
	    throw new IllegalArgumentException("parameters  is zero length");
	} 

	if (acceptableFields == null || acceptableFields.size() == 0){
	    return;
	}

	for(String key: parameters.keySet()){
	    if(key == null || key.length() == 0){
		throw new IllegalArgumentException("parameters key=" + key + " is null or is zero length");
	    }
	    if(acceptableFields != null && acceptableFields.size() != 0 && !acceptableFields.contains(key)){
		throw new IllegalArgumentException("Illegal field:" + key);
	    }

	    List<String>values = parameters.get(key);
	    if(values == null || values.size() == 0){
		throw new IllegalArgumentException("parameters key=" + key + " has null values or is zero length");
	    }
	    for(String value: values){
		if (value == null){
		    throw new IllegalArgumentException("parameter value for key=" + key + " is null");
		}
	    }
	}
    }

    

    public static final void checkList(List list, int limit){
	if(list == null){
		throw new IllegalArgumentException("Null list");
	    }

	int len = list.size();
	if(len == 0){
		throw new IllegalArgumentException("Empty list (size=0)");
	    }
	if(len > limit){
		throw new IllegalArgumentException("List too large " + len + "; greater than limit: " + limit);
	    }
    }

    public static final void checkId(final Long id) throws IllegalArgumentException{
	List<Long> ids = new ArrayList<Long>(1);
	ids.add(id);
	checkIds(ids);
    }

    public static final void checkIds(final List<Long> ids) throws IllegalArgumentException{
	if(ids == null){
	    throw new IllegalArgumentException("ids List<Long> is null");
	}
	if(ids.size() == 0){
	    throw new IllegalArgumentException("ids List<Long> is empty (length=0)");
	}
    }

    public static final int min(final int i, final int j){
	if (j>i){
	    return i;
	}
	return j;
    }

    public static final List<Long> sliceList(final List<Long> list, final long offset, final int limit) throws IllegalArgumentException{
	checkList(list, Integer.MAX_VALUE);
	int len = list.size();
	
	if(offset >len){
	    return new ArrayList<Long>(0);
	}
	return list.subList((int)offset, min((int)(offset+limit), len));
    }


    public static final String existsIsDirIsReadable(String dir){
	File f = new File(dir);
	
	if (!f.exists()){
	    return "Dir does not exist:" + dir;
	}
	if (!f.isDirectory()){
	    return "Is not a directory:" + dir;
	}
	if (!f.canRead()){
	    return "Unable to read dir:" + dir;
	}

	return null;
    }

    public static final void touch(final File f) throws java.io.FileNotFoundException{
	    PrintWriter writer = new PrintWriter(f);
	    writer.println("x");
	    writer.flush();
	    writer.close();
    }

    public static final Set<String>strings2Set(String[] strings){
	Set<String> stringSet = new HashSet<String>(strings.length);
	for(String str: strings){
	    stringSet.add(str);
	}
	return stringSet;
    }

    public static final boolean listInSet(List<Object> list, Set<Object> set){
	return true;
    }

    public static final void checkPopulator(Populator p, Class generic) throws InitializationException{
	isNull(p);
	isNull(generic);
	
	if (generic != p.getProductClass()){
	    throw new InitializationException("Search type does not match Populator class: type=" + generic.getName() + "  productClass=" + p.getProductClass().getName());
	}

	if(p.getDefaultSortFields() == null || p.getDefaultSortFields().size() == 0){
	    throw new InitializationException("Populator (" + p.getClass().getName() + ") has null or zero length default sort field");
	}

	if(p.getValidSortFieldSet() == null || p.getValidSortFieldSet().size() == 0){
	    throw new InitializationException("Populator has null or zero length default sort field map");
	}

	if(!Util.listInSet(p.getDefaultSortFields(), p.getValidSortFieldSet())){
	    throw new InitializationException("Default sort fields not in valid sort fields");
	}

    }
    

}//


