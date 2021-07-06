package kg.easy.easycrm.mappers.impl;

import kg.easy.easycrm.mappers.OperationMapper;
import kg.easy.easycrm.mappers.PinMapper;
import kg.easy.easycrm.models.Operation;
import kg.easy.easycrm.models.dto.OperationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperationMapperImpl implements OperationMapper {

    @Autowired
    private PinMapper pinMapper;


    @Override
    public Operation toOperation(OperationDto operationDto) {

        Operation operation = new Operation();
        operation.setId(operationDto.getId());
        operation.setPin(pinMapper.toPin(operationDto.getPin()));
        operation.setStatus(operationDto.getStatus());
        operation.setDebt(operationDto.getDebt());
        operation.setChange(operationDto.getChange());
        operation.setTotal(operationDto.getTotal());

        return operation;
    }

    @Override
    public List<Operation> toOperations(List<OperationDto> operationDtos) {

        return operationDtos
                .stream()
                .map(x->toOperation(x))
                .collect(Collectors.toList());
    }

    @Override
    public OperationDto toOperationDto(Operation operation) {
        OperationDto operationDto = new OperationDto();
        operationDto.setId(operation.getId());
        operationDto.setPin(pinMapper.toPinDto(operation.getPin()));
        operationDto.setStatus(operation.getStatus());
        operationDto.setDebt(operation.getDebt());
        operationDto.setChange(operation.getChange());
        operationDto.setTotal(operation.getTotal());
        operationDto.setAddDate(operation.getAddDate());
        operationDto.setEditDate(operation.getEditDate());
        return operationDto;
    }

    @Override
    public List<OperationDto> toOperationDtos(List<Operation> operations) {
        return operations
                .stream()
                .map(x->toOperationDto(x))
                .collect(Collectors.toList());
    }
}
