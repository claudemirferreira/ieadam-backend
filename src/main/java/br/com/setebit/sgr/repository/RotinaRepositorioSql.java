package br.com.setebit.sgr.repository;

import java.util.List;

import br.com.setebit.sgr.security.entity.Rotina;

public interface RotinaRepositorioSql {

	public List<Rotina> listaRotinasPorPerfil(int id);

}
