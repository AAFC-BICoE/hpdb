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
public class HPSearcher_PathogenTest  extends BaseNoun implements HPSearch{
    private final static Logger LOG = Logger.getLogger(HPSearcher_PathogenTest.class.getName()); 

    static LuceneConfig pathogenConfig;

    static{
	validIds = new Long[] {1l,2l,5l,15l,16l,17l,18l};
	invalidIds = new Long[] {3l,4l,6l,7l};

	validSortFields = new String[]{LuceneFields.PATHOGEN_GENUS};
	invalidSortFields = new String[]{"foobarx"};

	validGenus = "Basidiodendron";
	validSpecies = "cinereum";

	try{
	    pathogenConfig = UtilLucene.luceneConfig(LuceneFields.PATHOGEN_TYPE, UtilTest.goodProperties);
	}catch(InitializationException e){
	    e.printStackTrace();
	}
    }

   @Test
   public void shouldGetAllPathogens() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
       SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
       hps.init(pathogenConfig);
       List<Long> all = hps.getAll(1,10);	   
       Assert.assertTrue(all != null && all.size() >0);
    }



   @Test
   public void shouldGetSinglePathogenBySingleId() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
       SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
       hps.init(pathogenConfig);
       Pathogen pathogen = hps.get(validIds().get(0));
       Assert.assertTrue(pathogen != null);
    }

   @Test
   public void shouldGetMultiplePathogenByMultipleIds() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
       SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
       hps.init(pathogenConfig);
       List<Pathogen> pathogens = hps.get(validIds());
       Assert.assertTrue(pathogens != null && pathogens.size() > 0);
    }


    @Test(expected=IllegalOffsetLimitException.class)
    public void shouldFailWithNegativeOffset() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
	hps.init(pathogenConfig);
	List<Long> all = hps.getAll(-1,10);	   
    }


    @Test(expected=IllegalOffsetLimitException.class)
    public void shouldFailWithBadLimit() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
       hps.init(pathogenConfig);
       List<Long> all = hps.getAll(10,-1);	   
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void shouldFailWithTooLargeOffset() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
       hps.init(pathogenConfig);
       List<Long> all = hps.getAll(10,1000);	   
    }



   @Test
   public void shouldGetAllPathogensCount() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
       SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
       hps.init(pathogenConfig);
       long allCount = hps.getAllCount();	   
       Assert.assertTrue(allCount >0);
    }



   @Test
   public void shouldGetSinglePathogenById() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
       SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
       hps.init(pathogenConfig);
       long id = validIds().get(0);	
       Pathogen host = hps.get(id);
       Assert.assertTrue(host != null);
    }


   @Test
   public void shouldGetMultiplePathogenById() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
       SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
       hps.init(pathogenConfig);
       List<Pathogen> hosts = hps.get(validIds());
       Assert.assertTrue(hosts != null && hosts.size() > 0);
    }


    @Test
    public void searchPathogenByGenusSuccessfully() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.PATHOGEN_GENUS, validGenus());
	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
	hps.init(pathogenConfig);
	List<Long> results = hps.search(queryParameters, validSortFields(), 0,3);
	Assert.assertTrue(results != null && results.size()>0);
    }

    @Test
    public void searchPathogenByGenusSpeciesSuccessfully() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.PATHOGEN_GENUS, validGenus());
	queryParameters.putAll(HPSearcherTest.makeSimpleQuery(LuceneFields.PATHOGEN_SPECIES, validSpecies()));
	//queryParameters.putAll(HPSearcherTest.makeSimpleQuery(LuceneFields.PATHOGEN_SPECIES, ));

	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
	hps.init(pathogenConfig);
	List<Long> results = hps.search(queryParameters, validSortFields(), 0,3);
	Assert.assertTrue(results != null && results.size()>0);
    }


    @Test
    public void searchPathogenByGenusBadSpeciesShouldFail() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.PATHOGEN_GENUS, validGenus());
	queryParameters.putAll(HPSearcherTest.makeSimpleQuery(LuceneFields.PATHOGEN_SPECIES, invalidSpecies()));

	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
	hps.init(pathogenConfig);
	List<Long> results = hps.search(queryParameters, validSortFields(), 1,3);
	Assert.assertTrue(results == null || results.size()==0);
    }

    @Test
    public void searchPathogenCountSuccessfully() throws IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.PATHOGEN_GENUS, validGenus());
	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
	hps.init(pathogenConfig);
	long results = hps.searchCount(queryParameters);
	Assert.assertTrue(results>0l);
    }

    @Test
    public void searchPathogenSuccessfullyWithSorting() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.PATHOGEN_GENUS, validGenus());
	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
	hps.init(pathogenConfig);
	List<Long> results = hps.search(queryParameters, validSortFields(), 1,20);
	Assert.assertTrue(results != null && results.size()>0);
    }

    public void shouldFailWithSearchPathogenWithBadSortField() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.PATHOGEN_GENUS, validGenus());
	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
	hps.init(pathogenConfig);
	List<Long> results = hps.search(queryParameters, invalidSortFields(), 1,20);
    }

    @Test
    public void searchPathogenSuccessfullyWithSortingValidated() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.PATHOGEN_GENUS, A_STAR_WILDCARD);
	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
	hps.init(pathogenConfig);
	List<Long> results = hps.search(queryParameters, validSortFields(), 1,3);
	Assert.assertTrue(results != null && results.size()>1 );
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void searchShouldFailWithBadOffset() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.PATHOGEN_GENUS, validGenus());
	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
	hps.init(pathogenConfig);
	List<Long> results = hps.search(queryParameters, validSortFields(), -1,3);
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void searchShouldFailWithBadLimit() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.PATHOGEN_GENUS, validGenus());
	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
	hps.init(pathogenConfig);
	List<Long> results = hps.search(queryParameters, validSortFields(), 10,-3);
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void searchShouldFailWithTooBigLimit() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.PATHOGEN_GENUS, validGenus());
	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
	hps.init(pathogenConfig);
	List<Long> results = hps.search(queryParameters, validSortFields(), 10,9999);
    }


    @Test(expected=IllegalArgumentException.class)
    public void searchShouldFailwithBadSearchFields() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.PATHOGEN_GENUS, null);
	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
	hps.init(pathogenConfig);
	List<Long> results = hps.search(queryParameters, validSortFields(), 1,3);
    }

    @Test
    public void searchShouldReturnZeroResultsWithBadSearch() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.PATHOGEN_GENUS, invalidGenus());
	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
	hps.init(pathogenConfig);
	List<Long> results = hps.search(queryParameters, validSortFields(), 1,15);
	Assert.assertTrue(results != null && results.size()==0);
    }

    @Test
    public void searchShouldReturnResultsWithGoodSearch() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.PATHOGEN_GENUS, validGenus());
	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
	hps.init(pathogenConfig);
	List<Long> results = hps.search(queryParameters, validSortFields(), 1,15);
	Assert.assertTrue(results != null && results.size()>0);
    }

    @Test(expected=InitializationException.class)
    public void shouldFailGetAllWithMismatcheNouns() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Host.class);
        hps.init(pathogenConfig);
        List<Long> all = hps.getAll(1,10);	   
     }



}
