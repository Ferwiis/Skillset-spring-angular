package co.com.common.generic.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.com.common.tipoidentificacion.model.TipoIdentificacion;

public interface CommonService<E> {

	public E save(E entity);
	public Optional<E> findById(Long id);
	public Iterable<E> findAll();
	public Page<E> findAll(Pageable pageable);
	public void deleteById(Long id);
}
