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


@RunWith(JUnit4.class)
public class HPSearcher_HostTest extends BaseNoun implements HPSearch {
    private final static Logger LOG = Logger.getLogger(HPSearcher_HostTest.class.getName()); 

    static LuceneConfig hostConfig;

    static{
	validIds = new Long[] {1l,2l,3l,4l,5l,6l,7l,8l,9l,10l};
	invalidIds = new Long[] {711049l, 711050l, 711058l};
	try{
	    hostConfig = UtilLucene.luceneConfig(LuceneFields.HOST_TYPE, UtilTest.goodProperties);
	}catch(InitializationException e){
	    e.printStackTrace();
	}
    }

   @Test
   public void shouldGetAllHosts() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
       //SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
       SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
       hps.init(hostConfig);
       List<Long> all = hps.getAll(1,40);	   
       Assert.assertTrue(all != null && all.size() >0);
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void shouldFailWithNegativeOffset() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
	//SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
	SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
	hps.init(hostConfig);
	List<Long> all = hps.getAll(-1,10);	   
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void shouldFailWithBadLimit() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
	//SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
	SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
       hps.init(hostConfig);
       List<Long> all = hps.getAll(10,-1);	   
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void shouldFailWithTooLargeOffset() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
	//SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
       hps.init(hostConfig);
       List<Long> all = hps.getAll(10,1000);	   
    }



   @Test
   public void shouldGetAllHostsCount() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
       //SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
       SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
       hps.init(hostConfig);
       long allCount = hps.getAllCount();	   
       Assert.assertTrue(allCount >0);
    }



   @Test
   public void shouldGetSingleHostById() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
       SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
       hps.init(hostConfig);
       long id = validIds().get(0);	
       Host host = hps.get(id);
       Assert.assertTrue(host != null);
    }


   @Test
   public void shouldGetMultipleHostById() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
       SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
       hps.init(hostConfig);
       List<Host> hosts = hps.get(validIds());
       Assert.assertTrue(hosts != null && hosts.size() > 0);
    }


    @Test
    public void searchHostSuccessfully() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.HOST_GENUS, GOOD_HOST_GENUS);
	SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
	hps.init(hostConfig);
	List<Long> results = hps.search(queryParameters, HPSearcherTest.goodHostSortFields(), 1,3);
	Assert.assertTrue(results != null && results.size()>0);
    }

    @Test
    public void searchHostCountSuccessfully() throws IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.HOST_GENUS, GOOD_HOST_GENUS);
	SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
	hps.init(hostConfig);
	long results = hps.searchCount(queryParameters);
	Assert.assertTrue(results>0l);
    }

    @Test
    public void searchHostSuccessfullyWithSorting() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.HOST_GENUS, GOOD_HOST_GENUS);
	SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
	hps.init(hostConfig);
	List<Long> results = hps.search(queryParameters, HPSearcherTest.goodHostSortFields(), 1,20);
	Assert.assertTrue(results != null && results.size()>0);
    }

    public void shouldFailWithSearchHostWithBadSortField() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.HOST_GENUS, GOOD_HOST_GENUS);
	SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
	hps.init(hostConfig);
	List<Long> results = hps.search(queryParameters, HPSearcherTest.badHostSortFields(), 1,20);
    }

    @Test
    public void searchHostSuccessfullyWithSortingValidated() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.HOST_GENUS, A_STAR_WILDCARD);
	SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
	hps.init(hostConfig);
	List<Long> results = hps.search(queryParameters, HPSearcherTest.goodHostSortFields(), 1,3);
	Assert.assertTrue(results != null && results.size()>1 );
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void searchShouldFailWithBadOffset() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.HOST_GENUS, GOOD_HOST_GENUS);
	SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
	hps.init(hostConfig);
	List<Long> results = hps.search(queryParameters, HPSearcherTest.goodHostSortFields(), -1,3);
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void searchShouldFailWithBadLimit() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.HOST_GENUS, GOOD_HOST_GENUS);
	SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
	hps.init(hostConfig);
	List<Long> results = hps.search(queryParameters, HPSearcherTest.goodHostSortFields(), 10,-3);
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void searchShouldFailWithTooBigLimit() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.HOST_GENUS, GOOD_HOST_GENUS);
	SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
	hps.init(hostConfig);
	List<Long> results = hps.search(queryParameters, HPSearcherTest.goodHostSortFields(), 10,9999);
    }


    @Test(expected=IllegalArgumentException.class)
    public void searchShouldFailwithBadSearchFields() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.PATHOGEN_GENUS, null);
	SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
	hps.init(hostConfig);
	List<Long> results = hps.search(queryParameters, HPSearcherTest.goodHostSortFields(), 1,3);
    }

    @Test
    public void searchShouldReturnZeroResultsWithBadSearch() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.HOST_GENUS, BAD_HOST_GENUS);
	SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
	hps.init(hostConfig);
	List<Long> results = hps.search(queryParameters, HPSearcherTest.goodHostSortFields(), 1,15);
	Assert.assertTrue(results != null && results.size()==0);
    }

    @Test
    public void searchShouldReturnResultsWithGoodSearch() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.HOST_GENUS, GOOD_HOST_GENUS);
	SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
	hps.init(hostConfig);
	List<Long> results = hps.search(queryParameters, HPSearcherTest.goodHostSortFields(), 1,15);
	Assert.assertTrue(results != null && results.size()>0);
    }

    @Test(expected=InitializationException.class)
    public void shouldFailGetAllWithMismatcheNouns() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
        hps.init(hostConfig);
        List<Long> all = hps.getAll(1,10);	   
     }


}
