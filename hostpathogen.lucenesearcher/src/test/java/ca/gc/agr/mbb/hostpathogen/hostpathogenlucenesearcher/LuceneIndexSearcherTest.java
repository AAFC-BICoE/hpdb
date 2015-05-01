package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;


import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ca.gc.agr.mbb.hostpathogen.nouns.Pathogen;

@RunWith(JUnit4.class)
public class LuceneIndexSearcherTest{
    private final static Logger LOG = Logger.getLogger(LuceneIndexSearcherTest.class.getName()); 
    private static final String luceneIndex = "a45";

    // FAIL tests
    @Test(expected=InitializationException.class)
    public void initWithNullLuceneSearcher() throws InitializationException{
	//LuceneIndexSearcher lis = new LuceneIndexSearcher(Pathogen.class);
	LuceneIndexSearcher<Pathogen> lis = new LuceneIndexSearcher<Pathogen>();
	PathogenPopulator pap = new PathogenPopulator();
	lis.init(null, UtilLucene.makeAnalyzer(), pap);
    }

    @Test(expected=InitializationException.class)
    public void initWithNullLuceneAnalyzer() throws InitializationException{
	//LuceneIndexSearcher lis = new LuceneIndexSearcher(Pathogen.class);
	LuceneIndexSearcher lis = new LuceneIndexSearcher();
	PathogenPopulator pap = new PathogenPopulator();
	try{
	    UtilLucene.openAndWriteLuceneIndex(luceneIndex);
	    lis.init(UtilLucene.makeIndexSearcher(luceneIndex), null, pap);
	}catch(java.io.IOException e){
	    // This shouldn't happen
	    e.printStackTrace();
	}
    }


    @Test(expected=InitializationException.class)
    public void initWithNullPopulator() throws InitializationException{
	//LuceneIndexSearcher lis = new LuceneIndexSearcher(Pathogen.class);
	LuceneIndexSearcher lis = new LuceneIndexSearcher();
	try{
	    UtilLucene.openAndWriteLuceneIndex(luceneIndex);
	    lis.init(UtilLucene.makeIndexSearcher(luceneIndex), UtilLucene.makeAnalyzer(), null);
	}catch(java.io.IOException e){
	    // This shouldn't happen
	    e.printStackTrace();
	}
    }

    // SUCCESS tests
    @Test
    public void goodLuceneDirAndGoodPopulator() throws InitializationException{
	//LuceneIndexSearcher lis = new LuceneIndexSearcher(Pathogen.class);
	LuceneIndexSearcher lis = new LuceneIndexSearcher();
	PathogenPopulator pap = new PathogenPopulator();
	try{
	    lis.init(UtilLucene.makeIndexSearcher(luceneIndex), UtilLucene.makeAnalyzer(), pap);
	}catch(java.io.IOException e){
	    // This shouldn't happen
	    e.printStackTrace();
	}   
    }
}
