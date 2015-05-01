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
import ca.gc.agr.mbb.hostpathogen.nouns.HigherTaxa;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.StoredField;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.LuceneFields;

@RunWith(JUnit4.class)
public class HigherTaxaPopulatorTest{
    private final static Logger LOG = Logger.getLogger(HigherTaxaPopulatorTest.class.getName()); 

    static LuceneConfig htConfig;
    static{
	try{
	    htConfig = UtilLucene.luceneConfig(LuceneFields.HIGHER_TAXA_TYPE, UtilTest.goodProperties);
	}catch(InitializationException e){
	    e.printStackTrace();
	}
    }

    //@Test(expected=InitializationException.class)
    @Test()
    public void shouldConstructOK() throws IndexFailureException,InitializationException{
	Populator<HigherTaxa> pop = new HigherTaxaPopulator<HigherTaxa>();
	Assert.assertTrue(pop != null);
    }
    
    @Test(expected=FailedPopulateException.class)
    public void populateShouldFailWithNullDocument() throws IndexFailureException,InitializationException{
	Populator<HigherTaxa> pop = new HigherTaxaPopulator<HigherTaxa>();
	HigherTaxa ht = pop.populate(null);
    }

    @Test
    public void populateShouldSucceedWithValidDocument() throws IndexFailureException,InitializationException{
	Populator<HigherTaxa> pop = new HigherTaxaPopulator<HigherTaxa>();
	HigherTaxa ht = pop.populate(makeValidDocument());
	Assert.assertTrue(ht != null);
    }


    @Test(expected=FailedPopulateException.class)
    public void populateShouldFailWithDocumentMissingPrimaryKey() throws IndexFailureException,InitializationException{
	Populator<HigherTaxa> pop = new HigherTaxaPopulator<HigherTaxa>();
	Document d = makeValidDocument();
	d.removeField(BasePopulator.stored(LuceneFields.PK));
	HigherTaxa ht = pop.populate(d);
    }

    @Test
    public void populateShouldSucceedWithDocumentMissingNoMandatoryField() throws IndexFailureException,InitializationException{
	Populator<HigherTaxa> pop = new HigherTaxaPopulator<HigherTaxa>();
	Document d = makeValidDocument();
	d.removeField(BasePopulator.stored(LuceneFields.DIVISION));
	HigherTaxa ht = pop.populate(d);
	Assert.assertTrue(ht != null);
    }

    private Document makeValidDocument(){
	Document d = new Document();
	d.add(new StoredField(BasePopulator.stored(LuceneFields.PK), "3"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.KINGDOM), "kind dom"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.DIVISION), "div ision"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.CLASS), "cl ass"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.ORDER), "or der"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.FAMILY), "fa mily"));
	return d;
    }
}
