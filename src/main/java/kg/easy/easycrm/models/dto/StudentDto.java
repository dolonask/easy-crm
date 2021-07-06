package kg.easy.easycrm.models.dto;

import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String phone;
    private CourseDto course;
    private String pin;
    private boolean active;
}
