package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ca.gc.agr.mbb.hostpathogen.nouns.Pathogen;
import ca.gc.agr.mbb.hostpathogen.nouns.Host;
import ca.gc.agr.mbb.hostpathogen.nouns.HostPathogen;
import ca.gc.agr.mbb.hostpathogen.nouns.Reference;

@RunWith(JUnit4.class)
public class HPSearcherTest implements HPSearch{
    private final static Logger LOG = Logger.getLogger(HPSearcherTest.class.getName()); 

    static LuceneConfig pathogenConfig;

    static{
	try{
	    pathogenConfig = UtilLucene.luceneConfig(LuceneFields.PATHOGEN_TYPE, UtilTest.goodProperties);

	}catch(InitializationException e){
	    e.printStackTrace();
	}
    }

    @Test
    public void shouldConstructOK() throws InitializationException{
	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
	Assert.assertTrue(hps != null);
    }

   @Test
    public void shouldInitOKWithGoodConfig() throws InitializationException{
       SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
       hps.init(pathogenConfig);
	
    }

    @Test(expected=InitializationException.class)
    public void shouldFailWithNullConfig() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
       hps.init(null);
    }

    static Map<String, List<String>> makeSimpleQuery(String queryField, String queryString){
	List<String> values = new ArrayList<String>();
	values.add(queryString);

	Map<String, List<String>> queryParameters = new HashMap<String, List<String>>();
	queryParameters.put(queryField, values);
	return queryParameters;
	
    }

    static List<String> goodHostSortFields(){
	List<String> sf = new ArrayList<String>();
	sf.add(LuceneFields.HOST_GENUS);
	return sf;
    }

    static List<String> badHostSortFields(){
	List<String> sf = new ArrayList<String>();
	sf.add(LuceneFields.PATHOGEN_GENUS);
	return sf;
    }
}
