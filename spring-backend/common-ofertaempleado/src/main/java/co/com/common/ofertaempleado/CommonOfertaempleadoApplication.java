package co.com.common.ofertaempleado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("co.com.common.empresa.model")
public class CommonOfertaempleadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonOfertaempleadoApplication.class, args);
	}

}
