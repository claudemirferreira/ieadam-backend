package br.com.setebit.sgr.repository;

import java.util.List;

import br.com.setebit.sgr.security.entity.Rotina;

public interface PerfilRotinaRepositorioSql {

	public List<Rotina> listaRotinaNotInPerfil(int idPerfil);
	
	public Rotina existeRotinaAssociada(int idPerfil, int idRotina);

}