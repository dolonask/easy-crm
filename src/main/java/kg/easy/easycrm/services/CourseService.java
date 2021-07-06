package kg.easy.easycrm.services;

import kg.easy.easycrm.models.dto.CourseDto;

import java.util.List;

public interface CourseService {
    
    CourseDto save(CourseDto courseDto);

    List<CourseDto> findAll();
}
