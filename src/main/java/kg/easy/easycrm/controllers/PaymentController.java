package kg.easy.easycrm.controllers;

import kg.easy.easycrm.models.PinPaymentDto;
import kg.easy.easycrm.models.dto.PinDto;
import kg.easy.easycrm.services.PinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pin")
@CrossOrigin
public class PaymentController {

    @Autowired
    private PinService pinService;

    @PutMapping("/make/payment")
    public PinPaymentDto makePayment(@RequestParam String pin, @RequestParam double payment){
        return pinService.makePayment(pin, payment);
    }

    @GetMapping("/{pin}")
    public PinDto getInfo(@PathVariable String pin){
        return pinService.findPin(pin);
    }



}
