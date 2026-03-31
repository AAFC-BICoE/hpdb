package ca.gc.agr.mbb.hostpathogen.web.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.gc.agr.mbb.hostpathogen.web.dao.GenericDao;
import ca.gc.agr.mbb.hostpathogen.web.service.GenericManager;

/**
 * This class serves as the Base class for all other Managers - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * <p>To register this class in your Spring context file, use the following XML.
 * <pre>
 *     &lt;bean id="userManager" class="ca.gc.agr.mbb.hostpathogen.web.service.impl.GenericManagerImpl"&gt;
 *         &lt;constructor-arg&gt;
 *             &lt;bean class="ca.gc.agr.mbb.hostpathogen.web.dao.hibernate.GenericDaoHibernate"&gt;
 *                 &lt;constructor-arg value="ca.gc.agr.mbb.hostpathogen.web.model.User"/&gt;
 *                 &lt;property name="sessionFactory" ref="sessionFactory"/&gt;
 *             &lt;/bean&gt;
 *         &lt;/constructor-arg&gt;
 *     &lt;/bean&gt;
 * </pre>
 * <p>If you're using iBATIS instead of Hibernate, use:
 * <pre>
 *     &lt;bean id="userManager" class="ca.gc.agr.mbb.hostpathogen.web.service.impl.GenericManagerImpl"&gt;
 *         &lt;constructor-arg&gt;
 *             &lt;bean class="ca.gc.agr.mbb.hostpathogen.web.dao.ibatis.GenericDaoiBatis"&gt;
 *                 &lt;constructor-arg value="ca.gc.agr.mbb.hostpathogen.web.model.User"/&gt;
 *                 &lt;property name="dataSource" ref="dataSource"/&gt;
 *                 &lt;property name="sqlMapClient" ref="sqlMapClient"/&gt;
 *             &lt;/bean&gt;
 *         &lt;/constructor-arg&gt;
 *     &lt;/bean&gt;
 * </pre>
 *
 * @param <T>  a type variable
 * @param <PK> the primary key for that type
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *  Updated by jgarcia: added full text search + reindexing
 */
public class GenericManagerImpl<T, PK extends Serializable> implements GenericManager<T, PK> {
    /**
     * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from Commons Logging
     */
    protected final Log log = LogFactory.getLog(getClass());

    /**
     * GenericDao instance, set by constructor of child classes
     */
    protected GenericDao<T, PK> dao;


    public GenericManagerImpl() {
    }

    public GenericManagerImpl(GenericDao<T, PK> genericDao) {
        this.dao = genericDao;
    }

    /**
     * {@inheritDoc}
     */
    public List<T> getAll() {
        return dao.getAll();
    }

    /**
     * {@inheritDoc}
     */
    public T get(PK id) {
        return dao.get(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean exists(PK id) {
        return dao.exists(id);
    }

    /**
     * {@inheritDoc}
     */
    public T save(T object) {
        return dao.save(object);
    }

    /**
     * {@inheritDoc}
     */
    public void remove(T object) {
        dao.remove(object);
    }

    /**
     * {@inheritDoc}
     */
    public void remove(PK id) {
        dao.remove(id);
    }

    /**
     * {@inheritDoc}
     * Search implementation using Hibernate Search.
     */
    @SuppressWarnings("rawtypes")
	public List<T> search(String q, Class clazz) {
        if (q == null || "".equals(q.trim())) {
            return getAll();
        }

        return dao.search(q);
    }

    /**
     * {@inheritDoc}
     */
    public void reindex() {
        dao.reindex();
    }

    /**
     * {@inheritDoc}
     */
    public void reindexAll(boolean async) {
        dao.reindexAll(async);
    }

    /**
     * {@inheritDoc}
     */
	public List<T> getFilteredPagedData(int start, int page, String field, boolean ascending, Map<String, String> filters, boolean export) {
		return dao.getFilteredPagedData(start, page, field, ascending, filters, export);
	}

    /**
     * {@inheritDoc}
     */
	public int getDataCount(Map<String, String> filters) {
		return dao.getDataCount(filters);
	}

}