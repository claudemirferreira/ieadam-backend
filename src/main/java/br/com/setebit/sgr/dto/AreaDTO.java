package br.com.setebit.sgr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.setebit.sgr.security.entity.Zona;


public class AreaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String nome;

	public AreaDTO() {
	}

	public AreaDTO(int id, String nome) {
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

	public static AreaDTO toDTO(Zona entity) {
		return new AreaDTO(entity.getIdZona(), entity.getNome());
	}

	public static List<AreaDTO> toDTO(List<Zona> list) {
		List<AreaDTO> dtos = new ArrayList<AreaDTO>();
		list.forEach(item -> dtos.add(toDTO(item)));
		return dtos;
	}

}