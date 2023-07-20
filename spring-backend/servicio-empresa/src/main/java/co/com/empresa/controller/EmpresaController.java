package co.com.empresa.controller;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.common.generic.controller.CommonController;
import co.com.common.ofertaempleado.model.Empleado;
import co.com.common.ofertaempleado.model.Empresa;
import co.com.common.usuario.model.*;
import co.com.empresa.service.EmpresaService;


@RestController
public class EmpresaController extends CommonController<Empresa,EmpresaService>{
	
	@PostMapping(value = "/")
	public ResponseEntity<?> registrarEmpresa(@Valid @RequestBody Empresa empresa, BindingResult result){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		empresa.getUsuario().setNickname(empresa.getNit());
		empresa.getUsuario().getRoles().add(new Rol(2));
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(empresa));
	}
	
	@PostMapping(value = "/{id}/registrar/empleado")
	public ResponseEntity<?> registrarEmpleado(@Email(message = "no es un correo electrónico") @RequestParam String correo, @Valid @RequestBody Empleado empleado, BindingResult result, @PathVariable Long id){
		Optional<Empresa> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		if(result.hasErrors()) {
			return this.validar(result);
		}
	    int tam = 8;
	    boolean usarLetras = true;
	    boolean usarNumeros = true;
		Empresa empresa = optional.get();
		Usuario usuario = new Usuario();
		usuario.setNickname(correo.substring(0, correo.lastIndexOf("@")));
		usuario.setCorreo(correo);
		usuario.setContrasena(RandomStringUtils.random(tam, usarLetras, usarNumeros));
		usuario.getRoles().add(new Rol(3));
		empleado.setUsuario(usuario);
		empleado.setEmpresa(empresa);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(empresa));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> modificarEmpresa(@Valid @RequestBody Empresa empresa, BindingResult result, @PathVariable Long id){
		Optional<Empresa> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Empresa empresa_actualizada = optional.get();
		empresa_actualizada.setUsuario(empresa.getUsuario());
		empresa_actualizada.setTel_fijo(empresa.getTel_fijo());
		empresa_actualizada.setMatricula_merc(empresa.getMatricula_merc());		
		empresa_actualizada.setNom_duenio(empresa.getNom_duenio());
		empresa_actualizada.setApe_duenio(empresa.getApe_duenio());
		empresa_actualizada.setTel_duenio(empresa.getTel_duenio());
		empresa_actualizada.setNom_rep(empresa.getNom_rep());
		empresa_actualizada.setApe_rep(empresa.getApe_rep());
		empresa_actualizada.setTipo_id_rep(empresa.getTipo_id_duenio());
		empresa_actualizada.setNum_id_rep(empresa.getNum_id_rep());
		empresa_actualizada.setTel_rep(empresa.getTel_rep());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(empresa_actualizada));
	}
	
	@GetMapping("/usuario/{id}") 
	public ResponseEntity<?> findUsuarioEmpresa(@PathVariable Long id){
		Optional<Empresa> optional = service.findEmpresaByUsuario(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Empresa entity = optional.get();
		return ResponseEntity.ok(entity);
	}
	
	@GetMapping("/curso/{id}") 
	public ResponseEntity<?> findCursoEmpresa(@PathVariable Long id){
		return ResponseEntity.ok(service.findCursoEmpresa(id));
	}
	
	
	@GetMapping("/tipos_id") 
	public ResponseEntity<?> listarTiposID(){
		return ResponseEntity.ok(service.findAllTiposIdentificacion());
	}
	
	@GetMapping("/{id}/empleados")
	public ResponseEntity<?> listarEmpleados(Pageable pageable, @Valid @PathVariable Long id){
		Optional<Empresa> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		else{
			Empresa empresa = optional.get();
			return ResponseEntity.ok().body(service.findAllEmpleadosEmpresaPaginacion(pageable, empresa.getId()));
		}
	}
	
	@PutMapping("/{id}/modificar/empleado/{id_emple}")
	public ResponseEntity<?> modificarEmpleado(@Valid @RequestBody Empleado empleado, BindingResult result, @Valid @PathVariable Long id, @Valid @PathVariable Long id_emple){
		Optional<Empresa> optional_empresa = service.findById(id);
		if(!optional_empresa.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		else{
			Empresa empresa = optional_empresa.get();
			Optional<Empleado> optional_empleado = service.findEmpleado(id_emple);
			if(!optional_empleado.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			Empleado empleado_buscado = optional_empleado.get();
			empleado_buscado.setNombre(empleado.getNombre());
			empleado_buscado.setApellido(empleado.getApellido());	
			empleado_buscado.setCiudad(empleado.getCiudad());
			empleado_buscado.setLocalidad(empleado.getLocalidad());
			empleado_buscado.setDireccion(empleado.getDireccion());
			empleado_buscado.setTelefono(empleado.getTelefono());
			empleado_buscado.setTarj_pro(empleado.getTarj_pro());
			empleado_buscado.setEmpresa(empresa);
			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(empresa));
		}
	}
	
	
	@PutMapping("/{id}/modificar/contrasena")
	public ResponseEntity<?> modificarContrasena(@RequestParam(required = false) String contrasena_actual, @RequestParam(required = false) String nueva_contrasena, @RequestParam(required = false) String conf_contrasena, @Valid @RequestBody Empresa empresa, BindingResult result, @PathVariable Long id){
		Optional<Empresa> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Empresa empresa_actualizada = optional.get();
		
		if(!contrasena_actual.equals(empresa_actualizada.getUsuario().getContrasena())) {
			return new ResponseEntity("La contraseña actual es incorrecta", HttpStatus.UNAUTHORIZED);
		}
		
		if(!nueva_contrasena.equals(conf_contrasena)) {
			return new ResponseEntity("Las contraseñas no coinciden", HttpStatus.NOT_MODIFIED);
		}
		empresa_actualizada.getUsuario().setContrasena(nueva_contrasena);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(empresa_actualizada));
	}
	
	@GetMapping("/{id}/mis_cursos")
	public ResponseEntity<?> listarCursosDeLaEmpresa(Pageable pageable, @PathVariable Long id){
		Optional<Empresa> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(service.findAllOfertasByEmpresaPage(pageable, id));
	}
	
	@GetMapping("/{id_emp}/mis_cursos/curso/{id_oferta}")
	public ResponseEntity<?> consultarCurso(@PathVariable Long id_emp, @PathVariable Long id_oferta){
		Optional<Empresa> optional = service.findById(id_emp);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(service.findOfertaEmpresa(id_emp, id_oferta));
	}
	
	@GetMapping("/{id_emp}/mis_cursos/curso/{id_oferta}/empleados")
	public ResponseEntity<?> consultarEmpleadosCurso(@PathVariable Long id_emp, @PathVariable Long id_oferta){
		Optional<Empresa> optional = service.findById(id_emp);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(service.findEmpleadosOferta(id_emp, id_oferta));
	}
}