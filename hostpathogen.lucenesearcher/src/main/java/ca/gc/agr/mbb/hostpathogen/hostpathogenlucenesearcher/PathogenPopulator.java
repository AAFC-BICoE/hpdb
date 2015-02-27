package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;

import org.apache.lucene.document.Document;
import ca.gc.agr.mbb.hostpathogen.nouns.Pathogen;
import ca.gc.agr.mbb.hostpathogen.nouns.Reference;

public class PathogenPopulator<T> extends BasePopulator{
    
    public PathogenPopulator(){
	recordType = PATHOGEN_TYPE;
	classType = Pathogen.class;
	addSortFields(PATHOGEN_GENUS, PATHOGEN_SPECIES, PATHOGEN_SUBSPECIFIC_TAXA);
	addDefaultSortFields(PATHOGEN_GENUS, PATHOGEN_SPECIES, PATHOGEN_SUBSPECIFIC_TAXA);
	addSearchFields(FUNGAL_STATE, PATHOGEN_AUTHOR, PATHOGEN_GENUS, PATHOGEN_SPECIES, PATHOGEN_SUBSPECIFIC_TAXA, PK_PATHOGEN_ID, VIRUS_MPLO_NAMES);
    }

    public final T populate(Document doc) throws FailedPopulateException{
	super.populate(doc);
	Pathogen p = new Pathogen();

	// obligatory
	p.setId(longValue(doc, stored(primaryKeyField), true));

	//
	p.setGenus(stringValue(doc, stored(PATHOGEN_GENUS)));
	p.setSpecies(stringValue(doc, stored(PATHOGEN_SPECIES)));
	p.setHigherTaxaId(longValue(doc, stored(FK_HIGHER_TAXA_ID)));
	p.setIdAccepted(longValue(doc, stored(FK_PATHOGEN_ID_ACCEPTED)));
	p.setAnamorphId(longValue(doc, stored(FK_ANAMORPH_ID)));
	p.setFungalState(stringValue(doc, stored(FUNGAL_STATE)));
	p.setAuthor(stringValue(doc, stored(PATHOGEN_AUTHOR)));
	p.setSubSpecificTaxa(stringValue(doc, stored(PATHOGEN_SUBSPECIFIC_TAXA)));
	p.setVirusMPLO(stringValue(doc, stored(VIRUS_MPLO_NAMES)));
	return (T)p;
    }



}
