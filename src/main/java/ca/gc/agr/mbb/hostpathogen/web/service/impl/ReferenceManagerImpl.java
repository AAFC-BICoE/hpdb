package ca.gc.agr.mbb.hostpathogen.web.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.gc.agr.mbb.hostpathogen.web.dao.ReferenceDao;
import ca.gc.agr.mbb.hostpathogen.web.model.Reference;
import ca.gc.agr.mbb.hostpathogen.web.service.ReferenceManager;


/**
 * Implementation of ReferenceManager interface.
 *
 * @author bilkhus
 */
@Service("referenceManager")
@WebService(serviceName = "ReferenceService", endpointInterface = "ca.gc.agr.mbb.hostpathogen.web.service.ReferenceService")
public class ReferenceManagerImpl extends GenericManagerImpl<Reference, Long> implements ReferenceManager {
    private ReferenceDao referenceDao;

    @Override
    @Autowired
    public void setReferenceDao(final ReferenceDao referenceDao) {
        this.dao = referenceDao;
        this.referenceDao = referenceDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Reference getReference(final String referenceId) {
        return referenceDao.get(new Long(referenceId));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Reference> getReferences() {
        return referenceDao.getAllDistinct();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Reference> search(final String searchTerm) {
        return super.search(searchTerm, Reference.class);
    }

}