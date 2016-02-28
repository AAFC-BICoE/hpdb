package ca.gc.agr.mbb.hostpathogen.web.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ca.gc.agr.mbb.hostpathogen.web.dao.HostPathogenDao;
import ca.gc.agr.mbb.hostpathogen.web.model.Host;
import ca.gc.agr.mbb.hostpathogen.web.model.HostPathogen;
import ca.gc.agr.mbb.hostpathogen.web.model.Pathogen;

/**
 * This class interacts with Hibernate session to save/delete and
 * retrieve HostPathogen objects.
 *
 * @author bilkhus
 */
@Repository("hostPathogenDao")
public class HostPathogenDaoHibernate extends GenericDaoHibernate<HostPathogen, Long> implements HostPathogenDao {

    /**
     * Constructor that sets the entity to HostPathogen.class.
     */
    public HostPathogenDaoHibernate() {
        super(HostPathogen.class);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<HostPathogen> getHostPathogens() {
        Query qry = getSession().createQuery("from HostPathogen h order by upper(h.id)");
        return qry.list();
    }

    /**
     * {@inheritDoc}
     */
    public HostPathogen saveHostPathogen(HostPathogen hostPathogen) {
        if (log.isDebugEnabled()) {
            log.debug("hostPathogen's id: " + hostPathogen.getId());
        }
        getSession().saveOrUpdate(hostPathogen);
        // necessary to throw a DataIntegrityViolation and catch it in HostPathogenManager
        getSession().flush();
        return hostPathogen;
    }

    /**
     * Overridden simply to call the saveHostPathogen method. This is happening
     * because saveHostPathogen flushes the session and saveObject of BaseDaoHibernate
     * does not.
     *
     * @param hostPathogen the hostPathogen to save
     * @return the modified hostPathogen (with a primary key set if they're new)
     */
    @Override
    public HostPathogen save(HostPathogen hostPathogen) {
        return this.saveHostPathogen(hostPathogen);
    }
    
    /**
     * {@inheritDoc}
     * @throws Exception 
     */
    @SuppressWarnings("unchecked")
	public List<HostPathogen> getHostPathogenByHostGenus(String genus) throws Exception {
        List <HostPathogen> hp = null;
        
        Criteria c = getSession().createCriteria(HostPathogen.class);
        c.createAlias("host", "host")  ;     
        c.add(Restrictions.eq("host.genus", genus));
        hp = c.list();
        
        if (hp == null || hp.isEmpty()) {
            throw new Exception("genus '" + genus + "' not found...");
        } else {
            return hp;
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
	public List<Pathogen> getPathogenByHost(Long hostId){
    	
    	Query q = getSession()
    				.createQuery("select distinct pathogen from HostPathogen where host = :hostId");
    	q.setParameter("hostId", hostId);					
    	
    	return q.list();
    }
    
    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Host> getHostByPathogen(Long pathogenId){
    	
    	Query q = getSession()
    				.createQuery("select distinct host from HostPathogen where pathogen = :pathogenId");
    	q.setParameter("pathogenId", pathogenId);					
    	
    	return q.list();
    }
    
}