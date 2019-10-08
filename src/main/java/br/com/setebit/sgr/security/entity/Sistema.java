package br.com.setebit.sgr.security.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the saa_sistema database table.
 * 
 */
@Entity
@Table(name = "saa_sistema")
public class Sistema implements Serializable {

	private static final long serialVersionUID = -1348896933495695497L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sistema")
	private int id;

	@Column(length = 6, nullable = false, unique = true)
	private String codigo;

	@Column(length = 200, nullable = false)
	private String descricao;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(length = 100, nullable = false)
	private String imagem;

	@OneToMany(mappedBy = "sistema")
	private List<Perfil> perfils;

	public Sistema() {
	}

	public Sistema(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public List<Perfil> getPerfils() {
		return this.perfils;
	}

	public void setPerfils(List<Perfil> perfils) {
		this.perfils = perfils;
	}

	public Perfil addPerfil(Perfil perfil) {
		getPerfils().add(perfil);
		perfil.setSistema(this);

		return perfil;
	}

	public Perfil removePerfil(Perfil perfil) {
		getPerfils().remove(perfil);
		perfil.setSistema(null);

		return perfil;
	}

}