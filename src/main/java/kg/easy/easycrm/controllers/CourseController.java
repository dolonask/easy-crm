package kg.easy.easycrm.controllers;

import kg.easy.easycrm.models.dto.CourseDto;
import kg.easy.easycrm.services.CourseService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/save")
    public CourseDto save(@RequestBody CourseDto courseDto){
        return courseService.save(courseDto);
    }
    @GetMapping("/all")
    public List<CourseDto> findAll(){

        return courseService.findAll();
    }


}
