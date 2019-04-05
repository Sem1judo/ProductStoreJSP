package dao;

import java.util.List;

public interface GenerickDao<T> {

    T create(T obj);

    T read(int id);

    void delete(int id);

    void update(T obj);

    List<T> getAll();

}
