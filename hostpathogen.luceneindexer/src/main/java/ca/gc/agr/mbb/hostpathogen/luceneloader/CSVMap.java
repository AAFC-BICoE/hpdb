package ca.gc.agr.mbb.hostpathogen.hostpathogenluceneloader;

import org.apache.commons.csv.CSVRecord;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

public interface CSVMap{

    public void setIndexKeyField(final String indexKeyField);
    public void add(final CSVRecord record);
    public CSVRecord get(final String key);
    public List<CSVRecord> getAll(final String key);

    

}
