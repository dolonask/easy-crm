package kg.easy.easycrm.models.dto.request;

import lombok.Data;

import java.util.List;


@Data
public class OperationCreate {
    private String pin;
    private List<ProductCreate> products;
    private double money;
}
