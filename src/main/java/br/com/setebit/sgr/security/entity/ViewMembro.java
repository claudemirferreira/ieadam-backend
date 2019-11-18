package br.com.setebit.sgr.security.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "view_membro")
@Immutable
public class ViewMembro {

	@Id
	@Column(name = "id_membro")
	private int idMembro;

	@Column
	private String membro;
	
	@Column(name = "id_area")
	private Integer idArea;

	@Column
	private String area;
	
	@Column(name = "id_nucleo")
	private Integer idNucleo;

	@Column
	private String nucleo;

	@Column(name = "id_zona")
	private Integer idZona;

	@Column
	private String zona;
	
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	
	@Column
	private String congregacao;

	@Column
	private String situacao;

	@Column
	private char sexo;
	
	@Column
	private String nacionalidade;
	
	@Column
	private String cidade;

	@Column(name = "nome_pai")
	private String nomePai;
	
	@Column(name = "nome_mae")
	private String nomeMae;
	
	@Column(name = "estado_civil")
	private String estadoCivil;

	@Column
	private String conjuge;

	@Column(name = "data_cadastro")
	private Date dataCadastro;
	
	@Column(name = "data_batismo")
	private Date dataBatismo;

	@Column
	private String funcao;
	
	private int registro;
	
	public int getIdMembro() {
		return idMembro;
	}

	public void setIdMembro(int idMembro) {
		this.idMembro = idMembro;
	}

	public String getMembro() {
		return membro;
	}

	public void setMembro(String membro) {
		this.membro = membro;
	}

	public Integer getIdArea() {
		return idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getIdNucleo() {
		return idNucleo;
	}

	public void setIdNucleo(Integer idNucleo) {
		this.idNucleo = idNucleo;
	}

	public String getNucleo() {
		return nucleo;
	}

	public void setNucleo(String nucleo) {
		this.nucleo = nucleo;
	}

	public Integer getIdZona() {
		return idZona;
	}

	public void setIdZona(Integer idZona) {
		this.idZona = idZona;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCongregacao() {
		return congregacao;
	}

	public void setCongregacao(String congregacao) {
		this.congregacao = congregacao;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

//	public String getEscolaridade() {
//		return escolaridade;
//	}
//
//	public void setEscolaridade(String escolaridade) {
//		this.escolaridade = escolaridade;
//	}
//
//	public String getProfissao() {
//		return profissao;
//	}
//
//	public void setProfissao(String profissao) {
//		this.profissao = profissao;
//	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getConjuge() {
		return conjuge;
	}

	public void setConjuge(String conjuge) {
		this.conjuge = conjuge;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataBatismo() {
		return dataBatismo;
	}

	public void setDataBatismo(Date dataBatismo) {
		this.dataBatismo = dataBatismo;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public int getRegistro() {
		return registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}
}