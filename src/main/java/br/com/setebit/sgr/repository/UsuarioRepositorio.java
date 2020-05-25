package br.com.setebit.sgr.repository;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.setebit.sgr.dto.UsuarioDTO;
import br.com.setebit.sgr.security.entity.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

	@Query("select u from Usuario u where u.login = :login")
	public Usuario findByLogin(@Param("login") String login);

	@Query("select u from Usuario u where u.nome like :nome")
	public List<Usuario> findByNomeLike(@Param("nome") String nome);

	@Query("select u from Usuario u where u.login = :login and u.senha = :senha")
	public Usuario findByLoginAndSenha(@Param("login") String login, @Param("senha") String senha)
			throws NoResultException;

	@Query("select u from Usuario u where u.email = :email")
	public Usuario findByEmail(@Param("email") String email);
	
	public Page<Usuario> findByNomeLike(String nome, Pageable pages);

	public Usuario findByIdMembro(Integer idMembro);
	
	@Query( value = " select id_usuario, login, senha, status, zona, area, nucleo, in_privilegio, \n" + 
			"email, id_membro, nome, logomarca, telefone "
			+ " from saa_usuario nome like :nome or login = :login or id_membro = :id_membro", 
			nativeQuery = true)
	public Page<Usuario> pesquisarUsuario(@Param("nome") String nome, 
			@Param("login") String login, 
			@Param("id_membro") Integer idMembro, 
			Pageable pages);

}
