package kg.easy.easycrm.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private String pin;
    private boolean active;

}
