package kg.easy.easycrm.services;

import kg.easy.easycrm.models.Operation;
import kg.easy.easycrm.models.dto.OperationDto;
import kg.easy.easycrm.models.dto.request.OperationCreate;

public interface OperationService {

    OperationDto append(OperationCreate oper);
}
