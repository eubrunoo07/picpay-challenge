package io.eubrunoo07.picpay.challenge.enums;

import lombok.Getter;

@Getter
public enum TransferStatus {
    NOT_AUTHORIZED_TRANSFER("Not authorized transfer"),
    APPROVED("Approved"),
    TRANSFER_ERROR("Transfer error");

    private final String transferStatus;


    TransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }
}
