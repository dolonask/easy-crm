package kg.easy.easycrm.mappers;

import kg.easy.easycrm.models.OperationDetail;
import kg.easy.easycrm.models.dto.OperationDetailDto;

import java.util.List;

public interface OperationDetailMapper {

    OperationDetail toOperationDetail(OperationDetailDto operationDetailDto);
    List<OperationDetail> toOperationDetails(List<OperationDetailDto> operationDetailDtos);
    OperationDetailDto toOperationDetailDto(OperationDetail operationDetail);
    List<OperationDetailDto> toOperationDetailDtos(List<OperationDetail> operationDetails);

}
