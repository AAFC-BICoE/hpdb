package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;

import java.util.Properties;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import ca.gc.agr.mbb.hostpathogen.nouns.Pathogen;
import ca.gc.agr.mbb.hostpathogen.nouns.Host;
import ca.gc.agr.mbb.hostpathogen.nouns.HostPathogen;

public class HPSearcherMock<T> implements SearcherDao<T>
{
    public static final int NUM_IDS = 100;

    // 2000-2099
    static List<Long>pathogenIds = null;
    static List<Pathogen>pathogens = null;

    // 100-199
    static List<Long>hostIds = null;
    static List<Host>hosts = null;

    // 200-299
    static List<Long>hostPathogenIds = null;
    static List<HostPathogen>hostPathogens = null;

    static{
	pathogenIds = new ArrayList<Long>(NUM_IDS);
	pathogens = new ArrayList<Pathogen>(NUM_IDS);

	hostIds = new ArrayList<Long>(NUM_IDS);
	hosts = new ArrayList<Host>(NUM_IDS);

	hostPathogenIds = new ArrayList<Long>(NUM_IDS);
	hostPathogens = new ArrayList<HostPathogen>(NUM_IDS);


	for(int i=0; i<NUM_IDS; i++){
	    long hid = (long)(100+i);
	    long pid = (long)(2000+i);
	    long phid = (long)(200+i);

	    hostIds.add(new Long(hid));
	    hostPathogenIds.add(new Long(phid));
	    pathogenIds.add(new Long(pid));

	    Pathogen pathogen = new Pathogen();
	    pathogen.setId(pid);
	    pathogen.setGenus("genus" + pid);
	    pathogen.setSpecies("species" + pid);
	    pathogens.add(pathogen);

	    Host host = new Host();
	    host.setId(pid);
	    host.setGenus("genus" + pid);
	    host.setSpecies("species" + pid);
	    hosts.add(host);

	    HostPathogen hostPathogen = new HostPathogen();
	    hostPathogen.setId(pid);
	    hostPathogens.add(hostPathogen);
	}
    }

    protected HPSearcherMock(){
	
    }

/** 
  * Initialize Searcher with Properties.
  *  Must be run before any other methods.
  * 
  * 
  * @param java.util.Properties - contains init information
  * @return Searcher 
  * @exception InitializationException
  */ 
    
    public SearcherDao init(Properties p) throws InitializationException{
    	// get 
    	return this;
    }

    @Override
    public void init(LuceneConfig lc) throws InitializationException{
	
    }

    @Override
    public List<Long>getAll(final long offset, final int limit) throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	return new ArrayList<Long>();
    }
   
    @Override
    public List<Long>search(Map<String,List<String>>queryParameters, List<String> sortFields, final long offset, final int limit) throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	return new ArrayList<Long>();
    }


    public List<T>get(final List<Long> ids) throws IllegalArgumentException, IndexFailureException, InitializationException{
	return new ArrayList<T>();
    }

    @Override
     public T get(final Long id) throws IllegalArgumentException, IndexFailureException, InitializationException{
	return null;
    }
    
    @Override
    public long getAllCount() throws IndexFailureException, InitializationException{
	return 10l;
    }
    
    @Override
	public long searchCount(Map<String,List<String>>queryParameters) throws IllegalArgumentException, IndexFailureException, InitializationException{
	return 10l;
    }

    @Override public List<Long> getBy(Class type, long foreignKeyId, final long offset, final int limit) throws IllegalArgumentException, IndexFailureException, IllegalOffsetLimitException{
	return null;
    }

    @Override
    public Date getTimeStamp() throws IndexFailureException{
	Calendar cal = Calendar.getInstance();
	cal.roll(Calendar.MONTH, -1);
	return cal.getTime();
    }

}

