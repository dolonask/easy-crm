package kg.easy.easycrm.mappers;

import kg.easy.easycrm.models.Student;
import kg.easy.easycrm.models.dto.StudentDto;

import java.util.List;

public interface StudentMapper {

    Student toStudent(StudentDto studentDto);
    List<Student> toStudents(List<StudentDto> studentDtos);
    StudentDto toStudentDto(Student student);
    List<StudentDto> toStudentDtos(List<Student> students);


}
