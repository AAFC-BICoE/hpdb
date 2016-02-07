package ca.gc.agr.mbb.hostpathogen.web.service.impl;

import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import ca.gc.agr.mbb.hostpathogen.web.dao.ReferenceDao;
import ca.gc.agr.mbb.hostpathogen.web.model.Reference;


public class ReferenceManagerImplTest extends BaseManagerMockTestCase {
	
	@Mock 
	private ReferenceDao referenceDao;
	
	@InjectMocks
	private ReferenceManagerImpl referenceManager;
	
    @Test
    public void testGetReference() throws Exception {
        //given
        final Reference testData = new Reference();
        given(referenceDao.get(1L)).willReturn(testData);

        //then
        Reference reference = referenceManager.getReference("1");

        //then
        assertTrue(reference != null);
        assert reference != null;
    }

//    @Test
//    public void testSaveReference() throws Exception {
//        //given
//        final Reference testData = new Reference();
//
//        given(referenceDao.get(1L)).willReturn(testData);
//
//
//        final Reference reference = referenceManager.getReference("-1");
//        reference.setGenus("Aspergillus");
//
//        given(referenceDao.saveReference(reference)).willReturn(reference);
//
//
//        //when
//        Reference returned = referenceManager.saveReference(reference);
//
//        //then
//        assertTrue(returned.getPhoneNumber().equals("303-555-1212"));
//        assertTrue(returned.getRoles().size() == 1);
//    }

//    @Test
//    public void testAddAndRemoveReference() throws Exception {
//        //given
//        Reference reference = new Reference();
//
//        // call populate method in super class to populate test data
//        // from a properties file matching this class name
//        reference = (Reference) populate(reference);
//
//
//        Role role = new Role(Constants.USER_ROLE);
//        reference.addRole(role);
//
//        final Reference reference1 = reference;
//        given(referenceDao.saveReference(reference1)).willReturn(reference1);
//
//
//        //when
//        reference = referenceManager.saveReference(reference);
//
//        //then
//        assertTrue(reference.getReferencename().equals("john"));
//        assertTrue(reference.getRoles().size() == 1);
//
//        //given
//        willDoNothing().given(referenceDao).remove(5L);
//        referenceManager.removeReference("5");
//
//        given(referenceDao.get(5L)).willReturn(null);
//
//        //when
//        reference = referenceManager.getReference("5");
//
//        //then
//        assertNull(reference);
//        verify(referenceDao).remove(5L);
//    }

//    @Test
//    public void testReferenceExistsException() {
//        // set expectations
//        final Reference reference = new Reference();
//        reference.setGenus("new");
//
//        willThrow(new DataIntegrityViolationException("")).given(referenceDao).saveReference(reference);
//
//        // run test
//        try {
//            referenceManager.saveReference(reference);
//            fail("Expected ReferenceExistsException not thrown");
//        } catch (ReferenceExistsException e) {
//            log.debug("expected exception: " + e.getMessage());
//            assertNotNull(e);
//        }
//    }

}
