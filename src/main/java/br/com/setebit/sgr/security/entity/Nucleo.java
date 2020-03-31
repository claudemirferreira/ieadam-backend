package br.com.setebit.sgr.security.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ieadam_nucleo")
public class Nucleo implements Serializable {

	private static final long serialVersionUID = 1724329521623025890L;

	@Id
	@Column(name = "id_nucleo")
	private int id;

	@Column(name = "situacao", length = 1, columnDefinition = "CHAR(1)", nullable = false)
	private String situacao;

	@Column(name = "id_coordenador")
	private int idCoordenador;

	@Column(length = 60, nullable = false)
	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_ultima_atualizacao")
	private Date dataUltimaAtualizacao;

	@Transient
	private boolean usuarioNucleo;

	@ManyToOne
	@JoinColumn(name = "id_zona")
	@JsonManagedReference
	private Zona zona;
	
	public Nucleo() {
		
	}

	public Nucleo(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public int getIdCoordenador() {
		return idCoordenador;
	}

	public void setIdCoordenador(int idCoordenador) {
		this.idCoordenador = idCoordenador;
	}

	public boolean isUsuarioNucleo() {
		return usuarioNucleo;
	}

	public void setUsuarioNucleo(boolean usuarioNucleo) {
		this.usuarioNucleo = usuarioNucleo;
	}

}