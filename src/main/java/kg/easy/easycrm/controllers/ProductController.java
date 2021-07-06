package kg.easy.easycrm.controllers;

import kg.easy.easycrm.models.dto.ProductDto;
import kg.easy.easycrm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class ProductController implements BaseController<ProductDto> {


    @Autowired
    private ProductService productService;

    @Override
    @PostMapping("/save")
    public ProductDto save(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }

    @Override
    public List<ProductDto> findAll() {
        return productService.findAll();
    }
}
