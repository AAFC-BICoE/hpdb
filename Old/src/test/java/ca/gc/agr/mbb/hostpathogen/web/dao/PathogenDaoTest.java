package ca.gc.agr.mbb.hostpathogen.web.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import ca.gc.agr.mbb.hostpathogen.web.model.Pathogen;

public class PathogenDaoTest extends BaseDaoTestCase {
	
    @Autowired
    private PathogenDao dao;

    @Test(expected=DataAccessException.class)
    public void testGetPathogenInvalid() throws Exception {
        // should throw DataAccessException
        dao.get(1000L);
    }

    @Test
    public void testGetPathogen() throws Exception {
        Pathogen pathogen = dao.get(-1L);

        assertNotNull(pathogen);
    }

    @Test
    public void testPathogenExists() throws Exception {
        boolean b = dao.exists(-1L);
        assertTrue(b);
    }

    @Test
    public void testPathogenNotExists() throws Exception {
        boolean b = dao.exists(111L);
        assertFalse(b);
    }

    @Test
    public void testPathogenSearch() throws Exception {
        // reindex all the data
        dao.reindex();

        List<Pathogen> found = dao.search("Fusarium");
        assertEquals(2, found.size());
        Pathogen pathogen = found.get(0);
        assertEquals("Fusarium", pathogen.getGenus());

        // test mirroring
//        pathogen = dao.get(-2L);
//        pathogen.setGenus("FusariumX");
//        dao.savePathogen(pathogen);
//        flush();
//        flushSearchIndexes();
//
//        // now verify it is reflected in the index
//        found = dao.search("FusariumX");
//        assertEquals(1, found.size());
//        pathogen = found.get(0);
//        assertEquals("FusariumX", pathogen.getGenus());
    }
}
