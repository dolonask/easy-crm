package kg.easy.easycrm.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface BaseController<S,T> {

    @PostMapping("/save")
    S save(@RequestBody S s);

    @GetMapping("/all")
    List<S> findAll();

    @PutMapping("/update")
    S update (@RequestBody S s);

    @GetMapping("/{id}")
    S findById(@PathVariable T id);

}
