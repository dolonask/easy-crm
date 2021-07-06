package kg.easy.easycrm.services.impl;

import kg.easy.easycrm.dao.CourseRepo;
import kg.easy.easycrm.exceptions.ResourceNotFound;
import kg.easy.easycrm.mappers.CourseMapper;
import kg.easy.easycrm.models.Course;
import kg.easy.easycrm.models.dto.CourseDto;
import kg.easy.easycrm.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public CourseDto save(CourseDto courseDto) {
        Course course = courseMapper.toCourse(courseDto);
        course = courseRepo.save(course);
        return courseMapper.toCourseDto(course);
    }

    @Override
    public List<CourseDto> findAll() {
        return courseMapper.toCourseDtos(
                courseRepo.findAll()
        );
    }

    @Override
    public CourseDto update(CourseDto t) {
        CourseDto courseDto = findById(t.getId());
        Course course = courseMapper.toCourse(t);
        course = courseRepo.save(course);
        return courseMapper.toCourseDto(course);
    }

    @Override
    public CourseDto findById(Long aLong) {
        Course course = courseRepo.findById(aLong).orElseThrow(()->new ResourceNotFound("Курс не найден!"));
        return courseMapper.toCourseDto(course);
    }
}
