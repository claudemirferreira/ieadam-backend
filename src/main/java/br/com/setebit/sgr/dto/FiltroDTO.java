package br.com.setebit.sgr.dto;

import java.io.Serializable;

public class FiltroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ano;
	private ZonaDTO zona;
	private NucleoDTO nucleo;
	private AreaDTO area;
	private String nomeRelatorio;

	public ZonaDTO getZona() {
		return zona;
	}

	public void setZona(ZonaDTO zona) {
		this.zona = zona;
	}

	public NucleoDTO getNucleo() {
		return nucleo;
	}

	public void setNucleo(NucleoDTO nucleo) {
		this.nucleo = nucleo;
	}

	public AreaDTO getArea() {
		return area;
	}

	public void setArea(AreaDTO area) {
		this.area = area;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getNomeRelatorio() {
		return nomeRelatorio;
	}

	public void setNomeRelatorio(String nomeRelatorio) {
		this.nomeRelatorio = nomeRelatorio;
	}

	public String toString() {
		return "ano = " + ano + "; zona.getId=" + zona.getId() + "; nucleo.getId=" + nucleo.getId() + "; area.getId="
				+ area.getId() + "; nome=" + nomeRelatorio;
	}

}