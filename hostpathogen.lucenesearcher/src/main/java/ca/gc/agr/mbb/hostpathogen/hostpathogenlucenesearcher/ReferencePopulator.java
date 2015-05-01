package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;

import org.apache.lucene.document.Document;
import ca.gc.agr.mbb.hostpathogen.nouns.Reference;


public class ReferencePopulator<T> extends BasePopulator{
    
    public ReferencePopulator(){
	recordType = REFERENCE_TYPE;
	classType = Reference.class;

	addSortFields(REFERENCE_YEAR, REFERENCE_AUTHORS);
	addDefaultSortFields(REFERENCE_AUTHORS, REFERENCE_YEAR);
	addSearchFields(REFERENCE_AUTHORS, REFERENCE_YEAR);
    }

    @Override
    public final T populate(Document doc) throws FailedPopulateException{
	super.populate(doc);
	Reference ref = new Reference();
	// obligatory
	ref.setId(longValue(doc, stored(primaryKeyField), true));
	if (doc.get(stored(FK_REF_SOURCE_ID)) == null){
		System.err.println("************** " + doc);
	    }

	ref.setSourceId(longValue(doc, stored(FK_REF_SOURCE_ID))); // Thought should be mandatory
	ref.setAuthor(stringValue(doc, stored(REFERENCE_AUTHORS))); // Thought should be mandatory
	ref.setYear(stringValue(doc, stored(REFERENCE_YEAR))); // Thought should be mandatory

	ref.setTitle(stringValue(doc, stored(CHAPTER_ARTICLE_TITLE))); // Thought should be mandatory

	ref.setVolume(stringValue(doc, stored(VOLUME)));
	ref.setPage(stringValue(doc, stored(PAGES)));

	return (T)ref;
    }



}
