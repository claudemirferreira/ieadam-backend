package br.com.setebit.sgr.dto;

import java.io.Serializable;

public class ParametroRelatorioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String ano;
	private int idZona;
	private int idNucleo;
	private int idArea;
	private String nomeRelatorio;

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public int getIdZona() {
		return idZona;
	}

	public void setIdZona(int idZona) {
		this.idZona = idZona;
	}

	public int getIdNucleo() {
		return idNucleo;
	}

	public void setIdNucleo(int idNucleo) {
		this.idNucleo = idNucleo;
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public String getNomeRelatorio() {
		return nomeRelatorio;
	}

	public void setNomeRelatorio(String nomeRelatorio) {
		this.nomeRelatorio = nomeRelatorio;
	}
	
	public String toString() {
		return "ano = " + ano + "; idZona=" + idZona + "; idNucleo"+ idNucleo + "; idArea=" + idArea + "; nome=" + nomeRelatorio;
	}

}