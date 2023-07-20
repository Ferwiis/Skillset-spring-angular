package co.com.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.common.usuario.model.Rol;
import co.com.common.usuario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	
	public Usuario findByNickname(String nickname);
}
