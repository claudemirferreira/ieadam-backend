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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "ieadam_area")
public class Area implements Serializable {

	private static final long serialVersionUID = -6455533571538685292L;

	@Id
	@Column(name = "id_area")
	private int idArea;

	@Column(name = "id_pastor")
	private int idPastor;

	@Column(length = 60, nullable = false)
	private String nome;

	@Column(name = "situacao", length = 1, columnDefinition = "CHAR(1)", nullable = false)
	private String situacao;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_ultima_atualizacao")
	private Date dataUltimaAtualizacao;

	@ManyToOne
	@JoinColumn(name = "id_nucleo")
	@JsonBackReference
	private Nucleo nucleo;

	@Transient
	private boolean usuarioArea;
	
	public Area() {
		
	}

	public Area(int idArea) {
		super();
		this.idArea = idArea;
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public int getIdPastor() {
		return idPastor;
	}

	public void setIdPastor(int idPastor) {
		this.idPastor = idPastor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	public Nucleo getNucleo() {
		return nucleo;
	}

	public void setNucleo(Nucleo nucleo) {
		this.nucleo = nucleo;
	}

	public boolean isUsuarioArea() {
		return usuarioArea;
	}

	public void setUsuarioArea(boolean usuarioArea) {
		this.usuarioArea = usuarioArea;
	}

}