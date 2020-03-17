package br.com.setebit.sgr.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.setebit.sgr.security.entity.Zona;

@Repository
public class ZonaRepositorioSqlImpl implements ZonaRepositorioSql {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Zona> listaZonaUsuario(int usuarioId) {
		
		//TODO TESTE
		//String SQL = "select p.* from ieadam_usuario_zona z, ieadam_zona p where z.id_zona = p.id_zona and z.id_usuario = 1673 and p.id_zona = 1";

		
		String SQL1 = "select distinct r.* from " + " (select p.* from ieadam_usuario_zona z, ieadam_zona p "
				+ " where z.id_zona = p.id_zona and z.id_usuario = " + usuarioId;

		String SQL2 = " union select o.* from ieadam_usuario_nucleo n, ieadam_nucleo m, ieadam_zona o "
				+ " where m.id_nucleo = n.id_nucleo  and m.id_zona = o.id_zona and n.id_usuario = " + usuarioId;

		String SQL3 = " union "
				+ " select z.* from ieadam_usuario_area n, ieadam_area m, ieadam_nucleo o, ieadam_zona z "
				+ " where m.id_area = n.id_area and o.id_nucleo = m.id_nucleo "
				+ " and z.id_zona = o.id_zona and n.id_usuario = " + usuarioId + " ) as r;";

		String SQL = SQL1 + SQL2 + SQL3;
		
		System.out.println("=========== inicio listaZonaUsuario ============= ");
		System.out.println(SQL);
		System.out.println("=========== fim listaZonaUsuario ============= ");
		return entityManager.createNativeQuery(SQL, Zona.class).getResultList();

	}

	@Override
	public boolean isUsuarioDeZona(int usuarioId, int idZona) {

		String SQL = " select a.* from ieadam_zona a, ieadam_usuario_zona b " + " where a.id_zona = b.id_zona "
				+ " and b.id_zona = " + idZona + " and b.id_usuario = " + usuarioId;

		@SuppressWarnings("unchecked")
		List<Zona> zonas = entityManager.createNativeQuery(SQL, Zona.class).getResultList();

		if (zonas.size() > 0)
			return true;
		else
			return false;

	}
}