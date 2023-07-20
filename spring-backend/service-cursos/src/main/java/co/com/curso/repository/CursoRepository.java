package co.com.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.common.curso.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

}
