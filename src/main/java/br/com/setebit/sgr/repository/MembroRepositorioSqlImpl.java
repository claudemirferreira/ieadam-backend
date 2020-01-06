package br.com.setebit.sgr.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.setebit.sgr.dto.FiltroDTO;
import br.com.setebit.sgr.security.entity.ViewMembro;

@SuppressWarnings("unchecked")
@Repository
public class MembroRepositorioSqlImpl extends RepositorioGenerico implements MembroRepositorioSql {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ViewMembro> listarMembrosByFiltros(FiltroDTO filtroDTO) {

		StringBuilder sb = new StringBuilder();
		List<String> condictions = new ArrayList<String>();

		sb.append(" select vm from ViewMembro vm ");
		if (notEmpty(filtroDTO)) {
			if (notEmpty(filtroDTO.getMembro())) {
				condictions.add(" vm.membro  like :membro ");
			}
			if (notEmpty(filtroDTO.getArea().getId()) && filtroDTO.getArea().getId() >= 0) {
				condictions.add(" vm.idArea = :idArea ");
			}
			if (notEmpty(filtroDTO.getNucleo().getId()) && filtroDTO.getNucleo().getId() > 0) {
				condictions.add(" vm.idNucleo = :idNucleo ");
			}
			if (notEmpty(filtroDTO.getZona().getId()) && filtroDTO.getZona().getId() > 0) {
				condictions.add(" vm.idZona = :idZona ");
			}
		}

		String orderBy = " order by vm.membro ";

		Query query = entityManager.createQuery(generateHql(sb.toString(), condictions) + orderBy);

		if (notEmpty(filtroDTO)) {
			if (notEmpty(filtroDTO.getMembro())) {
				query.setParameter("membro", filtroDTO.getMembro() + "%");
			}
			if (notEmpty(filtroDTO.getArea().getId()) && filtroDTO.getArea().getId() >= 0) {
				query.setParameter("idArea", filtroDTO.getArea().getId());
			}
			if (notEmpty(filtroDTO.getNucleo().getId()) && filtroDTO.getNucleo().getId() > 0) {
				query.setParameter("idNucleo", filtroDTO.getNucleo().getId());
			}
			if (notEmpty(filtroDTO.getZona().getId()) && filtroDTO.getZona().getId() > 0) {
				query.setParameter("idZona", filtroDTO.getZona().getId());
			}
		}

		System.out.println("pesquisa de membros =========");
		System.out.println("membro = " + filtroDTO.getMembro() + "%");
		System.out.println("idArea = " + filtroDTO.getArea().getId());
		System.out.println("idNucleo = " + filtroDTO.getNucleo().getId());
		System.out.println("idZona = " + filtroDTO.getZona().getId());
		
		return query.getResultList();
	}
	
	public ViewMembro findById(int idMembro) {

		StringBuilder sb = new StringBuilder();
		List<String> condictions = new ArrayList<String>();

		sb.append(" select vm from ViewMembro vm ");
		condictions.add(" vm.idMembro = :idMembro ");

		String orderBy = " order by vm.membro ";

		Query query = entityManager.createQuery(generateHql(sb.toString(), condictions) + orderBy);

		query.setParameter("idMembro", idMembro);

		System.out.println("pesquisa de membros =========");
		
		return (ViewMembro) query.getSingleResult();
	}

}