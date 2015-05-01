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
import ca.gc.agr.mbb.hostpathogen.nouns.RefSources;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.StoredField;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.LuceneFields;

@RunWith(JUnit4.class)
public class RefSourcesPopulatorTest{
    private final static Logger LOG = Logger.getLogger(RefSourcesPopulatorTest.class.getName()); 

    static LuceneConfig htConfig;
    static{
	try{
	    htConfig = UtilLucene.luceneConfig(LuceneFields.REF_SOURCES_TYPE, UtilTest.goodProperties);
	}catch(InitializationException e){
	    e.printStackTrace();
	}
    }

    //@Test(expected=InitializationException.class)
    @Test()
    public void shouldConstructOK() throws IndexFailureException,InitializationException{
	Populator<RefSources> pop = new RefSourcesPopulator<RefSources>();
	Assert.assertTrue(pop != null);
    }
    
    @Test(expected=FailedPopulateException.class)
    public void populateShouldFailWithNullDocument() throws IndexFailureException,InitializationException{
	Populator<RefSources> pop = new RefSourcesPopulator<RefSources>();
	RefSources ht = pop.populate(null);
    }

    @Test
    public void populateShouldSucceedWithValidDocument() throws IndexFailureException,InitializationException{
	Populator<RefSources> pop = new RefSourcesPopulator<RefSources>();
	RefSources ht = pop.populate(makeValidDocument());
	Assert.assertTrue(ht != null);
    }


    @Test(expected=FailedPopulateException.class)
    public void populateShouldFailWithDocumentMissingPrimaryKey() throws IndexFailureException,InitializationException{
	Populator<RefSources> pop = new RefSourcesPopulator<RefSources>();
	Document d = makeValidDocument();
	d.removeField(BasePopulator.stored(LuceneFields.PK));
	RefSources ht = pop.populate(d);
    }

    @Test(expected=FailedPopulateException.class)
    public void populateShouldFailWithDocumentMissingMandatoryField() throws IndexFailureException,InitializationException{
	Populator<RefSources> pop = new RefSourcesPopulator<RefSources>();
	Document d = makeValidDocument();
	d.removeField(BasePopulator.stored(LuceneFields.FK_REFERENCE_ID));
	RefSources ht = pop.populate(d);
    }

    @Test
    public void populateShouldSucceedWithDocumentMissingNonMandatoryField() throws IndexFailureException,InitializationException{
	Populator<RefSources> pop = new RefSourcesPopulator<RefSources>();
	Document d = makeValidDocument();
	d.removeField(BasePopulator.stored(LuceneFields.VOLUME));
	RefSources ht = pop.populate(d);
	Assert.assertTrue(ht != null);
    }

    private Document makeValidDocument(){
	Document d = new Document();
	d.add(new StoredField(BasePopulator.stored(LuceneFields.PK), "3"));

	d.add(new StoredField(BasePopulator.stored(LuceneFields.REFERENCE_YEAR), "reference_year"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.REFERENCE_AUTHORS), "reference_authors"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.FK_REF_SOURCE_ID), "2048"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.CHAPTER_ARTICLE_TITLE), "chapter_article_title"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.VOLUME), "volume"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.PAGES), "pages"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.FK_REFERENCE_ID), "199"));
	return d;
    }
}
