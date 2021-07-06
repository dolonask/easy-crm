package kg.easy.easycrm.controllers;

import kg.easy.easycrm.models.dto.CourseDto;
import kg.easy.easycrm.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/course")
public class CourseController implements BaseController<CourseDto, Long>{

    @Autowired
    private CourseService courseService;

    @Override
    public CourseDto save(CourseDto courseDto) {
        return courseService.save(courseDto);
    }

    @Override
    public List<CourseDto> findAll() {
        return courseService.findAll();
    }

    @Override
    public CourseDto update(CourseDto courseDto) {
        return courseService.update(courseDto);
    }

    @Override
    public CourseDto findById(Long id) {
        return courseService.findById(id);
    }
}
