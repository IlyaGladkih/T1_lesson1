package ru.test.lesson1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableAspectJAutoProxy
public class Lesson1Application {

	public static void main(String[] args) {
		SpringApplication.run(Lesson1Application.class, args);
	}

}
