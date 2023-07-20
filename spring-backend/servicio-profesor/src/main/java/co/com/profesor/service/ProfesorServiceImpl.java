package co.com.profesor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.common.curso.model.Curso;
import co.com.common.generic.service.CommonServiceImpl;
import co.com.common.ofertaempleado.model.Oferta;
import co.com.common.ofertaempleado.model.OfertaEmpleado;
import co.com.profesor.repository.ProfesorRepository;
import co.com.common.profesor.model.Profesor;
import co.com.common.tipoidentificacion.model.TipoIdentificacion;

@Service
public class ProfesorServiceImpl extends CommonServiceImpl<Profesor, ProfesorRepository> implements ProfesorService{

	@Override
	@Transactional(readOnly = true)
	public List<Oferta> findAllOfertasByProfesor(Long id_prof) {
		return repository.findAllOfertasByProfesor(id_prof);
	}

	@Override
	@Transactional(readOnly = true)
	public Oferta findOfertaProfesor(Long id_prof, Long id_oferta) {
		return repository.findOfertaProfesor(id_prof, id_oferta);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OfertaEmpleado> findAllEmpleadosOferta(Long id_prof, Long id_oferta) {
		return repository.findAllEmpleadosOferta(id_prof, id_oferta);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Profesor> findProfesorByUsuario(Long usuario) {
		return repository.findProfesorByUsuario(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Oferta> findAllOfertasByProfesorPage(Pageable pageable, Long id) {
		List<Oferta> listaCursosProfesor = repository.findAllOfertasByProfesor(id);
		Page<Oferta> paginacion_cursos_profesor = new PageImpl<Oferta>(listaCursosProfesor,pageable,listaCursosProfesor.size());
		return paginacion_cursos_profesor;
	}

	@Override
	@Transactional(readOnly = true)
	public Curso findCursoProfesor(Long id_curso) {
		return repository.findCursoProfesor(id_curso);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<TipoIdentificacion> findAllTiposIdentificacion() {
		return repository.findAllTiposIdentificacion();
	}
}
