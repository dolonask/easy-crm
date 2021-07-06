package kg.easy.easycrm.controllers;

import kg.easy.easycrm.models.dto.ProductDto;
import kg.easy.easycrm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/product")
public class ProductController implements BaseController<ProductDto, Long> {


    @Autowired
    private ProductService productService;

    @Override
    public ProductDto save(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }

    @Override
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @Override
    public ProductDto update(ProductDto t) {
        System.out.println(t);
        return null;
    }

    @Override
    public ProductDto findById(Long id) {
        System.out.println(id);
        return null;
    }


}
