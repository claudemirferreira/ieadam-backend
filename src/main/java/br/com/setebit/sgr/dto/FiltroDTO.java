package br.com.setebit.sgr.dto;

import java.io.Serializable;

public class FiltroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ano;
	private String anoFim;
	private String anoInicio;
	private ZonaDTO zona;
	private NucleoDTO nucleo;
	private AreaDTO area;
	private String nomeRelatorio;
	private String membro;
	private MesDto mes;
	private MesDto mesInicio;
	private MesDto mesFim;

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

	public String getMembro() {
		return membro;
	}

	public void setMembro(String membro) {
		this.membro = membro;
	}

	public String getAnoFim() {
		return anoFim;
	}

	public void setAnoFim(String anoFim) {
		this.anoFim = anoFim;
	}

	public String getAnoInicio() {
		return anoInicio;
	}

	public void setAnoInicio(String anoInicio) {
		this.anoInicio = anoInicio;
	}

	public MesDto getMesInicio() {
		return mesInicio;
	}

	public void setMesInicio(MesDto mesInicio) {
		this.mesInicio = mesInicio;
	}

	public MesDto getMesFim() {
		return mesFim;
	}

	public void setMesFim(MesDto mesFim) {
		this.mesFim = mesFim;
	}

	public MesDto getMes() {
		return mes;
	}

	public void setMes(MesDto mes) {
		this.mes = mes;
	}

	public String toString() {
		return "ano = " + ano + "; zona.getId=" + zona.getId() + "; nucleo.getId=" + nucleo.getId() + "; area.getId="
				+ area.getId() + "; nome=" + nomeRelatorio;
	}

}