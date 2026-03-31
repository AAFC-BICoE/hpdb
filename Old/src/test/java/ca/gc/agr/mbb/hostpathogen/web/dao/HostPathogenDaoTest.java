package ca.gc.agr.mbb.hostpathogen.web.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import ca.gc.agr.mbb.hostpathogen.web.model.HostPathogen;

public class HostPathogenDaoTest extends BaseDaoTestCase {
	
    @Autowired
    private HostPathogenDao dao;

    @Test(expected=DataAccessException.class)
    public void testGetHostPathogenInvalid() throws Exception {
        // should throw DataAccessException
        dao.get(1000L);
    }

    @Test
    public void testGetHostPathogen() throws Exception {
        HostPathogen hostPathogen = dao.get(-1L);

        assertNotNull(hostPathogen);
    }

    @Test
    public void testHostPathogenExists() throws Exception {
        boolean b = dao.exists(-1L);
        assertTrue(b);
    }

    @Test
    public void testHostPathogenNotExists() throws Exception {
        boolean b = dao.exists(111L);
        assertFalse(b);
    }

    @Test
    public void testHostPathogenSearch() throws Exception {
        // reindex all the data
        dao.reindex();

        List<HostPathogen> found = dao.search("Fusarium");
        assertEquals(7, found.size());
        HostPathogen hostPathogen = found.get(0);
        assertEquals("Fusarium", hostPathogen.getHostGenus());

        // test mirroring
//        hostPathogen = dao.get(-2L);
//        hostPathogen.setGenus("FusariumX");
//        dao.saveHostPathogen(hostPathogen);
//        flush();
//        flushSearchIndexes();
//
//        // now verify it is reflected in the index
//        found = dao.search("FusariumX");
//        assertEquals(1, found.size());
//        hostPathogen = found.get(0);
//        assertEquals("FusariumX", hostPathogen.getGenus());
    }
}
