package kg.easy.easycrm.mappers;

import kg.easy.easycrm.models.Pin;
import kg.easy.easycrm.models.dto.PinDto;

import java.util.List;

public interface PinMapper {

    Pin toPin(PinDto pinDto);
    List<Pin> toPins(List<PinDto> pinDtos);
    PinDto toPinDto(Pin pin);
    List<PinDto> toPinDtos(List<Pin> pins);
}
