package com.daw.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.domain.User;
import com.daw.domain.repositories.UserRepository;
import com.daw.persistence.crud.UsuarioCrudRepository;
import com.daw.persistence.entities.Usuario;
import com.daw.persistence.mappers.UserMapper;

@Repository
public class UsuarioRepository implements UserRepository {

	@Autowired
	private UsuarioCrudRepository usuarioCrudRepository;

	@Autowired
	private UserMapper userMapper;

	public List<User> getAll() {
		List<Usuario> usuarios = (List<Usuario>) usuarioCrudRepository.findAll();
		return userMapper.toUsers(usuarios);
	}

	public Optional<User> getUser(long userId) {
		Optional<Usuario> usuario = usuarioCrudRepository.findById(userId);
		return usuario.map(user -> userMapper.toUser(user));
	}

	public User save(User user) {
		Usuario usuario = userMapper.toUsuario(user);
		Usuario savedUsuario = usuarioCrudRepository.save(usuario);
		return userMapper.toUser(savedUsuario);
	}

	public void delete(long userId) {
		usuarioCrudRepository.deleteById(userId);
	}

	public Optional<Usuario> getByUsername(String username) {
		return usuarioCrudRepository.findByUsername(username);
	}
}
