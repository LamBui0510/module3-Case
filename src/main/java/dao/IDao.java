package dao;

import model.Customer;

import java.util.List;

public interface IDao<T> {
    List<T> getList ();
    void insert(T t);
    void update(int id,T t);
    void delete(int id);
}
