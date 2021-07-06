package kg.easy.easycrm.services.impl;

import kg.easy.easycrm.dao.PinRepo;
import kg.easy.easycrm.exceptions.ResourceNotFound;
import kg.easy.easycrm.mappers.PinMapper;
import kg.easy.easycrm.models.Pin;
import kg.easy.easycrm.models.PinPaymentDto;
import kg.easy.easycrm.models.dto.PinDto;
import kg.easy.easycrm.services.OperationService;
import kg.easy.easycrm.services.PinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PinServiceImpl implements PinService {

    @Autowired
    private PinRepo pinRepo;
    @Autowired
    private PinMapper pinMapper;
    @Autowired
    private OperationService operationService;

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
        PinDto pinDto = pinMapper.toPinDto(currPin);
        return pinDto;
    }

    @Override
    public void setDebt(String pin, double debt) {
        if (debt > 0) {
            PinDto pinDto = findPin(pin);
            pinDto.setDebt(pinDto.getDebt() + debt);
            pinRepo.save(pinMapper.toPin(pinDto));
        }
    }

    @Override
    public PinDto makePayment(String pin, double payment) {

        PinDto pinDto = findPin(pin);

        PinPaymentDto pinPaymentDto = new PinPaymentDto();
        pinPaymentDto.setPayment(payment);

        if (pinDto.getDebt() < payment){
            pinPaymentDto.setDebt(pinDto.getDebt() - payment);
        }else{
            pinPaymentDto.setChange(payment - pinDto.getDebt());
        }

        pinDto.setDebt(pinPaymentDto.getDebt());
        Pin pin1 = pinMapper.toPin(pinDto);
        pinRepo.save(pin1);

        operationService.setPaymentOperation(pinDto,pinPaymentDto.getPayment() - pinPaymentDto.getChange());
        return pinDto;
    }
}
