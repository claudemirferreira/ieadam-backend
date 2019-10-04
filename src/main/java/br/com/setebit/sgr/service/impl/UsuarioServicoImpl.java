package br.com.setebit.sgr.service.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.setebit.sgr.repository.UsuarioRepositorio;
import br.com.setebit.sgr.repository.UsuarioRepositorioJPA;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.service.UsuarioServico;

@Service
public class UsuarioServicoImpl implements UsuarioServico {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private UsuarioRepositorioJPA usuarioRepositorioJPA;

	@Override
	public Usuario findByLoginAndSenha(String login, String senha) throws NoResultException {
		return this.usuarioRepositorio.findByLoginAndSenha(login, senha);
	}

	@Override
	public Usuario findByLogin(String login) {
		return this.usuarioRepositorio.findByLogin(login);
	}

	@Override
	public List<Usuario> listarTodos() {
		return this.usuarioRepositorio.findAll();
	}

	@Override
	public Usuario salvar(Usuario usuario) {
		return this.usuarioRepositorio.save(usuario);
	}

	@Override
	public void remover(Usuario usuario) {
		this.usuarioRepositorio.delete(usuario);
	}

	@Override
	public List<Usuario> findByUsuario(Usuario usuario) {
		return usuarioRepositorioJPA.findByUsuario(usuario);
	}

}