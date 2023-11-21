package io.github.skippertokozak.lab04.client.dao;


import java.util.List;
import java.util.Optional;

public interface Dao<T> {


    List<T> getAll();

    void update(T t);
    //void loginConfirmed(T user);

    void delete(T t);

    Optional<T> get(Integer id);
}
