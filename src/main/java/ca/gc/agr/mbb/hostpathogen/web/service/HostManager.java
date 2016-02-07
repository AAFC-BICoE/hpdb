package ca.gc.agr.mbb.hostpathogen.web.service;

import java.util.List;

import ca.gc.agr.mbb.hostpathogen.web.dao.HostDao;
import ca.gc.agr.mbb.hostpathogen.web.model.Host;

/**
 * The Interface HostManager.
 */
public interface HostManager extends GenericManager<Host, Long>{
	
	/**
	 * Find host by genus.
	 *
	 * @param genus the genus
	 * @return the list
	 */
	List<Host> findHostByGenus(String genus);
	
    /**
     * Gets the host.
     *
     * @param userId the user id
     * @return the host
     */
    public Host getHost(final String userId);
    
    /**
     * Search.
     *
     * @param searchTerm the search term
     * @return the list
     */
    List<Host> search(String searchTerm);

	/**
	 * Gets the hosts.
	 *
	 * @return the hosts
	 */
	List<Host> getHosts();
	
	/**
	 * Sets the host dao.
	 *
	 * @param hostDao the new host dao
	 */
	void setHostDao(HostDao hostDao);

}