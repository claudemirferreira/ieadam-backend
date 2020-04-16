package br.com.setebit.sgr.security.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author altitdb
 */
@Entity
@Table(name = "saa_perfil")
public class Perfil implements Serializable {

	private static final long serialVersionUID = 7371241296081749393L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_perfil")
	private Integer id;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioPerfilPk.perfil")
	private List<UsuarioPerfil> usuarioPerfil = new ArrayList<UsuarioPerfil>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfilRotinaPk.perfil")
	private List<PerfilRotina> perfilRotina = new ArrayList<PerfilRotina>();

	@Column(length = 30, nullable = false)
	private String nome;

	@Column(length = 60, nullable = false)
	private String imagem;

	@ManyToOne
	@JoinColumn(name = "id_sistema")
	private Sistema sistema;

	public Perfil() {}

	public Perfil(Integer idPerfil) {
		this.id = idPerfil;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<UsuarioPerfil> getUsuarioPerfil() {
		return usuarioPerfil;
	}

	public void setUsuarioPerfil(List<UsuarioPerfil> usuarioPerfil) {
		this.usuarioPerfil = usuarioPerfil;
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

	public List<PerfilRotina> getPerfilRotina() {
		return perfilRotina;
	}

	public void setPerfilRotina(List<PerfilRotina> perfilRotina) {
		this.perfilRotina = perfilRotina;
	}

	public Perfil(Integer id, String nome, String imagem, Sistema sistema) {
		this.id = id;
		this.nome = nome;
		this.imagem = imagem;
		this.sistema = sistema;
	}

}