package co.com.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EntityScan("co.com.common.usuario.model")
@EnableEurekaClient
public class ServicioUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioUsuarioApplication.class, args);
	}

}
