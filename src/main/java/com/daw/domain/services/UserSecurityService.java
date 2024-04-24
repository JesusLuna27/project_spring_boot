package com.daw.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.daw.domain.repositories.UserRepository;
import com.daw.persistence.entities.Usuario;

@Service
public class UserSecurityService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Obtener el usuario desde la bbdd
		Usuario usuario = this.userRepository.getByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no se ha encontrado"));

		// Creamos un array de string con los roles
		String roles[] = new String[usuario.getRoles().size()];

		for (int i = 0; i < roles.length; i++) {
			roles[i] = usuario.getRoles().get(i).getRole();
		}
		// Construimos el usuario
		return User.builder().username(usuario.getUsername()).password(usuario.getPassword()).roles(roles)
				.disabled(usuario.isDisabled()).accountLocked(usuario.isLocked()).build();
	}

}