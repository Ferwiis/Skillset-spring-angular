package co.com.oferta.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.common.ofertaempleado.model.Oferta;
import co.com.common.ofertaempleado.model.Horario;
import co.com.common.generic.controller.CommonController;
import co.com.oferta.service.OfertaService;


@RestController
public class OfertaController extends CommonController<Oferta,OfertaService>{
	
	@PostMapping(value = "/")
	public ResponseEntity<?> crearOferta(@Valid @RequestBody Oferta oferta, BindingResult result){
		String respuesta = "El profesor con el ID "+oferta.getProfesor().getNum_id()+" tiene cruce de horarios.\nPor favor seleccione otro profesor.";
		List<Oferta> ofertas_profesor = service.findAllByProfesor(oferta.getProfesor());
		for(Oferta oferta_prof:ofertas_profesor) {
			List<Horario> horarios_oferta_profesor = oferta_prof.getHorarios();
			for(Horario horario_prof:horarios_oferta_profesor) {
				for(Horario horario_oferta_creacion:oferta.getHorarios()) {
					if((horario_prof.getId() == horario_oferta_creacion.getId())||(horario_prof.getDia().getId()==horario_oferta_creacion.getDia().getId() && !horario_prof.getHora_inicio().isBefore(horario_oferta_creacion.getHora_inicio()) && horario_prof.getHora_inicio().isBefore(horario_oferta_creacion.getHora_fin()))) {
						return new ResponseEntity(respuesta, HttpStatus.UNAUTHORIZED); 
					}
				}
			}
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(oferta));
	}
	
}
