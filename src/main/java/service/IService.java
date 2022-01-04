package service;

import java.util.List;

public interface IService<T> {
    List<T> getList();
    void save (T t);
    void update(int id,T t);
    void delete(int id);
 }
