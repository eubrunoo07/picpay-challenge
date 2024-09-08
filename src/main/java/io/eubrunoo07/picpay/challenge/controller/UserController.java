package io.eubrunoo07.picpay.challenge.controller;

import io.eubrunoo07.picpay.challenge.dto.UserRequestDTO;
import io.eubrunoo07.picpay.challenge.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/picpay/users")
@CrossOrigin(originPatterns = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody@Valid UserRequestDTO data){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(data));
    }

}
