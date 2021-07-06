package kg.easy.easycrm.controllers;

import kg.easy.easycrm.models.User;
import kg.easy.easycrm.models.dto.AuthResponse;
import kg.easy.easycrm.models.dto.UserDto;
import kg.easy.easycrm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/auth")
    public AuthResponse auth(@RequestParam String phone, @RequestParam String pin ){
        return userService.auth(phone, pin);
    }

    @PostMapping("/save")
    public UserDto save(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }

    @GetMapping("/all")
    public List<UserDto> findAll(){
        return userService.findAll();
    }


}
