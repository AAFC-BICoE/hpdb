package ca.gc.agr.mbb.hostpathogen.web.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ca.gc.agr.mbb.hostpathogen.web.dao.hibernate.GenericDaoHibernate;
import ca.gc.agr.mbb.hostpathogen.web.model.User;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class GenericDaoTest extends BaseDaoTestCase {
    Log log = LogFactory.getLog(GenericDaoTest.class);
    GenericDao<User, Long> genericDao;
    @Autowired
    SessionFactory sessionFactory;

    @Before
    public void setUp() {
        genericDao = new GenericDaoHibernate<>(User.class, sessionFactory);
    }

    @Test
    public void getUser() {
        User user = genericDao.get(-1L);
        assertNotNull(user);
        assertEquals("user", user.getUsername());
    }
}
