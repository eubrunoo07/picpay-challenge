package io.eubrunoo07.picpay.challenge.repository;

import io.eubrunoo07.picpay.challenge.model.Transfer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends MongoRepository<Transfer, String> {
}
