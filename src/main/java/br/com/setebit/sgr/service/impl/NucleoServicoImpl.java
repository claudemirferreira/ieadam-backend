package br.com.setebit.sgr.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.setebit.sgr.repository.NucleoRepositorio;
import br.com.setebit.sgr.repository.NucleoRepositorioSql;
import br.com.setebit.sgr.security.entity.Nucleo;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.Zona;
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
	public List<Nucleo> findByZona(int zona) {
		return this.repositorio.findByZona(zona);
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
	public List<Nucleo> listaNucleoToUsuarioAndZona(Usuario usuario, Zona zona) {
		return repositorioSql.listaNucleoToUsuarioAndZona(usuario, zona);
	}

	@Override
	public boolean isUsuarioDeNucleo(int usuarioId, int idNucleo) {
		return repositorioSql.isUsuarioDeNucleo(usuarioId, idNucleo);
	}
}