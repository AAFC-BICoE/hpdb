package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;

import org.apache.lucene.document.Document;
import ca.gc.agr.mbb.hostpathogen.nouns.RefSources;


public class RefSourcesPopulator<T> extends BasePopulator{
    
    public RefSourcesPopulator(){
	recordType = REF_SOURCES_TYPE;
	classType = RefSources.class;

	addSortFields(JOURNAL_TITLE, BOOK_YEAR, BOOK_AUTHOR, BOOK_TITLE);
	addDefaultSortFields(JOURNAL_TITLE);
	addSearchFields(JOURNAL_TITLE, BOOK_YEAR, BOOK_AUTHOR, BOOK_TITLE);
    }

    @Override
    public final T populate(Document doc) throws FailedPopulateException{
	super.populate(doc);
	RefSources rs = new RefSources();

	rs.setId(longValue(doc, stored(primaryKeyField), true));
	rs.setReferenceId(longValue(doc, stored(FK_REFERENCE_ID), true));

	rs.setJournal(stringValue(doc, stored(JOURNAL_TITLE)));

	rs.setTitle(stringValue(doc, stored(BOOK_TITLE)));

	rs.setEditor(stringValue(doc, stored(BOOK_EDITOR)));

	rs.setAuthor(stringValue(doc, stored(BOOK_AUTHOR)));

	rs.setYear(stringValue(doc, stored(BOOK_YEAR)));

	rs.setJournalTitle(stringValue(doc, stored(JOURNAL_TITLE)));

	rs.setPublisher(stringValue(doc, stored(BOOK_PUBLISHER)));

	// Waiting for change to BookPublishingPlace
	//rs.setCity(stringValue(doc, stored())); 

	rs.setPages(stringValue(doc, stored(BOOK_PAGES)));

	return (T)rs;
    }



}
