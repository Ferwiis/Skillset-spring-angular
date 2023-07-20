package co.com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan("co.com.common.curso.model")
public class ServiceCursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCursoApplication.class, args);
	}

}
