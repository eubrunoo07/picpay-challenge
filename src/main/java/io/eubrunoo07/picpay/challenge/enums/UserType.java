package io.eubrunoo07.picpay.challenge.enums;

import lombok.Getter;

@Getter
public enum UserType {
    USER("User"),
    MERCHANT("Merchant");

    private final String userType;

    UserType(String userType) {
        this.userType = userType;
    }
}
