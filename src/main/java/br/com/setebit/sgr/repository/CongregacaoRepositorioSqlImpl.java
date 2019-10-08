package br.com.setebit.sgr.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.setebit.sgr.security.entity.Congregacao;
import br.com.setebit.sgr.security.entity.Zona;

@Repository
public class CongregacaoRepositorioSqlImpl implements CongregacaoRepositorioSql {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<Congregacao> listaCongregacaoToZona(Zona zona) {

		String SQL = "select d.* from sgr.ieadam_area a, sgr.ieadam_nucleo b, "
				+ "sgr.ieadam_zona c, sgr.ieadam_congregacao d "
				+ "where a.id_nucleo = b.id_nucleo and b.id_zona = c.id_zona "
				+ "and d.id_area = a.id_area and c.id_zona = " + zona.getIdZona();

		return entityManager.createNativeQuery(SQL, Congregacao.class).getResultList();
	}
}