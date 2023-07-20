package co.com.usuario.service;

import java.util.Optional;

import co.com.common.generic.service.CommonService;
import co.com.common.usuario.model.Rol;
import co.com.common.usuario.model.Usuario;

public interface UsuarioService extends CommonService<Usuario>{
	
	public Optional<Usuario> findByNickname(String nickname);
}
