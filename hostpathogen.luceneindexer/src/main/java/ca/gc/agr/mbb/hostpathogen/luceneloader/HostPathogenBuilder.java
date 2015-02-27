package ca.gc.agr.mbb.hostpathogen.hostpathogenluceneloader;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVRecord;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.document.StringField;

public class HostPathogenBuilder extends Builder{
    private final Logger LOG = Logger.getLogger(HostPathogenBuilder.class.getName());

    private CSVMap pathogenMap, hostMap, hpLocalityLinksMap, localityMap;
    private String csvDir, hostCsv,  pathogenCsv,hpLocalityLinksCsv, localityCsv;

    public static final String[] HOST_PATHOGEN_FIELDS={
	PK_HOST_PATHOGEN_ID,
	FK_REFERENCE_ID,
	FK_HOST_ID,
	FK_PATHOGEN_ID,
	RUST_STATE,
	PLANT_PART,
	SYMPTOM,
	NOTES,
    };

    @Override
    public void init(){
	objectFields = HOST_PATHOGEN_FIELDS;
	primaryKeyField = PK_HOST_PATHOGEN_ID;
	recordType = HOST_PATHOGEN_TYPE;

	pathogenMap = new CSVMapImpl();
	CSVMapLoader.load(pathogenMap, csvDir, pathogenCsv, PK_PATHOGEN_ID);
	hostMap = new CSVMapImpl();
	CSVMapLoader.load(hostMap, csvDir, hostCsv, PK_HOST_ID);

	hpLocalityLinksMap = new CSVMultiMap();
	CSVMapLoader.load(hpLocalityLinksMap, csvDir, hpLocalityLinksCsv, FK_HOST_PATHOGEN_ID);

	localityMap = new CSVMapImpl();
	CSVMapLoader.load(localityMap, csvDir, localityCsv, PK_LOCATION_ID);;

	LOG.info("################ init done");
	
    }

    public HostPathogenBuilder(final String csvFilename, final String hostCsv, final String pathogenCsv, final String hpLocalityLinksCsv, final String localityCsv, String csvDir){
	super(csvFilename);
	this.hostCsv = hostCsv;
	this.pathogenCsv = pathogenCsv;
	this.csvDir = csvDir;
	this.hpLocalityLinksCsv = hpLocalityLinksCsv;
	this.localityCsv = localityCsv;
    }

    public void afterMakeDocument(final Document doc){

	CSVRecord pathogen = pathogenMap.get(doc.getValues(FK_PATHOGEN_ID + STORED_SUFFIX)[0]);
	//System.out.println("HostPathogenBuilder.afterMakeDocument: " + pathogen);
	//System.out.println("HostPathogenBuilder.afterMakeDocument: pathogen.get(PATHOGEN_GENUS)" + pathogen.get(PATHOGEN_GENUS));
	doc.add(new StringField(PATHOGEN_GENUS, pathogen.get(PATHOGEN_GENUS), Field.Store.YES));
	doc.add(new StringField(PATHOGEN_SPECIES, pathogen.get(PATHOGEN_SPECIES), Field.Store.YES));

	CSVRecord host = hostMap.get(doc.getValues(FK_HOST_ID + STORED_SUFFIX)[0]);
	//System.out.println("HostPathogenBuilder.afterMakeDocument: " + host);
	doc.add(new StringField(HOST_GENUS, host.get(HOST_GENUS), Field.Store.YES));
	doc.add(new StringField(HOST_SPECIES, host.get(HOST_SPECIES), Field.Store.YES));
	doc.add(new StringField(CULTIVAR, host.get(CULTIVAR), Field.Store.YES));


	//LOG.info(doc.toString());
	// Get all the locality join records with fk_host_pathogen_id = HostPathogen.ID
	List<CSVRecord> hpJoin = hpLocalityLinksMap.getAll(doc.getValues(PK)[0]);
	//System.err.println(doc.getValues(PK)[0]);
	//System.err.println("Lenght of join=" + hpJoin.size());
	if (hpJoin != null){
	    // Only store/index unique countries
	    Set<String> countrySet = new HashSet<String>(3);
		for(CSVRecord r: hpJoin){
		    //System.err.println(r);
		    CSVRecord locality = localityMap.get(r.get(FK_LOCATION_ID));
		    //System.err.println("\t" + locality);

		    String country = locality.get(COUNTRY);
		    if (!countrySet.contains(country)){
			doc.add(new StringField(COUNTRY, country, Field.Store.YES));
			countrySet.add(country);
		    }
		    doc.add(new StringField(PK_LOCATION_ID, locality.get(PK_LOCATION_ID), Field.Store.YES));
		    doc.add(new StringField(PROVINCE_STATE_TERRITORY_ABBREVIATION, locality.get(PROVINCE_STATE_TERRITORY_ABBREVIATION), Field.Store.YES));
		    doc.add(new StringField(PROVINCE_STATE_TERRITORY, locality.get(PROVINCE_STATE_TERRITORY), Field.Store.YES));

		}
	    }
    }

}
