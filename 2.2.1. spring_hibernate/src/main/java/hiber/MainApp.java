package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.add(new User("Sasha", "Maksimov", "Sasha@gmail.com", new Car("lada", 99)));
        userService.add(new User("Petya", "Saev", "Petya@gmail.com", new Car("BMW", 777)));
        userService.add(new User("Lesha", "Izvekov", "Lesha@gmail.com", new Car("oka", 89)));
        userService.add(new User("Olya", "Markina", "Olya@gmail.com", new Car("KIA", 15)));
        List<User> userList = userService.listUsers();
        userList.forEach(System.out::println);

        List<User> list = userService.getUser(new Car("lada", 99));
        list.forEach(System.out::println);










        context.close();
    }
}
