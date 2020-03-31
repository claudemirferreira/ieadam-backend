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

import br.com.setebit.sgr.dto.AreaDTO;
import br.com.setebit.sgr.dto.NucleoDTO;
import br.com.setebit.sgr.dto.UsuarioAssociacaoDTO;
import br.com.setebit.sgr.dto.UsuarioDTO;
import br.com.setebit.sgr.dto.ZonaDTO;
import br.com.setebit.sgr.repository.UsuarioPerfilRepositorio;
import br.com.setebit.sgr.repository.UsuarioRepositorio;
import br.com.setebit.sgr.repository.UsuarioRepositorioJPA;
import br.com.setebit.sgr.security.entity.Area;
import br.com.setebit.sgr.security.entity.Nucleo;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.Zona;
import br.com.setebit.sgr.security.jwt.JwtUserFactory;
import br.com.setebit.sgr.service.AreaServico;
import br.com.setebit.sgr.service.NucleoServico;
import br.com.setebit.sgr.service.UsuarioAreaServico;
import br.com.setebit.sgr.service.UsuarioNucleoServico;
import br.com.setebit.sgr.service.UsuarioServico;
import br.com.setebit.sgr.service.UsuarioZonaServico;
import br.com.setebit.sgr.service.ZonaServico;

@Service
public class UsuarioServicoImpl implements UsuarioServico {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private UsuarioRepositorioJPA usuarioRepositorioJPA;

	@Autowired
	private UsuarioPerfilRepositorio usuarioPerfilRepositorio;

	@Autowired
	private ZonaServico zonaServico;

	@Autowired
	private NucleoServico nucleoServico;

	@Autowired
	private AreaServico areaServico;

	@Autowired
	private UsuarioZonaServico usuarioZonaServico;

	@Autowired
	private UsuarioNucleoServico usuarioNucleoServico;

	@Autowired
	private UsuarioAreaServico usuarioAreaServico;

	@Override
	public Usuario findByLoginAndSenha(String login, String senha) throws NoResultException {
		return this.usuarioRepositorio.findByLoginAndSenha(login, senha);
	}

	@Override
	public Usuario findByLogin(String login) {
		System.out.println("findByLogin = " + login);
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

	@Override
	public UsuarioAssociacaoDTO findUsuarioAssociacao(UsuarioDTO usuario) {

		UsuarioAssociacaoDTO dto = new UsuarioAssociacaoDTO();

		dto.setZonas(ZonaDTO.toDTO(zonaServico.listarTodos()));
		dto.setNucleos(NucleoDTO.toDTO(nucleoServico.listarTodos()));
		dto.setAreas(AreaDTO.toDTO(areaServico.listarTodos()));
		dto.setUsuario(usuario);

		for (ZonaDTO zona : dto.getZonas()) {
			if (usuarioZonaServico.findByUsuarioAndByZona(new Usuario(usuario.getId()), new Zona(zona.getId())) == null)
				zona.setUsuarioZona(false);
			else
				zona.setUsuarioZona(true);
		}

		for (NucleoDTO nucleo : dto.getNucleos()) {
			if (usuarioNucleoServico.findByUsuarioAndByNucleo(new Usuario(usuario.getId()),
					new Nucleo(nucleo.getId())) == null)
				nucleo.setUsuarioNucleo(false);
			else
				nucleo.setUsuarioNucleo(true);
		}

		for (AreaDTO area : dto.getAreas()) {
			if (usuarioAreaServico.findByUsuarioAndByArea(new Usuario(usuario.getId()), new Area(area.getId())) == null)
				area.setUsuarioArea(false);
			else
				area.setUsuarioArea(true);
		}

		return dto;
	}

}