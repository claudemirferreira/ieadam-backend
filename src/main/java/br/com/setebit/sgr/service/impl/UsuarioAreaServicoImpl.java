package br.com.setebit.sgr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.setebit.sgr.dto.UsuarioAreaDTO;
import br.com.setebit.sgr.dto.UsuarioNucleoDTO;
import br.com.setebit.sgr.repository.UsuarioAreaRepositorio;
import br.com.setebit.sgr.security.entity.Area;
import br.com.setebit.sgr.security.entity.Nucleo;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.UsuarioArea;
import br.com.setebit.sgr.security.entity.UsuarioNucleo;
import br.com.setebit.sgr.service.UsuarioAreaServico;

@Service
public class UsuarioAreaServicoImpl implements UsuarioAreaServico {

	@Autowired
	private UsuarioAreaRepositorio repositorio;

	@Override
	public List<UsuarioArea> listarTodos() {
		return repositorio.findAll();
	}

	@Override
	public UsuarioArea salvar(UsuarioArea usuarioNucleo) {
		return repositorio.saveAndFlush(usuarioNucleo);
	}

	@Override
	public void remover(UsuarioArea usuarioNucleo) {
		repositorio.delete(usuarioNucleo);
	}

	@Override
	public UsuarioArea findByUsuarioAndByArea(Usuario usuario, Area area) {
		return repositorio.findByUsuarioAndByArea(usuario, area);
	}

	@Override
	public void deleteByUsuarioAndByArea(Usuario usuario, Area area) {
		repositorio.deleteByUsuarioAndByArea(usuario, area);

	}

	@Override
	public List<Area> findByUsuario(Usuario usuario) {
		List<UsuarioArea> lista = repositorio.findByUsuario(usuario);
		List<Area> areas = new ArrayList<Area>();
		for (UsuarioArea usuarioArea : lista) {
			areas.add(usuarioArea.getArea());
		}
		return areas;
	}

	@Override
	public UsuarioAreaDTO atualizar(UsuarioAreaDTO dto) {
		UsuarioArea usuarioArea = UsuarioAreaDTO.toEntity(dto);
		if (dto.isUsuarioArea())
			repositorio.save(usuarioArea);
		else {
			usuarioArea = repositorio.findByUsuarioAndByArea(new Usuario(dto.getIdUsuario()), new Area(dto.getIdArea()));
			repositorio.deleteById(usuarioArea.getIdUsuarioArea());
		}
		return dto;
	}
}