package ca.gc.agr.mbb.hostpathogen.web.service.impl;

import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import ca.gc.agr.mbb.hostpathogen.web.dao.HostPathogenDao;
import ca.gc.agr.mbb.hostpathogen.web.model.HostPathogen;


public class HostPathogenManagerImplTest extends BaseManagerMockTestCase {
	
	@Mock 
	private HostPathogenDao hostPathogenDao;
	
	@InjectMocks
	private HostPathogenManagerImpl hostPathogenManager;
	
    @Test
    public void testGetHostPathogen() throws Exception {
        //given
        final HostPathogen testData = new HostPathogen();
        given(hostPathogenDao.get(1L)).willReturn(testData);

        //then
        HostPathogen hostPathogen = hostPathogenManager.getHostPathogen("1");

        //then
        assertTrue(hostPathogen != null);
        assert hostPathogen != null;
    }

//    @Test
//    public void testSaveHostPathogen() throws Exception {
//        //given
//        final HostPathogen testData = new HostPathogen();
//
//        given(hostPathogenDao.get(1L)).willReturn(testData);
//
//
//        final HostPathogen hostPathogen = hostPathogenManager.getHostPathogen("-1");
//        hostPathogen.setGenus("Aspergillus");
//
//        given(hostPathogenDao.saveHostPathogen(hostPathogen)).willReturn(hostPathogen);
//
//
//        //when
//        HostPathogen returned = hostPathogenManager.saveHostPathogen(hostPathogen);
//
//        //then
//        assertTrue(returned.getPhoneNumber().equals("303-555-1212"));
//        assertTrue(returned.getRoles().size() == 1);
//    }

//    @Test
//    public void testAddAndRemoveHostPathogen() throws Exception {
//        //given
//        HostPathogen hostPathogen = new HostPathogen();
//
//        // call populate method in super class to populate test data
//        // from a properties file matching this class name
//        hostPathogen = (HostPathogen) populate(hostPathogen);
//
//
//        Role role = new Role(Constants.USER_ROLE);
//        hostPathogen.addRole(role);
//
//        final HostPathogen hostPathogen1 = hostPathogen;
//        given(hostPathogenDao.saveHostPathogen(hostPathogen1)).willReturn(hostPathogen1);
//
//
//        //when
//        hostPathogen = hostPathogenManager.saveHostPathogen(hostPathogen);
//
//        //then
//        assertTrue(hostPathogen.getHostPathogenname().equals("john"));
//        assertTrue(hostPathogen.getRoles().size() == 1);
//
//        //given
//        willDoNothing().given(hostPathogenDao).remove(5L);
//        hostPathogenManager.removeHostPathogen("5");
//
//        given(hostPathogenDao.get(5L)).willReturn(null);
//
//        //when
//        hostPathogen = hostPathogenManager.getHostPathogen("5");
//
//        //then
//        assertNull(hostPathogen);
//        verify(hostPathogenDao).remove(5L);
//    }

//    @Test
//    public void testHostPathogenExistsException() {
//        // set expectations
//        final HostPathogen hostPathogen = new HostPathogen();
//        hostPathogen.setGenus("new");
//
//        willThrow(new DataIntegrityViolationException("")).given(hostPathogenDao).saveHostPathogen(hostPathogen);
//
//        // run test
//        try {
//            hostPathogenManager.saveHostPathogen(hostPathogen);
//            fail("Expected HostPathogenExistsException not thrown");
//        } catch (HostPathogenExistsException e) {
//            log.debug("expected exception: " + e.getMessage());
//            assertNotNull(e);
//        }
//    }

}
