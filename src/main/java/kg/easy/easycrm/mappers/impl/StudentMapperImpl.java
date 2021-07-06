package kg.easy.easycrm.mappers.impl;

import kg.easy.easycrm.mappers.CourseMapper;
import kg.easy.easycrm.mappers.StudentMapper;
import kg.easy.easycrm.models.Course;
import kg.easy.easycrm.models.Student;
import kg.easy.easycrm.models.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentMapperImpl implements StudentMapper {

    @Autowired
    private CourseMapper courseMapper;
    @Override
    public Student toStudent(StudentDto studentDto) {

        Student student = new Student();
        student.setId(studentDto.getId());
        student.setPhone(studentDto.getPhone());
        student.setActive(studentDto.isActive());
        student.setCourse(courseMapper.toCourse(studentDto.getCourse()));
        return student;
    }

    @Override
    public List<Student> toStudents(List<StudentDto> studentDtos)
    {
        return studentDtos
                .stream()
                .map(x->toStudent(x))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto toStudentDto(Student student) {

        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setPhone(student.getPhone());
        studentDto.setActive(student.isActive());
        studentDto.setCourse(courseMapper.toCourseDto(student.getCourse()));
        return studentDto;
    }

    @Override
    public List<StudentDto> toStudentDtos(List<Student> students) {
        return students
                .stream()
                .map(x->toStudentDto(x))
                .collect(Collectors.toList());
    }
}
