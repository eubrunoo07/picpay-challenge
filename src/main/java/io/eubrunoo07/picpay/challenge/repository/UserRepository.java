package io.eubrunoo07.picpay.challenge.repository;

import io.eubrunoo07.picpay.challenge.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
