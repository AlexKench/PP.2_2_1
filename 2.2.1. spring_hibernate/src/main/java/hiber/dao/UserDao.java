package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();

   Session getSessionFactory();
}
