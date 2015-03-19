package ca.gc.agr.mbb.hostpathogen.luceneloader;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;


public class AuthorBuilder extends Builder{



    public static final String[] AUTHOR_FIELDS={
	LOOKUP_AUTHOR,
	PK_AUTHOR_LOOKUP_ID,
    };


    public AuthorBuilder(final String csvFilename){
	super(csvFilename);
    }

    @Override
    public void init(){
	objectFields = AUTHOR_FIELDS;
	primaryKeyField = PK_AUTHOR_LOOKUP_ID;
	recordType = AUTHOR_TYPE;
    }


}
