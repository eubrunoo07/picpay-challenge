package io.eubrunoo07.picpay.challenge.model;

import io.eubrunoo07.picpay.challenge.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private String id;
    private String fullName;
    private String document;
    private String email;
    private String password;
    private UserType userType;
    private BigDecimal balance;
}
