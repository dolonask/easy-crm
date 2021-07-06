package kg.easy.easycrm.models.report;

import kg.easy.easycrm.models.dto.PinDto;
import lombok.Data;

import java.util.List;

@Data
public class PinInfo {
    private PinDto pinDto;
    private List<OperationReport> operationReports;

}

