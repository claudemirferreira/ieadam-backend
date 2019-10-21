package br.com.setebit.sgr.repository;

import java.util.List;

import br.com.setebit.sgr.security.entity.Area;
import br.com.setebit.sgr.security.entity.Zona;

public interface AreaRepositorioSql {

	public List<Area> listaAreaToUsuarioAndNucleo(int idUsuario, int idNucleo);

	public List<Area> listaAreaToZona(Zona zona);

}