package kg.easy.easycrm.mappers;

import kg.easy.easycrm.models.User;
import kg.easy.easycrm.models.dto.UserDto;

import java.util.List;

public interface UserMapper {

    User toUser(UserDto userDto);
    UserDto toUserDto(User user);
    List<User> toUsers(List<UserDto> userDtos);
    List<UserDto> toUserDtos(List<User> users);
}
