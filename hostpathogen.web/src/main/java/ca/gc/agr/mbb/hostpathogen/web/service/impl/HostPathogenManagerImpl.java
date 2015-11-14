package ca.gc.agr.mbb.hostpathogen.web.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.gc.agr.mbb.hostpathogen.web.dao.HostPathogenDao;
import ca.gc.agr.mbb.hostpathogen.web.model.HostPathogen;
import ca.gc.agr.mbb.hostpathogen.web.service.HostPathogenManager;

@Service("hostPathogenManager")
@WebService(serviceName = "HostPathogenService", endpointInterface = "ca.gc.agr.mbb.hostPathogenpathogen.web.service.HostPathogenService")
public class HostPathogenManagerImpl extends GenericManagerImpl<HostPathogen, Long> implements HostPathogenManager{
	
	private HostPathogenDao hostPathogenDao;
	
    @Override
    @Autowired
    public void setHostPathogenDao(final HostPathogenDao hostPathogenDao) {
        this.dao = hostPathogenDao;
        this.hostPathogenDao = hostPathogenDao;
    }

	@Override
	public List<HostPathogen> findHostPathogenByGenus(String genus) {
		try {
			return hostPathogenDao.getHostPathogenByHostGenus(genus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
    /**
     * {@inheritDoc}
     */
    @Override
    public HostPathogen getHostPathogen(final String userId) {
        return hostPathogenDao.get(new Long(userId));
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<HostPathogen> getHostPathogens() {
        return hostPathogenDao.getAllDistinct();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<HostPathogen> search(final String searchTerm) {
        return super.search(searchTerm, HostPathogen.class);
    }

}