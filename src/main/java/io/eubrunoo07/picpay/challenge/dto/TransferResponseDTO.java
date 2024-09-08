package io.eubrunoo07.picpay.challenge.dto;

import io.eubrunoo07.picpay.challenge.enums.TransferStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class TransferResponseDTO {
    private String senderName;
    private String receiveName;
    private BigDecimal transferValue;
    private LocalDateTime transferDate;
    private TransferStatus status;
}
