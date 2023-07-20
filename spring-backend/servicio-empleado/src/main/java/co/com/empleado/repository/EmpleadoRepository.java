package co.com.empleado.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.common.curso.model.Curso;
import co.com.common.ofertaempleado.model.*;
import co.com.common.tipoidentificacion.model.TipoIdentificacion;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
	
	@Query("SELECT emp FROM Empresa emp")
	public Iterable<Empresa> findAllEmpresas();
	
	@Query("SELECT t FROM TipoIdentificacion t")
	public Iterable<TipoIdentificacion> findAllTiposIdentificacion();
	
	@Query("SELECT emple FROM Empleado emple"
			+ " JOIN emple.usuario usu"
			+ " WHERE usu.id = ?1")
	public Optional<Empleado> findEmpleadoByUsuario(Long usuario);
	
	@Query("SELECT oe.oferta FROM OfertaEmpleado oe"
			+ " JOIN Empleado emple"
			+ " ON oe.empleado = emple.id"
			+ " WHERE emple.id = ?1")
	public List<Oferta> findAllOfertasByEmpleado(Long id_emple);
	
	@Query("SELECT oe FROM OfertaEmpleado oe"
			+ " JOIN Oferta o ON oe.oferta = o.id"
			+ " JOIN Empleado emple ON oe.empleado = emple.id"
			+ " WHERE emple.id = ?1 AND o.id = ?2")
	public OfertaEmpleado findOfertaEmpleado(Long id_emple, Long id_oferta);
	
	@Query(value = "SELECT oe.empleado FROM OfertaEmpleado oe"
			+ " JOIN Oferta o ON oe.oferta = o.id"
			+ " WHERE o.id = ?1")
	public List<Empleado> findAllEmpleadosOferta(Long id_oferta);
	
	@Query("SELECT c FROM Curso c"
			+ " WHERE c.id = ?1")
	public Curso findCursoEmpleado(Long id_curso);
}
