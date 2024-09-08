package io.eubrunoo07.picpay.challenge.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TransferRequestDTO {
    private String senderId;
    private String receiveId;
    private BigDecimal transferValue;
}
