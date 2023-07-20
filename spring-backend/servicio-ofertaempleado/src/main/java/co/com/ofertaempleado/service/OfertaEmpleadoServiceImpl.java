package co.com.ofertaempleado.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.common.generic.service.CommonServiceImpl;
import co.com.common.ofertaempleado.model.Empleado;
import co.com.common.ofertaempleado.model.Empresa;
import co.com.common.ofertaempleado.model.Oferta;
import co.com.common.ofertaempleado.model.OfertaEmpleado;
import co.com.ofertaempleado.repository.OfertaEmpleadoRepository;

@Service
public class OfertaEmpleadoServiceImpl extends CommonServiceImpl<OfertaEmpleado, OfertaEmpleadoRepository> implements OfertaEmpleadoService{

	@Override
	@Transactional(readOnly = true)
	public Oferta findOferta(Long id_oferta) {
		return repository.findOferta(id_oferta);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<OfertaEmpleado> findAllByEmpleado(Empleado empleado) {
		return repository.findAllByEmpleado(empleado);
	}

	@Override
	@Transactional(readOnly = true)
	public Empresa findEmpresa(Long id_empleado) {
		return repository.findEmpresa(id_empleado);
	}

	@Override
	@Transactional
	public List<OfertaEmpleado> saveAll(List<OfertaEmpleado> curso_empleados) {
		return repository.saveAll(curso_empleados);
	}

	@Override
	@Transactional(readOnly = true)
	public OfertaEmpleado findByOfertaAndEmpleado(Oferta oferta, Empleado empleado) {
		return repository.findByOfertaAndEmpleado(oferta, empleado);
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findEmpleado(Long id_emple) {
		return repository.findEmpleado(id_emple);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAllEmpleados(Long id_emp) {
		return repository.findAllEmpleados(id_emp);
	}
}
