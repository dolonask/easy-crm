package kg.easy.easycrm.mappers.impl;

import kg.easy.easycrm.mappers.ProductMapper;
import kg.easy.easycrm.models.Product;
import kg.easy.easycrm.models.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMapperImpl implements ProductMapper {
    @Override
    public Product toProduct(ProductDto productDto) {

        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setActive(productDto.isActive());
        product.setPrice(productDto.getPrice());
        product.setPicture(productDto.getPicture());
        return product;
    }

    @Override
    public ProductDto toProductDto(Product product) {

        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setActive(product.isActive());
        productDto.setPrice(product.getPrice());
        productDto.setPicture(product.getPicture());
        return productDto;
    }

    @Override
    public List<Product> toProducts(List<ProductDto> productDtos) {
        return productDtos
                .stream()
                .map(x->toProduct(x))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> toProductDtos(List<Product> users) {

        return users
                .stream()
                .map(x->toProductDto(x))
                .collect(Collectors.toList());
    }
}
