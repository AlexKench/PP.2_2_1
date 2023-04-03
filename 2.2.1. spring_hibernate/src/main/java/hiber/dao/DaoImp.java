package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DaoImp<T> implements Dao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(T t) {
        sessionFactory.getCurrentSession().save(t);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getListUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public Session getSessionFactory() {
        return sessionFactory.getCurrentSession();
    }
}
