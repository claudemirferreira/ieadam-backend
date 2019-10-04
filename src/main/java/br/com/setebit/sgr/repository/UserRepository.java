package br.com.setebit.sgr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.setebit.sgr.security.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}