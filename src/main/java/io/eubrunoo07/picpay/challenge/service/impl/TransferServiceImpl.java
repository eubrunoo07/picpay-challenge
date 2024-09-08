package io.eubrunoo07.picpay.challenge.service.impl;

import io.eubrunoo07.picpay.challenge.dto.TransferRequestDTO;
import io.eubrunoo07.picpay.challenge.dto.TransferResponseDTO;
import io.eubrunoo07.picpay.challenge.enums.TransferStatus;
import io.eubrunoo07.picpay.challenge.enums.UserType;
import io.eubrunoo07.picpay.challenge.exception.exceptions.*;
import io.eubrunoo07.picpay.challenge.model.Transfer;
import io.eubrunoo07.picpay.challenge.model.User;
import io.eubrunoo07.picpay.challenge.repository.TransferRepository;
import io.eubrunoo07.picpay.challenge.repository.UserRepository;
import io.eubrunoo07.picpay.challenge.service.TransferService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private TransferRepository transferRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public TransferResponseDTO createTransfer(TransferRequestDTO data) {
        Transfer transfer = null;
        if(verifyTransfer(data)){
            User sender = userRepository
                    .findById(data.getSenderId())
                    .orElseThrow(() -> new UserNotExistsException("Sender not exists"));
            User receive = userRepository
                    .findById(data.getReceiveId())
                    .orElseThrow(() -> new UserNotExistsException("Receive not exists"));

            transfer = new Transfer();
            transfer.setTransferDate(LocalDateTime.now());
            transfer.setTransferValue(data.getTransferValue());
            transfer.setSender_id(sender.getId());
            transfer.setReceiver_id(receive.getId());
            BigDecimal senderBalanceBeforeTransaction = sender.getBalance();
            BigDecimal receiveBalanceBeforeTransaction = receive.getBalance();
            sender.setBalance(sender.getBalance().subtract(data.getTransferValue()));
            receive.setBalance(receive.getBalance().add(data.getTransferValue()));
            if(sender.getBalance().equals(senderBalanceBeforeTransaction)){
                transfer.setStatus(TransferStatus.TRANSFER_ERROR);
            }
            else if(receive.getBalance().equals(receiveBalanceBeforeTransaction)){
                transfer.setStatus(TransferStatus.TRANSFER_ERROR);
            }
            else{
                transfer.setStatus(TransferStatus.APPROVED);
                transferRepository.save(transfer);
                userRepository.save(sender);
                userRepository.save(receive);
            }
        }

        User sender = userRepository
                .findById(data.getSenderId())
                .orElseThrow(() -> new UserNotExistsException("Sender not exists"));
        User receive = userRepository
                .findById(data.getReceiveId())
                .orElseThrow(() -> new UserNotExistsException("Receive not exists"));

        assert transfer != null;

        return TransferResponseDTO.builder()
                .id(transfer.getId())
                .senderName(sender.getFullName())
                .receiveName(receive.getFullName())
                .transferValue(transfer.getTransferValue())
                .status(transfer.getStatus())
                .transferDate(transfer.getTransferDate())
                .build();
    }

    public boolean verifyTransfer(TransferRequestDTO data){
        User sender = userRepository
                .findById(data.getSenderId())
                .orElseThrow(() -> new UserNotExistsException("Sender not exists"));
        User receive = userRepository
                .findById(data.getReceiveId())
                .orElseThrow(() -> new UserNotExistsException("Receive not exists"));

        if(sender.getUserType() == UserType.MERCHANT){
            throw new MerchantCannotPerformTransferException("Merchant cannot perform transfer");
        }
        if(sender.getBalance().compareTo(data.getTransferValue()) < 0){
            throw new BalanceIsLessThanTransferValueException("The balance is less than the transfer amount");
        }
        if(data.getTransferValue().compareTo(BigDecimal.ZERO) <= 0){
            throw new TransferValueIsInvalidException("Transfer value must be greater than 0");
        }
        if(sender.getId().equals(receive.getId())){
            throw new SenderIsAlsoReceiveException("The sender is also the receive");
        }
        return true;
    }
}
