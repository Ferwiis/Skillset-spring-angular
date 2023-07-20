package co.com.certificado.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.common.certificado.model.Certificado;
import co.com.common.generic.controller.CommonController;
import co.com.certificado.service.CertificadoService;


@RestController
public class CertificadoController extends CommonController<Certificado,CertificadoService>{
	
	@Autowired
	private CertificadoService servicio;

	@PutMapping("/{id}")
	public ResponseEntity<?> modificar(@Validated @RequestBody Certificado certificado, BindingResult result, @PathVariable Long id){
		Optional<Certificado> optional = servicio.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Certificado certificado_actualizado = optional.get();
//		certificado_actualizado.setId_emple(certificado.getId_emple());
//		certificado_actualizado.setNum_id_emple(certificado.getNum_id_emple());
//		certificado_actualizado.setNom_emple(certificado.getNom_emple());
//		certificado_actualizado.setApe_emple(certificado.getApe_emple());
//		certificado_actualizado.setTipo_id_emple(certificado.getTipo_id_emple());
//		certificado_actualizado.setFecha_nac_emple(certificado.getFecha_nac_emple());		
//		certificado_actualizado.setCiudad_emple(certificado.getCiudad_emple());
//		certificado_actualizado.setLocal_emple(certificado.getLocal_emple());
//		certificado_actualizado.setDir_emple(certificado.getDir_emple());
//		certificado_actualizado.setTel_emple(certificado.getTel_emple());
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(certificado_actualizado));
	}

}
