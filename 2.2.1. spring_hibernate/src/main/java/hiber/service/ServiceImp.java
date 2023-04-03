package hiber.service;

import hiber.dao.Dao;
import hiber.model.User;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class ServiceImp<T> implements Service<T> {

    @Autowired
    private Dao dao;


    @Override
    public void add(T t) {
        dao.add(t);
    }


    @Override
    public List<User> getListUsers() {
        return dao.getListUsers();
    }



    @Override
    public List<User> getUser(String carModel, int carSeries) {
        Query query = dao.getSessionFactory().createQuery("from User u where u.car.model = :model and u.car.series = :series");
        query.setParameter("model", carModel).setParameter("series", carSeries);
        return query.list();
    }
}

