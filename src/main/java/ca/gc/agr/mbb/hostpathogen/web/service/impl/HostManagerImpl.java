package ca.gc.agr.mbb.hostpathogen.web.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.gc.agr.mbb.hostpathogen.web.dao.HostDao;
import ca.gc.agr.mbb.hostpathogen.web.model.Host;
import ca.gc.agr.mbb.hostpathogen.web.service.HostManager;

@Service("hostManager")
@WebService(serviceName = "HostService", endpointInterface = "ca.gc.agr.mbb.hostpathogen.web.service.HostService")
public class HostManagerImpl extends GenericManagerImpl<Host, Long> implements HostManager{
	
	private HostDao hostDao;
	
    @Override
    @Autowired
    public void setHostDao(final HostDao hostDao) {
        this.dao = hostDao;
        this.hostDao = hostDao;
    }

	@Override
	public List<Host> findHostByGenus(String genus) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
    /**
     * {@inheritDoc}
     */
    @Override
    public Host getHost(final String userId) {
        return hostDao.get(new Long(userId));
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Host> getHosts() {
        return hostDao.getAllDistinct();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Host> search(final String searchTerm) {
        return super.search(searchTerm, Host.class);
    }

}