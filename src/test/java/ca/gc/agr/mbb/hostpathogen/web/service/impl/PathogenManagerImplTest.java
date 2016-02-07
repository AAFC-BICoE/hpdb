package ca.gc.agr.mbb.hostpathogen.web.service.impl;

import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import ca.gc.agr.mbb.hostpathogen.web.dao.PathogenDao;
import ca.gc.agr.mbb.hostpathogen.web.model.Pathogen;


public class PathogenManagerImplTest extends BaseManagerMockTestCase {
	
	@Mock 
	private PathogenDao pathogenDao;
	
	@InjectMocks
	private PathogenManagerImpl pathogenManager;
	
    @Test
    public void testGetPathogen() throws Exception {
        //given
        final Pathogen testData = new Pathogen();
        given(pathogenDao.get(1L)).willReturn(testData);

        //then
        Pathogen pathogen = pathogenManager.getPathogen("1");

        //then
        assertTrue(pathogen != null);
        assert pathogen != null;
    }

//    @Test
//    public void testSavePathogen() throws Exception {
//        //given
//        final Pathogen testData = new Pathogen();
//
//        given(pathogenDao.get(1L)).willReturn(testData);
//
//
//        final Pathogen pathogen = pathogenManager.getPathogen("-1");
//        pathogen.setGenus("Aspergillus");
//
//        given(pathogenDao.savePathogen(pathogen)).willReturn(pathogen);
//
//
//        //when
//        Pathogen returned = pathogenManager.savePathogen(pathogen);
//
//        //then
//        assertTrue(returned.getPhoneNumber().equals("303-555-1212"));
//        assertTrue(returned.getRoles().size() == 1);
//    }

//    @Test
//    public void testAddAndRemovePathogen() throws Exception {
//        //given
//        Pathogen pathogen = new Pathogen();
//
//        // call populate method in super class to populate test data
//        // from a properties file matching this class name
//        pathogen = (Pathogen) populate(pathogen);
//
//
//        Role role = new Role(Constants.USER_ROLE);
//        pathogen.addRole(role);
//
//        final Pathogen pathogen1 = pathogen;
//        given(pathogenDao.savePathogen(pathogen1)).willReturn(pathogen1);
//
//
//        //when
//        pathogen = pathogenManager.savePathogen(pathogen);
//
//        //then
//        assertTrue(pathogen.getPathogenname().equals("john"));
//        assertTrue(pathogen.getRoles().size() == 1);
//
//        //given
//        willDoNothing().given(pathogenDao).remove(5L);
//        pathogenManager.removePathogen("5");
//
//        given(pathogenDao.get(5L)).willReturn(null);
//
//        //when
//        pathogen = pathogenManager.getPathogen("5");
//
//        //then
//        assertNull(pathogen);
//        verify(pathogenDao).remove(5L);
//    }

//    @Test
//    public void testPathogenExistsException() {
//        // set expectations
//        final Pathogen pathogen = new Pathogen();
//        pathogen.setGenus("new");
//
//        willThrow(new DataIntegrityViolationException("")).given(pathogenDao).savePathogen(pathogen);
//
//        // run test
//        try {
//            pathogenManager.savePathogen(pathogen);
//            fail("Expected PathogenExistsException not thrown");
//        } catch (PathogenExistsException e) {
//            log.debug("expected exception: " + e.getMessage());
//            assertNotNull(e);
//        }
//    }

}
