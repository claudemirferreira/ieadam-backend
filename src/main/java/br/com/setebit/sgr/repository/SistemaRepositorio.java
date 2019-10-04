package br.com.setebit.sgr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.setebit.sgr.security.entity.Sistema;

@Repository
public interface SistemaRepositorio extends JpaRepository<Sistema, Integer> {

	@Query("select r from Sistema r where r.nome like :nome")
	public List<Sistema> findByNomeLike(@Param("nome") String nome);

	@Query("select r from Sistema r where r.codigo = :codigo")
	public Sistema findByCodigo(@Param("codigo") String codigo);

}