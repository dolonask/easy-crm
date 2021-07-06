package kg.easy.easycrm.mappers.impl;

import kg.easy.easycrm.mappers.CourseMapper;
import kg.easy.easycrm.models.Course;
import kg.easy.easycrm.models.dto.CourseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseMapperImpl implements CourseMapper {
    @Override
    public Course toCourse(CourseDto courseDto) {
        Course course = new Course();
        course.setId(courseDto.getId());
        course.setAssistant(courseDto.getAssistant());
        course.setClassroom(courseDto.getClassroom());
        course.setEndDate(courseDto.getEndDate());
        course.setMentor(courseDto.getMentor());
        course.setName(courseDto.getName());
        course.setPrice(courseDto.getPrice());
        course.setStartDate(courseDto.getStartDate());
        course.setTime(courseDto.getTime());
        course.setActive(courseDto.isActive());
        return course;
    }

    @Override
    public CourseDto toCourseDto(Course course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setAssistant(course.getAssistant());
        courseDto.setClassroom(course.getClassroom());
        courseDto.setEndDate(course.getEndDate());
        courseDto.setMentor(course.getMentor());
        courseDto.setName(course.getName());
        courseDto.setPrice(course.getPrice());
        courseDto.setStartDate(course.getStartDate());
        courseDto.setTime(course.getTime());
        courseDto.setActive(course.isActive());
        return courseDto;
    }

    @Override
    public List<Course> toCourses(List<CourseDto> courseDtos) {

        return courseDtos
                .stream()
                .map(x->toCourse(x))
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> toCourseDtos(List<Course> courses) {

        return courses
                .stream()
                .map(x->toCourseDto(x))
                .collect(Collectors.toList());
    }
}
