package io.eubrunoo07.picpay.challenge.service.impl;

import io.eubrunoo07.picpay.challenge.dto.UserRequestDTO;
import io.eubrunoo07.picpay.challenge.dto.UserResponseDTO;
import io.eubrunoo07.picpay.challenge.enums.UserType;
import io.eubrunoo07.picpay.challenge.exception.exceptions.CpfOrCnpjAlreadyExistsException;
import io.eubrunoo07.picpay.challenge.exception.exceptions.DocumentIsInvalidException;
import io.eubrunoo07.picpay.challenge.exception.exceptions.EmailALreadyExistsException;
import io.eubrunoo07.picpay.challenge.model.User;
import io.eubrunoo07.picpay.challenge.repository.UserRepository;
import io.eubrunoo07.picpay.challenge.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDTO createUser(UserRequestDTO data) {
        User user = null;
        boolean userVerified = verifyUserRequestData(data);
        if(userVerified){
            user = new User();
            BeanUtils.copyProperties(data, user);
            user.setUserType(UserType.valueOf(data.getUserType()));
        }
        assert user != null;
        userRepository.save(user);

        return UserResponseDTO.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .document(user.getDocument())
                .email(user.getEmail())
                .userType(String.valueOf(user.getUserType()))
                .build();
    }

    public boolean verifyUserRequestData(UserRequestDTO data){

        String documentRegex = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})";

        if(!data.getDocument().matches(documentRegex)){
            throw new DocumentIsInvalidException("Document is invalid");
        }

        boolean existsByEmail = userRepository
                .findByEmail(data.getEmail())
                .isPresent();

        boolean existsByDocument = userRepository
                .findByDocument(data.getDocument())
                .isPresent();

        if(existsByEmail){
            throw new EmailALreadyExistsException("Email already exists");
        }
        else if(existsByDocument){
            throw new CpfOrCnpjAlreadyExistsException("Cpf or Cnpj already exists");
        }
        else{
            return true;
        }
    }
}
