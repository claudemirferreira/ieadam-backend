package br.com.setebit.sgr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.setebit.sgr.security.entity.PerfilRotina;

@Repository
public interface PerfilRotinaRepositorio extends JpaRepository<PerfilRotina, Long> {

}