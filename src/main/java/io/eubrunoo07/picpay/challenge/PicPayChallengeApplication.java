package io.eubrunoo07.picpay.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class PicPayChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicPayChallengeApplication.class, args);
	}

}
