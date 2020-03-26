package br.com.setebit.sgr.service.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.setebit.sgr.repository.UsuarioPerfilRepositorio;
import br.com.setebit.sgr.repository.UsuarioRepositorio;
import br.com.setebit.sgr.repository.UsuarioRepositorioJPA;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.UsuarioPerfil;
import br.com.setebit.sgr.security.jwt.JwtUserFactory;
import br.com.setebit.sgr.service.UsuarioServico;

@Service
public class UsuarioServicoImpl implements UsuarioServico {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private UsuarioRepositorioJPA usuarioRepositorioJPA;
	
	@Autowired
	private UsuarioPerfilRepositorio usuarioPerfilRepositorio;

	@Override
	public Usuario findByLoginAndSenha(String login, String senha) throws NoResultException {
		return this.usuarioRepositorio.findByLoginAndSenha(login, senha);
	}

	@Override
	public Usuario findByLogin(String login) {
		System.out.println("findByLogin = "+login);
		Usuario u = this.usuarioRepositorio.findByLogin(login);
		return u;
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

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		System.out.println("entrou no logar");
		Usuario usuario = usuarioRepositorio.findByLogin(login);
		if (usuario == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", login));
		} else {
			return JwtUserFactory.create(usuario);
		}
	}

	@Override
	public Usuario findByEmail(String email) {
		return this.usuarioRepositorio.findByEmail(email);
	}

	@Override
	public Usuario findByOne(Integer id) {
		return usuarioRepositorio.findById(id).get();
	}

	@Override
	public Page<Usuario> findByNomeLike(String nome, int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");
		return usuarioRepositorio.findByNomeLike(nome, pageRequest);
	}

}