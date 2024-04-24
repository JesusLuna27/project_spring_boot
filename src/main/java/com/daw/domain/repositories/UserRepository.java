package com.daw.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.daw.domain.User;
import com.daw.persistence.entities.Usuario;

public interface UserRepository {

	List<User> getAll();

	Optional<User> getUser(long userId);

	User save(User user);

	void delete(long userId);

	Optional<Usuario> getByUsername(String username);

}
