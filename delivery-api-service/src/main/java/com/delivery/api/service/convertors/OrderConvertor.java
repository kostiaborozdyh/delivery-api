package com.delivery.api.service.convertors;

import com.delivery.api.service.dto.description.DescriptionRequestDTO;
import com.delivery.api.service.dto.order.OrderRequestDTO;
import com.delivery.api.service.dto.order.OrderResponseDTO;
import com.delivery.db.entities.Dates;
import com.delivery.db.entities.Order;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderConvertor {
    private final ModelMapper mapper;

    public Order convertFromRequestDto(OrderRequestDTO orderRequestDTO) {
        Order order = mapper.map(orderRequestDTO, Order.class);
        Dates dates = new Dates();
        dates.setDateOfArrival(LocalDateTime.now());
        order.setDates(dates);
        DescriptionRequestDTO description = orderRequestDTO.getDescription();
        order.getDescription().setVolume(description.getHeight() * description.getLength() * description.getWidth());
        return order;
    }

    public List<OrderResponseDTO> convertToListResponseDTO(List<Order> orderList) {
        return mapper.map(orderList, new TypeToken<List<OrderResponseDTO>>() {
        }.getType());
    }

    public List<OrderResponseDTO> convertToListResponseDTO(Page<Order> orderList) {
        return mapper.map(orderList.getContent(), new TypeToken<List<OrderResponseDTO>>() {
        }.getType());
    }

    public OrderResponseDTO convertToResponseDTO(Order order) {
        return mapper.map(order, OrderResponseDTO.class);
    }
}
