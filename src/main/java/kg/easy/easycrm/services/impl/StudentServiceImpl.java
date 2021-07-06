package kg.easy.easycrm.services.impl;

import kg.easy.easycrm.dao.StudentRepo;
import kg.easy.easycrm.mappers.StudentMapper;
import kg.easy.easycrm.models.Student;
import kg.easy.easycrm.models.dto.StudentDto;
import kg.easy.easycrm.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student student = studentMapper.toStudent(studentDto);
        student = studentRepo.save(student);
        return studentMapper.toStudentDto(student);
    }

    @Override
    public List<StudentDto> findAll() {
        return studentMapper
                .toStudentDtos(studentRepo.findAll());
    }
}
