package kg.easy.easycrm.services;

import kg.easy.easycrm.models.dto.ProductDto;

public interface ProductService extends BaseService<ProductDto> {

    ProductDto findById(Long id);

}
