package ca.gc.agr.mbb.hostpathogen.web.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import ca.gc.agr.mbb.hostpathogen.web.dao.HostDao;
import ca.gc.agr.mbb.hostpathogen.web.model.Host;

/**
 * This class interacts with Hibernate session to save/delete and
 * retrieve Host objects.
 *
 * @author bilkhus
 */
@Repository("hostDao")
public class HostDaoHibernate extends GenericDaoHibernate<Host, Long> implements HostDao {

    /**
     * Constructor that sets the entity to Host.class.
     */
    public HostDaoHibernate() {
        super(Host.class);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Host> getHosts() {
        Query qry = getSession().createQuery("from Host h order by upper(h.genus)");
        return qry.list();
    }

    /**
     * {@inheritDoc}
     */
    public Host saveHost(Host host) {
        if (log.isDebugEnabled()) {
            log.debug("host's id: " + host.getId());
        }
        getSession().saveOrUpdate(host);
        // necessary to throw a DataIntegrityViolation and catch it in HostManager
        getSession().flush();
        return host;
    }

    /**
     * Overridden simply to call the saveHost method. This is happening
     * because saveHost flushes the session and saveObject of BaseDaoHibernate
     * does not.
     *
     * @param host the host to save
     * @return the modified host (with a primary key set if they're new)
     */
    @Override
    public Host save(Host host) {
        return this.saveHost(host);
    }

}
