package kg.easy.easycrm.models.dto;

import lombok.Data;

@Data
public class OperationDetailDto {
    private Long id;
    private ProductDto product;
    private OperationDto operation;
    private int amount;


}
