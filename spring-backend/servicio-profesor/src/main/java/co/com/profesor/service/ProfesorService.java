package co.com.profesor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.com.common.curso.model.Curso;
import co.com.common.generic.service.CommonService;
import co.com.common.ofertaempleado.model.Oferta;
import co.com.common.ofertaempleado.model.OfertaEmpleado;
import co.com.common.profesor.model.Profesor;
import co.com.common.tipoidentificacion.model.TipoIdentificacion;

public interface ProfesorService extends CommonService<Profesor>{
	public Iterable<TipoIdentificacion> findAllTiposIdentificacion();
	public Page<Oferta> findAllOfertasByProfesorPage(Pageable pageable, Long id);
	public Optional<Profesor> findProfesorByUsuario(Long usuario);
	public List<Oferta> findAllOfertasByProfesor(Long id_prof);
	public Oferta findOfertaProfesor(Long id_prof, Long id_oferta);
	public List<OfertaEmpleado> findAllEmpleadosOferta(Long id_prof, Long id_oferta);
	public Curso findCursoProfesor(Long id_curso);
}
