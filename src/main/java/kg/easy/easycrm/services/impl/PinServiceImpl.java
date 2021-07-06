package kg.easy.easycrm.services.impl;

import kg.easy.easycrm.dao.PinRepo;
import kg.easy.easycrm.exceptions.ResourceNotFound;
import kg.easy.easycrm.models.Pin;
import kg.easy.easycrm.models.dto.PinDto;
import kg.easy.easycrm.services.PinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PinServiceImpl implements PinService {

    @Autowired
    private PinRepo pinRepo;

    @Override
    public boolean setPin(String pin) {

        if (pinRepo.existsById(pin)) {
            return false;
        }

        Pin newPin = new Pin();
        newPin.setPin(pin);
        pinRepo.save(newPin);

        return true;
    }

    @Override
    public boolean pinExists(String pin) {
        return pinRepo.existsById(pin);
    }

    @Override
    public PinDto findPin(String pin) {
        Pin currPin = pinRepo.findById(pin).orElseThrow(()->new ResourceNotFound("пин не найден!"));
        PinDto pinDto = new PinDto();
        pinDto.setPin(currPin.getPin());
        return pinDto;
    }
}
