package kg.easy.easycrm.services;

import java.util.List;

public interface BaseService<S,T> {

    S save( S body);
    List<S> findAll();
    S update (S body);
    S findById(T id);

}
