package ca.gc.agr.mbb.hostpathogen.hostpathogenluceneloader;

import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.LuceneFields;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.UtilLucene;
import org.apache.lucene.index.IndexWriter;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.Field;

public final class Util{
    static final String SUFFIX = "\\.csv";

    public static final String makeIndexName(String base){
	// Assumes .csv suffix
	return "luceneIndex." + base.replaceAll(SUFFIX, "");
    }

    public static final void saveTimeStampRecord(IndexWriter writer) throws java.io.IOException{
	Calendar cal = Calendar.getInstance();
	DateFormat df = new SimpleDateFormat(LuceneFields.TIMESTAMP_FORMAT);
	String dateAsString = df.format(cal.getTime());

	Document doc = new Document();
	doc.add(new StoredField(UtilLucene.storedName(LuceneFields.TIMESTAMP_FIELD), dateAsString));
	doc.add(new StringField(LuceneFields.TIMESTAMP_FIELD, dateAsString.toLowerCase(), Field.Store.NO));

	long timeInMillis = cal.getTimeInMillis();
	doc.add(new StoredField(UtilLucene.storedName(LuceneFields.TIMESTAMP_FIELD_IN_MILLIS), timeInMillis));
	doc.add(new LongField(LuceneFields.TIMESTAMP_FIELD_IN_MILLIS, timeInMillis, Field.Store.NO));

	doc.add(new StringField(LuceneFields.RECORD_TYPE, LuceneFields.TIMESTAMP_TYPE, Field.Store.YES));
	doc.add(new StoredField(UtilLucene.storedName(LuceneFields.RECORD_TYPE), LuceneFields.TIMESTAMP_TYPE));


	writer.addDocument(doc);
    }    
}
