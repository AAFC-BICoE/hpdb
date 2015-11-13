package ca.gc.agr.mbb.hostpathogen.web.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import ca.gc.agr.mbb.hostpathogen.web.model.Host;

public class HostDaoTest extends BaseDaoTestCase {
	
    @Autowired
    private HostDao dao;

    @Test(expected=DataAccessException.class)
    public void testGetHostInvalid() throws Exception {
        // should throw DataAccessException
        dao.get(1000L);
    }

    @Test
    public void testGetHost() throws Exception {
        Host host = dao.get(-1L);

        assertNotNull(host);
    }

    @Test
    public void testHostExists() throws Exception {
        boolean b = dao.exists(-1L);
        assertTrue(b);
    }

    @Test
    public void testHostNotExists() throws Exception {
        boolean b = dao.exists(111L);
        assertFalse(b);
    }

    @Test
    public void testHostSearch() throws Exception {
        // reindex all the data
        dao.reindex();

        List<Host> found = dao.search("Fusarium");
        assertEquals(2, found.size());
        Host host = found.get(0);
        assertEquals("Fusarium", host.getGenus());

        // test mirroring
//        host = dao.get(-2L);
//        host.setGenus("FusariumX");
//        dao.saveHost(host);
//        flush();
//        flushSearchIndexes();
//
//        // now verify it is reflected in the index
//        found = dao.search("FusariumX");
//        assertEquals(1, found.size());
//        host = found.get(0);
//        assertEquals("FusariumX", host.getGenus());
    }
}
