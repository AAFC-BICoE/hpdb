package ca.gc.agr.mbb.hostpathogen.web.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import ca.gc.agr.mbb.hostpathogen.web.dao.LocationDao;
import ca.gc.agr.mbb.hostpathogen.web.model.Location;

/**
 * This class interacts with Hibernate session to save/delete and
 * retrieve Location objects.
 *
 * @author bilkhus
 */
@Repository("locationDao")
public class LocationDaoHibernate extends GenericDaoHibernate<Location, Long> implements LocationDao {

    /**
     * Constructor that sets the entity to Location.class.
     */
    public LocationDaoHibernate() {
        super(Location.class);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Location> getLocations() {
        Query qry = getSession().createQuery("from Location h order by upper(h.id)");
        return qry.list();
    }

    /**
     * {@inheritDoc}
     */
    public Location saveLocation(Location location) {
        if (log.isDebugEnabled()) {
            log.debug("location's id: " + location.getId());
        }
        getSession().saveOrUpdate(location);
        // necessary to throw a DataIntegrityViolation and catch it in LocationManager
        getSession().flush();
        return location;
    }

    /**
     * Overridden simply to call the saveLocation method. This is happening
     * because saveLocation flushes the session and saveObject of BaseDaoHibernate
     * does not.
     *
     * @param location the location to save
     * @return the modified location (with a primary key set if they're new)
     */
    @Override
    public Location save(Location location) {
        return this.saveLocation(location);
    }

}
