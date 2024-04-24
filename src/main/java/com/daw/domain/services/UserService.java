package com.daw.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.domain.User;
import com.daw.domain.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAll() {
		return userRepository.getAll();
	}

	public Optional<User> getUser(long userId) {
		return userRepository.getUser(userId);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public boolean delete(long userId) {
		return getUser(userId).map(user -> {
			userRepository.delete(userId);
			return true;
		}).orElse(null);

	}

}
