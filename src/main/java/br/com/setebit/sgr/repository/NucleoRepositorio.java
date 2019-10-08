package br.com.setebit.sgr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.setebit.sgr.security.entity.Nucleo;

public interface NucleoRepositorio extends JpaRepository<Nucleo, Long> {

	@Query("select n from Nucleo n where n.zona.idZona = :zona")
	public List<Nucleo> findByZona(@Param("zona") int zona);

	@Query("select n from Nucleo n where n.idCoordenador = :membro")
	public List<Nucleo> findByMembro(@Param("membro") int membro);

	@Query("select n from Nucleo n where n.id = :id")
	public Nucleo findOne(@Param("id") int id);

}