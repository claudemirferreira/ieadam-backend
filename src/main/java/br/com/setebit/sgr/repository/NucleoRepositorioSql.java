package br.com.setebit.sgr.repository;

import java.util.List;

import br.com.setebit.sgr.security.entity.Nucleo;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.Zona;

public interface NucleoRepositorioSql {

	public List<Nucleo> listaNucleoUsuario(Usuario usuario);

	public List<Nucleo> listaNucleoPorArea(Usuario usuario);

	public List<Nucleo> listaNucleoToUsuarioAndZona(Usuario usuario, Zona zona);

	public boolean isUsuarioDeNucleo(int usuarioId, int idNucleo);

}