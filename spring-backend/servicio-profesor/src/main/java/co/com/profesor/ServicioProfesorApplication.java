package co.com.profesor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EntityScan({"co.com.common.usuario.model","co.com.common.tipoidentificacion.model","co.com.common.profesor.model","co.com.common.curso.model","co.com.common.ofertaempleado.model"})
@EnableEurekaClient
public class ServicioProfesorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioProfesorApplication.class, args);
	}

}
