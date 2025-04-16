package com.gmichel.aviones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EntityScan({"com.gmichel.commons.models.entities"})
@EnableFeignClients
public class MicroservicioAvionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioAvionesApplication.class, args);
	}

}
