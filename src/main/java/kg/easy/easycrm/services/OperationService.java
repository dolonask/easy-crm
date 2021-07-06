package kg.easy.easycrm.services;

import kg.easy.easycrm.models.dto.OperationDto;
import kg.easy.easycrm.models.dto.request.OperationCreate;

import java.util.List;

public interface OperationService {

    OperationDto append(OperationCreate oper);

    List<OperationDto> findAll();

    List<OperationDto> findByPin(String pin);

    List<OperationDto> findDebtOperations(String pin);
}
