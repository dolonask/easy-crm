package kg.easy.easycrm.models.dto;

import kg.easy.easycrm.models.enums.OperationStatus;
import lombok.Data;

import java.util.Date;

@Data
public class OperationDto {

    private Long id;
    private Date addDate;
    private Date editDate;
    private PinDto pin;
    private double total;
    private double debt;
    private OperationStatus status;
    private double change;

}
