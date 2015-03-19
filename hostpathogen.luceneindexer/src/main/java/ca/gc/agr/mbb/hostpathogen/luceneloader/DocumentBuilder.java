package ca.gc.agr.mbb.hostpathogen.luceneloader;

import org.apache.commons.csv.CSVRecord;

import org.apache.lucene.document.Document;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.LuceneFields;

public interface DocumentBuilder extends LuceneFields{
    Document makeDocument(CSVRecord record);
    void afterMakeDocument(Document doc);
    void init();
    void close();



}
