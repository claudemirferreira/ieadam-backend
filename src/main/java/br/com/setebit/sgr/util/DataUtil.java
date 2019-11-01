package br.com.setebit.sgr.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.setebit.sgr.security.enums.Mes;

public class DataUtil {

	public static void main(String[] args) {
		pegarAnocorrente();
	}

	public static Mes pegarMescorrente() {
		Date data = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		Format format = new SimpleDateFormat("MM");

		return pegarMes(Integer.parseInt(format.format(c.getTime())));

	}

	public static int pegarAnocorrente() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		return year;
	}

	public static List<Integer> pegarAnos() {

		int anoCorrente = pegarAnocorrente();
		List<Integer> lista = new ArrayList<Integer>();

		for (int anoInicio = 2012; anoInicio <= anoCorrente; anoCorrente--) {
			lista.add(anoCorrente);
		}

		return lista;
	}

	private static Mes pegarMes(int mes) {

		if (mes == 1)
			return Mes.JANEIRO;
		else if (mes == 2)
			return Mes.FEVEREIRO;
		else if (mes == 3)
			return Mes.MARCO;
		else if (mes == 4)
			return Mes.ABRIL;
		else if (mes == 5)
			return Mes.MAIO;
		else if (mes == 6)
			return Mes.JUNHO;
		else if (mes == 7)
			return Mes.JULHO;
		else if (mes == 8)
			return Mes.AGOSTO;
		else if (mes == 9)
			return Mes.SETEMBRO;
		else if (mes == 10)
			return Mes.OUTUBRO;
		else if (mes == 11)
			return Mes.NOVEMBRO;
		else
			return Mes.DEZEMBRO;
	}

}