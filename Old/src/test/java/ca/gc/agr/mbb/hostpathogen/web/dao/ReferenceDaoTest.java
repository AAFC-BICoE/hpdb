package ca.gc.agr.mbb.hostpathogen.web.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import ca.gc.agr.mbb.hostpathogen.web.model.Reference;
import ca.gc.agr.mbb.hostpathogen.web.service.ReferenceManager;

public class ReferenceDaoTest extends BaseDaoTestCase {
	
    @Autowired
    private ReferenceManager dao;

    @Test(expected=DataAccessException.class)
    public void testGetReferenceInvalid() throws Exception {
        // should throw DataAccessException
        dao.get(1000L);
    }

    @Test
    public void testGetReference() throws Exception {
        Reference reference = dao.get(-1L);

        assertNotNull(reference);
    }

    @Test
    public void testReferenceExists() throws Exception {
        boolean b = dao.exists(-1L);
        assertTrue(b);
    }

    @Test
    public void testReferenceNotExists() throws Exception {
        boolean b = dao.exists(111L);
        assertFalse(b);
    }

    @Test
    public void testReferenceSearch() throws Exception {
        // reindex all the data
        dao.reindex();

        List<Reference> found = dao.search("Joe and Larry");
        assertEquals(1, found.size());
        Reference reference = found.get(0);
        assertEquals("Joe and Larry", reference.getAuthors());

        // test mirroring
//        reference = dao.get(-2L);
//        reference.setGenus("FusariumX");
//        dao.saveReference(reference);
//        flush();
//        flushSearchIndexes();
//
//        // now verify it is reflected in the index
//        found = dao.search("FusariumX");
//        assertEquals(1, found.size());
//        reference = found.get(0);
//        assertEquals("FusariumX", reference.getGenus());
    }
}
