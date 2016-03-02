package ca.gc.agr.mbb.hostpathogen.web.dao.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.util.Version;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.ObjectRetrievalFailureException;

import ca.gc.agr.mbb.hostpathogen.web.dao.GenericDao;
import ca.gc.agr.mbb.hostpathogen.web.dao.SearchException;

/**
 * This class serves as the Base class for all other DAOs - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * <p>To register this class in your Spring context file, use the following XML.
 * <pre>
 *      &lt;bean id="fooDao" class="ca.gc.agr.mbb.hostpathogen.web.dao.hibernate.GenericDaoHibernate"&gt;
 *          &lt;constructor-arg value="ca.gc.agr.mbb.hostpathogen.web.model.Foo"/&gt;
 *      &lt;/bean&gt;
 * </pre>
 *
 * @param <T>  a type variable
 * @param <PK> the primary key for that type
 * @author <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 *         Updated by jgarcia: update hibernate3 to hibernate4
 * @author jgarcia (update: added full text search + reindexing)
 */
@SuppressWarnings("deprecation")
public class GenericDaoHibernate<T, PK extends Serializable> implements GenericDao<T, PK> {
    /**
     * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from Commons Logging
     */
    protected final Log log = LogFactory.getLog(getClass());
    private Class<T> persistentClass;
    @Resource
    private SessionFactory sessionFactory;
    private Analyzer defaultAnalyzer;

    /**
     * Constructor that takes in a class to see which type of entity to persist.
     * Use this constructor when subclassing.
     *
     * @param persistentClass the class type you'd like to persist
     */
    public GenericDaoHibernate(final Class<T> persistentClass) {
        this.persistentClass = persistentClass;
        defaultAnalyzer = new StandardAnalyzer(Version.LUCENE_36);
    }

    /**
     * Constructor that takes in a class and sessionFactory for easy creation of DAO.
     *
     * @param persistentClass the class type you'd like to persist
     * @param sessionFactory  the pre-configured Hibernate SessionFactory
     */
    public GenericDaoHibernate(final Class<T> persistentClass, SessionFactory sessionFactory) {
        this.persistentClass = persistentClass;
        this.sessionFactory = sessionFactory;
        defaultAnalyzer = new StandardAnalyzer(Version.LUCENE_36);
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public Session getSession() throws HibernateException {
        Session sess = getSessionFactory().getCurrentSession();
        if (sess == null) {
            sess = getSessionFactory().openSession();
        }
        return sess;
    }

    @Autowired
    @Required
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	protected void createSortCriteria(String sortColumn, boolean ascending,	Criteria criteria) {

		if (sortColumn == null)
			return;

		String[] columnProperties = sortColumn.split("\\.");

		String sortProperty = columnProperties.length > 0 ? 
							 	columnProperties[columnProperties.length - 1] : 
								sortColumn;

		Criteria sortCriteria = criteria;
		for (int i = 0; i < columnProperties.length - 1; i++) {
			sortCriteria = sortCriteria.createCriteria(columnProperties[i]);
		}

		sortCriteria.addOrder(ascending ? Order.asc(sortProperty) : Order.desc(sortProperty));
	}

	private Criteria createFilterCriteria(String filterEntity, String filterAttribute, String value, Criteria criteria) {

		Criteria filterCriteria = criteria;

		if (value == null || value.length() == 0)
			return criteria;

		if (filterEntity != null && filterEntity.contains(".")) {

			int splitPoint = filterEntity.indexOf(".");
			
			String entity = filterEntity.substring(0, splitPoint);
			filterEntity = filterEntity.substring(splitPoint + 1, filterEntity.length());

			return createFilterCriteria(filterEntity, filterAttribute, value, filterCriteria.createCriteria(entity));

		} else {

			if (filterEntity != null)
				filterCriteria = filterCriteria.createCriteria(filterEntity);

//			System.out.print("Creating filter criteria: " + filterAttribute + " " + value);
			
			filterCriteria.add(Expression.like(filterAttribute, value));

		}

		return filterCriteria;
	}

	protected void createFilterCriteria(Map<String, String> filters, Criteria criteria) {
		
		Map<String, Criteria> criterias = new HashMap<String, Criteria>();
		
		for (String fullAttribute : filters.keySet()) {
			
			if (fullAttribute.contains(".")) {
				
				String entity = fullAttribute.substring(0, fullAttribute.lastIndexOf("."));
				String attribute = fullAttribute.substring(fullAttribute.lastIndexOf(".") + 1);
				
				if (criterias.get(entity) == null) {
					
					criterias.put(entity, createFilterCriteria(entity, attribute, filters.get(fullAttribute), criteria));
					
				} else {
					
					createFilterCriteria(null, attribute, filters.get(fullAttribute), criterias.get(entity));
					
				}
				
			} else {
				
				createFilterCriteria(null, fullAttribute, filters.get(fullAttribute), criteria);
				
			}
			
		}
		
	}
	
    /**
     * {@inheritDoc}
     */
	@SuppressWarnings("unchecked")
	public List<T> getFilteredPagedData(int start, int page, String property, boolean ascending, Map<String, String> filters, boolean export) {
		Session sess = getSession();
		Criteria criteria = sess.createCriteria(this.persistentClass);
		
		if(!export){
			criteria.setFirstResult(start);
			criteria.setMaxResults(page);
		} 

		createSortCriteria(property, ascending, criteria);
		
		if (filters.size() > 0) {
			createFilterCriteria(filters, criteria);
		}
		
		return criteria.list();
	}
	
    /**
     * {@inheritDoc}
     */
	public int getDataCount(Map<String, String> filters) {
		Session sess = getSession();
		Criteria criteria = sess.createCriteria(this.persistentClass);
		
		if (filters.size() > 0) {
			createFilterCriteria(filters, criteria);
		}
		
		criteria.setProjection(Projections.rowCount());
		Number nuofRecords = ((Number) criteria.uniqueResult());
		
		return nuofRecords == null ? 0 : nuofRecords.intValue();
	}
    

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        Session sess = getSession();
        return sess.createCriteria(persistentClass).list();
    }

    /**
     * {@inheritDoc}
     */
    public List<T> getAllDistinct() {
        Collection<T> result = new LinkedHashSet<T>(getAll());
        return new ArrayList<T>(result);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
	public List<T> search(String searchTerm) throws SearchException {
        Session sess = getSession();
        FullTextSession txtSession = Search.getFullTextSession(sess);

        org.apache.lucene.search.Query qry;
        try {
            qry = HibernateSearchTools.generateQuery(searchTerm, this.persistentClass, sess, defaultAnalyzer);
        } catch (ParseException ex) {
            throw new SearchException(ex);
        }
        org.hibernate.search.FullTextQuery hibQuery = txtSession.createFullTextQuery(qry,
                this.persistentClass);
        return hibQuery.list();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public T get(PK id) {
        Session sess = getSession();
        IdentifierLoadAccess byId = sess.byId(persistentClass);
        T entity = (T) byId.load(id);

        if (entity == null) {
            log.warn("Uh oh, '" + this.persistentClass + "' object with id '" + id + "' not found...");
            throw new ObjectRetrievalFailureException(this.persistentClass, id);
        }

        return entity;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public boolean exists(PK id) {
        Session sess = getSession();
        IdentifierLoadAccess byId = sess.byId(persistentClass);
        T entity = (T) byId.load(id);
        return entity != null;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public T save(T object) {
        Session sess = getSession();
        return (T) sess.merge(object);
    }

    /**
     * {@inheritDoc}
     */
    public void remove(T object) {
        Session sess = getSession();
        sess.delete(object);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
	public void remove(PK id) {
        Session sess = getSession();
        IdentifierLoadAccess byId = sess.byId(persistentClass);
        T entity = (T) byId.load(id);
        sess.delete(entity);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
        Session sess = getSession();
        Query namedQuery = sess.getNamedQuery(queryName);
        for (String s : queryParams.keySet()) {
            Object val = queryParams.get(s);
            if (val instanceof Collection) {
                namedQuery.setParameterList(s, (Collection) val);
            } else {
                namedQuery.setParameter(s, val);
            }
        }
        return namedQuery.list();
    }

    /**
     * {@inheritDoc}
     */
    public void reindex() {
        HibernateSearchTools.reindex(persistentClass, getSessionFactory().getCurrentSession());
    }


    /**
     * {@inheritDoc}
     */
    public void reindexAll(boolean async) {
        HibernateSearchTools.reindexAll(async, getSessionFactory().getCurrentSession());
    }

}