package kg.easy.easycrm.services;

import kg.easy.easycrm.models.dto.ProductDto;

import java.util.List;

public interface ProductService extends BaseService<ProductDto, Long> {

    List<ProductDto> findAllByActive(boolean status);
}
