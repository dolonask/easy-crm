package kg.easy.easycrm.services;

import kg.easy.easycrm.models.dto.PinDto;

public interface PinService {

    boolean setPin(String pin);
    
    boolean pinExists(String pin);

    PinDto findPin(String pin);
}
