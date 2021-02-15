package pro.filaretov.spring.patterns.blackdots.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BlackDotsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackDotsApplication.class, args);
	}

}
