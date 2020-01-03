package br.com.setebit.sgr.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.setebit.sgr.security.entity.ViewPerfilRotina;

@SuppressWarnings("unchecked")
@Repository
public class ViewPerfilRotinaRepositorioSqlImpl extends RepositorioGenerico implements ViewPerfilRotinaRepositorioSql {

	@PersistenceContext
	private EntityManager entityManager;

	public List<ViewPerfilRotina> listarRotinaPorPerfil(int idPerfil) {

		StringBuilder sb = new StringBuilder();
		List<String> condictions = new ArrayList<String>();

		sb.append(" select vm from ViewPerfilRotina vm ");

		String orderBy = " order by vm.nome ";

		//Query query = entityManager.createQuery(generateHql(sb.toString(), condictions) + orderBy);

		return null;//query.getResultList();
	}

}