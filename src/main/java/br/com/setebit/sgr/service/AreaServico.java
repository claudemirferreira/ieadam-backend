package br.com.setebit.sgr.service;

import java.util.List;

import br.com.setebit.sgr.dto.AreaDTO;
import br.com.setebit.sgr.security.entity.Area;
import br.com.setebit.sgr.security.entity.Zona;

public interface AreaServico {

	public List<Area> listarTodos();

	public Area salvar(Area area);

	public void remover(Area area);

	public List<AreaDTO> findByNucleo(int nucleo);

	public List<Area> findByMembro(int membro);

	public List<Area> findByMembroAndNucleo(int membro, int idNucleo);

	public List<AreaDTO> listaAreaToUsuarioAndNucleo(int idUsuario, int idNucleo);

	public List<Area> listaAreaToZona(Zona zona);

}