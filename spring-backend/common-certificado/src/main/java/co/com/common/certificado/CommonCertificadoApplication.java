package co.com.common.certificado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"co.com.common.usuario.model","co.com.common.tipoidentificacion.model", "co.com.common.profesor.model", "co.com.common.curso.model",
	"co.com.common.oferta.model", "co.com.common.certificado.model", "co.com.common.ofertaempleado.model"})
public class CommonCertificadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonCertificadoApplication.class, args);
	}

}
