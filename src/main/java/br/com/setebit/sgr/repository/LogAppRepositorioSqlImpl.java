package br.com.setebit.sgr.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.setebit.sgr.security.entity.LogApp;

@SuppressWarnings("unchecked")
@Repository
public class LogAppRepositorioSqlImpl extends RepositorioGenerico implements LogAppRepositorioSql {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<LogApp> listarLogByFiltros(String nomeUsuario, Date dataInicio, Date dataFim) {

		StringBuilder sb = new StringBuilder();
		List<String> condictions = new ArrayList<String>();

		sb.append("select l from LogApp l, Usuario u ");

		if (notEmpty(nomeUsuario) || notEmpty(dataInicio)) {

			condictions.add("l.usuario.idUsuario = u.idUsuario ");

			if (notEmpty(nomeUsuario)) {
				condictions.add("u.nome like :usuario ");
			}

			if (notEmpty(dataInicio)) {
				condictions.add("l.dataHoraAcao between :dataInicio and :dataFim ");
			}
		}

		String orderBy = "order by l.dataHoraAcao ";

		Query query = entityManager.createQuery(generateHql(sb.toString(), condictions) + orderBy);

		if (notEmpty(nomeUsuario)) {
			if (notEmpty(nomeUsuario)) {
				query.setParameter("usuario", nomeUsuario + "%");
			}
		}

		if (notEmpty(dataInicio)) {
			query.setParameter("dataInicio", dataInicio);

			if (notEmpty(dataFim)) {
				query.setParameter("dataFim", dataFim);
			} else {
				query.setParameter("dataFim", new Date());
			}

		}

		return query.getResultList();
	}

}