package ca.gc.agr.mbb.hostpathogen.web.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import ca.gc.agr.mbb.hostpathogen.web.model.Location;
import ca.gc.agr.mbb.hostpathogen.web.service.LocationManager;

public class LocationDaoTest extends BaseDaoTestCase {
	
    @Autowired
    private LocationManager dao;

    @Test(expected=DataAccessException.class)
    public void testGetLocationInvalid() throws Exception {
        // should throw DataAccessException
        dao.get(1000L);
    }

    @Test
    public void testGetLocation() throws Exception {
        Location location = dao.get(-1L);

        assertNotNull(location);
    }

    @Test
    public void testLocationExists() throws Exception {
        boolean b = dao.exists(-1L);
        assertTrue(b);
    }

    @Test
    public void testLocationNotExists() throws Exception {
        boolean b = dao.exists(111L);
        assertFalse(b);
    }

    @Test
    public void testLocationSearch() throws Exception {
        // reindex all the data
        dao.reindex();

        List<Location> found = dao.search("Canada");
        assertEquals(1, found.size());
        Location location = found.get(0);
        assertEquals("Canada", location.getCountry());

        // test mirroring
//        location = dao.get(-2L);
//        location.setGenus("FusariumX");
//        dao.saveLocation(location);
//        flush();
//        flushSearchIndexes();
//
//        // now verify it is reflected in the index
//        found = dao.search("FusariumX");
//        assertEquals(1, found.size());
//        location = found.get(0);
//        assertEquals("FusariumX", location.getGenus());
    }
}
