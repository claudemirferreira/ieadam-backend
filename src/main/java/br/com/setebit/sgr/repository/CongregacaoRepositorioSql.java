package br.com.setebit.sgr.repository;

import java.util.List;

import br.com.setebit.sgr.security.entity.Congregacao;
import br.com.setebit.sgr.security.entity.Zona;

public interface CongregacaoRepositorioSql {

	public List<Congregacao> listaCongregacaoToZona(Zona zona);

}