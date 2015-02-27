package ca.gc.agr.mbb.hostpathogen.hostpathogenluceneloader;

import org.apache.commons.csv.CSVRecord;

import org.apache.lucene.document.Document;

public class AnamorphBuilder extends Builder{

    public static final String[] ANAMORPH_FIELDS={
	PK_ANAMORPH_ID,
	FK_PATHOGEN_ID_SYN,
	FK_PATHOGEN_ID_ANA,
	FK_PATHOGEN_ID_SYN2,
    };


    public AnamorphBuilder(final String csvFilename){
     	super(csvFilename);
    }

    @Override
    public void init(){
	objectFields = ANAMORPH_FIELDS;
	primaryKeyField = PK_ANAMORPH_ID;
	recordType = ANAMORPH_TYPE;
    }

}

