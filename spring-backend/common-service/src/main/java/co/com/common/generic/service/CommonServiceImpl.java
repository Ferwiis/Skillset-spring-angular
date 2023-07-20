package co.com.common.generic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import co.com.common.tipoidentificacion.model.TipoIdentificacion;



public class CommonServiceImpl<E,R extends JpaRepository<E,Long>> implements CommonService<E> {

	@Autowired
	protected R repository;
	
	@Override
	@Transactional
	public E save(E entity) {
		return repository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<E> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<E> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<E> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
