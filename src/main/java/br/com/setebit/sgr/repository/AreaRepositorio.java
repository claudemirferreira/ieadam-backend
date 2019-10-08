package br.com.setebit.sgr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.setebit.sgr.security.entity.Area;

public interface AreaRepositorio extends JpaRepository<Area, Long> {

	@Query("select a from Area a where a.nucleo.id = :nucleo")
	public List<Area> findByNucleo(@Param("nucleo") int nucleo);

	@Query("select a from Area a where a.idPastor = :membro")
	public List<Area> findByMembro(@Param("membro") int membro);
	
	@Query("select a from Area a where a.idPastor = :membro and a.nucleo.id = :idNucleo")
	public List<Area> findByMembroAndNucleo(@Param("membro") int membro, @Param("idNucleo") int idNucleo);
}