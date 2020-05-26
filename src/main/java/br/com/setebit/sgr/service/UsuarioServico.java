package br.com.setebit.sgr.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import br.com.setebit.sgr.dto.UsuarioAssociacaoDTO;
import br.com.setebit.sgr.dto.UsuarioDTO;
import br.com.setebit.sgr.security.entity.Usuario;

@Component
public interface UsuarioServico extends UserDetailsService {

	public List<Usuario> listarTodos();

	public Usuario salvar(Usuario usuario);

	public void remover(Usuario usuario);

	public Usuario findByLogin(String login);
	
	public Usuario findByEmail(String email);
	
	public Usuario findByOne(Integer id);

	public Usuario findByLoginAndSenha(String login, String senha) throws NoResultException;

	public Page<Usuario> findByNomeLike(String nome, int page, int size);
	
	public UsuarioAssociacaoDTO findUsuarioAssociacao(Integer id);

	Usuario alterarSenha(UsuarioDTO dto);
	
	Page<Usuario> pesquisarUsuario(UsuarioDTO usuario, int page, int size);

}
