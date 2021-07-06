package kg.easy.easycrm.mappers.impl;

import kg.easy.easycrm.mappers.UserMapper;
import kg.easy.easycrm.models.User;
import kg.easy.easycrm.models.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapperImpl implements UserMapper {
    @Override
    public User toUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setPhone(userDto.getPhone());
        user.setPin(userDto.getPin());
        user.setActive(userDto.isActive());
        return user;
    }

    @Override
    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setPhone(user.getPhone());
        userDto.setPin(user.getPin());
        userDto.setActive(user.isActive());
        return userDto;
    }

    @Override
    public List<User> toUsers(List<UserDto> userDtos) {

        return userDtos.stream()
                .map(x->toUser(x))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> toUserDtos(List<User> users) {
        return users.stream()
                .map(x->toUserDto(x))
                .collect(Collectors.toList());
    }
}
