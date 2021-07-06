package kg.easy.easycrm.services.impl;

import kg.easy.easycrm.dao.UserRepo;
import kg.easy.easycrm.exceptions.ResourceNotFound;
import kg.easy.easycrm.exceptions.WrongCredentials;
import kg.easy.easycrm.mappers.UserMapper;
import kg.easy.easycrm.models.User;
import kg.easy.easycrm.models.dto.AuthResponse;
import kg.easy.easycrm.models.dto.UserDto;
import kg.easy.easycrm.services.PinService;
import kg.easy.easycrm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PinService pinService;
    @Autowired
    private UserMapper userMapper;

    @Override
    public AuthResponse auth(String phone, String pin) {

        User user = userRepo.findByPhone(phone);

        if (user == null){
            throw new ResourceNotFound("Пользователь не найден!");
        }

        if (!user.getPin().equals(pin)){
            throw new WrongCredentials("Неверный пароль!");
        }


        return new AuthResponse(true, "Добро пожаловать!");
    }

    @Override
    public UserDto save(UserDto userDto) {

        String pin = userDto.getPhone().substring(userDto.getPhone().length() - 6);

        while (!pinService.setPin(pin)){
            int numPin = Integer.parseInt(pin);
            numPin++;
            pin = String.valueOf(numPin);
        }

        userDto.setPin(pin);

        User user = userMapper.toUser(userDto);
        user = userRepo.save(user);

        return userMapper.toUserDto(user);
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toUserDtos(
                userRepo.findAll(Sort.by("active")));
    }

    @Override
    public UserDto update(UserDto t) {
        UserDto userDto = findById(t.getId());
        User user = userMapper.toUser(t);
        user = userRepo.save(user);
        return userMapper.toUserDto(user);
    }

    @Override
    public UserDto findById(Long aLong) {
        User user = userRepo.findById(aLong).orElseThrow(()->new ResourceNotFound("Пользователь не найден!"));
        return userMapper.toUserDto(user);
    }
}
