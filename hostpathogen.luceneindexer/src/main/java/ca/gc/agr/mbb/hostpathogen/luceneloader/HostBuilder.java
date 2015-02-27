package ca.gc.agr.mbb.hostpathogen.hostpathogenluceneloader;

import java.util.ArrayList;

public class HostBuilder extends Builder{



    // pk_host_id,fk_higher_taxa_id,fk_host_id_accepted,host_genus,host_species,host_subspecific_taxa,host_author,cultivar,english_name,french_name,host_notes,verify,QD


    public static final String[] HOST_FIELDS={
	CULTIVAR,
	FK_HIGHER_TAXA_ID,
	FK_HOST_ID_ACCEPTED,
	HOST_AUTHOR,
	HOST_GENUS,
	HOST_SPECIES,
	HOST_SUBSPECIFIC_TAXA,
	PK_HOST_ID
    };

    public HostBuilder(final String csvFilename){
	super(csvFilename);
    }

    @Override
    public void init(){
	objectFields = HOST_FIELDS;
	primaryKeyField = PK_HOST_ID;
	recordType = HOST_TYPE;
    }

}
