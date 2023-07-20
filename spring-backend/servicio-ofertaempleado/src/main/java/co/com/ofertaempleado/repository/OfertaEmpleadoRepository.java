package co.com.ofertaempleado.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.common.ofertaempleado.model.*;

public interface OfertaEmpleadoRepository extends JpaRepository<OfertaEmpleado,Long>{
	@Query("SELECT emple FROM Empleado emple"
			+ " WHERE emple.empresa.id = ?1")
	public List<Empleado> findAllEmpleados(Long id_emp);
	public List<OfertaEmpleado> findAllByEmpleado(Empleado empleado);
	public OfertaEmpleado findByOfertaAndEmpleado(Oferta oferta, Empleado empleado);
	@Query("SELECT o FROM Oferta o WHERE o.id = :id_oferta")
	public Oferta findOferta(@Param(value = "id_oferta")Long id_oferta);
	@Query("SELECT emp FROM Empresa emp"
			+ " INNER JOIN Empleado emple ON emple.empresa = emp.id"
			+ " WHERE emple.id = :id_emple")
	public Empresa findEmpresa(@Param(value = "id_emple") Long id_emple);
	@Query("SELECT emple FROM Empleado emple"
			+ " WHERE emple.id = :id_emple")
	public Empleado findEmpleado(@Param(value = "id_emple") Long id_emple);
}
