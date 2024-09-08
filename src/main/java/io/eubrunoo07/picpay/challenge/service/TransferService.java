package io.eubrunoo07.picpay.challenge.service;

import io.eubrunoo07.picpay.challenge.dto.TransferRequestDTO;
import io.eubrunoo07.picpay.challenge.dto.TransferResponseDTO;
import io.eubrunoo07.picpay.challenge.model.Transfer;

public interface TransferService {
    TransferResponseDTO createTransfer(TransferRequestDTO data);
}
