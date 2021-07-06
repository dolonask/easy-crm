package kg.easy.easycrm.controllers;

import kg.easy.easycrm.models.dto.OperationDto;
import kg.easy.easycrm.models.dto.request.OperationCreate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/v1/operation")
public class OperationController {

    @PostMapping("/append")
    public OperationDto save(@RequestBody OperationCreate oper) {
        return null;
    }

    public List<OperationDto> findAll() {
        return null;
    }
}
