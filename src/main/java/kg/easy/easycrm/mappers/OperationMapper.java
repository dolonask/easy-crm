package kg.easy.easycrm.mappers;

import kg.easy.easycrm.models.Operation;
import kg.easy.easycrm.models.dto.OperationDto;

import java.util.List;

public interface OperationMapper {

    Operation toOperation(OperationDto operationDto);
    List<Operation> toOperations(List<OperationDto> operationDtos);
    OperationDto toOperationDto(Operation operation);
    List<OperationDto> toOperationDtos(List<Operation> operations);

}
