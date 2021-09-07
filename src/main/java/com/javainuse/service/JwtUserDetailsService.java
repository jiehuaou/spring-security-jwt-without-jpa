package com.javainuse.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	PasswordEncoder encoder;

	static final String pass = "$2a$10$vxPLMEZgFeaprgJnDdNzjerYn7s.3qr7y2CXOzUghDxBB.rnf3UMy";  // 123
	static final String raw_pass = "123";  // 123

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("load user ------> " + username);
		if ("javainuse".equals(username)) {
			List<SimpleGrantedAuthority> rights = Arrays.asList(
					new SimpleGrantedAuthority("ROLE_HELLO")
			);
			final String encodePassword = encoder.encode(raw_pass);
			System.out.println("encodePassword=" + encodePassword);
			return new User("javainuse", encodePassword, rights);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}