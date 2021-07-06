package kg.easy.easycrm.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "pins")
public class Pin {

    @Id
    private String pin;
}
