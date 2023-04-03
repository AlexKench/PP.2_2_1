package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;

import java.util.List;

public interface Dao<T> {
   void add(T t);
   List<User> getListUsers();

   Session getSessionFactory();
}
