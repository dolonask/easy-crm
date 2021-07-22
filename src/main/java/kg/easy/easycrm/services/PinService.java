package kg.easy.easycrm.services;

import kg.easy.easycrm.models.PinPaymentDto;
import kg.easy.easycrm.models.dto.PinDto;

import java.util.List;

public interface PinService {

    boolean setPin(String pin);
    
    boolean pinExists(String pin);

    PinDto findPin(String pin);

    PinDto setDebt(String pin, double debt);

    PinPaymentDto makePayment(String pin, double payment);
}
