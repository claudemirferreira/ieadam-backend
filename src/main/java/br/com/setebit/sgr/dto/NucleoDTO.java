package br.com.setebit.sgr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.setebit.sgr.security.entity.Zona;

public class NucleoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String nome;

	public NucleoDTO() {
	}

	public NucleoDTO(int id, String nome) {
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

	public static NucleoDTO toDTO(Zona entity) {
		return new NucleoDTO(entity.getIdZona(), entity.getNome());
	}

	public static List<NucleoDTO> toDTO(List<Zona> list) {
		List<NucleoDTO> dtos = new ArrayList<NucleoDTO>();
		list.forEach(item -> dtos.add(toDTO(item)));
		return dtos;
	}

}