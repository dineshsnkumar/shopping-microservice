package io.projects.kafka.EmailNotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
public class EmailNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailNotificationApplication.class, args);
	}

}
