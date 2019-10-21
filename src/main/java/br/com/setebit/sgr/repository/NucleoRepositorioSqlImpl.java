package br.com.setebit.sgr.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.setebit.sgr.security.entity.Nucleo;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.Zona;

@Repository
public class NucleoRepositorioSqlImpl implements NucleoRepositorioSql {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Nucleo> listaNucleoUsuario(Usuario usuario) {

		String SQL1 = "select DISTINCT R.* from "
				+ " (select b.* from ieadam_usuario_nucleo a, ieadam_nucleo b, ieadam_area c "
				+ " where b.id_nucleo = a.id_nucleo and b.id_nucleo = c.id_nucleo and " + " a.id_usuario = "
				+ usuario.getId();

		String SQL2 = " union select b.* from ieadam_area a, ieadam_usuario_area a1, ieadam_nucleo b  "
				+ "	where a.id_area = a1.id_area and b.id_nucleo = a.id_nucleo and " + " a1.id_usuario = "
				+ usuario.getId() + ") AS R;";

		String SQL = SQL1 + SQL2;
		System.out.println("=========== inicio listaNucleoUsuario ============= ");
		System.out.println(SQL);
		System.out.println("=========== fim listaNucleoUsuario ============= ");
		return entityManager.createNativeQuery(SQL, Nucleo.class).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Nucleo> listaNucleoPorArea(Usuario usuario) {

		String SQL1 = "select DISTINCT R.* from "
				+ "(select b.* from ieadam_usuario_nucleo a, ieadam_nucleo b, ieadam_area c "
				+ " where b.id_nucleo = a.id_nucleo and b.id_nucleo = c.id_nucleo " + " and a.id_usuario = "
				+ usuario.getId();

		String SQL2 = " union select b.* from ieadam_area a, ieadam_nucleo b, ieadam_usuario_nucleo c "
				+ " where a.id_nucleo = b.id_nucleo and c.id_nucleo = b.id_nucleo " + " and c.id_usuario = "
				+ usuario.getId() + ") AS R;";

		String SQL = SQL1 + SQL2;
		System.out.println("=========== inicio listaNucleoUsuario ============= ");
		System.out.println(SQL);
		System.out.println("=========== fim listaNucleoUsuario ============= ");
		return entityManager.createNativeQuery(SQL, Nucleo.class).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Nucleo> listaNucleoToUsuarioAndZona(int idUsuario, int idZona) {

		String SQL;

		String SQL1 = "select DISTINCT R.* from ( "
				+ " select b.* from ieadam_nucleo b,  ieadam_usuario_nucleo c, ieadam_zona d "
				+ " where b.id_nucleo = c.id_nucleo and b.id_zona = d.id_zona " + " and c.id_usuario = "
				+ idUsuario + " and d.id_zona = " + idZona;

		String SQL2 = " union select c.* from ieadam_usuario_area a, ieadam_area b, ieadam_nucleo c	"
				+ " where a.id_area = b.id_area and c.id_nucleo = b.id_nucleo " + " and a.id_usuario = "
				+ idUsuario + " and c.id_zona = " + idZona + " ) as R; ";

		SQL = SQL1 + SQL2;

		System.out.println("=========== inicio listaNucleoToUsuarioAndZona ============= ");
		System.out.println(SQL);
		System.out.println("=========== fim listaNucleoToUsuarioAndZona ============= ");

		return entityManager.createNativeQuery(SQL, Nucleo.class).getResultList();

	}

	@Override
	public boolean isUsuarioDeNucleo(int usuarioId, int idNucleo) {
		String SQL = "	select a.* from ieadam_nucleo a, ieadam_usuario_nucleo b" + " where a.id_nucleo = b.id_nucleo "
				+ " and b.id_nucleo = " + idNucleo + " and b.id_usuario = " + usuarioId;

		System.out.println("===== inicio isUsuarioDeNucleo ====== ");
		System.out.println(SQL);
		System.out.println("===== fim isUsuarioDeNucleo ====== ");

		@SuppressWarnings("unchecked")
		List<Nucleo> nucleos = entityManager.createNativeQuery(SQL, Nucleo.class).getResultList();

		if (nucleos.size() > 0)
			return true;
		else
			return false;

	}

}