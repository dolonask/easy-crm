package kg.easy.easycrm.mappers;

import kg.easy.easycrm.models.Product;
import kg.easy.easycrm.models.dto.ProductDto;

import java.util.List;

public interface ProductMapper {

    Product toProduct(ProductDto productDto);
    ProductDto toProductDto(Product product);
    List<Product> toProducts(List<ProductDto> productDtos);
    List<ProductDto> toProductDtos(List<Product> users);
}
