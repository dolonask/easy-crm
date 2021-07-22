package kg.easy.easycrm.controllers;

import kg.easy.easycrm.models.dto.ProductDto;
import kg.easy.easycrm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin
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

    @GetMapping("/{status}")
    public List<ProductDto> findAllByActive(@PathVariable boolean status) {
        return productService.findAllByActive(status);
    }

    @Override
    public ProductDto update(ProductDto t) {
        return productService.update(t);
    }

    @Override
    public ProductDto findById(Long id) {
        return productService.findById(id);
    }


}
