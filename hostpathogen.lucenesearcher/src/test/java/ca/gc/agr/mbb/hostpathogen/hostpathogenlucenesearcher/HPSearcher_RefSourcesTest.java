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

import ca.gc.agr.mbb.hostpathogen.nouns.RefSources;
import ca.gc.agr.mbb.hostpathogen.nouns.Pathogen;


@RunWith(JUnit4.class)
public class HPSearcher_RefSourcesTest  extends BaseNoun implements HPSearch{
    private final static Logger LOG = Logger.getLogger(HPSearcher_RefSourcesTest.class.getName()); 

    static LuceneConfig refSourcesConfig;

    static final String VALID_REFERENCE_AUTHOR = "Allen*";

    static final String VALID_JOURNAL_TITLE = "American*";

    static{
	validIds = new Long[] {1l,2l,3l,4l,5l,6l,7l,8l,9l,10l};
	invalidIds = new Long[] {711049l, 711050l, 711058l};

	validSortFields = new String[]{LuceneFields.JOURNAL_TITLE};
	invalidSortFields = new String[]{"foobarx"};


	try{
	    refSourcesConfig = UtilLucene.luceneConfig(LuceneFields.REF_SOURCES_TYPE, UtilTest.goodProperties);
	}catch(InitializationException e){
	    e.printStackTrace();
	}
    }

   @Test
   public void shouldGetAllRefSourcess() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
       SearcherDao<RefSources> hps = new HPSearcher<RefSources>(RefSources.class);
       hps.init(refSourcesConfig);
       List<Long> all = hps.getAll(1,10);	   
       Assert.assertTrue(all != null && all.size() >0);
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void shouldFailWithNegativeOffset() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
	//SearcherDao<RefSources> hps = new HPSearcher<RefSources>(RefSources.class);
	SearcherDao<RefSources> hps = new HPSearcher<RefSources>(RefSources.class);
       hps.init(refSourcesConfig);
       List<Long> all = hps.getAll(-1,10);	   
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void shouldFailWithBadLimit() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
	//SearcherDao<RefSources> hps = new HPSearcher<RefSources>(RefSources.class);
SearcherDao<RefSources> hps = new HPSearcher<RefSources>(RefSources.class);
       hps.init(refSourcesConfig);
       List<Long> all = hps.getAll(10,-1);	   
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void shouldFailWithTooLargeOffset() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
	//SearcherDao<RefSources> hps = new HPSearcher<RefSources>(RefSources.class);
SearcherDao<RefSources> hps = new HPSearcher<RefSources>(RefSources.class);
       hps.init(refSourcesConfig);
       List<Long> all = hps.getAll(10,1000);	   
    }



   @Test
   public void shouldGetAllRefSourcessCount() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
       //SearcherDao<RefSources> hps = new HPSearcher<RefSources>(RefSources.class);
       SearcherDao<RefSources> hps = new HPSearcher<RefSources>(RefSources.class);
       hps.init(refSourcesConfig);
       long allCount = hps.getAllCount();	   
       Assert.assertTrue(allCount >0);
    }



   @Test
   public void shouldGetSingleRefSourcesById() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
       SearcherDao<RefSources> hps = new HPSearcher<RefSources>(RefSources.class);
       hps.init(refSourcesConfig);

       RefSources refSources = hps.get(validIds().get(0));
       Assert.assertTrue(refSources != null);
    }


    @Test
    public void searchRefSourcesSuccessfully() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.JOURNAL_TITLE, VALID_JOURNAL_TITLE);
	SearcherDao<RefSources> hps = new HPSearcher<RefSources>(RefSources.class);
	hps.init(refSourcesConfig);
	List<Long> results = hps.search(queryParameters, validSortFields(), 1,3);
	Assert.assertTrue(results != null && results.size()>0);
    }

    @Test
    public void searchRefSourcesCountSuccessfully() throws IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.JOURNAL_TITLE, VALID_JOURNAL_TITLE);
	SearcherDao<RefSources> hps = new HPSearcher<RefSources>(RefSources.class);
	hps.init(refSourcesConfig);
	long results = hps.searchCount(queryParameters);
	Assert.assertTrue(results>0l);
    }

    @Test
    public void searchRefSourcesSuccessfullyWithSorting() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.JOURNAL_TITLE, VALID_JOURNAL_TITLE);
	SearcherDao<RefSources> hps = new HPSearcher<RefSources>(RefSources.class);
	hps.init(refSourcesConfig);
	List<Long> results = hps.search(queryParameters, validSortFields(), 1,20);
	Assert.assertTrue(results != null && results.size()>0);
    }

    public void shouldFailWithSearchRefSourcesWithBadSortField() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery("x", "y");
	SearcherDao<RefSources> hps = new HPSearcher<RefSources>(RefSources.class);
	hps.init(refSourcesConfig);
	List<Long> results = hps.search(queryParameters, HPSearcherTest.badHostSortFields(), 1,20);
    }

    @Test(expected=IllegalArgumentException.class)
    public void searchRefSourcesFailWithWrongFields() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.HOST_GENUS, A_STAR_WILDCARD);
	SearcherDao<RefSources> hps = new HPSearcher<RefSources>(RefSources.class);
	hps.init(refSourcesConfig);
	List<Long> results = hps.search(queryParameters, validSortFields(), 1,3);
    }

    @Test
    public void searchRefSourcesSuccessfullyWithSortingValidated() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.JOURNAL_TITLE, VALID_JOURNAL_TITLE);
	SearcherDao<RefSources> hps = new HPSearcher<RefSources>(RefSources.class);
	hps.init(refSourcesConfig);
	List<Long> results = hps.search(queryParameters, validSortFields(), 1,3);
	Assert.assertTrue(results != null && results.size()>=1 );
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void searchShouldFailWithBadOffset() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.JOURNAL_TITLE, VALID_JOURNAL_TITLE);
	SearcherDao<RefSources> hps = new HPSearcher<RefSources>(RefSources.class);
	hps.init(refSourcesConfig);
	List<Long> results = hps.search(queryParameters, validSortFields(), -1,3);
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void searchShouldFailWithBadLimit() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.JOURNAL_TITLE, VALID_JOURNAL_TITLE);
	SearcherDao<RefSources> hps = new HPSearcher<RefSources>(RefSources.class);
	hps.init(refSourcesConfig);
	List<Long> results = hps.search(queryParameters, validSortFields(), 10,-3);
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void searchShouldFailWithTooBigLimit() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.JOURNAL_TITLE, VALID_JOURNAL_TITLE);
	SearcherDao<RefSources> hps = new HPSearcher<RefSources>(RefSources.class);
	hps.init(refSourcesConfig);
	List<Long> results = hps.search(queryParameters, validSortFields(), 10,9999);
    }


    @Test(expected=IllegalArgumentException.class)
    public void searchShouldFailwithBadSearchFields() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.REFERENCE_AUTHORS, null);
	SearcherDao<RefSources> hps = new HPSearcher<RefSources>(RefSources.class);
	hps.init(refSourcesConfig);
	List<Long> results = hps.search(queryParameters, validSortFields(), 1,3);
    }

    @Test
    public void searchShouldReturnZeroResultsWithBadSearch() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.JOURNAL_TITLE, BAD_HOST_GENUS);
	SearcherDao<RefSources> hps = new HPSearcher<RefSources>(RefSources.class);
	hps.init(refSourcesConfig);
	List<Long> results = hps.search(queryParameters, validSortFields(), 1,15);
	Assert.assertTrue(results != null && results.size()==0);
    }

    @Test
    public void searchShouldReturnResultsWithGoodSearch() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.JOURNAL_TITLE, VALID_JOURNAL_TITLE);
	SearcherDao<RefSources> hps = new HPSearcher<RefSources>(RefSources.class);
	hps.init(refSourcesConfig);
	List<Long> results = hps.search(queryParameters, validSortFields(), 1,15);
	Assert.assertTrue(results != null);
	Assert.assertTrue(results.size()>0);
    }

    @Test(expected=InitializationException.class)
    public void shouldFailGetAllWithMismatcheNouns() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
        hps.init(refSourcesConfig);
        List<Long> all = hps.getAll(1,10);	   
     }

}
