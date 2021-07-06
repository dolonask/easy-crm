package kg.easy.easycrm.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    private String mentor;
    private String assistant;
    private String classroom;
    private Date startDate;
    private Date endDate;
    private double price;
    private String time;
    private boolean active;

}
