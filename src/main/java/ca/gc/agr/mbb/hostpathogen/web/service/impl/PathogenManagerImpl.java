package ca.gc.agr.mbb.hostpathogen.web.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.gc.agr.mbb.hostpathogen.web.dao.PathogenDao;
import ca.gc.agr.mbb.hostpathogen.web.model.Pathogen;
import ca.gc.agr.mbb.hostpathogen.web.service.PathogenManager;

@Service("pathogenManager")
@WebService(serviceName = "PathogenService", endpointInterface = "ca.gc.agr.mbb.pathogenpathogen.web.service.PathogenService")
public class PathogenManagerImpl extends GenericManagerImpl<Pathogen, Long> implements PathogenManager{
	
	private PathogenDao pathogenDao;
	
    @Override
    @Autowired
    public void setPathogenDao(final PathogenDao pathogenDao) {
        this.dao = pathogenDao;
        this.pathogenDao = pathogenDao;
    }

	@Override
	public List<Pathogen> findPathogenByGenus(String genus) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
    /**
     * {@inheritDoc}
     */
    @Override
    public Pathogen getPathogen(final String userId) {
        return pathogenDao.get(new Long(userId));
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Pathogen> getPathogens() {
        return pathogenDao.getAllDistinct();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Pathogen> search(final String searchTerm) {
        return super.search(searchTerm, Pathogen.class);
    }

}