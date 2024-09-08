package io.eubrunoo07.picpay.challenge.controller;

import io.eubrunoo07.picpay.challenge.dto.UserRequestDTO;
import io.eubrunoo07.picpay.challenge.dto.UserResponseDTO;
import io.eubrunoo07.picpay.challenge.model.User;
import io.eubrunoo07.picpay.challenge.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/")
    public ResponseEntity<List<UserResponseDTO>> users(){
        List<User> users = userService.findAll();
        List<UserResponseDTO> response = new ArrayList<>();
        for (User user : users) {
            response.add(UserResponseDTO.builder()
                    .id(user.getId())
                    .fullName(user.getFullName())
                    .email(user.getEmail())
                    .document(user.getDocument())
                    .userType(String.valueOf(user.getUserType()))
                    .balance(user.getBalance())
                    .build());
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //Soon.. (findById, delete and update

}
