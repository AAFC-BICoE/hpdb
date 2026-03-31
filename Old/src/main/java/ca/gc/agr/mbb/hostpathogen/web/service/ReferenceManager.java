package ca.gc.agr.mbb.hostpathogen.web.service;

import java.util.List;

import ca.gc.agr.mbb.hostpathogen.web.dao.ReferenceDao;
import ca.gc.agr.mbb.hostpathogen.web.model.Reference;


/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *  Modified by <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
public interface ReferenceManager extends GenericManager<Reference, Long> {
	
    /**
     * Convenience method for testing - allows you to mock the DAO and set it on an interface.
     * @param referenceDao the ReferenceDao implementation to use
     */
    void setReferenceDao(ReferenceDao referenceDao);

    /**
     * Retrieves a reference by referenceId.  An exception is thrown if reference not found
     *
     * @param referenceId the identifier for the reference
     * @return Reference
     */
    Reference getReference(String referenceId);

    /**
     * Finds a reference by their referencename.
     * @param referencename the reference's referencename used to login
     * @return Reference a populated reference object
     * @throws org.springframework.security.core.referencedetails.ReferencenameNotFoundException
     *         exception thrown when reference not found
     */

    /**
     * Retrieves a list of all references.
     * @return List
     */
    List<Reference> getReferences();

    /**
     * Saves a reference's information.
     *
     * @param reference the reference's information
     * @throws ReferenceExistsException thrown when reference already exists
     * @return reference the updated reference object
     */

    /**
     * Search a reference for search terms.
     * @param searchTerm the search terms.
     * @return a list of matches, or all if no searchTerm.
     */
    List<Reference> search(String searchTerm);
}
