package br.com.setebit.sgr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.setebit.sgr.dto.UsuarioNucleoDTO;
import br.com.setebit.sgr.repository.UsuarioNucleoRepositorio;
import br.com.setebit.sgr.security.entity.Nucleo;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.UsuarioNucleo;
import br.com.setebit.sgr.security.entity.Zona;
import br.com.setebit.sgr.service.UsuarioNucleoServico;

@Service
public class UsuarioNucleoServicoImpl implements UsuarioNucleoServico {

	@Autowired
	private UsuarioNucleoRepositorio repositorio;

	@Override
	public List<UsuarioNucleo> listarTodos() {
		return repositorio.findAll();
	}

	@Override
	public UsuarioNucleo salvar(UsuarioNucleo usuarioNucleo) {
		return repositorio.saveAndFlush(usuarioNucleo);
	}

	@Override
	public void remover(UsuarioNucleo usuarioNucleo) {
		repositorio.delete(usuarioNucleo);
	}

	@Override
	public UsuarioNucleo findByUsuarioAndByNucleo(Usuario usuario, Nucleo nucleo) {
		return repositorio.findByUsuarioAndByNucleo(usuario, nucleo);
	}

	@Override
	public void deleteByUsuarioAndByNucleo(Usuario usuario, Nucleo nucleo) {
		repositorio.deleteByUsuarioAndByNucleo(usuario, nucleo);
	}

	@Override
	public List<Nucleo> findByUsuario(Usuario usuario) {

		List<UsuarioNucleo> lista = repositorio.findByUsuario(usuario);
		List<Nucleo> nucleos = new ArrayList<Nucleo>();
		for (UsuarioNucleo usuarioNucleo : lista) {
			nucleos.add(usuarioNucleo.getNucleo());
		}
		return nucleos;
	}

	@Override
	public UsuarioNucleoDTO atualizar(UsuarioNucleoDTO dto) {
		// TODO Auto-generated method stub
		UsuarioNucleo usuarioZona = UsuarioNucleoDTO.toEntity(dto);
		if (dto.isUsuarioNucleo())
			repositorio.save(usuarioZona);
		else {
			usuarioZona = repositorio.findByUsuarioAndByNucleo(new Usuario(dto.getIdUsuario()), new Nucleo(dto.getIdNucleo()));
			repositorio.deleteById(usuarioZona.getIdUsuarioNucleo());
		}
			
		return dto;
	}

}