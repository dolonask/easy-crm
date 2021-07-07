package kg.easy.easycrm.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.easy.easycrm.models.enums.OperationStatus;
import lombok.Data;

import java.util.Date;

@Data
public class OperationDto {

    private Long id;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date addDate;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date editDate;
    private PinDto pin;
    private double total;
    private double debt;
    private OperationStatus status;
    private double change;

}
