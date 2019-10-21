package br.com.setebit.sgr.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.setebit.sgr.dto.NucleoDTO;
import br.com.setebit.sgr.repository.NucleoRepositorio;
import br.com.setebit.sgr.repository.NucleoRepositorioSql;
import br.com.setebit.sgr.security.entity.Nucleo;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.service.NucleoServico;

@Service
public class NucleoServicoImpl implements NucleoServico, Serializable {

	private static final long serialVersionUID = -5220391642354623929L;

	@Autowired
	private NucleoRepositorio repositorio;

	@Autowired
	private NucleoRepositorioSql repositorioSql;

	@Override
	public List<Nucleo> listarTodos() {
		return this.repositorio.findAll();
	}

	@Override
	public Nucleo salvar(Nucleo nucleo) {
		return this.repositorio.save(nucleo);
	}

	@Override
	public void remover(Nucleo nucleo) {
		this.repositorio.delete(nucleo);

	}

	@Override
	public List<NucleoDTO> findByZona(int zona) {
		return NucleoDTO.toDTO(this.repositorio.findByZona(zona));
	}

	@Override
	public List<Nucleo> findByMembro(int membro) {
		return this.repositorio.findByMembro(membro);
	}

	public Nucleo findOne(int id) {
		return this.repositorio.findOne(id);
	}

	@Override
	public List<Nucleo> listaNucleoUsuario(Usuario usuario) {
		return repositorioSql.listaNucleoUsuario(usuario);
	}

	@Override
	public List<NucleoDTO> listaNucleoToUsuarioAndZona(int idUsuario, int idZona) {
		return NucleoDTO.toDTO(repositorioSql.listaNucleoToUsuarioAndZona(idUsuario, idZona));
	}

	@Override
	public boolean isUsuarioDeNucleo(int usuarioId, int idNucleo) {
		return repositorioSql.isUsuarioDeNucleo(usuarioId, idNucleo);
	}
}