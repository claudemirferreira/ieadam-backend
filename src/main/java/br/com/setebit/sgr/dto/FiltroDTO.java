package br.com.setebit.sgr.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.setebit.sgr.util.IEADAMUtils;

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
	private int idMembro;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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

	public int getIdMembro() {
		return idMembro;
	}

	public void setIdMembro(int idMembro) {
		this.idMembro = idMembro;
	}

	public String getDataMesAnoInicio() {
		try {
			Calendar dataMesAnoInicio = new GregorianCalendar(Integer.parseInt(getAnoInicio()), getMesInicio().getId(),
					1);
			return dateFormat.format(dataMesAnoInicio.getTime());

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public String getDataMesAnoFim() {
		try {
			Calendar dataMesAnoFim = new GregorianCalendar(Integer.parseInt(getAnoFim()), getMesFim().getId(), 1);
			return dateFormat.format(dataMesAnoFim.getTime());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public String getMesAnoInicio() {
		try {
			return IEADAMUtils.getMesByIndice(getMesInicio().getId()) + "/" + getDataAno();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public String getMesAno() {
		try {
			return IEADAMUtils.getMesByIndice(getMesInicio().getId()) + "/" + getDataAno();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public String getMesAnoFim() {
		try {
			return IEADAMUtils.getMesByIndice(getMesFim().getId()) + "/" + getAnoFim();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public String getMesAnoString() {
		try {
			return IEADAMUtils.getMesByIndice(getMesInicio().getId()) + "/" + getAno();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public String getDataAno() {
		try {
			Calendar dataAno = new GregorianCalendar(Integer.parseInt(getAno()), getMesInicio().getId(), 1);
			return dateFormat.format(dataAno.getTime());

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	public String toString() {
		if (zona == null)
			zona = new ZonaDTO();
		if (nucleo == null)
			nucleo = new NucleoDTO();
		if (area == null)
			area = new AreaDTO();
		
		return "========================================================"
				+ "\n DATA_MES_ANO = " + getDataAno() 
				+ "\n DATA_MES_ANO_INICIO = " + getDataMesAnoInicio()
				+ "\n DATA_MES_ANO_FIM = " + getDataMesAnoFim()
				+ "\n MES_ANO_INICIO = " + getMesAnoInicio()
				+ "\n MES_ANO_FIM = " + getMesAnoFim()
				+ "\n MES_ANO = " + getMesAno()
				+ "\n DATA_ANO = " + getAno()
				+ "\n ZONA =" + zona.getId() 
				+ "\n NUCLEO=" + nucleo.getId() 
				+ "\n AREA="	+ area.getId() 
				+ "\n NOME=" + nomeRelatorio;
		//CALL proc_rel_fin_proventos_pastoral ($P{DATA_MES_ANO}, $P{ZONA} , $P{NUCLEO} , $P{AREA}, 0);
	}

}