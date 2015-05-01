package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;
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
public class HPSearcherTimeTest{
    private final static Logger LOG = Logger.getLogger(HPSearcherTest.class.getName()); 

    static LuceneConfig pathogenConfig;
    static{
	try{
	    pathogenConfig = UtilLucene.luceneConfig(LuceneFields.PATHOGEN_TYPE, UtilTest.goodProperties);
	}catch(InitializationException e){
	    e.printStackTrace();
	}
    }

    @Test(expected=InitializationException.class)
    public void shouldFailIfNotInited() throws IndexFailureException,InitializationException{
	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
	Date timeStamp = hps.getTimeStamp();
    }

    @Test()
    public void shouldReturnNotNullTime() throws IndexFailureException,InitializationException{
	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
	hps.init(pathogenConfig);
	Date timeStamp = hps.getTimeStamp();

	Assert.assertTrue(timeStamp != null);
    }

}
