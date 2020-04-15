package br.com.setebit.sgr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.setebit.sgr.security.entity.Perfil;
import br.com.setebit.sgr.security.entity.Sistema;

@Repository
public interface PerfilRepositorio extends JpaRepository<Perfil, Integer> {

	@Query("select r from Perfil r where r.nome like :nome")
	public List<Perfil> findByNomeLike(@Param("nome") String nome);

	@Query("select r from Perfil r where r.sistema = :sistema")
	public List<Perfil> findBySistema(@Param("sistema") Sistema sistema);

	@Query(value = "select a.* \n" + 
			"from   saa_perfil a, saa_usuario_perfil b \n" + 
			"where  a.id_perfil = b.id_perfil \n" + 
			"and    b.id_usuario = :idUsuario \n" + 
			"and    a.id_sistema = :idSistema", nativeQuery = true)
	public List<Perfil> listarPerfilUsuario( @Param("idSistema") Integer idSistema, @Param("idUsuario") Integer idUsuario);

	@Query("select u from Rotina u where u.sistema = :sistema and u.nome like :nome")
	public List<Perfil> findBySistemaByNomeLike(@Param("sistema") Sistema sistema, @Param("nome") String nome);

}