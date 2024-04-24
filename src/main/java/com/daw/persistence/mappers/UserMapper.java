package com.daw.persistence.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.daw.domain.User;
import com.daw.persistence.entities.Usuario;

@Mapper(componentModel = "spring")
public interface UserMapper {

	@Mappings({ @Mapping(source = "id_usuario", target = "userId"),

			@Mapping(source = "username", target = "username"),

			@Mapping(source = "password", target = "password"),

			@Mapping(source = "email", target = "email"),

			@Mapping(source = "locked", target = "locked"),

			@Mapping(source = "disabled", target = "disabled"),

		 })

	User toUser(Usuario usuario);

	List<User> toUsers(List<Usuario> usuarios);

	@InheritInverseConfiguration
	@Mapping(target = "pedidos", ignore = true)
	@Mapping(target = "roles", ignore = true)

	Usuario toUsuario(User user);
}
