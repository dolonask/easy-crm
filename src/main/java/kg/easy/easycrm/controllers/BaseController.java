package kg.easy.easycrm.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface BaseController<T> {

    T save( T t);
    List<T> findAll();
}
