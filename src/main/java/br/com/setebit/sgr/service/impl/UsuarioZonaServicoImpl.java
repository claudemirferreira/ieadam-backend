package br.com.setebit.sgr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.setebit.sgr.repository.UsuarioZonaRepositorio;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.UsuarioZona;
import br.com.setebit.sgr.security.entity.Zona;
import br.com.setebit.sgr.service.UsuarioZonaServico;

@Service
public class UsuarioZonaServicoImpl implements UsuarioZonaServico {

	@Autowired
	private UsuarioZonaRepositorio repositorio;

	@Override
	public List<UsuarioZona> listarTodos() {
		return repositorio.findAll();
	}

	@Override
	public UsuarioZona salvar(UsuarioZona usuarioNucleo) {
		return repositorio.saveAndFlush(usuarioNucleo);
	}

	@Override
	public void remover(UsuarioZona usuarioNucleo) {
		repositorio.delete(usuarioNucleo);
	}

	@Override
	public UsuarioZona findByUsuarioAndByZona(Usuario usuario, Zona zona) {
		System.out.println("usuario " + usuario.getId());
		System.out.println("zona " + zona.getIdZona());

		UsuarioZona usuarioZona = repositorio.findByUsuarioAndByZona(usuario, zona);
		return usuarioZona;
	}

	@Override
	public void deleteByUsuarioAndByZona(Usuario usuario, Zona zona) {
		repositorio.deleteByUsuarioAndByZona(usuario, zona);
	}

	@Override
	public List<Zona> findByUsuario(Usuario usuario) {
		List<UsuarioZona> lista = repositorio.findByUsuario(usuario);
		List<Zona> zonas = new ArrayList<Zona>();
		for (UsuarioZona usuarioZona : lista) {
			zonas.add(usuarioZona.getZona());
		}
		return zonas;
	}

}