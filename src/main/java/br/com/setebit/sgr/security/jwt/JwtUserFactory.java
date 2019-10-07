package br.com.setebit.sgr.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.setebit.sgr.security.entity.User;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.enums.ProfileEnum;

public class JwtUserFactory {

	private JwtUserFactory() {
	}

	public static JwtUser create(User user) {
		return new JwtUser(user.getId().toString(), user.getEmail(), user.getPassword(),
				mapToGrantedAuthorities(user.getProfile()));
	}

	public static JwtUser create(Usuario usuario) {
		return new JwtUser(String.valueOf(usuario.getId()), usuario.getEmail(), usuario.getSenha(),
				mapToGrantedAuthorities(usuario.getProfile()));
	}

	private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
		return authorities;
	}
	
}