package co.com.curso.service;

import org.springframework.stereotype.Service;

import co.com.curso.repository.CursoRepository;
import co.com.common.generic.service.CommonServiceImpl;
import co.com.common.curso.model.Curso;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService{

}