package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.List;
import java.util.Properties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UtilTest{
    private final static Logger LOG = Logger.getLogger("test"); 

    // checkOffsetAndLimit
    @Test(expected=IllegalOffsetLimitException.class)
    public void negativeOffset() throws IllegalOffsetLimitException
    {
	Util.checkOffsetAndLimit(-1, 2);
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void limitLessThanOne() throws IllegalOffsetLimitException
    {
	Util.checkOffsetAndLimit(100, 0);
    }

    @Test(expected=IllegalOffsetLimitException.class)
    public void limitTooLarge() throws IllegalOffsetLimitException
    {
	Util.checkOffsetAndLimit(100, HPSearcher.LIMIT_MAX+6);
    }

    @Test
    public void hasGoodOffsetAndLimit() throws IllegalOffsetLimitException
    {
	Util.checkOffsetAndLimit(100, 50);
    }



    //////////////////////////////
    // checkQueryParameters

    @Test(expected=IllegalArgumentException.class)
    public void queryIsNull() throws IllegalArgumentException
    {
	Util.checkQueryParameters(null, new HashSet<String>());
    }

    @Test(expected=IllegalArgumentException.class)
    public void queryIsZeroLength() throws IllegalArgumentException{
	Util.checkQueryParameters(new HashMap<String,List<String>>(), new HashSet<String>());
    }

    @Test
    public void queryWithOneParameter(){
	Map<String, List<String>>queries = new HashMap<String,List<String>>();
	List<String>values = new ArrayList<String>();
	values.add("ali*");
	queries.put("genus", values);
	Util.checkQueryParameters(queries, null);
    }


    //////////////////////////////
    // sliceList

    @Test(expected=IllegalArgumentException.class)
    public void listIsNull() throws IllegalArgumentException
    {
	Util.sliceList(null, 0,10);
    }


    //////////////////////////////
    // luceneConfig

    static Properties goodProperties = new Properties();
    static Properties emptyProperties = new Properties();
    static Properties badDirProperties = new Properties();
    static{
	goodProperties.put(SearcherDao.LUCENE_INDICES_BASE_DIR, HPSearcherTest.GOOD_LUCENE_DIR);
	badDirProperties.put(SearcherDao.LUCENE_INDICES_BASE_DIR, HPSearcherTest.BAD_LUCENE_DIR);
    }
    
    ///NEGATIVE
    @Test(expected=IllegalArgumentException.class)
    public void nullNounLuceneConfig()  throws InitializationException
    {
	UtilLucene.luceneConfig(null, goodProperties);
    }

    @Test(expected=IllegalArgumentException.class)
    public void nullPropertiesLuceneConfig()  throws InitializationException
    {
	UtilLucene.luceneConfig(LuceneFields.PATHOGEN_TYPE, null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void missingLuceneDirPropertyLuceneConfig()  throws InitializationException
    {
	UtilLucene.luceneConfig(LuceneFields.PATHOGEN_TYPE, null);
    }

    @Test(expected=InitializationException.class)
    public void badLuceneDirPropertyLuceneConfig() throws InitializationException
    {
	UtilLucene.luceneConfig(LuceneFields.PATHOGEN_TYPE, badDirProperties);
    }
    
    //POSITIVE
    @Test
    public void succesfulLuceneConfig() throws InitializationException
    {
	UtilLucene.luceneConfig(LuceneFields.PATHOGEN_TYPE, goodProperties);
    }


}
