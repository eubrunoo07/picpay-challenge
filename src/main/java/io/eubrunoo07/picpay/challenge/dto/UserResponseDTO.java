package io.eubrunoo07.picpay.challenge.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDTO {
    private String fullName;
    private String cpfOrCnpj;
    private String email;
    private String userType;
}
