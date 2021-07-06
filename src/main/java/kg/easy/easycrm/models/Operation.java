package kg.easy.easycrm.models;

import kg.easy.easycrm.models.enums.OperationStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "operations")
public class Operation {

    @Id
    @GeneratedValue
    private Long id;
    @CreationTimestamp
    private Date addDate;
    @UpdateTimestamp
    private Date editDate;

    @ManyToOne
    @JoinColumn(name = "pin")
    private Pin pin;

    private double total;
    private double debt;
    @Enumerated(EnumType.STRING)
    private OperationStatus status;
    private double change;


}
