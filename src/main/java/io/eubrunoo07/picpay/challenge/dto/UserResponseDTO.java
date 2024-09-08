package io.eubrunoo07.picpay.challenge.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UserResponseDTO {
    private String id;
    private String fullName;
    private String document;
    private String email;
    private String userType;
    private BigDecimal balance;
}
