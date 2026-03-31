package ca.gc.agr.mbb.hostpathogen.web.dao;

import java.util.List;

import ca.gc.agr.mbb.hostpathogen.web.model.Host;

/**
 * Host Data Access Object (GenericDao) interface.
 *
 * @author bilkhus
 */
public interface HostDao extends GenericDao<Host, Long> {

    /**
     * Gets a list of hosts ordered by the uppercase version of their hostname.
     *
     * @return List populated list of hosts
     */
    List<Host> getHosts();

    /**
     * Saves a host's information.
     * @param host the object to be saved
     * @return the persisted Host object
     */
    Host saveHost(Host host);

}
