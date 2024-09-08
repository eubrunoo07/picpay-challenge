package io.eubrunoo07.picpay.challenge.model;

import io.eubrunoo07.picpay.challenge.enums.TransferStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "transfer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transfer {

    @Id
    private String id;

    private String sender_id;
    private String receiver_id;
    private BigDecimal transferValue;
    private LocalDateTime transferDate;
    private TransferStatus status;

}
