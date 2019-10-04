package br.com.setebit.sgr.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.setebit.sgr.security.entity.Perfil;

@Repository
public class UsuarioPerfilRepositorioSqlImpl implements UsuarioPerfilRepositorioSql {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Perfil> listaPerfilNotInUsuario(int idUsuario) {
		return entityManager.createNativeQuery(
				"select p.* from saa_perfil p " + "where p.id_perfil not in ( "
						+ "select id_perfil from saa_usuario_perfil up " + "where up.id_usuario = " + idUsuario + ")",
				Perfil.class).getResultList();

	}
}