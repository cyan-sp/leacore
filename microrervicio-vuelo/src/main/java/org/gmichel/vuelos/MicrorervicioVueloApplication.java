package org.gmichel.vuelos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EntityScan({"com.gmichel.commons.models.entities"})
@EnableFeignClients
public class MicrorervicioVueloApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrorervicioVueloApplication.class, args);
    }

}
