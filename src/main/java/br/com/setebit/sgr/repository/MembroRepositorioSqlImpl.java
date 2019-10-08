package br.com.setebit.sgr.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.setebit.sgr.security.entity.ViewMembro;

@SuppressWarnings("unchecked")
@Repository
public class MembroRepositorioSqlImpl extends RepositorioGenerico implements MembroRepositorioSql {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ViewMembro> listarMembrosByFiltros(ViewMembro viewMembro) {

		StringBuilder sb = new StringBuilder();
		List<String> condictions = new ArrayList<String>();

		sb.append(" select vm from ViewMembro vm ");
		if (notEmpty(viewMembro)) {
			if (notEmpty(viewMembro.getMembro())) {
				condictions.add(" vm.membro  like :membro ");
			}
			if (notEmpty(viewMembro.getIdArea()) && viewMembro.getIdArea() >= 0) {
				condictions.add(" vm.idArea = :idArea ");
			}
			if (notEmpty(viewMembro.getIdNucleo()) && viewMembro.getIdNucleo() >= 0) {
				condictions.add(" vm.idNucleo = :idNucleo ");
			}
			if (notEmpty(viewMembro.getIdZona()) && viewMembro.getIdZona() >= 0) {
				condictions.add(" vm.idZona = :idZona ");
			}
		}

		String orderBy = " order by vm.membro ";

		Query query = entityManager.createQuery(generateHql(sb.toString(), condictions) + orderBy);

		if (notEmpty(viewMembro)) {
			if (notEmpty(viewMembro.getMembro())) {
				query.setParameter("membro", viewMembro.getMembro() + "%");
			}
			if (notEmpty(viewMembro.getIdArea()) && viewMembro.getIdArea() >= 0) {
				query.setParameter("idArea", viewMembro.getIdArea());
			}
			if (notEmpty(viewMembro.getIdNucleo()) && viewMembro.getIdNucleo() >= 0) {
				query.setParameter("idNucleo", viewMembro.getIdNucleo());
			}
			if (notEmpty(viewMembro.getIdZona()) && viewMembro.getIdZona() >= 0) {
				query.setParameter("idZona", viewMembro.getIdZona());
			}
		}

		return query.getResultList();
	}

}