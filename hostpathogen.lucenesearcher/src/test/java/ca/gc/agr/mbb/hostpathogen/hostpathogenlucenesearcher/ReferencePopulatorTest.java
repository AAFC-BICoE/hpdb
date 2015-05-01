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
import ca.gc.agr.mbb.hostpathogen.nouns.Reference;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.StoredField;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.LuceneFields;

@RunWith(JUnit4.class)
public class ReferencePopulatorTest{
    private final static Logger LOG = Logger.getLogger(ReferencePopulatorTest.class.getName()); 

    static LuceneConfig htConfig;
    static{
	try{
	    htConfig = UtilLucene.luceneConfig(LuceneFields.REFERENCE_TYPE, UtilTest.goodProperties);
	}catch(InitializationException e){
	    e.printStackTrace();
	}
    }

    //@Test(expected=InitializationException.class)
    @Test()
    public void shouldConstructOK() throws IndexFailureException,InitializationException{
	Populator<Reference> pop = new ReferencePopulator<Reference>();
	Assert.assertTrue(pop != null);
    }
    
    @Test(expected=FailedPopulateException.class)
    public void populateShouldFailWithNullDocument() throws IndexFailureException,InitializationException{
	Populator<Reference> pop = new ReferencePopulator<Reference>();
	Reference ht = pop.populate(null);
    }

    @Test
    public void populateShouldSucceedWithValidDocument() throws IndexFailureException,InitializationException{
	Populator<Reference> pop = new ReferencePopulator<Reference>();
	Reference ht = pop.populate(makeValidDocument());
	Assert.assertTrue(ht != null);
    }


    @Test(expected=FailedPopulateException.class)
    public void populateShouldFailWithDocumentMissingPrimaryKey() throws IndexFailureException,InitializationException{
	Populator<Reference> pop = new ReferencePopulator<Reference>();
	Document d = makeValidDocument();
	d.removeField(BasePopulator.stored(LuceneFields.PK));
	Reference ht = pop.populate(d);
    }

    // # Not mandatory (from data)
    // @Test(expected=FailedPopulateException.class)
    // public void populateShouldFailWithDocumentMissingMandatoryField() throws IndexFailureException,InitializationException{
    // 	Populator<Reference> pop = new ReferencePopulator<Reference>();
    // 	Document d = makeValidDocument();
    // 	d.removeField(BasePopulator.stored(LuceneFields.CHAPTER_ARTICLE_TITLE));
    // 	Reference ht = pop.populate(d);
    // }

    @Test
    public void populateShouldSucceedWithDocumentMissingNonMandatoryField() throws IndexFailureException,InitializationException{
	Populator<Reference> pop = new ReferencePopulator<Reference>();
	Document d = makeValidDocument();
	d.removeField(BasePopulator.stored(LuceneFields.RUST_STATE));
	Reference ht = pop.populate(d);
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
	return d;
    }
}
