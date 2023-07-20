package co.com.oferta.service;

import co.com.common.profesor.model.Profesor;

import java.util.List;

import co.com.common.generic.service.CommonService;
import co.com.common.ofertaempleado.model.Oferta;

public interface OfertaService extends CommonService<Oferta> {
	public List<Oferta> findAllByProfesor(Profesor profesor);
}
