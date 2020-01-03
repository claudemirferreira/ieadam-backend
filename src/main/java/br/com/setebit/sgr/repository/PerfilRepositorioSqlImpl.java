package br.com.setebit.sgr.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.setebit.sgr.security.entity.Perfil;

@Repository
public class PerfilRepositorioSqlImpl implements PerfilRepositorioSql {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Perfil> listaPerfilPorSistemaPorUsuario(int sistemaId, int usuarioId) {
		return entityManager.createNativeQuery("SELECT distinct i.* FROM saa_perfil i, saa_usuario_perfil b "
				+ "where i.id_perfil = b.id_perfil and i.id_sistema = " + sistemaId + " and b.id_usuario =  "
				+ usuarioId, Perfil.class).getResultList();
	}
	
	public Perfil getPerfil(Long id) {
		return (Perfil) entityManager.createNativeQuery("SELECT distinct i.* FROM saa_perfil i  "
				+ "where i.id_perfil = " + id , Perfil.class).getSingleResult();
	}
}