package ca.gc.agr.mbb.hostpathogen.web.dao;

import java.util.List;

import ca.gc.agr.mbb.hostpathogen.web.model.Pathogen;

/**
 * Pathogen Data Access Object (GenericDao) interface.
 *
 * @author bilkhus
 */
public interface PathogenDao extends GenericDao<Pathogen, Long> {

    /**
     * Gets a list of pathogens ordered by the uppercase version of their pathogenname.
     *
     * @return List populated list of pathogens
     */
    List<Pathogen> getPathogens();

    /**
     * Saves a pathogen's information.
     * @param pathogen the object to be saved
     * @return the persisted Pathogen object
     */
    Pathogen savePathogen(Pathogen pathogen);

}