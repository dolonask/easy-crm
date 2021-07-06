package kg.easy.easycrm.models.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class ProductDto {

    private Long id;

    private String name;
    private String picture;
    private double price;
    private boolean active;


}
