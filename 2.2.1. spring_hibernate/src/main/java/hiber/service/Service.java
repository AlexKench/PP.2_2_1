package hiber.service;

import hiber.model.User;

import java.util.List;

public interface Service<T> {
    void add(T t);
    List<User> getListUsers();


    List<User> getUser(String carModel, int carSeries);
}
