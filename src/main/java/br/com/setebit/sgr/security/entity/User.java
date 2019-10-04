package br.com.setebit.sgr.security.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import br.com.setebit.sgr.security.enums.ProfileEnum;

@Entity
@Table(name = "saa_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1869155013000688801L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_Sequence")
	@SequenceGenerator(name = "user_Sequence", sequenceName = "user_Sequence")
	@Column(name = "user_id")
	private Long id;

	@NotBlank(message = "Email required")
	@Email(message = "Email invalid")
	private String email;

	@NotBlank(message = "Password required")
	@Size(min = 6)
	private String password;

	private ProfileEnum profile;

	public User(Long id) {
		this.id = id;
	}

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ProfileEnum getProfile() {
		return profile;
	}

	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
	}

}