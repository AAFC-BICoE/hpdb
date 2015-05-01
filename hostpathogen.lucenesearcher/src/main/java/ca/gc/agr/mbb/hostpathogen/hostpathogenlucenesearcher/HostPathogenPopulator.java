package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;

import org.apache.lucene.document.Document;
import ca.gc.agr.mbb.hostpathogen.nouns.HostPathogen;
import ca.gc.agr.mbb.hostpathogen.nouns.Pathogen;
import ca.gc.agr.mbb.hostpathogen.nouns.Host;
import ca.gc.agr.mbb.hostpathogen.nouns.Reference;

public class HostPathogenPopulator<T> extends BasePopulator{
    
    public HostPathogenPopulator(){
	recordType = HOST_PATHOGEN_TYPE;
	classType = HostPathogen.class;
	addSortFields(PATHOGEN_GENUS, PATHOGEN_SPECIES, HOST_GENUS, HOST_SPECIES, HOST_SUBSPECIFIC_TAXA);
	addDefaultSortFields(HOST_GENUS, HOST_SPECIES, HOST_SUBSPECIFIC_TAXA);

	addSearchFields(HOST_GENUS, HOST_SPECIES);

	addRelation(Host.class, FK_HOST_ID);
	addRelation(Pathogen.class, FK_PATHOGEN_ID);
	addRelation(Reference.class, FK_REFERENCE_ID);
    }

    @Override
    public final T populate(Document doc) throws FailedPopulateException{
	super.populate(doc);
	HostPathogen p = new HostPathogen();
	p.setId(longValue(doc, stored(primaryKeyField), true));

	p.setReferenceId(longValue(doc, stored(FK_REFERENCE_ID), true));
	p.setHostId(longValue(doc, stored(FK_HOST_ID), true));
	p.setPathogenId(longValue(doc, stored(FK_PATHOGEN_ID), true));
	//
	p.setRustState(stringValue(doc, stored(RUST_STATE)));
	p.setPlantPart(stringValue(doc, stored(PLANT_PART)));
	p.setSymptom(stringValue(doc, stored(SYMPTOM)));
	p.setNotes(stringValue(doc,  stored(NOTES)));
	return (T)p;
    }



}
