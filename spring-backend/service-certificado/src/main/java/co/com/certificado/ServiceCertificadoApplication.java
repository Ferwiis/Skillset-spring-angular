package co.com.certificado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan({"co.com.common.usuario.model","co.com.common.tipoidentificacion.model", "co.com.common.empresa.model",
	"co.com.common.empleado.model", "co.com.common.profesor.model", "co.com.common.curso.model",
	"co.com.common.oferta.model", "co.com.common.certificado.model"})
public class ServiceCertificadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCertificadoApplication.class, args);
	}

}
