package co.com.empleado.controller;

import java.util.Optional;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import co.com.common.generic.controller.CommonController;
import co.com.common.ofertaempleado.model.*;
import co.com.common.profesor.model.Profesor;
import co.com.common.usuario.model.Rol;
import co.com.common.usuario.model.Usuario;
import co.com.empleado.service.EmpleadoService;


@RestController
public class EmpleadoController extends CommonController<Empleado,EmpleadoService>{
	
	@PostMapping(value = "/")
	public ResponseEntity<?> registrarEmpleado(@Valid @RequestBody Empleado empleado, BindingResult result){
		if(result.hasErrors()) {
			return this.validar(result);
		}
	    int tam = 8;
	    boolean usarLetras = true;
	    boolean usarNumeros = true;
	    empleado.getUsuario().setNickname(empleado.getUsuario().getCorreo().substring(0, empleado.getUsuario().getCorreo().lastIndexOf("@")));
	    empleado.getUsuario().setCorreo(empleado.getUsuario().getCorreo());
	    empleado.getUsuario().setContrasena(RandomStringUtils.random(tam, usarLetras, usarNumeros));
	    empleado.getUsuario().getRoles().add(new Rol(3));
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(empleado));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> modificar(@Validated @RequestBody Empleado empleado, BindingResult result, @PathVariable Long id){
		Optional<Empleado> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Empleado empleado_actualizado = optional.get();
		empleado_actualizado.setNombre(empleado.getNombre());
		empleado_actualizado.setApellido(empleado.getApellido());	
		empleado_actualizado.setCiudad(empleado.getCiudad());
		empleado_actualizado.setLocalidad(empleado.getLocalidad());
		empleado_actualizado.setDireccion(empleado.getDireccion());
		empleado_actualizado.setTelefono(empleado.getTelefono());
		empleado_actualizado.setTarj_pro(empleado.getTarj_pro());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(empleado_actualizado));
	}
	
	@GetMapping("/tipos_id") 
	public ResponseEntity<?> listarTiposID(){
		return ResponseEntity.ok(service.findAllTiposIdentificacion());
	}
	
	
	@GetMapping("/empresas") 
	public ResponseEntity<?> listarEmpresas(){
		return ResponseEntity.ok(service.findAllEmpresas());
	}
	
	@GetMapping("/usuario/{id}") 
	public ResponseEntity<?> findUsuarioEmpleado(@PathVariable Long id){
		Optional<Empleado> optional = service.findEmpleadoByUsuario(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Empleado entity = optional.get();
		return ResponseEntity.ok(entity);
	}
	
	@GetMapping("/{id}/mis_cursos")
	public ResponseEntity<?> listarCursosDelEmpleado(Pageable pageable, @PathVariable Long id){
		Optional<Empleado> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(service.findAllOfertasByEmpleadoPage(pageable, id));
	}
	
	@GetMapping("/curso/{id}") 
	public ResponseEntity<?> findCursoEmpleado(@PathVariable Long id){
		return ResponseEntity.ok(service.findCursoEmpleado(id));
	}
	
	
	@GetMapping("/{id_emple}/mis_cursos/curso/{id_oferta}")
	public ResponseEntity<?> consultarCurso(@PathVariable Long id_emple, @PathVariable Long id_oferta){
		Optional<Empleado> optional = service.findById(id_emple);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(service.findOfertaEmpleado(id_emple, id_oferta));
	}
	
	@GetMapping("/{id_emple}/mis_cursos/curso/{id_oferta}/empleados")
	public ResponseEntity<?> consultarEmpleadosCurso(@PathVariable Long id_emple, @PathVariable Long id_oferta){
		Optional<Empleado> optional = service.findById(id_emple);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(service.findAllEmpleadosOferta(id_oferta));
	}

}
