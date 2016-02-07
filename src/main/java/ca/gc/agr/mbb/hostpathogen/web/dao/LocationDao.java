package ca.gc.agr.mbb.hostpathogen.web.dao;

import java.util.List;

import ca.gc.agr.mbb.hostpathogen.web.model.Location;

/**
 * Location Data Access Object (GenericDao) interface.
 *
 * @author bilkhus
 */
public interface LocationDao extends GenericDao<Location, Long> {

    /**
     * Gets a list of locations ordered by the uppercase version of their locationname.
     *
     * @return List populated list of locations
     */
    List<Location> getLocations();

}