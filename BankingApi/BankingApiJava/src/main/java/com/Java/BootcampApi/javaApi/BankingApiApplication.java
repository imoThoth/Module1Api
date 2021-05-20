package com.Java.BootcampApi.javaApi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingApiApplication.class, args);
	}
	@Bean
	public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {

		return new OpenAPI()
				.info(new Info()
						.title("Banking")
						.version(appVersion)
						.description("Your Account")
				)
				.addServersItem(new Server().url("http://localhost:8080/"));
				//.addServersItem(new Server().url("https://api.whitehatcoaches.org.uk/"));
	}
}
