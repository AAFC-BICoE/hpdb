package ca.gc.agr.mbb.hostpathogen.web.service;

import java.util.List;

import ca.gc.agr.mbb.hostpathogen.web.dao.PathogenDao;
import ca.gc.agr.mbb.hostpathogen.web.model.Pathogen;

/**
 * The Interface PathogenManager.
 */
public interface PathogenManager extends GenericManager<Pathogen, Long>{
	
	/**
	 * Find pathogen by genus.
	 *
	 * @param genus the genus
	 * @return the list
	 */
	List<Pathogen> findPathogenByGenus(String genus);
	
    /**
     * Gets the pathogen.
     *
     * @param userId the user id
     * @return the pathogen
     */
    public Pathogen getPathogen(final String userId);
    
    /**
     * Search.
     *
     * @param searchTerm the search term
     * @return the list
     */
    List<Pathogen> search(String searchTerm);

	/**
	 * Gets the pathogens.
	 *
	 * @return the pathogens
	 */
	List<Pathogen> getPathogens();
	
	/**
	 * Sets the pathogen dao.
	 *
	 * @param pathogenDao the new pathogen dao
	 */
	void setPathogenDao(PathogenDao pathogenDao);

}