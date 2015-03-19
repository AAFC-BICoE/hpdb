package ca.gc.agr.mbb.hostpathogen.luceneloader;

import java.util.ArrayList;

public class ReferenceSourceBuilder extends Builder{

    public static final String[] REF_SOURCE_FIELDS={
	BOOK_AUTHOR,
	BOOK_EDITOR,
	BOOK_PAGES,
	BOOK_PUBLISHER,
	BOOK_PUBLISHER_PLACE,
	BOOK_TITLE,
	BOOK_YEAR,
	JOURNAL_ABBREVIATION,
	JOURNAL_TITLE,
	PK_REF_SOURCE_ID,
    };

    @Override
    public void init(){
	objectFields = REF_SOURCE_FIELDS;
	primaryKeyField = PK_REF_SOURCE_ID;
	recordType = REF_SOURCES_TYPE;
    }

    public ReferenceSourceBuilder(final String csvFilename){
	super(csvFilename);
    }

}
