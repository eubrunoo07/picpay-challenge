package io.eubrunoo07.picpay.challenge.service;

import io.eubrunoo07.picpay.challenge.dto.UserRequestDTO;
import io.eubrunoo07.picpay.challenge.dto.UserResponseDTO;
import io.eubrunoo07.picpay.challenge.model.User;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO data);
}
