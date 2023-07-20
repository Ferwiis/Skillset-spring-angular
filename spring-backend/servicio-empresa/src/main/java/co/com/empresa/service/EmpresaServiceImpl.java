package co.com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.empresa.repository.EmpresaRepository;
import co.com.common.curso.model.Curso;
import co.com.common.generic.service.CommonServiceImpl;
import co.com.common.ofertaempleado.model.Empleado;
import co.com.common.ofertaempleado.model.Empresa;
import co.com.common.ofertaempleado.model.Oferta;
import co.com.common.ofertaempleado.model.OfertaEmpleado;
import co.com.common.tipoidentificacion.model.TipoIdentificacion;

@Service
public class EmpresaServiceImpl extends CommonServiceImpl<Empresa, EmpresaRepository> implements EmpresaService{

	@Override
	@Transactional(readOnly = true)
	public Optional<Empleado> findEmpleado(Long id_emple) {
		return repository.findEmpleado(id_emple);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Oferta> findAllOfertasByEmpresa(Long id_emp) {
		return repository.findAllOfertasByEmpresa(id_emp);
	}

	@Override
	@Transactional(readOnly = true)
	public Oferta findOfertaEmpresa(Long id_emp, Long id_oferta) {
		return repository.findOfertaEmpresa(id_emp, id_oferta);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OfertaEmpleado> findEmpleadosOferta(Long id_emp, Long id_oferta) {
		return repository.findEmpleadosOferta(id_emp, id_oferta);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Empresa> findEmpresaByUsuario(Long usuario) {
		return repository.findEmpresaByUsuario(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<TipoIdentificacion> findAllTiposIdentificacion() {
		return repository.findAllTiposIdentificacion();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAllEmpleados(Long id_emp) {
		return repository.findAllEmpleados(id_emp);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Oferta> findAllOfertasByEmpresaPage(Pageable pageable, Long id) {
		List<Oferta> listaCursosEmpresa = repository.findAllOfertasByEmpresa(id);
		Page<Oferta> paginacion_cursos_empresa = new PageImpl<Oferta>(listaCursosEmpresa,pageable,listaCursosEmpresa.size());
		return paginacion_cursos_empresa;
	}

	@Override
	@Transactional(readOnly = true)
	public Curso findCursoEmpresa(Long id_curso) {
		return repository.findCursoEmpresa(id_curso);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Empleado> findAllEmpleadosEmpresaPaginacion(Pageable pageable, Long id) {
		List<Empleado> listaEmpleadosEmpresa = repository.findAllEmpleados(id);
		Page<Empleado> paginacion_empleados_empresa = new PageImpl<Empleado>(listaEmpleadosEmpresa,pageable,listaEmpleadosEmpresa.size());
		return paginacion_empleados_empresa;
	}
}
