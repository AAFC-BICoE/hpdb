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
import ca.gc.agr.mbb.hostpathogen.nouns.HostPathogen;
import ca.gc.agr.mbb.hostpathogen.nouns.Pathogen;
import ca.gc.agr.mbb.hostpathogen.nouns.Host;
import ca.gc.agr.mbb.hostpathogen.nouns.Reference;

@RunWith(JUnit4.class)
public class HPSearcher_HostPathogenTest implements HPSearch{
    private final static Logger LOG = Logger.getLogger(HPSearcher_HostPathogenTest.class.getName()); 

    static LuceneConfig hostPathogenConfig;

    static{
	try{
	    hostPathogenConfig = UtilLucene.luceneConfig(LuceneFields.HOST_PATHOGEN_TYPE, UtilTest.goodProperties);
	}catch(InitializationException e){
	    e.printStackTrace();
	}
    }

    @Test(expected=IllegalArgumentException.class)
    public void getByShouldFailForBadClass() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	SearcherDao<HostPathogen> hps = new HPSearcher<HostPathogen>(HostPathogen.class);
	hps.init(hostPathogenConfig);
	// getBy is for relations, so this needs to be another class, as defined in HostPathogenPopulator (i.e. Host, Pathogen, Reference)
	List<Long> results = hps.getBy(HostPathogen.class, 43, 1,20);
    }

    @Test
    public void hostPathogenGetByHostShouldWorkWithGoodFK() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	SearcherDao<HostPathogen> hps = new HPSearcher<HostPathogen>(HostPathogen.class);
	hps.init(hostPathogenConfig);
	List<Long> results = hps.getBy(Host.class, GOOD_HP_HOST_FK, 1,20);
	Assert.assertTrue(results != null && results.size()>0);
    }

    @Test
    public void hostPathogenGetByPathogenShouldWorkWithGoodFK() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	SearcherDao<HostPathogen> hps = new HPSearcher<HostPathogen>(HostPathogen.class);
	hps.init(hostPathogenConfig);
	List<Long> results = hps.getBy(Pathogen.class, GOOD_HP_PATHOGEN_FK, 1,20);
	Assert.assertTrue(results != null && results.size()>0);
    }

    @Test
    public void hostPathogenGetByReferenceShouldWorkWithGoodFK() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	SearcherDao<HostPathogen> hps = new HPSearcher<HostPathogen>(HostPathogen.class);
	hps.init(hostPathogenConfig);
	List<Long> results = hps.getBy(Reference.class, GOOD_HP_REFERENCE_FK, 1,20);
	Assert.assertTrue(results != null && results.size()>0);
    }


    
}
