package br.com.setebit.sgr.service;

import java.util.List;

import br.com.setebit.sgr.dto.LogDTO;
import br.com.setebit.sgr.security.entity.LogApp;

public interface LogAppServico {

	public LogApp salvar(LogApp logApp);

	public List<LogApp> listarTodos();

	public List<LogApp> listarPorUsuario(int idUsuario);

	public List<LogApp> listarPorFiltros(LogDTO logApp);

	LogApp salvarLog(String nomeRelatorio);
}