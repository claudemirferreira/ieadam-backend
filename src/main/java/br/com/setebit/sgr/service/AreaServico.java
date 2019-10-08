package br.com.setebit.sgr.service;

import java.util.List;

import br.com.setebit.sgr.security.entity.Area;
import br.com.setebit.sgr.security.entity.Nucleo;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.Zona;

public interface AreaServico {

	public List<Area> listarTodos();

	public Area salvar(Area area);

	public void remover(Area area);

	public List<Area> findByNucleo(int nucleo);

	public List<Area> findByMembro(int membro);

	public List<Area> findByMembroAndNucleo(int membro, int idNucleo);

	public List<Area> listaAreaToUsuarioAndNucleo(Usuario usuario, Nucleo nucleo);

	public List<Area> listaAreaToZona(Zona zona);

}