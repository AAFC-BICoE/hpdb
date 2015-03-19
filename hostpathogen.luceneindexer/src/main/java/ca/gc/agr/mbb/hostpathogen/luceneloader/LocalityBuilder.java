package ca.gc.agr.mbb.hostpathogen.luceneloader;

import java.util.ArrayList;

public class LocalityBuilder extends Builder{

    public static final String[] LOCALITY_FIELDS={
	PK_LOCATION_ID,
	PROVINCE_STATE_TERRITORY_ABBREVIATION,
	PROVINCE_STATE_TERRITORY,
	COUNTRY,
    };

    public LocalityBuilder(final String csvFilename){
	super(csvFilename);
    }

    @Override
    public void init(){
	objectFields = LOCALITY_FIELDS;
	primaryKeyField = PK_LOCATION_ID;
	recordType = LOCALITY_TYPE;
    }

}
