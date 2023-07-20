package co.com.usuario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.usuario.repository.UsuarioRepository;
import co.com.common.generic.service.CommonServiceImpl;
import co.com.common.usuario.model.Rol;
import co.com.common.usuario.model.Usuario;

@Service
public class UsuarioServiceImpl extends CommonServiceImpl<Usuario, UsuarioRepository> implements UsuarioService{
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findByNickname(String nickname) {
		return Optional.of(repository.findByNickname(nickname));
	}

}
