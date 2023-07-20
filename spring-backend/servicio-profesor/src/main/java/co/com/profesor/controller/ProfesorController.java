package co.com.profesor.controller;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.common.generic.controller.CommonController;
import co.com.common.profesor.model.Profesor;
import co.com.common.usuario.model.Rol;
import co.com.common.usuario.model.Usuario;
import co.com.profesor.service.ProfesorService;


@RestController
public class ProfesorController extends CommonController<Profesor,ProfesorService>{

	@PostMapping(value = "/")
	public ResponseEntity<?> registrarProfesor(@Email(message = "no es un correo electrónico") @RequestParam String correo, @Valid @RequestBody Profesor profesor, BindingResult result){
		if(result.hasErrors()) {
			return this.validar(result);
		}
	    int tam = 8;
	    boolean usarLetras = true;
	    boolean usarNumeros = true;
		Usuario usuario = new Usuario();
		usuario.setNickname(correo.substring(0, correo.lastIndexOf("@")));
		usuario.setCorreo(correo);
		usuario.setContrasena(RandomStringUtils.random(tam, usarLetras, usarNumeros));
		usuario.getRoles().add(new Rol(4));
		profesor.setUsuario(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(profesor));
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<?> modificarProfesor(@Validated @RequestBody Profesor profesor, BindingResult result, @PathVariable Long id){
		Optional<Profesor> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Profesor profesor_actualizado = optional.get();
		profesor_actualizado.setNombre(profesor.getNombre());
		profesor_actualizado.setApellido(profesor.getApellido());
		profesor_actualizado.setCiudad(profesor.getCiudad());
		profesor_actualizado.setLocalidad(profesor.getLocalidad());
		profesor_actualizado.setDireccion(profesor.getDireccion());
		profesor_actualizado.setTelefono(profesor.getTelefono());
		profesor_actualizado.setTarj_pro(profesor.getTarj_pro());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(profesor_actualizado));
	}
	
	@GetMapping("/tipos_id") 
	public ResponseEntity<?> listarTiposID(){
		return ResponseEntity.ok(service.findAllTiposIdentificacion());
	}
	
	
	@GetMapping("/usuario/{id}") 
	public ResponseEntity<?> findUsuarioProfesor(@PathVariable Long id){
		Optional<Profesor> optional = service.findProfesorByUsuario(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Profesor entity = optional.get();
		return ResponseEntity.ok(entity);
	}
	
	@GetMapping("/{id}/mis_cursos")
	public ResponseEntity<?> listarCursosDelProfesor(Pageable pageable, @PathVariable Long id){
		Optional<Profesor> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(service.findAllOfertasByProfesorPage(pageable, id));
	}
	
	@GetMapping("/curso/{id}") 
	public ResponseEntity<?> findCursoProfesor(@PathVariable Long id){
		return ResponseEntity.ok(service.findCursoProfesor(id));
	}
	
	@GetMapping("/{id_prof}/mis_cursos/curso/{id_oferta}")
	public ResponseEntity<?> consultarCurso(@PathVariable Long id_prof, @PathVariable Long id_oferta){
		Optional<Profesor> optional = service.findById(id_prof);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(service.findOfertaProfesor(id_prof, id_oferta));
	}
	
	@GetMapping("/{id_prof}/mis_cursos/curso/{id_oferta}/empleados")
	public ResponseEntity<?> consultarEmpleadosCurso(@PathVariable Long id_prof, @PathVariable Long id_oferta){
		Optional<Profesor> optional = service.findById(id_prof);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(service.findAllEmpleadosOferta(id_prof, id_oferta));
	}
}

