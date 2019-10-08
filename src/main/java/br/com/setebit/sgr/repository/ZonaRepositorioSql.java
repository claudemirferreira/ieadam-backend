package br.com.setebit.sgr.repository;

import java.util.List;

import br.com.setebit.sgr.security.entity.Zona;

public interface ZonaRepositorioSql {

	public List<Zona> listaZonaUsuario(int usuarioId);

	public boolean isUsuarioDeZona(int usuarioId, int idZona);

}