package com.daw.persistence.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.daw.domain.Order;
import com.daw.persistence.entities.Pedido;

@Mapper(componentModel = "spring")
public interface OrderMapper {

	@Mappings({ @Mapping(source = "id_pedido", target = "orderId"),

			@Mapping(source = "fechaPedido", target = "orderDate"),

			@Mapping(source = "fechaEnvio", target = "shippingDate"),

			@Mapping(source = "total", target = "totalAmount"),

			@Mapping(source = "idUsuario", target = "userId"),

			@Mapping(source = "usuario", target = "user") })

	Order toOrder(Pedido pedido);

	List<Order> toOrders(List<Pedido> pedidos);

	@InheritInverseConfiguration
	@Mapping(target = "usuario", ignore = true)

	Pedido toPedido(Order order);
}