package br.com.setebit.sgr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MesDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String nome;

	public MesDto(int id, String nome) {
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
	
	public static List<MesDto> pegarMeses() {
		List<MesDto> lista = new ArrayList<MesDto>();
		lista.add(new MesDto(0,"Janeiro"));
		lista.add(new MesDto(1,"Fevereiro"));
		lista.add(new MesDto(2,"Marco"));
		lista.add(new MesDto(3,"Abril"));
		lista.add(new MesDto(4,"Maio"));
		lista.add(new MesDto(5,"Junho"));
		lista.add(new MesDto(6,"Julho"));
		lista.add(new MesDto(7,"Agosto"));
		lista.add(new MesDto(8,"Setembro"));
		lista.add(new MesDto(9,"Outubro"));
		lista.add(new MesDto(10,"Novembro"));
		lista.add(new MesDto(11,"Dezembro"));
		
		return lista;		
	}

}