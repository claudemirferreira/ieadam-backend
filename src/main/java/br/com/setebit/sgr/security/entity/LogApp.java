package br.com.setebit.sgr.security.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ieadam_log_app")
public class LogApp implements Serializable {

	private static final long serialVersionUID = -6455533571538685292L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_log_app")
	private int idLogApp;

	@Column(name = "data_hora_acao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraAcao;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@Column(name = "acao_usuario")
	private String acaoUsuario;

	public LogApp() {
		usuario = new Usuario();
	}

	public int getIdLogApp() {
		return idLogApp;
	}

	public void setIdLogApp(int idLogApp) {
		this.idLogApp = idLogApp;
	}

	public Date getDataHoraAcao() {
		return dataHoraAcao;
	}

	public void setDataHoraAcao(Date dataHoraAcao) {
		this.dataHoraAcao = dataHoraAcao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getAcaoUsuario() {
		return acaoUsuario;
	}

	public void setAcaoUsuario(String acaoUsuario) {
		this.acaoUsuario = acaoUsuario;
	}
}
