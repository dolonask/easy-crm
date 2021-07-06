package kg.easy.easycrm.controllers;

import kg.easy.easycrm.models.dto.CourseDto;
import kg.easy.easycrm.models.dto.StudentDto;
import kg.easy.easycrm.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public StudentDto save(@RequestBody StudentDto studentDto){
        return studentService.save(studentDto);
    }

    @GetMapping("/all")
    public List<StudentDto> findAll(){

        return studentService.findAll();
    }
}
