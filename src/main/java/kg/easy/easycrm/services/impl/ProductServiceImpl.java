package kg.easy.easycrm.services.impl;

import kg.easy.easycrm.dao.ProductRepo;
import kg.easy.easycrm.exceptions.ResourceNotFound;
import kg.easy.easycrm.mappers.ProductMapper;
import kg.easy.easycrm.models.Product;
import kg.easy.easycrm.models.dto.ProductDto;
import kg.easy.easycrm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = productMapper.toProduct(productDto);
        product = productRepo.save(product);
        return productMapper.toProductDto(product);
    }

    @Override
    public List<ProductDto> findAll() {
        return productMapper.toProductDtos(productRepo.findAll());
    }

    @Override
    public ProductDto update(ProductDto t) {
        ProductDto productDto = findById(t.getId());
        Product product = productMapper.toProduct(t);
        product = productRepo.save(product);
        return productMapper.toProductDto(product);
    }

    @Override
    public ProductDto findById(Long id) {
        return productMapper.toProductDto(
                productRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Товар не найден!"))
        );
    }
}
