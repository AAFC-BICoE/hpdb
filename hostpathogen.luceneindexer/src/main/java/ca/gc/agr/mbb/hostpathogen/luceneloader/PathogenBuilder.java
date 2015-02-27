package ca.gc.agr.mbb.hostpathogen.hostpathogenluceneloader;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;


public class PathogenBuilder extends Builder{

    public static final String[] PATHOGEN_FIELDS={
	FK_ANAMORPH_ID,
	FK_HIGHER_TAXA_ID,
	FK_PATHOGEN_ID_ACCEPTED,
	FUNGAL_STATE,
	PATHOGEN_AUTHOR,
	PATHOGEN_GENUS,
	PATHOGEN_SPECIES,
	PATHOGEN_SUBSPECIFIC_TAXA,
	PK_PATHOGEN_ID,
	VIRUS_MPLO_NAMES
    };

    public PathogenBuilder(final String csvFilename){
	super(csvFilename);
    }

    @Override
    public void init(){
	objectFields = PATHOGEN_FIELDS;
	primaryKeyField = PK_PATHOGEN_ID;
	recordType = PATHOGEN_TYPE;
    }


}
