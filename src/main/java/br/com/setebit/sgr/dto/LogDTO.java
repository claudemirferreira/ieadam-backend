package br.com.setebit.sgr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.setebit.sgr.security.entity.Area;
import br.com.setebit.sgr.security.entity.LogApp;
import br.com.setebit.sgr.security.entity.Usuario;

public class LogDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nomeUsuario;

	private Date dataInicio;

	private Date dataFim;
	
	private Integer idLogApp;

	private Date dataHoraAcao;

	private String acaoUsuario;
	
	public LogDTO() {}

	public LogDTO(String nomeUsuario, Date dataInicio, Date dataFim) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	public Integer getIdLogApp() {
		return idLogApp;
	}

	public void setIdLogApp(Integer idLogApp) {
		this.idLogApp = idLogApp;
	}

	public Date getDataHoraAcao() {
		return dataHoraAcao;
	}

	public void setDataHoraAcao(Date dataHoraAcao) {
		this.dataHoraAcao = dataHoraAcao;
	}

	public String getAcaoUsuario() {
		return acaoUsuario;
	}

	public void setAcaoUsuario(String acaoUsuario) {
		this.acaoUsuario = acaoUsuario;
	}

	public LogDTO(LogApp entity) {
		this.nomeUsuario = entity.getUsuario().getNome();
		this.dataHoraAcao = entity.getDataHoraAcao();
		this.acaoUsuario = entity.getAcaoUsuario();
		this.idLogApp = entity.getIdLogApp();
	}

	public static LogDTO toDTO(LogApp entity) {
		return new LogDTO(entity);
	}

	public static List<LogDTO> toDTO(List<LogApp> list) {
		List<LogDTO> dtos = new ArrayList<LogDTO>();
		list.forEach(item -> dtos.add(toDTO(item)));
		return dtos;
	}

}