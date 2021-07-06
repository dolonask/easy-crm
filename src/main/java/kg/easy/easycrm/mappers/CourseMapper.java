package kg.easy.easycrm.mappers;

import kg.easy.easycrm.models.Course;
import kg.easy.easycrm.models.dto.CourseDto;

import java.util.List;

public interface CourseMapper {

    Course toCourse(CourseDto courseDto);
    CourseDto toCourseDto(Course course);

    List<Course> toCourses(List<CourseDto> courseDtos);
    List<CourseDto> toCourseDtos(List<Course> courses);


}
