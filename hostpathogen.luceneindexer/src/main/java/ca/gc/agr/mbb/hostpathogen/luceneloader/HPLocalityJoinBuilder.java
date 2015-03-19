package ca.gc.agr.mbb.hostpathogen.luceneloader;

import java.util.ArrayList;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.HPLocalityJoin;

public class HPLocalityJoinBuilder extends Builder{

    public static final String[] HP_LOCALITY_JOIN_FIELDS={
	HPLocalityJoin.FK_HOST_PATHOGEN_ID,
	HPLocalityJoin.FK_LOCATION_ID,
    };

    public HPLocalityJoinBuilder(final String csvFilename){
	super(csvFilename);
    }

    @Override
    public void init(){
	objectFields = HP_LOCALITY_JOIN_FIELDS;

	//primaryKeyField = HPLocalityJoin.PK_LOCALITY_LINK_ID;
	// We do look ups based on FK_HOST_PATHOGEN_ID
	primaryKeyField = FK_HOST_PATHOGEN_ID;

	recordType = HP_LOCALITY_JOIN_TYPE;
    }

}
