package ca.gc.agr.mbb.hostpathogen.web.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import ca.gc.agr.mbb.hostpathogen.web.dao.PathogenDao;
import ca.gc.agr.mbb.hostpathogen.web.model.Pathogen;

/**
 * This class interacts with Hibernate session to save/delete and
 * retrieve Pathogen objects.
 *
 * @author bilkhus
 */
@Repository("pathogenDao")
public class PathogenDaoHibernate extends GenericDaoHibernate<Pathogen, Long> implements PathogenDao {

    /**
     * Constructor that sets the entity to Pathogen.class.
     */
    public PathogenDaoHibernate() {
        super(Pathogen.class);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Pathogen> getPathogens() {
        Query qry = getSession().createQuery("from Pathogen p order by upper(p.genus)");
        return qry.list();
    }

    /**
     * {@inheritDoc}
     */
    public Pathogen savePathogen(Pathogen pathogen) {
        if (log.isDebugEnabled()) {
            log.debug("pathogen's id: " + pathogen.getId());
        }
        getSession().saveOrUpdate(pathogen);
        // necessary to throw a DataIntegrityViolation and catch it in PathogenManager
        getSession().flush();
        return pathogen;
    }

    /**
     * Overridden simply to call the savePathogen method. This is happening
     * because savePathogen flushes the session and saveObject of BaseDaoHibernate
     * does not.
     *
     * @param pathogen the pathogen to save
     * @return the modified pathogen (with a primary key set if they're new)
     */
    @Override
    public Pathogen save(Pathogen pathogen) {
        return this.savePathogen(pathogen);
    }

}
