package kg.easy.easycrm.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import kg.easy.easycrm.models.dto.CourseDto;
import kg.easy.easycrm.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/course")
@CrossOrigin
public class CourseController implements BaseController<CourseDto, Long>{

    @Autowired
    private CourseService courseService;

    @Override
    @ApiOperation(value = "Создание курса")
    public CourseDto save(CourseDto courseDto) {
        return courseService.save(courseDto);
    }

    @Override
    @ApiOperation(value = "Получение всех курсов")
    public List<CourseDto> findAll() {
        return courseService.findAll();
    }

    @Override
    @ApiOperation(value = "Редактирование курса")
    public CourseDto update(CourseDto courseDto) {
        return courseService.update(courseDto);
    }

    @Override
    @ApiOperation(value = "Найти информацию о курсе по ID")
    public CourseDto findById(Long id) {
        return courseService.findById(id);
    }
}
