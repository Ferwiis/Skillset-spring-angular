package co.com.usuario.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.common.generic.controller.CommonController;
import co.com.common.usuario.model.Usuario;
import co.com.usuario.service.UsuarioService;


@RestController
public class UsuarioController extends CommonController<Usuario,UsuarioService>{
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> json){
		Optional<Usuario> optional = service.findByNickname(json.get("nickname"));
		if(!optional.isPresent()) {
			return new ResponseEntity("El usuario y/o contraseña son incorrectos", HttpStatus.UNAUTHORIZED);
		}
		Usuario usuario = optional.get();
		if (usuario.getCuenta_activada()) {
			if(usuario.getContrasena().equals(json.get("contrasena"))) {
				usuario.setEsta_activo(true);
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.save(usuario));
			}else {
				return new ResponseEntity("El usuario y/o contraseña son incorrectos", HttpStatus.UNAUTHORIZED);
			}
		}else {
			return new ResponseEntity("El usuario no ha sido activado por el administrador.", HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/activar/{id}")
	public ResponseEntity<?> activarUsuario(@PathVariable Long id){
		Optional<Usuario> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Usuario usuario_actualizado = optional.get();
		usuario_actualizado.setCuenta_activada(true);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuario_actualizado));
	}
	
	@PutMapping("/desactivar/{id}")
	public ResponseEntity<?> desactivarUsuario(@PathVariable Long id){
		Optional<Usuario> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Usuario usuario_actualizado = optional.get();
		usuario_actualizado.setCuenta_activada(false);
		usuario_actualizado.setEsta_activo(false);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuario_actualizado));
	}

}
