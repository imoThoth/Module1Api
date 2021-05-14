package com.BootcampApi.openApi

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.servers.Server
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@SpringBootApplication(exclude = arrayOf(SecurityAutoConfiguration::class))
class OpenApiApplication

fun main(args: Array<String>) {
	runApplication<OpenApiApplication>(*args)
	val passwordEncoder = BCryptPasswordEncoder()
	val hashedPassword = passwordEncoder.encode("password")
	println(hashedPassword)
}


@Bean
fun customOpenAPI(@Value("\${springdoc.version}") appVersion: String?): OpenAPI? {
	return OpenAPI()
		.info(
			Info()
				.title("Airports")
				.version(appVersion)
				.description("28,000 airports")
		)
		.addServersItem(Server().url("http://localhost:8080/"))
		.addServersItem(Server().url("https://api.whitehatcoaches.org.uk/"))
}
