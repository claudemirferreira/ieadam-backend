package br.com.setebit.sgr.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.setebit.sgr.dto.LogDTO;
import br.com.setebit.sgr.security.entity.LogApp;

@SuppressWarnings("unchecked")
@Repository
public class LogAppRepositorioSqlImpl extends RepositorioGenerico implements LogAppRepositorioSql {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<LogApp> listarLogByFiltros(LogDTO dto) {

		StringBuilder sb = new StringBuilder();
		List<String> condictions = new ArrayList<String>();

		sb.append("select l from LogApp l, Usuario u ");

		if (notEmpty(dto.getNomeUsuario()) || notEmpty(dto.getDataInicio())) {

			condictions.add("l.usuario.id = u.id ");

			if (notEmpty(dto.getNomeUsuario())) {
				condictions.add("u.nome like :usuario ");
			}

			if (notEmpty(dto.getDataInicio())) {
				condictions.add("l.dataHoraAcao between :dataInicio and :dataFim ");
			}
		}

		String orderBy = "order by l.dataHoraAcao ";

		Query query = entityManager.createQuery(generateHql(sb.toString(), condictions) + orderBy);

		if (notEmpty(dto.getNomeUsuario())) {
			if (notEmpty(dto.getNomeUsuario())) {
				query.setParameter("usuario", dto.getNomeUsuario() + "%");
			}
		}

		if (notEmpty(dto.getDataInicio())) {
			query.setParameter("dataInicio", dto.getDataInicio());

			if (notEmpty(dto.getDataFim())) {
				query.setParameter("dataFim", dto.getDataFim());
			} else {
				query.setParameter("dataFim", new Date());
			}

		}

		return query.getResultList();
	}

}