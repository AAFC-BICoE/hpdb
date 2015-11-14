package ca.gc.agr.mbb.hostpathogen.web.dao;

import java.util.List;

import ca.gc.agr.mbb.hostpathogen.web.model.HostPathogen;

/**
 * HostPathogen Data Access Object (GenericDao) interface.
 *
 * @author bilkhus
 */
public interface HostPathogenDao extends GenericDao<HostPathogen, Long> {

    /**
     * Gets a list of hosts ordered by the uppercase version of their hostname.
     *
     * @return List populated list of hosts
     */
    List<HostPathogen> getHostPathogens();

    /**
     * Saves a host's information.
     * @param host the object to be saved
     * @return the persisted HostPathogen object
     */
    HostPathogen saveHostPathogen(HostPathogen host);
    
    /**
     * Gets the host pathogen by host genus.
     *
     * @param genus the genus
     * @return the host pathogen by host genus
     * @throws Exception the exception
     */
    public List<HostPathogen> getHostPathogenByHostGenus(String genus) throws Exception;

}
