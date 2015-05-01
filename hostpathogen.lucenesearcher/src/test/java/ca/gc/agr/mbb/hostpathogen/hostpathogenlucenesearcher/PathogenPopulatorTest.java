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
import ca.gc.agr.mbb.hostpathogen.nouns.Pathogen;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.StoredField;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.LuceneFields;

@RunWith(JUnit4.class)
public class PathogenPopulatorTest{
    private final static Logger LOG = Logger.getLogger(PathogenPopulatorTest.class.getName()); 

    static LuceneConfig htConfig;
    static{
	try{
	    htConfig = UtilLucene.luceneConfig(LuceneFields.PATHOGEN_TYPE, UtilTest.goodProperties);
	}catch(InitializationException e){
	    e.printStackTrace();
	}
    }

    //@Test(expected=InitializationException.class)
    @Test()
    public void shouldConstructOK() throws IndexFailureException,InitializationException{
	Populator<Pathogen> pop = new PathogenPopulator<Pathogen>();
	Assert.assertTrue(pop != null);
    }
    
    @Test(expected=FailedPopulateException.class)
    public void populateShouldFailWithNullDocument() throws IndexFailureException,InitializationException{
	Populator<Pathogen> pop = new PathogenPopulator<Pathogen>();
	Pathogen ht = pop.populate(null);
    }

    @Test
    public void populateShouldSucceedWithValidDocument() throws IndexFailureException,InitializationException{
	Populator<Pathogen> pop = new PathogenPopulator<Pathogen>();
	Pathogen ht = pop.populate(makeValidDocument());
	Assert.assertTrue(ht != null);
    }


    @Test(expected=FailedPopulateException.class)
    public void populateShouldFailWithDocumentMissingPrimaryKey() throws IndexFailureException,InitializationException{
	Populator<Pathogen> pop = new PathogenPopulator<Pathogen>();
	Document d = makeValidDocument();
	d.removeField(BasePopulator.stored(LuceneFields.PK));
	Pathogen ht = pop.populate(d);
    }

    @Test
    public void populateShouldSucceedWithDocumentMissingNoMandatoryField() throws IndexFailureException,InitializationException{
	Populator<Pathogen> pop = new PathogenPopulator<Pathogen>();
	Document d = makeValidDocument();
	d.removeField(BasePopulator.stored(LuceneFields.FUNGAL_STATE));
	Pathogen ht = pop.populate(d);
	Assert.assertTrue(ht != null);
    }

    private Document makeValidDocument(){
	Document d = new Document();
	d.add(new StoredField(BasePopulator.stored(LuceneFields.PK), "3"));

	d.add(new StoredField(BasePopulator.stored(LuceneFields.FUNGAL_STATE), "fungal_state"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.PATHOGEN_AUTHOR), "pathogen_author"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.PATHOGEN_GENUS), "pathogen_genus"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.PATHOGEN_SPECIES), "pathogen_species"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.PATHOGEN_SUBSPECIFIC_TAXA), "pathogen_subspecific_taxa"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.PK_PATHOGEN_ID), "pk_pathogen_id"));
	d.add(new StoredField(BasePopulator.stored(LuceneFields.VIRUS_MPLO_NAMES), "virus_mplo_names"));

	return d;
    }
}
