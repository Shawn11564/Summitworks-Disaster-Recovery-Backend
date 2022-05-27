package com.summitworks.disasterrecovery.models.users;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements UserDetails {

	@Id
	@SequenceGenerator(
			name = "user_id_sequence",
			sequenceName = "user_id_sequence"
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "user_id_sequence"
	)
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	@Builder.Default
	private UserRole userRole = UserRole.CONTRACTOR;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		final SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userRole.name());
		return Collections.singletonList(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email; // actually getting the user's email
	}

	@Override
	public boolean isAccountNonExpired() {
		return true; // all accounts non-expired for our purposes
	}

	@Override
	public boolean isAccountNonLocked() {
		return false; // don't lock accounts for our purposes
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true; // don't expire for our purposes
	}

	@Override
	public boolean isEnabled() {
		return true; // all accounts enabled for our purposes
	}
}
