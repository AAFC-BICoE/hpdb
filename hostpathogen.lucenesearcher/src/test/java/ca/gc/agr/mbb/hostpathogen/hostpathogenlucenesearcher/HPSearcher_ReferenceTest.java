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

import ca.gc.agr.mbb.hostpathogen.nouns.Reference;
import ca.gc.agr.mbb.hostpathogen.nouns.Pathogen;


@RunWith(JUnit4.class)
public class HPSearcher_ReferenceTest  extends BaseNoun implements HPSearch{
    private final static Logger LOG = Logger.getLogger(HPSearcher_ReferenceTest.class.getName()); 

    static LuceneConfig referenceConfig;

    static final String VALID_REFERENCE_AUTHOR = "Allen*";


    static{
	validIds = new Long[] {1l,2l,3l,4l,5l,6l,7l,8l,9l,10l};
	invalidIds = new Long[] {711049l, 711050l, 711058l};
	try{
	    referenceConfig = UtilLucene.luceneConfig(LuceneFields.REFERENCE_TYPE, UtilTest.goodProperties);
	}catch(InitializationException e){
	    e.printStackTrace();
	}
    }

   @Test
   public void shouldGetAllReferences() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
       SearcherDao<Reference> hps = new HPSearcher<Reference>(Reference.class);
       hps.init(referenceConfig);
       List<Long> all = hps.getAll(1,10);	   
       Assert.assertTrue(all != null && all.size() >0);
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void shouldFailWithNegativeOffset() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
	//SearcherDao<Reference> hps = new HPSearcher<Reference>(Reference.class);
	SearcherDao<Reference> hps = new HPSearcher<Reference>(Reference.class);
       hps.init(referenceConfig);
       List<Long> all = hps.getAll(-1,10);	   
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void shouldFailWithBadLimit() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
	//SearcherDao<Reference> hps = new HPSearcher<Reference>(Reference.class);
SearcherDao<Reference> hps = new HPSearcher<Reference>(Reference.class);
       hps.init(referenceConfig);
       List<Long> all = hps.getAll(10,-1);	   
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void shouldFailWithTooLargeOffset() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
	//SearcherDao<Reference> hps = new HPSearcher<Reference>(Reference.class);
SearcherDao<Reference> hps = new HPSearcher<Reference>(Reference.class);
       hps.init(referenceConfig);
       List<Long> all = hps.getAll(10,1000);	   
    }



   @Test
   public void shouldGetAllReferencesCount() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
       //SearcherDao<Reference> hps = new HPSearcher<Reference>(Reference.class);
       SearcherDao<Reference> hps = new HPSearcher<Reference>(Reference.class);
       hps.init(referenceConfig);
       long allCount = hps.getAllCount();	   
       Assert.assertTrue(allCount >0);
    }



   @Test
   public void shouldGetSingleReferenceById() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
       SearcherDao<Reference> hps = new HPSearcher<Reference>(Reference.class);
       hps.init(referenceConfig);

       Reference reference = hps.get(validIds().get(0));
       Assert.assertTrue(reference != null);
    }


    @Test
    public void searchReferenceSuccessfully() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.REFERENCE_AUTHORS, VALID_REFERENCE_AUTHOR);
	SearcherDao<Reference> hps = new HPSearcher<Reference>(Reference.class);
	hps.init(referenceConfig);
	List<Long> results = hps.search(queryParameters, goodReferenceSortFields(), 1,3);
	Assert.assertTrue(results != null && results.size()>0);
    }

    @Test
    public void searchReferenceCountSuccessfully() throws IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.REFERENCE_AUTHORS, VALID_REFERENCE_AUTHOR);
	SearcherDao<Reference> hps = new HPSearcher<Reference>(Reference.class);
	hps.init(referenceConfig);
	long results = hps.searchCount(queryParameters);
	Assert.assertTrue(results>0l);
    }

    @Test
    public void searchReferenceSuccessfullyWithSorting() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.REFERENCE_AUTHORS, VALID_REFERENCE_AUTHOR);
	SearcherDao<Reference> hps = new HPSearcher<Reference>(Reference.class);
	hps.init(referenceConfig);
	List<Long> results = hps.search(queryParameters, goodReferenceSortFields(), 1,20);
	Assert.assertTrue(results != null && results.size()>0);
    }

    public void shouldFailWithSearchReferenceWithBadSortField() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.REFERENCE_AUTHORS, VALID_REFERENCE_AUTHOR);
	SearcherDao<Reference> hps = new HPSearcher<Reference>(Reference.class);
	hps.init(referenceConfig);
	List<Long> results = hps.search(queryParameters, HPSearcherTest.badHostSortFields(), 1,20);
    }

    @Test(expected=IllegalArgumentException.class)
    public void searchReferenceFailWithWrongFields() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.HOST_GENUS, A_STAR_WILDCARD);
	SearcherDao<Reference> hps = new HPSearcher<Reference>(Reference.class);
	hps.init(referenceConfig);
	List<Long> results = hps.search(queryParameters, goodReferenceSortFields(), 1,3);
    }

    @Test
    public void searchReferenceSuccessfullyWithSortingValidated() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.REFERENCE_AUTHORS, A_STAR_WILDCARD);
	SearcherDao<Reference> hps = new HPSearcher<Reference>(Reference.class);
	hps.init(referenceConfig);
	List<Long> results = hps.search(queryParameters, goodReferenceSortFields(), 1,3);
	Assert.assertTrue(results != null && results.size()>1 );
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void searchShouldFailWithBadOffset() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.REFERENCE_AUTHORS, VALID_REFERENCE_AUTHOR);
	SearcherDao<Reference> hps = new HPSearcher<Reference>(Reference.class);
	hps.init(referenceConfig);
	List<Long> results = hps.search(queryParameters, goodReferenceSortFields(), -1,3);
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void searchShouldFailWithBadLimit() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.REFERENCE_AUTHORS, VALID_REFERENCE_AUTHOR);
	SearcherDao<Reference> hps = new HPSearcher<Reference>(Reference.class);
	hps.init(referenceConfig);
	List<Long> results = hps.search(queryParameters, goodReferenceSortFields(), 10,-3);
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void searchShouldFailWithTooBigLimit() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.REFERENCE_AUTHORS, VALID_REFERENCE_AUTHOR);
	SearcherDao<Reference> hps = new HPSearcher<Reference>(Reference.class);
	hps.init(referenceConfig);
	List<Long> results = hps.search(queryParameters, goodReferenceSortFields(), 10,9999);
    }


    @Test(expected=IllegalArgumentException.class)
    public void searchShouldFailwithBadSearchFields() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.REFERENCE_AUTHORS, null);
	SearcherDao<Reference> hps = new HPSearcher<Reference>(Reference.class);
	hps.init(referenceConfig);
	List<Long> results = hps.search(queryParameters, goodReferenceSortFields(), 1,3);
    }

    @Test
    public void searchShouldReturnZeroResultsWithBadSearch() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.REFERENCE_AUTHORS, BAD_HOST_GENUS);
	SearcherDao<Reference> hps = new HPSearcher<Reference>(Reference.class);
	hps.init(referenceConfig);
	List<Long> results = hps.search(queryParameters, goodReferenceSortFields(), 1,15);
	Assert.assertTrue(results != null && results.size()==0);
    }

    @Test
    public void searchShouldReturnResultsWithGoodSearch() throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException{
	Map<String, List<String>> queryParameters = HPSearcherTest.makeSimpleQuery(LuceneFields.REFERENCE_AUTHORS, VALID_REFERENCE_AUTHOR);
	SearcherDao<Reference> hps = new HPSearcher<Reference>(Reference.class);
	hps.init(referenceConfig);
	List<Long> results = hps.search(queryParameters, goodReferenceSortFields(), 1,15);
	Assert.assertTrue(results != null);
	Assert.assertTrue(results.size()>0);
    }

    @Test(expected=InitializationException.class)
    public void shouldFailGetAllWithMismatcheNouns() throws InitializationException, IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException{
	SearcherDao<Pathogen> hps = new HPSearcher<Pathogen>(Pathogen.class);
        hps.init(referenceConfig);
        List<Long> all = hps.getAll(1,10);	   
     }

    static List<String> goodReferenceSortFields(){
	List<String> sf = new ArrayList<String>();
	sf.add(LuceneFields.REFERENCE_YEAR);
	return sf;
    }

}
