package com.comfama.api.propuestasCultura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PropuestaCulturaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropuestaCulturaApplication.class, args);
	}

}
