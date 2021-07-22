package kg.easy.easycrm.controllers;

import kg.easy.easycrm.exceptions.ResourceNotFound;
import kg.easy.easycrm.exceptions.WrongCredentials;
import kg.easy.easycrm.models.dto.AuthResponse;
import kg.easy.easycrm.models.dto.UserDto;
import kg.easy.easycrm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController implements BaseController<UserDto, Long>{


    @Autowired
    private UserService userService;

    @PostMapping("/auth")
    public AuthResponse auth(@RequestParam String phone, @RequestParam String pin ){
        try {
            return userService.auth(phone, pin);
        }catch (ResourceNotFound ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Пользователь не найден!");
        }catch (WrongCredentials ex){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Неверный пин-код!");
        }
    }

    @PostMapping("/save")
    public UserDto save(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }

    @GetMapping("/all")
    public List<UserDto> findAll(){
        return userService.findAll();
    }

    @Override
    public UserDto update(UserDto t) {
        return userService.update(t);
    }

    @Override
    public UserDto findById(Long id) {
        return userService.findById(id);
    }


}
