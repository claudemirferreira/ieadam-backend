package br.com.setebit.sgr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.setebit.sgr.security.entity.Perfil;

public class PerfilDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String nome;
	
	private List<RotinaDTO> rotinas = new ArrayList<RotinaDTO>();

	public PerfilDTO() {
	}

	public PerfilDTO(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

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

	public List<RotinaDTO> getRotinas() {
		return rotinas;
	}

	public void setRotinas(List<RotinaDTO> rotinas) {
		this.rotinas = rotinas;
	}

	public static PerfilDTO toDTO(Perfil entity) {
		return new PerfilDTO(entity.getId(), entity.getNome());
	}

	public static List<PerfilDTO> toDTO(List<Perfil> list) {
		List<PerfilDTO> dtos = new ArrayList<PerfilDTO>();
		list.forEach(item -> dtos.add(toDTO(item)));
		return dtos;
	}

}