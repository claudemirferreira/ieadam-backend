package br.com.setebit.sgr.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "view_perfil_rotina")
@Immutable
public class ViewPerfilRotina {

	@Id
	@Column(name = "id_rotina")
	private int idRotina;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(name = "id_perfil")
	private int idPerfil;

	public int getIdRotina() {
		return idRotina;
	}

	public void setIdRotina(int idRotina) {
		this.idRotina = idRotina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

}
