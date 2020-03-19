package br.com.setebit.sgr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.setebit.sgr.security.entity.Perfil;
import br.com.setebit.sgr.security.entity.Rotina;
import br.com.setebit.sgr.security.entity.Sistema;

@Repository
public interface RotinaRepositorio extends JpaRepository<Rotina, Integer> {

	public final static String LISTAR_ROTINA_POR_PERFIL = "SELECT a "
			+ "FROM PerfilRotina p LEFT JOIN p.perfilRotinaPk.rotina a " + "WHERE p.perfilRotinaPk.perfil = :perfil";

	@Query(LISTAR_ROTINA_POR_PERFIL)
	public List<Rotina> findByPerfil(@Param("perfil") Perfil perfil);

	@Query("select r from Rotina r where r.nome like :nome")
	public List<Rotina> findByNomeLike(@Param("nome") String nome);

	@Query("select u from Rotina u where u.sistema = :sistema")
	public List<Rotina> findBySistema(@Param("sistema") Sistema sistema);

	@Query("select u from Rotina u where u.sistema = :sistema and u.nome like :nome")
	public List<Rotina> findBySistemaByNomeLike(@Param("sistema") Sistema sistema, @Param("nome") String nome);
	
	@Query(value = "select a.* from saa_rotina a, saa_perfil_rotina b \n" + 
			" where a.id_rotina = b.id_rotina \n" + 
			" and b.id_perfil = :idPerfil", nativeQuery = true)
	public List<Rotina> listarRotinaPorPerfil(@Param("idPerfil") Integer idPerfil);

}