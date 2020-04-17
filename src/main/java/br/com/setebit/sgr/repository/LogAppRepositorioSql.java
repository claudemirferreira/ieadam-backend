package br.com.setebit.sgr.repository;

import java.util.List;

import br.com.setebit.sgr.dto.LogDTO;
import br.com.setebit.sgr.security.entity.LogApp;

public interface LogAppRepositorioSql {

	List<LogApp> listarLogByFiltros(LogDTO dto);

}