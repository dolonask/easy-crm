package kg.easy.easycrm.services.impl;

import kg.easy.easycrm.dao.ProductRepo;
import kg.easy.easycrm.exceptions.ResourceNotFound;
import kg.easy.easycrm.mappers.ProductMapper;
import kg.easy.easycrm.models.Product;
import kg.easy.easycrm.models.dto.ProductDto;
import kg.easy.easycrm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
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

    @Override
    public List<ProductDto> findAllByActive(boolean status) {
        return productMapper.toProductDtos(productRepo.findAllByActive(status));
    }
    @Override
    public ProductDto saveProductDb(MultipartFile picture, String name, double price) {
        ProductDto productDto = new ProductDto();
        String fileName = StringUtils.cleanPath(picture.getOriginalFilename());
        if(fileName.contains("..")){
            System.out.println("not a valid file");
        }
        productDto.setName(name);
        try {
            productDto.setPicture(Base64.getEncoder().encodeToString(picture.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        productDto.setActive(true);
        productDto.setPrice(price);
        Product product = productMapper.toProduct(productDto);
        product = productRepo.save(product);
        return productMapper.toProductDto(product);
    }
}
