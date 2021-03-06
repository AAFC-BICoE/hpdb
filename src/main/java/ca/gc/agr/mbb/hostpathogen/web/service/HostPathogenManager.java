package ca.gc.agr.mbb.hostpathogen.web.service;

import java.util.List;

import ca.gc.agr.mbb.hostpathogen.web.dao.HostPathogenDao;
import ca.gc.agr.mbb.hostpathogen.web.model.Host;
import ca.gc.agr.mbb.hostpathogen.web.model.HostPathogen;
import ca.gc.agr.mbb.hostpathogen.web.model.Pathogen;

/**
 * The Interface HostPathogenManager.
 */
public interface HostPathogenManager extends GenericManager<HostPathogen, Long>{
	
	/**
	 * Find host by genus.
	 *
	 * @param genus the genus
	 * @return the list
	 */
	List<HostPathogen> findHostPathogenByGenus(String genus);
	
    /**
     * Gets the host.
     *
     * @param userId the user id
     * @return the host
     */
    public HostPathogen getHostPathogen(final String userId);
    
    /**
     * Search.
     *
     * @param searchTerm the search term
     * @return the list
     */
    List<HostPathogen> search(String searchTerm);

	/**
	 * Gets the hosts.
	 *
	 * @return the hosts
	 */
	List<HostPathogen> getHostPathogens();
	
	/**
	 * Sets the host dao.
	 *
	 * @param hostDao the new host dao
	 */
	void setHostPathogenDao(HostPathogenDao hostDao);
	
    /**
     * Gets the pathogen by host.
     *
     * @param hostId the host id
     * @return the pathogen by host
     */
    public List<Pathogen> getPathogenByHost(Long hostId);

    
    /**
     * Gets the host by pathogen.
     *
     * @param pathogenId the pathogen id
     * @return the host by pathogen
     */
    public List<Host> getHostByPathogen(Long pathogenId);
    
}