package kg.easy.easycrm.controllers;

import kg.easy.easycrm.models.dto.PinDto;
import kg.easy.easycrm.services.PinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pin")
public class PaymentController {

    @Autowired
    private PinService pinService;

    @PutMapping("/make/payment")
    public PinDto makePayment(@RequestParam String pin, @RequestParam double payment){
        return pinService.makePayment(pin, payment);
    }

    @GetMapping("/{pin}")
    public PinDto getInfo(@PathVariable String pin){
        return pinService.findPin(pin);
    }



}
