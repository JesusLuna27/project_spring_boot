package com.daw.persistence.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.daw.domain.Product;
import com.daw.persistence.entities.Producto;

@Mapper(componentModel = "spring", uses = { CategoryMapper.class })
public interface ProductMapper {

	@Mappings({ @Mapping(source = "id_producto", target = "productId"),

			@Mapping(source = "descripcion", target = "description"),

			@Mapping(source = "nombre", target = "name"),

			@Mapping(source = "precio", target = "price"),

			@Mapping(source = "stock", target = "stock"),

			@Mapping(source = "id_categoria", target = "categoryId")

	})

	Product toProduct(Producto producto);

	List<Product> toProducts(List<Producto> productos);

	@InheritInverseConfiguration
	@Mapping(target = "detallePedidos", ignore = true)

	Producto toProducto(Product product);

}
