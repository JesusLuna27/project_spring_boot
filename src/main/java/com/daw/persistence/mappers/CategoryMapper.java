package com.daw.persistence.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.daw.domain.Category;
import com.daw.persistence.entities.Categoria;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

	@Mappings({ @Mapping(source = "id_categoria", target = "categoryId"),

			@Mapping(source = "descripcion", target = "description"),

			@Mapping(source = "nombre", target = "name") })

	Category toCategory(Categoria categoria);

	List<Category> toCategories(List<Categoria> categorias);

	@InheritInverseConfiguration
	@Mapping(target = "productos", ignore = true)
	Categoria toCategoria(Category category);

}
