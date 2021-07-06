package kg.easy.easycrm.services;

import kg.easy.easycrm.models.dto.OperationDto;
import kg.easy.easycrm.models.dto.PinDto;
import kg.easy.easycrm.models.dto.request.OperationCreate;
import kg.easy.easycrm.models.report.PinInfo;

import java.util.List;

public interface OperationService {

    OperationDto append(OperationCreate oper);

    List<OperationDto> findAll();


    List<OperationDto> findDebtOperations(String pin);

    void setPaymentOperation(PinDto pinDto, double payment);

    PinInfo findByPin(String pin, Integer pageNo, Integer pageSize);
}
