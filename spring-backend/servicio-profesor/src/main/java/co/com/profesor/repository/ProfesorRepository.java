package co.com.profesor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.common.profesor.model.Profesor;
import co.com.common.tipoidentificacion.model.TipoIdentificacion;
import co.com.common.curso.model.Curso;
import co.com.common.ofertaempleado.model.Oferta;
import co.com.common.ofertaempleado.model.OfertaEmpleado;

public interface ProfesorRepository extends JpaRepository<Profesor, Long>{
	
	@Query("SELECT t FROM TipoIdentificacion t")
	public Iterable<TipoIdentificacion> findAllTiposIdentificacion();
	
	@Query("SELECT prof FROM Profesor prof"
			+ " JOIN prof.usuario usu"
			+ " WHERE usu.id = ?1")
	public Optional<Profesor> findProfesorByUsuario(Long usuario);
	
	@Query("SELECT o FROM Oferta o"
			+ " JOIN Profesor p ON o.profesor = p.id"
			+ " WHERE p.id = ?1 ")
	public List<Oferta> findAllOfertasByProfesor(Long id_prof);
	
	@Query("SELECT o FROM Oferta o"
			+ " JOIN Profesor p ON o.profesor = p.id"
			+ " WHERE p.id = ?1 AND o.id = ?2")
	public Oferta findOfertaProfesor(Long id_prof, Long id_oferta);
	
	@Query(value = "SELECT oe FROM OfertaEmpleado oe"
			+ " JOIN Oferta o ON oe.oferta = o.id"
			+ " JOIN Profesor p ON o.profesor = p.id"
			+ " WHERE p.id = ?1 AND o.id = ?2")
	public List<OfertaEmpleado> findAllEmpleadosOferta(Long id_prof, Long id_oferta);
	
	@Query("SELECT c FROM Curso c"
			+ " WHERE c.id = ?1")
	public Curso findCursoProfesor(Long id_curso);
}
