package com.compile.io.application;

import com.compile.io.application.data.TestData;
import com.compile.io.application.domain.TestLogic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public TestData createTestData() {
		return new TestData();
	}

	@Bean
	public TestLogic createTestLogic() {
		return new TestLogic();
	}
}

