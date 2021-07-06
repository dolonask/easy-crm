package kg.easy.easycrm.services;

import java.util.List;

public interface BaseService<T> {

    T save( T t);
    List<T> findAll();

}
