package kg.easy.easycrm.services.impl;

import kg.easy.easycrm.dao.OperationDetailRepo;
import kg.easy.easycrm.dao.OperationRepo;
import kg.easy.easycrm.exceptions.ResourceNotFound;
import kg.easy.easycrm.mappers.OperationDetailMapper;
import kg.easy.easycrm.mappers.OperationMapper;
import kg.easy.easycrm.models.Operation;
import kg.easy.easycrm.models.OperationDetail;
import kg.easy.easycrm.models.dto.OperationDetailDto;
import kg.easy.easycrm.models.dto.OperationDto;
import kg.easy.easycrm.models.dto.request.OperationCreate;
import kg.easy.easycrm.models.enums.OperationStatus;
import kg.easy.easycrm.services.OperationService;
import kg.easy.easycrm.services.PinService;
import kg.easy.easycrm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private PinService pinService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OperationMapper operationMapper;
    @Autowired
    private OperationRepo operationRepo;
    @Autowired
    private OperationDetailMapper operationDetailMapper;
    @Autowired
    private OperationDetailRepo operationDetailRepo;


    @Override
    public OperationDto append(OperationCreate oper) {

        if (!pinService.pinExists(oper.getPin())){
            throw new ResourceNotFound("Пин не найден!");
        }

        List<OperationDetailDto> operationDetailDtos = oper.getProducts()
                .stream()
                .map(x->{
                    OperationDetailDto operationDetailDto = new OperationDetailDto();
                    operationDetailDto.setAmount(x.getAmount());
                    operationDetailDto.setProduct(productService.findById(x.getId()));
                    return operationDetailDto;
                })
                .collect(Collectors.toList());

        OperationDto operationDto = new OperationDto();
        operationDto.setPin(pinService.findPin(oper.getPin()));
        operationDto.setTotal(operationDetailDtos.stream()
                .map(x -> x.getProduct().getPrice()).mapToDouble(Double::doubleValue).sum());


        double diff = operationDto.getTotal() - oper.getMoney();

        if (diff > 0){
            // положил больше
            operationDto.setChange(diff);
            operationDto.setStatus(OperationStatus.CLOSED);
        }else if (diff < 0){
            // положил меньше
            operationDto.setDebt(diff);
            operationDto.setStatus(OperationStatus.DEBT);
        }else{
            // равно
            operationDto.setStatus(OperationStatus.CLOSED);
        }

        Operation operation = operationMapper.toOperation(operationDto);
        operation = operationRepo.save(operation);


        Operation finalOperation = operation;
        List<OperationDetail> operationDetails = operationDetailDtos
                .stream()
                .map(x->{
                    OperationDetail operationDetail = operationDetailMapper.toOperationDetail(x);
                    operationDetail.setOperation(finalOperation);
                    return operationDetail;

                })
                .collect(Collectors.toList());


        operationDetailRepo.saveAll(operationDetails);


        return operationDto;
    }

    @Override
    public List<OperationDto> findAll() {
        return null;
    }

    @Override
    public List<OperationDto> findByPin(String pin) {
        return null;
    }

    @Override
    public List<OperationDto> findDebtOperations(String pin) {
        return null;
    }
}
