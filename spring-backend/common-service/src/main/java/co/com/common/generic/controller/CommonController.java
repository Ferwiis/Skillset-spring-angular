package co.com.common.generic.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.common.generic.service.CommonService;

@RestController
public class CommonController<E,S extends CommonService<E>>  {
	
	@Autowired
	protected S service;
	
	@PostMapping
	public ResponseEntity<?> crear(@Valid @RequestBody E entity, BindingResult result) {
		if(result.hasErrors()) {
			return this.validar(result);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
	}
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/pagina")
	public ResponseEntity<?> listar(Pageable pageable){
		return ResponseEntity.ok().body(service.findAll(pageable));
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<E> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		E entity = optional.get();
		return ResponseEntity.ok(entity);
	}
	
		
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build(); 
	}
	
	protected ResponseEntity<?> validar(BindingResult result){
		Map<String,Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err ->{
			errores.put(err.getField(), " El atributo " + err.getField() + " " + err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}
	
}
