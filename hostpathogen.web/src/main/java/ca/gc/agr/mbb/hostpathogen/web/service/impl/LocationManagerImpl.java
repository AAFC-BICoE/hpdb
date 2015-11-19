package ca.gc.agr.mbb.hostpathogen.web.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.gc.agr.mbb.hostpathogen.web.dao.LocationDao;
import ca.gc.agr.mbb.hostpathogen.web.model.Location;
import ca.gc.agr.mbb.hostpathogen.web.service.LocationManager;


/**
 * Implementation of LocationManager interface.
 *
 * @author bilkhus
 */
@Service("locationManager")
@WebService(serviceName = "LocationService", endpointInterface = "ca.gc.agr.mbb.hostpathogen.web.service.LocationService")
public class LocationManagerImpl extends GenericManagerImpl<Location, Long> implements LocationManager {
    private LocationDao locationDao;

    @Override
    @Autowired
    public void setLocationDao(final LocationDao locationDao) {
        this.dao = locationDao;
        this.locationDao = locationDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Location getLocation(final String locationId) {
        return locationDao.get(new Long(locationId));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Location> getLocations() {
        return locationDao.getAllDistinct();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Location> search(final String searchTerm) {
        return super.search(searchTerm, Location.class);
    }

}