package com.crud.app.CRUDApp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "CRUD App REST API documentation",
				description = "Spring Boot Restful App",
				version = "v1.0.0",
				contact = @Contact(
						name = "Mary",
						email = "marjane.namavar@gmail.com"
				)
		)
)
public class CrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAppApplication.class, args);
	}

}
