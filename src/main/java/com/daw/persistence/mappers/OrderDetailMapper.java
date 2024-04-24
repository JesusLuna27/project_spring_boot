package com.daw.persistence.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.daw.domain.OrderDetail;
import com.daw.persistence.entities.DetallePedido;

@Mapper(componentModel = "spring", uses = { OrderMapper.class, ProductMapper.class })
public interface OrderDetailMapper {

	@Mappings({ @Mapping(source = "id_detalle", target = "orderDetailId"),

			@Mapping(source = "cantidad", target = "amount"),

			@Mapping(source = "precio", target = "price"),

			@Mapping(source = "idPedido", target = "idOrder"),

			@Mapping(source = "idProducto", target = "idProduct"),

			@Mapping(source = "pedido", target = "order"),

			@Mapping(source = "producto", target = "product") })

	OrderDetail toOrderDetail(DetallePedido detallePedido);

	List<OrderDetail> toOrdersDetails(List<DetallePedido> detallesPedidos);

	DetallePedido toDetallePedido(OrderDetail orderDetail);

}
