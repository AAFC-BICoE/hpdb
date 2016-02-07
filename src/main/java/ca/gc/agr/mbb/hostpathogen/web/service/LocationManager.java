package ca.gc.agr.mbb.hostpathogen.web.service;

import java.util.List;

import ca.gc.agr.mbb.hostpathogen.web.dao.LocationDao;
import ca.gc.agr.mbb.hostpathogen.web.model.Location;


/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *  Modified by <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
public interface LocationManager extends GenericManager<Location, Long> {
	
    /**
     * Convenience method for testing - allows you to mock the DAO and set it on an interface.
     * @param locationDao the LocationDao implementation to use
     */
    void setLocationDao(LocationDao locationDao);

    /**
     * Retrieves a location by locationId.  An exception is thrown if location not found
     *
     * @param locationId the identifier for the location
     * @return Location
     */
    Location getLocation(String locationId);

    /**
     * Finds a location by their locationname.
     * @param locationname the location's locationname used to login
     * @return Location a populated location object
     * @throws org.springframework.security.core.locationdetails.LocationnameNotFoundException
     *         exception thrown when location not found
     */

    /**
     * Retrieves a list of all locations.
     * @return List
     */
    List<Location> getLocations();

    /**
     * Saves a location's information.
     *
     * @param location the location's information
     * @throws LocationExistsException thrown when location already exists
     * @return location the updated location object
     */

    /**
     * Search a location for search terms.
     * @param searchTerm the search terms.
     * @return a list of matches, or all if no searchTerm.
     */
    List<Location> search(String searchTerm);
}
