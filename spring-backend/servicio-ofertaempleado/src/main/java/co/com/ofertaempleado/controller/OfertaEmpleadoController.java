package co.com.ofertaempleado.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.common.generic.controller.CommonController;
import co.com.common.ofertaempleado.model.Empleado;
import co.com.common.ofertaempleado.model.Empresa;
import co.com.common.ofertaempleado.model.Horario;
import co.com.common.ofertaempleado.model.Oferta;
import co.com.common.ofertaempleado.model.OfertaEmpleado;
import co.com.ofertaempleado.service.OfertaEmpleadoService;

@RestController
public class OfertaEmpleadoController extends CommonController<OfertaEmpleado,OfertaEmpleadoService>{
	
	
	@PostMapping("/{id_oferta}/inscribirse")
	public ResponseEntity<?> inscribirse(@RequestBody Map<String, Empleado[]> json, @PathVariable Long id_oferta){
		Oferta oferta_inscripcion = service.findOferta(id_oferta);
		Empleado[] empleados = json.get("listaEmpleados");
		Empresa empresa_inscripcion = service.findEmpresa(empleados[0].getId());
		String respuesta = "Los empleados con los siguientes IDs no son de la empresa \'"+empresa_inscripcion.getRazon_social()+"\':\n";
		boolean no_son_de_la_empresa = false;
		for(int i = 0; i<empleados.length;i++) {
			Empleado empleado = empleados[i];
			Optional<Empleado> optional_empleado = service.findAllEmpleados(empresa_inscripcion.getId()).stream().filter(emple->emple.getId()==empleado.getId()).findFirst();
			if(!optional_empleado.isPresent()){
				no_son_de_la_empresa = true;
				respuesta+="- "+String.valueOf(empleados[i].getId())+"\n";
			}else {
				empleados[i] = optional_empleado.get();
			}
		}
		if(no_son_de_la_empresa) {
			return new ResponseEntity(respuesta, HttpStatus.UNAUTHORIZED);
		}
		if(empleados.length>oferta_inscripcion.getCupos()) {
			return new ResponseEntity("El número de cupos es "+String.valueOf(oferta_inscripcion.getCupos())+"; "
					+ "por lo cual no se pueden inscribir a todos estos empleados.\n"
					+ "Seleccione nuevamente una cantidad válida de empleados a inscribir en esta oferta.", HttpStatus.UNAUTHORIZED); 
		}
		respuesta = "Los empleados con los siguientes IDs ya vieron este curso:\n";
		boolean hubo_empleados_inscritos = false;
		for(Empleado empleado:empleados) {
			List<OfertaEmpleado> ofertas_empleado = service.findAllByEmpleado(empleado);
			for(OfertaEmpleado o:ofertas_empleado) {
				if(o.getOferta().getCurso().getId() == oferta_inscripcion.getCurso().getId()) {
					hubo_empleados_inscritos = true;
					respuesta+="- "+String.valueOf(empleado.getNum_id())+"\n";
					break;
				}
			}
		}
		respuesta+="Por favor seleccione otros empleados.";
		if(hubo_empleados_inscritos) {
			return new ResponseEntity(respuesta, HttpStatus.UNAUTHORIZED); 
		}
		respuesta = "Los empleados con los siguientes IDs tienen cruce de horarios:\n";
		boolean hubo_cruce_horarios = false;
		for(Empleado empleado:empleados) {
			List<OfertaEmpleado> cursos_inscritos_empleado = service.findAllByEmpleado(empleado);
			busqueda_cruce_empleado:
			for(OfertaEmpleado curso:cursos_inscritos_empleado) {
				List<Horario> horarios_curso = curso.getOferta().getHorarios();
				for(Horario horario:horarios_curso) {
					for(Horario horario_oferta_inscripcion:oferta_inscripcion.getHorarios()) {
						if(horario.getDia()==horario_oferta_inscripcion.getDia() && !horario.getHora_inicio().isBefore(horario_oferta_inscripcion.getHora_inicio()) && horario.getHora_inicio().isBefore(horario_oferta_inscripcion.getHora_fin())) {
							hubo_cruce_horarios = true;
							respuesta+="- "+String.valueOf(empleado.getNum_id())+"\n";
							break busqueda_cruce_empleado;
						}
					}
				}
			}
		}
		if(hubo_cruce_horarios) {
			return new ResponseEntity(respuesta, HttpStatus.UNAUTHORIZED);
		}
		List<OfertaEmpleado> curso_empleados = new ArrayList<>();
		for(Empleado empleado:empleados) {
			curso_empleados.add(new OfertaEmpleado(oferta_inscripcion, empleado));
		}
		service.saveAll(curso_empleados);
		return ResponseEntity.status(HttpStatus.CREATED).body(oferta_inscripcion);
	}
	
	@PutMapping("/{id_oferta}/empleado/{id_emple}/asignar_asistencias")
	public ResponseEntity<?> asignarAsistencias(@RequestParam int asistencias, @PathVariable Long id_oferta, @PathVariable Long id_emple){
		Oferta oferta = service.findOferta(id_oferta);
		OfertaEmpleado ofer_emple = service.findByOfertaAndEmpleado(oferta, service.findEmpleado(id_emple));
		String respuesta = "La cantidad de asistencias debe ser entre 0 y el número de sesiones del curso de \""+oferta.getCurso().getNombre()+"\" ("+oferta.getCurso().getSesiones_curso()+" sesiones)";
		if(asistencias < 0 || asistencias > oferta.getCurso().getSesiones_curso()) {
			return new ResponseEntity(respuesta, HttpStatus.NOT_ACCEPTABLE);
		}
		ofer_emple.setAsistencias(asistencias);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(ofer_emple));
	}
	
	@PutMapping("/{id_oferta}/empleado/{id_emple}/asignar_nota_definitiva")
	public ResponseEntity<?> asignarNotaDefinitiva(@RequestParam double nota_definitiva, @PathVariable Long id_oferta, @PathVariable Long id_emple){
		Oferta oferta = service.findOferta(id_oferta);
		OfertaEmpleado ofer_emple = service.findByOfertaAndEmpleado(oferta, service.findEmpleado(id_emple));
		String respuesta = "La nota definitiva del empleado debe ser entre 0.0 a 5.0";
		if(nota_definitiva < 0 || nota_definitiva > 5) {
			return new ResponseEntity(respuesta, HttpStatus.NOT_ACCEPTABLE);
		}
		ofer_emple.setNota_definitiva(nota_definitiva);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(ofer_emple));
	}

}
