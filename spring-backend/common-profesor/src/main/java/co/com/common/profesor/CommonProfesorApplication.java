package co.com.common.profesor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"co.com.common.usuario.model","co.com.common.tipoidentificacion.model","co.com.common.profesor.model"})
public class CommonProfesorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonProfesorApplication.class, args);
	}

}
