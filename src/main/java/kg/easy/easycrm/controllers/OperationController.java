package kg.easy.easycrm.controllers;

import kg.easy.easycrm.models.dto.OperationDto;
import kg.easy.easycrm.models.dto.request.OperationCreate;
import kg.easy.easycrm.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/operation")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @PostMapping("/append")
    public OperationDto save(@RequestBody OperationCreate oper) {
        return operationService.append(oper);
    }

    @GetMapping("/all")
    public List<OperationDto> findAll() {
        return operationService.findAll();
    }

    @GetMapping("/{pin}")
    public List<OperationDto> findByPin(@PathVariable String pin){
        return operationService.findByPin(pin);
    }

    @GetMapping("/debt/{pin}")
    public List<OperationDto> findDebtOperations(@PathVariable String pin){
        return operationService.findDebtOperations(pin);
    }



}
