package co.com.empleado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.com.common.curso.model.Curso;
import co.com.common.generic.service.CommonService;
import co.com.common.ofertaempleado.model.Empleado;
import co.com.common.ofertaempleado.model.Empresa;
import co.com.common.ofertaempleado.model.Oferta;
import co.com.common.ofertaempleado.model.OfertaEmpleado;
import co.com.common.tipoidentificacion.model.TipoIdentificacion;

public interface EmpleadoService extends CommonService<Empleado>{
	public Iterable<TipoIdentificacion> findAllTiposIdentificacion();
	public Iterable<Empresa> findAllEmpresas();
	public Page<Oferta> findAllOfertasByEmpleadoPage(Pageable pageable, Long id);
	public Optional<Empleado> findEmpleadoByUsuario(Long usuario);
	public List<Oferta> findAllOfertasByEmpleado(Long id_emple);
	public OfertaEmpleado findOfertaEmpleado(Long id_emple, Long id_oferta);
	public List<Empleado> findAllEmpleadosOferta(Long id_oferta);
	public Curso findCursoEmpleado(Long id_curso);
}
