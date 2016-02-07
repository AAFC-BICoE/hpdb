package ca.gc.agr.mbb.hostpathogen.web.dao;

import java.util.List;

import ca.gc.agr.mbb.hostpathogen.web.model.Reference;

/**
 * Reference Data Access Object (GenericDao) interface.
 *
 * @author bilkhus
 */
public interface ReferenceDao extends GenericDao<Reference, Long> {

    /**
     * Gets a list of references ordered by the uppercase version of their referencename.
     *
     * @return List populated list of references
     */
    List<Reference> getReferences();

}
