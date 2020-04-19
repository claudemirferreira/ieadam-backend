package br.com.setebit.sgr.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.setebit.sgr.dto.LogDTO;
import br.com.setebit.sgr.repository.LogAppRepositorio;
import br.com.setebit.sgr.repository.LogAppRepositorioSql;
import br.com.setebit.sgr.security.entity.LogApp;
import br.com.setebit.sgr.security.jwt.JwtUser;
import br.com.setebit.sgr.service.LogAppServico;

@Service
public class LogAppServicoImpl implements LogAppServico {

	@Autowired
	private LogAppRepositorio repositorio;

	@Autowired
	private LogAppRepositorioSql repositorioSql;

	@Override
	public LogApp salvar(LogApp logApp) {
		return this.repositorio.save(logApp);
	}
	
	@Override
	public LogApp salvarLog(String nomeRelatorio) {
		JwtUser user = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		LogApp logApp = new LogApp(new Date(), Integer.parseInt(user.getId()), nomeRelatorio);
		return this.repositorio.save(logApp);
	}

	@Override
	public List<LogApp> listarTodos() {
		return this.repositorio.findAll();
	}

	@Override
	public List<LogApp> listarPorUsuario(int idUsuario) {
		return this.repositorio.findByUsuario(idUsuario);
	}

	public List<LogApp> listarPorFiltros(LogDTO logApp) {
		return this.repositorioSql.listarLogByFiltros(logApp);
	}
}