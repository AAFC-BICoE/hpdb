package ca.gc.agr.mbb.hostpathogen.web.service.impl;

import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import ca.gc.agr.mbb.hostpathogen.web.dao.HostDao;
import ca.gc.agr.mbb.hostpathogen.web.model.Host;


public class HostManagerImplTest extends BaseManagerMockTestCase {
	
	@Mock 
	private HostDao hostDao;
	
	@InjectMocks
	private HostManagerImpl hostManager;
	
    @Test
    public void testGetHost() throws Exception {
        //given
        final Host testData = new Host();
        given(hostDao.get(1L)).willReturn(testData);

        //then
        Host host = hostManager.getHost("1");

        //then
        assertTrue(host != null);
        assert host != null;
    }

//    @Test
//    public void testSaveHost() throws Exception {
//        //given
//        final Host testData = new Host();
//
//        given(hostDao.get(1L)).willReturn(testData);
//
//
//        final Host host = hostManager.getHost("-1");
//        host.setGenus("Aspergillus");
//
//        given(hostDao.saveHost(host)).willReturn(host);
//
//
//        //when
//        Host returned = hostManager.saveHost(host);
//
//        //then
//        assertTrue(returned.getPhoneNumber().equals("303-555-1212"));
//        assertTrue(returned.getRoles().size() == 1);
//    }

//    @Test
//    public void testAddAndRemoveHost() throws Exception {
//        //given
//        Host host = new Host();
//
//        // call populate method in super class to populate test data
//        // from a properties file matching this class name
//        host = (Host) populate(host);
//
//
//        Role role = new Role(Constants.USER_ROLE);
//        host.addRole(role);
//
//        final Host host1 = host;
//        given(hostDao.saveHost(host1)).willReturn(host1);
//
//
//        //when
//        host = hostManager.saveHost(host);
//
//        //then
//        assertTrue(host.getHostname().equals("john"));
//        assertTrue(host.getRoles().size() == 1);
//
//        //given
//        willDoNothing().given(hostDao).remove(5L);
//        hostManager.removeHost("5");
//
//        given(hostDao.get(5L)).willReturn(null);
//
//        //when
//        host = hostManager.getHost("5");
//
//        //then
//        assertNull(host);
//        verify(hostDao).remove(5L);
//    }

//    @Test
//    public void testHostExistsException() {
//        // set expectations
//        final Host host = new Host();
//        host.setGenus("new");
//
//        willThrow(new DataIntegrityViolationException("")).given(hostDao).saveHost(host);
//
//        // run test
//        try {
//            hostManager.saveHost(host);
//            fail("Expected HostExistsException not thrown");
//        } catch (HostExistsException e) {
//            log.debug("expected exception: " + e.getMessage());
//            assertNotNull(e);
//        }
//    }

}
