package kg.easy.easycrm.controllers;

import kg.easy.easycrm.models.dto.StudentDto;
import kg.easy.easycrm.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@CrossOrigin
public class StudentController implements BaseController<StudentDto, Long> {

    @Autowired
    private StudentService studentService;


    @Override
    public StudentDto save(StudentDto studentDto) {
        return studentService.save(studentDto);
    }

    @Override
    public List<StudentDto> findAll() {
        return studentService.findAll();
    }

    @Override
    public StudentDto update(StudentDto studentDto) {
        return studentService.update(studentDto);
    }

    @Override
    public StudentDto findById(Long id) {
        return studentService.findById(id);
    }
}
