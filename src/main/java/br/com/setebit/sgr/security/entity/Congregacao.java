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

@Entity
@Table(name = "ieadam_congregacao")
public class Congregacao implements Serializable {

	private static final long serialVersionUID = 7686113032375136921L;

	@Id
	@Column(name = "id_congregacao")
	private int idCongregacao;

	private String cidade;

	@ManyToOne
	@JoinColumn(name = "id_area")
	private Area area;
	
//	@Column
//	private int idArea;

	@Column(length = 60, nullable = false)
	private String bairro;

	@Temporal(TemporalType.DATE)
	private Date dataFundacao;

	@Column(length = 60, nullable = false)
	private String nome;

	@Column(length = 60, nullable = false)
	private String endereco;

	@Column(length = 8)
	private String cep;

	@Column(length = 30)
	private String telefone;

	@Column(name = "situacao", length = 1, columnDefinition = "CHAR(1)", nullable = false)
	private String situacao;

	@Temporal(TemporalType.DATE)
	private Date dataUltimaAtualizacao;

	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	public int getIdCongregacao() {
		return idCongregacao;
	}

	public void setIdCongregacao(int idCongregacao) {
		this.idCongregacao = idCongregacao;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

//	public int getIdArea() {
//		return idArea;
//	}
//
//	public void setIdArea(int idArea) {
//		this.idArea = idArea;
//	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}