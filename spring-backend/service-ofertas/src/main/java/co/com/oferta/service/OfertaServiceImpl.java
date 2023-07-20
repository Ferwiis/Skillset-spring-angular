package co.com.oferta.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.oferta.repository.OfertaRepository;
import co.com.common.profesor.model.Profesor;
import co.com.common.generic.service.CommonServiceImpl;
import co.com.common.ofertaempleado.model.Oferta;

@Service
public class OfertaServiceImpl extends CommonServiceImpl<Oferta, OfertaRepository> implements OfertaService{

	@Override
	public List<Oferta> findAllByProfesor(Profesor profesor) {
		return repository.findAllByProfesor(profesor);
	}
	
}
