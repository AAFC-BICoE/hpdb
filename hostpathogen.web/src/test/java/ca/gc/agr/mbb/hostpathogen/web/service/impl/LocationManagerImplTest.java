package ca.gc.agr.mbb.hostpathogen.web.service.impl;

import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import ca.gc.agr.mbb.hostpathogen.web.dao.LocationDao;
import ca.gc.agr.mbb.hostpathogen.web.model.Location;


public class LocationManagerImplTest extends BaseManagerMockTestCase {
	
	@Mock 
	private LocationDao locationDao;
	
	@InjectMocks
	private LocationManagerImpl locationManager;
	
    @Test
    public void testGetLocation() throws Exception {
        //given
        final Location testData = new Location();
        given(locationDao.get(1L)).willReturn(testData);

        //then
        Location location = locationManager.getLocation("1");

        //then
        assertTrue(location != null);
        assert location != null;
    }

//    @Test
//    public void testSaveLocation() throws Exception {
//        //given
//        final Location testData = new Location();
//
//        given(locationDao.get(1L)).willReturn(testData);
//
//
//        final Location location = locationManager.getLocation("-1");
//        location.setGenus("Aspergillus");
//
//        given(locationDao.saveLocation(location)).willReturn(location);
//
//
//        //when
//        Location returned = locationManager.saveLocation(location);
//
//        //then
//        assertTrue(returned.getPhoneNumber().equals("303-555-1212"));
//        assertTrue(returned.getRoles().size() == 1);
//    }

//    @Test
//    public void testAddAndRemoveLocation() throws Exception {
//        //given
//        Location location = new Location();
//
//        // call populate method in super class to populate test data
//        // from a properties file matching this class name
//        location = (Location) populate(location);
//
//
//        Role role = new Role(Constants.USER_ROLE);
//        location.addRole(role);
//
//        final Location location1 = location;
//        given(locationDao.saveLocation(location1)).willReturn(location1);
//
//
//        //when
//        location = locationManager.saveLocation(location);
//
//        //then
//        assertTrue(location.getLocationname().equals("john"));
//        assertTrue(location.getRoles().size() == 1);
//
//        //given
//        willDoNothing().given(locationDao).remove(5L);
//        locationManager.removeLocation("5");
//
//        given(locationDao.get(5L)).willReturn(null);
//
//        //when
//        location = locationManager.getLocation("5");
//
//        //then
//        assertNull(location);
//        verify(locationDao).remove(5L);
//    }

//    @Test
//    public void testLocationExistsException() {
//        // set expectations
//        final Location location = new Location();
//        location.setGenus("new");
//
//        willThrow(new DataIntegrityViolationException("")).given(locationDao).saveLocation(location);
//
//        // run test
//        try {
//            locationManager.saveLocation(location);
//            fail("Expected LocationExistsException not thrown");
//        } catch (LocationExistsException e) {
//            log.debug("expected exception: " + e.getMessage());
//            assertNotNull(e);
//        }
//    }

}
