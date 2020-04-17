package br.com.setebit.sgr.security.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author altitdb
 */
@Entity
@Table(name = "saa_rotina")
public class Rotina implements Serializable {

	private static final long serialVersionUID = 55549693990924773L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rotina")
	private Integer id;

	@Column(length = 100, nullable = false)
	private String imagem;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(length = 100, nullable = false)
	private String acao;

	@Column(length = 1, nullable = false)
	private byte status;

	@ManyToOne
	@JoinColumn(name = "id_sistema")
	private Sistema sistema;

	@Lob
	@Column(name = "logomarca")
	private byte[] logomarca;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getAcao() {
		if(acao==null)
			return " ";
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public byte[] getLogomarca() {
		return logomarca;
	}

	public void setLogomarca(byte[] logomarca) {
		this.logomarca = logomarca;
	}

	public Rotina(int id) {
		this.id = id;
	}
	
	public Rotina() {}

	public Rotina(Integer id, String imagem, String nome, String acao, Sistema sistema) {
		this.id = id;
		this.imagem = imagem;
		this.nome = nome;
		this.acao = acao;
		this.sistema = sistema;
		this.status = 1;
	}

}