package br.com.setebit.sgr.security.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ieadam_usuario_nucleo")
public class UsuarioNucleo implements Serializable {

	private static final long serialVersionUID = -6455533571538685292L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario_nucleo")
	private int idUsuarioNucleo;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_nucleo")
	private Nucleo nucleo;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getIdUsuarioNucleo() {
		return idUsuarioNucleo;
	}

	public void setIdUsuarioNucleo(int idUsuarioNucleo) {
		this.idUsuarioNucleo = idUsuarioNucleo;
	}

	public Nucleo getNucleo() {
		return nucleo;
	}

	public void setNucleo(Nucleo nucleo) {
		this.nucleo = nucleo;
	}

}