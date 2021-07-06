package kg.easy.easycrm.services;

import kg.easy.easycrm.models.dto.AuthResponse;
import kg.easy.easycrm.models.dto.UserDto;

import java.util.List;

public interface UserService {


    AuthResponse auth(String phone, String pin);

    UserDto save(UserDto userDto);

    List<UserDto> findAll();
}
