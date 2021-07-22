package kg.easy.easycrm.controllers;

import kg.easy.easycrm.models.dto.OperationDto;
import kg.easy.easycrm.models.dto.request.OperationCreate;
import kg.easy.easycrm.models.report.PinInfo;
import kg.easy.easycrm.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/operation")
@CrossOrigin
public class OperationController {

    @Autowired
    private OperationService operationService;

    @PostMapping("/append")
    public OperationDto save(@RequestBody OperationCreate oper) {
        return operationService.append(oper);
    }

//    @GetMapping("/all")
//    public List<OperationDto> findAll() {
//        return operationService.findAll();
//    }

    @GetMapping("/{pin}")
    public PinInfo findByPin(@PathVariable String pin,
                                   @RequestParam(defaultValue = "0") Integer pageNo,
                                   @RequestParam(defaultValue = "10") Integer pageSize){
        return operationService.findByPin(pin, pageNo, pageSize);
    }

//    @GetMapping("/debt/{pin}")
//    public List<OperationDto> findDebtOperations(@PathVariable String pin){
//        return operationService.findDebtOperations(pin);
//    }







}
