package io.eubrunoo07.picpay.challenge.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

@Data
@Builder
public class UserRequestDTO {
    @NotBlank(message = "You must enter the full name")
    private String fullName;
    @NotBlank(message = "You must enter the cpf or cnpj")
    private String document;
    @NotBlank(message = "You must enter the email")
    private String email;
    @NotBlank(message = "You must enter the password")
    private String password;
    @NotBlank(message = "You must enter the user type")
    private String userType;
    private BigDecimal balance;
}
