package co.com.oferta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.common.ofertaempleado.model.Oferta;
import co.com.common.profesor.model.Profesor;

public interface OfertaRepository extends JpaRepository<Oferta, Long>{
	public List<Oferta> findAllByProfesor(Profesor profesor);
}
