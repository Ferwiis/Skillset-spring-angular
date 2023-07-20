package co.com.ofertaempleado.service;

import java.util.List;

import co.com.common.generic.service.CommonService;
import co.com.common.ofertaempleado.model.*;

public interface OfertaEmpleadoService extends CommonService<OfertaEmpleado>{
	public List<Empleado> findAllEmpleados(Long id_emp);
	public List<OfertaEmpleado> findAllByEmpleado(Empleado empleado);
	public OfertaEmpleado findByOfertaAndEmpleado(Oferta oferta, Empleado empleado);
	public Oferta findOferta(Long id_oferta);
	public Empresa findEmpresa(Long id_empleado);
	public List<OfertaEmpleado> saveAll(List<OfertaEmpleado> curso_empleados);
	public Empleado findEmpleado(Long id_emple);
}
