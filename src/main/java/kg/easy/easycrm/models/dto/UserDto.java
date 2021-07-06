package kg.easy.easycrm.models.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String phone;
    private boolean active;
    private String pin;
}
