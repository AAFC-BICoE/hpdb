package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;

import org.apache.lucene.document.Document;
import ca.gc.agr.mbb.hostpathogen.nouns.HigherTaxa;

public class HigherTaxaPopulator<T> extends BasePopulator{

    public HigherTaxaPopulator(){
	classType = HigherTaxa.class;
	recordType = HIGHER_TAXA_TYPE;

	addSortFields(KINGDOM, DIVISION, CLASS, ORDER, FAMILY);
	addDefaultSortFields(FAMILY);
    }

    @Override
    public final T populate(Document doc) throws FailedPopulateException{
	super.populate(doc);

	HigherTaxa h = new HigherTaxa();
	
	// obligatory
	h.setId(longValue(doc, primaryKeyField+STORED_SUFFIX, true));

	h.setKingdom(stringValue(doc, stored(KINGDOM)));
	h.setDivision(stringValue(doc, stored(DIVISION)));
	h.setClazz(stringValue(doc, stored(CLASS)));
	h.setOrder(stringValue(doc, stored(ORDER)));
	h.setFamily(stringValue(doc, stored(FAMILY)));
	return (T)h;
    }



}
