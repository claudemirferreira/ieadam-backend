package br.com.setebit.sgr.repository;

import java.util.Date;
import java.util.List;

import br.com.setebit.sgr.security.entity.LogApp;

public interface LogAppRepositorioSql {

	public List<LogApp> listarLogByFiltros(String nomeUsuario, Date dataInicio, Date dataFim);

}