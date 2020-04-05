package br.com.setebit.sgr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.UsuarioZona;
import br.com.setebit.sgr.security.entity.Zona;

public interface UsuarioZonaRepositorio extends JpaRepository<UsuarioZona, Integer> {

	@Query("select a from UsuarioZona a where a.usuario = :usuario and  a.zona = :zona order by a.zona.nome")
	public UsuarioZona findByUsuarioAndByZona(@Param("usuario") Usuario usuario, @Param("zona") Zona zona);

	@Modifying
	@Transactional
	@Query("delete from UsuarioZona a where a.usuario = :usuario and  a.zona = :zona")
	void deleteByUsuarioAndByZona(@Param("usuario") Usuario usuario, @Param("zona") Zona zona);

	@Query("select a from UsuarioZona a where a.usuario = :usuario")
	List<UsuarioZona> findByUsuario(@Param("usuario") Usuario usuario);

	@Query(value = "SELECT * FROM ieadam_usuario_zona a WHERE a.id_usuario = :idUsuario and id_zona = :idZona order by a.zona.nome", nativeQuery = true)
	public UsuarioZona findByUsuarioAndByZona(@Param("idUsuario") Integer idUsuario, @Param("idZona") Integer idZona);

}