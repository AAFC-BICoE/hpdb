package ca.gc.agr.mbb.hostpathogen.web.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import ca.gc.agr.mbb.hostpathogen.web.dao.ReferenceDao;
import ca.gc.agr.mbb.hostpathogen.web.model.Reference;

/**
 * This class interacts with Hibernate session to save/delete and
 * retrieve Reference objects.
 *
 * @author bilkhus
 */
@Repository("referenceDao")
public class ReferenceDaoHibernate extends GenericDaoHibernate<Reference, Long> implements ReferenceDao {

    /**
     * Constructor that sets the entity to Reference.class.
     */
    public ReferenceDaoHibernate() {
        super(Reference.class);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Reference> getReferences() {
        Query qry = getSession().createQuery("from Reference h order by upper(h.id)");
        return qry.list();
    }

    /**
     * {@inheritDoc}
     */
    public Reference saveReference(Reference reference) {
        if (log.isDebugEnabled()) {
            log.debug("reference's id: " + reference.getId());
        }
        getSession().saveOrUpdate(reference);
        // necessary to throw a DataIntegrityViolation and catch it in ReferenceManager
        getSession().flush();
        return reference;
    }

    /**
     * Overridden simply to call the saveReference method. This is happening
     * because saveReference flushes the session and saveObject of BaseDaoHibernate
     * does not.
     *
     * @param reference the reference to save
     * @return the modified reference (with a primary key set if they're new)
     */
    @Override
    public Reference save(Reference reference) {
        return this.saveReference(reference);
    }

}
