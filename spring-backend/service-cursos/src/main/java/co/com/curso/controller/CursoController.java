package co.com.curso.controller;

import java.util.Optional;

import javax.validation.Valid;

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

import co.com.common.generic.controller.CommonController;
import co.com.common.curso.model.Curso;
import co.com.curso.service.CursoService;


@RestController
public class CursoController extends CommonController<Curso,CursoService>{
	
	@Autowired
	private CursoService service;
	

	@PutMapping("/{id}")
	public ResponseEntity<?> modificar(@Valid @RequestBody Curso curso, BindingResult result, @PathVariable Long id){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Curso> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso curso_actualizado = optional.get();
		curso_actualizado.setNombre(curso.getNombre());
		curso_actualizado.setObjetivo(curso.getObjetivo());
		curso_actualizado.setSesiones_semanales(curso.getSesiones_semanales());
		curso_actualizado.setHoras_sesion(curso.getHoras_sesion());
		curso_actualizado.setContenidos(curso.getContenidos());
		curso_actualizado.setPrecio(curso.getPrecio());
		curso_actualizado.setTipo_curso(curso.getTipo_curso());		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(curso_actualizado));
	}
	
}