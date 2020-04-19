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

import br.com.setebit.sgr.util.PathRelatorios;

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

	public LogApp(Date dataHoraAcao, Integer idUsuario, String acaoUsuario) {
		super();
		this.dataHoraAcao = dataHoraAcao;
		this.usuario = new Usuario(idUsuario);
		if( PathRelatorios.RELATORIO_SECRETARIA_DEBITO.getNome().equals(acaoUsuario))
			this.acaoUsuario = PathRelatorios.RELATORIO_SECRETARIA_DEBITO_ACAO.getNome();
		else if (PathRelatorios.RELATORIO_SECRETARIA_ESTATISTICO.getNome().equals(acaoUsuario))
			this.acaoUsuario = PathRelatorios.RELATORIO_SECRETARIA_ESTATISTICO_ACAO.getNome();
		else if (PathRelatorios.RELATORIO_SECRETARIA_MEMBROS.getNome().equals(acaoUsuario))
			this.acaoUsuario = PathRelatorios.RELATORIO_SECRETARIA_MEMBROS_ACAO.getNome();
		else if (PathRelatorios.RELATORIO_SECRETARIA_DEBITO_PASTORAL.getNome().equals(acaoUsuario))
			this.acaoUsuario = PathRelatorios.RELATORIO_SECRETARIA_DEBITO_PASTORAL_ACAO.getNome();
		else if (PathRelatorios.RELATORIO_TESOURARIA_SALDO_CONGREGACAO.getNome().equals(acaoUsuario))
			this.acaoUsuario = PathRelatorios.RELATORIO_TESOURARIA_SALDO_CONGREGACAO_ACAO.getNome();
		else if (PathRelatorios.RELATORIO_TESOURARIA_PROVENTOS_PASTORAL.getNome().equals(acaoUsuario))
			this.acaoUsuario = PathRelatorios.RELATORIO_TESOURARIA_PROVENTOS_PASTORAL_ACAO.getNome();
		else if (PathRelatorios.RELATORIO_TESOURARIA_DEBITO_FINANCEIRO.getNome().equals(acaoUsuario))
			this.acaoUsuario = PathRelatorios.RELATORIO_TESOURARIA_DEBITO_FINANCEIRO_ACAO.getNome();
		else if (acaoUsuario.equals(null))
			this.acaoUsuario = "NÃO INFORMADO";
		else
			this.acaoUsuario = acaoUsuario;
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
