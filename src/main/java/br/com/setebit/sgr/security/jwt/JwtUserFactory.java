package br.com.setebit.sgr.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.setebit.sgr.security.entity.Usuario;

public class JwtUserFactory {

	private JwtUserFactory() {
	}

	public static JwtUser create(Usuario usuario) {
		JwtUser u = new JwtUser(String.valueOf(usuario.getId()), usuario.getLogin(), usuario.getSenha(),
				mapToGrantedAuthorities());
		return u;
	}

	private static List<GrantedAuthority> mapToGrantedAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("admin"));
		return authorities;
	}

}