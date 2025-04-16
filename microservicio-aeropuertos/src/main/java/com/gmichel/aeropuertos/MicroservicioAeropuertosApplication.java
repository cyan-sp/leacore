package com.gmichel.aeropuertos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EntityScan({"com.gmichel.commons.models.entities"})
@EnableFeignClients
public class MicroservicioAeropuertosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioAeropuertosApplication.class, args);
	}

}
