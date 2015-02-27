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
import ca.gc.agr.mbb.hostpathogen.nouns.HostPathogen;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.StoredField;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.LuceneFields;

@RunWith(JUnit4.class)
public class HostPathogenPopulatorTest{
    private final static Logger LOG = Logger.getLogger(HostPathogenPopulatorTest.class.getName()); 

    static LuceneConfig htConfig;
    static{
	try{
	    htConfig = UtilLucene.luceneConfig(LuceneFields.HOST_PATHOGEN_TYPE, UtilTest.goodProperties);
	}catch(InitializationException e){
	    e.printStackTrace();
	}
    }

    //@Test(expected=InitializationException.class)
    @Test()
    public void shouldConstructOK() throws IndexFailureException,InitializationException{
	Populator<HostPathogen> pop = new HostPathogenPopulator<HostPathogen>();
	Assert.assertTrue(pop != null);
    }
    
    @Test(expected=FailedPopulateException.class)
    public void populateShouldFailWithNullDocument() throws IndexFailureException,InitializationException{
	Populator<HostPathogen> pop = new HostPathogenPopulator<HostPathogen>();
	HostPathogen ht = pop.populate(null);
    }

    @Test
    public void populateShouldSucceedWithValidDocument() throws IndexFailureException,InitializationException{
	Populator<HostPathogen> pop = new HostPathogenPopulator<HostPathogen>();
	HostPathogen ht = pop.populate(makeValidDocument());
	Assert.assertTrue(ht != null);
    }


    @Test(expected=FailedPopulateException.class)
    public void populateShouldFailWithDocumentMissingPrimaryKey() throws IndexFailureException,InitializationException{
	Populator<HostPathogen> pop = new HostPathogenPopulator<HostPathogen>();
	Document d = makeValidDocument();
	d.removeField(BasePopulator.stored(LuceneFields.PK));
	HostPathogen ht = pop.populate(d);
    }

    @Test(expected=FailedPopulateException.class)
    public void populateShouldFailWithDocumentMissingMandatoryField() throws IndexFailureException,InitializationException{
	Populator<HostPathogen> pop = new HostPathogenPopulator<HostPathogen>();
	Document d = makeValidDocument();
	d.removeField(BasePopulator.stored(LuceneFields.FK_PATHOGEN_ID));
	HostPathogen ht = pop.populate(d);
    }

    @Test
    public void populateShouldSucceedWithDocumentMissingNonMandatoryField() throws IndexFailureException,InitializationException{
	Populator<HostPathogen> pop = new HostPathogenPopulator<HostPathogen>();
	Document d = makeValidDocument();
	d.removeField(BasePopulator.stored(LuceneFields.RUST_STATE));
	HostPathogen ht = pop.populate(d);
	Assert.assertTrue(ht != null);
    }

    private Document makeValidDocument(){
	Document d = new Document();
	d.add(new StoredField(BasePopulator.stored(LuceneFields.PK), "3"));

	d.add(new StoredField(BasePopulator.stored(LuceneFields.PATHOGEN_GENUS), "pathogen_genus"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.PATHOGEN_SPECIES), "pathogen_species"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.HOST_GENUS), "host_genus"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.HOST_SPECIES), "host_species"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.HOST_SUBSPECIFIC_TAXA), "host_subspecific_taxa"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.FK_REFERENCE_ID), "12"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.FK_HOST_ID), "433"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.FK_PATHOGEN_ID), "10118"));

	return d;
    }
}
