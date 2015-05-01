package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;

import org.apache.lucene.document.Document;
import ca.gc.agr.mbb.hostpathogen.nouns.Host;
import ca.gc.agr.mbb.hostpathogen.nouns.Reference;

public class HostPopulator<T> extends BasePopulator{

    public HostPopulator(){
	recordType = HOST_TYPE;
	classType = Host.class;
	addSortFields(HOST_GENUS, HOST_SPECIES);
	addDefaultSortFields(HOST_GENUS, HOST_SPECIES, HOST_SUBSPECIFIC_TAXA);
	addSearchFields(HOST_GENUS, HOST_SPECIES, HOST_SUBSPECIFIC_TAXA);


    }

    @Override
    public final T populate(Document doc) throws FailedPopulateException{
	super.populate(doc);
	Host h = new Host();

	// obligatory
	h.setId(longValue(doc, stored(primaryKeyField), true));
	h.setGenus(stringValue(doc, stored(HOST_GENUS), true));
	//
	h.setSpecies(stringValue(doc, stored(HOST_SPECIES)));
	h.setHigherTaxaId(longValue(doc, stored(FK_HIGHER_TAXA_ID)));
	h.setIdAccepted(longValue(doc, stored(FK_HOST_ID_ACCEPTED)));
	h.setCultivar(stringValue(doc, stored(CULTIVAR)));
	h.setAuthor(stringValue(doc, stored(HOST_AUTHOR)));
	return (T)h;
    }



}
