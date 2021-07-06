package kg.easy.easycrm.mappers.impl;

import kg.easy.easycrm.mappers.PinMapper;
import kg.easy.easycrm.models.Pin;
import kg.easy.easycrm.models.dto.PinDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PinMapperImpl implements PinMapper {
    @Override
    public Pin toPin(PinDto pinDto) {
        Pin pin = new Pin();
        pin.setPin(pinDto.getPin());
        return pin;
    }

    @Override
    public List<Pin> toPins(List<PinDto> pinDtos) {

        return pinDtos
                .stream()
                .map(x->toPin(x))
                .collect(Collectors.toList());

    }

    @Override
    public PinDto toPinDto(Pin pin) {

        PinDto pinDto = new PinDto();
        pinDto.setPin(pin.getPin());
        return pinDto;

    }

    @Override
    public List<PinDto> toPinDtos(List<Pin> pins) {

        return pins
                .stream()
                .map(x->toPinDto(x))
                .collect(Collectors.toList());
    }
}
