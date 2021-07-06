package kg.easy.easycrm.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CourseDto {

    private Long id;
    private String name;
    private String mentor;
    private String assistant;
    private String classroom;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date startDate;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date endDate;
    private double price;
    private String time;
    private boolean active;

}
