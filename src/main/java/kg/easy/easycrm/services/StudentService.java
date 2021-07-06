package kg.easy.easycrm.services;

import kg.easy.easycrm.models.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto save(StudentDto studentDto);

    List<StudentDto> findAll();
}
