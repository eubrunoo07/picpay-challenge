package io.eubrunoo07.picpay.challenge.controller;

import io.eubrunoo07.picpay.challenge.dto.TransferRequestDTO;
import io.eubrunoo07.picpay.challenge.service.TransferService;
import io.eubrunoo07.picpay.challenge.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/picpay/transfers")
@CrossOrigin(originPatterns = "*")
public class TransferController {

    @Autowired
    private TransferService transferService;
    @Autowired
    private UserService userService;

    @PostMapping("/transfer")
    public ResponseEntity<Object> transfer(@RequestBody@Valid TransferRequestDTO data){
        return ResponseEntity.status(HttpStatus.CREATED).body(transferService.createTransfer(data));
    }
}
