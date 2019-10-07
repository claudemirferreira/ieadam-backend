package br.com.setebit.sgr.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.setebit.sgr.security.entity.Usuario;

public interface UsuarioServico extends UserDetailsService {

	public List<Usuario> listarTodos();

	public Usuario salvar(Usuario usuario);

	public void remover(Usuario usuario);

	public Usuario findByLogin(String login);

	public Usuario findByLoginAndSenha(String login, String senha) throws NoResultException;

	public List<Usuario> findByUsuario(Usuario usuario) throws NoResultException;

}
