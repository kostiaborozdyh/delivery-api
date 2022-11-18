package com.delivery.api.service.services;

import com.delivery.api.service.convertors.OrderConvertor;
import com.delivery.api.service.dto.order.OrderRequestDTO;
import com.delivery.api.service.dto.order.OrderResponseDTO;
import com.delivery.db.entities.Dates;
import com.delivery.db.entities.LocationStatus;
import com.delivery.db.entities.Order;
import com.delivery.db.entities.PaymentStatus;
import com.delivery.db.repository.OrderRepository;
import com.delivery.db.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    private final OrderConvertor orderConvertor;

    @Transactional(readOnly = true)
    public List<OrderResponseDTO> getAll() {
        List<Order> allOrders = orderRepository.findAll();
        return modelMapper.map(allOrders, new TypeToken<List<OrderResponseDTO>>() {
        }.getType());
    }

    @Transactional(rollbackFor = Exception.class)
    public Order createOrder(OrderRequestDTO orderRequestDTO) {
        Order order = orderConvertor.convertFromRequestDto(orderRequestDTO);
        order.setUser(userRepository.findById(1).orElse(null));
        return orderRepository.save(order);
    }

}
