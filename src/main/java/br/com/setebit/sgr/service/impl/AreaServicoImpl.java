package br.com.setebit.sgr.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.setebit.sgr.dto.AreaDTO;
import br.com.setebit.sgr.repository.AreaRepositorio;
import br.com.setebit.sgr.repository.AreaRepositorioSql;
import br.com.setebit.sgr.security.entity.Area;
import br.com.setebit.sgr.security.entity.Zona;
import br.com.setebit.sgr.service.AreaServico;

@Service
public class AreaServicoImpl implements AreaServico, Serializable {

	private static final long serialVersionUID = -5220391642354623929L;

	@Autowired
	private AreaRepositorio repositorio;

	@Autowired
	private AreaRepositorioSql repositorioSql;

	@Override
	public List<Area> listarTodos() {
		return this.repositorio.findAll();
	}

	@Override
	public Area salvar(Area area) {
		return this.repositorio.save(area);
	}

	@Override
	public void remover(Area area) {
		this.repositorio.delete(area);

	}

	@Override
	public List<AreaDTO> findByNucleo(int nucleo) {
		return AreaDTO.toDTO(this.repositorio.findByNucleo(nucleo));
	}

	@Override
	public List<Area> findByMembro(int membro) {
		return this.repositorio.findByMembro(membro);
	}

	@Override
	public List<Area> findByMembroAndNucleo(int membro, int idNucleo) {
		return this.repositorio.findByMembroAndNucleo(membro, idNucleo);
	}

	public List<AreaDTO> listaAreaToUsuarioAndNucleo(int idUsuario, int idNucleo) {
		return AreaDTO.toDTO( repositorioSql.listaAreaToUsuarioAndNucleo(idUsuario, idNucleo));
	}

	@Override
	public List<Area> listaAreaToZona(Zona zona) {
		return repositorioSql.listaAreaToZona(zona);
	}

}