package co.com.empresa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.common.curso.model.Curso;
import co.com.common.ofertaempleado.model.Empleado;
import co.com.common.ofertaempleado.model.Empresa;
import co.com.common.ofertaempleado.model.Oferta;
import co.com.common.ofertaempleado.model.OfertaEmpleado;
import co.com.common.tipoidentificacion.model.TipoIdentificacion;
import co.com.common.usuario.model.Usuario;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{	
	
	@Query("SELECT t FROM TipoIdentificacion t")
	public Iterable<TipoIdentificacion> findAllTiposIdentificacion();
	
	@Query("SELECT emp FROM Empresa emp"
			+ " JOIN emp.usuario usu"
			+ " WHERE usu.id = ?1")
	public Optional<Empresa> findEmpresaByUsuario(Long usuario);
	
	@Query("SELECT emple FROM Empleado emple"
			+ " WHERE emple.id = ?1")
	public Optional<Empleado> findEmpleado(Long id_emple);
	
	@Query("SELECT emple FROM Empleado emple"
			+ " WHERE emple.empresa.id = ?1")
	public List<Empleado> findAllEmpleados(Long id_emp);
	
	@Query(value = "SELECT o FROM Oferta o"
			+ " WHERE o.id IN (SELECT MIN(oe.oferta) FROM OfertaEmpleado oe"
			+ " JOIN Empleado emple ON oe.empleado = emple.id"
			+ " JOIN Empresa emp ON emple.empresa = emp.id"
			+ " WHERE emp.id = ?1"
			+ " GROUP BY oe.oferta)")
	public List<Oferta> findAllOfertasByEmpresa(Long id_emp);
	
	@Query("SELECT o FROM Oferta o"
			+ " JOIN OfertaEmpleado oe ON oe.oferta = o.id"
			+ " JOIN Empleado emple ON oe.empleado = emple.id"
			+ " JOIN Empresa emp ON emple.empresa = emp.id"
			+ " WHERE emp.id = ?1 AND o.id = ?2")
	public Oferta findOfertaEmpresa(Long id_emp, Long id_oferta);
	
	@Query(value = "SELECT oe FROM OfertaEmpleado oe"
			+ " JOIN Empleado emple ON oe.empleado = emple.id"
			+ " JOIN Empresa emp ON emple.empresa = emp.id"
			+ " JOIN Oferta o ON oe.oferta = o.id"
			+ " WHERE emp.id = ?1 AND o.id = ?2")
	public List<OfertaEmpleado> findEmpleadosOferta(Long id_emp, Long id_oferta);
	
	@Query("SELECT c FROM Curso c"
			+ " WHERE c.id = ?1")
	public Curso findCursoEmpresa(Long id_curso);
}
