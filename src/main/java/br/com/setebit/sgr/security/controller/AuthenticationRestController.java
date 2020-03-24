package br.com.setebit.sgr.security.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.setebit.sgr.dto.UsuarioDTO;
import br.com.setebit.sgr.security.jwt.JwtAuthenticationRequest;
import br.com.setebit.sgr.security.jwt.JwtTokenUtil;
import br.com.setebit.sgr.security.model.CurrentUser;
import br.com.setebit.sgr.service.UsuarioServico;

@RestController
@CrossOrigin(origins = "*")
public class AuthenticationRestController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private UsuarioServico usuarioService;

	@PostMapping(value = "/api/auth")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest)
			throws AuthenticationException {

		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getLogin(),
						authenticationRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getLogin());
		final String token = jwtTokenUtil.generateToken(userDetails);
		final UsuarioDTO user = UsuarioDTO.getDTO(usuarioService.findByEmail(authenticationRequest.getLogin()));
		user.setSenha(null);
		return ResponseEntity.ok(new CurrentUser(token, user));
	}

	@PostMapping(value = "/api/refresh")
	public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		String username = jwtTokenUtil.getUsernameFromToken(token);
		final UsuarioDTO user = UsuarioDTO.toDTO(usuarioService.findByEmail(username));

		if (jwtTokenUtil.canTokenBeRefreshed(token)) {
			String refreshedToken = jwtTokenUtil.refreshToken(token);
			return ResponseEntity.ok(new CurrentUser(refreshedToken, user));
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}

}