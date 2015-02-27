package ca.gc.agr.mbb.hostpathogen.hostpathogenluceneloader;

import java.util.ArrayList;

public class ReferenceBuilder extends Builder{

    public static final String[] REFERENCE_FIELDS={
	PK_REFERENCE_ID,
	CHAPTER_ARTICLE_TITLE,
	DATA_SOURCE,
	PAGES,
	REFERENCE_AUTHORS,
	REFERENCE_YEAR,
	VOLUME,
    };

    @Override
    public void init(){
	objectFields = REFERENCE_FIELDS;
	primaryKeyField = PK_REFERENCE_ID;
	recordType = REFERENCE_TYPE;
    }


    public ReferenceBuilder(final String csvFilename){
	super(csvFilename);
    }


}
