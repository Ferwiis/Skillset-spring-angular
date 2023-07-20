package co.com.empleado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.common.curso.model.Curso;
import co.com.common.generic.service.CommonServiceImpl;
import co.com.common.ofertaempleado.model.Empleado;
import co.com.common.ofertaempleado.model.Empresa;
import co.com.common.ofertaempleado.model.Oferta;
import co.com.common.ofertaempleado.model.OfertaEmpleado;
import co.com.common.tipoidentificacion.model.TipoIdentificacion;
import co.com.empleado.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl extends CommonServiceImpl<Empleado, EmpleadoRepository> implements EmpleadoService{

	@Override
	@Transactional(readOnly = true)
	public List<Oferta> findAllOfertasByEmpleado(Long id_emple) {
		return repository.findAllOfertasByEmpleado(id_emple);
	}

	@Override
	@Transactional(readOnly = true)
	public OfertaEmpleado findOfertaEmpleado(Long id_emple, Long id_oferta) {
		return repository.findOfertaEmpleado(id_emple, id_oferta);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAllEmpleadosOferta(Long id_oferta) {
		return repository.findAllEmpleadosOferta(id_oferta);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Empleado> findEmpleadoByUsuario(Long usuario) {
		return repository.findEmpleadoByUsuario(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Oferta> findAllOfertasByEmpleadoPage(Pageable pageable, Long id) {
		List<Oferta> listaCursosEmpleado = repository.findAllOfertasByEmpleado(id);
		Page<Oferta> paginacion_cursos_empleado = new PageImpl<Oferta>(listaCursosEmpleado,pageable,listaCursosEmpleado.size());
		return paginacion_cursos_empleado;
	}

	@Override
	@Transactional(readOnly = true)
	public Curso findCursoEmpleado(Long id_curso) {
		return repository.findCursoEmpleado(id_curso);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<TipoIdentificacion> findAllTiposIdentificacion() {
		return repository.findAllTiposIdentificacion();
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Empresa> findAllEmpresas() {
		return repository.findAllEmpresas();
	}
}
