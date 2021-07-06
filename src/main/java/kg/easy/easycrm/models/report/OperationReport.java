package kg.easy.easycrm.models.report;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.easy.easycrm.models.enums.OperationStatus;
import lombok.Data;

import java.util.Date;

@Data
public class OperationReport {

    private Long id;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date addDate;
    private OperationStatus status;
    private double debt;

}
