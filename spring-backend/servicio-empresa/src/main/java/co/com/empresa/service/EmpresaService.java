package co.com.empresa.service;

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
import co.com.common.usuario.model.Usuario;

public interface EmpresaService extends CommonService<Empresa> {
	public Page<Empleado> findAllEmpleadosEmpresaPaginacion(Pageable pageable, Long id);
	public Page<Oferta> findAllOfertasByEmpresaPage(Pageable pageable, Long id);
	public Iterable<TipoIdentificacion> findAllTiposIdentificacion();
	public List<Empleado> findAllEmpleados(Long id_emp);
	public Optional<Empresa> findEmpresaByUsuario(Long usuario);
	public Optional<Empleado> findEmpleado(Long id_emple);
	public List<Oferta> findAllOfertasByEmpresa(Long id_emp);
	public Oferta findOfertaEmpresa(Long id_emp, Long id_oferta);
	public List<OfertaEmpleado> findEmpleadosOferta(Long id_emp, Long id_oferta);
	public Curso findCursoEmpresa(Long id_curso);
}
