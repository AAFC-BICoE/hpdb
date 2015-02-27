package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;

import org.apache.lucene.document.Document;
import ca.gc.agr.mbb.hostpathogen.nouns.Anamorph;

public class AnamorphPopulator<T> extends BasePopulator{

    public AnamorphPopulator(){
	recordType = ANAMORPH_TYPE;
	classType = Anamorph.class;
    }

    @Override
    public final T populate(Document doc) throws FailedPopulateException{
	super.populate(doc);
	 Anamorph h = new Anamorph();
	// // obligatory
	 h.setId(longValue(doc, stored(primaryKeyField), true));
	 h.setAnamorphId(longValue(doc, stored(LuceneFields.FK_PATHOGEN_ID_ANA), true));
	 h.setSynanamorphId(longValue(doc, stored(LuceneFields.FK_PATHOGEN_ID_SYN), true));
	 h.setSynanamorphId2(longValue(doc, stored(LuceneFields.FK_PATHOGEN_ID_SYN2), true));
	 return (T)h;
    }



}
