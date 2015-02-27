package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;

import org.apache.lucene.document.Document;
import ca.gc.agr.mbb.hostpathogen.nouns.Location;

public class LocationPopulator<T> extends BasePopulator{

    public LocationPopulator(){
	recordType = LOCALITY_TYPE;
	classType = Location.class;

	addSortFields(COUNTRY, PROVINCE_STATE_TERRITORY);
	addDefaultSortFields(COUNTRY, PROVINCE_STATE_TERRITORY);
	addSearchFields(COUNTRY);
    }

    @Override
    public final T populate(Document doc) throws FailedPopulateException{
	super.populate(doc);
	Location h = new Location();
	// obligatory
	h.setId(longValue(doc, stored(primaryKeyField), true));
	h.setProvinceStateTerritory(stringValue(doc, stored(PROVINCE_STATE_TERRITORY), true));
	h.setCountry(stringValue(doc, stored(COUNTRY), true));
	return (T)h;
    }



}
