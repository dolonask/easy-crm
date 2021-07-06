package kg.easy.easycrm.mappers.impl;

import kg.easy.easycrm.mappers.OperationDetailMapper;
import kg.easy.easycrm.mappers.OperationMapper;
import kg.easy.easycrm.mappers.ProductMapper;
import kg.easy.easycrm.models.OperationDetail;
import kg.easy.easycrm.models.dto.OperationDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperationDetailMapperImpl implements OperationDetailMapper {

    @Autowired
    private OperationMapper operationMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public OperationDetail toOperationDetail(OperationDetailDto operationDetailDto) {
        OperationDetail operationDetail = new OperationDetail();
        operationDetail.setId(operationDetailDto.getId());
        operationDetail.setAmount(operationDetailDto.getAmount());
        operationDetail.setOperation(operationMapper.toOperation(operationDetailDto.getOperation()));
        operationDetail.setProduct(productMapper.toProduct(operationDetailDto.getProduct()));
        return operationDetail;
    }

    @Override
    public List<OperationDetail> toOperationDetails(List<OperationDetailDto> operationDetailDtos) {

        return operationDetailDtos
                .stream()
                .map(x->toOperationDetail(x))
                .collect(Collectors.toList());
    }

    @Override
    public OperationDetailDto toOperationDetailDto(OperationDetail operationDetail) {
        OperationDetailDto operationDetailDto = new OperationDetailDto();
        operationDetailDto.setId(operationDetail.getId());
        operationDetailDto.setAmount(operationDetail.getAmount());
        operationDetailDto.setOperation(operationMapper.toOperationDto(operationDetail.getOperation()));
        operationDetailDto.setProduct(productMapper.toProductDto(operationDetail.getProduct()));
        return operationDetailDto;
    }

    @Override
    public List<OperationDetailDto> toOperationDetailDtos(List<OperationDetail> operationDetails) {
        return operationDetails
                .stream()
                .map(x->toOperationDetailDto(x))
                .collect(Collectors.toList());
    }
}
