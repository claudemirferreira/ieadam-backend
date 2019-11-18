package br.com.setebit.sgr.util;

/**
 * Classe utilitaria usada para uso geral
 * @author Elimarcos Arouca
 *
 */
public class IEADAMUtils {

	private static String meses[] = {
		"JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ"
	};
	
	/**
	 * Metodo responsavel por retornar o prefixo de um determinado mes atraves de um indice
	 * @param indice
	 * @return
	 */
	public static String getMesByIndice(int indice) {
		if (indice < 12)
			return meses[indice];
		return meses[0];			
	}
}
