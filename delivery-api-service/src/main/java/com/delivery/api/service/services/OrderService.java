package com.delivery.api.service.services;

import com.delivery.api.service.convertors.OrderConvertor;
import com.delivery.api.service.dto.order.OrderRequestDTO;
import com.delivery.api.service.dto.order.OrderResponseDTO;
import com.delivery.db.entities.Order;
import com.delivery.db.entities.User;
import com.delivery.db.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final OrderConvertor orderConvertor;

    @Transactional(readOnly = true)
    public List<OrderResponseDTO> getAllByUser(int pageNum, int pageSize) {
        User user = userService.getCurrentUser();
        List<Order> allOrders = orderRepository.findAllByUser(user, PageRequest.of(pageNum, pageSize));
        return orderConvertor.convertToListResponseDTO(allOrders);
    }

    @Transactional(readOnly = true)
    public List<OrderResponseDTO> getAllOrders(int pageNum, int pageSize) {
        Page<Order> allOrders = orderRepository.findAll(PageRequest.of(pageNum, pageSize));
        return orderConvertor.convertToListResponseDTO(allOrders);
    }


    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
        User user = userService.getCurrentUser();
        Order order = orderConvertor.convertFromRequestDto(orderRequestDTO);

        order.setUser(user);
        order = save(order);
        return orderConvertor.convertToResponseDTO(order);
    }

    @Transactional(rollbackFor = Exception.class)
    public Order save(Order order){
        return orderRepository.save(order);
    }

}
